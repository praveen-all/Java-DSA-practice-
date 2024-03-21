import java.util.*;
public class traversal {
    static class Edges{
        int s;
        int d;
        int w;
       public Edges(int s,int d,int w){
        this.d=d;
        this.s=s;
        this.w=w;
       }
    }
    public static void createArrayList(ArrayList<Edges>[]graphs){
        for(int i=0;i<graphs.length;i++){
               graphs[i]=new ArrayList<>();
        }
        graphs[0].add(new Edges(0, 1, 1));
        graphs[0].add(new Edges(0, 2, 1));
        // 1-vertex
        graphs[1].add(new Edges(1, 0, 1));
        graphs[1].add(new Edges(1, 3, 1));

        // 2-Vertex
        graphs[2].add(new Edges(2, 0, 1));
        graphs[2].add(new Edges(2, 4, 1));

        //3-vertex
        graphs[3].add(new Edges(3, 1, 1));
        graphs[3].add(new Edges(3, 4, 1));
        graphs[3].add(new Edges(3, 5, 1));
        
        // 4-vertex
        graphs[4].add(new Edges(4, 3, 1));
        graphs[4].add(new Edges(4, 2, 1));
        graphs[4].add(new Edges(4, 5, 1));
        // 5-vertex
        graphs[5].add(new Edges(5, 3, 1));
        graphs[5].add(new Edges(5, 4, 1));
        graphs[5].add(new Edges(5, 6, 1));

        // 6-vertex
        graphs[6].add(new Edges(6, 5, 1));
    }

    public static void bfs(ArrayList<Edges>[]graph){
        Queue<Integer> q=new LinkedList<>();
        boolean []visited=new boolean[graph.length];
        q.add(0);
        while(!q.isEmpty()){
            int cur=q.remove();
            if(!visited[cur]){
                System.out.print(cur+" ");
                visited[cur]=true;
            
            // push the all neighbours to queue
            for(int i=0;i<graph[cur].size();i++){
              q.add(graph[cur].get(i).d);
            }
            }
        }
    }
     
    // check if it has path or not
    public static boolean hasPath(ArrayList<Edges>[]grap,int src,int dest,boolean[]visited){
        if(src==dest){
            return true;
        }
        visited[src]=true;
        for(int i=0;i<grap[src].size();i++){
            Edges e=grap[src].get(i);
            if(!visited[e.d]&& hasPath(grap, e.d, dest, visited)){
                return true;
            }
        }
        return false;
    }
    public static void dfs(ArrayList<Edges>[]graph,int curr,boolean visited[]){
        System.out.print(curr+" ");
        visited[curr]=true;

        // call the destination which donot called
        for(int i=0;i<graph[curr].size();i++){
            if(!visited[graph[curr].get(i).d]){
                dfs(graph, graph[curr].get(i).d, visited);
            }
        }
    }
    public static void main(String[] args) {
        int v=7;
        ArrayList<Edges> []graphs=new ArrayList[v];

        createArrayList(graphs);
        bfs(graphs);
        // travel the graph on breath first search order
        
        // now depth first search
        boolean visted[]=new boolean[graphs.length];
        // dfs(graphs,6,visted);

        // System.out.print(hasPath(graphs, 0, 2, visted));


    }
}
