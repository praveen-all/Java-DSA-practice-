import java.util.*;
public class ActivitySelection{
    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};
    ArrayList<Integer> a=new ArrayList<>();
        int maxact=1;
        a.add(0);
        int lastend=end[0];
        for(int i=1;i<end.length;i++){
            if(start[i]>=lastend){
                maxact++;
                lastend=end[i];
                a.add(i);
            }

        }
        System.out.println("maximum activities "+maxact);
        for(int i=0;i<a.size();i++){
            System.out.print("A"+a.get(i)+"   ");
        }
    }
}