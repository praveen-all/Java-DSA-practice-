public class findLLInCYCLE {
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

    public static boolean iscycle(){
        Node slow=Head;
        Node fast=Head;
        while(fast!=null && fast.nxt!=null){
            slow=slow.nxt;
            fast=fast.nxt.nxt;
            if(slow==fast){
                return true;
            }

        }
        return false;
    }

    public static void takeanll(){
        Node slow=Head;
        Node fast=Head;
        boolean istrue=false;
        while(fast!=null && fast.nxt!=null){
            if(slow==fast){
                istrue=true;
                break;
            }
        }

        if(istrue==false){
            return ;
        }

        Node prev= null;
        slow=Head;
       while(slow!=fast){
           prev=fast;
           fast=fast.nxt;
        slow=slow.nxt;
       }


    //    
       prev.nxt=null;


      

        
    }
    public static void main(String[] args) {
       Head=new Node(1);
       Head.nxt=new Node(3);
       Head.nxt.nxt=new Node(42);
       Head.nxt.nxt.nxt=new Node(43);
       Head.nxt.nxt.nxt.nxt=new Node(45);
       Head.nxt.nxt.nxt.nxt.nxt=new Node(44);
       Head.nxt.nxt.nxt.nxt.nxt.nxt=Head.nxt.nxt;

        //  System.out.println(iscycle());
         takeanll();
         System.out.println(iscycle());
        
        
    }
}
