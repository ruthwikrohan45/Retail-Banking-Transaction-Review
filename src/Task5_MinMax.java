
public class Task5_MinMax {

    // Store minimum and maximum values
    static class Result {
        double min;
        double max;

        Result(double min, double max) {
            this.min = min;
            this.max = max;
        }
    }

    // BRUTE FORCE APPROACH
    static Result bruteForce(double[] arr) {

        double min = arr[0];
        double max = arr[0];

        // Check every transaction amount
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] < min) {
                min = arr[i];
            }

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return new Result(min, max);
    }

    // DIVIDE AND CONQUER APPROACH
    static Result divideAndConquer(
            double[] arr, int left, int right) {

        // Base case: only one element
        if (left == right) {
            return new Result(arr[left], arr[left]);
        }

        // Base case: two elements
        if (right == left + 1) {

            if (arr[left] < arr[right]) {
                return new Result(arr[left], arr[right]);
            } else {
                return new Result(arr[right], arr[left]);
            }
        }

        // Divide the array into two halves
        int mid = left + (right - left) / 2;

        Result first = divideAndConquer(arr, left, mid);

        Result second = divideAndConquer(arr, mid + 1, right);

        // Combine the results
        double min = Math.min(first.min, second.min);

        double max = Math.max(first.max, second.max);

        return new Result(min, max);
    }

    public static void main(String[] args) {

        // Sample transaction amounts
        double[] amounts = {
                2500, 1500, 3000, 5000, 800,
                4500, 1200, 6000, 900, 2000
        };

        System.out.println("TRANSACTION AMOUNTS:");

        for (double amount : amounts) {
            System.out.print(amount + " ");
        }

        // Brute force
        long start1 = System.nanoTime();

        Result brute = bruteForce(amounts);

        long end1 = System.nanoTime();

        System.out.println("\n\nBRUTE FORCE RESULT:");

        System.out.println("Minimum amount: Rs." + brute.min);

        System.out.println("Maximum amount: Rs." + brute.max);

        System.out.println("Execution time: "
                + (end1 - start1) + " ns");

        // Divide and conquer
        long start2 = System.nanoTime();

        Result divide = divideAndConquer(
                amounts, 0, amounts.length - 1
        );

        long end2 = System.nanoTime();

        System.out.println("\nDIVIDE AND CONQUER RESULT:");

        System.out.println("Minimum amount: Rs." + divide.min);

        System.out.println("Maximum amount: Rs." + divide.max);

        System.out.println("Execution time: "
                + (end2 - start2) + " ns");
    }
}
