public class transformsumtree {
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
    public static int transfor(Node root){
       if(root==null){
        return 0;
       }
       int leftdata=transfor(root.left);
       int rightdata=transfor(root.right);
       int data=root.data;
       int sumleft=root.left==null? 0:root.left.data;
       int sumright=root.right==null? 0:root.right.data;
       root.data=sumleft+sumright+leftdata+rightdata;

       return data;
    }
    public static void print(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        print(root.left);
        print(root.right);
    }
public static void main(String[] args) {
    Node nn=new Node(1);
    nn.left=new Node(2);
    nn.left.left=new Node(4);
    nn.left.right=new Node(5);
    nn.right=new Node(3);
    nn.right.left=new Node(6);
    nn.right.right=new Node(7);
    transfor(nn);
    print(nn);
}

}
