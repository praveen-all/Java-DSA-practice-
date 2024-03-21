import java.util.*;

public class Totalpractice {
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

   static class Tree{
    static int indx=-1;
    public Node buildtree(int nodes[]){
        indx++;
        if(nodes[indx]==-1){
            return null;
        } 
        Node newNode=new Node(nodes[indx]);
        newNode.left=buildtree(nodes);
        newNode.right=buildtree(nodes);

        return newNode;
    }
    public static void levelOrder(Node root){
        if(root==null){
            return ;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
       while(!q.isEmpty()){
        Node cur=q.remove();
        if(cur==null){
            if(q.isEmpty()){
                break;
            }else{
                System.out.println();
                q.add(null);
            }
        }else{
            System.out.print(cur.data+" ");
            if(cur.left!=null){
                q.add(cur.left);
            }
            if(cur.right!=null){
                q.add(cur.right);
            }
        }
       }
    }
   static List<List<Integer>> level=new ArrayList<>();
    public List<List<Integer>> levelOrdeer(Node root){
        level =new ArrayList<>();
        if(root==null){
            return level;
        }
        Queue<Node> q=new LinkedList<>();
        List<Integer> l=new ArrayList<>();
        q.add(root);
        boolean pavi=false;
        q.add(null);
        while(!q.isEmpty()){
          Node cur=q.remove();
          if(cur==null){
                   if(q.isEmpty()){
                    if(pavi){
                        Collections.sort(l);
                        pavi=pavi==true?false:true;
                             level.add(l);
                            }else{
                                level.add(l);
                            }
                    break;
                   }else{
                    if(pavi){
                Collections.reverse(l);
                pavi=pavi==true?false:true;
                     level.add(l);
                     l=new ArrayList<>();
                     q.add(null);
                    }else{
                        pavi=pavi==true?false:true;
                        level.add(l);
                        l=new ArrayList<>();
                        q.add(null);
                    }
                   }
          }else{
            l.add(cur.data);
            if(cur.left!=null){
                q.add(cur.left);
            }
            if(cur.right!=null){
                q.add(cur.right);
            }
          }

        }
        return level;
    }

}
   
    public static void main(String[] args) {
        Tree t=new Tree();
        
        int arr[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root=t.buildtree(arr);
        System.out.println(t.levelOrdeer(root));  
       
    }
}
