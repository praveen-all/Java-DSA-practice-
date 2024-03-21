import java.util.*;
public class CodeForHeapOperation {
    static class Heap{
        ArrayList<Integer> arr=new ArrayList<>();
        public void add(int data){
            arr.add(data);

            int x=arr.size()-1;
            int par=(x-1)/2;
            while(arr.get(x)<arr.get(par)){
                int temp=arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x=par;
                par=(x-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }
      
        public boolean isEmpty(){
            return arr.size()==0;
        }
  // now implement an remove function
        private void heapify(int i){
            
            int left=2*i+1;
            int right=2*i+2;
            int minIndx=i;

            if(left<arr.size() && arr.get(minIndx)>arr.get(left)){
                minIndx=left;
            }
            if(right<arr.size() && arr.get(minIndx)>arr.get(right)){
                minIndx=right;
            }

            if(minIndx!=i){
                int temp=arr.get(i);
                arr.set(i,arr.get(minIndx));
                arr.set(minIndx, temp);
                heapify(minIndx);
            }
          
        }


        public int remove(){
            int data=arr.get(0);
            // step 1
            int temp=arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // step 2 remove the last elemet in arrayList
            arr.remove(arr.size()-1);

            // heapify the arraylist
            heapify(0);

            return data;
        }
       
    }
    public static void main(String[] args) {
        Heap h=new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        h.add(88);
        h.add(894399);
        h.add(-1);
       while(!h.isEmpty()){
        System.out.println(h.peek());
        h.remove();
       }
    }
}
