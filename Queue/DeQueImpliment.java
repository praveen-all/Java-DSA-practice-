import java.util.*;
public class DeQueImpliment {

    public static void main(String[] args) {
         Deque<Integer> dq=new  LinkedList<>();

        dq.addFirst(23);
        dq.addFirst(2);
        dq.addFirst(4);
        dq.addFirst(9);
        dq.addLast(800);
        dq.addLast(89);

        System.out.println(dq);
        System.out.println(dq.getFirst());
        System.out.println(dq.getLast());
        System.out.println(dq.removeLast());
        System.out.println(dq.removeFirst());
    }
}
