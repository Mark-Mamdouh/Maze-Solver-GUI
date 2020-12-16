package eg.edu.alexu.csd.ds.maze.cs20;

public class BFS {
	static QueueUsingLinkedLists queue= new QueueUsingLinkedLists();
	static char[][] map;
	static int [][] m;
	static boolean[][] visited;
	static int indexes[][]=new int [3][2];
	static int[] node=new int[2];
	static boolean flag=false;
	
	public static void searchPath( char[][] map , int x1 , int y1 , int x2 , int y2 ){
		visited[indexes[0][0]][indexes[0][1]]=true;
		m[indexes[0][0]][indexes[0][1]]=0;
		if(x1==x2 && y1==y2){
			return;
		}
		if(map[x1][y1]=='E'){
			flag=true;
		}
		if(flag){
			return;
		}
		if(y1-1>=0 && y1-1<map[0].length && (map[x1][y1-1]=='.' || map[x1][y1-1]=='E') && visited[x1][y1-1]==false && !flag){
			visited[x1][y1-1]=true;
			if(map[x1][y1-1]=='E'){
				indexes[2][0]=x1;
				indexes[2][1]=y1;
				m[x1][y1-1]=-1;
				flag=true;
				return;
			}
			node=new int[2];
			node[0]=x1;
			node[1]=y1-1;
			queue.enqueue(node);
			map[x1][y1-1]='@';
			//printChar(map);
			m[x1][y1-1]=m[x1][y1]+1;
		}
		if(x1+1>=0 && x1+1<map.length && (map[x1+1][y1]=='.' || map[x1+1][y1]=='E') && visited[x1+1][y1]==false && !flag){
			visited[x1+1][y1]=true;
			if(map[x1+1][y1]=='E'){
				indexes[2][0]=x1;
				indexes[2][1]=y1;
				m[x1+1][y1]=-1;
				flag=true;
				return;
			}
			node=new int[2];
			node[0]=x1+1;
			node[1]=y1;
			queue.enqueue(node);
			map[x1+1][y1]='@';
			//printChar(map);
			m[x1+1][y1]=m[x1][y1]+1;
		}
		if(y1+1>=0 && y1+1<map[0].length && (map[x1][y1+1]=='.' || map[x1][y1+1]=='E') && visited[x1][y1+1]==false && !flag){
			visited[x1][y1+1]=true;
			if(map[x1][y1+1]=='E'){
				indexes[2][0]=x1;
				indexes[2][1]=y1;
				m[x1][y1+1]=-1;
				flag=true;
				return;
			}
			node=new int[2];
			node[0]=x1;
			node[1]=y1+1;
			queue.enqueue(node);
			map[x1][y1+1]='@';
			//printChar(map);
			m[x1][y1+1]=m[x1][y1]+1;
		}
		if(x1-1>=0 && x1-1<map.length && (map[x1-1][y1]=='.' || map[x1-1][y1]=='E') && visited[x1-1][y1]==false && !flag){
			visited[x1-1][y1]=true;
			if(map[x1-1][y1]=='E'){
				indexes[2][0]=x1;
				indexes[2][1]=y1;
				m[x1-1][y1]=-1;
				flag=true;
				return;
			}
			node=new int[2];
			node[0]=x1-1;
			node[1]=y1;
			queue.enqueue(node);
			map[x1-1][y1]='@';
			//printChar(map);
			m[x1-1][y1]=m[x1][y1]+1;
		}
		int[] temp = null;
		try{
			temp=(int[]) queue.dequeue();
			searchPath(map,temp[0],temp[1],x2,y2);
		}catch(Exception e){
			
		}
	}
	
	public static void findPath(int x, int y) {
		map[indexes[2][0]][indexes[2][1]] = 'x';
		if (indexes[0][0] > indexes[1][0]) {
			if (y+1<m[0].length&&y+1>=0&&m[x][y + 1] == m[x][y] - 1&&map[x][y+1]=='@') {
				map[x][y + 1] = 'x';
				 
				findPath(x, y + 1);
			}
			else if (y-1>=0&&m[x][y - 1] == m[x][y] - 1&&map[x][y-1]=='@') {
				map[x][y - 1] = 'x';
				 
				findPath(x, y - 1);
			}
			else 
				if (x+1<m.length && x+1>=0&&m[x + 1][y] == m[x][y] - 1&&map[x+1][y]=='@') {
				map[x + 1][y] = 'x';
				 
				findPath(x + 1, y);
			}
			else if (x-1>=0&&m[x - 1][y] == m[x][y] - 1&&map[x-1][y]=='@') {
				map[x - 1][y] = 'x';
				 
				findPath(x - 1, y);
			}
		}else if (indexes[0][0] < indexes[1][0]) {
			if (y+1<m[0].length&&y+1>=0&&m[x][y + 1] == m[x][y] - 1&&map[x][y+1]=='@') {
				map[x][y + 1] = 'x';
				 
				findPath(x, y + 1);
			}
			else if (y-1>=0&&m[x][y - 1] == m[x][y] - 1&&map[x][y-1]=='@') {
				map[x][y - 1] = 'x';
				 
				findPath(x, y - 1);
			} 
			else if (x-1>=0&&m[x - 1][y] == m[x][y] - 1&&map[x-1][y]=='@') {
				map[x - 1][y] = 'x';
				 
				findPath(x - 1, y);
			} 
			else if (x+1<m.length&&x+1>=0&&m[x + 1][y] == m[x][y] - 1&&map[x+1][y]=='@') {
				map[x + 1][y] = 'x';
				 
				findPath(x + 1, y);
			} 
		} else if (indexes[0][0] == indexes[1][0]) {
			if (x-1>=0&&m[x - 1][y] == m[x][y] - 1&&map[x-1][y]=='@') {
				map[x - 1][y] = 'x';
				findPath(x - 1, y);
			} else if (x+1<m.length&&x+1>=0&&m[x + 1][y] == m[x][y] - 1&&map[x+1][y]=='@') {
				map[x + 1][y] = 'x';
				findPath(x + 1, y);
			} else if (y+1<m[0].length&&y+1>=0&&m[x][y + 1] == m[x][y] - 1&&map[x][y+1]=='@') {
				map[x][y + 1] = 'x';
				findPath(x, y + 1);
			} else if (y-1>=0&&m[x][y - 1] == m[x][y] - 1&&map[x][y-1]=='@') {
				map[x][y - 1] = 'x';
				findPath(x, y - 1);
			}
		}
	}
	
	public static void printChar(char[][] map){
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[0].length;j++){
				System.out.print(map[i][j]);
			}
			System.out.printf("\n");
		}
		System.out.printf("\n");
	}
	
	public static void initialize(){
		flag=false;
		indexes=new int[3][2];
		node=new int[2];
		queue= new QueueUsingLinkedLists();
	}
	
	public static void printInt(int[][] m2){
		for(int i=0;i<m2.length;i++){
			for(int j=0;j<m2[0].length;j++){
				System.out.print(m2[i][j]+" ");
			}
			System.out.printf("\n");
		}
		System.out.printf("\n");
	}
}