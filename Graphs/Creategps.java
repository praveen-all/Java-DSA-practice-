import java.util.*;
public class Creategps {
    static class Edges{
        int source;
        int desti;//destination
        int wt; //weight between two vertex
      public Edges(int s,int d,int w){
        this.source=s;
        this.desti=d;
        this.wt=w;
      }

        }

    public static boolean detectCycle(ArrayList<Edges>[]graph){
        boolean visited[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(detectcycleutil(graph,visited,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectcycleutil(ArrayList<Edges> graph[],boolean[]visited,int cur,int par){
        visited[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edges e=graph[cur].get(i);
            // case 3
            if(!visited[e.desti]){
                if(detectcycleutil(graph, visited, e.desti, cur)){
                    return true;
                }
            }else if(visited[e.desti] && par!=e.desti){
                return true;
            }
        }
        return false;
    }
        public static void main(String[] args) {
            /*
                                (5)
                             0-------  1
                                 (1) /   \ (3)
                                    /     \
                                   2 ----- 3
                                   |  (1)
                                (2)|
                                   4
                    //   this our basic graph

             */
                 int v=5;//no of vertices
             ArrayList<Edges> []graph=new ArrayList[v];
             for(int i=0;i<graph.length;i++){
                graph[i]=new ArrayList<>();
             }

            //  now create graph for different vertex
            // 0-vertex
            graph[0].add(new Edges(0, 1, 5));

            // 1-vertex
            graph[1].add(new Edges(1, 0, 5));
            graph[1].add(new Edges(1, 2, 1));
            graph[1].add(new Edges(1, 3, 3));
            // 2-vertex
            graph[2].add(new Edges(2, 1, 1));
            graph[2].add(new Edges(2, 3, 1));
            graph[2].add(new Edges(2, 4, 2));

            // 3-vertex
            graph[3].add(new Edges(3, 1, 3));
            graph[3].add(new Edges(3, 2, 1));

            // 4-vertex
            graph[4].add(new Edges(4, 2, 2));

            // print all neighbours of vertex 2
            // for(int i=0;i<graph[2].size();i++){
            //     Edges e=graph[2].get(i);
            //     System.out.println(e.desti);
            // }
            System.out.println(detectCycle(graph));
        }
}
