import java.util.*;
public class overall {
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
  public static void BFS(ArrayList<Edge>[]graph){
    Queue<Integer> q=new LinkedList<>();
    boolean visited[]=new boolean[graph.length];
    q.add(0);
    while(!q.isEmpty()){
        int cur=q.remove();
        if(!visited[cur]){
            System.out.print(cur+" ");
            visited[cur]=true;
            for(int i=0;i<graph[cur].size();i++){
                Edge e=graph[cur].get(i);
                q.add(e.desti);
            }
        }
    }


  }
  public static boolean checkCycle(ArrayList<Edge>[]graph){
    boolean visited[]=new boolean[graph.length];
    for(int i=0;i<graph.length;i++){
        if(!visited[i]){
            if(detectCycle(graph,visited,i,-1)){
                return true;
            }
        }
    }
    return false;
  }
  public static boolean detectCycle(ArrayList<Edge> []graph,boolean visited[],int cur,int par){
    visited[cur]=true;
    for(int i=0;i<graph[cur].size();i++){
        Edge e=graph[cur].get(i);
        if(!visited[e.desti]){
            if(detectCycle(graph, visited, e.desti, cur)){
                return true;
            }
        }else if(visited[e.desti]&& par!=e.desti){
            return true;
        }
    }
    return false;
  }
//   check is given graph Bipartite or not
public static boolean biPartite(ArrayList<Edge>[]graph){
  int color[]=new int[graph.length];
  Queue<Integer> q=new LinkedList<>();
  Arrays.fill(color, -1);
  for(int i=0;i<graph.length;i++){
       if(color[i]==-1){
        q.add(i);
        color[i]=0;
        while(!q.isEmpty()){
            int cur=q.remove();

            for(int j=0;j<graph[cur].size();j++){
                Edge e=graph[cur].get(j);
                if(color[e.desti]==-1){
                    int nextcoloe=color[cur]==0?1:0;
                    color[e.desti]=nextcoloe;
                    q.add(e.desti);
                }else if(color[e.desti]==color[cur]){
                    return false;
                }

            }
        }
       }
  }
  return true;
}
static class Info{
    int data;
    int parent;
    public Info(int d,int p){
        this.data=d;
        this.parent=p;
    }
}
// check cycle exist or not using BFS method
   public static boolean BFScycle(ArrayList<Edge>[]graph){
    boolean visited[]=new boolean[graph.length];
    // with components of graph
    for(int i=0;i<graph.length;i++){
        if(!visited[i]){
            if(detect(graph,i,visited)){
                return true;
            }
        }
    }
    return false;
    
   }
   public static boolean detect(ArrayList<Edge>[]graph,int c,boolean []visited){
    Queue<Info> q=new LinkedList<>();
    q.add(new Info(c, Integer.MIN_VALUE));
    visited[c]=true;
    while(!q.isEmpty()){
        Info cur=q.remove();
        for(int i=0;i<graph[cur.data].size();i++){
               Edge e=graph[cur.data].get(i);
               if(!visited[e.desti]){
                visited[e.desti]=true;
                q.add( new Info(e.desti, cur.data));
               }else if(visited[e.desti]&& e.desti!=cur.parent){
                   return true;
               }
        }
    }
    return false;
   }
    public static void main(String[] args) {
       
        int v=7;
        ArrayList<Edge>[]graph=new ArrayList[v];//initializing object of array 
        // i havnt initialize an arraylist to array
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
   
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        
        // // vertex 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1,3, 1));
        // vertex -2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        // vertex -3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
    
        // // vertex-4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4,      3, 1));
        graph[4].add(new Edge(4, 5, 1));
    
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));
    
    
        //    BFS(graph);
        //    System.out.println(checkCycle(graph));
   
        // System.out.println(checkCycle(graph));
        // System.out.println(biPartite(graph));
        System.out.println(BFScycle(graph));
        
    }
}                                                                                                                                                                           
