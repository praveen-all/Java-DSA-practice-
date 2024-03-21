import java.util.*;
public class CycleUsinfBFS{
    static class Edge{
        int src;
        int desti;
        public Edge(int src,int desti){
            this.src=src;
            this.desti=desti;
        }
    }
    public static void creategraph(ArrayList<Edge>[]graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        // 0-vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 2));

    }
    public static boolean Cycledisconnect(ArrayList<Edge>[]graph){
        boolean visited[]=new boolean[graph.length];
      
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
               if( cycle(graph,visited,i))
                       return true;
            }
        }
        return false;
    }
     public static boolean cycle(ArrayList<Edge>[]graph,boolean[]visited,int src){
        int par[]=new int[graph.length];
        Arrays.fill(par, -1);
        Queue<Integer>q=new LinkedList<>();
        q.add(src);
        visited[src]=true;
        while(!q.isEmpty()){
            int cur=q.remove();
             for(int i=0;i<graph[cur].size();i++){
                Edge e=graph[cur].get(i);
                if(!visited[e.desti]){
                    q.add(e.desti);
                    visited[e.desti]=true;
                    par[e.desti]=cur;

                }else if(par[cur]!=e.desti){
                    return true;
                }
             }
        }
        return false;
     }
public static void main(String[] args) {
    ArrayList<Edge>[]graph=new ArrayList[4];
    creategraph(graph);
   System.out.println( Cycledisconnect(graph));
}
}