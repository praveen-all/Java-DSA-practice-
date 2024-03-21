public class heapSort {

         public static void heapify(int arr[],int indx,int size){
                 int left=indx*2+1;
                 int right=indx*2+2;
                 int maxindx=indx;

                 if(left<size && arr[maxindx]<arr[left]){
                    maxindx=left;
                 }
                 if(right<size && arr[maxindx]<arr[right]){
                    maxindx=right;
                 }

                 if(maxindx!=indx){
                    int temp=arr[maxindx];
                    arr[maxindx]=arr[indx];
                    arr[indx]=temp;
                    heapify(arr,maxindx,size);
                 }
        }
         public static void heapSort(int arr[]){
            int n=arr.length;
            for(int i=n/2;i>=0;i--){
                heapify(arr,i,n);
            }

            // next step rotate the last and first elemet then call the heapify size each reduce to n-1

            for(int i=n-1;i>=0;i--){
                int temp=arr[i];
                arr[i]=arr[0];
                arr[0]=temp;
                heapify(arr,0,i);
            }
        }
    public static void main(String[] args) {
        // sort the given array using heap sort
        int arr[]={1,2,5,4,3,99,33,566,5,-439,3938,30,-33};
          heapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
