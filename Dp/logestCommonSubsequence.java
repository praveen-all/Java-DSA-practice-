import javax.swing.Box.Filler;

public class logestCommonSubsequence {
    public static int lcs(String a,String b){
        char dp[][]=new char[a.length()][b.length()];
        for(int i=0;i<a.length();i++){
            char c=a.charAt(i);
            for(int j=0;j<b.length();j++){
                if(c==b.charAt(j))
                    dp[i][j]=c;
                    else{
                        dp[i][j]='0';
                    }
                
            }
        }
        int count=0;
        for(int i=0;i<a.length();i++){
            
            for(int j=0;j<b.length();j++){
                if(dp[i][j]!='0'){

                    count++;
                }
                
            }
        }
        return count;
    }
    public static int lcsrecursion(String str1,String str2,int n,int m){
        if(n==0 || m==0){
            return 0;
        }

        if(str1.charAt(n-1)==str2.charAt(m-1)){
            return lcsrecursion(str1, str2, n-1, m-1)+1;
        }else{
            int ans1=lcsrecursion(str1, str2, n-1, m);
            int ans2=lcsrecursion(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }
    public static int memoizaion(String str1,String str2,int n,int m,int[][]dp){
            if(m==0 || n==0){
                return 0;
            }
 
            if(dp[n][m]!=-1){
                return dp[n][m];
            }

            if(str1.charAt(n-1)==str2.charAt(m-1)){
               dp[n][m]=memoizaion(str1, str2, n-1, m-1, dp)+1;
            }else{
                int ans1=memoizaion(str1, str2, n-1, m, dp);
                int ans2=memoizaion(str1, str2, n, m-1, dp);
               dp[n][m]= Math.max(ans1, ans2);
            }
               return dp[n][m];
    }
    public static int tabulation(String s,String p){
        int n=s.length();
        int m=p.length();
        int [][]dp=new int[n+1][m+1];//declaration

        // initialize
        for(int i=0;i<dp.length;i++){
        for(int j=0;j<dp[0].length;j++){
            if(i==0 || j==0)
            dp[i][j]=0;
        }
        }

        // Fill
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s.charAt(i-1)==p.charAt(j-1)){
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
    public static void main(String[] args) {
        String str1="abcdge";
        String str2="abdg";
        System.out.println(lcs(str1,str2));
        System.out.println(lcsrecursion(str1,str2,str1.length(),str2.length()));
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                dp[i][j]=-1;
            }
        }

        System.out.println(memoizaion(str1,str2,n,m,dp));
        System.out.println(tabulation(str1, str2));

    }
}
