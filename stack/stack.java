import java.util.ArrayList;

// this is practicing 
import java.util.*;


public class stack{

// public static void greatest(int arr[],int greatest[]){
//     Stack<Integer> s=new Stack<>();
//     int n=arr.length;
//     greatest[n-1]=-1;
//    s.push(n-1);
//    for(int i=n-2;i>=0;i--){
//     int cur=arr[i];
//     while(!s.empty() && arr[s.peek()]<=cur){
//           s.pop();
//     }
//     if(s.empty()){
//         greatest[i]=-1;
//     }else{
//         greatest[i]=arr[s.peek()];
//     }
//     s.push(i);
//    }


// }
public static int histogram(int arr[]){
    int n=arr.length;
    int left[]=new int[n];
    int right[]=new int[n];

    Stack<Integer> s=new Stack<>();
    right[n-1]=n;
    s.push(n-1);
    for(int i=n-2;i>=0;i--){
        
        int cur=arr[i];
        while(!s.isEmpty() && cur<=arr[s.peek()]){
                 s.pop();
        }

        if(s.isEmpty()){
            right[i]=n;
        }else{
            right[i]=s.peek();
        }
        s.push(i);
    }
    s=new Stack<>();
    left[0]=-1;
    s.push(0);
    for(int i=0;i<n;i++){
        int cur=arr[i];
        while(!s.isEmpty() && cur<=arr[s.peek()]){
            s.pop();
        }
        if(s.isEmpty()){
            left[i]=-1;
        }
        else{
            left[i]=s.peek();
        }
        s.push(i);
    }


    // for(int i=0;i<n;i++){
    //     System.out.print(left[i]+" ");
    // }
    int max=Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
        int val=right[i]-left[i]-1;
        max=Math.max(max,val*arr[i]);
    }
    return max;

}
    public static void main(String[] args) {
       int arr[]={2,1,5,6,2,3};
      
     System.out.println(histogram(arr));
    }
}