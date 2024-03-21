import java.util.*;

public class QueueJavaFrameWork {
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        Queue<Integer> qd=new ArrayDeque<>();
         qd.add(34);
         qd.add(90);
         qd.add(899);
         while(!qd.isEmpty()){
            System.out.println(qd.peek());
            qd.remove();
         }

    }
}
