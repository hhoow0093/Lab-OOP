package Tutorial;

public class BankTransferPayment extends Payment {
    private String bankAccount;

    public BankTransferPayment(double amount, String bankAccount) {
        super(amount);
        this.bankAccount = bankAccount;
    }
    
    @Override
    void processPayment() {
        System.out.println("Processing Transfer payment of $" + amount + " for bank account " + bankAccount);
    }

}
