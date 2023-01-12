package backend.entities;

import java.util.List;

public interface Cart {

    boolean isEmpty();

    void addProduct(Product product);

    List<Product> getProducts();

    void clear();

}

