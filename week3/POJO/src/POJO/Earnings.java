package POJO;

public class Earnings {
    private int count;
    private double price;

    public Earnings() {}

    public Earnings(int count, double price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Earnings{" +
                "count=" + count +
                ", price=" + price +
                '}';
    }
}
