import java.util.*;

public class Numerical_K_stops {
    static class Edge{
        int src;
        int desti;
        int weight;
        public Edge(int s,int d,int w){
            src=s;
            desti=d;
            weight=w;
        }
    }
public static void createGraph(ArrayList<Edge>[]graph,int[][]a){
    for(int i=0;i<graph.length;i++){
        graph[i]=new ArrayList<>();
    }

    for(int i=0;i<a.length;i++){
        int src=a[i][0];
        int dest=a[i][1];
        int weight=a[i][2];
    graph[i].add(new Edge(src, dest, weight));
    }
}
static class Info{
    int v;
    int cost;
    int stops;
    public Info(int v,int color,int shorted){
        this.v=v;
        this.cost=color;
        this.stops=shorted;
    }
}

public static int cheapest(ArrayList<Edge>[]graph,int src,int dest,int k){
    int v=graph.length;
    int distance[]=new int[v];
    for(int i=0;i<v;i++){
        if(i!=src){
            distance[i]=Integer.MAX_VALUE;
        }
    }

    // directed graph doesnot required visited

    Queue<Info> q=new LinkedList<>();
    q.add(new Info(src, 0, -1));
    while(!q.isEmpty()){
        Info cur=q.remove();
        if(cur.stops>k){
             break;
        }
        
        for(int i=0;i<graph[cur.v].size();i++){
            Edge e=graph[cur.v].get(i);
            if(distance[e.src]+e.weight<distance[e.desti] && cur.stops<=k){
                distance[e.desti]=distance[e.src]+e.weight;
                q.add(new Info(e.desti, distance[e.desti], cur.stops+1));
            }
        }
    }
    if(distance[dest]==Integer.MAX_VALUE){
        return -1;
    }else{
        return distance[dest];
    }
}
    // 
    public static void main(String[] args) {
        int dtl[][]={{0,1,100},{0,2,500},{1,2,500}};
        int src=0;
        int dest=2;
        int k=1;
      ArrayList<Edge> []graph=new ArrayList[dtl.length];
      createGraph(graph,dtl);
      System.out.println(cheapest(graph, 0, 2, 1));
    }
}
