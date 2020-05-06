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
			// input 받기 완료.
			
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
 		int result = count + 1; // 지금까지의 카운트에 나 방문한거까지 더해서.
 		visited[x][y] = 1; // 나 방문했고.
 		
 		for(int i=0; i<4; i++) {
 			int curx = x+dx[i];
 			int cury = y+dy[i];

 			if(curx >= 0 && curx <N && cury>=0 && cury<N) { // 범위 안이고.

 				if(room[curx][cury] == room[x][y]+1 && visited[curx][cury] == 0) {
 					result = move(curx, cury, count+1);
 					//System.out.println("from "+curx+ " "+ cury+" : "+result);
 				}
 			}
 		}
 		
 		return result;
 	}
	
}

