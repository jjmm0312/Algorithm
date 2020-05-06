import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EX1 {

	static int R, C;
	static int[][] graph; // 주어진 그래프
	static boolean[][] visited; // 방문했나 안했나
	static int count = 0;
	static Queue<String> queue = new LinkedList<String>();
	static LinkedList<Character> myList = new LinkedList<Character>();
	static LinkedList<Integer> sizeArr;
	static boolean[] check = new boolean[26];
	static int ans = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String line = in.nextLine();
		String[] splitStrings = line.split(" ");

		R = Integer.valueOf(splitStrings[0]); // 세로줄 개수
		C = Integer.valueOf(splitStrings[1]); // 가로줄 개수

		graph = new int[R][C];

		for (int i = 0; i < R; i++) {
			line = in.nextLine();
			for (int j = 0; j < C; j++) {
				graph[i][j] = line.charAt(j)-'A';
			}
		}
		// input finish.

		sizeArr = new LinkedList<>();
		dfs(0, 0, 0);

		//sizeArr.sort(null);
		System.out.println(ans);
		in.close();
	}

	public static void dfs(int j, int k, int num) {

		if (check[graph[j][k]]) { // 0,0에 저장된 알파벳이 이미 한번 방문한 알파벳이라면,
			//sizeArr.add(num);// 정답을 갱신해준다.
			ans = Math.max(ans, num); // 정답을 갱신해준다.
			return; // 조건에 만족하므로 리턴.
		} else {

			check[graph[j][k]] = true;
			if (j - 1 >= 0) {
				dfs(j - 1, k, num + 1);
			}
			if (j + 1 < R) {
				dfs(j + 1, k, num + 1);
			}
			if (k + 1 < C) {
				dfs(j, k + 1, num + 1);
			}
			if (k - 1 >= 0) {
				dfs(j, k - 1, num + 1);
			}

			check[graph[j][k]] = false;
		}
	}
}