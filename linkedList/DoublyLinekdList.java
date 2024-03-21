public class DoublyLinekdList {
     public class Node{
        int data;
        Node next;
        Node prev;
         public Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
          }
     }
     public static Node head;
     public static Node tail;
     public static int size;

     public void addfirst(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }

        newNode.next=head;
        head.prev=newNode;
        head=newNode;


     }
    //  remove-first

    public void removefirst(){
         if(head==null){
            System.out.println("empty linked list cannot be removable");
            return;
         }
         if(size==1){
            System.out.println(head.data);
            head=tail=null;
            return;
         }
         size--;
         head=head.next;
         System.out.println(head.prev.data);
         head.prev=null;
    }
    // add last linked list
    public void  addlast(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
        }

        newnode.prev=tail;
        tail.next=newnode;
        tail=newnode;
        size++;

    }

    //remove last in double linked list

    public void removelast(){
        if(head==null){
                  System.out.println("node not removable because its empty");
                  return;
        }
        if(size==1){
            head=tail=null;
            return;
        }

        size--; 
        tail=tail.prev;
        System.out.println("remove last"+tail.next.data);
        tail.next=null;


    }

    // reverse an double linked list
    public void reverseLl(){
        Node curr=head;
        Node prv=null;
        Node nxt;
        while(curr!=null){
            nxt=curr.next;
            curr.next=prv;
            curr.prev=nxt;

            prv=curr;
            curr=nxt;
        }
        head=prv;
    }

    // circular linked list (singular linked list)

    public void SingularCircularList(){
        tail.next=head;
        head.prev=tail;
    }
    //  print an double linked list

    public void pprintdll(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            System.out.println();

            temp=temp.next;
        }

    }
     public static void main(String[] args) {
         DoublyLinekdList dl=new DoublyLinekdList();
         dl.addfirst(34);
         dl.addfirst(56);
         dl.addfirst(98);
         dl.addfirst(43);
         dl.addfirst(4);
         dl.addfirst(41);
         dl.addlast(9955094);
         dl.pprintdll();
         dl.reverseLl();
         dl.pprintdll();
        //  System.out.println("deleted value in first position");
        //  dl.removefirst();
        //  dl.removefirst();
        //  dl.removefirst();
        // System.out.println("size is "+size);
        //  System.out.println("after deleted");
        //  dl.pprintdll();
        // System.out.println("size is "+size);
        // dl.removelast();
        // dl.removelast();
        System.out.println("size is "+size);
        dl.SingularCircularList();
        dl.pprintdll();
    }
}


// circular liked from both sigular linked list and double linked list