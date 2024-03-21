import java.util.*;

public class firstcodeforce {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        while(n-->0){
            boolean p=false;
            int size=sc.nextInt();
            // String s=sc.next();
            String s=sc.nextLine();
            String ch=sc.nextLine();
            for(int j=1;j<size-1;j+=3){
                if(j>=size-1){
                    break;
                }

                if(ch.charAt(j)==ch.charAt(j+1)){
                    p=true;
                    }else{
                        p=false;
                        break;
                     }
                 
            }


            if(p){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
}
