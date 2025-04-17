package Tutorial;

public class Main {
    public static void main(String[] args) {
        Payment creditCard = new CreditCardPayment(100.0, "1234-5678-9012-3456");
        Payment bankTransfer = new BankTransferPayment(300.0, "349857623845");

        creditCard.paymentDetails();
        creditCard.processPayment();

        bankTransfer.paymentDetails();
        bankTransfer.processPayment();
    }

}
