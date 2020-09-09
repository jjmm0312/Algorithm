import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {

		// 합이 21을 넘지 않는 한도 내에서, 합을 최대한 크게.
		// 카드에는 양의 정수
		// N장의 카드가 모두 숫자 보이게 놓고
		// 딜러가 M을 외친다.
		// 플레이어는 시간안에 N장 중에서 3장 고르기
		// 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야함.
		// N장 카드 숫자, M 넘지않으면서 M 과 최대한 가까운 카드 3장의 합은?
		
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
