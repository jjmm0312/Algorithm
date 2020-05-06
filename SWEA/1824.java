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
	// 프로그램이 정지하면 YES 아니면 NO 를 출력하시오.
	// 혁셈블리어 메모리는 단 하나. 0-15 사이의 정수를 저장. 초기값은 0.
	static int mem = 0;
    static int dx[] = { 1, -1, 0, 0 };
    static int dy[] = { 0, 0, 1, -1 };
	public static char[][] command; // 명령어를 나타낸다.
	public static boolean[][][][] check; // 방문햇는지 안햇는지를 나타내는 체크맵입니다.
	public static int yes = 0;
	public static int exit = 0;
	public static int R = 0, C = 0;
	
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

		for(int test_case = 0; test_case < T; test_case++)
		{	
			R = sc.nextInt(); 
			C = sc.nextInt(); // 나는 R행 c열
			command = new char[R][C];
			check = new boolean[21][21][16][5];
			mem = 0;
			yes = 0;
			exit = 0;
			int terminal = 0;
			for(int i=0; i<R; i++) {
				String str = sc.next();
				char[] arr = str.toCharArray();
				for(int j=0; j<C; j++) {
					command[i][j] = arr[j];
					if(command[i][j] == '@') {
						terminal = 1;
					}
				}
			}
			
			
			// input 받기 완료햇습니당.
			if(terminal == 0)
				System.out.println("#" + (test_case+1) + " " + "NO");
			else {
				compiler(0, 0, 3);
				if(yes == 1)
					System.out.println("#" + (test_case+1) + " " + "YES");
				else
					System.out.println("#" + (test_case+1) + " " + "NO");
					
			}
		}
	}
	
	public static void compiler(int i, int j,int direction) {
		// R행 C열의 command 중에서. [i][j] 칸에 들어왔습니다. 
		// direction은 상하좌우 0123.
		// 명령을 처리하고 다음문자로 이동하세요.
		//System.out.println(i+ " " + j + " " + check[i][j][mem][direction]);
			if(exit == 1)
				return;
			// 명령을 처리합니다.
			if(command[i][j] == '<') {
				// 이동방향을 왼쪽으로 바꾼다.
				direction = 2;
			}else if(command[i][j] == '>') {
				// 이동방향을 오른쪽으로 바꾼다.
				direction = 3;
			}else if(command[i][j] == '^') {
				// 이동방향을 위쪽으로 바꾼다.
				direction = 0;
			}else if(command[i][j] == 'v') {
				// 이동방향을 아래쪽으로 바꾼다.
				direction = 1;
			}else if(command[i][j] == '_') {
				// 메모리 0이면, 이동방향 오른쪽. 아니면 왼쪽으로 바꾼다.
				if(mem == 0)
					direction = 3;
				else
					direction = 2;
			}else if(command[i][j] == '|') {
				// 메모리 0이면 이동방향 아래로. 아니면 위로 바꾼다.
				if(mem == 0)
					direction = 1;
				else
					direction = 0;
			}else if(command[i][j] == '?') {
				// 이동방향을 상하좌우 중 하나로 무작위로 바꾼다. 방향이 바뀔 확률은 네방향 동일.
				direction = 4;
			}else if(command[i][j] == '.') {
				// 아무것도 하지않는다.
			}else if(command[i][j] == '@') {
				// 프로그램 정지한다.
				exit = 1;
				yes = 1;
				return;
			}else if(command[i][j] >= '0' && command[i][j] <='9') { // 0 - 9
				// 메모리에 숫자 저장
				mem = Integer.valueOf(command[i][j] - '0');
			}else if(command[i][j] == '+') {
				// 메모리에 더하기 1. 15면 0으로
				mem += 1;
				if(mem == 16)
					mem = 0;
			}else if(command[i][j] == '-') {
				// 메모리에 빼기 1. 0이면 15로
				mem -= 1;
				if(mem == -1)
					mem = 15;
			}
			
			if(check[i][j][mem][direction] == true)
				{
				exit = 1;
				return;
				}
			else
				check[i][j][mem][direction] = true;
			
			// 좌표를 다음 좌표로 이동할거예요.
			// 이동해야할 좌표를 구해보자.
			List<Point> list = next(i,j,direction);
			// 여기에 이동해야할 좌표들이 저장되어 있음.
			/*
			for(int k=0; k<list.size(); k++) {
				if(yes==0)exit=0;
				compiler(list.get(k).x, list.get(k).y,list.get(k).location);
			}
			*/
			for(Point p : list) {
	            // 이동할 때마다 exit = false 로 변경해줘야 함.
	            // 상, 하, 좌, 우 모두 이동해서 확인해줘야함.!
	            if(yes == 0) exit = 0;
	            compiler(p.x,p.y,p.location);
	            
	        }

		return;
		}
	
	public static List<Point> next(int x, int y, int direction){
	
		List<Point> list = new ArrayList<>();
		switch(direction) {
	 case 4: 
         // case 0,1,2,3  모두 실행하면서 
         // 상, 하, 좌, 우 모두 검사하기.

     case 3: // 오른쪽
         Point temp0 = new Point(x, y,0);
         temp0.y = y + 1 >= C ? 0: y + 1;
         temp0.location = 3;
         list.add(temp0);
         
         if(direction!=4) break;
     case 2: // 왼쪽
         Point temp1 = new Point(x, y,0);
         temp1.y = y - 1 < 0 ? C-1: y - 1;
         temp1.location = 2;
         list.add(temp1);
         if(direction!=4) break;
     case 1: // 아래쪽
         Point temp2 = new Point(x, y,0);
         temp2.x = x + 1 >= R ? 0 : x + 1;
         temp2.location = 1;
         list.add(temp2);
         if(direction!=4) break;
     case 0: // 위쪽
         Point temp3 = new Point(x, y,0);
         temp3.x = x - 1 < 0 ? R -1: x - 1;
         temp3.location = 0;
         list.add(temp3);
         if(direction!=4) break;
     }


		return list;
	}
	
	 

}
	
class Point{
    int x;
    int y;
    int location;
    
    public Point(int x, int y, int location) {
        this.x = x;
        this.y = y;
        this.location = location;
    }
}

			
	
