import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// N * M 미로에 갇혀있다. 왼쪾 위가 1,1 오른쪽 아래가 n, m
		// 1.1 -> n.m 으로 이동할건데.
		// 오른쪽 ,아래쪽, 대각선으로 이동가능. 
		
		// 가져올 수 있는 사탕 최대의 개수.
		/*
		1 2 3 4
		0 0 0 5
		9 8 7 6
		*/
		int[][] map = new int[N+1][M+1]; // 지도 입니다. 지도!
		
		for(int i = 1; i<= N; i++) {
			for(int j=1; j<=M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int[][] candy = new int[N+1][M+1];
		
		candy[1][1] = map[1][1];
		// 왼쪽, 대각선왼쪽위, 위쪽 중에 제일 큰애랑 나랑 더하기!
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				// i, j 번째 최대 캔디 구하기.
				// i-1, j 왼쪽
				// i, j-1 위쪽
				// i-1, j-1 대각선 위쪽
				
				// 1 2 3 중 젤 큰거 구하기
				int a = Math.max(candy[i-1][j], candy[i][j-1]); // 1, 2 중 큰거
				int b = Math.max(candy[i][j-1], candy[i-1][j-1]); // 2, 3 중 큰거
				int c = Math.max(a, b); // 젤 큰거
				candy[i][j] = map[i][j] + c;
				
			}
		}
		
		System.out.println(candy[N][M]);
		
	}
}
