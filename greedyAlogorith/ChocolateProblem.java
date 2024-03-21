import java.lang.reflect.Array;
import java.util.*;
public class ChocolateProblem {
    public static void main(String[] args) {
        int n=4,m=6;
        Integer costvetical[]={2,1,3,1,4};//m-1
        Integer costhorizontal[]={4,1,2};//n-1

        // sort descending order because we go high cost to low cost


           Arrays.sort(costvetical,Collections
           .reverseOrder());
           Arrays.sort(costhorizontal,Collections.reverseOrder());

           int h=0,v=0,vp=1,hp=1,cost=0;

           while(h<costhorizontal.length && v<costvetical.length){
             if(costvetical[v]<=costhorizontal[h]){
                cost+=(vp*costhorizontal[h]);
                h++;
                hp++;
             }else{
                cost+=(hp*costvetical[v]);
                 v++;
                 vp++;
             }
           }

           while(h<costhorizontal.length){
            cost+=(vp*costhorizontal[h]);
            hp++;
            h++;
           }


           while(v<costvetical.length){
            cost+=(hp*costvetical[v]);
            v++;
            vp++;
           }


           System.out.println("minum cost is "+ cost);
    }
}
