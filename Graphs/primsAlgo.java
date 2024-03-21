import java.util.*;
public class primsAlgo {
    static class Edges{
        int src;
        int desti;
        int wieght;
        public Edges(int src,int desti,int wieght){
            this.src=src;
            this.desti=desti;
            this.wieght=wieght;
        }
    }
    static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public Pair(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }
    public static void prims(ArrayList<Edges>[]graph){
        boolean[]visited=new boolean[graph.length];
        int finalcost=0;
         PriorityQueue<Pair>pq=new PriorityQueue<>();
         pq.add(new Pair(0, 0));
         while(!pq.isEmpty()){
            Pair curr=pq.remove(); 
            if(!visited[curr.v]){
                visited[curr.v]=true;
                 finalcost+=curr.cost;
                for(int i=0;i<graph[curr.v].size();i++){
                    Edges e=graph[curr.v].get(i);
                    pq.add(new Pair(e.desti,e.wieght));
                }
            }
         }
         System.out.println(finalcost);
    }
    public static void main(String[] args) {
        ArrayList<Edges>[]graph=new ArrayList[5];
        for(int i=0;i<graph.length;i++){
         graph[i]=new ArrayList<>();
     }
     graph[0].add(new Edges(0, 1,10));
     graph[0].add(new Edges(0, 2,15));
     graph[0].add(new Edges(0, 3,50));

    //  vertex 1
     graph[1].add(new Edges(1, 0,10));
     graph[1].add(new Edges(1, 3,40));
    //  vertex2
     graph[2].add(new Edges(2, 0,15));
     graph[2].add(new Edges(2, 3,30));
     graph[3].add(new Edges(3, 2,30));
     graph[3].add(new Edges(3, 1,40));
      prims(graph);
    }
}
