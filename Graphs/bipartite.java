
import java.util.*;
public class bipartite {
    static class Edges{
        int s;
        int d;
        // int w;
       public Edges(int s,int d){
        this.d=d;
        this.s=s;
        // this.w=w;
       }
    }

    public static void createArrayList(ArrayList<Edges>[]graphs){
        // for(int i=0;i<graphs.length;i++){
        //        graphs[i]=new ArrayList<>();
        // }
        // graphs[0].add(new Edges(0, 1, 1));
        // graphs[0].add(new Edges(0, 2, 1));
        // // 1-vertex
        // graphs[1].add(new Edges(1, 0, 1));
        // graphs[1].add(new Edges(1, 3, 1));

        // // 2-Vertex
        // graphs[2].add(new Edges(2, 0, 1));
        // graphs[2].add(new Edges(2, 4, 1));

        // //3-vertex
        // graphs[3].add(new Edges(3, 1, 1));
        // graphs[3].add(new Edges(3, 4, 1));
        // graphs[3].add(new Edges(3, 5, 1));
        
        // // 4-vertex
        // graphs[4].add(new Edges(4, 3, 1));
        // graphs[4].add(new Edges(4, 2, 1));
        // graphs[4].add(new Edges(4, 5, 1));
        // // 5-vertex
        // graphs[5].add(new Edges(5, 3, 1));
        // graphs[5].add(new Edges(5, 4, 1));
        // graphs[5].add(new Edges(5, 6, 1));

        // 6-vertex
        // graphs[6].add(new Edges(6, 5, 1));
    }
    // to check the given graph is bipartite or not
    public static boolean bipartite(ArrayList<Edges> []graph){
        int color[]=new int[graph.length];
          Queue<Integer> q=new LinkedList<>();
        // i initialize all color array by -1 means no color
        for(int i=0;i<color.length;i++){
            color[i]=-1;
        }

        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
              q.add(i);
              color[i]=0;
              while(!q.isEmpty()){
                int curr=q.remove();
                // add all neighbor to q
                for(int j=0;j<graph[curr].size();j++){
                      Edges e=graph[curr].get(j);
                      if(color[e.d]==-1){
                        int nextcolor=color[curr]==0?1:0;
                        color[e.d]=nextcolor;
                        q.add(e.d);
                      }else if(color[e.d]==color[curr]){
                        return false; //not bipartite
                      }
                }

              }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Edges>[]graph=new ArrayList[5];
        // createArrayList(graph);
        for(int i=0;i<graph.length;i++){
                   graph[i]=new ArrayList<>();
            }
        graph[1].add(new Edges(1, 2));
        graph[1].add(new Edges(1, 4) );
        graph[2].add(new Edges(2, 1) );
        graph[2].add(new Edges(2, 3) );
        graph[3].add(new Edges(3, 2) );
        graph[3].add(new Edges(3, 4) );
        graph[4].add(new Edges(4, 1) );
        graph[4].add(new Edges(4, 3) );

        System.out.println(bipartite(graph));
    }

}
