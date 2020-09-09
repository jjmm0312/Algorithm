import java.util.Scanner;

public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// RGB �Ÿ����� ���� N��. �Ÿ��� ����. 1�� ������ N�� ��.
		// ��, ��, �� �� �ϳ�. 
		// ����� �־������� ����� �ּڰ�.
		// 1���� 2���̶� �� �޶����.
		// n���� N-1�� ���� �� �޶����
		// i���� ���� i-1, i+1 ���� �޶����.
		
		int N = sc.nextInt();
		int[][] cost = new int[N][3];
		// ù ��. ��. ��. ��.
		// �ι�° ��. �� �ּ�. �� �ּ�. �� �ּ�.
		//
		//
		
		for(int i=0; i<N; i++) {
			
			if( i == 0 ) {
				cost[i][0] = sc.nextInt();
				cost[i][1] = sc.nextInt();
				cost[i][2] = sc.nextInt();
			}else {
				int tmp = sc.nextInt();
				cost[i][0] = Math.min(tmp + cost[i-1][1], tmp + cost[i-1][2]);

				tmp = sc.nextInt();
				cost[i][1] = Math.min(tmp + cost[i-1][0], tmp + cost[i-1][2]);
				
				tmp = sc.nextInt();
				cost[i][2] = Math.min(tmp + cost[i-1][0], tmp + cost[i-1][1]);
			}
		}
		
		
		
		int min = cost[N-1][0];
		if(cost[N-1][1] < min) {
			min = cost[N-1][1];
		}
		if(cost[N-1][2] < min) {
			min = cost[N-1][2];
		}
		
		System.out.println(min);
		
	}
}
