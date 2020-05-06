import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] solution(String s) {
       		int[] answer;
		List<String> l = new LinkedList<String>();
		int size = 0;
		
		char[] charS = s.toCharArray();
		// { 가 나오면 index start. }가 나오면 index 끝. 처음과 끝은 빼고.
		int start = 0, end = 0;
		for(int i=1; i<charS.length-1; i++) {
			if(charS[i] == '{') {
				start = i+1;
			}
			else if(charS[i] == '}') {
				end = i;
				l.add(s.substring(start, end));
				size++;
			}
		}
        
		// input 받기 완료.
		
		// size 0 에서 가져오고
		// size 1에서 입력된거 빼고 가져오고.
		// size 2에서 입력된거 빼고 가져오고.
		
		answer = new int[size];
		String[][] sizeArr = new String[size+1][size+1];
		for(int i=0; i<size; i++) {
			sizeArr[l.get(i).split(",").length] = l.get(i).split(",");
		}
		
		// 그러면 이제 1 array 는 사이즈가 1개인것.
		
		for(int i = 1; i<size+1; i++) {
			// i는 사이즈 입니다. 현재 i사이즈를 돌고 있어요.
			int finalInt = 0;
			for(int j=0; j<i; j++) {
				String currentChar = sizeArr[i][j]; // 현재 사이즈에 있는 j번째 요소 입니다.
				//System.out.println(currentChar);
				int check = 0; // 모두랑 일치하지 않으면 저장.
				int currentInt = Integer.valueOf(currentChar);
				for(int k=0;k<answer.length;k++) {
					if(currentInt == answer[k]) {
						check = 1;// 같은게 있으면 나가세요....
					}
				}
				
				if(i == 1)
					finalInt = currentInt;
				else if(check == 0)
					finalInt = currentInt;
			}
				answer[i-1] = finalInt;
			
			
		}
		return answer;
    }
}