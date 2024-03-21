public class an {
    public static void mergsort(int arr[],int si,int ei){

        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;
        mergsort(arr, si, mid);
        mergsort(arr, mid+1, ei);
        merge(arr,si,mid,ei);
    }

    public static void merge(int []arr,int si,int mid,int ei){
        int i=si;
        int j=mid+1;
        int k=0;
        int temp[]=new int[ei-si+1];
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
               i++;
            }
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        for(int p=0,l=si;p<temp.length;p++,l++){
               arr[l]=temp[p];
        }
    }
      public static void main(String[] args) {
        int arr[]={6,3,95,43};
        mergsort(arr, 0, arr.length-1);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
      }
}
