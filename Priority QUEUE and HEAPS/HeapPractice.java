import java.security.PublicKey;
import java.util.*;
import java.util.zip.Adler32;

public class HeapPractice {
     static ArrayList<Integer> al=new ArrayList<>();
     static class PriorityQueue{
        public void add(int data){
            al.add(data);
            int x=al.size()-1;
            int p=(x-1)/2;
            while(al.get(x)<al.get(p)){
                int temp=al.get(x);
                al.set(x, al.get(p));
                al.set(p, temp);
                x=p;
                p=(x-1)/2;
            }
        }
        public int peek(){
            if(al.size()==0){
                System.out.println("under flow");
                return -1;
            }
            return al.get(0);
        }
        private void hepify(int index){
            int left=2*index+1;
            int right=2*index+2;
            int mindex=index;
            if(left<al.size() &&  al.get(left)<al.get(mindex))
            mindex=left;
            if(right<al.size() && al.get(right)<al.get(mindex))
            mindex=right;

            if(mindex!=index){
                int temp=al.get(mindex);
                al.set(mindex, al.get(index));
                al.set(index, temp);
                hepify(mindex);
            }
        }
        public int pop(){
            if(al.size()==0){
                System.out.println("under flow");
                return -1;
            }
            int data=al.get(0);
            al.set(0, al.get(al.size()-1));
            al.set(al.size()-1,data);

           int a= al.remove(al.size()-1);
            hepify(0);
            return a;
        }
        public boolean isEmpty(){
            return al.size()==0;
        }
     }
    //  implement heapsort 
    // 1) heapipy the n/2 element means :- we will get fist high element
    //  2)swap from i 0 to n-1 call heapify (0,i)
   private static void heapify(int arr[],int i,int n){
          int left=2*i+1;
          int right=2*i+2;
          int max=i;
          if(left<n && arr[left]>arr[max]){
            max=left;
          }
          if(right<n && arr[right]>arr[max]){
            max=right;
          }
          if(max!=i){
            int temp=arr[max];
            arr[max]=arr[i];
            arr[i]=temp;
            heapify(arr, max, n);
          }
   }
    public static void heapsort(int []arr){
        int n=arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }
        // 
        for(int i=n-1;i>0;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            heapify(arr, 0, i);
        }
        for(int i=0;i<arr.length;i++){

            System.out.println(arr[i]);
        }
        
    }
     public static void main(String[] args) {
        // PriorityQueue pq=new PriorityQueue();
        // pq.add(23);
        // pq.add(34);
        // pq.add(9);
        // pq.add(556);
        // pq.add(884);
        // while(!pq.isEmpty()){
        //     System.out.println(pq.pop());
        // }
        int arr[]={3,5,6,3,2,2,3,43,3};
        heapsort(arr);
        for(int i=0;i<arr.length;i++){

            System.out.println(arr[i]);
        }
     }
}
