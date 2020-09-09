import java.util.Scanner;

public class Practice2 {
	public static int num = 0;
	public static int k;
	public static int[] S;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// �ζǴ� 1 - 49 �߿��� 6�� ����4
		// 49 ���� �� k���� ��� ���� S �����
		// �� ���� ������ ��ȣ ����.
		int terminal = 1;
		// S �� k �� �־�������, ���� ���� ��� ���.
		terminal = sc.nextInt();
		
		while(terminal != 0) {
			
			k = terminal;
			S = new int[k];
			for(int i=0; i<k; i++) {
				//System.out.println(i);
				S[i] = sc.nextInt();
			}
			// S ���� 6���� ���� ��� ���� ���.
			lotto(0, 0, "");
			
			//System.out.println("fin");
			terminal = sc.nextInt();
			//System.out.println(terminal);
			System.out.println();
		}
	}
	
	public static void lotto(int sum, int i, String result) {
		// sum �� �� �� ������ ����, i�� �ε���.
		if(sum == 6) {
			System.out.println(result);
			return;
		}
		
		if(i >= k) return; // �ε����� �Ѿ�� ������.
		
		String thisStr = "";
		if(sum == 0) {
			thisStr = "" + S[i]; 
		} else {
			thisStr = " " + S[i];
		}
		
		lotto(sum+1, i+1, result + thisStr); // �� �����ϱ�
		lotto(sum, i+1, result); // �� �ȼ����ϱ�
	}
	
}
