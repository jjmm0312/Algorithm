
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EX1 {

	static int[][] myMap;
	static int[][] check;
	static int M, N;
	static int result = 0;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String line = in.nextLine();
		String[] splitStrings = line.split(" ");

        M = Integer.valueOf(splitStrings[0]); // 세로줄 개수
        N = Integer.valueOf(splitStrings[1]); // 가로줄 개수
        
        myMap = new int[M][N];
        check = new int[M][N];
        
        for(int i=0; i<M; i++) {
        	for(int j=0; j<N; j++) {
        		check[i][j] = -1;
        	}
        }
        
        for(int i=0; i<M; i++) {
        	line = in.nextLine();
    		splitStrings = line.split(" ");
    		
        	for(int j=0; j<N; j++) {
        		myMap[i][j] = Integer.parseInt(splitStrings[j]);
        	}
        }
        
      
        
        System.out.println(findway(0,0));
        
  for(int i=0; i<M; i++) {
    		
        	for(int j=0; j<N; j++) {
        		System.out.print(check[i][j] + " ");
        	}
        	System.out.println();
        }
        
	}
	
	static int findway(int x, int y){

		System.out.println(" i am "+x+y);
		if(x == (M-1) && y == (N-1)){
			// 종점 도착.
			return 1;
		}
	
		if(check[x][y] == -1) { // 나는 방문한 적 없는 노드야.
			check[x][y] = 0; // 방문했다.
			
        	if((x+1)<M && myMap[x+1][y] < myMap[x][y]) {
        		check[x][y] += findway(x+1, y);
        	}
        	if(x > 0 && myMap[x-1][y] < myMap[x][y]){
        		check[x][y] += findway(x-1, y);
        	}
        	if((y+1) <N && myMap[x][y+1] < myMap[x][y]){
        		check[x][y] += findway(x, y+1);
        	}
        	if(y > 0 && myMap[x][y-1] < myMap[x][y]){
        		check[x][y] += findway(x, y-1);
        	}
        	
		}
        	
        return check[x][y];
        
        
        

	}
}