import java.util.Comparator;
import java.util.PriorityQueue;;
public class PQusingJCF{
    static class Student implements Comparable<Student>{
        int rank;
        String name;
        public Student(String name,int rank){
            this.name=name;
            this.rank=rank;
        }
        @Override
        public int compareTo(Student s2){
               return this.rank-s2.rank;
        }
    }
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq=new PriorityQueue<>();
        PriorityQueue<Student> pq=new PriorityQueue<>();
        pq.add(new Student("pavan", 1));
        pq.add(new Student("praveen", 100));
        pq.add(new Student("darshan t", 2));
        pq.add(new Student("kiran G", 3));
        pq.add(new Student("bhuvan", 166));
         System.out.println("our college toppers ");
         System.out.println(" name   -->  rank");
        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+"    -> "+pq.peek().rank);
            pq.remove();
        }
    }
}