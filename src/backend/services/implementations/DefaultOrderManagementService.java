package backend.services.implementations;

import backend.entities.Order;
import backend.services.OrderManagementService;

import java.util.Arrays;
import java.util.Objects;

public class DefaultOrderManagementService implements OrderManagementService {

    private static final int DEFAULT_ORDERS_CAPACITY = 10;

    private static DefaultOrderManagementService instance;

    private Order[] orders;

    private int lastIndex;

    {
        initOrderManagementService();
    }


    public static OrderManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultOrderManagementService();
        }
        return instance;
    }

    @Override
    public void addOrder(Order order) {
        if (order == null) {
            return;
        }
        if (orders.length <= lastIndex) {
            orders = Arrays.copyOf(orders, orders.length << 1);
        }
        orders[lastIndex++] = order;
    }

    @Override
    public Order[] getOrdersByUserId(int userId) {
        Order[] result = Arrays.stream(orders).filter(order -> order.getCustomerId() == userId).toArray(Order[]::new);
        return result.length > 0 ? result : null;
    }

    @Override
    public Order[] getOrders() {
        return Arrays.stream(orders).filter(Objects::nonNull).toArray(Order[]::new);
    }

    void clearServiceState() {
        initOrderManagementService();
    }

    private  void initOrderManagementService(){
        this.orders = new Order[DEFAULT_ORDERS_CAPACITY];
        this.lastIndex = 0;
    }


}