import java.util.*;
public class mergeTwoBST {
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
    public static void getInorder(Node root,ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
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
    public static Node mergeBST(Node root1,Node root2){
        //   step1 arr1
        ArrayList<Integer> arr1=new ArrayList<>();
        getInorder(root1,arr1);

        // step2 arr2

        ArrayList<Integer> arr2=new ArrayList<>();
        getInorder(root2,arr2);

        // step 3 merge to sorted array list using merge sort process
        ArrayList<Integer> finall=new ArrayList<>();
        int i=0,j=0;
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<arr2.get(j)){
                finall.add(arr1.get(i));
                i++;
            }else{
                finall.add(arr2.get(j));
                j++;
            }
        }

        while(i<arr1.size()){
            finall.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            finall.add(arr2.get(j));
            j++;
        }
        
        return createBST(finall,0,finall.size()-1);
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);

    }
    public static void main(String[] args) {
        Node root=new Node(2);
        root.left=new Node(1);
        root.right=new Node(4);
        Node root1=new Node(9);
        root1.left=new Node(3);
        root1.right=new Node(12);

        Node merge=mergeBST(root,root1);
        /*
           after the merge is happens
                            3
                          /   \
                         1     9
                         \    / \
                          2  4  12
         */
              preorder(merge);
    }
}
