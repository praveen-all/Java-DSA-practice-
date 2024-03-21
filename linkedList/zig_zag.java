public class zig_zag {
    public static class Node{
        int data;
        Node nxt;
        public Node(int data){
            this.data=data;
            this.nxt=null;
        }
    }
    public static Node head;
    public static Node tail;

    public void addlast(int data){
        Node newnoNode=new Node(data);
        if(head==null){
            head=tail=newnoNode;
        return;
        }

        tail.nxt=newnoNode;
        tail=newnoNode;
      }

     public static void   printanList(){

      Node temp=head;
      while (temp!=null) {
          System.out.print(temp.data+"   ");
          temp=temp.nxt;
      }
      System.out.println("null");
    }
    // zig-zag code here

    public void zigzag(){
        // find mid
        Node slow=head;
        Node fast=head.nxt;
        while(fast!=null  && fast.nxt!=null){
            slow=slow.nxt;
            fast=fast.nxt.nxt;
        }
        Node mid=slow;

        // 2nd half
        Node curr=mid.nxt;
        mid.nxt=null;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.nxt;
            curr.nxt=prev;
            prev=curr;
            curr=next;
        }

        // zig-zad 

        Node left=head;
        Node right=prev;
        Node nextL,nextR;
        while(left!=null && right!=null){
            nextL=left.nxt;
            left.nxt=right;
            nextR=right.nxt;
            right.nxt=nextL;

            left=nextL;
            right=nextR;
        }
    }

    public static void main(String[] args) {
        zig_zag zz=new zig_zag();
        zz.addlast(1);
        zz.addlast(2);
        zz.addlast(3);
        zz.addlast(4);
        zz.addlast(5);
        zz.addlast(6);
        zz.printanList();
        zz.zigzag();
        zz.printanList();
    }
}
