package liar.xiaoyu.www.temp.dao.impl;

import liar.xiaoyu.www.temp.common.DbcpUtil;
import liar.xiaoyu.www.temp.dao.MiyaoDao;
import liar.xiaoyu.www.temp.entity.Miyao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MiyaoImpl implements MiyaoDao {
    @Override
    public Integer insertMiyao(String value) {
        Connection connection = DbcpUtil.getConnection();
        PreparedStatement preparedStatement = null;
        Integer row = 0;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO miyao(value) VALUES(?);");
            preparedStatement.setString(1,value);
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
    public Integer deleteMiyaoByID(Integer id) {
        Connection connection = DbcpUtil.getConnection();
        PreparedStatement preparedStatement = null;
        Integer row = 0;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM miyao WHERE id = ?");
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
    public Integer updateMiyao(String value) {
        Connection connection = DbcpUtil.getConnection();
        PreparedStatement preparedStatement = null;
        Integer row = 0;
        try {
            preparedStatement = connection.prepareStatement("UPDATE miyao SET miyao=? WHERE id = 1");
            preparedStatement.setString(1,value);
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
    public Miyao selectMiyaoByID(Integer id) {
        Connection connection = DbcpUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Miyao miyao = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM miyao WHERE id = ?;");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                miyao = new Miyao();
                miyao.setId(resultSet.getInt("id"));
                miyao.setValue(resultSet.getString("value"));
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
        return miyao;
    }

    @Override
    public List<Miyao> selectAllMiyao() {
        Connection connection = DbcpUtil.getConnection();
        List<Miyao> miyaos = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM miyao;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Miyao miyao = new Miyao();
                miyao.setId(resultSet.getInt("id"));
                miyao.setValue(resultSet.getString("value"));
                miyaos.add(miyao);
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
        return miyaos;
    }

    @Override
    public String selectMiyaoValue() {
        Connection connection = DbcpUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String value = "";
        try {
            preparedStatement = connection.prepareStatement("SELECT value FROM miyao;");
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            value = resultSet.getString("value");
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
        return value;
    }
}
