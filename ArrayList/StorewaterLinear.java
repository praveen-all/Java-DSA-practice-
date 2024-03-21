import java.util.ArrayList;
// here we got linear time complexity
public class StorewaterLinear {
    public static int storewater(ArrayList<Integer> list){
        int lp=0,rp=list.size()-1;

         int maxwater=0;
        while (lp<rp) {
            int h=Math.min(list.get(lp), list.get(rp));
            int w=rp-lp;
            int currentwater=h*w;
            maxwater=Math.max(maxwater, currentwater);
            if(list.get(lp)<list.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }

        return maxwater;

    }
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        System.out.println(storewater(list));
    }
}
