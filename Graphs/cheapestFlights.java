// fint the cheapest cost to reach from src to desti with k stop
import java.util.*;
public class cheapestFlights {
    static class Edges{
        int src;
        int desti;
        int wieght;
        public Edges(int s,int d,int w){
            this.desti=d;
            this.src=s;
            this.wieght=w;
        }
    }
    public static void Creategps(int [][]arr,ArrayList<Edges>[]graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
           }
           for(int i=0;i<arr.length;i++){
            int src=arr[i][0];
            int desti=arr[i][1];
            int wieght=arr[i][2];
            Edges e=new Edges(src, desti, wieght);
            graph[src].add(e);
           }
    }

    static class Info{
        int v;
        int cost;
        int stops;
        public Info(int v,int cost,int stops){
            this.v=v;
            this.cost=cost;
            this.stops=stops;
        }
        
    }
    public static int cheapest(int arr[][],int src,int dest,int k,int n){
        ArrayList<Edges> []graph=new ArrayList[n];
        Creategps(arr, graph);
        int dist[]=new int[graph.length];
        // initialize all dist by maxi
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        Queue<Info> q=new LinkedList<>();
        q.add(new Info(src, 0, 0));
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr.stops>k){
                 break;
            }
            for(int i=0;i<graph[curr.v].size();i++){
                 Edges e=graph[curr.v].get(i);
                 int u=e.src;
                 int v=e.desti;
                 int w=e.wieght;

                 if(curr.cost+w<dist[v] && curr.stops<=k){
                    dist[v]=curr.cost+w;
                    q.add(new Info(v, dist[v],curr.stops+1 ));
                 }
            }
        }
        if(dist[dest]==Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dest];
        }
    }
    public static void main(String[] args) {
        int arr[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{3,2,200}};
        int n=4;
       
      
        System.out.println(cheapest(arr, 0, 3, 1,  n));
    }
}
