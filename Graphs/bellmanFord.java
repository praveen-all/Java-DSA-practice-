import java.util.*;
public class bellmanFord {
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
    public static void bellman(ArrayList<Edges>[]graph){
        // create an distance array
        int src=0;
        int []dist=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        // run v-1 times
        for(int i=0;i<dist.length-1;i++){
            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edges e=graph[j].get(k);
                    int u=e.src;
                    int v=e.desti;
                    int w=e.wieght;
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){
                        dist[v]=dist[u]+w;
                    }
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.println(dist[i]);
        }
    }
    public static void main(String[] args) {
        ArrayList<Edges>[]graph=new ArrayList[5];
        for(int i=0;i<graph.length;i++){
         graph[i]=new ArrayList<>();
     }
     graph[0].add(new Edges(0, 1,2));
     graph[0].add(new Edges(0, 2,4));
     graph[1].add(new Edges(1, 2,-4));
     graph[2].add(new Edges(2, 3,2));
     graph[3].add(new Edges(3, 4,4));
     graph[4].add(new Edges(4, 1,-1));
      bellman(graph);
    }
}
