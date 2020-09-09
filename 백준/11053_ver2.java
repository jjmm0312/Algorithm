import java.util.Scanner;

public class Practice2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		// ���� �� �����ϴ� �κ� ���� ���ϴ� ���α׷� �ۼ��ϱ�.
		// A = 10 20 10 30 20 50 �� ���
		// a = 1 
		// ���� �� �����ϴ� �κ� ������ 10 20 30 50 �̰� ���̴� 4 �̴�.
		
		int N = sc.nextInt();
		int[] A = new int[N]; // ���ڸ� �����ϴ� �迭
		int[] len = new int[N+1]; // ���̸� �����ϴ� �迭
		int currentlen = 0;
		
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			// ���� A[i] �ڸ����� �˾ƺ��ž�.
			int max = 0;
			for(int j=0; j<=currentlen; j++) {
				// 0 ���� len �迭 ��ü�� ���Ŵϱ� len ����.
				if(len[j] < A[i] && j > max) max = j;
			}
			
			// �� ���� A[i] �� ����. ������ ���� �ֵ� �� ���� �� �� ����. max + 1. �ű�ٰ� 1 ���Ѱ� ����.
			if(max + 1 <= currentlen) {
				// ���� �ִ� �迭 �߿� ������.
				if(len[max+1] > A[i]) len[max+1] = A[i];
			} else {
				// ó�� ���� ���̸�.
				len[max+1] = A[i];
				currentlen ++;
			}
		}
		
		System.out.println(currentlen);
		
	}
}
