class Solution {
    public int solution(String s) {
        char[] str = s.toCharArray();
        int min = s.length();
        for(int i=1; i<=s.length()/2; i++) {

    		int check = 0;
        	int size = 1;
        	int length = 0;// i�� ����� ����.
        	char[] Acompare = new char[i]; // ��⿡�ٰ� a, b ��� ��.
        	char[] Bcompare = new char[i];
        	for(int j=0; j<i; j++)  Acompare[j] = str[j]; // �ʱⰪ ����.
			length = i;
			
			
        	for(int j = i; j<s.length(); j++) {// str[j] : j��° ���ڸ� Ž�����Դϴ�~
        		if(s.length() % i != 0 && j + i - j%i > s.length()){ // ����� i���� ä������ �ʴ� ������ ����.
        			length++;
        		}
        		else {
        			Bcompare[j%i] = str[j]; 
        			int chk = 0; // ������ 0 or �ٸ��� 1
        			for(int k=0; k<i; k++) {
        				if(Acompare[k] != Bcompare[k]) {
        					chk = 1; 
        					break;
        				}
        			}
    			
	    			if(j%i == i-1) {
	    	        	if(check == 0) {// ó�� üũ�� ���� �ִ� �����Դϴ�.~		
		        			if(chk == 0) {// ���ƿ� �׷��� ����մϴ�.
		        				length = length + 1; // ���� �߰� , ���ڿ� ����.
		        				size+=1;
		        				check = 1;
		        			}else if(chk == 1) {// �ٸ��ϴ� �׷��� ����...
		        				Acompare = Bcompare.clone(); // A�� B�� �ٲ��ְ�. B�� ���� ��������.
		        				length = length + i;
		        			}
		        		}else if(check == 1) {// �տ��� �̹� ���� ���� 3���� ����μ�����.
		        			if(chk == 0) {
		        				size+=1;// ���ƿ� �׷��� �ƹ��͵� ����. 
		        				if(size == 10)
		        					length += 1;
		        				else if(size == 100)
		        					length += 1;
		        				else if(size == 1000)
		        					length+=1;
		        			}else if(chk == 1) {// �ٸ��ϴ� �׷��� ����...
		        				Acompare = Bcompare.clone(); // A�� B�� �ٲ��ְ�. B�� ���� ��������.
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