package eg.edu.alexu.csd.ds.maze.cs20;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {
	BFS obj=new BFS();
	private Timer timer;
	private Map m;
	private Player p;
	public boolean win = false;
	private String Message="";
	private Font font = new Font("Serif",Font.BOLD,48);
	@SuppressWarnings("static-access")
	private int row=obj.map.length , column=obj.map[0].length ;
	
	public Board(){
		m=new Map();
		p=new Player();
		addKeyListener(new Al());
		setFocusable(true);
		timer = new Timer (25,this);
		timer.start();
	}
	
	public void actionPerformed(ActionEvent e){
		if(m.getMap(p.getTileX(), p.getTileY()).equals("E")){
			Message = "Congratulations";
			win= true;
		}
		repaint();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		if (!win) {
			for (int y = 0; y < row; y++) {
				for (int x = 0; x < column; x++) {
					if (m.getMap(x, y).equals("E")) {
						g.drawImage(m.getFinish(), x * 32, y * 32, null);
					}
					if (m.getMap(x, y).equals("S")) {
						g.drawImage(m.getGrass(), x * 32, y * 32, null);
					}
					if (m.getMap(x, y).equals(".")) {
						g.drawImage(m.getGrass(), x * 32, y * 32, null);
					}
					if (m.getMap(x, y).equals("#")) {
						g.drawImage(m.getWall(), x * 32, y * 32, null);
					}
					if (m.getMap(x, y).equals("x")) {
						g.drawImage(m.getPath(), x * 32, y * 32, null);
					}
					if (m.getMap(x, y).equals("@")) {
						g.drawImage(m.getGrass(), x * 32, y * 32, null);
					}
				}
			}
			g.drawImage(p.getPlayer(), p.getTileX()*32, p.getTileY()*32, null);
		}
		if (win) {
			g.setColor(Color.MAGENTA);
			g.setFont(font);
			g.drawString(Message, 150, 300);
		}
		
	}
	
	public class Al extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			int keycode = e.getKeyCode();
			if (keycode == KeyEvent.VK_W) {
				if (!m.getMap(p.getTileX(), p.getTileY() - 1).equals("#")) {
					p.move(0, -1);
				}
			}
			if (keycode == KeyEvent.VK_S) {
				if (!m.getMap(p.getTileX(), p.getTileY() + 1).equals("#")) {
					p.move(0, 1);
				}
			}
			if (keycode == KeyEvent.VK_A) {
				if (!m.getMap(p.getTileX() - 1, p.getTileY()).equals("#")) {
					p.move(-1, 0);
				}
			}
			if (keycode == KeyEvent.VK_D) {
				if (!m.getMap(p.getTileX() + 1, p.getTileY()).equals("#")) {
					p.move(1, 0);
				}
			}
		}
		
		public void keyRelased(KeyEvent e){
			
		}

		public void keyTyped(KeyEvent e){
	
		}
	}
}
