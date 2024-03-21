import java.util.spi.ToolProvider;

public class SQUIREL{
    public static void suirel(int arr[][]){
        int colstart=0;
        int rowstart=0;
        int colend=arr[0].length-1;
        int rowend=arr.length-1;
        while (colstart<=colend && rowstart<=rowend) {
            // top
            for(int i=colstart;i<=colend;i++){
                System.out.print(arr[rowstart][i]+" ");
            }

            // right side
            rowstart++;
            for(int i=rowstart;i<=rowend;i++){
                System.out.print(arr[i][colend]+" ");
            }

            // down
            colend--;
            for(int i=colend;i>=colstart;i--){
                System.out.print(arr[rowend][i]+" ");
            }

            rowend--;
            for(int i=rowend;i>=rowstart;i--){
                System.out.print(arr[i][colstart]+" ");

            }

            colstart++;

        }
    }
    
public static void main(String[] args) {
    int arr[][]={
        {10,20,30,40},{15,25,35,45},{27,29,37,48},
        {32,33,39,50}

    };

 
}
}