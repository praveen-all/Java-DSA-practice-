import java.util.*;
public class twoSum {
    public static void main(String[] args) {
      List<Integer> list=new ArrayList<>();
      list.add(2);
      list.add(232);
      list.add(3);
      list.add(2);
      list.add(24);
    //   System.out.println(list.remove(2));
    //   System.out.println(list);
      Collections.replaceAll(list, 2, 2323);
      System.out.println(list);
      Collections.reverseOrder();
    //   list.clear();
    //   System.out.println(list);
    //   for(Integer a:list){
    //     System.out.println(a);
    //   }
    //   differenct way of iterating arraylist
    //    for(int i=0;i<list.size();i++){
    //     System.out.println(list.get(i));
    //    }

        //  Iterator<Integer> l=list.iterator();
        //  while(l.hasNext()){
        //     System.out.println(l.next());
        //  }

        // list.forEach(a->{
        //     System.out.println(a);
        // });

        list.forEach(System.out::println);
        List<List<Integer>> ll=new ArrayList<>();
        ll.add(list);
        

        // methods to convert array to arraylist
        String praveen[]={"praveen","lava","kusha","kumshi"};
        List<String> sl=new ArrayList<>(Arrays.asList(praveen));
        sl.forEach(System.out::println);
        Collections.sort(sl,Collections.reverseOrder());
        System.out.println(sl);
        
        // array to arraylist
      List<String>sl2=new ArrayList<>();
      sl2=Arrays.asList(praveen);
      ArrayList<String> sl3=new ArrayList<>();
      
    //   arraylist to array
      String pavi[]=new String[sl3.size()];
      pavi=sl3.toArray(new String[sl3.size()]);

      Integer []p=list.toArray(new Integer[list.size()]);
    //   how to convert int to Integer
    int x=23;
    Integer xx=Integer.valueOf( x);
    System.out.println(xx);

    // how to convert Integer to int
    Integer myInt=23;
    int myint=myInt.intValue();
    System.out.println(myint);

    }
}
