/////////////////////////////////////////////////////////////////////////////////////////////
// �⺻ �����ڵ�� ���� �����ص� ���� �����ϴ�. ��, ����� ���� ����
// �Ʒ� ǥ�� ����� ���� �ʿ�� �����ϼ���.
// ǥ�� �Է� ����
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int ���� 1�� �Է¹޴� ����
// b = sc.nextDouble();                        // double ���� 1�� �Է¹޴� ����
// g = sc.nextByte();                          // char ���� 1�� �Է¹޴� ����
// var = sc.next();                            // ���ڿ� 1�� �Է¹޴� ����
// AB = sc.nextLong();                         // long ���� 1�� �Է¹޴� ����
/////////////////////////////////////////////////////////////////////////////////////////////
// ǥ�� ��� ����
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int ���� 1�� ����ϴ� ����
//System.out.println(b); 		       						 // double ���� 1�� ����ϴ� ����
//System.out.println(g);		       						 // char ���� 1�� ����ϴ� ����
//System.out.println(var);		       				   // ���ڿ� 1�� ����ϴ� ����
//System.out.println(AB);		       				     // long ���� 1�� ����ϴ� ����
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */

class EX1
{static int num;
static int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
static int dy[] = { 0, 1, -1, -1, 1, -1, 0, 1 };
static int map[][];
static boolean check[][];

static void solution(int x,int y) {
    check[x][y]=true;
    for(int i=0;i<8;i++) {
        // �ֺ� ĭ�� �湮���� ���� 0�� ��� �ش� ĭ�� solution ���� 
        if(map[x+dx[i]][y+dy[i]]==0&&!check[x+dx[i]][y+dy[i]]) {
            solution(x+dx[i],y+dy[i]);
        }
        // 0�� �ֺ� ĭ�� ������ ��� �湮 ó��
        else if(map[x+dx[i]][y+dy[i]]!=-1&&map[x+dx[i]][y+dy[i]]!=99&&!check[x+dx[i]][y+dy[i]]) {
            check[x+dx[i]][y+dy[i]]=true;
        }
    }
}

public static void main(String[] args) throws Exception{		
	System.setIn(new FileInputStream("input (4).txt"));
    Scanner scan = new Scanner(System.in);
    int T = scan.nextInt();
    for (int test_case = 1; test_case <= T; test_case++) {
        num = 0;
        int N = scan.nextInt();
        map = new int[N + 2][N + 2];
        check = new boolean[N + 2][N + 2];
        
        //////////////////// 1 �Է¹ޱ� ///////////////////////////
        for (int i = 0; i <= N + 1; i++) {
            String str="";
            if(i!=0&&i!=N+1) {
                str=scan.next();
            }
            for (int j = 0; j <= N + 1; j++) {
                if (i == 0 || i == N + 1 || j == 0 || j == N + 1) {
                    map[i][j] = -1; // �� �ٱ�
                } else {
                    if(str.charAt(j-1)=='.') {
                        map[i][j]=1;
                    }else {
                        map[i][j]=99; // ����
                    }
                }
            }
        }
        //////////////////// 2 �ֺ� ���� ���� ���� ///////////////////////////
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(map[i][j]==1) {
                    int count=0;
                    for(int k=0;k<8;k++) {
                        if(map[i+dx[k]][j+dy[k]]==99) {
                            count++;
                        }
                    }
                    map[i][j]=count;
                }
            }
        }
        //////////////////// 3 0�� ���� ó���ϱ� ///////////////////////////
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(map[i][j]==0&&!check[i][j]) {
                    solution(i,j);
                    num++;
                }
            }
        }
        //////////////////// 4 �����ִ� ���ڵ� ó���ϱ� ///////////////////////////
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(map[i][j]!=0&&map[i][j]!=-1&&map[i][j]!=99&&!check[i][j]) {
                    num++;
                }
            }
        }
        System.out.printf("#%d %d\n",test_case,num);
    }
}}