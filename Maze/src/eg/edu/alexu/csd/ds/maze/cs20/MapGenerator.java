package eg.edu.alexu.csd.ds.maze.cs20;
import java.util.Random;
public class MapGenerator {
	public char[][] mapGenerator(){
	Random random = new Random();
	int randRow=random.nextInt(20)+10;
	int randCol=random.nextInt(20)+10;
	int i = 0;
	int j =0;
	int steps =random.nextInt(20)+10;
	boolean iORj;
	int incORdec;
	char[][]map = new char[randRow][randCol];
	map[i][j]='S';
	while(steps!=0){
		iORj=random.nextBoolean();
		incORdec=random.nextInt(4);
		if(iORj&&(incORdec>0)&&i!=randRow-1&&map[i+1][j]!='S'&&map[i+1][j]!='.'){
			i++;map[i][j]='.';
			if(steps==1){map[i][j]='E';}}
		else if(!iORj&&(incORdec>0)&&j!=randCol-1&&map[i][j+1]!='S'&&map[i][j+1]!='.'){
			j++;map[i][j]='.';
			if(steps==1){map[i][j]='E';}}
		else if(iORj&&(incORdec==0)&&i!=0&&map[i-1][j]!='S'&&map[i-1][j]!='.'){
			i--;map[i][j]='.';
			if(steps==1){map[i][j]='E';}}
		else if(!iORj&&(incORdec==0)&&j!=0&&map[i][j-1]!='S'&&map[i][j-1]!='.'){
			j--;map[i][j]='.';
			if(steps==1){map[i][j]='E';}}
		else{continue;}
		steps--;
	}
	for(int ii=0;ii<randRow;ii++){
		for(int jj=0;jj<randCol;jj++){
			iORj=random.nextBoolean();
			if(map[ii][jj]!='S'&&map[ii][jj]!='.'&&map[ii][jj]!='E'){
				if(iORj){map[ii][jj]='#';}
				else{map[ii][jj]='.';}
			}
		}
	
	}
	return map;
	
	}

}
