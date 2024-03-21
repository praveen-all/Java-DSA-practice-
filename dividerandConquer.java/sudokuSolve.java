// best example for backtracking

public class sudokuSolve {
// here we checking if the number eligible sit that position or not
    public static boolean ischecked(int sudoku[][],int row,int col,int digit){

            for(int i=0;i<=8;i++){
                if(sudoku[i][col]==digit){
                    return false;
                }
            }
            for(int i=0;i<=8;i++){
                if(sudoku[row][i]==digit){
                    return false;
                }
            }

            // now for grid

            int sr=(row/3)*3;
            int sc=(col/3)*3;
            for(int i=sr;i<sr+3;i++){
                for(int j=sc;j<sc+3;j++){
                    if(sudoku[i][j]==digit){
                        return false;
                    }
                }
            }

        return true;
    }



    public static boolean sudokuSolve(int sudoku[][],int row,int col){

        //   what its base case
        if(row==9 ){
            return true;
        }

       int nextrow=row,nxtcol=col+1;

       if(col+1==9){
        nextrow=row+1;
        nxtcol=0;
       }

       if(sudoku[row][col]!=0){
        return sudokuSolve(sudoku, nextrow, nxtcol);
       }

       for(int i=1;i<=9;i++){
        if(ischecked(sudoku,row,col,i)){
            sudoku[row][col]=i;
            if(sudokuSolve(sudoku, nextrow, nxtcol)){
                return true;
            }
            sudoku[row][col]=0;

        }
       }
    
       return false;
    }

    // printing an resultant

    public static void printarr(int sudoku[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int sudoku[][]={
            {0,0,8,0,0,0,0,0,0},
            {4,9,0,1,5,7,0,0,2},
            {0,0,3,0,0,4,1,9,0},
            {1,8,5,0,6,0,0,2,0},
            {0,0,0,0,2,0,0,6,0},
            {9,6,0,4,0,5,3,0,0},
            {0,3,0,0,7,2,0,0,4},
            {0,4,9,0,3,0,0,5,7},
            {8,2,7,0,0,9,0,1,3},
        };
       if( sudokuSolve(sudoku, 0, 0)){
          printarr(sudoku);//printing an array
       }else{
        System.out.println("sry solution doesnot exit");
       }

    }
}
