package Tutorial;

public abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    abstract void processPayment();
    
    public void paymentDetails() {
        System.out.println("Processing payment of $ " + amount);
    }

}
