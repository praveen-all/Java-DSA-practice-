import java.util.*;

public class HashMapOperation{
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("India", 100);
        map.put("china", 10);
        map.put("USA", 80);
        map.put("Iron", 90);
        map.put("china", 5);
        System.out.println(map);
        // get 
        System.out.println(map.get("India"));
        // remove method delete and return the val at deleted key

        // System.out.println(map.remove("India"));
        System.out.println(map.remove("IRON"));//if given key is not found return null
        System.out.println(map.containsKey("India"));

        // check the size
        System.out.println(map.size());

        // isEmpty()
        System.out.println(map.isEmpty());
        System.out.println(map.keySet());

        // how to iterate the given map
        Set<String> keys=map.keySet();
        for(String key :keys){
            System.out.println("key "+key+"---------->"+map.get(key));
        }
    }
}