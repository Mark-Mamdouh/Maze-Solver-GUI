package eg.edu.alexu.csd.ds.maze.cs20 ;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import eg.edu.alexu.csd.ds.maze.MyStack;

public class Game {
	@SuppressWarnings({ "static-access", "resource", "unused" })
	public static void main(String[] args) throws Exception{
		while (true){
			System.out.print("1)Game Mode\n2)DFS\n3)BFS\n4)Generate new maze");
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
		
		try {
			FileReader file = new FileReader("C:/Users/Mark Mamdouh/Downloads/Maze/maze.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("Maze is not found");
			return;
		}
		int[] currentPos=new int[2];
		int[] firstGate=new int[2];
		int[] secondGate=new int[2];
		char move;
		boolean flag=false;
		FileReader file = new FileReader("C:/Users/Mark Mamdouh/Downloads/Maze/maze.txt");
		Scanner reader = new Scanner(file);
		Scanner moveScan = new Scanner(System.in);
		 int row =reader.nextInt();
		 int col = reader.nextInt();
		 char[][] maze= new char[row][col] ;
		 String line=reader.nextLine();
		 for(int i=0;i<row;i++){
			 line=reader.nextLine();
			 for(int j=0;j<col;j++){
				 maze[i][j]=line.charAt(j);
				 if(maze[i][j]=='S'){currentPos[0]=i;currentPos[1]=j;}
				 if(maze[i][j]=='*'&&!flag){firstGate[0]=i;firstGate[1]=j;flag=true;}
				 if(maze[i][j]=='*'&&flag){secondGate[0]=i;secondGate[1]=j;}
			 }
		 }
		 int i=currentPos[0];
			int j=currentPos[1];
			
		switch(choice){
		case 1:
	while(true){
		printMaze(maze,row,col);
		flag=false;
		move=moveScan.next().charAt(0);
		switch(move){
		case 'w' :
			if(currentPos[0]==0){break;}
			if(maze[currentPos[0]-1][currentPos[1]]=='E'){flag =true;break; }
			if(currentPos[0]-1==firstGate[0]&&currentPos[1]==firstGate[1]){
				maze[currentPos[0]][currentPos[1]]='.';
				currentPos[0]=secondGate[0];
				currentPos[1]=secondGate[1];
				maze[currentPos[0]][currentPos[1]]='';
				break;
			}
			if(currentPos[0]==secondGate[0]&&currentPos[1]==secondGate[1]){
				maze[currentPos[0]][currentPos[1]]='*';
				currentPos[0]=currentPos[0]-1;
				maze[currentPos[0]][currentPos[1]]='';
				break;
			}
			if(maze[currentPos[0]-1][currentPos[1]]=='#'){break;}
			maze[currentPos[0]-1][currentPos[1]]='';
			if(currentPos[0]!=i||currentPos[1]!=j){maze[currentPos[0]][currentPos[1]]='.';}
			else{maze[currentPos[0]][currentPos[1]]='S';}
			currentPos[0]=currentPos[0]-1;
			break;
		case 's' :
			if(currentPos[0]==row-1){break;}
			if(maze[currentPos[0]+1][currentPos[1]]=='E'){flag =true;break; }
			if(currentPos[0]+1==firstGate[0]&&currentPos[1]==firstGate[1]){
				maze[currentPos[0]][currentPos[1]]='.';
				currentPos[0]=secondGate[0];
				currentPos[1]=secondGate[1];
				maze[currentPos[0]][currentPos[1]]='';
				break;
			}
			if(currentPos[0]==secondGate[0]&&currentPos[1]==secondGate[1]){
				maze[currentPos[0]][currentPos[1]]='*';
				currentPos[0]=currentPos[0]+1;
				maze[currentPos[0]][currentPos[1]]='';
				break;
			}
			if(maze[currentPos[0]+1][currentPos[1]]=='#'){break;}
			maze[currentPos[0]+1][currentPos[1]]='';
			if(currentPos[0]!=i||currentPos[1]!=j){maze[currentPos[0]][currentPos[1]]='.';}
			else{maze[currentPos[0]][currentPos[1]]='S';}
			currentPos[0]=currentPos[0]+1;
			break;
		case 'd' :
			if(currentPos[1]==col-1){break;}
			if(maze[currentPos[0]][currentPos[1]+1]=='E'){flag =true;break; }
			if(currentPos[0]==firstGate[0]&&currentPos[1]+1==firstGate[1]){
				maze[currentPos[0]][currentPos[1]]='.';
				currentPos[0]=secondGate[0];
				currentPos[1]=secondGate[1];
				maze[currentPos[0]][currentPos[1]]='';
				break;
			}
			if(currentPos[0]==secondGate[0]&&currentPos[1]==secondGate[1]){
				maze[currentPos[0]][currentPos[1]]='*';
				currentPos[1]=currentPos[1]+1;
				maze[currentPos[0]][currentPos[1]]='';
				break;
			}
			
			if(maze[currentPos[0]][currentPos[1]+1]=='#'){break;}
			maze[currentPos[0]][currentPos[1]+1]='';
			if(currentPos[0]!=i||currentPos[1]!=j){maze[currentPos[0]][currentPos[1]]='.';}
			else{maze[currentPos[0]][currentPos[1]]='S';}
			currentPos[1]=currentPos[1]+1;
			break;
		case 'a' :
			if(currentPos[1]==0){break;}
			if(maze[currentPos[0]][currentPos[1]-1]=='E'){flag =true;break; }
			if(currentPos[0]==firstGate[0]&&currentPos[1]-1==firstGate[1]){
				maze[currentPos[0]][currentPos[1]]='.';
				currentPos[0]=secondGate[0];
				currentPos[1]=secondGate[1];
				maze[currentPos[0]][currentPos[1]]='';
				break;
			}
			if(currentPos[0]==secondGate[0]&&currentPos[1]==secondGate[1]){
				maze[currentPos[0]][currentPos[1]]='*';
				currentPos[1]=currentPos[1]-1;
				maze[currentPos[0]][currentPos[1]]='';
				break;
			}
			if(maze[currentPos[0]][currentPos[1]-1]=='#'){break;}
			maze[currentPos[0]][currentPos[1]-1]='';
			if(currentPos[0]!=i||currentPos[1]!=j){maze[currentPos[0]][currentPos[1]]='.';}
			else{maze[currentPos[0]][currentPos[1]]='S';}
			currentPos[1]=currentPos[1]-1;
			break;
				
		}
		if(flag){System.out.println("\nYou are AWESOME ^-^");break;}
		
		}
		break;
		case 2:
			char[][]map = new char[row][col];
		/*	for(int ii=0;ii<row;ii++){
				for(int jj=0;jj<col;jj++){
					map[ii][jj]=maze[ii][jj];
				}
			}*/
			DFS obj = new DFS();
			MyStack stack = new MyStackClass();
			obj.DFSearch(maze, i, j, stack);
			System.out.println();
			printRoute(maze,row,col,stack);
			break;
		case 3:
			BFS bfs = new BFS();
			bfs.map=new char[row][col];
			bfs.m=new int[row][col];
			bfs.visited=new boolean[row][col];
			for(int ii=0;ii<row;ii++){
				for(int jj=0;jj<col;jj++){
					bfs.map[ii][jj]=maze[ii][jj];
					if(bfs.map[ii][jj]=='S'){
						bfs.indexes[0][0]=ii;
						bfs.indexes[0][1]=jj;
					}
					if(bfs.map[ii][jj]=='E'){
						bfs.indexes[1][0]=ii;
						bfs.indexes[1][1]=jj;
					}
				}
			}
			bfs.searchPath(bfs.map,bfs.indexes[0][0],bfs.indexes[0][1],bfs.indexes[1][0],bfs.indexes[1][1]);
			bfs.findPath(bfs.indexes[2][0],bfs.indexes[2][1]);
			bfs.printChar(bfs.map);
			bfs.initialize();
			break;
		case 4:
			System.out.print("\nLoading....");
			MapGenerator obj2 = new MapGenerator();
			maze = obj2.mapGenerator();
			try {
				File file2 = new File("C:/Users/Mark Mamdouh/Downloads/Maze/maze.txt");
	 
				// if file doesnt exists, then create it
				if (!file2.exists()) {
					file2.createNewFile();
				}
				FileWriter fw = new FileWriter(file2.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(maze.length+" "+maze[0].length+"\n");
				for(int ii=0;ii<maze.length;ii++){
					for(int jj=0;jj<maze[0].length;jj++){
						bw.write(maze[ii][jj]);
					}
					bw.write("\n");
				}
				bw.close();
				System.out.print("\nGenerated\n");
	 
	 
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("err");
			}
			break;
			} } }
	public static void printMaze (char[][] maze, int row , int col){
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				System.out.print(maze[i][j]);
		}
			System.out.print("\n");}}
	public static void printRoute(char[][] maze, int row , int col,MyStack stack){
			int[]arr = new int[2];
			int len= stack.size();
			int[][] route = new int[2][len];
			boolean flag = false ;
			for(int i =0;i<len-1;i++){
				arr=(int[])stack.pop();
				route[0][i]=arr[0];
				route[1][i]=arr[1];
			}
			maze[0][0]='S';
			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					for(int ii=0;ii<len-1;ii++){
						
					if(route[0][ii]==i&&route[1][ii]==j&&maze[i][j]!='E')
					{flag=true;break;}}
					if(flag){flag=false;System.out.print("");}
					else{System.out.print(maze[i][j]);}
				}
					System.out.print("\n");
		}
	}
	
		
	
}
