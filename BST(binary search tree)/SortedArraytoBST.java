import java.util.ArrayList;

public class SortedArraytoBST {
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
    public static Node arraytoBST(int arr[],int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node(arr[mid]);
        root.left=arraytoBST(arr, st, mid-1);
        root.right=arraytoBST(arr, mid+1, end);
        return root;
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);

    }
    // convert normal bst to balanced bst
    // ------------------------------------------------------------------------------------------
       public static void getInorder(Node root, ArrayList<Integer> inorder){
               if(root==null){
                return ;
               }
               getInorder(root.left, inorder);
               inorder.add(root.data);
               getInorder(root.right, inorder);
       }
       public static Node createBST(ArrayList<Integer> inorder,int st,int end){
          if(st>end){
            return null;
          }
          int mid=(st+end)/2;
          Node root=new Node(inorder.get(mid));
          root.left=createBST(inorder, st, mid-1);
          root.right=createBST(inorder, mid+1, end);
          return root;
       }
       public static Node balanceBST(Node root){
              if(root==null){
            return null;
              }
              ArrayList<Integer> inorder=new ArrayList<>();
              getInorder(root,inorder);
              root=createBST(inorder,0,inorder.size()-1);
              return root;
       }
    //    size of largest bst in given bs
    public static int maxsize=0;
          static class Info{
            boolean isBST;
            int size;
            int min;
            int max;
            public Info(boolean isBST,int size,int min,int max){
                this.isBST=isBST;
                this.size=size;
                this.min=min;
                this.max=max;
            }
          }

          public static Info largeBST(Node root){
              if(root==null){
                return new Info(true, 0,Integer.MAX_VALUE, Integer.MIN_VALUE);
              }
              Info left=largeBST(root.left);
              Info right=largeBST(root.right);
              int size=left.size+right.size+1;
              int min=Math.min(left.min,Math.min(right.min,root.data));
              int max=Math.max(left.max,Math.max(right.max,root.data));

              if(root.data<=left.max || root.data>=right.min){
                return new Info(false, size, min, max);
              }

              if(left.isBST||right.isBST){
                maxsize=Math.max(maxsize, size);
                return new Info(true, size, min, max);
              }
              return new Info(false, size, min, max);
          }
    public static void main(String[] args) {
        // int arr[]={3,5,6,8,10,11,12};
        // Node root=arraytoBST(arr, 0, arr.length-1);
        // preorder(root);
        /*
                        8
                      /   \
                     5     11
                    / \    /\
                   3   6  10 12


                    Node root=new Node(8);
        root.left=new Node(6);
        root.left.left=new Node(5);
        root.left.left.left=new Node(3);
        root.right=new Node(10);
        root.right.right=new Node(11);
        root.right.right.right=new Node(12);
        
        Node reroot=balanceBST(root);
        preorder(reroot);
         */
       

        //  -----------------------find the largest bst in the bs
        Node root=new Node(50);
        root.left=new Node(30);
        root.left.left=new Node(5);
        root.left.right=new Node( 20);
        root.right=new Node(60);
        root.right.left=new Node(45);
        root.right.right=new Node( 70);
        root.right.right.right=new Node( 80);
        root.right.right.left=new Node( 80);
        Info nn=largeBST(root);
        System.out.println("max size of bst  in bs"+maxsize);

    }
}
