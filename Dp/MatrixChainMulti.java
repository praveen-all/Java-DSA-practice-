import java.util.Arrays;

public class MatrixChainMulti {
    public static int mcm(int a[],int i,int j){
        if(i==j){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1=mcm(a, i, k);
            int cost2=mcm(a,k+1,j);//arr[1,2]=>a2=arr[1]*arr[2];
            int cost3=a[i-1]*a[k]*a[j];
            int finalcost=cost1+cost2+cost3;
            ans=Math.min(ans, finalcost);
        }
        return ans;
    }
    public static int memoization(int a[],int i,int j,int [][]dp){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1=memoization(a, i, k, dp);
            int cost2=memoization(a, k+1, j, dp);
            int cost3=a[i-1]*a[k]*a[j];
            ans=Math.min(ans, cost3+cost1+cost2);
        }
        return dp[i][j]=ans;
    }
    public static int tabulation(int arr[]){
        int n=arr.length;
        int dp[][]=new int[n][n];

        // initialization
        for(int i=0;i<n;i++){
            dp[i][i]=0;
        }

        // fill
        for(int len=2;len<=n-1;len++){
            for(int i=1;i<=n-len;i++){
                int j=i+len-1;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int cost1=dp[i][k];
                    int cost2=dp[k+1][j];
                    int cost3=arr[i-1]*arr[k]*arr[j];
                dp[i][j]=Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }
        return dp[1][n-1];
    }
    public static void main(String[] args) {
        int arr[]={1,4,5,6};
        int n=arr.length;
        System.out.println(mcm(arr,1,n-1));
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i+=1){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(memoization(arr, 1, n-1, dp));
        System.out.println(tabulation(arr));
    }
}
