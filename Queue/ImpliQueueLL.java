import javax.swing.UIDefaults.ProxyLazyValue;

public class ImpliQueueLL {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class Queue{
        public static Node head=null;
        public static Node tail=null;
        public static boolean isEmpty(){
            return  (head==null && tail==null);
        }
        //addd

        public static void add(int data){
            Node newnode=new Node(data);
            if(head==null){
                head=tail=newnode;
                return;
            }

            tail.next=newnode;
            tail=newnode;
        }

        // remove 

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front=head.data;
            if(head==tail){
                head=tail=null;
            }else{
                head=head.next;
            }

            return front;
        }

        // peek()

        public static int peek(){
           if(isEmpty()){
            System.out.println("queue is empty");
            return -1;
           }

           return head.data;
        }
    }
    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(34);
        q.add(67);
        q.add(56);
        q.add(90);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    

    }
}
