import java.lang.invoke.CallSite;
import java.util.*;
// using the method of DFS check cycle exist or not 
public class DirectedCycle {
    static class Edges{
        int src;
        int desti;
        public Edges(int src,int dest){
            this.desti=dest;
            this.src=src;
        }
    }
    //function
    public static boolean isCycle(ArrayList<Edges>[]graph){
        boolean visited[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(isCycleUtil(graph,visited,stack,i)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edges>[]graph,boolean[]visited,boolean[]stack,int cur){
        visited[cur]=true;
        stack[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edges e=graph[cur].get(i);
            if(stack[e.desti]){
                return true;
            }
            if(!visited[e.desti]&& isCycleUtil(graph, visited, stack, e.desti)){
                return true;
            }
        }
        stack[cur]=false;
        return false;
    }
    // detect the cycle in directed graph using DFS method
    public static boolean detectcycle(ArrayList<Edges>[]graph){
        boolean []visited=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(util(graph,visited,stack,i)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean util(ArrayList<Edges>[]graph,boolean[]visited,boolean[]stack,int cur){
        visited[cur]=true;
        stack[cur]=true;
        for(int j=0;j<graph[cur].size();j++){
            Edges e=graph[cur].get(j);
            if(stack[e.desti]){
                return true;
            }
            if(!visited[e.desti]&& util(graph, visited, stack, e.desti)){
                return true;
            }
        }
        stack[cur]=false;
        return false;
    }
    public static void main(String[] args) {
        // create graph
        ArrayList<Edges> graph[]=new ArrayList[4];
        // initialize the all graph by arraylist
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edges(0, 2));
        graph[2].add(new Edges(2, 1));
        graph[1].add(new Edges(1, 0)); 
        // graph[3].add(new Edges(3, 0));
        
         
         System.out.println(isCycle(graph)); 
        System.out.println(detectcycle(graph));
    }
}
