package Tugas;

public class Cash extends Payment {
    public Cash(Item item) {
        super(item);
    }

    public int pay() {
        if (isPaidOff) {
            return 0;
        }
        isPaidOff = true;
        return this.item.getPrice();
    }

}
