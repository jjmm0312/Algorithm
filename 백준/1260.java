import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EX1 {

	static int N, M;
	static int[][] graph; // 주어진 그래프
	static boolean[] visited; // 방문했나 안했나
	 public static void main(String []args){
		 			Scanner in = new Scanner(System.in);
	        
	                String line = in.nextLine();
	                String[] splitStrings = line.split(" ");

	                N = Integer.valueOf(splitStrings[0]); // 정점의 개수
	                M = Integer.valueOf(splitStrings[1]); // 간선의 개수
	                int V = Integer.valueOf(splitStrings[2]); // 시작 정점 번호
	 
	                graph = new int[N+1][N+1];
	                visited = new boolean[N+1];
	                for(int i=0; i<M; i++) {

		                line = in.nextLine();
		                splitStrings = line.split(" ");
		                
		                graph[Integer.valueOf(splitStrings[0])][Integer.valueOf(splitStrings[1])] = 1;
		                graph[Integer.valueOf(splitStrings[1])][Integer.valueOf(splitStrings[0])] = 1;
		                
	                }
	                

	                dfs(V);
	                System.out.println();
	                bfs(V);
	               
	                // 그래프 완성 완료.
	 }
	 
	 public static void dfs(int i) {
		 System.out.print(i+" ");
		 visited[i] = true;
		 
		 for(int j = 1; j<N+1; j++) {
			 if(visited[j] != true && graph[i][j] == 1) {
				 dfs(j);
			 }
		 }
	 }
	 
	 public static void bfs(int i) {
		 for(int j = 0; j<N+1; j++) {
			 visited[j] = false;
		 }
		 
		 Queue<Integer> queue = new LinkedList<Integer>();
		 queue.offer(i);
		 visited[i] = true;
		 System.out.print((i)+" ");
		 
		 while(!queue.isEmpty()) {

			 int current = queue.poll();
		 for(int j=0; j<N+1; j++) {
			 if(visited[j] != true && graph[current][j] == 1) {
			 queue.offer(j);
			 visited[j] = true;
			 System.out.print((j)+" ");
			 }
		 }

		 }
		 
	 }
}