import java.util.Scanner;

public class Practice2 {
	
	public static void main(String[] args) {
		// 자물쇠 N * N
		// 열쇠는 M * M
		// 자물쇠에는 홈이 있고
		// 열쇠도 홈과 돌기가 있고, 회전과 이동이 가능
		// 홈에 돌기를 딱 맞추면 열림
		// 자물쇠의 홈을 모두 채워야함.
		// 돌기와 돌기가 만나면 안됨.
		// 열수 있으면 true, 열수 없으면 false
		// 0은 홈, 1은 돌기
		int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
		int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};
		
		System.out.println(solution(key, lock));
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;
		
		// 키가 할 수 있는 행동
		// 90도 회전. * 4 번
		int N = lock.length;
		int M = key.length;
		// 위 아래 오른족 왼쪽 이동하기.
		for(int i = 0; i<4; i++) {
			int[][] currentkey = new int[M][M];
			// 90 도씩 회전하면 인덱스가 바뀐다.
			if(i == 0) {
				for(int k = 0; k<M; k++) {
					for(int j = 0; j<M; j++) {
						currentkey[k][j] = key[k][j];
					}
				}
			} else if(i == 1) {
				int x = 0; 
				int y = M-1;
				for(int k = 0; k<M; k++) {
					for(int j = 0; j<M; j++) {
						currentkey[x][y] = key[k][j];
						x++;
					}
					x = 0;
					y = y-1;
				}
			} else if(i == 2) {
				int x = M-1; 
				int y = M-1;
				for(int k = 0; k<M; k++) {
					for(int j = 0; j<M; j++) {
						currentkey[x][y] = key[k][j];
						y--;
					}
					x = x-1;
					y = M-1;
				}
				
			} else if(i == 3) {
				int x = M-1; 
				int y = 0;
				for(int k = 0; k<M; k++) {
					for(int j = 0; j<M; j++) {
						currentkey[x][y] = key[k][j];
						x--;
					}
					x = M-1;
					y = y+1;;
				}
			}
			
			// 이 모양을 전체에 갖다대보기.
			// currentkey 를 전체 모양에 갖다대보자.
			
			int holenum = 0;
			int[][] solvelock = new int[N+((M-1)*2)][N+((M-1)*2)];
			// KEY 여백 포함해서 새로운 자물쇠 만들고.
			for(int j = M-1; j<=M-1+N-1; j++) {
				for(int k = M-1; k<=M-1+N-1; k++) {
					if(lock[j-(M-1)][k-(M-1)] == 0) holenum++; // 자물쇠의 홈 개수
					solvelock[j][k] = lock[j-(M-1)][k-(M-1)];
				}
			}
			
			int curx = 0;
			int cury = 0;
			
			boolean breaks = false;
			for(int v = 0; v<=M-1+N-1; v++) {
				for(int w=0; w<=M-1+N-1; w++) {
					// 이번 위치에서의 열쇠와 만나는 자리 모두 검사할 것이다.
					int success = 0; // 총 홈을 맞춘 개수
					breaks = false; // 중간에 고장났는지 안났는지. 고장났으면 중간에서 브레이크 걸어서 넘어갈거임.
					
					for(int j = 0; j<M; j++) {
						if(breaks) break;
						for(int k=0; k<M; k++) {
							if(breaks) break;
								if(currentkey[j][k] == 1 && solvelock[curx+j][cury+k] == 1) {
									breaks = true; // 돌기끼리 부딪혔음. 
								}else if(curx + j >= M-1 && curx + j <= M-1+N-1 && cury + k <= M-1+N-1 && cury+k >= M-1 ) { 
									// 임시 줄은 상관없고!
									if(solvelock[curx+j][cury+k] == 0 && currentkey[j][k] == 0) {
										// 홈이 안맞춰지면
									}else if(solvelock[curx+j][cury+k] == 1 && currentkey[j][k] == 0) {
										// 홈이 안맞춰지면
									} else {
										// 홈이 맞춰지면
										success++;
									}
								}	
						}
					}
					
					if(success == holenum) return true; // 홈이 다 맞춰졌으면 성공.
					
					// curx, cury 이동시킬 시간.
					cury++;
				}
				cury = 0;
				curx++;
			}
		}
		return answer;
	}

}
