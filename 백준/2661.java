
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

class EX1
{
	public static int N;
	public static int min = Integer.MAX_VALUE;
 	public static void main(String args[]) throws Exception
	{
 		Scanner sc = new Scanner(System.in);
 		N = sc.nextInt(); // N�ڸ� ������ ���ؾ� �մϴ�.
 		
 		make("1");
	}
 	
 	public static boolean stop = false;
 	public static void make(String s) {
 		if(stop)
 			return;
 		
 		if(s.length() == N) {
 			System.out.println(s);
 			stop = true;
 			return;
 		}
 		
 		if(isSatisfy(s+"1"))
 	 		make(s+"1");
 		if(isSatisfy(s+"2"))
 	 		make(s+"2");
 		if(isSatisfy(s+"3"))

 	 		make(s+"3");
 		
 		
 		// 1�ϰ��
 		// 2�ϰ��
 		// 3�ϰ��
 	}
 	
 	public static boolean isSatisfy(String s) {
 	    int len = s.length();
 	    int loop = len / 2;
 	    int start = len - 1;
 	    int end = len;

 	    for (int i = 1; i <= loop; i++) {

 	        // i => �ڸ���
 	        if (s.substring(start - i, end - i).equals(s.substring(start, end))) {
 	            return false;
 	        }
 	        // s.substring(5, 6)
 	        // s.substring(6, 7)
 	        // equal �̸� false.
 	        // �ƴϸ� ��ĭ ������.
 	        
 	        // s.substring(3, 5)
 	        // s.substring(5, 7)
 	        start -= 1;
 	    }
 	    return true;
 	}
}
 	


