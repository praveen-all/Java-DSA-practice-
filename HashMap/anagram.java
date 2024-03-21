import java.util.*;
public class anagram {
    public static boolean anagram(String str1,String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str1.length();i++){
             map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0)+1);
        }
        for(int i=0;i<str2.length();i++){
           char ch=str2.charAt(i);
           if(map.get(ch)!=null){
               if(map.get(ch)==1){
                map.remove(ch);
               }else{
                map.put(ch, map.get(ch)-1);
               }
           }else{
            return false;
           }
       }

       if(map.isEmpty()){
        return true;
       }else{
        return false;
       }
    }
    public static void main(String[] args) {
        String str1="praveen";
        String str2="eenrapv";//check it here now is shouldnot work 
        System.out.println(anagram(str1,str2));

    }
}
