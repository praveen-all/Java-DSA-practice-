public class mirrorImage {
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
    public static Node mirror(Node root){
        if(root==null){
            return null;
        }
        Node left=mirror(root.left);
        Node right=mirror(root.right);

        root.left=right;
        root.right=left;
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
    public static void main(String[] args) {
        Node newnode=new Node(8);
        newnode.left=new Node(5);
        newnode.right=new Node(10);
        newnode.left.left=new Node(2);
        newnode.left.right=new Node(6);
        newnode.right.right=new Node(11);
        /*
                     actuall bst        
                                8
                               / \
                              5   10
                             / \    \
                            2   6    11 

                     mirror bst
                                8
                               / \
                              10   5
                             /    / \
                            11   6   2
         */
        preorder(newnode);
        Node late= mirror(newnode);
        System.out.println();
        preorder(late);

    }
}
