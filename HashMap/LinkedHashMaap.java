import java.util.*;
public class LinkedHashMaap {
    public static void main(String[] args) {
          LinkedHashMap<String,Integer> lmap=new LinkedHashMap();
          lmap.put("India", 100);
          lmap.put("china", 20);
          lmap.put("Iron", 89);
          lmap.put("england", 99);
          System.out.println(lmap);
          System.out.println(lmap.get("Iron"));
          System.out.println(lmap.size());
          System.out.println(lmap.replace("china", 20, 0));
          System.out.println(lmap.remove("china"));
    }
}
