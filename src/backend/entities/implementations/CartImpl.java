package entities.implementations;

import entities.Cart;
import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class CartImpl implements Cart {

    private List<Product> products;

    public CartImpl() {
        this.products = new ArrayList<>(10);
    }

    @Override
    public boolean isEmpty() {
        return products.isEmpty();
    }

    @Override
    public void addProduct(Product product) {
        if(product==null)return;
        products.add(product);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void clear() {
        products.clear();
    }
}
