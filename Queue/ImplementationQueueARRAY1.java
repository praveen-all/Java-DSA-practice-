public class ImplementationQueueARRAY1 {
    // implementation of Queue using array

        static class Queue{
            static int arr[];
            static int size;
            static int rear;
            public Queue(int size){
                this.arr=new int[size];
                this.size=size;
                this.rear=-1;
            }
            public static boolean isEmpty(){
                return rear==-1;
            }
            // add
            public static void add(int data){
                if(rear==arr.length-1){
                    System.out.println("queue is fulled");
                    return ;
                }
                rear=rear+1;
                arr[rear]=data;
            }

            // remove 
            public static int remove(){
                if(isEmpty()){
                    System.out.println("sry Queue is Empty()");
                    return -1;
                }

                int top=arr[0];
                for(int i=0;i<rear;i++){
                    arr[i]=arr[i+1];
                }
                rear=rear-1;
                return top;
            }

            // peek();

            public static int peek(){
                return  arr[0];
            }
        }
        public static void main(String[] args) {
            Queue q= new Queue(8);
            q.add(23);
            q.add(23);
            q.add(989);
            q.add(123);
            q.add(908);

            while(!q.isEmpty()){
                System.out.println(q.peek());
                q.remove();
            }
        }
}
