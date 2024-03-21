import java.util.ArrayList;
import java.util.Scanner;

public class monotonicarraylist {
    public static boolean findpair(ArrayList<Integer> list){
        
        if(list.get(0)>list.get(1)){
            for(int i=0;i<list.size()-1;i++){
                if(list.get(i)<list.get(i+1)){
                    return false;
                }
            }
        }else{
            for(int i=0;i<list.size()-1;i++){
                if(list.get(i)>list.get(i+1)){
                    return false;
                }
            }
        }
        return true;
       
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList <Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }

        System.out.println(findpair(list));
    }
}
