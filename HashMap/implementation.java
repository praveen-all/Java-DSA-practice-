import java.util.*;
public class implementation {
    static class HashMap<k,v>{
        class Node{
            k key;
            v val;
            public Node(k key,v val){
                this.key=key;
                this.val=val;
            }
        }

        private int n;//size of total nodes
        private int N;
        private LinkedList<Node> bucket[];

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N=4;
            this.bucket=new LinkedList[4];
            for(int i=0;i<bucket.length;i++){
                bucket[i]=new LinkedList<>();
            }
        }

        // now put the key and val 
        private int hasFunction(k key){
            int hc=key.hashCode();
            return Math.abs(hc)%N;
        }

        private int searchInLL(k key,int bi){
            LinkedList<Node> ll=bucket[bi];
            int di=0;
            for(int i=0;i<ll.size();i++){
                Node node=ll.get(i);
                if(node.key==key){
                    return di;
                }
                di++;
            }
            return -1;
        }
        @SuppressWarnings("unchecked")
        private void rehashMap(){
            LinkedList<Node> old[]=bucket;
            bucket=new LinkedList[N*2];
            N=N*2;
            //initialize the bucket with linked list
            for(int i=0;i<bucket.length;i++){
                bucket[i]=new LinkedList<>();
            }
            // add the old value to new created bucket
            for(int i=0;i<old.length;i++){
                LinkedList<Node> ll=old[i];
                for(int j=0;j<ll.size();j++){
                     Node node=ll.get(j);
                     put(node.key, node.val);
                }
            }
        }
        public  void put(k key,v val){
            int bi=hasFunction(key);//find the bucket index using hascode
            int di=searchInLL(key,bi);//return the index of node

            if(di!=-1){
                Node node=bucket[bi].get(di);
                node.val=val;
            }else{
                bucket[bi].add(new Node(key, val));
                n++;
            }
            double lambda=(double) n/N;//we have to  fix length of linked list to some critical because to balance good TC
            if(lambda>2.0){
                rehashMap();
            }
        }

        // check contains te key or not 
        public boolean containsKey(k key){
            int bi=hasFunction(key);//find the bucket index using hascode
            int di=searchInLL(key,bi);//return the index of node

            if(di!=-1){
               return true;
            }else{
                return false;
            }
        }
        
        public v get(k key){
            int bi=hasFunction(key);//find the bucket index using hascode
            int di=searchInLL(key,bi);//return the index of node

            if(di!=-1){
              Node node=bucket[bi].get(di);
               return node.val;
            }else{
                return null;
            }
        }

        // size
        public int size(){
            return n;
        }
        // isEmpty
        public boolean isEmpty(){
            return n==0;
        }

        public v remove(k key){
            int bi=hasFunction(key);//find the bucket index using hascode
            int di=searchInLL(key,bi);//return the index of node

            if(di!=-1){
              Node node=bucket[bi].remove(di);
              n--;
               return node.val;
            }else{
                return null;
            }
        }

        public ArrayList<k> keySet(){
            ArrayList<k> keys=new ArrayList<>();
            for(int i=0;i<bucket.length;i++){
                LinkedList<Node> ll=bucket[i];
                for(int j=0;j<ll.size();j++){
                     keys.add(ll.get(j).key);
                }
            }
            return keys;
        }

    }
    public static void main(String[] args) {
        HashMap map=new HashMap<>();
        map.put("India", 100);
        map.put("china", 0);
        map.put("Iron", 88);
        map.put("brazel",894);

        System.out.println(map.keySet());
        System.out.println(map.containsKey("India"));
        System.out.println(map.remove("India"));
        System.out.println(map.remove("Inda"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}
