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
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */

class EX1
{
	// ���α׷��� �����ϸ� YES �ƴϸ� NO �� ����Ͻÿ�.
	// �������� �޸𸮴� �� �ϳ�. 0-15 ������ ������ ����. �ʱⰪ�� 0.
	static int mem = 0;
    static int dx[] = { 1, -1, 0, 0 };
    static int dy[] = { 0, 0, 1, -1 };
	public static char[][] command; // ��ɾ ��Ÿ����.
	public static boolean[][][][] check; // �湮�޴��� ���޴����� ��Ÿ���� üũ���Դϴ�.
	public static int yes = 0;
	public static int exit = 0;
	public static int R = 0, C = 0;
	
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

		for(int test_case = 0; test_case < T; test_case++)
		{	
			R = sc.nextInt(); 
			C = sc.nextInt(); // ���� R�� c��
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
			
			
			// input �ޱ� �Ϸ��޽��ϴ�.
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
		// R�� C���� command �߿���. [i][j] ĭ�� ���Խ��ϴ�. 
		// direction�� �����¿� 0123.
		// ����� ó���ϰ� �������ڷ� �̵��ϼ���.
		//System.out.println(i+ " " + j + " " + check[i][j][mem][direction]);
			if(exit == 1)
				return;
			// ����� ó���մϴ�.
			if(command[i][j] == '<') {
				// �̵������� �������� �ٲ۴�.
				direction = 2;
			}else if(command[i][j] == '>') {
				// �̵������� ���������� �ٲ۴�.
				direction = 3;
			}else if(command[i][j] == '^') {
				// �̵������� �������� �ٲ۴�.
				direction = 0;
			}else if(command[i][j] == 'v') {
				// �̵������� �Ʒ������� �ٲ۴�.
				direction = 1;
			}else if(command[i][j] == '_') {
				// �޸� 0�̸�, �̵����� ������. �ƴϸ� �������� �ٲ۴�.
				if(mem == 0)
					direction = 3;
				else
					direction = 2;
			}else if(command[i][j] == '|') {
				// �޸� 0�̸� �̵����� �Ʒ���. �ƴϸ� ���� �ٲ۴�.
				if(mem == 0)
					direction = 1;
				else
					direction = 0;
			}else if(command[i][j] == '?') {
				// �̵������� �����¿� �� �ϳ��� �������� �ٲ۴�. ������ �ٲ� Ȯ���� �׹��� ����.
				direction = 4;
			}else if(command[i][j] == '.') {
				// �ƹ��͵� �����ʴ´�.
			}else if(command[i][j] == '@') {
				// ���α׷� �����Ѵ�.
				exit = 1;
				yes = 1;
				return;
			}else if(command[i][j] >= '0' && command[i][j] <='9') { // 0 - 9
				// �޸𸮿� ���� ����
				mem = Integer.valueOf(command[i][j] - '0');
			}else if(command[i][j] == '+') {
				// �޸𸮿� ���ϱ� 1. 15�� 0����
				mem += 1;
				if(mem == 16)
					mem = 0;
			}else if(command[i][j] == '-') {
				// �޸𸮿� ���� 1. 0�̸� 15��
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
			
			// ��ǥ�� ���� ��ǥ�� �̵��Ұſ���.
			// �̵��ؾ��� ��ǥ�� ���غ���.
			List<Point> list = next(i,j,direction);
			// ���⿡ �̵��ؾ��� ��ǥ���� ����Ǿ� ����.
			/*
			for(int k=0; k<list.size(); k++) {
				if(yes==0)exit=0;
				compiler(list.get(k).x, list.get(k).y,list.get(k).location);
			}
			*/
			for(Point p : list) {
	            // �̵��� ������ exit = false �� ��������� ��.
	            // ��, ��, ��, �� ��� �̵��ؼ� Ȯ���������.!
	            if(yes == 0) exit = 0;
	            compiler(p.x,p.y,p.location);
	            
	        }

		return;
		}
	
	public static List<Point> next(int x, int y, int direction){
	
		List<Point> list = new ArrayList<>();
		switch(direction) {
	 case 4: 
         // case 0,1,2,3  ��� �����ϸ鼭 
         // ��, ��, ��, �� ��� �˻��ϱ�.

     case 3: // ������
         Point temp0 = new Point(x, y,0);
         temp0.y = y + 1 >= C ? 0: y + 1;
         temp0.location = 3;
         list.add(temp0);
         
         if(direction!=4) break;
     case 2: // ����
         Point temp1 = new Point(x, y,0);
         temp1.y = y - 1 < 0 ? C-1: y - 1;
         temp1.location = 2;
         list.add(temp1);
         if(direction!=4) break;
     case 1: // �Ʒ���
         Point temp2 = new Point(x, y,0);
         temp2.x = x + 1 >= R ? 0 : x + 1;
         temp2.location = 1;
         list.add(temp2);
         if(direction!=4) break;
     case 0: // ����
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

			
	
