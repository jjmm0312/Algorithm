import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// ���� N ų�� ����ؾ���
		// 3ų�� ����, 5ų�� ����
		// �ִ��� ���� ���� ����ž�
		// ���� � �������� ���غ�
		
		int N = sc.nextInt(); // ����̰� �ʿ��� ų�μ�
		
		int result = 0;
		int current = N;
		int bag = 0;
		
		while(current >= 3) {
			if(current % 5 != 0) {
				// ���� 5�� ����� �ƴϸ�.
				current -= 3;
				bag++;
			}
			
			else {
				bag += current / 5;
				current = 0;
			}
		}
		
		if(current != 0) result = -1;
		else result = bag;
		
		System.out.println(result);

	}

}
