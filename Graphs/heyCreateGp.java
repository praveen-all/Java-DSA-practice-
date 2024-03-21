import java.util.*;
public class heyCreateGp {
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
    public static void bfs(ArrayList<Edge>[]graph){
        Queue<Integer> q=new LinkedList<>();
        boolean visited[]=new boolean[graph.length];
        q.add(1);
        while(!q.isEmpty()){
            int cur=q.remove();
            if(!visited[cur]){
                System.out.print(cur+" ");
                visited[cur]=true;
                // adding immidiate neighbours
                for(int i=0;i<graph[cur].size();i++){
                    Edge e=graph[cur].get(i);
                   q.add(e.desti);
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge>[]graph,int cur,boolean[]visited){
        visited[cur]=true;
        System.out.print(cur+" ");
        // calling neighbours

        for(int i=0;i<graph[cur].size();i++){
           int cu=graph[cur].get(i).desti;
           if(!visited[cu]){
            dfs(graph, cu, visited);
           }
        }
    }
    public static boolean hashpath(ArrayList<Edge>[]graph,int src,int desti,boolean []visited){
        if(src==desti){
            return true;
        }

        visited[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!visited[e.desti] && hashpath(graph, e.desti, desti, visited)){
                return true;
            }
        }
        return false;
    }
    public static boolean detectCycle(ArrayList<Edge>[]graph){
        boolean []visited=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(detectCycleUtile(graph,visited,i,-1)){
                    return true;
                }
            }
        }
        return false;

    }
    public static boolean detectCycleUtile(ArrayList<Edge>[]graph,boolean[]visited,int cur,int par){
        visited[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            if(!visited[e.desti]){
                if(detectCycleUtile(graph,visited,e.desti,cur)){
                    return true;
                }
            }else if(visited[e.desti]&& par!=e.desti){
                return true;
            }
        }
        return false;
    }
    public static boolean detectCycleBFS(ArrayList<Edge>[]graph){
        boolean visited[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
               if( detectCycleBFSUtil(graph,visited,i)){
                return true;
               }
            }
        }
        return false;
    }
    public static boolean detectCycleBFSUtil(ArrayList<Edge>[]graph,boolean[]visited,int cur){
        Queue<Integer> q=new LinkedList<>();
        int par[]=new int[graph.length];
        Arrays.fill(par,-1);
        q.add(cur);
       
        while(!q.isEmpty()){
            int cu=q.remove();
            visited[cu]=true;
            for(int i=0;i<graph[cu].size();i++){
                Edge e=graph[cu].get(i);
                if(!visited[e.desti]){
                    par[e.desti]=cu;
                    q.add(e.desti);
                }else if(e.desti!=par[cu]){
                    return  true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //declare array of arrayList graph
        int v=7;
        ArrayList<Edge> [] graph=new ArrayList[v]; 
        // now initializing each vertices index by Empty ArrayList?boz previously it store null value
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
        // 0- vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        // 1 - vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2-vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        //3-vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4-vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));

        // i am trying to print all the neighbours of 2
        // for(int i=0;i<graph[2].size();i++){
        //     Edge e=graph[2].get(i);
        //     System.out.print(e.desti+" ");
        // }
        // graph traversal BFS

        // bfs(graph);
        // dfs(graph, 0, new boolean[v]);
        // System.out.println(hashpath(graph, 0, 6, new boolean[v]));
        // detect the cycle in undirected graph using DFS method

    //    System.out.println( detectCycle(graph));
    //    cycle detection using bfs method
       System.out.println(detectCycleBFS(graph));
    }
}
