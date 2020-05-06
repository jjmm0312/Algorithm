/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
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

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
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
// i를 골랏을경우
 		
 		
 		visited[depth] = true;
 		pick(depth+1, sum+height[depth]);
 		
 		// i를 고르지 않았을 경우
 		visited[depth] = false;
 		pick(depth+1, sum);
 		
 	}
}

