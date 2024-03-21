import java.util.*;
public class stockSpanSTACK {
    
    public static void Stockspan(int[]Stock,int[]span){
        Stack<Integer> s=new Stack<>();
        span[0]=1;
        s.push(0);
        for(int i=1;i<Stock.length;i++){
            int current=Stock[i];
            while(!s.isEmpty() && current>=Stock[s.peek()] ){
                s.pop();
            }

            if(s.isEmpty()){
                span[i]=i+1;
            }else{
                int high=s.peek();
                span[i]=i-high;
            }
            s.push(i);
        }
    }
      public static void main(String[] args) {
        int [] Stock={100,80,60,70,60,85,100};
        int [] span=new int[Stock.length];
        Stockspan(Stock,span);

        for(int i=0;i<span.length;i++){
            System.out.print(span[i]+"  ");
        }
      }   
}
