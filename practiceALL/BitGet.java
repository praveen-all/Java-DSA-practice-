import java.util.*;
public class BitGet {
   
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		String str="codeforces";
		while(t-->0){
		  char c=sc.next().charAt(0);
		  String s="";
		  s+=c;
          if(str.contains(s)){
			System.out.println("YES");
		  }else{
			System.out.println("NO");
		  }
		}
    }
}
