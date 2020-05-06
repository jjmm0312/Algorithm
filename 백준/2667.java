import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EX1 {

	static int N, M;
	static char[][] graph; // 주어진 그래프
	static boolean[][] visited; // 방문했나 안했나
	static int count = 0;
	static Queue<String> queue = new LinkedList<String>();
	
	 public static void main(String []args){
		 			Scanner in = new Scanner(System.in);
		 			
		 			N = Integer.valueOf(in.nextLine());
		 	        //in.next();
	             
	                graph = new char[N][N];
	                visited = new boolean[N][N];
	                
	                for(int j=0; j<N; j++) {
		       			 for(int k=0; k<N; k++) {
		       					 visited[j][k] = false; 
		       			 }
		       		 }
	             
	                for(int i=0; i<N; i++) {

	                	String line = in.nextLine();
	                	for(int j=0; j<N; j++) {
	                		graph[i][j] = line.charAt(j);
	                	}
	                }
	                
	                // input finish.
	                
	                

	        		LinkedList<Integer> sizeArr=new LinkedList<>();
	        		// 여기에는 단지안의 집 수를 저장할거야.
	        	
	                ////////////////////////
	                // 여기에 이제 단지수 계산하는 dfs를 넣어야함.
	                for(int j=0; j<N; j++) {
		       			 for(int k=0; k<N; k++) {
		       				 if(visited[j][k] != true && graph[j][k] == '1') { // 빈 사각형 하나를 찾아서.
		       					 count = 1;
		       					 dfs(j, k); // 넓이를 구하고.
		       					 sizeArr.add(count); // 넓이를 링크드리스트에 추가.
		       				 }
		       			 }
		       		 }
	       		 sizeArr.sort(null);
	       		 System.out.println(sizeArr.size());
	       		 for(int j = 0; j<sizeArr.size(); j++) {
	       			 System.out.print(sizeArr.get(j)+" ");
	       		 }
	              
	       		 in.close();
	 }
	 
	 public static void dfs(int j , int k) {
		 // 여기서 넓이를 구할거야.

		 visited[j][k] = true;
		 if(j-1>=0 && visited[j-1][k] == false && graph[j-1][k] == '1') {
				dfs(j-1,k);
				count++;
			 }
			 if(j+1<N && visited[j+1][k] == false&& graph[j+1][k] == '1') {
					dfs(j+1,k);
					count++;
			 }
			 if(k+1<N && visited[j][k+1] == false&& graph[j][k+1] == '1') {
dfs(j,k+1);
count++;
			 }
			 if(k-1>=0 && visited[j][k-1] == false&& graph[j][k-1] == '1') {
					dfs(j, k-1);
					count++;
			 }
			 
	 }
}