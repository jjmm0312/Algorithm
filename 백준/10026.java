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
	                
	                for(int j=0; j<N; j++) {
		       			 for(int k=0; k<N; k++) {
		       				 if(visited[j][k] != true) { // 빈 사각형 하나를 찾아서.
		       					 visited[j][k] = true;
		       					 bfs_normal(j, k); // 넓이를 구하고.
		       					 count++;
		       				 }
		       			 }
		       		 }
	                System.out.print(count + " ");
		       		 
	                count = 0;
	                for(int j=0; j<N; j++) {
		       			 for(int k=0; k<N; k++) {
		       					 visited[j][k] = false; 
		       			 }
		       		 }
	                
	                for(int j=0; j<N; j++) {
		       			 for(int k=0; k<N; k++) {
		       				 if(visited[j][k] != true) { // 빈 사각형 하나를 찾아서.
		       					 visited[j][k] = true;
		       					 bfs_abnormal(j, k); // 넓이를 구하고.
		       					 count++;
		       				 }
		       			 }
		       		 }
	                System.out.println(count);
/*
	        		LinkedList<Integer> sizeArr=new LinkedList<>();
	        		// 여기에는 사각형 넓이들을 저장할거야.
	        		
	       		 
	       		 
	       		 sizeArr.sort(null);
	       		 System.out.println(sizeArr.size());
	       		 for(int j = 0; j<sizeArr.size(); j++) {
	       			 System.out.print(sizeArr.get(j)+" ");
	       		 }
	*/                
	       		 in.close();
	 }
	 
	 public static void bfs_normal(int j , int k) {
		 // 여기서 넓이를 구할거야.
		 char my = graph[j][k];
		 if(j-1>=0 && visited[j-1][k] == false) {
			if(graph[j-1][k] == my) {
				visited[j-1][k] = true;
				queue.add((j-1)+","+k);
			}
		 }
		 if(j+1<N && visited[j+1][k] == false) {
			 if(graph[j+1][k] == my) {
					visited[j+1][k] = true;
					queue.add((j+1)+","+k);
				}
		 }
		 if(k+1<N && visited[j][k+1] == false) {
			 if(graph[j][k+1] == my) {
					visited[j][k+1] = true;
					queue.add((j)+","+(k+1));
				}
		 }
		 if(k-1>=0 && visited[j][k-1] == false) {
			 if(graph[j][k-1] == my) {
					visited[j][k-1] = true;
					queue.add((j)+","+(k-1));
				}
		 }
		 
		 if(!queue.isEmpty()) {

			 String current = queue.poll();
			 String[] str = current.split(",");
			 bfs_normal(Integer.valueOf(str[0]), Integer.valueOf(str[1]));
		 }
	 }
	 
	 public static void bfs_abnormal(int j , int k) {
		 // 여기서 넓이를 구할거야.
		 char my = graph[j][k];
		 if(j-1>=0 && visited[j-1][k] == false) {
			 if(graph[j][k] == 'R' || graph[j][k] == 'G') {
				 if(graph[j-1][k] == 'R' || graph[j-1][k] == 'G' ) {
						visited[j-1][k] = true;
						queue.add((j-1)+","+k);
					}
			 }
			 else {
				 if(graph[j-1][k] == my) {
						visited[j-1][k] = true;
						queue.add((j-1)+","+k);
					}
			 }
			
		 }
		 if(j+1<N && visited[j+1][k] == false) {
			 if(graph[j][k] == 'R' || graph[j][k] == 'G') {
				 if(graph[j+1][k] == 'R' || graph[j+1][k] == 'G' ) {
						visited[j+1][k] = true;
						queue.add((j+1)+","+k);
					}
			 }
			 else {

				 if(graph[j+1][k] == my) {
						visited[j+1][k] = true;
						queue.add((j+1)+","+k);
					}
			 }
		 }
		 if(k+1<N && visited[j][k+1] == false) {
			 if(graph[j][k] == 'R' || graph[j][k] == 'G') {
				 if(graph[j][k+1] == 'R' || graph[j][k+1] == 'G' ) {
						visited[j][k+1] = true;
						queue.add((j)+","+(k+1));
					}
			 }
			 else {

				 if(graph[j][k+1] == my) {
						visited[j][k+1] = true;
						queue.add((j)+","+(k+1));
					}
			 }
		 }
		 if(k-1>=0 && visited[j][k-1] == false) {
			 if(graph[j][k] == 'R' || graph[j][k] == 'G') {
				 if(graph[j][k-1] == 'R' || graph[j][k-1] == 'G' ) {
						visited[j][k-1] = true;
						queue.add((j)+","+(k-1));
					}
			 }
			 else {

				 if(graph[j][k-1] == my) {
						visited[j][k-1] = true;
						queue.add((j)+","+(k-1));
					}
			 }
		 }
		 
		 if(!queue.isEmpty()) {

			 String current = queue.poll();
			 String[] str = current.split(",");
			 bfs_abnormal(Integer.valueOf(str[0]), Integer.valueOf(str[1]));
		 }
	 }
}