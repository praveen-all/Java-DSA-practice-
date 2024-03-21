import java.util.HexFormat;

class LinkedList{
    public class Node{
        int age;
        Node next;
        String name;

        public Node(int age,String name){
            this.name=name;
            this.age=age;
            this.next=null;
        }

    }

    public Node head;
    public Node tail;
    public static int size=0;

    public void addfirst(String name,int age){
       Node newnode=new Node(age, name);
        
       if(head==null){
        head=tail=newnode;
        size++;
        return;
       }
       newnode.next=head;
       head=newnode;
        size++;

    }

    public void printarraylist(Node head){
        Node temp=head;
        if(temp==null){
            System.out.println("node imformation is empty 🤯🤯🤯");
        }
        while(temp!=null){
            System.out.println(temp.name +"age is "+temp.age);
            temp=temp.next;
        }
    }

    // add node at last

    public void addlast(String name,int age){
        Node newnode=new Node(age, name);
        if(head==null){
            head=tail=newnode;
            size++;
            return;
        }
        tail.next=newnode;
        tail=newnode;
        size++;
    }

    // remove from first

    public void removefirst(){
        if(head==null){
            System.out.println("node is empty not removable");
            return;
        }

        head=head.next;
        head.next=null;
        size--;
    }
    // remove last 

    public void removeLast(){
        if(size==0){
            System.out.println("node is empty not removable");
            return ;
        }else if(size==1){
            head=tail=null;
            return;
        }

        Node temp=head;
        for(int i=0;i<size-2;i++){
            temp=temp.next;
        }

        tail=temp;
        tail.next=null;

        
    }
    // add node at middle 

    public void addmiddle(String name,int age,int position){
        if(position==0){
            addfirst(name, age);
            return;
      }
        Node newNode=new Node(age, name);
        Node temp=head;
        
    for(int i=0;i<position-1;i++){
        temp=temp.next;

    }
      newNode.next=temp.next;
      temp.next=newNode;
    //  Node temm=temp.next;
    // temp.next=newNode;
    // newNode.next=temm;
    
    }

    // search by name 
    public int searchbyname(String name){
        int size=0;
        Node temp=head;
        while(temp!=null){
            if(name==temp.name){
                System.out.println("found at position is ");
                 return size;
            }
            temp=temp.next;
            size++;
        }

        System.out.println("did not found anywhere");
        return -1;
    }

    // search by an age 
    public int searchbyage(int age){
        int size=0;
        Node temp=head;
        while(temp!=null){
            if(age==temp.age){
                System.out.println("found at position is ");
                 return size;
            }
            temp=temp.next;
            size++;
        }

        System.out.println("did not found anywhere");
        return -1;
    }

    // search liked list using recursion 

    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }

        if(head.age==key){
            return 0;
        }

        int idx=helper(head.next, key);

        if(idx==-1){
            return -1;
        }
        return idx+1;

    }

    // reverse an  linked list

    public void reverse(){
        Node prev=null;
        Node cur=head;
        Node next;
        while (cur!=null) {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
            
        }
    }

// to check if linked list is palindrome or not 



public Node findMid(Node head){
     Node slow=head;
     Node fast=head;
     while(fast!=null && fast.next!=null) {
        slow=slow.next;
        fast=fast.next.next;
     }
    
    return slow;
}

    public boolean findpalindrome(){
        if(head==null || head.next==null){
            return true;
        }

        // find mid 
        Node midnode=findMid(head);

        // reverse right half
        Node prev=null;
        Node cur=midnode;
        Node next;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }

        Node right=prev;
        Node left=head;
        while(right!=null){
            if(left.age!=right.age){
                return false;
            }
            left=left.next;
            right=right.next;
        }

        return true;
    }


//    find iscycle exits or not

public void iscycle(){
    Node slow=head;
    Node fast=head.next;
    boolean cycle=false;
    Node kavi=null;
    while(fast!=null && fast.next!=null){
             if(slow==fast){
                // System.out.println(slow.age +" and "+slow.name);
                 kavi=fast.next;
                cycle= true;
               
                break;
             }
             slow=slow.next;
             fast=fast.next.next;
    }

    if(cycle==false){
        return;
    }


    // ----- >


    slow=head;

    Node prevv=null;
    while(slow!=kavi){
        prevv=kavi;
       kavi=kavi.next;
        slow=slow.next;
        System.out.println(prevv.age);
    }
    System.out.println(prevv.age);
    prevv.next=null; 

   
}
    

}

public class practice {
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
         ll.addfirst("pavan kumar ha", 20);
         ll.addfirst("praveen ", 10);
         ll.addfirst("ravi kumar ha", 5);
         ll.addfirst("null", 0);
         ll.addfirst("null", 5);
         ll.addfirst("null", 10);
         ll.addfirst("null", 20);
         ll.addfirst("rfj", 3);
         ll.addfirst("rfj", 44);
         ll.addfirst("rfj", 43);
         ll.addfirst("rfj", 33);

         ll.tail.next=ll.head.next;
         
        //  ll.printarraylist(ll.head);
        //  ll.reverse();
        //  System.out.println("liked list is reversed");
        //  ll.printarraylist(ll.tail);
        // System.out.println(ll.findpalindrome());
        // System.out.println("size of an liked list is "+ll.size);
        // ll.removefirst();
        // ll.removeLast();
         ll.iscycle();
         ll.printarraylist(ll.head);
        // is cycle exits
        //  System.out.println(ll.iscycle(ll.head));
                 
        // System.out.println("size of an liked list is "+ll.size);
        // ll.printarraylist(ll.head);
        // System.out.println(ll.tail.name);
        // System.out.println(ll.searchbyname("kiran g"));
        // System.out.println(ll.searchbyage(10));
        // System.out.println(ll.helper(ll.head, 10));

        // find if linkedList is palindrome or not 
    }
}

                      
              

// linked list using an java collection 

// import java.util.LinkedList;
// public class practice{

//     public boolean findpalindrome(){

//     }
//     public static void main(String[] args) {
//         LinkedList<Integer> ll=new LinkedList<>();
//         ll.addFirst(93);
//         ll.addLast(89);
//         ll.addLast(81);
//         ll.addLast(80);
//         ll.addLast(33);
//         ll.addLast(27);
//         ll.addLast(23);
//         System.out.println(ll);
//         ll.removeFirst();
//         ll.removeLast();
//         System.out.println(ll);
//     }
// }