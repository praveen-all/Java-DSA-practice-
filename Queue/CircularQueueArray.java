public class CircularQueueArray {
    static class Queue{
      static int arr[];
      static int size;
      static int rear;
      static int front;

      public Queue(int size){
        this.size=size;
        arr=new int[size];
        this.rear=-1;
        this.front=-1;
      }


    //   check isEmpty();
      public static boolean isEmpty(){
        return front==-1 && rear==-1;
      }

    //   check isFull();
      public static boolean isFull(){
        return (rear+1)%size==front;
      }

    //   add
    public static void add(int data){
        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }

        if(front==-1){
            front=0;
        }

        rear=(rear+1)%size;
        arr[rear]=data;
    }

    // remove 
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            int result=arr[front];
            if(front==rear){
                front=rear=-1;
            }else{
                front=(front+1)%size;
            }

            return result;
        }
        // peek()

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            return arr[front];
        }
    }
    public static void main(String[] args) {
          Queue q=new Queue(4);
          q.add(23);
          q.add(90);
          q.add(87);
          q.add(3);
          while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
          }
    }
}
