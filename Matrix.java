import java.util.*;

public class Matrix {
    private double[][] matrix;
    private int col;
    private int row;

    public Matrix(double[][] d){
        matrix = d;
        row = matrix.length;
        col = matrix[0].length;
    }

    public void printMatrix(){
        for (int i = 0; i < row; i++){
            System.out.print("| ");
            for (int j = 0; j < col; j++){
                System.out.printf("%7.3f", matrix[i][j]);
            }
            System.out.println(" |");
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public double getElem(int r, int c){ return matrix[r][c];}

    public double[][] getArray() {
        double[][] returnArray = new double[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                returnArray[i][j] = getElem(i, j);
            }
        }
        return returnArray;
    }

    public void setElem(double d, int r, int c){
       double arr[][] = getArray();
       for (int i = 0; i < this.row; i++){
           for (int j = 0; j < this.col; j++){
               if ((r == i) && (c == j))
                   arr[i][j] = d;
           }
       }
       matrix = arr;
    }
}
