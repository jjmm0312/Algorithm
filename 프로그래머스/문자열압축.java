class Solution {
    public int solution(String s) {
        char[] str = s.toCharArray();
        int min = s.length();
        for(int i=1; i<=s.length()/2; i++) {

    		int check = 0;
        	int size = 1;
        	int length = 0;// i개 압축시 길이.
        	char[] Acompare = new char[i]; // 요기에다가 a, b 담고 비교.
        	char[] Bcompare = new char[i];
        	for(int j=0; j<i; j++)  Acompare[j] = str[j]; // 초기값 저장.
			length = i;
			
			
        	for(int j = i; j<s.length(); j++) {// str[j] : j번째 글자를 탐색중입니다~
        		if(s.length() % i != 0 && j + i - j%i > s.length()){ // 여기는 i개가 채워지지 않는 마지막 묶음.
        			length++;
        		}
        		else {
        			Bcompare[j%i] = str[j]; 
        			int chk = 0; // 같은가 0 or 다른가 1
        			for(int k=0; k<i; k++) {
        				if(Acompare[k] != Bcompare[k]) {
        					chk = 1; 
        					break;
        				}
        			}
    			
	    			if(j%i == i-1) {
	    	        	if(check == 0) {// 처음 체크할 값을 넣는 과정입니다.~		
		        			if(chk == 0) {// 같아요 그러면 축소합니다.
		        				length = length + 1; // 숫자 추가 , 문자열 감소.
		        				size+=1;
		        				check = 1;
		        			}else if(chk == 1) {// 다릅니다 그러면 실패...
		        				Acompare = Bcompare.clone(); // A는 B로 바꿔주고. B에 새로 넣을것임.
		        				length = length + i;
		        			}
		        		}else if(check == 1) {// 앞에서 이미 넣은 경우야 3번쨰 경우인셈이지.
		        			if(chk == 0) {
		        				size+=1;// 같아요 그러면 아무것도 안해. 
		        				if(size == 10)
		        					length += 1;
		        				else if(size == 100)
		        					length += 1;
		        				else if(size == 1000)
		        					length+=1;
		        			}else if(chk == 1) {// 다릅니다 그러면 실패...
		        				Acompare = Bcompare.clone(); // A는 B로 바꿔주고. B에 새로 넣을것임.
		        				length = length + i;
		        				size = 1;
		        				check = 0;
		        			}
		        		}
	    			}	
        		}
        	}
        	min = Math.min(min, length);
        }
        return min;
    }
}