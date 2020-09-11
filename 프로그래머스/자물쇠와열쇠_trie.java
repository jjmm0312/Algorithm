import java.util.HashMap;
import java.util.Scanner;

public class Practice2 {
	
	public static void main(String[] args) {
		String[] words = {"frodo",  "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		
		solution(words, queries);
	}
	 
	 public static int[] solution(String[] words, String[] queries) {
	        int[] answer = new int[queries.length];
	        
	        TrieNode[] prefixTrie = new TrieNode[10001]; // 각 길이마다 트라이 만들고.
	        TrieNode[] suffixTrie = new TrieNode[10001]; 
	        
	        for(int i=0; i<words.length; i++) {
	        	if(prefixTrie[words[i].length()] == null)	
	        		prefixTrie[words[i].length()] = new TrieNode(); // 루트 생성.
	        	if(suffixTrie[words[i].length()] == null)	
	        		suffixTrie[words[i].length()] = new TrieNode(); // 루트 생성.
	        	
	        	insert(prefixTrie[words[i].length()], words[i], 0, 0); // 바로도 넣고
	        	insert(suffixTrie[words[i].length()], words[i], words[i].length()-1, 1); // 거꾸로도 넣고
	        }
	        
	        // 다넣었으면 이제 찾기 한다.
	        for(int i=0; i<queries.length; i++) {
	        	number = 0;
	        	String word = queries[i];
	        	
	        	if(word.charAt(0) == '?') {
	        		// 첫번쨰가 ? 면 suffix
	        		//String rword = new StringBuffer(word).reverse().toString();
	        		if(suffixTrie[word.length()] != null) 
	        			search(suffixTrie[word.length()], word, word.length()-1, 1);
	        	} else {
	        		// 아니면 prefix
	        		if(prefixTrie[word.length()] != null) 
	        			search(prefixTrie[word.length()], word, 0, 0);
	        	}
	        	answer[i] = number;
	        }
	        
	        
	        for(int i=0; i<queries.length; i++) {

		        System.out.println(answer[i]);
	        }
	        
	        return answer;
	 }

	       
	 
	 public static void insert(TrieNode node, String s, int i, int flag) {
		 if(s.length() == i || i < 0) {
			 // 내가 마지막이면.
			 return;
		 }
		 
		 char c = s.charAt(i);
		 
		 if(!node.child.containsKey(c)) { // 처음 들어온애다.
			 node.child.put(c, new TrieNode());
		 }
		 
		 node.num++;
		 
		 if(flag == 0)
			 insert(node.child.get(c), s, i+1, flag);
		 else
			 insert(node.child.get(c), s, i-1, flag);
		 
		 
	 }
	 
	 public static int number = 0;
	 public static void search(TrieNode node, String s, int i, int flag) {
		 char c = s.toCharArray()[i];
		 
		 if(c == '?'){ // ? 면 끝
			 number = node.num;
			 return;
		 }
		 
		 if(s.length() == i || i < 0) {
			 number = node.num;
			 return;
		 }
		 
		 if(!node.child.containsKey(c)) {
			 number = 0;
			 return;
		 } 
		
		 if(flag == 0)
			 search(node.child.get(c), s, i+1, flag);
		 else
			 search(node.child.get(c), s, i-1, flag);
		 
		 
	 }
}


class TrieNode{
	HashMap<Character, TrieNode> child;
	int num = 0;
	public TrieNode() {
		this.child = new HashMap();
	}
}
