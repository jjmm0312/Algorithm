import java.util.Scanner;

public class Practice2 {
	
	public static void main(String[] args) {
		// �ڹ��� N * N
		// ����� M * M
		// �ڹ��迡�� Ȩ�� �ְ�
		// ���赵 Ȩ�� ���Ⱑ �ְ�, ȸ���� �̵��� ����
		// Ȩ�� ���⸦ �� ���߸� ����
		// �ڹ����� Ȩ�� ��� ä������.
		// ����� ���Ⱑ ������ �ȵ�.
		// ���� ������ true, ���� ������ false
		// 0�� Ȩ, 1�� ����
		int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
		int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};
		
		System.out.println(solution(key, lock));
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;
		
		// Ű�� �� �� �ִ� �ൿ
		// 90�� ȸ��. * 4 ��
		int N = lock.length;
		int M = key.length;
		// �� �Ʒ� ������ ���� �̵��ϱ�.
		for(int i = 0; i<4; i++) {
			int[][] currentkey = new int[M][M];
			// 90 ���� ȸ���ϸ� �ε����� �ٲ��.
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
			
			// �� ����� ��ü�� ���ٴ뺸��.
			// currentkey �� ��ü ��翡 ���ٴ뺸��.
			
			int holenum = 0;
			int[][] solvelock = new int[N+((M-1)*2)][N+((M-1)*2)];
			// KEY ���� �����ؼ� ���ο� �ڹ��� �����.
			for(int j = M-1; j<=M-1+N-1; j++) {
				for(int k = M-1; k<=M-1+N-1; k++) {
					if(lock[j-(M-1)][k-(M-1)] == 0) holenum++; // �ڹ����� Ȩ ����
					solvelock[j][k] = lock[j-(M-1)][k-(M-1)];
				}
			}
			
			int curx = 0;
			int cury = 0;
			
			boolean breaks = false;
			for(int v = 0; v<=M-1+N-1; v++) {
				for(int w=0; w<=M-1+N-1; w++) {
					// �̹� ��ġ������ ����� ������ �ڸ� ��� �˻��� ���̴�.
					int success = 0; // �� Ȩ�� ���� ����
					breaks = false; // �߰��� ���峵���� �ȳ�����. ���峵���� �߰����� �극��ũ �ɾ �Ѿ����.
					
					for(int j = 0; j<M; j++) {
						if(breaks) break;
						for(int k=0; k<M; k++) {
							if(breaks) break;
								if(currentkey[j][k] == 1 && solvelock[curx+j][cury+k] == 1) {
									breaks = true; // ���Ⳣ�� �ε�����. 
								}else if(curx + j >= M-1 && curx + j <= M-1+N-1 && cury + k <= M-1+N-1 && cury+k >= M-1 ) { 
									// �ӽ� ���� �������!
									if(solvelock[curx+j][cury+k] == 0 && currentkey[j][k] == 0) {
										// Ȩ�� �ȸ�������
									}else if(solvelock[curx+j][cury+k] == 1 && currentkey[j][k] == 0) {
										// Ȩ�� �ȸ�������
									} else {
										// Ȩ�� ��������
										success++;
									}
								}	
						}
					}
					
					if(success == holenum) return true; // Ȩ�� �� ���������� ����.
					
					// curx, cury �̵���ų �ð�.
					cury++;
				}
				cury = 0;
				curx++;
			}
		}
		return answer;
	}

}
