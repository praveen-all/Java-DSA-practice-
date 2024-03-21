import java.util.ArrayList;
import java.util.PriorityQueue;

public class DAG {
    static class Edge{
        int src;
        int desti;
        int weight;
        public Edge(int src,int desti,int weight){
            this.src=src;
            this.desti=desti;
            this.weight=weight;
        }
    }
//     public static boolean path(ArrayList<Edge>[]graph,int src,int dest,boolean[]visited){
//         if(src==dest){
//             return true;
//         }
// visited[src]=true;
//         for(int i=0;i<graph[src].size();i++){
//             Edge e=graph[src].get(i);
//           if(!visited[e.desti]){
//             if(path(graph, e.desti, dest, visited)){
//                 return true;
//             }
//           }
//         }
//         return false;
//     }

// --------------------------practice distra's algorithm----------------------------

static class Pair implements Comparable<Pair>{

    int n;
    int path;
    public Pair(int n,int path){
        this.n=n;
        this.path=path;
    }

    @Override
    public int compareTo(Pair p){
        return this.path-p.path;
    }
}

public static void dikstra(ArrayList<Edge>[]graph,int src){
    try {
        int distance[]=new int[graph.length];
    // initialze the all distance with infinity except src
    for(int i=0;i<graph.length;i++){
        if(i!=src){
            distance[i]=Integer.MAX_VALUE;
        }
    }

    // check visited
    boolean []visited=new boolean[graph.length];
    PriorityQueue<Pair> pq=new PriorityQueue<>();
    pq.add(new Pair(src, 0));
    while(!pq.isEmpty()){
        Pair cur=pq.remove();
        if(!visited[cur.n]){
            visited[cur.n]=true;
            for(int i=0;i<graph[cur.n].size();i++){
                Edge e=graph[cur.n].get(i);
                int u=e.src;
                int v=e.desti;
                int w=e.weight;

                if(distance[u]+w<distance[v]){
                    distance[v]=distance[u]+w;
                    pq.add(new Pair(v, distance[v]));
                }
            }
        }
    }

    // pritn all sorted diance from src
    System.out.println("given below are the shorted path between from given src to node");

    for(int i=0;i<distance.length;i++){
        distance[i]=distance[i]==Integer.MAX_VALUE?0:distance[i];
        System.out.println(src+"-->"+i+" = "+distance[i]);
        
    }
    } catch (Exception e) {
       System.out.println("node cannot find anywhere");//why I used try and catch here if thet given unknown  node or address

    }
}
// find the shortest distance from src to destination using bellmann ford algorithm 
public static void bellmann(ArrayList<Edge>[]graph,int src){
    int v=graph.length;
    int[]distance=new int[v];
    for(int i=0;i<v;i++){
        if(i!=src){
            distance[i]=Integer.MAX_VALUE;
        }
    }
    //next do the v-1 operation 
    for(int i=0;i<v-1;i++){
        for(int j=0;j<v;j++){
            for(int k=0;k<graph[j].size();k++){
                Edge e=graph[j].get(k);
                int u=e.src;
                int vv=e.desti;
                int w=e.weight;
                if(distance[u]!=Integer.MAX_VALUE && distance[u]+w<distance[vv]){
                    distance[vv]=distance[u]+w;
                }
            }
        }
        print(distance);
    }
}
public static void print(int[]a){
    for(int i=0;i<a.length;i++){
        System.out.print(a[i]+"  ");
    }
    System.out.println();
}
// minimum spanning tree(MST)
static class Info implements Comparable<Info>{
    int n;
    int cost;
    public Info(int n,int cost){
        this.n=n;
        this.cost=cost;
    }
    @Override
    public int compareTo(Info f){
        return this.cost-f.cost;
    }
}
    public static int primes(ArrayList<Edge>[]graph){
        boolean[]visited=new boolean[graph.length];
        PriorityQueue<Info> pq=new PriorityQueue<>();
        int finalccost=0;

        pq.add(new Info(0, 0));
        while(!pq.isEmpty()){
            Info cur=pq.remove();
            if(!visited[cur.n]){
                visited[cur.n]=true;
                finalccost+=cur.cost;
                for(int i=0;i<graph[cur.n].size();i+=1){
                    Edge e=graph[cur.n].get(i);
                    pq.add(new Info(e.desti,e.weight));
                }
            }
        }
        return finalccost;
    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge>[]graph=new ArrayList[v];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        // create the direct graph
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
         graph[2].add(new Edge(2, 4, 3));
         graph[3].add(new Edge(3, 5, 1));
         graph[4].add(new Edge(4, 3, 2));
         graph[4].add(new Edge(4, 5, 5));
        //  boolean []visited=new boolean[v];
        // dikstra(graph, 6);        
        // bellmann(graph, 0);
        System.out.println(primes(graph));
        
         
    }
}
