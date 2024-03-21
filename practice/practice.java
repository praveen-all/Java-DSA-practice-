import java.util.*;
public class practice {
    public  int lastRemaining(int n) {
        int arr[]=new int[n];
        for(int i=1;i<=n;i++){
              arr[i-1]=i;
        }
        return lastnumber(arr);
    }

    public static int lastnumber(int arr[]){
        if(arr.length==1){
            return arr[0];
        }
            int bb[]=new int[arr.length/2];
            int j=0;
        for(int i=1;i<arr.length;i+=2){
            if(i>arr.length-1){
                break;
            }
              bb[j]=arr[i];
              j++;
        }
        if(bb.length==1){
            return bb[0];
        }

         int cc[]=new int[bb.length/2];
         j=cc.length-1;
        for(int i=bb.length-2;i>=0;i-=2){
            if(i<0){
                break;
            }
           cc[j]=bb[i];
           j--;
        }
        if(cc.length==1){
            return cc[0];
        }

      return  lastnumber(cc);
    }
 public static void main(String[] args) {
          System.out.println(lastRemaining(29));
 }
}