import java.util.*;
public class stackUsing2QUEUE {
    static class Stack{
        static Queue<Integer> q1=new LinkedList<>();
        static Queue<Integer> q2=new LinkedList<>();

    //    isEmpty()
    public static boolean isEmpty(){
        return (q1.isEmpty() && q2.isEmpty());

    }

    // add an 
    public static void push(int add){
        if(!q1.isEmpty() ){
            q1.add(add);
        }else{
            q2.add(add);
        }
    }
    // pop

    public static int pop(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }
        int top=-1;

        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                     top=q1.remove();
                     if(q1.isEmpty()){
                        break;
                     }

                     q2.add(top);
            }
        }else{
            while(!q2.isEmpty()){
                top=q2.remove();
                if(q2.isEmpty()){
                   break;
                }

                q1.add(top);
       }
        }
        return top;
    }
    // peek() an value

    public static int peek(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }
        int top=-1;

        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                     top=q1.remove();
                     q2.add(top);
            }
        }else{
            while(!q2.isEmpty()){
                top=q2.remove();
                q1.add(top);
       }
        }
        return top;
    }

    }
    public static void main(String[] args) {
        Stack s1=new Stack();
        s1.push(23);
        s1.push(89);
        s1.push(67);
        
        while(!s1.isEmpty()){
           System.out.println(s1.pop());
        }
    }
}
