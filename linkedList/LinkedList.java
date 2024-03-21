
// package linkedList;

/*
          
                        public class LinkedList {
              
                  public static class Node{
                      int data;
                      Node next;
                      public  Node(int a){
                          this.data=a;
                          this.next=null;
                      }
                      
                  }
              
                  public static Node head;
                  public static Node tail;
                  public static void main(String[] args) {
                      LinkedList ll=new LinkedList();
                      ll.head=new Node(4);
                      ll.head.next=new Node(34);
                      System.out.println(ll.head.data );
                      System.out.println(ll.head.next );
                  }
              }

 */

//  addd node at first

public class LinkedList{
  
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
      public static int size;

      public void addfirst(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
            size++;
            return;
            
        }
        newnode.nxt=head;
        head=newnode;
        size++;
      }

      public void addlast(int data){
        Node newnoNode=new Node(data);
        if(head==null){
            head=tail=newnoNode;
            size++;
        return;
        }
        size++;

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


    public static void middle(int indx,int data){
        Node newnode=new Node(data);
        int i=0;
        Node temp=head;
        while (i<indx-1) {
            temp=temp.nxt;
            i++;
        }
        size++;
        newnode.nxt=temp.nxt;
        temp.nxt=newnode;
        
    }
    public  void removenode(){
      head=head.nxt;

    }
    public int removeLat(){
         if(size==0){
          System.out.println("empty linked list");
          return Integer.MIN_VALUE;
         }else if(size==1){

          int val=tail.data;
          head=tail=null;
          size=0;
          return val;
         }

         Node temp=head;
         for(int i=0;i<size-2;i++){
          temp=temp.nxt;
         }
         int val=temp.nxt.data;
         temp.nxt=null;
         size--;
         return val;
    }

    public static int searchKeyInList(int key){
      int i=0;
      Node temp=head;
      while (temp!=null) {
        if( temp.data==key){
          return i;
        }
        temp=temp.nxt;
        i++;
       
      }
      return -1;
    }
    static int index=0;
    
    public static int searchRecursion(int key,Node head){
      if(head.data==key){
        return index;
      }
      if(head.nxt==null){
        return -1;
      }
       Node pavi=head.nxt;
       index++;
       return  searchRecursion(key,pavi);
    }

    // search an elemtns in linked list using an recursion method 
    public static int helper(Node head,int key){
      if(head==null){
        return -1;
      }
      if(head.data==key){
        return 0;
      }

      int indx=helper(head.nxt, key);
      if(indx==-1){
        return -1;
      }
      
      return indx+1;
    }
    public static int searchKey(int key){
           return  helper(head,key);
    }

    // reverse linked list

     public static void reverse(){
      Node prev=null;
      Node current=tail=head;
      Node next;
      while(current!=null){
        next=current.nxt;
        current.nxt=prev;
        prev=current;
        current=next;
      }

      head=prev;

     }
    //  delete nth node from end

    public static void deleteNthFromEnd(int n){
      int size=0;
      Node temp=head;
      while(temp!=null){
        temp=temp.nxt;
        size++;
      }
      if(n==size){
        head=head.nxt;
        return ;
      }

      int i=1;
      int ito=size-n;
      Node prev=head;
      while(i<ito){
        prev=prev.nxt;
        i++;
      }
      prev.nxt=prev.nxt.nxt;
      return ;
    }

      public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.addfirst(1);
        // printanList();
        ll.addfirst(34);
        // printanList();
        ll.addfirst(556);
        ll.addlast(34343);
        // printanList();
        ll.addlast(4459);
        // printanList();
        ll.addlast(23451234);
        // printanList();
        ll.addlast(554);
        // add data at middle
        ll.middle(2, -98483);
        // System.out.println(size);//find the size first we declered an static variable ,each time increase by one when we add and add at middle
        
        // how to remove node
        // ll.printanList();
        // ll.printanList();
        // ll.removenode();
        // ll.removenode();
        
        // remove from last
        // ll.printanList();
        // ll.removeLat();
        // ll.removeLat();
        // ll.printanList();


        // search key value in linked list
      //  System.out.println( ll.searchKeyInList(4459));;

      // search key using recursion 

      // System.out.println(searchRecursion(4459,ll.head));

      // search a key value in linked list using recursion another method
      // System.out.println(searchKey(4459));


      // reverse an linked list 
      //  ll.printanList();
      //  ll.reverse();
      //  ll.printanList();

      // delte an nth node from end
      ll.printanList();
      ll.deleteNthFromEnd(3);
      ll.printanList();





  }
}