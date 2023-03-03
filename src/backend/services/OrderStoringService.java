package backend.services;

import backend.entities.Order;

import java.util.List;

public interface OrderStoringService {

    void saveOrders(List<Order> orders);

    List<Order> loadOrders();
}
