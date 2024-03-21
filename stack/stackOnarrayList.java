import java.util.ArrayList;
import java.util.List;

public class stackOnarrayList {
    static class Stack{
        static ArrayList<Integer> ll=new ArrayList<>();
        
        // if list is an empty
        public static boolean empty(){
            return ll.size()==0;
        } 

        // push operator

        public static void push(int data){
          ll.add(data);
        }
        // pop operator

        public static int pop(){
             int top=ll.get(ll.size()-1);
             if(top==0){
                System.out.println("stack is empty");
                return -1;
             }
             ll.remove(ll.size()-1);
            
             return top;
        }

        // peek :- It means get top value from stack

        public static int peek(){
            if(ll.get(ll.size()-1)==0){
                System.out.println("stack is empty");
                return -1;
            }
            return ll.get(ll.size()-1);

        }
    }
    public static void main(String[] args) {
        Stack ss=new Stack();
        ss.push(2);
        ss.push(4);
        ss.push(8);
        ss.push(56);

        while (!ss.empty()) {
            System.out.println(ss.peek());
            ss.pop();
        }
    }
}
