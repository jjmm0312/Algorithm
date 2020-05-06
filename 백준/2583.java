import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EX1 {

	static int N, M;
	static boolean[][] graph; // 주어진 그래프
	static boolean[][] visited; // 방문했나 안했나
	static int count = 0;
	static Queue<String> queue = new LinkedList<String>();
	 public static void main(String []args){
		 			Scanner in = new Scanner(System.in);
	        
	                String line = in.nextLine();
	                String[] splitStrings = line.split(" ");

	                M = Integer.valueOf(splitStrings[0]); // 세로줄 개수
	                N = Integer.valueOf(splitStrings[1]); // 가로줄 개수
	                int V = Integer.valueOf(splitStrings[2]); // 사각형 개수
	 
	                visited = new boolean[M][N];
	             
	                for(int i=0; i<V; i++) {
	                	line = in.nextLine();
		                String[] ss = line.split(" ");
	                	int x1 = Integer.valueOf(ss[0]);
	                	int y1 = Integer.valueOf(ss[1]);
	                	int x2 = Integer.valueOf(ss[2]);
	                	int y2 = Integer.valueOf(ss[3]);
	                	
	                	for(int j=x1; j<x2; j++) {
	                		for(int k=y1; k<y2; k++) {
	                			visited[k][j] = true;
	                		}
	                	}
	                }
	                
	                // 사각형 그리기 완료.
		       		 

	        		LinkedList<Integer> sizeArr=new LinkedList<>();
	        		// 여기에는 사각형 넓이들을 저장할거야.
	        		
	       		 for(int j=0; j<M; j++) {
	       			 for(int k=0; k<N; k++) {
	       				 if(visited[j][k] != true) { // 빈 사각형 하나를 찾아서.
	       					 count = 1;
	       					 visited[j][k] = true;
	       					 bfs(j, k); // 넓이를 구하고.
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
	 
	 public static void bfs(int j , int k) {
		 // 여기서 넓이를 구할거야.
		 
		 if(j-1>=0 && visited[j-1][k] == false) {
			visited[j-1][k] = true;
			queue.add((j-1)+","+k);
		 }
		 if(j+1<M && visited[j+1][k] == false) {
				visited[j+1][k] = true;
				queue.add((j+1)+","+k);
		 }
		 if(k+1<N && visited[j][k+1] == false) {
				visited[j][k+1] = true;
				queue.add((j)+","+(k+1));
		 }
		 if(k-1>=0 && visited[j][k-1] == false) {
				visited[j][k-1] = true;
				queue.add((j)+","+(k-1));
		 }
		 
		 if(!queue.isEmpty()) {

			 String current = queue.poll();
			 count++;
			 String[] str = current.split(",");
			 bfs(Integer.valueOf(str[0]), Integer.valueOf(str[1]));
		 }
	 }
}