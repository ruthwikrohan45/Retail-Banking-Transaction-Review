
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Task3_DuplicateDetection {

    public static void main(String[] args) {

        // Sample transactions
        Transaction[] transactions = {
                new Transaction(1001, 501, 2500, "Amazon",
                        java.time.LocalDateTime.parse("2026-11-10T10:05:00")),

                new Transaction(1002, 502, 1500, "Flipkart",
                        java.time.LocalDateTime.parse("2026-11-10T09:10:00")),

                new Transaction(1003, 503, 3000, "Swiggy",
                        java.time.LocalDateTime.parse("2026-11-10T11:30:00")),

                new Transaction(1004, 501, 2500, "Amazon",
                        java.time.LocalDateTime.parse("2026-11-10T10:05:30")),

                new Transaction(1005, 504, 800, "Myntra",
                        java.time.LocalDateTime.parse("2026-11-10T10:30:00"))
        };

        // HashMap stores previously seen transactions
        Map<String, Transaction> seen = new HashMap<>();

        System.out.println("DUPLICATE TRANSACTION REPORT");

        for (Transaction current : transactions) {

            // Create a key using account, amount and merchant
            String key = current.accountId + "|" +
                    current.amount + "|" +
                    current.merchant;

            if (seen.containsKey(key)) {

                Transaction previous = seen.get(key);

                // Calculate difference between timestamps
                long seconds = Math.abs(
                        Duration.between(
                                previous.postingDate,
                                current.postingDate
                        ).getSeconds()
                );

                // Check whether difference is within 60 seconds
                if (seconds <= 60) {

                    System.out.println("Duplicate detected!");

                    System.out.println(
                            "Transaction IDs: " +
                                    previous.transactionId + " and " +
                                    current.transactionId
                    );

                    System.out.println(
                            "Time difference: " + seconds + " seconds"
                    );

                    System.out.println("----------------------");
                }
            }

            // Store the latest transaction
            if (!seen.containsKey(key) ||
                    current.postingDate.isAfter(
                            seen.get(key).postingDate)) {

                seen.put(key, current);
            }
        }
    }
}
