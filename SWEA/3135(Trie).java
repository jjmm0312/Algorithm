import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.InputStream;

public class EX1 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);

		UserSolution dictManager = new UserSolution();
		
		for (int TestCase = in.nextInt(), tc = 1; tc <= TestCase; tc = tc + 1) {

			int Query_N = in.nextInt();

			out.print("#" + tc);

			dictManager.init();

			for (int i = 1; i <= Query_N; i++) {
				int type = in.nextInt();

				if (type == 1) {
					String buf = in.next();
					dictManager.insert(buf.length(), buf);
				}
				else {
					String buf = in.next();
					int answer = dictManager.query(buf.length(), buf);
					out.print(" " + answer);
				}
			}
			out.println("");
		}
		out.close();
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				}
				catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}
	
	 static class UserSolution {
		
		static String[] l;
		static int size;
		Trie trie;
		void init() {
			trie = new Trie();
		}
		
		void insert(int buffer_size, String buf) {
			TrieNode thisNode = trie.rootNode;
			for(int i = 0; i<buffer_size; i++) {
				// 있으면 가져오고 있는거 반환하고 없으면 새로 붙이고 반환하고.
				thisNode = thisNode.getChildNodes().computeIfAbsent(buf.charAt(i), c->new TrieNode());
				thisNode.num++;
			}
			thisNode.setIsLastChar(true); //여기까지가 끝인 단어가 존재합니다.
		}
		
		int query(int buffer_size, String buf) {

			TrieNode thisNode = trie.rootNode;
			for(int i=0; i<buffer_size; i++) {
				char character = buf.charAt(i);
				TrieNode node = thisNode.getChildNodes().get(character);
				if(node == null)
					return 0;
				thisNode = node;
			}
			return thisNode.num;	
		}
}
	 
	 public static class TrieNode{
		 private Map<Character, TrieNode> childNodes = new HashMap<>();
		 private boolean isLastChar;
		 public int num = 0;
		 
		 Map<Character, TrieNode> getChildNodes() {
			 return this.childNodes;
			 }
			 boolean isLastChar() {
				 return this.isLastChar;
			 }
			 void setIsLastChar(boolean isLastChar) {
				 this.isLastChar = isLastChar;
			 }
	 }
	 

	 public static class Trie {
		private TrieNode rootNode;
		Trie(){
			rootNode = new TrieNode();
		}
	 }
}
