package org.example;

/**
 *
 * @author draegek
 */
public class Matrices {

    public static void printMatrix(int[][] matrix){
        int dimension = matrix.length;
        for (int[] ints : matrix) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public static int[][] multiply(int[][] A, int[][] B){
        int dimension = A.length;
        int[][] result = new int[dimension][dimension];
        for(int i = 0; i < dimension; i++) {       // row in A
            for (int j = 0; j < dimension; j++) {  // column in B
                result[i][j] = 0;
                for (int k = 0; k < dimension; k++)
                    result[i][j] += A[i][k] * B[k][j];
            }
        }
        return result;
    }

    // Brute force version of matrix power
    public static int[][] slowPower(int[][] matrix, int exponent){
        // TO DO
        int dimension = matrix.length;

        int[][] result = new int[dimension][dimension];

        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++){
                result[i][j] = matrix[i][j];
            }
        }

        for(int i = 1; i < exponent; i++){
            result = multiply(result, matrix); 
        }

        return result;
    }

    // Divide-and-conquer version of matrix power
    public static int[][] fastPower(int[][] matrix, int exponent){
        // TO DO
        if (exponent == 1) { // just return the given matrix
            return matrix;
        }

        // first recursively compute the power with half the exponent (rounding down)
        // What happen if the exponent is 5
        int [][] result_half = fastPower(matrix, exponent / 2);

        // Then square it

        int [][] result_even = multiply(result_half, result_half);

        // Matrix = A^4, exponent = 5
        // If the exponent is even, this is the result, e.g. A^6 = (A^3)^2
        if (exponent % 2 == 0) {
            return result_even;
        }

        return multiply(result_even, matrix);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Try changing the dimension (needs to still be square) and exponent
        // to see how the runtime changes
        int[][] matrix = {{1,2},{3,4}};
        int exponent = 9;          //
        long start = System.currentTimeMillis();
        printMatrix(slowPower(matrix, exponent));
        long middle = System.currentTimeMillis();
        printMatrix(fastPower(matrix, exponent));
        long end = System.currentTimeMillis();
        System.out.println("Runtimes (ms): " + (middle-start) + ", " + (end-middle));
    }

}
