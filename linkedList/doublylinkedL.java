import java.security.PublicKey;

public class doublylinkedL {

    public class Node{
        int data;Node next;
        Node prev;

        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size=0;

    // add element first in doubly linked list

    public void addfirst(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head.prev=newnode;
        head=newnode;
    }

    // print an elemnt both reverse and stright direction 

    public void printlist(Node head){
         Node temp=head;
         while(temp!=null){
               System.out.print(temp.data+" ");
                temp=temp.next;
         }
        //  System.out.println();
        //  temp=tail;
        //  while(temp!=null){
        //     System.out.print(temp.data+" ");
        //     temp=temp.prev;
        //  }
    }

    // add at last in doubly linked list

    public void addlast(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
        }

        tail.next=newnode;
        newnode.prev=tail;
        tail=newnode;
    }
    // remove from first
    public void removefirst(){
        if(head==null){
            System.out.println("sry empty not removalbe");
            return;
        }
        Node temp=head;
        temp=head.next;
        head.next=null;
         head=temp;
        head.prev=null;
    }
    // remove from thelast 
    public void removelast(){
        if(head==null){
            System.out.println("sry empty not removalbe");
            return;
        }

        Node temp=tail.prev;
        tail.prev=null;
        tail=temp;
        tail.next=null;
    }
    // reverse an doubly linked list
    public void reverse(){
        Node prev=null;
        Node cur=head;
        Node next;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            cur.prev=next;
            prev=cur;
            cur=next;
        }
        head=prev;
    }
    // shall make like circular linked list
    public void circular(){
        tail.next=head;
        head.prev=tail;
    }
    public static void main(String[] args) {
         doublylinkedL dd=new doublylinkedL();
         dd.addfirst(23);
         dd.addfirst(33);
         dd.addfirst(44);
         dd.addfirst(55);
         dd.addfirst(66);
         dd.addfirst(77);
         dd.addfirst(88);
         dd.addlast(344);
         dd.printlist(dd.head);
        //  dd.reverse();
        dd.circular();
         dd.printlist(dd.head);
    }
}
