import java.util.Scanner;

public class EX1 {

	 public static void main(String []args){
	        Scanner in = new Scanner(System.in);

	        int T = Integer.valueOf(in.nextLine()); // 테스트케이스의 수
	        int N, result;
	        int[] people;
	        int okay, check;
	        
	        for(int i=0; i<T; i++){ // 테스트 케이스의 수만큼
	            N = Integer.valueOf(in.nextLine()); // 지원자의 수
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