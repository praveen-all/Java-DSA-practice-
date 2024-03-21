import java.util.ArrayList;
import java.util.Scanner;
// this approach uses an linear
public class PairSum {

    public static boolean pairsumm(ArrayList<Integer> list,int target){
        int sp=0;
        int ep=list.size()-1;
        while (sp!=ep) {
            int sum=list.get(sp)+list.get(ep);
            if(sum==target){
                return true;
            }else if(sum>target){
                ep--;
            }else{
                sp++;
            }
        }
        return  false;
    }
    public static void main(String[] args) {
       ArrayList<Integer> list=new ArrayList<>();
         list.add(1);
         list.add(2);
         list.add(3);
         list.add(4);
         list.add(5);
         list.add(6);
         list.add(7);

         System.out.println(pairsumm(list, 2));
    }
}
