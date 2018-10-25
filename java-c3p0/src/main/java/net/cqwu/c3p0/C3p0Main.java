package net.cqwu.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * c3p0测试
 */
public class C3p0Main {
    public static void main(String[] args) {
        Connection connection = C3p0Utils.getConnection();
          getData(connection);
       connection = C3p0Utils.getConnection();
          insert(connection);
    }

    /**
     * 获取数据
     * @param conn
     */
    public static void getData(Connection conn) {
         String sql = "select * from test";
         PreparedStatement preparedStatement = null;
        ResultSet rs = null;
         try {
             preparedStatement = conn.prepareStatement(sql);
              rs = preparedStatement.executeQuery();
                     while(rs.next()) {
                         System.out.println(rs.getString(2) + "----->" + rs.getInt(3));
                     }
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             C3p0Utils.close(conn,preparedStatement,rs);
         }

    }

    /**
     * 插入数据
     * @param conn
     */
    public static void insert(Connection conn) {
       String sql = "insert into test (id,name,age) values(?,?,?)";
       PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,100);
            preparedStatement.setString(2,"zhangpeng");
            preparedStatement.setInt(3,34);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3p0Utils.close(conn,preparedStatement,null);
        }
    }
}
