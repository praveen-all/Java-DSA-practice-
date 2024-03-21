import java.util.*;
public class practice {
    static class node{
        int data;
        node left;
        node right;
        public node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
public static class BinaryTree{
    static int indx=-1;

    public static node buildtree(int arr[]){
        indx++;
        if(arr[indx]==-1){
            return null;
        }
        node newnode=new node(arr[indx]);
        newnode.left=buildtree(arr);
        newnode.right=buildtree(arr);

        return newnode;
    }
    public static void preorder(node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    // print the diameter 
   public static class Info{
        int diameter;
        int height;
        public Info(int diameter,int height){
            this.diameter=diameter;
            this.height=height;
        }
    }

    public static Info Diameter(node root){
        if(root==null){
            return new Info(0, 0);
        }
        Info left=Diameter(root.left);
        Info right=Diameter(root.right);

        int self=left.height+right.height+1;
        int newdiameter=Math.max(Math.max(left.diameter,right.diameter), self);
        int newheight=Math.max(left.height,right.height)+1;
        return new Info(newdiameter, newheight);
    }
    // check given sroot is the sub root of the given root 
    public static boolean isIdentical(node root,node subroot){
        if(root==null && subroot==null){
            return true;
        }else if(root==null|| subroot==null){
            return false;
        }
        else if(root.data!=subroot.data){
            return false;
        }

        if(!isIdentical(root.left, subroot.left)){
              return false;
        }
        if(!isIdentical(root.right, subroot.right)){
            return false;
        }
        return true;
    }
    public static boolean check(node root,node subroot){
        if(root==null){
            return false;
        }

        if(root.data==subroot.data){
            if(isIdentical(root,subroot)){
                return true;
            }
        }

        return check(root.left, subroot)|| check(root.right, subroot);
    }

}
public static void main(String[] args) {
    int arr[]={1,2,3,-1,-1,5,-1,-1,6,-1,-1};
    BinaryTree ab=new BinaryTree();
    node root=ab.buildtree(arr);
    /*
                  1
                 / \
                2   6
               / \
              3   5
     */
    // ab.preorder(root);
    node subroot=new node(2);
    subroot.left=new node(3);
    subroot.right=new node(5);
    /*
                  2
                 / \
                3   5
     */


   
    // System.out.println(ab.Diameter(root).diameter);
    System.out.println(ab.check(root, subroot));
    
}

}
