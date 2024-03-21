import java.util.Scanner;

public class subsetOFSTriNg {
    public static void findsubset(String str,String s,int i){
        if(i==str.length()){
            if(s.length()==0){
                System.out.println(" ");
            }else{
                System.out.println(s);
            }
            return;
        }
        findsubset(str, s+str.charAt(i), i+1);
        findsubset(str,s,i+1);
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        findsubset(str,"",0);
    }
}
