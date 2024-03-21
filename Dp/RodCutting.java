public class RodCutting {
    public static int FindTotalProfit(int[]length,int []price,int L){
        int n=length.length;
        // declare an array
        int[][]dp=new int[n+1][L+1];
        // initialization step
        for(int i=0;i<n+1;i++){
            for(int j=0;j<L+1;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
            }
        }
        // meaning using i( cuted  )length piece, can we got maximum profit of given lengt J
        // is it possible 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<L+1;j++){
                if(length[i-1]<=j){
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-length[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][L];
    }
    public static void main(String[] args) {
        int length[]={1,2,3,4,5,6,7,8};
        int price[]={1,5,8,9,10,17,17,20};
        int rodLength=8;
        System.out.println(FindTotalProfit(length,price,rodLength));
    }
}
