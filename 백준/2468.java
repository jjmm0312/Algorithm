
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EX1 {

	public static int N = 0;
	public static int[][] map;
	public static boolean[][] water;
	public static int count = 0, max = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		N = in.nextInt(); // N개의 줄.
		map = new int[N][N];
		water = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = in.nextInt();
			}
		}
		
		for(int i=1; i<=100; i++) {
			count = 0;
			//System.out.println(count);
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(map[j][k] <= i)
						water[j][k] = true;
					else
						water[j][k] = false;
				}
			}
			// 이 cut 기준 범람 맵 워터를 작성.
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(water[j][k] == false) {
						bfs(j, k);
						count++;
					}
				}
			}
			// 몇갠지 다 세었어.
			
			//System.out.println("here" + i + count);
			if(count > max)
				max = count;
		}
		
		System.out.println(max);
		
		
	}	
	
	public static void bfs(int i, int j) {

			water[i][j] = true; // 이칸은 끝났음.
			//System.out.println("here" + i + j);
			if( (i+1) < N && water[i+1][j] == false ) {
				bfs(i+1, j);
			}
			if( (i-1) >= 0 && water[i-1][j] == false) {
				bfs(i-1, j);
			}
			if( (j+1) < N &&  water[i][j+1] == false) {
				bfs(i, j+1);
			}
			if( (j-1) >= 0 && water[i][j-1] == false) {
				bfs(i, j-1);
			}
			
		
	}
}
	