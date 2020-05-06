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
	public static int N;
	public static int B;
	public static int[] height;
	public static boolean[] visited;
	public static List<Integer> list;
 	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++)
		{	
			N = sc.nextInt();
			B = sc.nextInt();
			
			height = new int[N];
			visited = new boolean[N];
			list = new LinkedList<Integer>();
			for(int i=0; i<N; i++) {
				height[i] = sc.nextInt();
			}
			
			pick(0, 0);
			list.sort(null);
			
			int i = 0;
			for(i=0; i<list.size(); i++) {
				if(B <= list.get(i))
					break;
			}
			System.out.println("#"+(test_case+1)+" " + (list.get(i) - B));
		}
	}
 	
 	public static void pick(int depth, int sum) {
 		//System.out.println(sum);
 		if(sum >= B)
 		{
 			list.add(sum);
 			return;
 		}
 		
 		if(depth == height.length) {
 			if(sum >= B)
 	 		{
 	 			list.add(sum); }
 			//System.out.println(sum);
 			return;
 		}
// i�� ��������
 		
 		
 		visited[depth] = true;
 		pick(depth+1, sum+height[depth]);
 		
 		// i�� ���� �ʾ��� ���
 		visited[depth] = false;
 		pick(depth+1, sum);
 		
 	}
}

