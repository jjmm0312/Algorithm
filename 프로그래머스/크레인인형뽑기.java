class Solution {    
    public int solution(int[][] board, int[] moves) {
        int[] bucket = new int[moves.length]; // 바구니 입니다.
        int answer = 0;
        int cursor = 0; // 크레인 어디 고를위치인지.
        int doll = 0;
        while(cursor != moves.length){ // 다 빠질때까지.
            int current = moves[cursor]; // 내가 현재 뽑을 줄.
            int size = 0; // 내가 뽑을 줄의 사이즈.
            for(int i=0; i<board.length; i++){
                if(board[i][current-1] != 0){
                    size = board.length - i;
                    break;
                }
            }
            
            if(size != 0) {
                doll = board[board.length-size][current-1]; // 지금 뽑은 아이.
                board[board.length-size][current-1]=0; // 이제 없어.
                
                int bucketsize = 0;
                for(int i=0; i<bucket.length; i++){
                    if(bucket[i] == 0){
                        bucketsize = i;
                        break;
                    }
                }
                
                bucket[bucketsize] = doll; // 바구니에인형을담았다!
                
                
          
                // 이제 두개가 겹칠 경우를 고려하자. 개수가 두개 이상일때만 검사함.
                if(bucketsize >0){
                if(bucket[bucketsize-1] == bucket[bucketsize]){
                    bucket[bucketsize-1] = 0;
                    bucket[bucketsize] = 0;
                    // 두개는 사라지고.
                    answer = answer+2; //사라진 개수를 더할거야.
                } 
                }
                
            }
            
            cursor = cursor + 1;
        }
        return answer;
    }
}