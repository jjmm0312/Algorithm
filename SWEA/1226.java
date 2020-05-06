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

class EX1
{

    static int dx[] = { 1, -1, 0, 0 };
    static int dy[] = { 0, 0, 1, -1 };
	public static int[][] map; // �̷θ� ��Ÿ�� �����Դϴ�.
	public static int[][] check; // �湮�޴��� ���޴����� ��Ÿ���� üũ���Դϴ�.
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
		int T = 10;
		
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/

		for(int test_case = 0; test_case < T; test_case++)
		{	
			map = new int[16][16];
			check = new int[16][16]; 
			int testNum = sc.nextInt(); // ���� ���° �׽�Ʈ ���̽��ΰ�.
			int firstx=0, firsty = 0;
			for(int i=0; i<16; i++) {
				String str = sc.next();
				String[] arr = str.split("");
				for(int j=0; j<16; j++) {
					map[i][j] = Integer.valueOf(arr[j]) - Integer.valueOf("0");
					if(map[i][j] == 2) {
						firstx = i;
						firsty = j;
					}
				}
			}
			

			System.out.println("#" + (test_case+1) + " " + adventure(firstx, firsty, 16));
		}
	}
	

	public static int adventure(int i, int j, int N) {
		//System.out.println(i + " " + j);

		int result = 0;
		if(map[i][j] == 3) // �������� ����!
			return 1;
		
		check[i][j] = 1; // �� �湮�߾�!
		for(int k=0; k<4; k++) {
			if(i+dx[k] < N && i+dx[k] >= 0 && j + dy[k] <N && j+dy[k] >= 0) {
				if(check[i+dx[k]][j+dy[k]] != 1 && map[i][j] != 1) { // ����ĭ�� �湮���� ĭ�̱�, ���� �ȸ�������.
					result = adventure(i+dx[k], j+dy[k], N); // ����ĭ���� �̵�! 
					if(result == 1)
						break;
				}
			}
		}
		
		// ����ĭ�� ���� ����...
		return result; // �׷��� ����.
	}
		
	
}