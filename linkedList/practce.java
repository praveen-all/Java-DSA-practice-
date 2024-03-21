public class practce{
    public class node{
        int data;
        node next;
        public node(int data){
            this.data=data;
            this.next=null;
        }
    }
    // create the static size
    public static int size=0;
    public static node head;
    public static node tail;
    public void addFirst(int data){
        node newnode=new node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }
    public void addLast(int data){
        node newnode=new node(data);

        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }
        tail.next=newnode;
        tail=newnode;
    }
    // add  middle
    public void addmidle(int index,int data){
        node newnode=new node(data);
        node temp=head;
        int i=0;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        newnode.next=temp.next;
        temp.next=newnode;
    }
    public int removeLast(){
        int val;
        if(size==0){
            System.out.println("linked list is empty");
            return 0;
        }
       else if(size==1){
            val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        node temp=head;

        int i=0;
        while(i<size-2){
              temp=temp.next;
              i++;
        }
        val=temp.next.data;
        temp.next=null;
        tail=temp;
        size--;
        return val;
    }
    public int removeFirst(){
        int val;
        if(size==0){
            System.out.println("linked list is empty");
            return 0;
        }
         if(size==1){
            val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        val=head.data;
        head=head.next;
        return val;
    }
    public void print(){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    // search the element in linked list
    public static int search(node temp,int key){
        if(temp==null){
            return -1;
        }
        if(temp.data==key){
            return 0;
        }
        int indx=search(temp.next, key);
        if(indx==-1){
            return -1;
        }
        return indx+1;
    }
    public int searchKey(int key){
        return  search(head,key);
    }
    
    // reverse the linkedlist using iteretive method
    public node reverse(node temp){
        node prev=null;
        node cur=temp;
        node next;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
    // floyd's cycle aglorithm to detect cycle exits in linked list
    public boolean detect(node temp){
        if(temp.next==null || temp==null){
            return false;
        }
        node slow=temp;
        node fast=temp;
        while(fast!=null && fast.next!=null){
            System.out.println("---->  ");
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public node getmid(node head){
        node slow=head;
        node fast=head.next;
        while(fast!=null && fast.next!=null){
             slow=slow.next;
             fast=fast.next.next;
        }
        return slow;
    }
    public node merge(node left,node right){
        node temp=new node(-1);
        node merge=temp;
        while(left!=null && right!=null){
            if(left.data<right.data ){
                temp.next=left;
                left=left.next;
                temp=temp.next;
            }else{
                temp.next=right;
                right=right.next;
                temp=temp.next;
            }
        }
        while(left!=null){
            temp.next=left;
                left=left.next;
                temp=temp.next;
        }
        while(right!=null){
            temp.next=right;
            right=right.next;
            temp=temp.next;
        }

        return merge.next;


    }
    public node mergesort(node head){
 
        if(head==null || head.next==null){
            return head;
        }

        node mid=getmid(head);
        node right=mid.next;
        mid.next=null;
        
        node lefnode=mergesort(head);
        node rightnode=mergesort(right);

        return merge(lefnode,rightnode);
    }
    public static void main(String[] args) {
        practce l=new practce();
        l.addFirst(23);

        l.addFirst(24);
        l.addFirst(25);
        l.addLast(35);
        l.addLast(5);
        l.addFirst(24);
        l.addFirst(2);
        l.addLast(3);
        l.addLast(596);
        // practce.tail.next=head.next.next;
        // System.out.println(l.detect(head));
        // l.print();
        // l.removeLast();
        // System.out.println(practce.size);
        // l.addmidle(2, 6000);
        // // practce.head=l.reverse(head);
        // l.print();
        
        // System.out.println(l.searchKey(6000));
        l.mergesort(head);
        l.print();
    }
}