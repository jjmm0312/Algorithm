import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 설탕 N 킬로 배달해야해
		// 3킬로 봉지, 5킬로 봉지
		// 최대한 적은 봉지 들고갈거야
		// 봉지 몇개 가져갈지 구해봐
		
		int N = sc.nextInt(); // 상근이가 필요한 킬로수
		
		int result = 0;
		int current = N;
		int bag = 0;
		
		while(current >= 3) {
			if(current % 5 != 0) {
				// 내가 5의 배수가 아니면.
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
