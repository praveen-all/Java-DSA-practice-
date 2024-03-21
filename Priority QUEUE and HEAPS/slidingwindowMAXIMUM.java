import java.util.*;
public class slidingwindowMAXIMUM {
    static class Info implements Comparable<Info>{
                int val;
                int indx;
                public Info(int val,int indx){
                    this.val=val;
                    this.indx=indx;
                }

                @Override
                public int compareTo(Info p1){
                    // for decending order
                    return p1.val-this.val;
                }
    }
    public static void main(String[] args) {
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        int res[]=new int[arr.length-k+1];
        PriorityQueue<Info> pq=new PriorityQueue<>();

        // add first k members to pq
        for(int i=0;i<k;i++){
            pq.add(new Info(arr[i], i));
        }
        res[0]=pq.peek().val;

        for(int i=k;i<arr.length;i++){
            while(pq.size()>1 && pq.peek().indx<=(i-k)){
                pq.remove();
            }
            pq.add(new Info(arr[i], i));
            res[i-k+1]=pq.peek().val;

        }

        // print all maximum value
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }

        // 
    }
}
