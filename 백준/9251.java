import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.next();
		String s2 = sc.next();
		
		// ACAYKP
		// CAPCAK
		
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		for(int i=1; i<=s1.length(); i++) {
			
			char c1 = s1.charAt(i-1);
			
			for(int j=1; j<=s2.length(); j++) {
				char c2 = s2.charAt(j-1);
				
				if(c1 == c2) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					// 좌측(x-1), 상단(y-1)의 값 중 더 큰 값.
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			
		}
		
		System.out.println(dp[s1.length()][s2.length()]);
	}
}
