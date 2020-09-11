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
		// �Ѱ��� ȸ�ǽ�
		// ȸ�� N��
		// ȸ�� ���۽ð�, ������ �ð� �ְ�
		// ��ġ�� �ʰ� �ϸ鼭 ȸ�ǽ� ��밡���� ȸ���� �ִ� ���� ã��
		// ���� == �� ����.
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ȸ���� ����
		
		int[][] conf = new int[N][2];
		for(int i=0; i<N; i++) {
			conf[i][0] = sc.nextInt(); // start
			conf[i][1] = sc.nextInt(); // end
		}
		
		// ���� ������ ȸ�� ���� �����ؾ���.
		// a[1] == b[1] ������ �ð��� ������
		// ���� �ð��� ���� ���� �ַ�.
		// a[0] - b[0] ���� �ð����� �� . ���۽ð��� ª�� �� ��ȯ.
		// ������ �ð��� ���� ������
		// a[1] - b[1] ������ �ð����� ��.
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
				idx = conf[i][1]; // ������ �ð��� ���� ���۽ð�����
				cnt++;
			}
			else {
				// �� �������ʹ�.
				if(conf[i][0] < idx) {
					continue; // ������ ���� �ð��� ���� ������ �ð����� ������ ������.
				} else {
					idx = conf[i][1];
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}

