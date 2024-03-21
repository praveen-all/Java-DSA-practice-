public class searchSoertedRotetedArray {
    public static int rotated(int arr[],int si,int ei,int tar){
        if(si>ei){
            return -1;
        }

        int mid=(si+ei)/2;
        if(arr[mid]==tar){
            return mid;
        }
 
    //this for line one
       if(arr[si]<arr[mid]){
            if(arr[si]<=tar && tar<arr[mid]){
                return rotated(arr, si, mid-1, tar);
            }else{
                return rotated(arr, mid+1, ei, tar);
            }
       }
       else{
        if(arr[mid]<tar && arr[ei]>=tar ){
             return rotated(arr, mid+1, ei, tar);
        } else{
            return rotated(arr, si, mid-1, tar);
        }
       }
    }
    public static void main(String[] args) {
        int arr[]={3,4,5,6,7,8,0,1,2};
         System.out.println(rotated(arr, 0, arr.length-1, 10));
    }
}
