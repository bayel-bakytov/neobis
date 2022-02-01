package POJO;

public class Earnings {
    private int earningId;
    private int count;
    private Price priceId;
    private Category genreId;

    public Earnings() {}

    public Earnings(int earningId, int count, Price priceId, Category genreId) {
        this.earningId = earningId;
        this.count = count;
        this.priceId = priceId;
        this.genreId = genreId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Price getPrice() {
        return priceId;
    }

    public void setPrice(Price priceId) {
        this.priceId = priceId;
    }

    public int getEarningId() {
        return earningId;
    }

    public void setEarningId(int earningId) {
        this.earningId = earningId;
    }

    public Category getGenreId() {
        return genreId;
    }

    public void setGenreId(Category genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "Earnings{" +
                "earningId=" + earningId +
                ", count=" + count +
                ", priceId=" + priceId +
                ", genreId=" + genreId +
                '}';
    }
}
