public class practice {
   public static int totalgrid(int i,int j,int m,int n){
    if(i==m-1 && j==n-1){
        return 1;

    }else if(i==m || j==n){
        return 0;
    }
    int w1=totalgrid(i+1, j, m, n);
    int w2=totalgrid(i, j+1, m, n);
    return w1+w2;
   }
    public static void main(String[] args) {

   System.out.println(totalgrid(0,0,4,4));
    }
}
