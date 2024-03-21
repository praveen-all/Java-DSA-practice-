import java.util.*;
public class Practice {

//Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring

public static boolean isvalid(String str){
    Stack<Character> s=new Stack<>();
    for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
        if(ch=='('){
            s.push(ch);
        }else if(!s.isEmpty() &&  s.peek()=='('){
            s.pop();
        }else{
            return false;
        }

    }
    return s.isEmpty();
}
public static int longestValidParentheses(String s) {
   int maxxout=0;
   for(int i=0;i<s.length();i++){
    for(int j=i+2;j<=s.length();j+=2){
           if(isvalid(s.substring(i,j))){
              maxxout=Math.max(maxxout, j-i);
           }
    }
   }
   return maxxout;

}
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println(longestValidParentheses("()(()")); 
}
}
