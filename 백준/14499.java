import java.util.Scanner;

public class Practice2 {

   // N*M 지도
   // 좌표는 r,c
   // r 은 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로부터 떨어진 칸의 개수
   
   // 윗면이 1이고, 동쪽이 3
   // 좌표는 x, y 처음엔 모든면이 0
   // 0이면 바닥이 복사되고 바닥은 0 만든다.
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt(); // 세로
      int M = sc.nextInt(); // 가로
      int x = sc.nextInt(); 
      int y = sc.nextInt();
      int k = sc.nextInt(); // 명령의 개수
      
      //마지막 줄은 이동 명령
      // 동 1 서 2 북 3 남 4
      // 이동할 때 마다 주사위 윗면의 수를 출력하세요. 바깥으로 이동하려고 하면 무시!
      
      int[][] map = new int[N][M];
      for(int i=0; i<N; i++) {
         for(int j=0; j<M; j++) {
            map[i][j] = sc.nextInt();
         }
      }
      
      int[] command = new int[k];
      for(int i = 0; i<k; i++) {
         command[i] = sc.nextInt();
      }
      
      // 주사위
      //   2(0,1)
      // 4(1,0) 1(1,1) 3(1,2)
      //   5(2,1)
      //   6(3,1)
      
      int[][] dice = new int[4][3];
      
      
      // 현재좌표는 x, y
      for(int i=0; i<k; i++) {
         // 이동했는데, 칸이 0이면 바닥이 칸으로
         // 아니면, 칸이 주사위로, 칸 수는 0
    	  
    	  
         // 1 : 동
         if(command[i] == 1) {
        	if(y < M-1) {
        		y = y+1; // 동쪽으로 이동.
        		
        		// 오른쪽으로 구르기.
            	int a = dice[1][0];
            	int b = dice[1][1];
            	int c = dice[1][2];
            	int d = dice[3][1]; // 현재 바닥
            	
            	dice[1][1] = a;
            	dice[1][2] = b;
            	dice[3][1] = c;
            	dice[1][0] = d;
            	
            	// 바닥은 3, 1
            	if(map[x][y] == 0) {
            		// 아니면 바닥으로 복사.
            		map[x][y] = dice[3][1];
            	} else {
            		dice[3][1] = map[x][y];
            		map[x][y] = 0;
            	}

                System.out.println(dice[1][1]);
        	}      
         }
         // 2 : 서 
         else if(command[i] == 2) {
        	 if(y > 0) {
         		y = y-1; // 서쪽으로 이동.
         		
         		// 오른쪽으로 구르기.
             	int a = dice[1][0];
             	int b = dice[1][1];
             	int c = dice[1][2];
             	int d = dice[3][1]; // 현재 바닥
             	
             	dice[1][1] = c;
             	dice[1][2] = d;
             	dice[3][1] = a;
             	dice[1][0] = b;
             	
             	// 바닥은 3, 1
          	if(map[x][y] == 0) {
        		// 바닥으로 복사.
        		map[x][y] = dice[3][1];
        	} else {
        		dice[3][1] = map[x][y];
        		map[x][y] = 0;
        	}

            System.out.println(dice[1][1]);
        	 }      

         }
         // 3 : 북
         else if(command[i] == 3) {
        	 if(x > 0) {
         		x = x-1; // 위쪽으로 이동.
         		
         		// 오른쪽으로 구르기.
             	int a = dice[0][1];
             	int b = dice[1][1];
             	int c = dice[2][1];
             	int d = dice[3][1]; // 현재 바닥
             	
             	dice[0][1] = b;
             	dice[1][1] = c;
             	dice[2][1] = d;
             	dice[3][1] = a;
             	
             	// 바닥은 3, 1
          	if(map[x][y] == 0) {
        		// 바닥으로 복사.
        		map[x][y] = dice[3][1];
        	} else {
        		dice[3][1] = map[x][y];
        		map[x][y] = 0;
        	}

            System.out.println(dice[1][1]);             	
         	}  

         }
         // 4 : 남   
         else {
        	 if(x < N-1) {
          		x = x+1; // 아래쪽으로 이동.
          		
          		// 오른쪽으로 구르기.
              	int a = dice[0][1];
              	int b = dice[1][1];
              	int c = dice[2][1];
              	int d = dice[3][1]; // 현재 바닥
              	
              	dice[0][1] = d;
              	dice[1][1] = a;
              	dice[2][1] = b;
              	dice[3][1] = c;

              	// 바닥은 3, 1
          	if(map[x][y] == 0) {
        		// 바닥으로 복사.
        		map[x][y] = dice[3][1];
        	} else {
        		dice[3][1] = map[x][y];
        		map[x][y] = 0;
        	}

            System.out.println(dice[1][1]);
          	}  
        	
         }
      }
   }

}