package com.dsaproblems.varsha.arrays;

public class RotateMatrixBy90Degree {

    public static void rotate(int[][] matrix) {

        int n = matrix.length;

        //Transpose the matrix
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

        //Reversing the row elements
        for(int i = 0; i < n; i++){
            int left = 0;
            int right = n-1;

            while(left < right){

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;

            }
        }

    }

    public static void main(String[] args) {
        int[][] mat = { { 0, 1, 2 },
                { 3, 4, 0 },
                { 1, 3, 1,} };


        rotate(mat);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
