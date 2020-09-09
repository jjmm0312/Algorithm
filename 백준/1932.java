import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		// 맨 위층부터 시작해서 맨 아래층으로 올때
		// 합이 최대가 되는 경로
		// 삼각형 크기는 1이상 500이하
		// 범위는 0 이상 9999 이하
		
		int n = sc.nextInt(); // 삼각형의 크기
	
		// 7
		// 3 8
		// 8 1 0
		// 2 7 4 4
		// 4 5 2 6 5
		
		//        0
		//       1 2       // 왼 : -2 오른쪽 : -1
		//     3  4  5     // 왼 : -3 오른쪽 : -2
		//   6  7  8  9    // 왼 : -4 오른쪽 : -3
		// 10 11 12 13 14  // 왼 : -5 오른쪽 : -4
		
		// 크기가 5 일때 : 1+2+3+4+5
		int size = 0;
		for(int i=1; i<=n; i++) {
			size += i;
		}
		
		int[] tri = new int[size];
		for(int i = 0; i<size; i++) {
			tri[i] = sc.nextInt();
		}
		
		int[] sum = new int[size];
		sum[0] = tri[0];
		int current = 1;

		int start = 0;
		int end = 0;
		
		int max = 0;
		
		for(int i = 1; i<n; i++) {
			//System.out.println("current "+current);
			// 현재 i층입니다.
			// 아래 층의 범위를 구하고.
			// 그러면 총 개수는 i+1 이고.
			// 현재 위치 current. 
			if(end != 0) {
				start = end - i + 1;
			}
			// 왼 -i+1 오 -i
			for(int j = 0; j<=i; j++) {
				if(current - (i + 1) < start) {
					//왼쪽이 start 보다 작으면
					sum[current] = tri[current] + sum[current - i];
					// 나 + 오른쪽.
				} else if(current - i > end) {
					// 오른쪽이 end 보다 크면
					sum[current] = tri[current] + sum[current - i - 1];
				} else {
					// 둘다 아니면 둘중 큰거
					//System.out.println(start + " " + end);
					//System.out.println(current + " " + (current-i) + " " + (current-i-1));
					sum[current] = Math.max(tri[current] + sum[current - i], tri[current] + sum[current - i - 1]);
				}

				if(i == (n-1)) {
					// 마지막 층이면 최댓값 찾아야한다.
					if(max < sum[current]) {
						max = sum[current];
					}
				}
				//System.out.println(current + "   " + sum[current]);
				current++;
			}

			end = current-1;
			//System.out.println("end "+end);
		}
		
		System.out.println(max);
		
		
	}
}
