import java.security.PublicKey;
import java.util.*;
public class maximumProfit {
       static class Job{
        int deadline;
        int profit;
        int id;
        
        public Job(int d,int p, int i){
            this.deadline=d;
            this.profit=p;
            this.id=i;
        }
       }
    public static void main(String[] args) {
        int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};
           
        ArrayList<Job> jobs=new ArrayList<>();

        for(int i=0;i<jobInfo.length;i++){
            jobs.add(new Job(jobInfo[i][0], jobInfo[i][1], i));
        }
         
        // we sort based on profit
        Collections.sort(jobs,(a,b)-> b.profit-a.profit);
                
        int time=0;

        // array list to add how many he can do
        ArrayList<Integer> ans=new ArrayList<>();

        for(int i=0;i<jobs.size();i++){
            Job curr=jobs.get(i);
            if(curr.deadline>time){
                ans.add(curr.id);
                time++;

            }
        }

        System.out.println("maximum  jobs he can do "+ans.size());
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+"  ");
        }
    }
}
