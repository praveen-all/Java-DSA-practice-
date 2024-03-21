public class Insert{
    static class Node{
        Node children[]=new Node[26];
        boolean endofword=false;
       Node(){
        for(int i=0;i<children.length;i++){
            children[i]=null;
        }
       }
    }

  public static  Node root=new Node();
  public static void insert(String str){
          Node cur=root;
          for(int i=0;i<str.length();i++){
            int indx=str.charAt(i)-'a';
            if( cur.children[indx]==null){
                cur.children[indx]=new Node();
            }
            cur=cur.children[indx];
          }
          cur.endofword=true;
  }
    //  search any string in trie
    public static boolean search(String str){
        Node cur=root;
        for(int i=0;i<str.length();i++){
            int indx=str.charAt(i)-'a';
            if(cur.children[indx]==null){
                return false;
            }
            cur=cur.children[indx];
        }

        return cur.endofword==true;
    }
    public static boolean wordBreakProblem(String str){
        if(str.length()==0){
            return true;
        }

        for(int i=1;i<=str.length();i++){
            if(search(str.substring(0,i)) && wordBreakProblem(str.substring(i))){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String words[]={"i","like","sam","samsung","thee"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(search("there"));
        System.out.println(search("those"));
        System.out.println(search("a"));
    }
}