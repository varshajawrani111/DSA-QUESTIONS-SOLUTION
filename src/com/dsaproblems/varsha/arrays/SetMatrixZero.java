package com.dsaproblems.varsha.arrays;

public class SetMatrixZero {

    public static void setMatrixZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        //check if first row has zero
        for(int i=0; i<n; i++){
            if(matrix[0][i] == 0){
                firstRowZero = true;
            }
        }

        //check if first column has zero
        for(int i=0; i<m; i++){
            if(matrix[i][0] == 0){
                firstColumnZero = true;
            }
        }

        //Mark rows and colmuns to zero
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //Set zeros using mark
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        //check firstRow
        if(firstRowZero){
            for(int i=0; i<n; i++){
                matrix[0][i] = 0;
            }
        }

        //check first column
        if(firstColumnZero){
            for(int i=0; i<m; i++){
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = { { 0, 1, 2, 0 },
                { 3, 4, 0, 2 },
                { 1, 3, 1, 5 } };

        setMatrixZeroes(mat);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
