import java.util.*;
public class StackUsingDeque {
    static class Stack{
        Deque<Integer> dq=new LinkedList<>();

        //push operator
        public  void push(int data){
            dq.addLast(data);
        }
        // pop
        public int pop(){
            return dq.removeLast();
        }
        // peek
        public int peek(){
            return dq.getLast();
        }
    }
    public static void main(String[] args) {
        Stack s=new Stack();
        s.push(90);
        s.push(43);
        s.push(84);
        s.push(657);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
