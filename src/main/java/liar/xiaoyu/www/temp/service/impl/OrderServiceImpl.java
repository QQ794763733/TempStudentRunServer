package liar.xiaoyu.www.temp.service.impl;

import liar.xiaoyu.www.temp.dao.OrderDao;
import liar.xiaoyu.www.temp.dao.impl.OrderDaoImpl;
import liar.xiaoyu.www.temp.entity.Order;
import liar.xiaoyu.www.temp.service.OrderService;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public Integer addOrder(Order order) {
        return orderDao.insertTemporder(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderDao.selectAllTemporder();
    }

    @Override
    public Boolean acceptOrder(Order order) {
        Boolean flag = false;
        Integer integer = orderDao.updateTemporderByID(order);
        if(integer > 0){
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Order> getOrderByRidgepole(Integer Ridgepole) {
        return orderDao.selectTemporderByRidgepole(Ridgepole);
    }

    @Override
    public Boolean cancelOrder(Integer id) {
        Boolean flag = false;
        Integer integer = orderDao.deleteTemporderByID(id);
        if(integer > 0){
            flag = true;
        }
        return flag;
    }
}