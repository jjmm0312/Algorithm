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
	public static int[][] customer; // 회사 + 집 + 고객 N명.
	public static boolean[] visited; // 회사 + 집 + 고객 N명.
	public static int N; // 고객의 수.
	public static Point[] map;
	public static int min;
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		// 고객은 2이상 10이하
		// 각각 칸의 크기는 0부터 100까지.
		// 모든 고객을 방문하고나서 죄소 경로
		// 경로는 |X1-X2| + |Y1-Y2|I
		
		for(int test_case = 0; test_case < T; test_case++)
		{				
			N = sc.nextInt();
			// 회사 집 고객*N 의 좌표 x, y 순서대로...
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
			// 서로서로 최소거리 다 구했다.
			checkMin(0, 0);
			
			// 집에 갈 때 경로를 계산하세요.
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
			count = count + customer[k][1]; // 마지막부터 집까지.
			if(min > count)
				min = count;
			visited[k] = false;
			return;
		}
		// 다 방문했으면 나가세요.
		
		for(int i = 0; i<N+2; i++) {
			if(visited[i] == false && i != 1) // 집은 가지마.
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