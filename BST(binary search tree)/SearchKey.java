import java.util.ArrayList;

public class SearchKey{
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
            public static Node buikdBST(Node root,int val){
                if(root==null){
                    root=new Node(val);
                    return root;
                }

                if(root.data>val){
                root.left=buikdBST(root.left, val);
                }else{
                    root.right=buikdBST(root.right, val);
                }

                return root;
            }    

            public static void inorder(Node root){
                if(root==null){
                    return ;
                }
                inorder(root.left);
                System.out.print(root.data+"  ");
                inorder(root.right);
            }

            public static boolean search(Node root,int key){
                if(root==null){
                    return false;
                }
                if(root.data==key){
                    return true;
                }
                if(root.data>key){
                   return search(root.left, key);
                }else{
                  return  search( root.right, key);
                }
            }
            // delete the nth value node \
            public static Node inorderSuccesor(Node root){
                while(root.left!=null){
                    root=root.left;
                }
                return root;
            }
            public static Node delete(Node root,int val){
                if(root.data>val){
                    root.left=delete(root.left, val);
                }else if(root.data<val){
                    root.right=delete(root.right, val);
                }else{
                    // leaf node
                    if(root.left==null&& root.right==null){
                        return null;
                    }

                    // only one children is present
                    if(root.left==null){
                        return root.right;
                    }else if(root.right==null){
                        return root.left;
                    }

                    Node is=inorderSuccesor(root.right);
                    root.data=is.data;
                    root.right=delete(root.right, is.data);
                }
                return root;
            }
            
        // print in range
        public static void printInRange(Node  root,int k1,int k2){
            if(root==null){
                return ;
            }
            if(k1<=root.data && root.data<=k2){
                printInRange(root.left, k1, k2);
                System.out.print(root.data+" ");
                printInRange(root.right, k1, k2);
            }else if(root.data<k1){
                printInRange(root.left, k1, k2);
            }else{
                printInRange(root.right, k1, k2);
            }
        }

        // print the path from root to leaf 
        public static void printout(ArrayList<Integer> path){
            for(int i=0;i<path.size();i++){
                   System.out.print(path.get(i)+"->");
            }
            System.out.println("null");
        }
        public static void printroot2leaf(Node root,ArrayList<Integer>path){
            if(root==null){
                return ;
            }
            path.add(root.data);
            if(root.left==null && root.right==null){
                printout(path);
            }
            printroot2leaf(root.left, path);
            printroot2leaf(root.right, path);
            path.remove(path.size()-1);
        }
        // check whether a give root of bst is true or not
        public static boolean isvalid(Node root,Node min,Node max){
            if(root==null){
                return true;
            }
            if(min!=null && root.data<=min.data){
                return false;
            }else if(max!=null && root.data>=max.data){
                return false;
            }

            return isvalid(root.left, min, root)&& isvalid(root.right, root, max);
        }

    public static void main(String[] args) {
        int values[]={8,5,3,1,4,6,10,11,14};
Node root=null;
         for(int i=0;i<values.length;i++){
            root=buikdBST(root, values[i]);
         }
        //   delete(root, 7);
        //  inorder(root);
        //  System.out.println("range");
        //  printInRange(root, 5, 12);
        // printroot2leaf(root, new ArrayList<>());

           if(isvalid(root, null,null)){
            System.out.println("valid");
           }else {
            System.out.println("not valid");
           }
    }
}

