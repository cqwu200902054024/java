package net.cqwu.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 获取链接，释放链接
 */
public class C3p0Utils {
    //通过配置文件标示创建相应连接池
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

    /**
     * //从连接池中获取一个链接
     * @return Connection
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭资源
     * @param conn
     * @param pst
     * @param rs
     */
    public static void close(Connection conn, PreparedStatement pst, ResultSet rs) {
         if(rs != null) {
             try{
                 rs.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }

         if(pst != null) {
             try {
                 pst.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }

         if(conn != null) {
             try {
                conn.close();
                 } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
    }
}
