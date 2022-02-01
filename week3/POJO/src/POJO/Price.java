package POJO;

public class Price {
    private int priceId;
    private double priceSale;

    public Price(int priceId, double priceSale) {
        this.priceId = priceId;
        this.priceSale = priceSale;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public double getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(double priceSale) {
        this.priceSale = priceSale;
    }

    @Override
    public String toString() {
        return "Price{" +
                "priceId=" + priceId +
                ", priceSale=" + priceSale +
                '}';
    }
}
