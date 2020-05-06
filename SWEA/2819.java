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
import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class EX1
{

	static int board[][];
	static Stack<Integer> result;
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		//System.setIn(new FileInputStream("sample_input.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		board = new int[4][4]; // ������.
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/

		for(int test_case = 0; test_case < T; test_case++)
		{

			result = new Stack();
            for(int i = 0; i<4; i++) {
            	for(int j=0; j<4; j++) {
            		board[i][j] = sc.nextInt();
            	}
            }
            ///////��ǲ ������ �Է� ��!
            
            //////////////////�˰����� ����///////////////////
            
            for(int i=0; i<4; i++) {
            	for(int j=0; j<4; j++) {
            		// �������� board[i][j]
            		dfs(i,j,0,0);
            	}
            }
            
            
            /////////////////�˰����� ��/////////////////////
		
			
			System.out.println("#" + (test_case+1) + " " + result.size());
		}
	}

	// count �� �°���� ��� 7�� ������ ����
	// num���ٰ� ���� ���ڰ� ���� ����. num �� 7�� ¥�� �迭
	public static void dfs(int i, int j, int count, double num) {
		// board[i][j] �� ��������.

		if(count == 7) {
			if(result.search((int)num) == -1) {
				result.push((int)num); // ������ �ֱ�.
			}
			count++;
			return;
		}
		
		num += board[i][j] * Math.pow(10, 6-count);
		
		// ������
		if(j+1 <4) {

			dfs(i, j+1, count+1, num);
		}
		// ����
		if(j-1 >= 0) {
			dfs(i, j-1, count+1, num);
		}
		// �Ʒ���
		if(i+1 < 4) {
			dfs(i+1, j, count+1, num);
		}
		// ����
		if(i-1>=0) {
			dfs(i-1, j, count+1, num);
		}
		
		return;
	}
}