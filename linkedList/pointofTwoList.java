public class pointofTwoList {
    public static class Node{
        int data;
        Node  next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
        
        
    }
    public static int poin(Node head1,Node head2){
        Node head=head2;
        while(head!=null){
            Node temp=head1;

            while(temp!=null){
                if(temp==head){
                    return head.data;
                }
                temp=temp.next;
            }
            head=head.next;
        }

        return -1;
    }
    public static void main(String[] args) {
        pointofTwoList nn=new pointofTwoList();

        // creating two linked list
        Node head1=new Node(12);
        Node head2=new Node(23);
        Node newnode=new Node(88);
        head2.next=newnode;
        newnode=new Node(882);
        head2.next.next=newnode;
        newnode=new Node(883);
        head2.next.next.next=newnode;
        newnode=new Node(889);
        head2.next.next.next.next=newnode;

        newnode=new Node(299);
        head1.next=newnode;
        newnode=new Node(99);
        head1.next.next=newnode;
        newnode=new Node(987);
        head1.next.next.next=newnode;

            // here link one list by another
        head1.next.next.next.next=head2.next.next;

       int point=nn.poin(head1, head2);

       if(point==-1){
        System.out.println("two node are may be not linked ");
       }else{
        System.out.println("point where they linked is "+point);
       }

       
    

    }
}
