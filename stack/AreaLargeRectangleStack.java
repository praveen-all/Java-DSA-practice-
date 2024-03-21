import java.util.*;

public class AreaLargeRectangleStack {
    public static void Maximum(int []arr){
            //   declare two array 1)next smallest left 2)next largest right
             int maxarea=0;
            int nsl[]=new int[arr.length];
            int nsr[]=new int[arr.length];
            
            // next smaller right array
            Stack<Integer> s=new Stack<>();
            for(int i=arr.length-1;i>=0;i--){
                while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                   
                    s.pop();
                }
                if(s.isEmpty()){
                    nsr[i]=arr.length;
                }else{
                    nsr[i]=s.peek();
                }
                s.push(i);
            }

            // next smaller left

            s=new Stack<>();
            for(int i=0;i<arr.length;i++){
                while(!s.empty() && arr[s.peek()]>=arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                   nsl[i]=-1;
                }else{
                    nsl[i]=s.peek();
                }
                s.push(i);
            }

             for(int i=0;i<nsl.length;i++){
               int area=arr[i]*(nsr[i]-nsl[i]-1);
               maxarea=Math.max(maxarea, area);
             }

             System.out.println(maxarea);

    }
    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};
        Maximum(arr);
    }
}
