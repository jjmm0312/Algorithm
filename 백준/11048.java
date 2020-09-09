import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// N * M �̷ο� �����ִ�. �ަU ���� 1,1 ������ �Ʒ��� n, m
		// 1.1 -> n.m ���� �̵��Ұǵ�.
		// ������ ,�Ʒ���, �밢������ �̵�����. 
		
		// ������ �� �ִ� ���� �ִ��� ����.
		/*
		1 2 3 4
		0 0 0 5
		9 8 7 6
		*/
		int[][] map = new int[N+1][M+1]; // ���� �Դϴ�. ����!
		
		for(int i = 1; i<= N; i++) {
			for(int j=1; j<=M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int[][] candy = new int[N+1][M+1];
		
		candy[1][1] = map[1][1];
		// ����, �밢��������, ���� �߿� ���� ū�ֶ� ���� ���ϱ�!
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				// i, j ��° �ִ� ĵ�� ���ϱ�.
				// i-1, j ����
				// i, j-1 ����
				// i-1, j-1 �밢�� ����
				
				// 1 2 3 �� �� ū�� ���ϱ�
				int a = Math.max(candy[i-1][j], candy[i][j-1]); // 1, 2 �� ū��
				int b = Math.max(candy[i][j-1], candy[i-1][j-1]); // 2, 3 �� ū��
				int c = Math.max(a, b); // �� ū��
				candy[i][j] = map[i][j] + c;
				
			}
		}
		
		System.out.println(candy[N][M]);
		
	}
}
