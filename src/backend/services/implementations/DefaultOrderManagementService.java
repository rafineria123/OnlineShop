package backend.services.implementations;

import backend.entities.Order;
import backend.services.OrderManagementService;
import backend.services.OrderStoringService;

import java.util.Arrays;
import java.util.Objects;

public class DefaultOrderManagementService implements OrderManagementService {

    private static final int DEFAULT_ORDERS_CAPACITY = 10;

    private static DefaultOrderManagementService instance;
    private OrderStoringService orderStoringService;

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
        Order[] result = Arrays.stream(orders).filter(Objects::nonNull).filter(order -> order.getCustomerId() == userId).toArray(Order[]::new);
        return result.length > 0 ? result : null;
    }

    @Override
    public Order[] getOrders() {
        if (orders == null || orders.length == 0) {
            orders = orderStoringService.loadOrders().toArray(Order[]::new);
        }
        return this.orders;
    }

    void clearServiceState() {
        initOrderManagementService();
    }

    private void initOrderManagementService(){
        this.orderStoringService = DefaultOrderStoringService.getInstance();
        this.lastIndex = 0;
        orders = new Order[DEFAULT_ORDERS_CAPACITY];
        orderStoringService.loadOrders().forEach(order -> addOrder(order));
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                orderStoringService.saveOrders(Arrays.stream(getOrders()).toList());
            }
        }, "Shutdown-thread"));

    }




}