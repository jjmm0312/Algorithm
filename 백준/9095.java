import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// n 을 123 의 합으로 나타내는 방법의 수.
		
		int T = sc.nextInt(); // 테스트케이스의 수
		for(int i=0; i<T; i++) {
			int n = sc.nextInt();  // 정수
			int result = 0; // 총 개수.
			
			int[] dp = new  int[11]; // n개짜리 배열을 하나 만들고!
			
			dp[1] = 1; // 1 만드는 법은 1개
			dp[2] = 2; // 2 만드는 법은 2개
			dp[3] = 4; // 3 만드는 법은 4개 : 1+1+1 1+2 2+1 3
			
			for(int j = 4; j<=n; j++) {
				// 숫자 j 일 때 몇 개 인가 알아보자.
				dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
				// j 일때는
				// j-1 경우 + 1
				// j-2 경우 + 2
				// j-3 경우 + 3
			}
			
			result = dp[n];
			
			System.out.println(result);
		}
		
	}
}
