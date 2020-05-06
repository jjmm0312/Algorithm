import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] solution(String s) {
       		int[] answer;
		List<String> l = new LinkedList<String>();
		int size = 0;
		
		char[] charS = s.toCharArray();
		// { �� ������ index start. }�� ������ index ��. ó���� ���� ����.
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
        
		// input �ޱ� �Ϸ�.
		
		// size 0 ���� ��������
		// size 1���� �ԷµȰ� ���� ��������.
		// size 2���� �ԷµȰ� ���� ��������.
		
		answer = new int[size];
		String[][] sizeArr = new String[size+1][size+1];
		for(int i=0; i<size; i++) {
			sizeArr[l.get(i).split(",").length] = l.get(i).split(",");
		}
		
		// �׷��� ���� 1 array �� ����� 1���ΰ�.
		
		for(int i = 1; i<size+1; i++) {
			// i�� ������ �Դϴ�. ���� i����� ���� �־��.
			int finalInt = 0;
			for(int j=0; j<i; j++) {
				String currentChar = sizeArr[i][j]; // ���� ����� �ִ� j��° ��� �Դϴ�.
				//System.out.println(currentChar);
				int check = 0; // ��ζ� ��ġ���� ������ ����.
				int currentInt = Integer.valueOf(currentChar);
				for(int k=0;k<answer.length;k++) {
					if(currentInt == answer[k]) {
						check = 1;// ������ ������ ��������....
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