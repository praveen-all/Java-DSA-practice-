import java.util.*;
public class OveralPracice {
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
        public static Node buildtree(int nodes[]){
            
            indx++;
            if(nodes[indx]==-1){
                return null;
            }
            Node newnode=new Node(nodes[indx]);
            newnode.left=buildtree(nodes);
            newnode.right=buildtree(nodes);
            return newnode;
        }
        // print binary tree element in preorder
        public static void preorder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
        // // print binary tree inorder
        // public static void inorder(Node root){
        //     if(root==null){
        //         return;
        //     }
        //     inorder(root.left);
        //     System.out.print(root.data+" ");
        //     inorder(root.right);
        // }
        // // print a binary tree in post order
        // public static void postorder(Node root){
        //     if(root==null){
        //         return ;
        //     }
        //    postorder(root.left);
        //    postorder(root.right);
        //    System.out.print(root.data+" ");
        // }
        // // print level order tree

        // public static void levelOrder(Node root){
        //     if(root==null){
        //         return;
        //     }
        //     Queue<Node> q=new LinkedList<>();
        //     q.add(root);
        //     q.add(null);
        //     while(!q.isEmpty()){
        //         Node curr=q.remove();
        //         if(curr==null){
        //             if(q.isEmpty()){
        //                 break;
        //             }else{
        //                 System.out.println();
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
        // // find height of the tree
        // public static int height(Node root){
        //     if(root==null){
        //         return 0;
        //     }
        //     int leftheight=height(root.left);
        //     int rightheight=height(root.right);
        //     return Math.max(leftheight, rightheight)+1;
        // }
        // // count the no of nodes in tree
        // public static int count(Node root){
        //     if(root==null){
        //         return 0;
        //     }
        //     int left=count(root.left);
        //     int right=count(root.right);
        //     return left+right+1;
        // }
        // // sum of all data in tree 
        // public static int sum(Node root){
        //     if(root==null){
        //         return 0;
        //     }
        //     int leftsum=sum(root.left);
        //     int rightsum=sum(root.right);
        //     return leftsum+rightsum+root.data;
        // }
        // //find the longest path between the two nodes means DIAMETER 
        // public static int finddiameter(Node root){
        //     if(root==null){
        //         return 0;
        //     }
        //     int ld=finddiameter(root.left);
        //     int lh=height(root.left);
        //     int rd=finddiameter(root.right);
        //     int rh=height(root.right);
        //     int selfdiameter=lh+rh+1;
        //     return Math.max(Math.max(ld, rd), selfdiameter);
        // }
        // // approach to find the diameter of the tree
        // // ----------------------
        // static class Info{
        //     int diameter;
        //     int height;
        //     Info(int diameter,int height){
        //         this.height=height;
        //         this.diameter=diameter;
        //     }
        // }
        // public static Info diameter(Node root){
        //     if(root==null){
        //         return new Info(0,0);
        //     }
        //     Info leftinfo=diameter(root.left);
        //     Info righInfo=diameter(root.right);
        //     int dia=Math.max(Math.max(leftinfo.diameter, righInfo.diameter),leftinfo.height+righInfo.height+1);
        //     int height=Math.max(leftinfo.height, righInfo.height)+1;
        //     return new Info(dia, height);
        // }
        // // check subtree is excit or not
        // public static boolean Issubtree(Node root,Node subroot){
        //     if(root==null){
        //         return false;
        //     }
        //     if(root.data==subroot.data){
        //         if(isidentical(root,subroot)){
        //             return true;
        //         }
        //     }

        //     return Issubtree(root.left, subroot)|| Issubtree(root.right, subroot);
        // }
        
        // public static boolean isidentical(Node root,Node sroot){
        //     if(root==null && sroot ==null){
        //         return true;
        //     }else if(root.data!=sroot.data || root==null || sroot==null){
        //         return false;
        //     }

        //     if(!isidentical(root.left, sroot.left)){
        //         return false;
        //     }
        //     if(!isidentical(root.right, sroot.right)){
        //         return false;
        //     }
        //     return true;
            
        // }

        // ------------------------------top view of -------------
        static class Info{
            Node node;
            int hd;
            public Info(Node head,int hd){
                this.node=head;
                this.hd=hd;
            }
        }
        public static void Topview(Node root){
           
             Queue <Info> q=new LinkedList<>();
             HashMap<Integer,Node> map=new HashMap<>();
             q.add(new Info(root, 0));
             q.add(null);
            int min=0,max=0;
             while(!q.isEmpty()){
                Info curr=q.remove();
                if(curr==null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    if(!map.containsKey(curr.hd)){
                        map.put(curr.hd, curr.node);

                    }

                    if(curr.node.left!=null){
                        q.add(new Info(curr.node.left, curr.hd-1));
                        min=Math.min(min, curr.hd-1);
                    }
                    if(curr.node.right!=null){
                        q.add(new Info(curr.node.right, curr.hd+1));
                        max=Math.max(max, curr.hd+1);
                    }
                }
             }
             for(int i=min;i<=max;i++){
              System.out.print(map.get(i).data+" ");
             }
        }
        // find the k level element 
        public static  void printKlevel(Node root,int level,int k){
            if(root==null){
                return ;
            }
             if(level==k){
                System.out.print(root.data+" ");
                return;
             }

             printKlevel(root.left, level+1, k);
             printKlevel(root.right, level+1, k);
        }
        // find first ancestor given two nodes
        public static Node findancestor(Node root,int n1,int n2){
        if(root==null || root.data==n1|| root.data==n2){
            return root;
        }
         
        Node left=findancestor(root.left, n1, n2);
        Node right=findancestor(root.right, n1, n2);
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        return root;
    }
    // find the minimum distance btween two nodes
    public static int minimumDistance(Node root,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftdistnce=minimumDistance(root.left, n);
        int rightdistance=minimumDistance(root.right, n);

        if(leftdistnce==-1  && rightdistance==-1){
            return -1;
        }
        else if(leftdistnce==-1){
            return rightdistance+1;
        }

        else{
            return leftdistnce+1;
        }

    }
    public static int minimum(Node root,int n1,int n2){
        if(root==null){
            return -1;
        }

           Node ancestor=findancestor(root, n1, n2);
           int indx1=minimumDistance(root,n1);
           int indx2=minimumDistance(root, n2);
           return indx1+indx2+1;
     }

    }
    public static void main(String[] args) {
        int nodes[]={1,2,3,-1,-1,4,-1,-1,5,6,-1,-1,7,-1,-1};
        BinaryTree b=new BinaryTree();
        Node root=b.buildtree(nodes);
        Node nn=new Node(2);
        nn.left=new Node(3);
        nn.right=new Node(5);                                                                           
        
    //     System.out.println();
    //    b.inorder(root);
    //    System.out.println();
    //    b.postorder(root);
    //    System.out.println();
    //    b.levelOrder(root);
    //    System.out.println("height of the tree is "+b.height(root));
    //      System.out.println("n of nodes "+ b.count(root));

    //      System.out.println("N sum of nodes in tree "+b.sum(root));
    //      System.out.println("diameter " + b.diameter(root).diameter);
    //      System.out.println("sum of root "+b.Issubtree(root, nn));
    // b.Topview(root);

        //   b.printKlevel(root, 1, 2);
        //  System.out.println( b.findancestor(root, 3, 7).data);

          System.out.println(b.minimum(root, 3, 7));
    }
}
