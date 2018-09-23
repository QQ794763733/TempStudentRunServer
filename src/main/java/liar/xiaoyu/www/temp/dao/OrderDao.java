package liar.xiaoyu.www.temp.dao;

import liar.xiaoyu.www.temp.entity.Order;
import java.util.List;

public interface OrderDao {
    List<Order> selectAllTemporder();

    List<Order> selectAllTemporderByUUID(String uuid);

    List<Order> selectTemporderByRidgepole(Integer ridgepole);

    Order selectTemporderByID(Integer id);

    Integer deleteTemporderByID(Integer id);

    Integer insertTemporder(Order order);

    Integer updateTemporderByID(Order order);
}
