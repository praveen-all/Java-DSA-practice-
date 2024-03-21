import java.util.*;

public class binaryTreeBasic {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree{
        static int indx=-1;
        public static Node binarytree(int nodes[]){
            indx++;
            if(nodes[indx]==-1){
                return null;
            }

           Node newnode= new Node(nodes[indx]);
            newnode.left=binarytree(nodes);
            newnode.right=binarytree(nodes);

            return newnode;
        }
        // print 

        public static void printOrTraverce(Node root){
            
            if(root==null){
                return ;
            }
            
            
            System.out.println(root.data);
            printOrTraverce(root.left);
            printOrTraverce(root.right);


        }

        public static void printInorder(Node root){
            if(root==null){
                return ;
            }

            printInorder(root.left);
            System.out.print(root.data+"  ");
           printInorder(root.right);
        }

        public static void printPostOrder(Node root){
            if(root==null){
                return;
            }

            printInorder(root.left);
            printInorder(root.right);
            System.out.print(root.data+"  ");
        }
        public static void printLevelOrder(Node root){
            if(root==null){
                return ;
            }
              Queue<Node> q=new LinkedList<>();
              q.add(root);
              q.add(null);

              while(!q.isEmpty()){
                Node current=q.remove();
                if(current==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(current.data+" ");
                    if(current.left!=null){
                        q.add(current.left);
                    }
                    if(current.right!=null){
                        q.add(current.right);
                    }
                }
              }
            
        }
    }
    public static void main(String[] args) {
        int binary[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree b=new BinaryTree();
        Node root= b.binarytree(binary);
        System.out.println(root.data);


        // how to traverce an tree 
        // using 1) Preorder method means first print * root , all  root.next and all root.right
          b.printOrTraverce(root);
        //   another methos called 2) inorder method
          b.printInorder(root);
          System.out.println();
        // 3) postorder method
        b.printPostOrder(root);
        System.out.println();
        // 4) traversal on level order .most imp quetion asked on g,f,a
        b.printLevelOrder(root);
       
    }
}
