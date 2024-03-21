import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;



public class unionFind {
    static class Edge implements Comparable<Edge>{
        int src;
        int desti;
        int weight;
        public Edge(int src,int desti,int weight){
            this.src=src;
            this.desti=desti;
            this.weight=weight;
        }

        @Override
        public int compareTo(Edge e){
            return this.weight-e.weight;
        }
    }

   static int n=7;
    static int[]par=new int[n];
    static int[]rank=new int[n];
    // parentp[x]=x
    // rank of all initially zero
    public static void initialize(){
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }
    public static int find(int x){
        if(par[x]==x){
            return x;
        }
        return par[x]=find(par[x]);
    }
    public static void union(int a,int b){
        int parA=find(a);
        int parB=find(b);
        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        }else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        }else{
            par[parB]=parA;
        }
    }
    public static void kruskal( ArrayList<Edge> graph,int v){
         initialize();
         Collections.sort(graph);
         int finalccost=0;
         int count=0;
         for(int i=0;count<v-1;i++){
            Edge e=graph.get(i);
           int parA=find(e.src);
           int parB=find(e.desti);
           if(parA!=parB){
            finalccost+=e.weight;
            count++;
            union(parA,parB);
           }

         }
         System.out.println(finalccost);
    }
    public static void main(String[] args) {
       ArrayList<Edge> graph=new ArrayList<>();
       graph.add(new Edge(0, 1, 10));
       graph.add(new Edge(0, 2, 15));
       graph.add(new Edge(0, 3, 30));
       graph.add(new Edge(1, 3, 40));
       graph.add(new Edge(2, 3, 50));
       int v=4;
       kruskal(graph, v);
    }
}
