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
            	// 첫 번째 인자가 0인 경우 우측으로 이동, 1인 경우 위로 이동
            	// 두 번째 인자가 0인 경우 현재 방향으로 1칸만 이동, 1인 경우 2칸 이상 이동
            	
            	// 나에게 1칸째로 우측으로 들어온 경우 : 내 왼쪽에서 1칸쨰 이동 경우 + 내 왼쪽에서 2칸째 이동 경우.
                dp[i][j][0][0] = (dp[i-1][j][0][0] + dp[i-1][j][0][1]) % 100000;
                // 나에게 2칸째로 우측으로 들어온 경우 : 내 왼쪽에서 2칸째 이동경우.
                dp[i][j][0][1] = dp[i-1][j][1][0];
                // 나에게 1칸째로 북쪽으로 들어온 경우 : 내 남쪽에서 1칸째 + 내 남쪽에서 2칸째(왜냐면 3칸쨰때 1칸으로도 침)
                dp[i][j][1][0] = (dp[i][j-1][1][0] + dp[i][j-1][1][1]) % 100000;
                // 나에게 2칸째로 북쪽으로 들어온 경우 : 내 남쪽에서 2칸째 이동하는 경우. ( 앞이랑 무조건 같음 )
                dp[i][j][1][1] = dp[i][j-1][0][0];
            }
        }

        int ans = 0;
        for(int i=0; i<2; i++) for(int j=0; j<2; j++) ans += dp[W][H][i][j];

        System.out.println(ans%100000);
		
	}
	
}




