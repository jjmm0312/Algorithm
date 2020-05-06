
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EX1 {

	private static int[] d;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = Integer.valueOf(in.nextLine());
		
		d = new int[n+1];
		for(int i=0;i<n+1; i++) {
			if(i == 0) d[i] = 0;
			else if(i == 1) d[i] = 1;
			else if(i == 2) d[i] = 3;
			else d[i] = (d[i-1]+2*d[i-2]) % 10007;
		}
		System.out.println(d[n]);
		
	}
}