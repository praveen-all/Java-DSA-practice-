import java.util.*;
public class NQueensPart2 {
    public static boolean isSafe(char str[][],int row,int col){
        // column up
        for(int i=row-1;i>=0;i--){
            if(str[i][col]=='Q'){
                return false;
            }
        }

        // upleft diagonal
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(str[i][j]=='Q'){
                return false;
            }
        }

        // upright diagonal
        for(int i=row-1,j=col+1;i>=0&& j<str.length;i--,j++){
            if(str[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
 static int size=0;
    public static void newqueen(char str[][],int row){
        if(row==str.length){
            size++;
            if(size==1)
            printarray(str);
            return;
        }
        for(int i=0;i<str.length;i++){
            if(isSafe(str,row,i)){
                str[row][i]='Q';
                newqueen(str, row+1);
                str[row][i]='X';
            }

        }
    }

    // printing an character array
    public static void printarray(char str[][]){
        System.out.println("------------chess boards------------");
        System.out.println("");
        for(int i=0;i<str.length;i++){
            for(int j=0;j<str.length;j++){
                System.out.print(str[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char str[][]=new char[n][n];
        for(int i=0;i<str.length;i++){
            for(int j=0;j<n;j++){
                str[i][j]='X';
            }
        }

        newqueen(str,0);
        
    }
}
