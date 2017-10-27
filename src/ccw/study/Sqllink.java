package ccw.study;

import java.sql.*;

public class Sqllink {
    private String driverName="com.mysql.jdbc.Driver";
    private String userName="root";
    private String password="123456";
    private String dbName="stu";
    private String tableName;
    private String url;

    private ResultSet rs=null;
    private Statement stmt=null;
    private Connection conn=null;

    Sqllink(String table){
        tableName=table;
        url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+password;
    }

    public boolean check(String un,String... pw){
        try{
            Class.forName(driverName).newInstance();
            conn= DriverManager.getConnection(url);
            stmt=conn.createStatement();
            String sql;
            if(pw!=null){
                if(pw.length==0)
                sql="SELECT * FROM "+tableName+" where username='"+un+"'";
            else
                sql="SELECT * FROM "+tableName+" where username='"+un+"'and password='"+pw[0]+"'";
            rs=stmt.executeQuery(sql);
            }
            if(rs.next()){
                close();
                return true;
            }
            else
            {
                close();
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        close();
        return false;
    }

    public void close(){
        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getRs(String sql){
        try {
            Class.forName(driverName).newInstance();
            conn = DriverManager.getConnection(url);
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public boolean Modify(String sql){
        int a=0;
        try{
            Class.forName(driverName).newInstance();
            conn = DriverManager.getConnection(url);
            Statement statement=conn.createStatement();
            a=statement.executeUpdate(sql);
        }
        catch(Exception e){
            close();
            System.out.println(e.toString());
            return false;
        }
        if(a>0)
            return true;
        else
            return false;
    }
}
