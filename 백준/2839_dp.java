import java.util.Scanner;

public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // n킬로 배달해야해.
		// 3 or 5
		// 최소봉지구하기.
		
		int[] bag = new int[N+1]; // 최대 5000 킬로
		
		bag[0] = -1;
		bag[1] = -1;
		bag[2] = -1;
		bag[3] = 1;
		if(N >= 4) bag[4] = -1;
		if(N >= 5) bag[5] = 1;
		
		for(int i=6; i<=N; i++) {
			int a = 0;
			int b = 0;
			
			if(bag[i-3] == -1) {
				a = -1;
			} else {
				a = bag[i-3] + 1;
			}
			
			if(bag[i-5] == -1) {
				b = -1;
			} else {
				b = bag[i-5] + 1 ;
			}
			
			if(a == -1 && b != -1) {
				bag[i] = b;
			} else if(b == -1 && a != -1) {
				bag[i] = a;
			} else if(a == -1 && b == -1) {
				bag[i] = -1;
			} else {
				bag[i] = Math.min(a, b);
			}
		}
		
		
		System.out.println(bag[N]);
		
	}
}
