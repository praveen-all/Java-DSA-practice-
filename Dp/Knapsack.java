import java.util.*;
// knapsack is the bag which can hold maximum W , we have to output what is maximum amount for mininum Weight W
// here we used an Memoization method (dp) to optimal existing recursion to optimized recursion
public class Knapsack {
    public static int knapsack(int val[],int wt[],int W,int n,int [][]dp){
        if(W==0 ||n==0){
             return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){
            // either include or exclude
         int ans1=val[n-1]+ knapsack(val, wt, W-wt[n-1], n-1,dp);
        //    exlude
        int ans2=knapsack(val, wt, W, n-1,dp);

            return dp[n][W]= Math.max(ans1, ans2);
    }
    else{
            return dp[n][W]=knapsack(val, wt, W, n-1,dp);
    }

    }
    // knapsack using tabulation method
    public static int tabulation(int val[],int wt[],int W,int dp[][]){
        int n=val.length;
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int value=val[i-1];
                int  w=wt[i-1];

                if(w<=j){
                    int include=value+dp[i-1][j-w];
                    int exclude=dp[i-1][j];
                   dp[i][j]= Math.max(include, exclude);
                }else{
                  dp[i][j]=dp[i-1][j];
                }

                    }      
                  }

                  return dp[dp.length-1][dp[0].length-1];

    }
    public static void main(String[] args) {
        int val[]={15,14,10,45,30,};
        int wt[]={2,5,1,3,4};
        int W=7;
        int dp[][]=new int[val.length+1][W+1];
      for(int i=0;i<dp.length;i++){
        for(int j=0;j<dp[0].length;j++){
            dp[i][j]=-1;
        }
      }
        // System.out.println(knapsack(val,wt,W,val.length,dp));
        System.out.println(tabulation(val, wt, W, dp));
    }
}
