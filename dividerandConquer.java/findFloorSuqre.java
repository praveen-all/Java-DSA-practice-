public class findFloorSuqre {

    public static int floosqrt(int n){
        if(n==0 ||n==1){
            return n;
        }
        int i=1,result=1;
        while(result<=n){
             i++;
             result =i*i;
        }
        return i-1;
    }
    public static void main(String[] args) {
       System.out.println( floosqrt(47));
    }
}
