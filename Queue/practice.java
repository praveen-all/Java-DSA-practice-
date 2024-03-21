// implementation of queue using LinkedList

import java.util.*;
public class practice {

    static Stack<Integer> s1=new Stack<>();
    static Stack<Integer> s2=new Stack<>();
 
  
public boolean empty(){
    return s1.isEmpty() && s2.isEmpty();
}
public void push(int data){
    s1.push(data);
}
public int pop(){
    int val=s2.pop();
    return val;
}

public int peek(){
   if(s2.isEmpty()){
        while(s1.isEmpty()==false){
        s2.push(s1.pop());
    }
   }
   return s2.pop();
}
public static void main(String[] args) {
    practice q=new practice();
    q.push(12);
    q.push(45);
    q.push(77);
    q.push(67);
    while(!q.empty()){
      System.out.println(q.pop());
    }
}
}
