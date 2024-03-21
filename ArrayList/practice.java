import java.util.*;
public class practice{
    static List<List<Integer>> res=new ArrayList<>();
    public static List<List<Integer>> threeSum(int[] nums) {
        // reverse an array to distrubute which is a ,b and c
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            // skip duplicate a
            if(i==0 || nums[i]!=nums[i-1]){
                 twonumberadd(i+1,nums.length-1,nums,0-nums[i]);
            }
        }
      return res;
    }

    public static void twonumberadd(int i,int j,int[]nums,int target){
         int a=nums[i-1];
         while(i<j){
            if(nums[i]+nums[j]>target){
                j--;
            }else if(nums[i]+nums[j]<target){
                i++;
            }else{
            List<Integer> list=new ArrayList<>();
               list.add(a);list.add(nums[i]);list.add(nums[j]);
               res.add(list);
            // check duplicate b
            while(i<j&&nums[i]==nums[i+1]) i++;
            while(i<j && nums[j]==nums[j-1]) j--;
            i++;
            j--;
            }
         }
    }
    public static void main(String[] args) {
        int arr[]={-1,0,1,2,-1,-4};
        List<List<Integer>> ll=new ArrayList<>();
      ll=  threeSum(arr);
        System.out.println(ll);
    }
}