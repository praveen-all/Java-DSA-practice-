import java.util.ArrayList;
import java.util.Scanner;

// package ArrayList;

public class storeWater {
    public static int storewater(ArrayList<Integer> list){
        int maxwater=0;
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                int h=Math.min(list.get(i), list.get(j));
                int w=j-i;
                maxwater=Math.max(maxwater, h*w);
            }

        }
        return maxwater;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        ArrayList<Integer> list=new ArrayList<>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        System.out.println("maximum water stored is"+ storewater(list));
    }
}
