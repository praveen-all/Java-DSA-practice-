public class coinChange {
    public static int coincahngeTabulation(int[]arr,int sum){
        int n=arr.length;
        // declare 2D array
        int [][]dp=new int[n+1][sum+1];
        // initialize
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i][j-arr[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][sum];

    }
    public static void print(int[][]dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[]={2,5,1,6};
        int sum=10;
        System.out.println(coincahngeTabulation(arr, sum));
    }
}
