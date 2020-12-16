package eg.edu.alexu.csd.ds.maze.cs20;



import org.junit.Test;

public class test {

	@SuppressWarnings("unused")
	@Test
	public static void main(String[] args) {
		
		BFS bfs = new BFS();
		MapGenerator obj= new MapGenerator();
		Game obj2= new Game();
		char[][]maze = obj.mapGenerator();
		bfs.map = maze;
		Board b = new Board();
		for(int i=0;i<maze.length;i++){
			for(int j=0;j<maze[0].length;j++){
				System.out.print(maze[i][j]);
			}
			System.out.print("\n");
		}
		
	}
	
	
	/*public void test2() {
		BFS bfs = new BFS();
		map = new char[row][col];
		bfs.map=new char[row][col];
		bfs.m=new int[row][col];
		bfs.visited=new boolean[row][col];
		for(int ii=0;ii<row;ii++){
			for(int jj=0;jj<col;jj++){
				bfs.map[ii][jj]=maze[ii][jj];
			}
		}
		bfs.searchPath(bfs.map,bfs.indexes[0][0],bfs.indexes[0][1],bfs.indexes[1][0],bfs.indexes[1][1]);
		bfs.findPath(bfs.indexes[2][0],bfs.indexes[2][1]);
		bfs.printChar(bfs.map);
		}*/
	}

