// package linkedList;

public class syntax {

        public static class Node{
            int data;
            Node next;
            public Node(int data){
                this.data=data;
                this.next=null;
            }
        }
        public static Node head;
        public static Node tail;

    public static void main(String[] args) {
        syntax n=new syntax();
        n.head=new Node(1);
        n.head.next=new Node(4);
        
        
    }
}
