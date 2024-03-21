import java.util.*;
public class practicedijkstrat {
    static class Edge{
        int src;
        int desti;
        int wieght;
        public Edge(int src,int desti,int wieght){
            this.src=src;
            this.desti=desti;
            this.wieght=wieght;
        }
    }

    // create a graph
    public static void creategraph(ArrayList<Edge>[]graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 5, 10));
        graph[0].add(new Edge(0, 1, 10));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 5, 50));
        graph[1].add(new Edge(1, 3, 20));
        graph[1].add(new Edge(1, 4, 40));
        graph[1].add(new Edge(1, 2, 30));
        graph[5].add(new Edge(5, 0, 10));
        graph[5].add(new Edge(5, 1, 50));
        graph[3].add(new Edge(3, 1, 20));
        graph[3].add(new Edge(3, 4, 10));
        graph[4].add(new Edge(4, 3, 10));
        graph[4].add(new Edge(4, 1, 50));
        graph[2].add(new Edge(2, 1, 30));
    }
    static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public Pair(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
        @Override
        public int compareTo(Pair p){
            return this.cost-p.cost;
        }
    }
    public static void prims(ArrayList<Edge>graph[]){
        boolean visited[]=new boolean[graph.length];
        int finalcost=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair cur=pq.remove();
            if(!visited[cur.v]){
                visited[cur.v]=true; 
              finalcost+=cur.cost;
              for(int i=0;i<graph[cur.v].size();i++){
                Edge e=graph[cur.v].get(i);
                pq.add( new Pair(e.desti, e.wieght));
              }
            }
        }
        System.out.println(finalcost);
    }
  public static void main(String[] args) {
    int v=6;
    ArrayList<Edge>[]graph=new ArrayList[v];
    creategraph(graph);
    prims(graph);
  }
}
