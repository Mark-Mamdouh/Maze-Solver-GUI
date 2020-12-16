package eg.edu.alexu.csd.ds.maze.cs20;

import java.awt.Image;
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;

public class Map {
	BFS obj=new BFS();
	private Scanner sc;
	@SuppressWarnings("static-access")
	private String Map[]=new String [obj.map.length];
	private Image grass,
				  finish,
				  wall,
				  path;
	
	public Map(){
		ImageIcon img = new ImageIcon("sand2.png");
		grass = img.getImage();
		img = new ImageIcon("wall.png");
		wall=img.getImage();
		img = new ImageIcon("finish3.png");
		finish=img.getImage();
		img = new ImageIcon("sand.png");
		path=img.getImage();
		openFile();
		readFile();
		closeFile();
	}
	
	public Image getGrass(){
		return grass;
	}
	
	public Image getWall(){
		return wall;
	}
	
	public Image getFinish(){
		return finish;
	}
	
	public Image getPath(){
		return path;
	}
	
	public String getMap(int x , int y){
		String index=Map[y].substring(x,x+1);
		return index;
	}
	
	public void openFile() {
	
		try{
			sc=new Scanner (new File("Map.txt"));
		}catch(Exception e){
			System.out.println("Error loading map");
		}
	}

	@SuppressWarnings("static-access")
	public void readFile() {
		try{
			while (sc.hasNext()) {
				for (int i = 0; i < obj.map.length; i++) {
					Map[i] = sc.next();
				}
			}
		}catch(Exception e){
			
		}
	}

	public void closeFile() {
		sc.close();
	}

}
