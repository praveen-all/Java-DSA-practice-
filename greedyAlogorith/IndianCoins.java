import java.util.*;
public class IndianCoins {
    public static void main(String[] args) {
        Integer coins[]={1,2,5,10,20,50,100,500,2000};
         Scanner sc=new Scanner(System.in);
         int amount=sc.nextInt();
         int amt=amount;
        int count=0;
         Arrays.sort(coins,Comparator.reverseOrder());
         ArrayList<Integer> ans=new ArrayList<>();
         for(int i=0;i<coins.length;i++){
           if(coins[i]<=amount){
            while(coins[i]<=amount){
                ans.add(coins[i]);
                amount-=coins[i];
                count++;
            }
           }
           if(amount==0){
            break;
           }
         }

         System.out.println("min number of coins required "+count);

         for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" + ");
         }
         System.out.println("= "+amt);
    }
}
