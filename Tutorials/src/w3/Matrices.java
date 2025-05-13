package w3;

public class Matrices {

    public static void printMatrix(int[][] matrix){
        int dimension = matrix.length;
        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
            System.out.println();
        }
    }

    public static int[][] multiply(int[][] A, int[][] B){
        int dimension = A.length;
        int[][] result = new int[dimension][dimension];
        for(int i = 0; i < dimension; i++)       // row in A
            for(int j = 0; j < dimension; j++){  // column in B
                result[i][j] = 0;
                for(int k = 0; k < dimension; k++)
                    result[i][j] += A[i][k] * B[k][j];
            }
        return result;
    }

    // Brute force version of matrix power
    public static int[][] slowPower(int[][] matrix, int exponent){
        // TO DO
        int[][] result = matrix;
        for(int e=0; e < exponent - 1; e++) {
            result = multiply(result, matrix);
        }
        return result;
    }

    // Divide-and-conquer version of matrix power
    public static int[][] fastPower(int[][] matrix, int exponent){
        // TO DO
        int[][] result = matrix;
        if (exponent == 0) {
            // Base case: A^0 is the identity matrix
            result = new int[matrix.length][matrix.length];
            for(int i = 0; i < matrix.length; i++) {
                result[i][i] = 1; // Set diagonal elements to 1
            }
            return result;
        } else if (exponent == 1) {
            // Base case: A^1 is A itself
            return result;
        } else if (exponent % 2 == 0) {
            // n is even: A^n = (A^(n/2))^2
            int[][] halfPower = fastPower(matrix, exponent / 2);
            result = multiply(halfPower, halfPower); // square the result
            return result;
        } else {
            // n is odd: A^n = A * (A^(n/2))^2
            int[][] halfPower = fastPower(matrix, (exponent-1) / 2);
            int[][] squaredHalfPower = multiply(halfPower, halfPower);
            result = multiply(matrix, squaredHalfPower);
            return result;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Try changing the dimension (needs to still be square) and exponent
        // to see how the runtime changes
        int[][] matrix = {{1,2},{3,4}};
        int exponent = 2;          //
        long start = System.currentTimeMillis();
        printMatrix(slowPower(matrix, exponent));
        long middle = System.currentTimeMillis();
        printMatrix(fastPower(matrix, exponent));
        long end = System.currentTimeMillis();
        System.out.println("Runtimes (ms): " + (middle-start) + ", " + (end-middle));
    }

}
