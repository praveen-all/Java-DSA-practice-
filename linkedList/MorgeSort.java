import java.util.HexFormat;

// import javax.print.attribute.standard.Sides;
// import javax.xml.transform.Templates;

// public class MorgeSort {
    
// public  static int size=0;
//    public static class Node{
   
//     int data;
//     Node  next;
    
//     public Node(int data){
//         this.data=data;
//         this.next= null;
//     }
   
    
//    }

//    public static  Node head;
//    public  static Node tail;

//    public void addfirst(int data){
//     Node newnode=new Node(data);
//     if(head==null){
//         head=tail=newnode;
//         size++;
//         return;
        
//     }
//     newnode.next=head;
//     head=newnode;
//   }

//    public  void   printanList(){

//     Node temp=head;
//     while (temp!=null) {
//         System.out.print(temp.data+"   ");
//         temp=temp.next;
//     }
//     System.out.println("null");
//   }

//    public Node merge(Node head1,Node head2){
//       Node mergell=new Node(-1);
//       Node temp=mergell;

//       while(head1!=null && head2 !=null){
//         if(head1.data<=head2.data){
//             temp.next=head1;
//             head1=head1.next;
//             temp=temp.next;
//         }else{
//             temp.next=head2;
//             head2=head2.next;
//             temp=temp.next;
//         }
//       }
//       while(head1!=null){
//         temp.next=head1;
//         head1=head1.next;
//         temp=temp.next;
//       }
//       while(head2!=null){
//         temp.next=head2;
//         head2=head2.next;
//         temp=temp.next;
//       }

//       return mergell.next;
//    }
// //    mid function finding function 

//     private Node getmid(Node head){
//         Node slow=head;
//         Node fast=head.next;

//         while(fast!=null && fast.next!=null){
//             slow=slow.next;
//             fast=fast.next.next;

//         }

//         return slow;
//     }

//    public Node mergesort(Node headd){
//     if(headd==null || headd.next==null){
//         return headd;
//     }
//     Node mid=getmid(headd);

//     // left head and right head
    
//     Node righhead=mid.next;
//     mid.next=null;
//     System.out.println("kyaji");
//     Node rightmerge=mergesort(righhead);
//     Node leftmerge=mergesort(headd);

//     // merge
//     return merge(leftmerge,rightmerge);


//    }





//    public static void main(String[] args) {

//   MorgeSort aa=new MorgeSort();
//   aa.addfirst(1);
//   aa.addfirst(2);
//   aa.addfirst(3);
//   aa.addfirst(4);
//   aa.addfirst(5);
//   aa.printanList();
//   head=aa.mergesort(head);
//   aa.printanList();


   
//    }
// }


public class MorgeSort{
    public class Node{
    int data;
    Node next;
      public Node(int data){
        this.data=data;
        this.next=null;
      }
    }
    public static Node head;
    public static Node tail;

    // add node first
    public void addfirst(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }

    public void printlist(Node head){
          
           Node temp=head;
           while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
           }
    }
    // sort an entered value on merge sort

    public Node mergesort(Node head){
        if(head==null || head.next==null){
            return head;
        }

        // find an find of an list
        Node midNode=midnoe(head);

        // left and right part 
        Node left=head;
        Node right=midNode.next;
        midNode.next=null;

        Node right1=mergesort(right);
        Node left1=mergesort(left);

        return merging(left1,right1);
    }
    // find finding function here
    public Node midnoe(Node head){
        Node slow=head;
        Node fast=head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;

    }
    // merging two node 
    public Node merging(Node head1,Node head2){
           Node mergenode=new Node(-1);
           Node temp=mergenode;

           while(head1!=null && head2!=null){
               if(head1.data<=head2.data){
                  temp.next=head1;
                  temp=temp.next;
                  head1=head1.next;
               }else{
                temp.next=head2;
                temp=temp.next;
                head2=head2.next;
               }
           }

           while(head1!=null){
            temp.next=head1;
                  temp=temp.next;
                  head1=head1.next;
           }

           while (head2!=null) {
            temp.next=head2;
            temp=temp.next;
            head2=head2.next;
           }

           return mergenode.next;
    }

    // print an linked list in zig-zag pattern
    public void zigzag(){
        if(head==null || head.next==null){
            return;
        }

        // find the mid of the linked list
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        Node curr=slow.next;
        slow.next=null;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }


        Node left=head;
        Node right=prev;
        Node nextL,nextR;
        while(left!=null && right!=null){
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;
            left=nextL;
            right=nextR;
        }

      printlist(head);

    }
    public static void main(String[] args) {
        MorgeSort mm=new MorgeSort();
          mm.addfirst(34);
          mm.addfirst(43);
          mm.addfirst(67);
          mm.addfirst(56);
          mm.addfirst(6664);
          mm.addfirst(6);
          mm.printlist(mm.head);
          System.out.println("after we sorted using merfe sort ");
        //   mm.printlist(mm.mergesort(mm.head));
        mm.zigzag();

    }
}