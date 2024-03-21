import java.util.*;

public class queuePractice {
public static  int  firstNone(String str){
    Queue<Integer> q=new LinkedList<>();
       int freq[]=new int[26];
    for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
        q.add(i);
        freq[ch-'a']++;
    }
    while(!q.isEmpty()){
       if(freq[str.charAt(q.peek())-'a']<=1){
        return q.peek();
       }
       q.remove();
    }
    return -1;
}
public static void main(String[] args) {
   System.out.println(firstNone("loveleetcode"));
}
}