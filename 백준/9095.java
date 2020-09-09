import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// n �� 123 �� ������ ��Ÿ���� ����� ��.
		
		int T = sc.nextInt(); // �׽�Ʈ���̽��� ��
		for(int i=0; i<T; i++) {
			int n = sc.nextInt();  // ����
			int result = 0; // �� ����.
			
			int[] dp = new  int[11]; // n��¥�� �迭�� �ϳ� �����!
			
			dp[1] = 1; // 1 ����� ���� 1��
			dp[2] = 2; // 2 ����� ���� 2��
			dp[3] = 4; // 3 ����� ���� 4�� : 1+1+1 1+2 2+1 3
			
			for(int j = 4; j<=n; j++) {
				// ���� j �� �� �� �� �ΰ� �˾ƺ���.
				dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
				// j �϶���
				// j-1 ��� + 1
				// j-2 ��� + 2
				// j-3 ��� + 3
			}
			
			result = dp[n];
			
			System.out.println(result);
		}
		
	}
}
