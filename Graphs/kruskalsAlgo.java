import java.util.*;
public class kruskalsAlgo {
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int weight;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.weight=w;
        }
        @Override
        public int compareTo(Edge e){
            return this.weight-e.weight;
        }
    }
    public static void createGraph(ArrayList<Edge>edges){
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }
    static int n=4;//number of vertice
    static int[]par=new int[n];
    static int rank[]=new int[n];

    // initialize the parent by index
public static void init(){
    for(int i=0;i<par.length;i++){
        par[i]=i;
    }
}
    // fint the parent of vertice
    public static int find(int x){
        if(x==par[x]){
            return par[x];
        }
        return par[x]=find(par[x]);
    }
    // union two vertex
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
//    kruskalsAlgorith
public static void kruskals(ArrayList<Edge>edges,int v){
    init();
    Collections.sort(edges);

    // my outerloop run fron count to v-1
    int count=0;
    int mstCost=0;
    for(int i=0;count<v-1;i++){
        Edge e=edges.get(i);
        int parA=e.src;
        int parB=e.dest;
        if(parA!=parB){
            union(parA, parB);
            mstCost+=e.weight;
            count++;
        }

    }
    System.out.println(mstCost);
}
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> edges=new ArrayList<>();
        createGraph(edges);
        kruskals(edges, v);
    }
}
