package backend.entities.implementations;

import backend.entities.Order;
import backend.entities.Product;

import java.util.Arrays;

public class DefaultOrder implements Order {
    private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;

    private String creditCardNumber;
    private Product[] products;
    private int customerId;

    @Override
    public boolean isCreditCardNumberValid(String creditCardNumber) {
        try {
            Integer.parseInt(creditCardNumber);
        } catch (NumberFormatException e) {
            return false;
        }
        return creditCardNumber.length() == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER ? true:false;
    }

    @Override
    public void setCreditCardNumber(String creditCardNumber) {
        if(isCreditCardNumberValid(creditCardNumber)){
            this.creditCardNumber = creditCardNumber;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void setProducts(Product[] products) {
        this.products = products;
    }

    @Override
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    @Override
    public int getCustomerId() {
        return this.customerId;
    }

    @Override
    public String toString() {
        return "DefaultOrder{" +
                "creditCardNumber='" + creditCardNumber + '\'' +
                ", products=" + Arrays.toString(products) +
                ", customerId=" + customerId +
                '}';
    }
}
