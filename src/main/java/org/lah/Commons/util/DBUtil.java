package org.lah.Commons.util;

import java.sql.*;

/**
 * author : 动力节点
 * 2019/3/14 0014
 */
public class DBUtil {

    private static String className="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://120.24.43.51:3306/sedb";
    private static String username="SEuser";
    private static String password="CAUSEuser";
    private static  Connection conn=null;
    private static  PreparedStatement ps=null;
    static{
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){

        try {
            conn= DriverManager.getConnection(url, username,password);
            //conn.setAutoCommit(false);//设置事务为手动提交
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static PreparedStatement  createStatement(String sql){
                     getConn();
                    try {
                        ps= conn.prepareStatement(sql);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                    return ps;
    }

   public static void close(ResultSet rs){
       try {
           if(rs!=null){
               rs.close();
           }
           if(ps!=null){
               ps.close();
           }
           if(conn!=null){
               conn.close();
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

   }

    public static void close( PreparedStatement ps,Connection conn){
       close(null, ps, conn);
    }

    public static void close(ResultSet rs, PreparedStatement ps,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
