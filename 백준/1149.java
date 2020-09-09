import java.util.Scanner;

public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// RGB 거리에는 집이 N개. 거리는 선분. 1번 집부터 N번 집.
		// 빨, 초, 파 중 하나. 
		// 비용이 주어졌을때 비용의 최솟값.
		// 1번은 2번이랑 색 달라야함.
		// n번은 N-1번 집과 색 달라야함
		// i번의 집은 i-1, i+1 집과 달라야함.
		
		int N = sc.nextInt();
		int[][] cost = new int[N][3];
		// 첫 줄. 빨. 초. 파.
		// 두번째 줄. 빨 최소. 초 최소. 파 최소.
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
