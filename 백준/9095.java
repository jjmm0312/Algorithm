
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EX1 {

	public static int[] d;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = Integer.valueOf(in.nextLine()); // �׽�Ʈ ���̽��� ����
		
		for(int i=0; i<T; i++) {
			int M = Integer.valueOf(in.nextLine());
			d = new int[M+1];
			for(int j=0; j<M+1; j++) {
				if(j == 0) d[j] = 0; // 0 �ִ� ��� ����.
				else if(j == 1) d[j] = 1; // 1�� ������� (1) �Ѱ���
				else if(j == 2) d[j] = 2; // 2�� ���� ��� (1+1, 2) �ΰ���
				else if(j == 3) d[j] = d[j-1] + d[j-2] + 1; // 3�� ���� ���� 1��� + 2��� + 3 (1+1+1, 1+2, 2+1, 3)
				else d[j] = d[j-1] + d[j-2] + d[j-3]; 
			}
			System.out.println(d[M]);
			
		}
	}
	
}