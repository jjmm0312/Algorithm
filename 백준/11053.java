import java.util.Scanner;

public class Practice2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		// ���� �� �����ϴ� �κ� ���� ���ϴ� ���α׷� �ۼ��ϱ�.
		// A = 10 20 10 30 20 50 �� ���
		// a = 1 
		// ���� �� �����ϴ� �κ� ������ 10 20 30 50 �̰� ���̴� 4 �̴�.
		
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		int finalmax = 0;

		arr[0] = 1;
		for(int i=1; i<N; i++) {
			int max = 0;
			for(int j=i-1; j>=0; j--) {
				if(A[j] < A[i] && max < arr[j]) max = arr[j];
			}
			arr[i] = max + 1;
			//System.out.println(arr[i]);
			if(arr[i] > finalmax) finalmax = arr[i];
		}
		
		if(finalmax == 0) finalmax = 1; // 1���� ���� ����, ����ó���� ���־����!!
		System.out.println(finalmax);
	}
}
