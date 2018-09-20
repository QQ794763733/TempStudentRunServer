package liar.xiaoyu.www.temp.common;

import org.apache.commons.dbcp2.BasicDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DbcpUtil {
    // BasicDataSource 也就是DBCP所使用数据源
    private static BasicDataSource basicDataSource;

    /**
     * 读取配置文件，并且初始化连接池
     */
    private static void init(){
        // 根据上面所放类路径读取配置文件
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("DBCP.properties");
        Properties properties = new Properties();
        try {
            // 加载properties文件
            properties.load(inputStream);

            // 新建一个BasicDataSource
            basicDataSource = new BasicDataSource();

            // 设置对应的参数
            basicDataSource.setUrl(properties.getProperty("db.url"));
            basicDataSource.setDriverClassName(properties.getProperty("db.driverClassName"));
            basicDataSource.setUsername(properties.getProperty("db.username"));
            basicDataSource.setPassword(properties.getProperty("db.password"));

            basicDataSource.setInitialSize(Integer.parseInt(properties.getProperty("dataSource.initialSize")));
            basicDataSource.setMaxIdle(Integer.parseInt(properties.getProperty("dataSource.maxIdle")));
            basicDataSource.setMinIdle(Integer.parseInt(properties.getProperty("dataSource.minIdle")));
            basicDataSource.setMaxWaitMillis(Integer.parseInt(properties.getProperty("dataSource.maxWait")));
            basicDataSource.setMaxTotal(Integer.parseInt(properties.getProperty("dataSource.maxActive")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得Connection
     * @return Connection
     */
    public synchronized static Connection getConnection(){
        if (basicDataSource == null){
            init();
        }
        try {
            return basicDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
