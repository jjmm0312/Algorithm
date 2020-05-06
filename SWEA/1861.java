/////////////////////////////////////////////////////////////////////////////////////////////
// �⺻ �����ڵ�� ���� �����ص� ���� �����ϴ�. ��, ����� ���� ����
// �Ʒ� ǥ�� ����� ���� �ʿ�� �����ϼ���.
// ǥ�� �Է� ����
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int ���� 1�� �Է¹޴� ����
// b = sc.nextDouble();                        // double ���� 1�� �Է¹޴� ����
// g = sc.nextByte();                          // char ���� 1�� �Է¹޴� ����
// var = sc.next();                            // ���ڿ� 1�� �Է¹޴� ����
// AB = sc.nextLong();                         // long ���� 1�� �Է¹޴� ����
/////////////////////////////////////////////////////////////////////////////////////////////
// ǥ�� ��� ����
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int ���� 1�� ����ϴ� ����
//System.out.println(b); 		       						 // double ���� 1�� ����ϴ� ����
//System.out.println(g);		       						 // char ���� 1�� ����ϴ� ����
//System.out.println(var);		       				   // ���ڿ� 1�� ����ϴ� ����
//System.out.println(AB);		       				     // long ���� 1�� ����ϴ� ����
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */

class EX1
{
	public static int[][] room;
	public static int N;
	public static int[][] result;
	public static int[][] visited;
	public static int[] dx = { -1, 1, 0, 0};
	public static int[] dy = { 0, 0, -1, 1};
 	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++)
		{				
			N = sc.nextInt();
			room = new int[N][N];
			result = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				for(int j=0; j<N; j++) {
					room[i][j] = sc.nextInt();
 				}
			}
			// input �ޱ� �Ϸ�.
			
			for(int i = 0; i<N; i++) {
				for(int j=0; j<N; j++) {
					visited = new int[N][N];
					result[i][j] = move(i, j, 0);
					//System.out.println(i+j+ ":" + room[i][j] + " "+result[i][j]);
 				}
			}
			

			int max = 0;
			int maxnum = 0;
			for(int i = 0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(max < result[i][j]) {
						max = result[i][j];
						maxnum = room[i][j];
					}else if(max == result[i][j]) {
						if(room[i][j] < maxnum) {
							maxnum = room[i][j];
						}
					}
 				}
			}
			
			System.out.println("#" + (test_case+1) + " " + maxnum + " " + max);
		}
	}
	
 	public static int move(int x, int y, int count) {
 		int result = count + 1; // ���ݱ����� ī��Ʈ�� �� �湮�Ѱű��� ���ؼ�.
 		visited[x][y] = 1; // �� �湮�߰�.
 		
 		for(int i=0; i<4; i++) {
 			int curx = x+dx[i];
 			int cury = y+dy[i];

 			if(curx >= 0 && curx <N && cury>=0 && cury<N) { // ���� ���̰�.

 				if(room[curx][cury] == room[x][y]+1 && visited[curx][cury] == 0) {
 					result = move(curx, cury, count+1);
 					//System.out.println("from "+curx+ " "+ cury+" : "+result);
 				}
 			}
 		}
 		
 		return result;
 	}
	
}

