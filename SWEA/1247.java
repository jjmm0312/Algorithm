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
	public static int[][] customer; // ȸ�� + �� + �� N��.
	public static boolean[] visited; // ȸ�� + �� + �� N��.
	public static int N; // ���� ��.
	public static Point[] map;
	public static int min;
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		// ���� 2�̻� 10����
		// ���� ĭ�� ũ��� 0���� 100����.
		// ��� ���� �湮�ϰ��� �˼� ���
		// ��δ� |X1-X2| + |Y1-Y2|I
		
		for(int test_case = 0; test_case < T; test_case++)
		{				
			N = sc.nextInt();
			// ȸ�� �� ��*N �� ��ǥ x, y �������...
			customer = new int[N+2][N+2];
			visited = new boolean[N+2];
			map = new Point[N+2];
			min = Integer.MAX_VALUE;
			for(int i=0; i<N+2; i++) {
				map[i] = new Point(sc.nextInt(), sc.nextInt());
				
				}
			for(int i = 0; i<N+2; i++) {
				for(int j= 0; j<N+2; j++) {
					customer[i][j] = Math.abs(map[i].x - map[j].x) + Math.abs(map[i].y-map[j].y);
				}
			}
			// ���μ��� �ּҰŸ� �� ���ߴ�.
			checkMin(0, 0);
			
			// ���� �� �� ��θ� ����ϼ���.
			System.out.println("#" + (test_case+1) + " " + min);
		}
	}
	
	public static void checkMin(int k, int count) {
		visited[k] = true;
		int chk = 0;
		for(int i=0; i<N+2; i++) {
			if(visited[i])
				chk++;
		}
		if(chk == N+1) {
			count = count + customer[k][1]; // ���������� ������.
			if(min > count)
				min = count;
			visited[k] = false;
			return;
		}
		// �� �湮������ ��������.
		
		for(int i = 0; i<N+2; i++) {
			if(visited[i] == false && i != 1) // ���� ������.
				checkMin(i, count+customer[k][i]);
		}
		visited[k] = false;
	}

}

class Point{
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}