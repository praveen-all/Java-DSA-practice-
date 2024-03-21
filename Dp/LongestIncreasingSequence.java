import java.util.*;

public class LongestIncreasingSequence{
    public static int lcs(int []arr,int []arr1){
        int n=arr.length;
        int m=arr1.length;
        int [][]dp=new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr[i-1]==arr1[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }
    public static int LIS(int []arr){
       HashSet<Integer> s=new HashSet<>();
       for(int i=0;i<arr.length;i++){
        s.add(arr[i]);
       }    

       int arr1[]=new int[s.size()];
       int j=0;
       for (int i : s) {
        arr1[j]=i;
        j++;
       }
       return lcs(arr,arr1);
    }
public static void main(String[] args) {
    int arr[]={50,3,10,7,40,80};
    System.out.println(LIS(arr));
}
}