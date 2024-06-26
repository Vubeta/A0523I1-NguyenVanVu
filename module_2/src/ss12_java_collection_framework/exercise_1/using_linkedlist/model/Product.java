package ss12_java_collection_framework.exercise_1.using_linkedlist.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String detailProduct;

    public Product() {
    }

    public Product(int id, String name, double price, String detailProduct) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detailProduct = detailProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetailProduct() {
        return detailProduct;
    }

    public void setDetailProduct(String detailProduct) {
        this.detailProduct = detailProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + String.format("%.0f",price) +
                ", detailProduct='" + detailProduct + '\'' +
                '}';
    }
}
