package liar.xiaoyu.www.temp.service;

import liar.xiaoyu.www.temp.entity.Order;

import java.util.List;

public interface OrderService {
    Integer addOrder(Order order);

    List<Order> getAllOrder();

    Boolean acceptOrder(Order order);

    List<Order> getOrderByRidgepole(Integer Ridgepole);

    Boolean cancelOrder(Integer id);
}
