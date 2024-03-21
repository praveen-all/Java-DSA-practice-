public class wildcardmatching {
    public static boolean ComapreTwoCharacter(String str,String pat){
        int n=str.length();
        int m=pat.length();

        boolean dp[][]=new boolean[n+1][m+1];
        
        // initialization step
        dp[0][0]=true;

        for(int i=1;i<n+1;i++){
            dp[i][0]=true;
        }

        for(int j=1;j<m+1;j++){
            if(pat.charAt(j-1)=='*'){
                  dp[0][j]=dp[0][j-1];
            }
        }
        // fill 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str.charAt(i-1)==pat.charAt(j-1)|| pat.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(pat.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String str="baaabab";
        String  pat="*****ba*****ab";
        System.out.println(ComapreTwoCharacter(str,pat));
    }
}
