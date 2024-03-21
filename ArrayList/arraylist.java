
import java.util.ArrayList;
import java.util.Collections;

public class arraylist {
    public static void main(String[] args) {
    ArrayList<Integer> list=new ArrayList<>();
    ArrayList<Integer> listreverse=new ArrayList<>();
    

          list.add(15);
          list.add(36);
          list.add(4);
          list.add(-9);
        //   we are using COllections.sort() :- which perform  sorting operation
        // and comaprator are function which defines sorting logic
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list,Collections.reverseOrder());//here "Collections.reverseOrder()" is an comparator which build logic for sorting
                System.out.println(list);
        
    }
}
