import java.util.*;

import javax.swing.GrayFilter;
public class practice {
    static class Edges{
        int src;
        int desti;
        int weight;
        public Edges(int src,int desti,int weight){
            this.src=src;
            this.desti=desti;
            this.weight=weight;
        }
    }
    // print as order of BFS
    public static void BFS(ArrayList<Edges> graph[]){
        Queue<Integer> q=new LinkedList<>();
        boolean visited[]=new boolean[graph.length];
                q.add(0);
                while(!q.isEmpty()){
                    int cur=q.remove();
                    if(!visited[cur]){
                        System.out.println(cur+" ");
                           visited[cur]=true;
                    // add all neighbours to queue
                    for(int j=0;j<graph[cur].size();j++){
                        Edges e=graph[cur].get(j);
                        q.add(e.desti);

                    }
                       }
                }
    }
    // print all graphs inorder of DFS
    public static void DFS(ArrayList<Edges>[]graph,int curr,boolean visited[]){
        System.out.print(curr+" ");
        visited[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
             Edges e=graph[curr].get(i);
             if(!visited[e.desti]){
                DFS(graph, e.desti, visited);
             }
        }

    }
    // check if it has path or not 
    public static boolean hasPath(ArrayList<Edges>[]graph,int src,int dest,boolean []visited){
        if(src==dest){
            return true;
        }
        visited[src]=true;
        for(int i=0;i<graph[src].size();i++){
            if(!visited[graph[src].get(i).desti]){
                if(hasPath(graph, graph[src].get(i).desti, dest, visited) ){
                    return true;
                }
            }

        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Edges> graph[]=new ArrayList[7];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
       
        graph[0].add(new Edges(0, 1, 1));
        graph[0].add(new Edges(0, 2, 1));
        // 1-vertex
        graph[1].add(new Edges(1, 0, 1));
        graph[1].add(new Edges(1, 3, 1));

        // 2-Vertex
        graph[2].add(new Edges(2, 0, 1));
        graph[2].add(new Edges(2, 4, 1));

        //3-vertex
        graph[3].add(new Edges(3, 1, 1));
        graph[3].add(new Edges(3, 4, 1));
        graph[3].add(new Edges(3, 5, 1));
        
        // 4-vertex
        graph[4].add(new Edges(4, 3, 1));
        graph[4].add(new Edges(4, 2, 1));
        graph[4].add(new Edges(4, 5, 1));
        // 5-ertex
        graph[5].add(new Edges(5, 3, 1));
        graph[5].add(new Edges(5, 4, 1));
        graph[5].add(new Edges(5, 6, 1));
        // 6-ertex
        graph[6].add(new Edges(6, 5, 1));

    // how to travers the graphs 
    // they are two most used algorithms called
    // 1)BFS (breadth first search)
    // 2)Deapth first algorithm(DFS
    // travers the all neighbours of vertex 2)
    // for(int i=0;i<graph[2].size();i++){
    //     System.out.println(graph[2].get(i).desti);
    // }
    BFS(graph);
    System.out.println("DFS order");
    DFS(graph, 0, new boolean[graph.length]);
    System.out.println("check if has the path between two nodes");
    System.out.println(hasPath(graph, 0, 9, new boolean[graph.length]));
    }
}



