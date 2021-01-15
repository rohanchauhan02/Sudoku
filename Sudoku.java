import java.util.*;
public class Sudoku{
    public static void main(String[] args){
        int [][]matrix={{3,1,9,5,0,8,4,0,0},
                        {5,2,0,0,0,0,0,0,0},
                        {0,8,7,0,0,0,0,3,1},
                        {0,0,3,0,1,0,0,8,0},
                        {0,0,0,8,6,0,0,0,5}, 
                        {0,5,0,0,9,0,6,0,0}, 
                        {1,3,0,0,0,0,2,5,0}, 
                        {0,0,0,0,0,0,0,7,4},
                        {0,0,5,2,0,6,3,0,0}};
                        display(matrix);
                        System.out.println("output->");
                        sudoku(matrix,0);
    }
    public static void display(int [][] matrix){
        for(int i=0;i<matrix.length;i++){
            if(i!=0 && i%3==0) System.out.println("-------------------");
            for(int j=0;j<matrix[0].length;j++){
                if(j!=0 && j%3==0) System.out.print("|");
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static boolean isSafePlace(int [][]matrix,int row,int col,int data){
        for(int i=0;i<9;i++){
            if(matrix[i][col]==data) return false;
            if(matrix[row][i]==data) return false;
        }
        int nrow=(row/3)*3;
        int ncol=(col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(matrix[nrow+i][ncol+j]==data) return false;
            }
        }
        return true;
    }
    public static void sudoku(int [][]matrix,int idx){
        if(idx == 81){
            display(matrix);
            return;
        }
        int row=idx/9;
        int col=idx%9;
        if(matrix[row][col]==0){
            for(int i=1;i<=9;i++){
                if(isSafePlace(matrix,row,col,i)){
                    matrix[row][col]=i;
                    sudoku(matrix,idx+1);
                    matrix[row][col]=0;
                }
            }
        }
        else sudoku(matrix,++idx);

    }
}