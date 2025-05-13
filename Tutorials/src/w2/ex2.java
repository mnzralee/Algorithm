package w2;

import java.util.ArrayList;

/*

 */
public class ex2 {
    public static int findSmallestMissing(int[] arr) {
        int maxValue = 0;

        for (int num : arr) {
            maxValue = Math.max(maxValue, num);
        }

        boolean[] seen = new boolean[maxValue + 1];
        for (int num : arr) {
            if (num <= maxValue) {
                seen[num] = true;
            }
        }

        for (int i=0; i<seen.length; i++) {
            if (!seen[i]) {
                return i;
            }
        }
        return maxValue + 1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 0, 3, 2, 5, 1, 0, 3};
        int missing = findSmallestMissing(arr);
        System.out.println("The smallest missing non-negative number is: " + missing); // Output: 6
    }
}
