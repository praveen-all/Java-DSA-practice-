
import java.util.ArrayList;
import java.util.*;

public class multi_dimensionalList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainlist=new ArrayList<>();
        ArrayList<Integer>list=new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(2);
        mainlist.add(list);
        // System.out.println(list);
        // System.out.println(mainlist);
        list.set(2, 9830283);
        // System.out.println(list);
        // System.out.println(mainlist);
        ArrayList<Integer> list2=new ArrayList<>();
        list2.add(98);
        list2.add(98);
        list2.add(98);
        list2.add(98);
        mainlist.add(list2);
        ArrayList<Integer> list3=new ArrayList<>();
        list3.add(9845);
        list3.add(9845);
        list3.add(9845);
        list3.add(9845);
        mainlist.add(list3);

        // mainlist.add(list2);
        // System.out.println(mainlist);


        // now printing main list using loop

        System.out.println(mainlist);

        // for(int i=0;i<mainlist.size();i++){
        //     System.out.println(mainlist.get(i));
        //     ArrayList <Integer> currentlist=mainlist.get(i);
        //     System.out.println(currentlist);
        //     for(int j=0;j<currentlist.size();j++){
        //         System.out.print(currentlist.get(i)+"  ");
        //     }
        // }

    }
}
