public class doubleLinkedlist {
    public class node{
        int data;
        node next;
        node pre;
        public node(int data){
            this.data=data;
            this.next=null;
            this.pre=null;
        }
    }
    public static node head;
    public static node tail;
    public static int size=0;
    public void addFirst(int data){
        node newnode=new node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return ;
        }
        newnode.next=head;
        head.pre=newnode;
        head=newnode;
    }
    public void addLast(int data){
        node newnode=new node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return ;
        }
        tail.next=newnode;
        newnode.pre=tail;
        tail=newnode;
    }

    public void print(node temp){
        node head=temp;
        while(head!=null){
            System.out.print(head.data+"<->");
            head=head.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        doubleLinkedlist dll=new doubleLinkedlist();
        dll.addFirst(23);
        dll.addFirst(232);
        dll.addFirst(89);
        dll.print(head);
        
    }
}
