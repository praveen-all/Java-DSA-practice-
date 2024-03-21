 public class CircularLinkedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;

        }
    }
    public static Node addEmpty(Node last,int data){
        if(last!=null){
          return null;
        }

       Node nn=new Node(data);
       last=nn;
       nn.next=last;
       System.out.println(last);
        return last;
  }

public static Node addfirst(Node last,int data){
  if(last==null){
      
      
      return addEmpty(last, data);
  }
  Node newnode=new Node(data);
  newnode.next=last.next;
  last.next=newnode;
  return last;
}


static void addlast(Node last,int data){
  if(last==null){
      addEmpty(last, data);
      return;
  }
  Node newnode=new Node(data);
  newnode.next=last.next;
  last.next=newnode;
  last=newnode;
}

//  add at nth turm 
static void addterm(Node last,int term,int data){
  if(last==null){
      System.out.println("linked list empty cannot add any value nth term");
      return;
  }

  Node p=last.next;
  Node newnode;
  do{
       if(p.data==term){
          newnode=new Node(data);
          newnode.next=p.next;
          p.next=newnode;

          if(p==last){
              last=newnode;
              return;
          }
       }
       p=p.next;
  }while(p!=last);
}


// delete an key node

static void delete(Node last,int data){
  if(last==null){
      System.out.println("node is empty not removable");
      return;
  }

  if(last.data==data && last.next==last ){
      last=null;
      return;
  }

  Node temp=last.next,doo=null;
  while(temp!=last  && temp.next.data!=data){
      temp=temp.next;
  }
  

  if(temp.next.data==data){
        doo=temp.next;
  }

  temp.next=doo.next;
  return;
}

// print an linked list 
public static void printt(Node last){
    if(last==null){
        System.out.println("empty");
        return;
    }
    Node temp=last.next;
    if(last.next==last){
          System.out.println(last.data+" ");
    }
    do{
        System.out.println(temp.data+" ");
        temp=temp.next;
    }while(temp!=last.next);
}
    public static void main(String[] args) {
        Node last=null;
         last=addfirst(last, 23);
         last=addfirst(last, 23);
         last=addfirst(last, 23);
         last=addfirst(last, 2233);
         last=addfirst(last, 232);
         last=addfirst(last, 2300);
          printt(last);
          System.out.println(last);
    }
}
