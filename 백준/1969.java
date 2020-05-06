import java.util.Scanner;

public class EX1 {

	 public static void main(String []args){
	        Scanner in = new Scanner(System.in);

	        int T = Integer.valueOf(in.nextLine()); // 테스트케이스의 수
	        int N, result;
	        int[] people;
	        int okay, check;
	        
	        for(int i=0; i<T; i++){ // 테스트 케이스의 수만큼
	            N = Integer.valueOf(in.nextLine()); // 지원자의 수import java.util.Scanner;

public class EX1 {

	 public static void main(String []args){
	        Scanner in = new Scanner(System.in);
	        
	                String line = in.nextLine();
	                String[] splitStrings = line.split(" ");

	                int N = Integer.valueOf(splitStrings[0]); // 총 DNA 개수
	                int M = Integer.valueOf(splitStrings[1]); // DNA 길이
	                
	                // WE HAVE TO FIND THE DNA STRING.
	                

	                String result = new String();
	                result = "";
	                int resultHam = 0;
	                
	                
	                int num[] = {0,0,0,0};
	                String[] str = new String[N];
	                for(int i=0; i<N; i++) {
	                	 str[i] = in.nextLine();
	                }
	                
	                for(int i=0; i<M; i++) {
	                	for(int j=0; j<4; j++) {
	                		num[j] = 0;
	                	}

	                	char current = 'T';
	                	for(int j=0; j<N; j++) {
	                		if(str[j].charAt(i)== 'T' ) {
	                			num[0]++;
	                		}else if(str[j].charAt(i)== 'A') {
	                			num[1]++;
	                		}else if(str[j].charAt(i)== 'G') {
	                			num[2]++;
	                		}else if(str[j].charAt(i)== 'C') {
	                			num[3]++;
	                		}
	                	}
	                	// T, A, G, C가 몇번 나왓는지 체크.
	                	int tmp = num[0];
	                	for(int j=1;j<4; j++) {
	                		if(tmp<num[j]) {
	                			tmp = num[j];
	                			if(j == 1) {
	                				current = 'A';
	                			}else if(j == 2) {
	                				current = 'G';
	                			}else if(j == 3) {
	                				current = 'C';
	                			}
	                			
	                		}else if(tmp == num[j]) {
	                			char news = 'T';
	                			if(j == 1) {
	                				news = 'A';
	                			}else if(j == 2) {
	                				news = 'G';
	                			}else if(j == 3) {
	                				news = 'C';
	                			}
	                			
	                			if((int)(current) > (int)(news) ) {
	                				current = news;
	                			}
	                		}
	                	}
	                	
	                	result = result + current; // 결과 dna 스트링
	                	int currentHam = N-tmp;
	                	resultHam = resultHam + currentHam;
	                	
	                }
	        System.out.println(result);
	        System.out.println(resultHam);
	        in.close();
	    } 
}
	            people = new int[N+1]; 
	            okay = 1;

	            for(int j=0; j<N; j++){
	                String line = in.nextLine();
	                String[] splitStrings = line.split(" ");

	                int index = Integer.valueOf(splitStrings[0]);
	                people[index]= Integer.valueOf(splitStrings[1]);
	                // 0에는 서류점수, 1에는 면접점수
	            }
	            
	            /*
	            for(int j=1; j<N-1; j++)
	            {
	            	check = 1;
	            	
	                for(int k=1; k<N; k++){
	                    if(people[j]>people[k]){
	 
	                        check = 0;
	                    }
	                }
	            	 
	            
	                if(check == 1){
	                    okay++;
	                }
	            }
*/
	            /*
	            for(int j=2; j<N+1; j++) {
	            	if(people[j]<people[1]) {
	            		okay++;
	            	}
	            }
	            */
	            int tmp = people[1];
	            for(int j=2; j<N; j++) {
	                             if(people[j]<tmp) {
	                                okay++;
	                                tmp = people[j];
	                             }
	                          }
	                          
	            System.out.println(okay);

	        }
	        in.close();
	    } 
}