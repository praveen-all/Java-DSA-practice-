import java.util.*;
// this is only code for greatest integer right of an array
public class RightGreaterStack {
    public static void main(String[] args) {
        int arr[]={6,8,0,1,3};
        int greatRight[]=new int[arr.length];

        Stack<Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            // check right greatest 

            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }

            //  
              
           if(s.isEmpty()){
            greatRight[i]=-1;
           }else{
            greatRight[i]=arr[s.peek()];
           }

           s.push(i);

        }

        for(int i=0;i<greatRight.length;i++){
            System.out.print(greatRight[i]+"  ");
        }
        System.out.println();
    }
}
