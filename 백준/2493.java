import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Practice2 {
	
	public static void main(String[] args) throws IOException {
		// N���� ���̰� ���� �ٸ� ž
		// ���ʺ��� ����������
		// ����⿡ �۽ű�
		// �������� �������� �������� �߻�
		// �������� ���� ó�� ������ �ָ� ���Ű���
		
		// 6 9 5 7 4
		// 4 ���� �߻��Ѱ� 7�� ����
		// 7 ���� �߻��Ѱ� 9�� ����
		// 5 ���� �߻��Ѱ� 9�� ����
		// 9�� 6 �� �ƹ��� ���� ����4
		
		// ������ ž���� �߻��� �������� ��� ž���� �����ϴ°� �˾Ƴ���
		
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// ž�� �� 1�̻� 500000 ����
		// ���̴� 1 �̻� 1������.
		int[] top = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Pair> stack = new Stack();
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		for(int i=0; i<N; i++) {
			top[i] = Integer.parseInt(st.nextToken());
			// i ��° ž���� �۽��մϴ�.
			
			if(stack.size() == 0) {
				// �ƹ��͵� ������
				bw.write(0 + " "); // 0 ���
				stack.push(new Pair(i, top[i]));
				//System.out.println("push " + top[i]);
			} else {
				// �װ� �ƴϸ�
				//System.out.println("peak " + stack.peek().height);
				//System.out.println(stack.size() + " size");
				// ������ �����ִ� �� ����
				while(stack.size() > 0) {
					if(stack.peek().height < top[i]) {
						// �� ���� �ִ� �ְ� ������ ������
						stack.pop(); // ����
						//System.out.println("pop");
					}
					else {
						break;
					}
				}
				
				if(stack.size() == 0) {
					// �ƹ��͵� ������
					bw.write(0 + " "); // 0 ���
					stack.push(new Pair(i, top[i]));
					//System.out.println("push " + top[i]);
				} else {
					bw.write(stack.peek().idx + " ");
					stack.push(new Pair(i, top[i]));
					//System.out.println("push " + top[i]);	
				}	
			}
		}
		// ž�� ���� ���� �Ϸ�
		
		br.close();
		bw.close();
	}
}

class Pair{
	int idx;
	int height;
	public Pair(int idx, int height) {
		this.idx = idx+1;
		this.height = height;
	}
}