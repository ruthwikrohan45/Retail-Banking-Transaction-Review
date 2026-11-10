
import java.time.LocalDateTime;

public class Task2_Sorting {

    // Compare transactions by posting date
    static int compare(Transaction a, Transaction b) {
        return a.postingDate.compareTo(b.postingDate);
    }

    // INSERTION SORT
    static void insertionSort(Transaction[] arr) {

        for (int i = 1; i < arr.length; i++) {

            Transaction key = arr[i];
            int j = i - 1;

            // Shift later dates to the right
            while (j >= 0 && compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // MERGE SORT
    static void mergeSort(Transaction[] arr, int left, int right) {

        if (left < right) {

            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    // Merge two sorted halves
    static void merge(Transaction[] arr,
                      int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        Transaction[] L = new Transaction[n1];
        Transaction[] R = new Transaction[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        // Choose left element first when dates are equal.
        // This preserves stability.
        while (i < n1 && j < n2) {

            if (compare(L[i], R[j]) <= 0) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    // Display transactions
    static void display(Transaction[] arr) {

        for (Transaction t : arr) {
            t.display();
        }
    }

    public static void main(String[] args) {

        Transaction[] transactions = {

                new Transaction(1001, 501, 2500, "Amazon",
                        LocalDateTime.parse("2026-11-10T10:05:00")),

                new Transaction(1002, 502, 1500, "Flipkart",
                        LocalDateTime.parse("2026-11-10T09:10:00")),

                new Transaction(1003, 503, 3000, "Swiggy",
                        LocalDateTime.parse("2026-11-10T11:30:00")),

                new Transaction(1004, 501, 5000, "Amazon",
                        LocalDateTime.parse("2026-11-10T09:10:00")),

                new Transaction(1005, 504, 800, "Myntra",
                        LocalDateTime.parse("2026-11-10T10:30:00"))
        };

        // Create separate copies
        Transaction[] insertionData = transactions.clone();
        Transaction[] mergeData = transactions.clone();

        // Insertion Sort
        long start1 = System.nanoTime();

        insertionSort(insertionData);

        long end1 = System.nanoTime();

        System.out.println("INSERTION SORT RESULT:");
        display(insertionData);

        System.out.println("Insertion Sort Time: "
                + (end1 - start1) + " ns");

        // Merge Sort
        long start2 = System.nanoTime();

        mergeSort(mergeData, 0, mergeData.length - 1);

        long end2 = System.nanoTime();

        System.out.println("\nMERGE SORT RESULT:");
        display(mergeData);

        System.out.println("Merge Sort Time: "
                + (end2 - start2) + " ns");

        System.out.println("\nBoth algorithms are stable.");
    }
}
