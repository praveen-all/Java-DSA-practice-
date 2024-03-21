// print the element repeated more than n/3 times
import java.util.*;
public class majorityELement {
    public static void main(String[] args) {
        HashSet<Integer> set=new HashSet<>();
        set.add(12);
        set.add(19);
        set.add(18);
        set.add(16);
        LinkedHashSet<Integer> set1=new LinkedHashSet<>();
        set1.add(12);
        set1.add(19);
        set1.add(18);
        set1.add(16);

        TreeSet<Integer> set3=new TreeSet<>();
        set3.add(12);
        set3.add(19);
        set3.add(18);
        set3.add(16);
        // 
      Iterator it=set3.iterator();
      while(it.hasNext()){
        System.out.println(it.next());
      }
        System.out.println("hashSet=>"+set);
        System.out.println("LinkedHashSet=>"+set1);
        System.out.println("TreeSet"+set3);
    }
}
