public class DeleteMtoN {
    public static class Node{
        int data;
        Node  next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node deleteMN(Node head,int m,int n){
             Node cur=head,temp;
             int count;
             while(cur!=null){
                for(count=1;count<m && cur!=null;count++){
                    cur=cur.next;
                }
                if(cur==null){
                    return head;
                }

                temp=cur.next;

                for(count=1;count<=n && temp!=null;count++){
                    temp=temp.next;
                }
                cur.next=temp;
                cur=temp;
             }

             return head;
    }


    public void printlist(Node head){
        if(head==null){
            System.out.println("empty");
            return;
        }
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }

    public static void main(String[] args) {
        Node head2=new Node(23);
        Node newnode=new Node(88);
        head2.next=newnode;
        newnode=new Node(882);
        head2.next.next=newnode;
        newnode=new Node(883);
        head2.next.next.next=newnode;
        newnode=new Node(889);
        head2.next.next.next.next=newnode;
         DeleteMtoN mm=new DeleteMtoN();
        Node head1=deleteMN(head2, 2, 2);
        mm.printlist(head1);

        
    }
}
