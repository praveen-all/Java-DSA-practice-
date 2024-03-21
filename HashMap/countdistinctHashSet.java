import java.util.HashSet;

public class countdistinctHashSet{
    // public static void main(String[] args) {
    //     int arr[]={4,3,2,5,6,7,3,4,2,1};
    //     HashSet<Integer> set=new HashSet<>();
    //     for(int i=0;i<arr.length;i++){
    //         set.add(arr[i]);
    //     }
    //     System.out.println(set.size());
    // }


    // fint the union and intersection of given two array
    public static void main(String[] args) {
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
       System.out.println("union"+set.size());

       set.clear();

       for(int i=0;i<arr1.length;i++){
        set.add(arr1[i]);
       }
       int count=0;
       for(int j=0;j<arr2.length;j++){
        if(set.contains(arr2[j])){
            count++;
            set.remove(arr2[j]);
        }
       }
       System.out.println("intersection"+count);
    }
}