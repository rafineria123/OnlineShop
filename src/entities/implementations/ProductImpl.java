package entities.implementations;

import entities.Product;

public class ProductImpl implements Product {
    private int id;
    private String name;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
