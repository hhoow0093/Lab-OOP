package Tugas;

public class Credit extends Payment {
    private int installment;
    private int maxInstallmentAmount;

    public Credit(Item item, int maxInstallmentAmount) {
        super(item);
        this.installment = 0;
        this.maxInstallmentAmount = maxInstallmentAmount;
    }
    
    public int getMaxInstallmentAmount() {
        return this.maxInstallmentAmount;
    }

    public int getInstallmentAmount() {
        return this.item.getPrice() / this.maxInstallmentAmount;
    }

    @Override
    public int pay() {
        int installmentAmount = this.item.getPrice() / this.maxInstallmentAmount;
        this.installment++;

        if (this.installment >= this.maxInstallmentAmount) {
            this.isPaidOff = true;
        }

        return installmentAmount;
    }
    
    @Override
    public int getRemainingAmount() {
        if (isPaidOff) {
            return 0;
        } else {
            int installmentAmount = this.item.getPrice() / this.maxInstallmentAmount;
            return this.item.getPrice() - (installmentAmount * this.installment);
        }
    }
}