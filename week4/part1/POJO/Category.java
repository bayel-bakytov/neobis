package POJO;

public class Category {
    private int genreId;
    private String name;
    private String description;

    public Category() {}

    public Category(int genreId, String name, String description) {
        this.genreId = genreId;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return genreId;
    }

    public void setId(int categoryId) {
        this.genreId = genreId;
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

    @Override
    public String toString() {
        return "Category{" +
                "genreId=" + genreId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
