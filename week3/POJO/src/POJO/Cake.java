package POJO;

import java.util.Objects;

public class Cake {
    private int id;
    private double price;
    private String name;
    private String description;
    private String imageUrl;

    public Cake() {}

    public Cake(int id, double price, String name, String description, String imageUrl) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cake cake = (Cake) o;
        return id == cake.id && Double.compare(cake.price, price) == 0 && name.equals(cake.name) && Objects.equals(description, cake.description) && Objects.equals(imageUrl, cake.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, name, description, imageUrl);
    }

    @Override
    public String toString() {
        return "Cake{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
