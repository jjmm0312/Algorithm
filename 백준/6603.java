import java.util.Scanner;

public class Practice2 {
	public static int num = 0;
	public static int k;
	public static int[] S;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 로또는 1 - 49 중에서 6개 고르기4
		// 49 가지 중 k가지 골라서 집합 S 만들고
		// 그 수만 가지고 번호 선택.
		int terminal = 1;
		// S 와 k 가 주어졌을때, 수를 고르는 모든 방법.
		terminal = sc.nextInt();
		
		while(terminal != 0) {
			
			k = terminal;
			S = new int[k];
			for(int i=0; i<k; i++) {
				//System.out.println(i);
				S[i] = sc.nextInt();
			}
			// S 에서 6개인 집합 모두 고르는 방법.
			lotto(0, 0, "");
			
			//System.out.println("fin");
			terminal = sc.nextInt();
			//System.out.println(terminal);
			System.out.println();
		}
	}
	
	public static void lotto(int sum, int i, String result) {
		// sum 은 나 안 포함한 개수, i는 인덱스.
		if(sum == 6) {
			System.out.println(result);
			return;
		}
		
		if(i >= k) return; // 인덱스가 넘어가면 나가기.
		
		String thisStr = "";
		if(sum == 0) {
			thisStr = "" + S[i]; 
		} else {
			thisStr = " " + S[i];
		}
		
		lotto(sum+1, i+1, result + thisStr); // 나 선택하기
		lotto(sum, i+1, result); // 나 안선택하기
	}
	
}
