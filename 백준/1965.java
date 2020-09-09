import java.util.Scanner;

public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 상자의 개수
		int[] box = new int[n];
		
		int max = 0;
		int count = 0;
		
		int finalmax = 0;
		
		for(int i=0; i<n; i++) {
			box[i] = sc.nextInt();
			if(box[i] > max) {
				max = box[i];
			}
		}
		
		// box 에는 1 5 2 3 7 들어 있음.
		// 1 5 7
		// 1 2 3 7 : 4개 
		
		// 1 2 3 4 5 6 7
		// o o o x o x o
		
		int[] dp = new int[max+1];
		
		for(int i=0; i<n; i++) {
			// 전체를 돌 것임.
			// dp[box[i]] = 나보다 앞에 있는 애 중 0이 아닌것 + 1
			int lastIdx = 0;
			int thismax = 0;
			
			for(int j = 0; j<box[i]; j++) {
				if(dp[j] >= thismax && dp[j] != 0) {
					thismax = dp[j];
					lastIdx = j;
				}
			}
			
			dp[box[i]] = dp[lastIdx] + 1;
			
			
			if(dp[box[i]] > finalmax) {
				finalmax = dp[box[i]];			
			}
		}
		
		System.out.println(finalmax);
	
	}
}
