import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice2 {

	// N*N 땅. 각 땅에는 나라가 하나씩.
	// r행 c열에는 A[r][c] 명이 살고 있음.
	// 인접한 나라 사이에는 국경선.
	
	// 국경선 공유 나라. 두 나라의 인구차이가 L명이상 R명이하라면 국경선을 하루동안 연다.
	// 다 열면 인구이동 시작.
	// 각 칸의 인구수는 연합 인구수 / 연합 이루는 칸의 개수
	// 엽합 해체하고 모든 국경선 닫음.
	
	// 더 이상 안일어날때까지 한다,
	// 몇 번 발생?
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      L = sc.nextInt();
      R = sc.nextInt();
      
      A = new int[N][N];
      for(int i=0; i<N; i++) {
    	  for(int j=0; j<N; j++) {
    		  A[i][j] = sc.nextInt();
    	  }
      }
      
      visited = new boolean[N][N];
      // 입력완료.
      
      check = true;
      while(check == true) {
    	  //System.out.println("round "+ num);
    	  // check 를 초기화
    	  check = false;
    	  // visited 를 초기화.
    	  for(int i=0; i<N; i++) {
    		  for(int j=0; j<N; j++) {
    			  visited[i][j] = false;
    		  }
    	  }
    	  
    	  for(int i=0; i<N; i++) {
    		  for(int j=0; j<N; j++) {
    			  if(visited[i][j] != true) {
    				  //System.out.println("start " + i + " " + j);
    				  current = 0;
    				  myArea = new ArrayList<Point>();
    				  search_move(i, j);
    			  }
    			  
    			  if(myArea.size() > 1) {
    				  check = true;
	    			  for(int k=0; k<myArea.size(); k++) {
	    				  int x= myArea.get(k).x;
	    				  int y = myArea.get(k).y;
	    				  A[x][y] = (int) current / myArea.size();
	    			  }
    			  }
    	    	  // 인구 이동.
    		  }
    	  }
    	  // 이동했으면 check 를 해주고.
    	  if(check == true) {
        	  num++; // 인구 이동 수 초
    	  }
      }  
      
      System.out.println(num);
   }
   
   public static boolean check = false; // 인구 이동을 한 경우.
   public static int num = 0; // 인구 이동을 몇 번 했느냐.
   public static boolean[][] visited;
   public static int N, L, R;
   public static int[][] A;
   public static int current;
   public static List<Point> myArea;
   
   public static void search_move(int x, int y) {
	   //System.out.println(x + " " + y);
	   myArea.add(new Point(x, y));
	   visited[x][y] = true;
	   current+=A[x][y]; // 내 사람 수 더하고.
	   if(x+1 < N && x+1 >= 0 && visited[x+1][y] != true) {
		   if((int)(Math.abs((double)(A[x][y] - A[x+1][y]))) >= L && (int)(Math.abs((double)(A[x][y] - A[x+1][y]))) <= R ) {
			   search_move(x+1, y);
		   }
	   }
	   if (x-1 < N && x-1 >= 0 && visited[x-1][y] != true) {
		   if((int)(Math.abs((double)(A[x][y] - A[x-1][y]))) >= L && (int)(Math.abs((double)(A[x][y] - A[x-1][y]))) <= R ) {
			   search_move(x-1, y);
		   }
	   } 
	   
	   if (y-1 < N && y-1 >= 0 && visited[x][y-1] != true) {
		   if((int)(Math.abs((double)(A[x][y] - A[x][y-1]))) >= L && (int)(Math.abs((double)(A[x][y] - A[x][y-1]))) <= R ) {
			   search_move(x, y-1);
		   }
	   }
	   
	   if (y+1 < N && y+1 >= 0 && visited[x][y+1] != true) {
		   if((int)(Math.abs((double)(A[x][y] - A[x][y+1]))) >= L && (int)(Math.abs((double)(A[x][y] - A[x][y+1]))) <= R ) {
			   search_move(x, y+1);
		   }
	   }
   }
}

class Point{
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}