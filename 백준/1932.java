
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EX1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = Integer.valueOf(in.nextLine()); // 삼각형의 크기
		int result[][] = new int[n+1][n+1];
		
		int sum = 0;
		
		for(int i=1; i<n+1; i++) { // 줄 수 만큼
			for(int j=1; j<i+1; j++) {
				int num = in.nextInt(); 
				result[i][j] = num;
				
				if (j == 1)
		            result[i][j] = result[i - 1][j] + result[i][j];
		        else if (j == i)
		            result[i][j] = result[i - 1][j - 1] + result[i][j];
		        else
		            result[i][j] = Math.max(result[i - 1][j - 1], result[i - 1][j]) + result[i][j];

		        if (sum < result[i][j])
		            sum = result[i][j];
			}		
		}

System.out.println(sum);
					
		
	}
}