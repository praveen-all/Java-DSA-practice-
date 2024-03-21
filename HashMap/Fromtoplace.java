import java.util.*;
public class Fromtoplace {

    public static String getstart(HashMap<String,String> tick){
        HashMap<String,String> revmap=new HashMap<>();
        for(String key:tick.keySet()){
            revmap.put(tick.get(key), key);
        }
        for(String key:tick.keySet()){
             if(!revmap.containsKey(key)){
                return key;
             }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String,String> map=new HashMap<>();
        map.put("chennai", "Bengaluru");
        map.put("mumbai", "Delhi");
        map.put("Goa", "chennai");
        map.put("Delhi", "Goa");
        String start=getstart(map);
        System.out.print(start);
        for(String key:map.keySet()){
            System.out.print("-->"+map.get(start));
            start=map.get(start);
        }
    }
}
