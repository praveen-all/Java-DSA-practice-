import java.util.Scanner;

public class permutationOFsTRING {

    public static void permutationOF(String str , String sc){
           if(str.length()==0){
            System.out.println(sc);
            return;
           }

          for(int i=0;i<str.length();i++){
            char c=str.charAt(i);

            String newstr=str.substring(0, i)+str.substring(i+1, str.length());

            permutationOF(newstr, sc+c);
          }

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        permutationOF(str,"");
    }
}
