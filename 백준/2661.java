
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
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
 		N = sc.nextInt(); // N자리 정수를 구해야 합니다.
 		
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
 		
 		
 		// 1일경우
 		// 2일경우
 		// 3일경우
 	}
 	
 	public static boolean isSatisfy(String s) {
 	    int len = s.length();
 	    int loop = len / 2;
 	    int start = len - 1;
 	    int end = len;

 	    for (int i = 1; i <= loop; i++) {

 	        // i => 자릿수
 	        if (s.substring(start - i, end - i).equals(s.substring(start, end))) {
 	            return false;
 	        }
 	        // s.substring(5, 6)
 	        // s.substring(6, 7)
 	        // equal 이면 false.
 	        // 아니면 한칸 앞으로.
 	        
 	        // s.substring(3, 5)
 	        // s.substring(5, 7)
 	        start -= 1;
 	    }
 	    return true;
 	}
}
 	


