import java.util.*;
public class HashSeet {
    public static void main(String[] args) {
      HashSet<Integer> set=new HashSet();
      set.add(23);  
      set.add(232);  
      set.add(233);  
      set.add(223);  
      set.add(253);

      // System.out.println(set);  
      // set.remove(23);
      // set.remove(233);
      // System.out.println(set);  
      // if(set.contains(223)){
      //   System.out.println("yeah , value is exist ");
      // }else{
      //   System.out.println("value doest not exist here so go anywhere seach");
      // }
      // Iteration in hashSet using a)Iterator b)advanced for loop
    //   Iterator it=set.iterator();
    //   while(it.hasNext()){
    //     System.out.println(it.next());
    //   }
    
    //   // using advenced for loop 
    //   for(Integer city:set){
    //     System.out.println(city);
    //   }
    System.out.println(set);
    LinkedHashSet<String> l=new LinkedHashSet<>();
    l.add("delhi");
    l.add("bengaluru");
    l.add("Noida");
    l.add("mubai");
    System.out.println(l);

    TreeSet<String> s=new TreeSet<>();
    s.add("delhi");
    s.add("bengaluru");
    s.add("Noida");
    s.add("mubai");
    System.out.println(s);

    
    }

}
