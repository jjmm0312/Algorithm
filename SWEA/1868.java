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
import java.util.Arrays;
import java.util.LinkedList;
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
{static int num;
static int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
static int dy[] = { 0, 1, -1, -1, 1, -1, 0, 1 };
static int map[][];
static boolean check[][];

static void solution(int x,int y) {
    check[x][y]=true;
    for(int i=0;i<8;i++) {
        // 주변 칸이 방문하지 않은 0일 경우 해당 칸에 solution 실행 
        if(map[x+dx[i]][y+dy[i]]==0&&!check[x+dx[i]][y+dy[i]]) {
            solution(x+dx[i],y+dy[i]);
        }
        // 0의 주변 칸이 숫자일 경우 방문 처리
        else if(map[x+dx[i]][y+dy[i]]!=-1&&map[x+dx[i]][y+dy[i]]!=99&&!check[x+dx[i]][y+dy[i]]) {
            check[x+dx[i]][y+dy[i]]=true;
        }
    }
}

public static void main(String[] args) throws Exception{		
	System.setIn(new FileInputStream("input (4).txt"));
    Scanner scan = new Scanner(System.in);
    int T = scan.nextInt();
    for (int test_case = 1; test_case <= T; test_case++) {
        num = 0;
        int N = scan.nextInt();
        map = new int[N + 2][N + 2];
        check = new boolean[N + 2][N + 2];
        
        //////////////////// 1 입력받기 ///////////////////////////
        for (int i = 0; i <= N + 1; i++) {
            String str="";
            if(i!=0&&i!=N+1) {
                str=scan.next();
            }
            for (int j = 0; j <= N + 1; j++) {
                if (i == 0 || i == N + 1 || j == 0 || j == N + 1) {
                    map[i][j] = -1; // 맵 바깥
                } else {
                    if(str.charAt(j-1)=='.') {
                        map[i][j]=1;
                    }else {
                        map[i][j]=99; // 지뢰
                    }
                }
            }
        }
        //////////////////// 2 주변 지뢰 개수 세기 ///////////////////////////
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(map[i][j]==1) {
                    int count=0;
                    for(int k=0;k<8;k++) {
                        if(map[i+dx[k]][j+dy[k]]==99) {
                            count++;
                        }
                    }
                    map[i][j]=count;
                }
            }
        }
        //////////////////// 3 0들 먼저 처리하기 ///////////////////////////
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(map[i][j]==0&&!check[i][j]) {
                    solution(i,j);
                    num++;
                }
            }
        }
        //////////////////// 4 남아있는 숫자들 처리하기 ///////////////////////////
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(map[i][j]!=0&&map[i][j]!=-1&&map[i][j]!=99&&!check[i][j]) {
                    num++;
                }
            }
        }
        System.out.printf("#%d %d\n",test_case,num);
    }
}}