/*
 * Solution #1 �̺� Ž��
class Solution {
    public int solution(int[] stones, int k) {
    	int answer = 0;
    
    	int start = Arrays.stream(stones).min().getAsInt();
    	int end = Arrays.stream(stones).max().getAsInt();
    	// start , end => �ּ�, �ִ�.
    	
    	while(start <= end) {
     		int mid = (end+start) / 2;
    		// �ּ�, �ִ��� �߰����� �����ҰԿ�.
    		
    		if(cross(mid, stones.clone(), k)) { // �˻��غ��� �����ϴ�!
    			answer = Math.max(answer, mid); // ���߿� ū �Ÿ� ����. �ִ� ����� �ǳʾ��ؼ�.
    			start = mid+1; // �׸��� �� ū���� �˻��غ��� �ؿ�. �׷��ϱ� ������ �߰����� ū����!
    		}else { // �����߾��...
    			end = mid - 1; // ���纸�� �� �������� ���� �մϴ�.. ���� ���������� ����������. 
    		}
    	}
    	return answer;
    }
    
    // �ǳ� �� �ֳ� ���� Ȯ���غ��Կ�!
    public boolean cross(int mid, int[] stones, int k) {
    	for(int i=0; i<stones.length; i++)
    		stones[i] -= mid;
    	// ���� mid ��ŭ�� ģ������ �ǳ� ���¶�, ������ ���ڸ� �� �ٿ��ٰԿ�.
    	
    	int check = 0;
    	// ��� 0 ¡�˴ٸ��� ���ӵǴ���?
    	
    	for(int i=0; i<stones.length; i++) {
    		if(stones[i] < 0) { // 0���� ������ �ǳμ��� ����...
    			check++;
    			if(check >= k) {
    				return false; // k�� �̻� 0���� �۾����� �ǳ� ����.. �����..
    			}
    		}
    		else { // 0���� ũ��! �׷��� ���ӵǴ� ¡�˴ٸ� 0��! 
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

        // ���� ������ Ȯ���Ұſ���!
        int i = 0;
        int min = Integer.MAX_VALUE;
        while(i <= stones.length - k) {
            // �� ���տ��� ���� ���ڰ� ū �ָ� ã���ſ���~
            int max = stones[i];
    		int index = 0;
    		
    		for(int j=i+1; j<i+k; j++) { // k��ŭ�� ������ Ž��. 
    			if(stones[j] >= max) {
    				index = j;
    				max = stones[j];
    			}
    		}
    		
    		if(index == 0) // ���� �� ���Ҵµ� ù��° �ְ� �ִ��̾�...
    			i += 1;
    		else // �ƴϸ� �ִ� �������� �̵���ŵ�ϴ�~
    			i = index+1;
    		
    		min = Math.min(min, max);
        }       
        return min;
    }
}