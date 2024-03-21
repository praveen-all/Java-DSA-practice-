import java.util.*;
public class leet {
    public static void print(int[]arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");

        }
        System.out.println();
    }
    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        // print(nums);
        int count=0;
        int i=1;
         for( ;i<nums.length;i++){
             if(nums[i]<=nums[i-1]){
                 count++;
                 nums[i]++;
                 Arrays.sort(nums);
                 i=1;
                 i--;
             }
         }
     return count;
     
  }
    public static void main(String[] args) {
        int arr[]={2,1,1,1};
       System.out.println(minIncrementForUnique(arr));
    }
}
