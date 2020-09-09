import java.util.Scanner;

public class Practice2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		// 가장 긴 증가하는 부분 수열 구하는 프로그램 작성하기.
		// A = 10 20 10 30 20 50 인 경우
		// a = 1 
		// 가장 긴 증가하는 부분 수열은 10 20 30 50 이고 길이는 4 이다.
		
		int N = sc.nextInt();
		int[] A = new int[N]; // 숫자를 저장하는 배열
		int[] len = new int[N+1]; // 길이를 저장하는 배열
		int currentlen = 0;
		
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			// 현재 A[i] 자리에서 알아볼거야.
			int max = 0;
			for(int j=0; j<=currentlen; j++) {
				// 0 부터 len 배열 전체를 볼거니깐 len 까지.
				if(len[j] < A[i] && j > max) max = j;
			}
			
			// 자 이제 A[i] 의 값은. 나보다 작은 애들 중 제일 긴 거 선택. max + 1. 거기다가 1 더한게 나야.
			if(max + 1 <= currentlen) {
				// 지금 있는 배열 중에 있으면.
				if(len[max+1] > A[i]) len[max+1] = A[i];
			} else {
				// 처음 나온 길이면.
				len[max+1] = A[i];
				currentlen ++;
			}
		}
		
		System.out.println(currentlen);
		
	}
}
