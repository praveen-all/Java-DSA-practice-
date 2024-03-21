public class arrayBack{
    public static void back(int []arr,int i){
        if(i==arr.length){
            print(arr);
            return ;
        }

        arr[i]=i+1;
        back(arr, i+1);
        arr[i]-=2;
    }
    public static void print(int arr[]){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]=new int[5];
        back(arr,0);
        print(arr);
    }
}