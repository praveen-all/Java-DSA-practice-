import java.util.*;
public class cf {
    public static void main(String[] args) {
    int nums[]={2,22,13,1200};
    ArrayList<Integer> ss=new ArrayList<>();
      
    for(int i=0;i<nums.length;i++){
        ArrayList<Integer> s=new ArrayList<>();
         int a=nums[i];
         while (a!=0) {
            
            s.add(a%10);
            a=a/10;
         }
         Collections.reverse(s);
         ss.addAll(s);
    }
System.out.println(ss);
   int arr[]=new int[ss.size()];
   for(int i=0;i<ss.size();i++){
    arr[i]=ss.get(i);
    
   }


   
       
}
}