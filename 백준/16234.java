import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice2 {

	// N*N ��. �� ������ ���� �ϳ���.
	// r�� c������ A[r][c] ���� ��� ����.
	// ������ ���� ���̿��� ���漱.
	
	// ���漱 ���� ����. �� ������ �α����̰� L���̻� R�����϶�� ���漱�� �Ϸ絿�� ����.
	// �� ���� �α��̵� ����.
	// �� ĭ�� �α����� ���� �α��� / ���� �̷�� ĭ�� ����
	// ���� ��ü�ϰ� ��� ���漱 ����.
	
	// �� �̻� ���Ͼ������ �Ѵ�,
	// �� �� �߻�?
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
      // �Է¿Ϸ�.
      
      check = true;
      while(check == true) {
    	  //System.out.println("round "+ num);
    	  // check �� �ʱ�ȭ
    	  check = false;
    	  // visited �� �ʱ�ȭ.
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
    	    	  // �α� �̵�.
    		  }
    	  }
    	  // �̵������� check �� ���ְ�.
    	  if(check == true) {
        	  num++; // �α� �̵� �� ��
    	  }
      }  
      
      System.out.println(num);
   }
   
   public static boolean check = false; // �α� �̵��� �� ���.
   public static int num = 0; // �α� �̵��� �� �� �ߴ���.
   public static boolean[][] visited;
   public static int N, L, R;
   public static int[][] A;
   public static int current;
   public static List<Point> myArea;
   
   public static void search_move(int x, int y) {
	   //System.out.println(x + " " + y);
	   myArea.add(new Point(x, y));
	   visited[x][y] = true;
	   current+=A[x][y]; // �� ��� �� ���ϰ�.
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