import java.util.*;
public class queue{
 public static void main(String[] args) {
  Deque<Integer> q=new LinkedList<>();
  q.addFirst(12);
  q.addLast(45);
  q.addLast(67);
  q.addLast(889);
  q.addLast(444);
  while(!q.isEmpty()){
    System.out.println(q.remove());
  }
 }
}
while( t-- > 0 ){
  String s = sc.next();
  if( s.length() < 4 ){
      System.out.println("Error");
  }
  else if( s.charAt(0) != '<' || s.charAt(s.length()-1) != '>' || s.charAt(1) != '/' ){
      System.out.println("Error");
  }
  else{
      boolean flag = true;
      
      for( int i = 2 ; i < s.length() - 1 ; i++  ){
          if( ( s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ) || (s.charAt(i) >= '0' && s.charAt(i) <= '9') ){
              continue;
          }
          else{
              flag = false;
              break;
          }
      }