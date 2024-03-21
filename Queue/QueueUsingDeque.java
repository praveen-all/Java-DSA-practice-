import java.util.*;
public class QueueUsingDeque {
     
       static class Queue{
          Deque<Integer> dq=new LinkedList<>();

        //   add
        public void add(int data){
            dq.addLast(data);
        }
        // remove

        public int remove(){
            return dq.removeFirst();
        }
        // peek();

        public int peek(){
            return dq.getFirst();
        }
       }
    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(89);
        q.add(892);
        q.add(8);
        q.add(823);
        q.add(44);
        q.add(4498475);
        System.out.println(q.peek());
        q.remove();
        System.out.println(q.peek());
        q.remove();
        System.out.println(q.peek());
        q.remove();
        System.out.println(q.peek());
        q.remove();
        System.out.println(q.peek());
        q.remove();
        System.out.println(q.peek());
        q.remove();
       
    }
}
