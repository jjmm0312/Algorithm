import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

		class Solution {
			String[] user_id;
			String[] banned_id;
			boolean[] visited;
			boolean[] checkk;
			int answer;
			// ���� ����� ���⿡ ����.
			HashSet<HashSet> hs;
			
		    public int solution(String[] user_id, String[] banned_id) {
		        answer = 0;
		        this.user_id = user_id;
		        this.banned_id = banned_id;
		        
		        hs = new HashSet();
	    		String[] out = new String[banned_id.length];
	    		visited = new boolean[banned_id.length];
	    		checkk = new boolean[user_id.length];
		        
		        combination(0,0,out);
		       answer = hs.size();
		        return answer;
		    }
		   
		    // ���� ��� ������ ���ž� �̤�... ..... ......
		    public void combination(int i, int size, String[] out) {
		    
		    	if(size == banned_id.length)
		    	{
		    		for(int j=0; j<banned_id.length; j++) {
		    			//System.out.print(out[j]);
		    		}
		    		//System.out.println();
		    		
		    		// out �� banned_id�� �ϳ��� ���غ�����.
		    		for(int j = 0; j<banned_id.length; j++) {
		    			for(int k = 0; k<banned_id.length; k++) {
		    				if(out[j].length() == banned_id[k].length() && visited[k] != true && compare(out[j], banned_id[k])==1) {
		    					// ��ġ�մϴ�.
		    					visited[k] = true;
		    					break;
		    				}
		    			}
		    		}
		    		
		    		for(int j=0; j<banned_id.length; j++) {
		    			//System.out.print(visited[j]);
		    		}
		    		
		    		//System.out.println();
		    		int check = 0;
		    		for(int j=0; j<banned_id.length; j++) {
		    			if(visited[j] != true)
		    				check = 1;
		    		}
		    		if(check == 0){
		    			// �����̸� �ؽü¿� �����ž�.
		    			HashSet<String> hash = new HashSet();
		    			for(int k = 0; k<banned_id.length; k++) {
		    				hash.add(out[k]);
		    			}
		    			hs.add(hash);
		    		}
		    		
		    		for(int j=0; j<banned_id.length; j++) {
		    			visited[j] = false;
		    		}
		    		return;
		    	
		    	}
		    	
		    	for(int k=0; k<user_id.length; k++) {
		    		if(checkk[k] != true) {
		    			out[size] = user_id[k];
			    		checkk[k] = true;
				    	combination(k, size+1, out);
				    	checkk[k] = false;
			    	}
		    	}
		    	
		    	
		    }
		    
		    public int compare(String user_, String banned_) {
		    	// user �� banned �� ���������� Ȯ���غ��ô�!
		    	char[] user = user_.toCharArray();
		    	char[] banned = banned_.toCharArray();
		    	
		    	int check = 0;
		    	for(int i = 0; i<banned.length; i++) {
		    		// �� ���ھ� ���Ұſ���.
		    		if(banned[i] == '*')
		    			continue;
		    		else if(user[i] != banned[i]) {
		    			check = 1;
		    		}
		    	}
		    	if(check == 1)
		    		return 0; // �ٸ� ������!
		    	else
		    	{
		    		//System.out.print(user_);
		    		//System.out.println("  "+banned_);
		    		return 1; // ������ ���� �����Դϴ�.
		    	}
		    }
		}
