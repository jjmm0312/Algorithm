import java.util.Scanner;

public class Main{
    public static void main(String []args){
        Scanner in = new Scanner(System.in);

        int T = Integer.valueOf(in.nextLine());
        //in.next();

        for(int i=0;i<T;i++)
        {
            String line = in.nextLine();
            String [] splitStrings = line.split(" ");
            
            //System.out.println(line);
            int A = Integer.valueOf(splitStrings[0]);
            int B = Integer.valueOf(splitStrings[1]);

            System.out.println("Case #" + (i+1) + ": " + A + " + " + B + " = " + (A+B));

            
        }

        in.close();
    }
}