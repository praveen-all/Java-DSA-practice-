import java.util.Scanner;

public class NqueensOnNarray {

    public static void chess(char str[][],int row){
        if(row==str.length){
            printArray(str);
            return;
        }

        for(int j=0;j<str.length;j++){
        if(ischecked(str,row,j)){//we can check number able to fix ro not
             str[row][j]='Q';
             chess(str,row+1);
             str[row][j]='X';
        }
              
        }

    }

    public static boolean ischecked(char [][]str,int row,int col){
        for(int i=row-1;i>=0;i--){
            if(str[i][col]=='Q'){
                return false;
            }
        }

        for(int i=row-1,j=col-1;i>=0 &&j>=0;i--,j--){
            if(str[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<str.length;i--,j++){
            if(str[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }

    public static void printArray(char[][]str){
        System.out.println("----------------chess bord-------------\n");
        System.out.println("----".repeat(str.length));
        for(int i=0;i<str.length;i++){
            System.out.print("| ");
            for(int j=0;j<str.length;j++){
                System.out.print(str[i][j]+" | ");
            }
            System.out.println();
            System.out.println("----".repeat(str.length));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char [][] str=new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                str[i][j]='X';
            }
        }

        chess(str,0);
    }
}
