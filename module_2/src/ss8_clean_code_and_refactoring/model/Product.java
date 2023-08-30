package ss8_clean_code_and_refactoring.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String productDetail;

    public Product() {
    }

    public Product(int id, String name, double price, String productDetail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productDetail = productDetail;
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

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productDetail='" + productDetail + '\'' +
                '}';
    }
}
