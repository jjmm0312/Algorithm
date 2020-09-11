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
		// N개의 높이가 서로 다른 탑
		// 왼쪽부터 오른쪽으로
		// 꼭대기에 송신기
		// 레이저는 수평으로 왼쪽으로 발사
		// 레이저는 제일 처음 만나는 애만 수신가능
		
		// 6 9 5 7 4
		// 4 에서 발사한건 7이 수신
		// 7 에서 발사한건 9가 수신
		// 5 에서 발사한건 9가 수신
		// 9랑 6 은 아무도 수신 못함4
		
		// 각각의 탑에서 발사한 레이저를 어느 탑에서 수신하는가 알아내라
		
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 탑의 수 1이상 500000 이하
		// 높이는 1 이상 1억이하.
		int[] top = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Pair> stack = new Stack();
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		for(int i=0; i<N; i++) {
			top[i] = Integer.parseInt(st.nextToken());
			// i 번째 탑에서 송신합니다.
			
			if(stack.size() == 0) {
				// 아무것도 없으면
				bw.write(0 + " "); // 0 출력
				stack.push(new Pair(i, top[i]));
				//System.out.println("push " + top[i]);
			} else {
				// 그게 아니면
				//System.out.println("peak " + stack.peek().height);
				//System.out.println(stack.size() + " size");
				// 나보다 작은애는 다 빼고
				while(stack.size() > 0) {
					if(stack.peek().height < top[i]) {
						// 맨 위에 있는 애가 나보다 작으면
						stack.pop(); // 빼기
						//System.out.println("pop");
					}
					else {
						break;
					}
				}
				
				if(stack.size() == 0) {
					// 아무것도 없으면
					bw.write(0 + " "); // 0 출력
					stack.push(new Pair(i, top[i]));
					//System.out.println("push " + top[i]);
				} else {
					bw.write(stack.peek().idx + " ");
					stack.push(new Pair(i, top[i]));
					//System.out.println("push " + top[i]);	
				}	
			}
		}
		// 탑의 높이 수신 완료
		
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