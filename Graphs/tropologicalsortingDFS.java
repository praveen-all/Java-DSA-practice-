import java.util.*;


public class tropologicalsortingDFS {
    static class Eadges{
        int desti;
        int src;
        public Eadges(int src,int desti){
            this.src=src;
            this.desti=desti;
        }
    }

    public static void isCycle(ArrayList<Eadges>[]graph){
        Stack<Integer> stack=new Stack<>();
        boolean visited[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                isCycleUtil(graph,visited,stack,i);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+"  ");
        }
    }
    public static void isCycleUtil(ArrayList<Eadges>[]graph,boolean[]visited,Stack<Integer>stack,int cur){
        visited[cur]=true;
        // call to neighbour
        for(int i=0;i<graph[cur].size();i++){
            Eadges e=graph[cur].get(i);
            if(!visited[e.desti]){
                isCycleUtil(graph, visited, stack, e.desti);
            }
        }
        stack.push(cur);
    }
    // topological sort using BFS kanhs algoritm
    public static void calindeg(ArrayList<Eadges>[]graph,int []indeg){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Eadges e=graph[i].get(j);
                indeg[e.desti]++;
            }
        }
    }
    public static void topological(ArrayList<Eadges>[]graph){
        int indeg[]=new int[graph.length];
        calindeg(graph,indeg);
        Queue<Integer> q=new LinkedList<>();
        // add all 0 indeg indec to queue
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr=q.remove();
            System.out.println(curr+" ");
            for(int i=0;i<graph[curr].size();i++){
                Eadges e=graph[curr].get(i);
                indeg[e.desti]--;
                if(indeg[e.desti]==0){
                    q.add(e.desti);
                }
            }
        }
    }
    // printh all path from sec to desti
    public static void printallpath(ArrayList<Eadges>[]graph,int src,int desti,String path){
        if(src==desti){
            System.out.println(path+src);
            return ;
        }
        for(int i=0;i<graph[src].size();i++){
           Eadges e=graph[src].get(i);
           printallpath(graph, e.desti, desti, path+src);

        }
    }

    // topological sort using dfs
    public static void topologicalsortDfs(ArrayList<Eadges>[]graph){

        boolean []visited=new boolean[graph.length];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                topologicalsortDfsUtil(graph,visited,s,i);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }

    }
    public static void topologicalsortDfsUtil(ArrayList<Eadges>[]graph,boolean[]visited,Stack<Integer>s,int cu){
        visited[cu]=true;
        for(int i=0;i<graph[cu].size();i++){
            Eadges e=graph[cu].get(i);
            if(!visited[e.desti]){
                topologicalsortDfsUtil(graph, visited, s, e.desti);
            }
        }
        s.add(cu);
    }
    public static void main(String[] args) {
           ArrayList<Eadges>[]graph=new ArrayList[6];
           for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        // graph[0].add(new Eadges(0, 3));
           graph[2].add(new Eadges(2, 3));
           graph[3].add(new Eadges(3, 1));
           graph[5].add(new Eadges(5, 2));
           graph[5].add(new Eadges(5, 0));
           graph[4].add(new Eadges(4, 0));
           graph[4].add(new Eadges(4, 1));
        //    isCycle(graph);
        topologicalsortDfs(graph);
        // topological(graph);
        // printallpath(graph, 5, 1, "");

    }
}
