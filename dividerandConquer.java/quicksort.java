public class quicksort {

    public static void partition(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
             
        int pind=findpivote(arr,si,ei);
        partition(arr, si, pind-1);
        partition(arr, pind+1, ei);
    
    }

    public static int findpivote(int arr[],int si,int ei){
        int pivote=arr[ei];
        int i=si-1;
        for(int j=si;j<ei;j++){
             if(arr[j]<=pivote){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
             }
        }

        i++;
        int temp=pivote;
        arr[ei]=arr[i];
        arr[i]=temp;

        return i;
    }

    public static void main(String[] args) {
        int arr[]={8,4,5,7,9,5};
        partition(arr, 0, arr.length-1);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
