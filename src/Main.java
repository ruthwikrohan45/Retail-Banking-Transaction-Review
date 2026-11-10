
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Store all transactions
        ArrayList<Transaction> transactions = new ArrayList<>();

        // Read the CSV file
        try (BufferedReader br = new BufferedReader(
                new FileReader("Data/transactions.csv"))) {

            String line;

            // Read each transaction
            while ((line = br.readLine()) != null) {

                // Skip empty lines and column headings
                if (line.isBlank() || line.startsWith("transactionId")) {
                    continue;
                }

                String[] data = line.split(",");

                int transactionId = Integer.parseInt(data[0]);
                int accountId = Integer.parseInt(data[1]);
                double amount = Double.parseDouble(data[2]);
                String merchant = data[3];
                LocalDateTime postingDate =
                        LocalDateTime.parse(data[4]);

                // Create transaction object
                Transaction t = new Transaction(
                        transactionId,
                        accountId,
                        amount,
                        merchant,
                        postingDate
                );

                transactions.add(t);
            }

            System.out.println("Transactions loaded successfully!");

            System.out.println("Total transactions: "
                    + transactions.size());

            // Display all transactions
            for (Transaction t : transactions) {
                t.display();
            }

        } catch (Exception e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }
    }
}
