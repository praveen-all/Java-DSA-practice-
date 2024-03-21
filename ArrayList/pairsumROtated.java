import java.util.ArrayList;

public class pairsumROtated {

    public static boolean pairing(ArrayList<Integer> list,int target){
    int sp=0,ep=0;
    for(int i=0;i<list.size();i++){
        if(list.get(i)>list.get(i+1)){
            sp=i+1;
            ep=i;
            break;
        }
    }

int sum,n=list.size();
    while (sp!=ep) {
      sum=list.get(sp)+list.get(ep);
      if(sum==target){
        return true;
      } else if(sum>target){
        ep=(n+ep-1)%n;
      }else{
        sp=(sp+1)%n;
      }
    }

return false;
    }
    public static void main(String[] args) {



        ArrayList<Integer> list=new ArrayList<>();
          
           list.add(11);
           list.add(15);
           list.add(6);
           list.add(8);
           list.add(9);
           list.add(10);
         System.out.println(pairing(list,16));
    }
}
