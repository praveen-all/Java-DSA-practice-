import java.util.*;


public class treepractice {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }

    }

    static class Tree{
        static int indx=-1;
        public static Node Buildtree(int nodes[]){
            indx++;
            if(nodes[indx]==-1){
                return null;
            }
            Node newnode=new Node(nodes[indx]);
            newnode.left=Buildtree(nodes);
            newnode.right=Buildtree(nodes);
            return newnode;
        }
           // -----------------------------------------------------------
        public static void Preorder(Node root){
            if(root==null){
                return;
            }
            Preorder(root.left);
            System.out.print(root.data+" ");
            Preorder(root.right);
        }
   // -----------------------------------------------------------
        // public static void  LEVELORDER(Node root){
        //     if(root==null){
        //         return;
        //     }
        //     Queue<Node> q=new LinkedList<>();
        //     q.add(root);
        //     q.add(null);
        //     while(!q.isEmpty()){
        //         Node curr=q.remove();
        //         if(curr==null){
        //             System.out.println();
        //             if(q.isEmpty()){
        //                 break;
        //             }else{
        //                 q.add(null);
        //             }
        //         }else{
        //             System.out.print(curr.data+" ");
        //             if(curr.left!=null){
        //                 q.add(curr.left);
        //             }
        //             if(curr.right!=null){
        //                 q.add(curr.right);
        //             }
        //         }
        //     }
        // }
        public   ArrayList<Integer> TakeArray(Node root){
            ArrayList<Integer> l=new ArrayList<>();
             Queue<Node> q=new LinkedList<>();
             q.add(root);
             
             while(!q.isEmpty()){
                Node cur=q.remove();
                if(cur==null){
                    l.add(0);
                }else{
                    l.add(cur.data);
                }
                if(cur!=null){
                    q.add(cur.left);
                q.add(cur.right);
                }
             }
             return l;
        }

          
    }   
       public static void main(String[] args) {
       
        int arr[]={1,3,5,-1,-1,-1,2,-1,-1};
        Tree t=new Tree();
        Node root=t.Buildtree(arr);
       int ar[]={2,1,-1,4,-1,-1,3,-1,7,-1,-1};
       Tree.indx=-1;
        Node subroot=t.Buildtree(ar);
        System.out.println(t.TakeArray(root));
        System.out.println(t.TakeArray(subroot));
       }
}
