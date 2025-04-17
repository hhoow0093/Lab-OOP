package Tugas;

public class Item {
    private String name;
    private String type;
    private int Price;

    public Item(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.Price = price;
    }

    public String getname() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return this.Price;
    }

    public void setPrice(int price) {
        this.Price = price;
    }
    


}
