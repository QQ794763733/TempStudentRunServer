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
            preparedStatement = connection.prepareStatement("SELECT * FROM userorder ORDER BY id DESC;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setUuid(resultSet.getString("uuid"));
                order.setRidgepole(resultSet.getInt("ridgepole"));
                order.setDorm(resultSet.getInt("dorm"));
                order.setContact(resultSet.getString("contact"));
                order.setInfo(resultSet.getString("info"));
                order.setStaff(resultSet.getString("staff"));
                order.setPhone(resultSet.getString("phone"));
                order.setFlag(resultSet.getInt("flag"));
                order.setDatetime(resultSet.getString("datetime"));
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
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return datas;
    }

    @Override
    public List<Order> selectAllTemporderByUUID(String uuid) {
        List<Order> datas = new ArrayList<>();
        Connection connection = DbcpUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM userorder WHERE uuid = ? ORDER BY id DESC;");
            preparedStatement.setString(1,uuid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setUuid(resultSet.getString("uuid"));
                order.setRidgepole(resultSet.getInt("ridgepole"));
                order.setDorm(resultSet.getInt("dorm"));
                order.setContact(resultSet.getString("contact"));
                order.setInfo(resultSet.getString("info"));
                order.setStaff(resultSet.getString("staff"));
                order.setPhone(resultSet.getString("phone"));
                order.setFlag(resultSet.getInt("flag"));
                order.setDatetime(resultSet.getString("datetime"));
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
            if(connection!=null){
                try {
                    connection.close();
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
            preparedStatement = connection.prepareStatement("SELECT * FROM userorder WHERE ridgepole = ? ORDER BY id DESC;");
            preparedStatement.setInt(1,ridgepole);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setUuid(resultSet.getString("uuid"));
                order.setRidgepole(resultSet.getInt("ridgepole"));
                order.setDorm(resultSet.getInt("dorm"));
                order.setContact(resultSet.getString("contact"));
                order.setInfo(resultSet.getString("info"));
                order.setStaff(resultSet.getString("staff"));
                order.setPhone(resultSet.getString("phone"));
                order.setFlag(resultSet.getInt("flag"));
                order.setDatetime(resultSet.getString("datetime"));
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
            if(connection!=null){
                try {
                    connection.close();
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
                order.setUuid(resultSet.getString("uuid"));
                order.setRidgepole(resultSet.getInt("ridgepole"));
                order.setDorm(resultSet.getInt("dorm"));
                order.setContact(resultSet.getString("contact"));
                order.setInfo(resultSet.getString("info"));
                order.setStaff(resultSet.getString("staff"));
                order.setPhone(resultSet.getString("phone"));
                order.setFlag(resultSet.getInt("flag"));
                order.setDatetime(resultSet.getString("datetime"));
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
            if(connection!=null){
                try {
                    connection.close();
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
            preparedStatement = connection.prepareStatement("SELECT staff FROM userorder WHERE id = ?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            String staff = null;
            while (resultSet.next()){
                staff = resultSet.getString("staff");
            }
            if(staff == null){
                preparedStatement = connection.prepareStatement("DELETE FROM userorder WHERE id = ?;");
                preparedStatement.setInt(1,id);
                row = preparedStatement.executeUpdate();
            }
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
            if(connection!=null){
                try {
                    connection.close();
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
        Integer id = 0;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO userorder(uuid,ridgepole,dorm,contact,info) VALUES(?,?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,order.getUuid());
            preparedStatement.setInt(2, order.getRidgepole());
            preparedStatement.setInt(3, order.getDorm());
            preparedStatement.setString(4,order.getContact());
            preparedStatement.setString(5, order.getInfo());
            Integer row = preparedStatement.executeUpdate();
            if(row > 0){
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                generatedKeys.next();
                id = generatedKeys.getInt(1);
            }
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
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return id;
    }

    @Override
    public Integer updateTemporderByID(Order order) {
        Connection connection = DbcpUtil.getConnection();
        PreparedStatement preparedStatement = null;
        Integer row = 0;
        String staff = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT staff FROM userorder WHERE id = ?;");
            preparedStatement.setInt(1,order.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                staff = resultSet.getString("staff");
            }
            if(staff==null){
                preparedStatement = connection.prepareStatement("UPDATE userorder SET staff=?,phone=?,flag=? WHERE id = ?;");
                preparedStatement.setString(1, order.getStaff());
                preparedStatement.setString(2, order.getPhone());
                preparedStatement.setInt(3, order.getFlag());
                preparedStatement.setInt(4, order.getId());
                row = preparedStatement.executeUpdate();
            }else{
                row = 0;
            }
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
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return row;
    }
}
