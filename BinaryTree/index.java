import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.relation.Role;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.xml.crypto.Data;

public class index {
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
    static class BinaryTree{
        static int index=-1;
        public node buildtree(int arr[]){
            index++;
            if(arr[index]==-1){
                return null;
            }
            node newnode=new node(arr[index]);
            newnode.left=buildtree(arr);
            newnode.right=buildtree(arr);
            return newnode;
        }

        public void preorder(node root){
            if(root==null){
                return ;
            }
            preorder(root.left);
            System.out.print(root.data+"  ");
            preorder(root.right);
        }
        // find the height of the tree

        public int height(node root){
            if(root==null){
                return 0;
            }
            int lh=height(root.left);
            int rh=height(root.right);
            return Math.max(lh,rh)+1;
        }

        // implement diameter of the tree
        public int Diameter(node root){
            if(root==null){
                return 0;
            }
            int ld=Diameter(root.left);
            int rd=Diameter(root.right);
            int lh=height(root.left);
            int rh=height(root.right);
            int self=lh+rh+1;
            return Math.max(ld,Math.max(rd, self));
        }                
        
        static class inf{
            int diameter;
            int height;
            public inf(int diameter,int height){
                this.diameter=diameter;
                this.height=height;
            }
        }
        
        public inf Diameter2(node root){
            if(root==null){
                return new inf(0, 0);

            }
            inf left=Diameter2(root.left);
            inf right=Diameter2(root.right);
            int diameter=Math.max(left.diameter,Math.max(right.diameter, left.height+right.height+1));
            int height=Math.max(left.height,right.height)+1;
            return new inf(diameter, height);
            
        }
        // check if given tree is the subtree of another tree
        public boolean IsSubRoot(node root,node subroot){
            if(root==null){
                return false;
            }
            if(root.data==subroot.data){
                if(isIdentical(root,subroot)){
                    return true;
                }
            }

            return IsSubRoot(root.left, subroot)|| IsSubRoot(root.right, subroot);
        }

        public boolean isIdentical(node root,node subroot){
            if(root==null && subroot==null){
                return true;
            }else if(root==null || subroot ==null){
                return false;
            }else if(root.data!=subroot.data){
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
        // top view of a tree

        static class Info{
            node Node;
            int hd;
            public Info(node Node,int hd){
                this.Node=Node;
                this.hd=hd;
            }
        }
        public void topView(node root){
          
            // creating queue for level order

            Queue<Info> q=new LinkedList<>();
            HashMap<Integer,node> map=new HashMap<>();
            int min=0,max=0;
            q.add(new Info(root, 0));
            q.add(null);
            while(!q.isEmpty()){
                Info curr=q.remove();
                if(curr==null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }

                }
                else{
                  if(!map.containsKey(curr.hd)){
                        map.put(curr.hd, curr.Node);
                    }

                    if(curr.Node.left!=null){
                        q.add(new Info( curr.Node.left,curr.hd-1));
                        min=Math.min(min, curr.hd-1);
                    }

                    if(curr.Node.right!=null){
                        q.add(new Info(curr.Node.right,curr.hd+1));
                        max=Math.max(max,curr.hd+1);
                    }



                }
            }

            for(int i=min;i<=max;i++){
            System.out.println(map.get(i).data);
            }

        }
    }
    public static void main(String[] args) {
        BinaryTree b=new BinaryTree();
        int arr[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
       node root= b.buildtree(arr);
       System.out.println(root.data);
       System.out.println(b.Diameter(root));
       System.out.println(b.Diameter2(root).diameter);
       int a[]={2,4,-1,-1,5,-1,-1};
       BinaryTree.index=-1;
       node subroot=b.buildtree(a);
       System.out.println(b.IsSubRoot(root, subroot));
       b.topView(root);
    }
}
