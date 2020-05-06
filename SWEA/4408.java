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
			corridor = new boolean[200]; // 총 방수
			student = new boolean[N]; // 총 학생수
			count = 0;
			
			for(int i=0; i<N; i++) {
				room[i] = new Point(sc.nextInt()-1, sc.nextInt()-1);
			}
			
			Arrays.sort(room);
			
			// 최단 시간을 계산합니다.
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
			if(chk == N) // 학생들이 다 집으로 돌아갔습니다!
				return;
			for(int i=0; i<200; i++) {
				corridor[i] = false;
			}
			
			//----------------------------------------------------------
			
			for(int i=0; i<N; i++) {
				if(student[i] == false) {// 아직 방에 가지 못했으면. 방에 돌아갈거야...
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
						if(corridor[j] == true) { // 차있으면.
							stop = 1;
							break;
						}
					}
					// 전부다 비어있으면
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
		} // while 문의 끝임.
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