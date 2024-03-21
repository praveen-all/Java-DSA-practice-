import java.util.*;
public class dijkstrats {
    static class Eadges{
        int desti;
        int src;
        int wieght;
        public Eadges(int src,int desti,int wieght){
            this.src=src;
            this.desti=desti;
            this.wieght=wieght;
        }
    }
    static class Pair implements Comparable<Pair>{
        int n;
        int path;
        public Pair(int n,int path){
            this.n=n;
            this.path=path;
        }
        @Override
        public int compareTo(Pair p1){
            return this.path-p1.path;
        }
    }

    public static void dijkstras(ArrayList<Eadges>[]graph,int src){
        int distance[]=new int[graph.length];
    
         for(int i=0;i<distance.length;i++){
            if(i!=src){
                distance[i]=Integer.MAX_VALUE;
            }
         }

        PriorityQueue<Pair> pq=new PriorityQueue<>();
        boolean visited[]=new boolean[graph.length];
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair cur=pq.remove();
            if(!visited[cur.n]){
                visited[cur.n]=true;
                for(int i=0;i<graph[cur.n].size();i++){
                    Eadges e=graph[cur.n].get(i);
                    int u=e.src;
                    int v=e.desti;
                    int w=e.wieght;
                    if(distance[u]+w<distance[v]){
                        distance[v]=distance[u]+w;
                        pq.add(new Pair(v, distance[v]));
                    }

                }
            }
        }
        for(int i=0;i<distance.length;i++){
            System.out.print(distance[i]+" ");
        }
    }
    public static void main(String[] args) {
        ArrayList<Eadges>[]graph=new ArrayList[7];
        for(int i=0;i<graph.length;i++){
         graph[i]=new ArrayList<>();
     }
     graph[0].add(new Eadges(0, 1,2));
     graph[0].add(new Eadges(0, 2,4));
     graph[1].add(new Eadges(1, 2,1));
     graph[1].add(new Eadges(1, 3,7));
     graph[2].add(new Eadges(2, 4,3));
     graph[3].add(new Eadges(3, 5,1));
     graph[4].add(new Eadges(4, 5,5));
     graph[4].add(new Eadges(4, 3,2));
    dijkstras(graph, 0);
    }
}
