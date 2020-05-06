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
import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Pos{
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	int x, y;
}

class EX1
{

    static int dx[] = { 1, -1, 0, 0 };
    static int dy[] = { 0, 0, 1, -1 };
	public static int[][] map; // 도로를 나타낸 지도입니다.
	public static int[][] check;
	public static final int INF = Integer.MAX_VALUE;
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		System.setIn(new FileInputStream("input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		// 점수는 0점부터 10점까지 있고
		// 11 가지의 경우. 점수는 1 이상 100이하의 자연수이다.
		// 0 1 2 3 4 5 6 7 8 9 10
		for(int test_case = 0; test_case < T; test_case++)
		{
			
			int N = sc.nextInt(); // 지도 크기. N*N
			map = new int[N][N]; // 도로를 나타낸 지도입니다.
			check = new int[N][N]; // 최단경로를 나타낸 지도입니다.
			
			for(int i=0; i<N; i++) {
				String str = sc.next();
				String[] arr = str.split("");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.valueOf(arr[j]) - Integer.valueOf("0");
					check[i][j] = INF;
				}
			}
			// 드디어 인풋받기 끝... ㅜㅜ
			
			Queue<Pos> q = new LinkedList<>();
			q.add(new Pos(0,0)); // 시작점을 넣고
			check[0][0] = map[0][0]; // 첫번째 최단 경로를 넣고.
			while(!q.isEmpty()) { // 큐가 들어있을 떄 까지 할거야.
				Pos cur = q.poll(); // 현재 자리는 큐에서 하나 꺼내고.
				for(int i=0; i<4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					if(nx >= N || ny >= N || nx < 0 || ny < 0) {
						continue; // 좌표가 범위 밖이면 넘어가고.
					}
					
					if((check[nx][ny] > check[cur.x][cur.y] + map[nx][ny])) {
						check[nx][ny] = check[cur.x][cur.y] + map[nx][ny];
						q.add(new Pos(nx, ny));
					}
				}
			}
			

			System.out.println("#" + (test_case+1) + " " + check[N-1][N-1]);
		}
	}
	


	
}