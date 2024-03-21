public class catalans {
    public static int catalan(int n,int []dp){
        if(n==0||n==1){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
int ans=0;
        for(int i=0;i<n;i++){
          ans+=catalan(i,dp)*catalan(n-i-1,dp);
        }
        dp[n]=ans;
        return dp[n];
    }

    // catalan using tabulation method
    public static int tabulation(int n){
        int dp[]=new int[n+1];

        dp[0]=dp[1]=1;
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        
        return dp[n];
    }
    public static void main(String[] args) {
        int n=52;
        // int dp[]=new int[31];
        // System.out.println(catalan(n,dp));
        System.out.println(tabulation(n));
    }
}
