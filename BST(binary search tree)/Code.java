import java.util.Scanner;

public class Code {
   public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    while(t-->0){
        int n=sc.nextInt();
        if(n==1){
            System.out.println(0);
            continue;
        }
        if(n%2==0){
            n=n/2;
            System.out.println((n-1)*3);
        }else{
            n=n/2;
             System.out.println(((n)*3 )-1);
        }
    }
   }
}
