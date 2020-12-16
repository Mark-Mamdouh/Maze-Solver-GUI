package eg.edu.alexu.csd.ds.maze.cs20;

import eg.edu.alexu.csd.ds.maze.MyStack;

public class DFS {
	MyStack stack = new MyStackClass();
	boolean flag=false;
	Game obj =new Game();
	int[] arr=new int[2];
	int count=0;
	public void DFSearch(char[][] maze, int i,int j,MyStack stack){
		arr[0]=i;arr[1]=j;
		stack.push(arr);count++;
		arr=new int[2];
		if(maze[i][j]=='E'){flag=true;return;}
		maze[i][j]='x';//visited
		//obj.printMaze(maze, maze.length, maze[i].length);
		if(flag){return;}
		if(hasLeft(maze,i,j)){DFSearch(maze,i,j-1,stack);}
		if(flag){return;}
		if(hasDown(maze,i,j)){DFSearch(maze,i+1,j,stack);}
		if(flag){return;}
		if(hasUp(maze,i,j)){DFSearch(maze,i-1,j,stack);}
		if(flag){return;}
		if(hasRight(maze,i,j)){DFSearch(maze,i,j+1,stack);}
		if(flag){return;}
		stack.pop();count--;
		return ;
		
		//char[][]map=maze;//copying it 
		
		
	}
	private boolean hasLeft(char[][]maze ,int i,int j){
		if(j==0||maze[i][j-1]=='#'||maze[i][j-1]=='x'){return false;}
		return true;
	}
	private boolean hasRight(char[][]maze ,int i,int j){
		if(j==maze[i].length-1||maze[i][j+1]=='#'||maze[i][j+1]=='x'){return false;}
		return true;
	}
	private boolean hasUp(char[][]maze ,int i,int j){
		if(i==0||maze[i-1][j]=='#'||maze[i-1][j]=='x'){return false;}
		return true;
	}
	private boolean hasDown(char[][]maze ,int i,int j){
		if(i==maze.length-1||maze[i+1][j]=='#'||maze[i+1][j]=='x'){return false;}
		return true;
	}
}
