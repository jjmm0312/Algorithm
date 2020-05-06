class Solution {    
    public int solution(int[][] board, int[] moves) {
        int[] bucket = new int[moves.length]; // �ٱ��� �Դϴ�.
        int answer = 0;
        int cursor = 0; // ũ���� ��� ����ġ����.
        int doll = 0;
        while(cursor != moves.length){ // �� ����������.
            int current = moves[cursor]; // ���� ���� ���� ��.
            int size = 0; // ���� ���� ���� ������.
            for(int i=0; i<board.length; i++){
                if(board[i][current-1] != 0){
                    size = board.length - i;
                    break;
                }
            }
            
            if(size != 0) {
                doll = board[board.length-size][current-1]; // ���� ���� ����.
                board[board.length-size][current-1]=0; // ���� ����.
                
                int bucketsize = 0;
                for(int i=0; i<bucket.length; i++){
                    if(bucket[i] == 0){
                        bucketsize = i;
                        break;
                    }
                }
                
                bucket[bucketsize] = doll; // �ٱ��Ͽ���������Ҵ�!
                
                
          
                // ���� �ΰ��� ��ĥ ��츦 �������. ������ �ΰ� �̻��϶��� �˻���.
                if(bucketsize >0){
                if(bucket[bucketsize-1] == bucket[bucketsize]){
                    bucket[bucketsize-1] = 0;
                    bucket[bucketsize] = 0;
                    // �ΰ��� �������.
                    answer = answer+2; //����� ������ ���Ұž�.
                } 
                }
                
            }
            
            cursor = cursor + 1;
        }
        return answer;
    }
}