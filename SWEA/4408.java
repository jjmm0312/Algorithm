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
	public static Point[] room;
	public static boolean[] corridor;
	public static boolean[] student;
	public static int count;
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++)
		{				
			N = sc.nextInt();
			room = new Point[N]; 
			corridor = new boolean[200]; // �� ���
			student = new boolean[N]; // �� �л���
			count = 0;
			
			for(int i=0; i<N; i++) {
				room[i] = new Point(sc.nextInt()-1, sc.nextInt()-1);
			}
			
			Arrays.sort(room);
			
			// �ִ� �ð��� ����մϴ�.
			checkTime();
			
			System.out.println("#" + (test_case+1) + " " + count);
		}
	}
	
	public static void checkTime() {
		int chk = 0;
		while(true) {
			chk = 0;
			for(int i=0; i<N; i++) {
				if(student[i] == true)
					chk++;
			}
			//System.out.println();
			if(chk == N) // �л����� �� ������ ���ư����ϴ�!
				return;
			for(int i=0; i<200; i++) {
				corridor[i] = false;
			}
			
			//----------------------------------------------------------
			
			for(int i=0; i<N; i++) {
				if(student[i] == false) {// ���� �濡 ���� ��������. �濡 ���ư��ž�...
					int stop = 0;
					int first = 0;
					int last = 0;
				
					if(room[i].des > room[i].cur) {
						first = room[i].cur;
						last = room[i].des;
					}else {
						last = room[i].cur;
						first = room[i].des;
					}
					
					for(int j = first/2; j<=last/2; j++) {
						if(corridor[j] == true) { // ��������.
							stop = 1;
							break;
						}
					}
					// ���δ� ���������
					if(stop == 0)
					{
						for(int j = first/2; j<=last/2; j++) {
							corridor[j] = true;
						}
						student[i] = true;
						//System.out.println("##" + i + "clear");
					}
				}
			}
			count++;
		} // while ���� ����.
	}
}

class Point implements Comparable<Point>{
	int cur, des, first;
	public Point(int cur, int des) {
		this.cur = cur;
		this.des = des;
		this.first = (cur > des) ? des : cur ;
	}
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		if(this.first > o.first) {
			return 1;
		}
		else if(this.first < o.first){
			return -1;
		}
		else
			return 0;
	}
	
}