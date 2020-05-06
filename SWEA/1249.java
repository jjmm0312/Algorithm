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
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
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
	public static int[][] map; // ���θ� ��Ÿ�� �����Դϴ�.
	public static int[][] check;
	public static final int INF = Integer.MAX_VALUE;
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		System.setIn(new FileInputStream("input.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/

		// ������ 0������ 10������ �ְ�
		// 11 ������ ���. ������ 1 �̻� 100������ �ڿ����̴�.
		// 0 1 2 3 4 5 6 7 8 9 10
		for(int test_case = 0; test_case < T; test_case++)
		{
			
			int N = sc.nextInt(); // ���� ũ��. N*N
			map = new int[N][N]; // ���θ� ��Ÿ�� �����Դϴ�.
			check = new int[N][N]; // �ִܰ�θ� ��Ÿ�� �����Դϴ�.
			
			for(int i=0; i<N; i++) {
				String str = sc.next();
				String[] arr = str.split("");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.valueOf(arr[j]) - Integer.valueOf("0");
					check[i][j] = INF;
				}
			}
			// ���� ��ǲ�ޱ� ��... �̤�
			
			Queue<Pos> q = new LinkedList<>();
			q.add(new Pos(0,0)); // �������� �ְ�
			check[0][0] = map[0][0]; // ù��° �ִ� ��θ� �ְ�.
			while(!q.isEmpty()) { // ť�� ������� �� ���� �Ұž�.
				Pos cur = q.poll(); // ���� �ڸ��� ť���� �ϳ� ������.
				for(int i=0; i<4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					if(nx >= N || ny >= N || nx < 0 || ny < 0) {
						continue; // ��ǥ�� ���� ���̸� �Ѿ��.
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