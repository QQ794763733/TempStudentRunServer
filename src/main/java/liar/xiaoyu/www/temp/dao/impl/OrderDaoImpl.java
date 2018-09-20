package liar.xiaoyu.www.temp.dao.impl;

import liar.xiaoyu.www.temp.common.DbcpUtil;
import liar.xiaoyu.www.temp.dao.OrderDao;
import liar.xiaoyu.www.temp.entity.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public List<Order> selectAllTemporder() {
        List<Order> datas = new ArrayList<>();
        Connection connection = DbcpUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM userorder;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setRidgepole(resultSet.getInt("ridgepole"));
                order.setDorm(resultSet.getInt("dorm"));
                order.setDorm(resultSet.getInt("dorm"));
                order.setInfo(resultSet.getString("info"));
                order.setStaff(resultSet.getString("staff"));
                order.setPhone(resultSet.getString("phone"));
                order.setFlag(resultSet.getInt("flag"));
                datas.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return datas;
    }

    @Override
    public List<Order> selectTemporderByRidgepole(Integer ridgepole) {
        List<Order> datas = new ArrayList<>();
        Connection connection = DbcpUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM userorder WHERE ridgepole = ?;");
            preparedStatement.setInt(1,ridgepole);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setRidgepole(resultSet.getInt("ridgepole"));
                order.setDorm(resultSet.getInt("dorm"));
                order.setDorm(resultSet.getInt("dorm"));
                order.setInfo(resultSet.getString("info"));
                order.setStaff(resultSet.getString("staff"));
                order.setPhone(resultSet.getString("phone"));
                order.setFlag(resultSet.getInt("flag"));
                datas.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return datas;
    }

    @Override
    public Order selectTemporderByID(Integer id) {
        Connection connection = DbcpUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Order order = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM userorder WHERE id = ?;");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setRidgepole(resultSet.getInt("ridgepole"));
                order.setDorm(resultSet.getInt("dorm"));
                order.setDorm(resultSet.getInt("dorm"));
                order.setInfo(resultSet.getString("info"));
                order.setStaff(resultSet.getString("staff"));
                order.setPhone(resultSet.getString("phone"));
                order.setFlag(resultSet.getInt("flag"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return order;
    }

    @Override
    public Integer deleteTemporderByID(Integer id) {
        Connection connection = DbcpUtil.getConnection();
        PreparedStatement preparedStatement = null;
        Integer row = 0;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM userorder WHERE id = ?;");
            preparedStatement.setInt(1,id);
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return row;
    }

    @Override
    public Integer insertTemporder(Order order) {
        Connection connection = DbcpUtil.getConnection();
        PreparedStatement preparedStatement = null;
        Integer row = 0;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO userorder(ridgepole,dorm,info,staff,phone,flag) VALUES(?,?,?,?,?,?);");
            preparedStatement.setInt(1, order.getRidgepole());
            preparedStatement.setInt(2, order.getDorm());
            preparedStatement.setString(3, order.getInfo());
            preparedStatement.setString(4, order.getStaff());
            preparedStatement.setString(5, order.getPhone());
            preparedStatement.setInt(6, order.getFlag());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return row;
    }

    @Override
    public Integer updateTemporderByID(Order order) {
        Connection connection = DbcpUtil.getConnection();
        PreparedStatement preparedStatement = null;
        Integer row = 0;
        try {
            preparedStatement = connection.prepareStatement("UPDATE userorder SET ridgepole=?,dorm=?,info=?,staff=?,phone=?,flag=? WHERE id = ?;");
            preparedStatement.setInt(1, order.getRidgepole());
            preparedStatement.setInt(2, order.getDorm());
            preparedStatement.setString(3, order.getInfo());
            preparedStatement.setString(4, order.getStaff());
            preparedStatement.setString(5, order.getPhone());
            preparedStatement.setInt(6, order.getFlag());
            preparedStatement.setInt(7, order.getId());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return row;
    }
}
