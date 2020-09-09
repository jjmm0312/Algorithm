import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {

		// ���� 21�� ���� �ʴ� �ѵ� ������, ���� �ִ��� ũ��.
		// ī�忡�� ���� ����
		// N���� ī�尡 ��� ���� ���̰� ����
		// ������ M�� ��ģ��.
		// �÷��̾�� �ð��ȿ� N�� �߿��� 3�� ����
		// ���� M�� ���� �����鼭 M�� �ִ��� ������ ��������.
		// N�� ī�� ����, M ���������鼭 M �� �ִ��� ����� ī�� 3���� ����?
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int num[] = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		
		int result = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(i == j) continue;
					if(j == k) continue;
					if(i == k) continue;
					
					int currentSum = num[i] + num[j] + num[k];
					if(currentSum > M) continue;
					
					if(currentSum > result) result = currentSum;
				}
			}
		}
		
		System.out.println(result);
		
	}

}
