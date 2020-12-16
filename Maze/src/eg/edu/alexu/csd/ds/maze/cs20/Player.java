package eg.edu.alexu.csd.ds.maze.cs20;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Player {
	
	BFS obj=new BFS();
	private int tileX,tileY;
	private Image player;
	
	@SuppressWarnings("static-access")
	public Player(){
		ImageIcon img = new ImageIcon("smiley.png");
		player = img.getImage();
		tileX = obj.indexes[0][1];
		tileY = obj.indexes[0][0];
	}
	
	public Image getPlayer(){
		return player;
	}
	
	
	public int getTileX(){
		return tileX;
	}
	
	public int getTileY(){
		return tileY;
	}
	
	public void move( int dx , int dy){
		tileX += dx;
		tileY += dy;
	}
}
