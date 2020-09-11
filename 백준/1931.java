import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Practice2 {
	
	public static boolean[] room;
	public static void main(String[] args) throws IOException {
		// 한개의 회의실
		// 회의 N개
		// 회의 시작시간, 끝나는 시간 있고
		// 겹치지 않게 하면서 회의실 사용가능한 회의의 최대 개수 찾기
		// 시작 == 끝 가능.
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 회의의 갯수
		
		int[][] conf = new int[N][2];
		for(int i=0; i<N; i++) {
			conf[i][0] = sc.nextInt(); // start
			conf[i][1] = sc.nextInt(); // end
		}
		
		// 빨리 끝나는 회의 먼저 시작해야함.
		// a[1] == b[1] 끝나는 시간이 같으면
		// 시작 시간이 가장 빠른 애로.
		// a[0] - b[0] 시작 시간으로 비교 . 시작시간이 짧은 애 반환.
		// 끝나는 시간이 같지 않으면
		// a[1] - b[1] 끝나는 시간으로 비교.
		Arrays.sort(conf, (a,b) -> a[1] == b[1]? a[0] - b[0] : a[1] - b[1]);
		/*
		Arrays.sort(conf, (a,b) -> {
			if(a[1] == b[1]) {
				return Integer.compare(a[0]-b[0], a[1]-b[1]);
			}else {
				return Integer.compare(a[0], b[0]);
			}
		});
		*/
		int idx = 0;
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			if(i == 0) {
				idx = conf[i][1]; // 끝나는 시간을 이제 시작시간으로
				cnt++;
			}
			else {
				// 그 다음부터는.
				if(conf[i][0] < idx) {
					continue; // 다음꺼 시작 시간이 현재 끝나는 시간보다 작으면 나가기.
				} else {
					idx = conf[i][1];
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}

