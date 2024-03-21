import java.util.ArrayList;
import java.util.*;

public class lonelyNumber {
    public static  ArrayList <Integer> lonely( ArrayList <Integer> num){
        ArrayList <Integer>list=new ArrayList<>();
        
        Collections.sort(num);
        for(int i=1;i<num.size()-1;i++){
            if(num.get(i-1)+1<num.get(i) &&  num.get(i)+1<num.get(i+1) ){
                list.add(num.get(i));
            }
        }
       int n=num.size();
        if(num.size()==1){
            list.add(num.get(0));
            
        }

        if(num.size()>1){
            if(num.get(0)+1<num.get(1)){
                list.add(num.get(0));
            }
            if(num.get(n-2)+1 <num.get(n-1)){
                list.add(num.get(n-1));
            }
        }


        return list;
    }
public static void main(String[] args) {
    
    ArrayList <Integer> num=new ArrayList<>();
    num.add(10);
    num.add(5);
    num.add(6);
    num.add(8);

   System.out.println( lonely(num));
}
}
