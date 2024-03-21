public class PalindromeInlist {
    public static class Node{
        int data;
        Node nxt;

        public Node(int n){
            this.data=n;
            this.nxt=null;
        }
    }
    public static  Node Head;
    public static  Node Tail;

    // add last 
    public void addlast(int n){
        Node newNode=new Node(n);
        if(Head==null){
         Head=Tail=newNode;
        //  System.out.println(Tail.data);
         return;
        }

        Tail.nxt=newNode;
        Tail=newNode;
        // System.out.println(Tail.data);
        return;
    }

    // first step find the mid value;
    public Node findmid(Node head){
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.nxt!=null) {
            slow=slow.nxt;
            fast=  fast.nxt.nxt;
             
        }

        return slow;
    }

    // check it is palindrom or not

    public boolean palindrom(Node head){
        // base condition
        if(head==null || head.nxt==null){
            return true;
        }

        // find mid
        Node midnode=findmid(head);

        // System.out.println(midnode.data);
        // System.out.println(midnode.nxt.data);

        // reverse right  list

        Node prev=null;
        Node cur=midnode;
        Node next;
        while(cur!=null){
             next=cur.nxt;
             cur.nxt=prev;
             prev=cur;
             cur=next;
        }

        // check left and right

        Node left=head;
        System.out.println(head.data);
        Node right=prev;//here is an last value of the linked list
        while(right!=null){
            // System.out.println(left.data);
            // System.out.println(right.data);
            if(left.data!=right.data){
                
                return false;
            }
           left= left.nxt;
           right= right.nxt;
        }
       return true;
    }
    public static void main(String[] args) {
        PalindromeInlist ll=new PalindromeInlist();
          ll.addlast(1);
          ll.addlast(2);
          ll.addlast(2);
          ll.addlast(2);
          ll.addlast(2);
          ll.addlast(2);
          ll.addlast(1);
          System.out.println(ll.palindrom(ll.Head));
    }
}
