public class grid {
    public static int grid(int i,int j,int n,int m){
        if(i==m-1 && j==n-1){
            return 1;
        }else if(i==m || j==n){
            return 0;
        }

        int w1=grid(i+1, j, n, m);
        int w2=grid(i, j+1, n, m);
        return w1+w2;
    }
    public static void main(String[] args) {
        
        System.out.println(grid(0,0,3,8));
    }
}
