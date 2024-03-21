import java.util.*;

public class validPrenthesisStack {

    public static boolean valide(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                s.push(ch);

            }else{
                if(s.empty()){
                    return false;
                }
                if((ch==')'&& s.peek()=='(')||(ch=='}'&& s.peek()=='{')||(ch==']'&& s.peek()=='[')){
                    s.pop();
                }else{
                     return false;
                }
            }
        }
        if(s.empty()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(valide(str));
    }
}
