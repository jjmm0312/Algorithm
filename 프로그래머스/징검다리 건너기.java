/*
 * Solution #1 이분 탐색
class Solution {
    public int solution(int[] stones, int k) {
    	int answer = 0;
    
    	int start = Arrays.stream(stones).min().getAsInt();
    	int end = Arrays.stream(stones).max().getAsInt();
    	// start , end => 최소, 최대.
    	
    	while(start <= end) {
     		int mid = (end+start) / 2;
    		// 최소, 최대의 중간으로 시작할게요.
    		
    		if(cross(mid, stones.clone(), k)) { // 검사해보고 가능하다!
    			answer = Math.max(answer, mid); // 답중에 큰 거를 고르기. 최대 프렌즈가 건너야해서.
    			start = mid+1; // 그리고 더 큰수를 검사해봐야 해요. 그러니깐 시작은 중간보다 큰수로!
    		}else { // 실패했어요...
    			end = mid - 1; // 현재보다 더 작은수를 골라야 합니다.. 끝을 작은쪽으로 가져오세요. 
    		}
    	}
    	return answer;
    }
    
    // 건널 수 있나 없나 확인해볼게요!
    public boolean cross(int mid, int[] stones, int k) {
    	for(int i=0; i<stones.length; i++)
    		stones[i] -= mid;
    	// 지금 mid 만큼의 친구들이 건넌 상태라서, 돌들의 숫자를 다 줄여줄게요.
    	
    	int check = 0;
    	// 몇개의 0 징검다리가 연속되느냐?
    	
    	for(int i=0; i<stones.length; i++) {
    		if(stones[i] < 0) { // 0보다 작으면 건널수가 없어...
    			check++;
    			if(check >= k) {
    				return false; // k개 이상 0보다 작았으니 건널 수가.. 없어요..
    			}
    		}
    		else { // 0보다 크다! 그러면 연속되는 징검다리 0개! 
    			check = 0;
    		}
    	}
    	return true;
    }
}
*/


// Solution #2
class Solution {
    public int solution(int[] stones, int k) {

        // 나의 왼쪽을 확인할거예요!
        int i = 0;
        int min = Integer.MAX_VALUE;
        while(i <= stones.length - k) {
            // 이 집합에서 가장 숫자가 큰 애를 찾을거예요~
            int max = stones[i];
    		int index = 0;
    		
    		for(int j=i+1; j<i+k; j++) { // k만큼의 구간을 탐색. 
    			if(stones[j] >= max) {
    				index = j;
    				max = stones[j];
    			}
    		}
    		
    		if(index == 0) // 전부 다 돌았는데 첫번째 애가 최댓값이야...
    			i += 1;
    		else // 아니면 최댓값 다음으로 이동시킵니다~
    			i = index+1;
    		
    		min = Math.min(min, max);
        }       
        return min;
    }
}