package backend.entities.implementations;

import backend.entities.Product;

public class DefaultProduct implements Product {
    private int id;
    private String productName;
    private String categoryName;
    private double price;

    public DefaultProduct() {
    }

    public DefaultProduct(int id, String productName, String categoryName, double price) {
        this.id = id;
        this.productName = productName;
        this.categoryName = categoryName;
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }


    public String getProductName() {
        return productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Double getPrice() {
        return price;
    }
}
