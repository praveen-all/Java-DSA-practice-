import java.util.Stack;

// public class stackusingLinkedList {

//     static class Node{
//         int data;
//         Node next;
//         public Node(int data){
//             this.data=data;
//             this.next=null;
//         }
//     }
//     static class Stack{
//         public static Node head=null;

//         //    to check is empty
//         public static boolean empty(){
//             return head==null;
//         }

//         // push element to stack using linked list

//         public static void push(int data){
//             Node newnode=new Node(data);
//             if(empty()){
//                 head=newnode;
//                 return;
//             }
//             newnode.next=head;
//             head=newnode;
//             return;
//         }
//         // pop elements from stack 

//         public static int pop(){
//             if(head==null){
//                 System.out.println("stack be an empty");
//                 return -1;
//             }
//             int top=head.data;
//             head=head.next;
//             return top;
//         }

//         // to get top elemnt from a stack

//         public static int peek(){
//             if(head==null){
//                 System.out.println("stack be an empty");
//                 return -1;
//             }
//             int top=head.data;
//             return top;
//         }

//     }
//     public static void main(String[] args) {
//         // //  Stack ss=new Stack();
//         //  ss.push(23);
//         //  ss.push(45);
//         //  ss.push(90);
//         //  ss.push(109);

//         //  while(!ss.empty()){
//         //     System.out.println(ss.peek());
//         //     ss.pop();
//         //  }
//         //  System.out.println(ss.pop());
//     }
// }


public class stackusingLinkedList{
    public static void main(String[] args) {
        Stack<Integer> ss=new Stack<>();
        ss.push(23);
        ss.push(56);
        ss.push(9083);
        ss.push(323);
        ss.push(83);
        while(!ss.isEmpty()){
            System.out.println(ss.peek());
            ss.pop();
        }
    }
}