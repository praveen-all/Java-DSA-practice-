import java.util.*;

public class QueueUsing2Stack {

    static class Queue{
        static Stack<Integer> s1=new Stack<>();
        static Stack<Integer> s2=new Stack<>();

        // isempty
        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        // add
        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        // remove

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty not removable");
                return -1;
            }

            return s1.pop();
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty not removable");
                return -1;
            }

            return s1.peek();
        }

    
    }
    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(23);
        q.add(78);
        q.add(99);
        q.add(9099);
        q.add(1211);
        q.add(1263);

        while(!q.isEmpty()){
            System.out.print(q.peek()+"       ");
            q.remove();
        }
        // we can do this as add to O(1) and remove & peek be O(n);
    }
}
