import java.util.*;
public class neartoCar {
    static class Info implements Comparable<Info>{
        int x;
        int y;
        int square;
        int indx;
        public Info(int x,int y,int square,int indx){
            this.x=x;
            this.y=y;
            this.square=square;
            this.indx=indx;
        }

        @Override
        public int compareTo(Info p1){
            return this.square-p1.square;
        }
    }
    public static void main(String[] args) {
        int point[][]={{3,3},{5,-1},{-2,4}};
        int k=2;

        PriorityQueue<Info> pq=new PriorityQueue<>();
        for(int i=0;i<point.length;i++){
            int square=point[i][0]*point[i][0]+point[i][1]*point[i][1];
            pq.add(new Info(point[i][0], point[i][1], square, i));
        }

        // now print the k car nearby origin or me 
        for(int i=0;i<k;i++){
            System.out.println("C"+pq.remove().indx);
        }

    }
}
