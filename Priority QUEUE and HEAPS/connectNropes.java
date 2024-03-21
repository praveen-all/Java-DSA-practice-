import java.util.*;
// given n ropes add to make big rope with minimum cost
public class connectNropes {
   public static void main(String[] args) {
    int arr[]={2,33,4,3,3,2,4,6};
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    for(int i=0;i<arr.length;i++){
        pq.add(arr[i]);
    }
    int cost=0;
    while(pq.size()>1){
        int min=pq.remove();
        int min2=pq.remove();
        cost+=min+min2;
        pq.add(min+min2);
    }
    System.out.println(cost);
   } 
}