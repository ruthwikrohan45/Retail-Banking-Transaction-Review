
import java.time.LocalDateTime;

public class Transaction {

    int transactionId;
    int accountId;
    double amount;
    String merchant;
    LocalDateTime postingDate;

    // Constructor to initialize transaction details
    public Transaction(int transactionId, int accountId,
                       double amount, String merchant,
                       LocalDateTime postingDate) {

        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
        this.merchant = merchant;
        this.postingDate = postingDate;
    }

    // Display transaction details
    public void display() {
        System.out.println(
                transactionId + " | " +
                        accountId + " | " +
                        amount + " | " +
                        merchant + " | " +
                        postingDate
        );
    }
}
