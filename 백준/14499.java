import java.util.Scanner;

public class Practice2 {

   // N*M ����
   // ��ǥ�� r,c
   // r �� �������κ��� ������ ĭ�� ����, c�� �������κ��� ������ ĭ�� ����
   
   // ������ 1�̰�, ������ 3
   // ��ǥ�� x, y ó���� ������ 0
   // 0�̸� �ٴ��� ����ǰ� �ٴ��� 0 �����.
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt(); // ����
      int M = sc.nextInt(); // ����
      int x = sc.nextInt(); 
      int y = sc.nextInt();
      int k = sc.nextInt(); // ����� ����
      
      //������ ���� �̵� ���
      // �� 1 �� 2 �� 3 �� 4
      // �̵��� �� ���� �ֻ��� ������ ���� ����ϼ���. �ٱ����� �̵��Ϸ��� �ϸ� ����!
      
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
      
      // �ֻ���
      //   2(0,1)
      // 4(1,0) 1(1,1) 3(1,2)
      //   5(2,1)
      //   6(3,1)
      
      int[][] dice = new int[4][3];
      
      
      // ������ǥ�� x, y
      for(int i=0; i<k; i++) {
         // �̵��ߴµ�, ĭ�� 0�̸� �ٴ��� ĭ����
         // �ƴϸ�, ĭ�� �ֻ�����, ĭ ���� 0
    	  
    	  
         // 1 : ��
         if(command[i] == 1) {
        	if(y < M-1) {
        		y = y+1; // �������� �̵�.
        		
        		// ���������� ������.
            	int a = dice[1][0];
            	int b = dice[1][1];
            	int c = dice[1][2];
            	int d = dice[3][1]; // ���� �ٴ�
            	
            	dice[1][1] = a;
            	dice[1][2] = b;
            	dice[3][1] = c;
            	dice[1][0] = d;
            	
            	// �ٴ��� 3, 1
            	if(map[x][y] == 0) {
            		// �ƴϸ� �ٴ����� ����.
            		map[x][y] = dice[3][1];
            	} else {
            		dice[3][1] = map[x][y];
            		map[x][y] = 0;
            	}

                System.out.println(dice[1][1]);
        	}      
         }
         // 2 : �� 
         else if(command[i] == 2) {
        	 if(y > 0) {
         		y = y-1; // �������� �̵�.
         		
         		// ���������� ������.
             	int a = dice[1][0];
             	int b = dice[1][1];
             	int c = dice[1][2];
             	int d = dice[3][1]; // ���� �ٴ�
             	
             	dice[1][1] = c;
             	dice[1][2] = d;
             	dice[3][1] = a;
             	dice[1][0] = b;
             	
             	// �ٴ��� 3, 1
          	if(map[x][y] == 0) {
        		// �ٴ����� ����.
        		map[x][y] = dice[3][1];
        	} else {
        		dice[3][1] = map[x][y];
        		map[x][y] = 0;
        	}

            System.out.println(dice[1][1]);
        	 }      

         }
         // 3 : ��
         else if(command[i] == 3) {
        	 if(x > 0) {
         		x = x-1; // �������� �̵�.
         		
         		// ���������� ������.
             	int a = dice[0][1];
             	int b = dice[1][1];
             	int c = dice[2][1];
             	int d = dice[3][1]; // ���� �ٴ�
             	
             	dice[0][1] = b;
             	dice[1][1] = c;
             	dice[2][1] = d;
             	dice[3][1] = a;
             	
             	// �ٴ��� 3, 1
          	if(map[x][y] == 0) {
        		// �ٴ����� ����.
        		map[x][y] = dice[3][1];
        	} else {
        		dice[3][1] = map[x][y];
        		map[x][y] = 0;
        	}

            System.out.println(dice[1][1]);             	
         	}  

         }
         // 4 : ��   
         else {
        	 if(x < N-1) {
          		x = x+1; // �Ʒ������� �̵�.
          		
          		// ���������� ������.
              	int a = dice[0][1];
              	int b = dice[1][1];
              	int c = dice[2][1];
              	int d = dice[3][1]; // ���� �ٴ�
              	
              	dice[0][1] = d;
              	dice[1][1] = a;
              	dice[2][1] = b;
              	dice[3][1] = c;

              	// �ٴ��� 3, 1
          	if(map[x][y] == 0) {
        		// �ٴ����� ����.
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