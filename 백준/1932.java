import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		// �� �������� �����ؼ� �� �Ʒ������� �ö�
		// ���� �ִ밡 �Ǵ� ���
		// �ﰢ�� ũ��� 1�̻� 500����
		// ������ 0 �̻� 9999 ����
		
		int n = sc.nextInt(); // �ﰢ���� ũ��
	
		// 7
		// 3 8
		// 8 1 0
		// 2 7 4 4
		// 4 5 2 6 5
		
		//        0
		//       1 2       // �� : -2 ������ : -1
		//     3  4  5     // �� : -3 ������ : -2
		//   6  7  8  9    // �� : -4 ������ : -3
		// 10 11 12 13 14  // �� : -5 ������ : -4
		
		// ũ�Ⱑ 5 �϶� : 1+2+3+4+5
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
			// ���� i���Դϴ�.
			// �Ʒ� ���� ������ ���ϰ�.
			// �׷��� �� ������ i+1 �̰�.
			// ���� ��ġ current. 
			if(end != 0) {
				start = end - i + 1;
			}
			// �� -i+1 �� -i
			for(int j = 0; j<=i; j++) {
				if(current - (i + 1) < start) {
					//������ start ���� ������
					sum[current] = tri[current] + sum[current - i];
					// �� + ������.
				} else if(current - i > end) {
					// �������� end ���� ũ��
					sum[current] = tri[current] + sum[current - i - 1];
				} else {
					// �Ѵ� �ƴϸ� ���� ū��
					//System.out.println(start + " " + end);
					//System.out.println(current + " " + (current-i) + " " + (current-i-1));
					sum[current] = Math.max(tri[current] + sum[current - i], tri[current] + sum[current - i - 1]);
				}

				if(i == (n-1)) {
					// ������ ���̸� �ִ� ã�ƾ��Ѵ�.
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
