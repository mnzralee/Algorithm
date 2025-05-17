package w4;

import java.util.Random;

public class MergeSort {

    // Merge (sorted) ranges values[first]...values[mid] and values[mid+1]...values[last]
    private static void mergeRanges(int[] values, int first, int mid, int last){
        // TO DO: implement the merge function
        int[] aux = new int[last - first + 1]; // Temporary array to hold merged values
        int i = first, j = mid + 1, k = 0;

        // Compare elements from the two ranges and merge them into aux
        while (i <= mid && j <= last) {
            if (values[i] <= values[j]) {
                aux[k++] = values[i++];
            } else {
                aux[k++] = values[j++];
            }
        }

        // Copy any remaining elements from the first range
        while (i <= mid) {
            aux[k++] = values[i++];
        }

        // Copy any remaining elements from the second range
        while (j <= last) {
            aux[k++] = values[j++];
        }

        // Copy the sorted elements from aux back to the original array
        System.arraycopy(aux, 0, values, first, aux.length);
    }


    // Auxiliary recursive function
    // Sorts the range values[first]...values[last]
    private static void sortRange(int[] values, int first, int last){
        if(last > first){    // Otherwise there is nothing to do (single value)
            int mid = (first + last) / 2;
//            System.out.println("one " + first + " " + mid + " " + last);
            sortRange(values, first, mid);      // Recursively sort first half
//            System.out.println("two " + first + " " + mid + " " + last);
            sortRange(values, mid + 1, last);   // Recursively sort second half
            System.out.println("three " + first + " " + mid + " " + last);
            mergeRanges(values, first, mid, last); // Merge sorted halves
        }
    }

    public static void sort(int[] values){
        sortRange(values, 0, values.length - 1);
    }

    public static int[] randomValues(int howMany){
        int[] result = new int[howMany];
        Random random = new Random();
        for(int i=0; i<howMany; i++)
            result[i] = random.nextInt() % (10 * howMany);
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // How many values to generate
        int numValues = 5;
        // Whether to print results. Only use with small numbers of values.
        boolean printResults = true;


        int[] a = randomValues(numValues);
        if(printResults){
            System.out.print("Before sorting: ");
            for(int i=0;i<numValues; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }
        long start = System.currentTimeMillis();
        sort(a);
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;
        if(printResults){
            System.out.print("After sorting: ");
            for(int i=0;i<numValues; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }
        System.out.println();
        System.out.println("Elapsed time = " + elapsed + " seconds");
    }
}
