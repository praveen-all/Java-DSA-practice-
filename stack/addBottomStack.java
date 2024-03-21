import java.util.*;
// here we are used recorsion 
public class addBottomStack {

    public static void addBottomStack(Stack<Integer>s,int dat){
        if(s.isEmpty()){
            s.push(dat);
            return;
        }
        int top=s.pop();
        addBottomStack(s, dat);
        s.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> ss=new Stack<>();
        ss.push(34);
        ss.push(45);
        ss.push(90);
        ss.push(77);

        addBottomStack(ss,45);
        System.out.println("hence after adding value at bottom we have ");
        while(!ss.isEmpty()){
            System.out.println(ss.pop());
        }
    }
}
