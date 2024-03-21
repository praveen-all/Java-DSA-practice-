public class climbingStairs {
    public static int ways(int n,int []f ){
        if(n==0)
            return 1;

        if(n<0){
            return 0;
        }
        if(f[n]!=0){
            return f[n];
        }
        return f[n]=ways(n-1, f)+ways(n-2, f)+ways(n-3, f);
    }
    public static void main(String[] args) {
        int n=1;
        int []f=new int[n+1];
        System.out.println(ways(n,f));
    }
}
