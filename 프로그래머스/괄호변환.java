import java.util.Scanner;

public class Practice2 {
	
	public static void main(String[] args) {
		// () ���� ������ �������� ��ȣ ���ڿ�
		// () ������ ¦�� ������ �ùٸ� ��ȣ ���ڿ�
		// �������� ���ڿ��� ������
		// �ùٸ� ��ȣ ���ڿ��� ��ȯ�Ͻÿ�.
		// �̹� �ùٸ� ��ȣ ���ڿ��̸� �״�� return.
		String p ="()))((()";
		System.out.println(solution(p));
	
	}
	
	public static String solution(String p) {
		String answer = "";
		return check(p);
	}
	
	public static String check(String p) {
		//System.out.println("thisp : " +p);
		String answer = "";
		if(p.equals("")) {
			return "";
		}
		// p �� ������
		// ()))((()
		char[] chararr = p.toCharArray(); // ( ) ) ) ( ( ( ) �ε�.
		int chknum = 0;
		boolean correct = false;
		if(chararr[0] == '(') {
			chknum--;
			correct = true;
		} else {
			chknum++;
		}
		// ( �� -1 ) �� +1
		int i = 1; // ���� �ε���
		while(chknum != 0) {
			//System.out.println(chknum);
			if(chararr[i] == '(') {
				chknum--;
			} else {
				chknum++;
			}
			i++;
		}
		
		// 0 - (i-1) ���� u ��
		// i - ������ v
		
		if(correct == true) {
			answer = p.substring(0, i) + check(p.substring(i, p.length()));
		} else {
			// p.substring�� ������� ���������Ѵ�!
			// 0 ���� i-1 ����!
			char[] changearr = new char[i];
			//changearr[0] = '(';
			//changearr[i-1] = ')';
			
			for(int j=1; j<i-1; j++) {
				changearr[j] = chararr[j] == '('? ')':'(';
			}
			
			answer = "(" + check(p.substring(i, p.length())) + ")" + String.valueOf(changearr).substring(1,i-1);
			//System.out.println(String.valueOf(changearr));
			//System.out.println("answer 1 : " + answer);
		}
		
		// u, v �� �и�.
		// u�� ���� �����ϰ�
		// �ڿ� check (v)�� ���� ����...
		// check(v)
		//System.out.println("answer : "+answer);
		return answer;
		
	}
}
