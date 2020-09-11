import java.util.Scanner;

public class Practice2 {
	
	public static void main(String[] args) {
		// () 개수 맞으면 균형잡힌 괄호 문자열
		// () 개수랑 짝도 맞으면 올바른 괄호 문자열
		// 균형잡힌 문자열을 보내면
		// 올바른 괄호 문자열로 변환하시오.
		// 이미 올바른 괄호 문자열이면 그대로 return.
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
		// p 가 들어오면
		// ()))((()
		char[] chararr = p.toCharArray(); // ( ) ) ) ( ( ( ) 인데.
		int chknum = 0;
		boolean correct = false;
		if(chararr[0] == '(') {
			chknum--;
			correct = true;
		} else {
			chknum++;
		}
		// ( 은 -1 ) 은 +1
		int i = 1; // 현재 인덱스
		while(chknum != 0) {
			//System.out.println(chknum);
			if(chararr[i] == '(') {
				chknum--;
			} else {
				chknum++;
			}
			i++;
		}
		
		// 0 - (i-1) 까지 u 고
		// i - 끝까지 v
		
		if(correct == true) {
			answer = p.substring(0, i) + check(p.substring(i, p.length()));
		} else {
			// p.substring을 원래대로 돌려놔야한다!
			// 0 부터 i-1 까지!
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
		
		// u, v 로 분리.
		// u는 조건 수행하고
		// 뒤에 check (v)를 붙일 것임...
		// check(v)
		//System.out.println("answer : "+answer);
		return answer;
		
	}
}
