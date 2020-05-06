import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.InputStream;

public class EX1 {
	public static int W, H, size;
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		
		W = sc.nextInt();
		H = sc.nextInt();
		
		int[][][][] dp = new int[W+1][H+1][2][2];

        for(int i=2; i<=W; i++) dp[i][1][0][0] = 1;
        for(int i=2; i<=H; i++) dp[1][i][1][0] = 1;	

        for(int i=2; i<=W; i++){
            for(int j=2; j<=H; j++){
            	// ù ��° ���ڰ� 0�� ��� �������� �̵�, 1�� ��� ���� �̵�
            	// �� ��° ���ڰ� 0�� ��� ���� �������� 1ĭ�� �̵�, 1�� ��� 2ĭ �̻� �̵�
            	
            	// ������ 1ĭ°�� �������� ���� ��� : �� ���ʿ��� 1ĭ�� �̵� ��� + �� ���ʿ��� 2ĭ° �̵� ���.
                dp[i][j][0][0] = (dp[i-1][j][0][0] + dp[i-1][j][0][1]) % 100000;
                // ������ 2ĭ°�� �������� ���� ��� : �� ���ʿ��� 2ĭ° �̵����.
                dp[i][j][0][1] = dp[i-1][j][1][0];
                // ������ 1ĭ°�� �������� ���� ��� : �� ���ʿ��� 1ĭ° + �� ���ʿ��� 2ĭ°(�ֳĸ� 3ĭ���� 1ĭ���ε� ħ)
                dp[i][j][1][0] = (dp[i][j-1][1][0] + dp[i][j-1][1][1]) % 100000;
                // ������ 2ĭ°�� �������� ���� ��� : �� ���ʿ��� 2ĭ° �̵��ϴ� ���. ( ���̶� ������ ���� )
                dp[i][j][1][1] = dp[i][j-1][0][0];
            }
        }

        int ans = 0;
        for(int i=0; i<2; i++) for(int j=0; j<2; j++) ans += dp[W][H][i][j];

        System.out.println(ans%100000);
		
	}
	
}




