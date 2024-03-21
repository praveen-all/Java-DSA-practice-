import java.sql.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class connect_city_minimum_cost {
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

    // create the graph
    public static void createGraph(int[][]cities, ArrayList<Edge>[]graph){
        for(int i=0;i<cities.length;i++){
          graph[i]=new ArrayList<>();

        }

        for(int i=0;i<cities.length;i++){
            for(int j=0;j<cities[0].length;j++){
                if(cities[i][j]!=0)
                graph[i].add(new Edge(i, j, cities[i][j]));
            }
        }
    }
    static class Info implements Comparable<Info>{
        int v;
        int path;
        public Info(int v,int path){
            this.v=v;
            this.path=path;
        }

        @Override
        public int compareTo(Info p){
            return this.path-p.path;
        }
    }
    public static void findsortest(ArrayList<Edge>[]graph){
        boolean[]visited=new boolean[graph.length];
        int finaldistance=0;
        PriorityQueue<Info> q=new PriorityQueue<>();
        q.add(new Info(0,0) );
        while(!q.isEmpty()){
            Info cur=q.remove();
            if(!visited[cur.v]){
                visited[cur.v]=true;
                finaldistance+=cur.path;

                for(int i=0;i<graph[cur.v].size();i++){
                    Edge e=graph[cur.v].get(i);
                    q.add(new Info(e.desti, e.weight));
                }
            }
        }
        System.out.println(finaldistance);
    }
    public static void main(String[] args) {
        int cities[][]={{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};
        ArrayList<Edge>[]graph=new ArrayList[cities.length];
        createGraph(cities,graph);
        findsortest(graph);
    }
}
