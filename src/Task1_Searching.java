
public class Task1_Searching {

    static final int SIZE = 100000;

    // Linear Search
    // Returns index and number of comparisons
    static int[] linearSearch(int[] arr, int target) {

        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {

            comparisons++;

            if (arr[i] == target) {
                return new int[]{i, comparisons};
            }
        }

        return new int[]{-1, comparisons};
    }

    // Binary Search
    // Array must be sorted
    static int[] binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int comparisons = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            comparisons++;

            if (arr[mid] == target) {
                return new int[]{mid, comparisons};
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{-1, comparisons};
    }

    public static void main(String[] args) {

        // Generate 100,000 sorted transaction IDs
        int[] transactionIds = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            transactionIds[i] = 1001 + i;
        }

        System.out.println("TOTAL TRANSACTIONS: " + SIZE);

        // --------------------------------
        // LINEAR SEARCH ANALYSIS
        // --------------------------------

        int[] linearBest = linearSearch(transactionIds, 1001);
        int[] linearWorst = linearSearch(transactionIds, 101000);

        long linearTotal = 0;

        // Calculate average comparisons
        for (int id : transactionIds) {
            linearTotal += linearSearch(transactionIds, id)[1];
        }

        double linearAverage = (double) linearTotal / SIZE;

        System.out.println("\n--- LINEAR SEARCH ---");

        System.out.println("Best case comparisons: "
                + linearBest[1]);

        System.out.println("Average case comparisons: "
                + linearAverage);

        System.out.println("Worst case comparisons: "
                + linearWorst[1]);

        // --------------------------------
        // BINARY SEARCH ANALYSIS
        // --------------------------------

        int[] binaryBest = binarySearch(transactionIds, 51000);

        int binaryMin = Integer.MAX_VALUE;
        int binaryMax = Integer.MIN_VALUE;
        long binaryTotal = 0;

        // Calculate comparison statistics for all IDs
        for (int id : transactionIds) {

            int comparisons = binarySearch(transactionIds, id)[1];

            binaryTotal += comparisons;

            binaryMin = Math.min(binaryMin, comparisons);
            binaryMax = Math.max(binaryMax, comparisons);
        }

        double binaryAverage = (double) binaryTotal / SIZE;

        System.out.println("\n--- BINARY SEARCH ---");

        System.out.println("Best case comparisons: "
                + binaryMin);

        System.out.println("Average case comparisons: "
                + binaryAverage);

        System.out.println("Worst case comparisons: "
                + binaryMax);

        // --------------------------------
        // PERFORMANCE COMPARISON
        // --------------------------------

        int target = 51000;

        int[] linearResult = linearSearch(transactionIds, target);
        int[] binaryResult = binarySearch(transactionIds, target);

        System.out.println("\n--- SEARCH COMPARISON ---");

        System.out.println("Target Transaction ID: " + target);

        System.out.println("Linear Search comparisons: "
                + linearResult[1]);

        System.out.println("Binary Search comparisons: "
                + binaryResult[1]);

        System.out.println("\nTransaction found at index: "
                + binaryResult[0]);
    }
}
