import java.util.Scanner;
import java.io.*;

public class main {
    public static void main(String[] args){
        int numOfEqus, choice;
        Scanner sc = new Scanner(System.in);
        Matrix matrix;

        do{
            System.out.print("Please enter the number of equations you want to enter: ");

            numOfEqus = sc.nextInt();
        }while(numOfEqus < 11);
        System.out.println("\nPlease enter (1) if you want to enter coefficients (including the b values) by command line or " +
                "(2) if you want to enter your file name which has the augmented coefficient matrix (including the b values)");
        choice = sc.nextInt();
        if (choice == 1){
            matrix = commandLine(numOfEqus);
        }
        else if (choice == 2){
            matrix = readFromFile(numOfEqus);
        }
        else
            System.exit(1);


    }

    private static Matrix readFromFile(int row) {
        String fileName;
        Scanner sc = new Scanner(System.in);
        int col;
        do{
            System.out.println("How many coefficients are in each equation? ");
            col = sc.nextInt();
        }while(col < 12);
        double[][] matrix = new double[row][col];
        System.out.println("What is the name of the file containing the matrix? ");
        fileName = sc.nextLine();
        try{
            int num1 = 0, num2 = 0;
            File myFile = new File(fileName);
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()){
                while (num2 < col){
                    double num = reader.nextDouble();
                    matrix[num1][num2] = num;
                    num2++;
                }
                num1++;
            }
            reader.close();
            Matrix output = new Matrix(matrix);
            return output;
        }catch(Exception e) {
            System.out.println("An error occurred. Program shutting down.");
            System.exit(1);
        }
        return null;
    }

    private static Matrix commandLine(int row) {
        Scanner sc = new Scanner(System.in);
        int col;
        do{
            System.out.println("How many coefficients are in each equation? ");
            col = sc.nextInt();
        }while(col < 12);
        double[][] matrix = new double[row][col];
        System.out.println("Please enter " + (col * row) + " numeric values:");
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                matrix[i][j] = sc.nextDouble();
            }
        }
        Matrix output = new Matrix(matrix);
        return output;
    }

    public Matrix rowMaxElem(Matrix m){
        double rowMax= 0;
        int pivotRow = 0;
        int[] rowNumbers = new int[m.getRow()];
        for (int i = 0; i < m.getRow(); i++){
            rowNumbers[i] = i;
        }
        double[] maxArray = new double[m.getRow()];
        for(int i = 1; i <= m.getRow(); i++){
            for (int j = 1; j <=m.getCol(); j++){
                if (m.getElem(i, j) > rowMax){
                    rowMax = m.getElem(i, j);
                    maxArray[i] = rowMax;
                }
                rowMax = 0;
            }
        }

        for (int i = 1; i < (m.getRow()-1); i++){
            double rMax = 0;
            for (int j = i; j < m.getRow(); j++){
                double r = Math.abs(m.getElem((i-1), (j-1))/maxArray[i]);
                if (r > rMax){
                    rMax = r;
                    pivotRow = i;
                }
            }
            if (rowNumbers[pivotRow] != rowNumbers[i]){
                int temp = rowNumbers[i];
                rowNumbers[i] = rowNumbers[pivotRow];
                rowNumbers[pivotRow] = temp;
            }
            for (int j = i + 1; j < m.getRow(); j++){

            }
        }
    }
}
