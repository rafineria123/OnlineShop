package backend.entities.implementations;

import backend.entities.Cart;
import backend.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class DefaultCart implements Cart {

    private List<Product> products;

    public DefaultCart() {
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
