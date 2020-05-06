
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EX1 {

	public static int[] d;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = Integer.valueOf(in.nextLine()); // 테스트 케이스의 개수
		
		for(int i=0; i<T; i++) {
			int M = Integer.valueOf(in.nextLine());
			d = new int[M+1];
			for(int j=0; j<M+1; j++) {
				if(j == 0) d[j] = 0; // 0 넣는 경우 없고.
				else if(j == 1) d[j] = 1; // 1을 넣을경우 (1) 한가지
				else if(j == 2) d[j] = 2; // 2를 넣을 경우 (1+1, 2) 두가지
				else if(j == 3) d[j] = d[j-1] + d[j-2] + 1; // 3을 넣을 경우는 1경우 + 2경우 + 3 (1+1+1, 1+2, 2+1, 3)
				else d[j] = d[j-1] + d[j-2] + d[j-3]; 
			}
			System.out.println(d[M]);
			
		}
	}
	
}