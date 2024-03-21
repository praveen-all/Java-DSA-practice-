public class targetsumset {
    public static boolean target(int []arr,int sum){
        int n=arr.length;

        //create dp array first step
        boolean[][] dp=new boolean[n+1][sum+1];

        // initializing 
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }

        // assign meaning
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                // valide case
                if(arr[i-1]<=j && dp[i-1][j-arr[i-1]]==true){

                    dp[i][j]= true;
                }else if(dp[i-1][j]==true){
                    dp[i][j]= true;

                }
            }
        }
        // print(dp);
        return dp[n][sum];
    }
    public static void print(boolean[][]dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[]={4,2,7,1,3,3,5,33,4,3,3,34,34,3,4,3,4};
        int sum=1000;
        System.out.println(target(arr,sum));
    }
}
