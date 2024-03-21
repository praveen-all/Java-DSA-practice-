import java.util.*;
public class reverseStringStack {
      public static String reverseString(String str){
        Stack<Character> ss=new Stack<>();
        int indx=0;
        while(indx<str.length()){
            ss.push(str.charAt(indx++));
        }

        StringBuilder stringbuild=new StringBuilder("");
        while (!ss.isEmpty()) {
            stringbuild.append(ss.pop());

        }
    
         str=stringbuild.toString();
        return str;
      }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(reverseString(str));
    }
}
