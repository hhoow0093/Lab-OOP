package Tugas;

public abstract class Payment {
    protected boolean isPaidOff;
    protected Item item;

    public abstract int pay();

    public Payment() {
        this.isPaidOff = false;
        this.item = null;
    }

    public Payment(Item item) {
        this.isPaidOff = false;
        this.item = item;
    }

    public boolean isPaidOff() {
        return this.isPaidOff;
    }

    public Item getItem() {
        return this.item;
    }

    public String getItemName() {
        return this.item.getname();
    }

    public String getStatus() {
        if (isPaidOff) {
            return "FINISHED";
        } else {
            return "ON PROGRESS";
        }
    }

    public int getRemainingAmount() {
        if (isPaidOff) {
            return 0;
        } else {
            return this.item.getPrice();
        }
    }


}
