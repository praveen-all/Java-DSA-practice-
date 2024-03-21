import java.util.*;
public class Praveen {
    static class HashMapp<k,v>{
        private class Node{
            k key;
            v value;
            public Node(k key,v value){
                this.key=key;
                this.value=value;
            }
    
        }
        private int n;
        private int N;
        private LinkedList<Node> bucket[];
        @SuppressWarnings("unchecked")
        public HashMapp(){
            this.N=4;
            
            this.bucket=new LinkedList[4];
            // initializing each bucket by linked list
            for(int i=0;i<4;i++){
                this.bucket[i]=new LinkedList<>();
            }
        }
    
        private int hashFunction(k key){
            int hc=key.hashCode();
            return Math.abs(hc)%N;
        }
        private int searchInLL(int bi,k key){
            LinkedList<Node> ll=this.bucket[bi];
            int di=0;
            for(int i=0;i<ll.size();i++){
              
                if(ll.get(i).key==key){
                    return di;
                }
                di++;
            }
            return -1;
        }
        @SuppressWarnings("unchecked")
    
        private void rehashing(){
            LinkedList<Node>old[]=bucket;
            bucket=new LinkedList[N*2];
            N=N*2;
            n=0;
            for(int i=0;i<bucket.length;i++){
                bucket[i]=new LinkedList<>();
            }
            for(int i=0;i<old.length;i++){
                LinkedList<Node> ll=old[i];
                for(Node node:ll){
                    put(node.key, node.value);
                }
            }
        }
        public void put(k key,v value){
            int bi=hashFunction(key);
            int di=searchInLL(bi,key);
    
            if(di!=-1){
                Node node=bucket[bi].get(di);
                node.value=value;
            }else{
           bucket[bi].add(new Node(key,value));
           n++;
            }
            
    
            double lamda=(double)n/N;
            if(lamda>=2.0){
                rehashing();
            }
    
        }
        public v get(k key){
            int bi=hashFunction(key);
            int di=searchInLL(bi,key);
    
            if(di!=-1){
                Node node=bucket[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }
        public boolean containsKey(k key){
            int bi=hashFunction(key);
            int di=searchInLL(bi,key);
    
            if(di!=-1){
               return true;
            }
            return false;
        }
    
        public boolean isEmpty(){
            return n==0;
        }
        public v remove(k key){
            int bi=hashFunction(key);
            int di=searchInLL(bi,key);
            
            if(di!=-1){
                Node node=bucket[bi].remove(di);
                n--;
                return node.value;
                
            }else{
                return null;
            }
        }
        public ArrayList<k> keySet(){
            ArrayList<k> ll=new ArrayList<>();
            for(int i=0;i<bucket.length;i++){
                LinkedList<Node> l=bucket[i];
                for(Node node:l){
                   ll.add(node.key);
                }
            }
            return ll;
        }
    }
    
    public static void main(String[] args) {
        HashMapp<String ,Integer> map=new HashMapp<>();
      map.put("pavi", 12);
      map.put("aavi", 152);
      map.put("ravi", 14);
      map.put("kavi", 182);
       ArrayList<String> keys=map.keySet();
       for(String s:keys){
        System.out.println(map.get(s));
       }
    } 
}
