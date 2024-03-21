import java.util.LinkedList;
public class LLjavaCollection {
    public static void main(String[] args) {
        LinkedList<Integer> ll=new LinkedList<>();
        ll.addFirst(34);
        ll.addLast(44);
        ll.addFirst(5678);
        ll.addLast(3456);
        System.out.println(ll);
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);
    }
}
