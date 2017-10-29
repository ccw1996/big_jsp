package ccw.study;

import org.apache.commons.dbutils.ResultSetHandler;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Logger;

public class JdbcUtils {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/stu?useUnicode=true&characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "123456";
    static {
        try {
            // 加载数据库驱动
            Class.forName(driver);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                // 关闭存储查询结果的ResultSet对象
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (st != null) {
            try {
                // 关闭负责执行SQL命令的Statement对象
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                // 关闭Connection数据库连接对象
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void update(String sql, Object params[]) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            st = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                st.setObject(i + 1, params[i]);
            }
            st.executeUpdate();

        } finally {
            release(conn, st, rs);
        }
    }

    public static Object query(String sql, Object params[], ResultSetHandler rsh) throws SQLException {

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            st = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                st.setObject(i + 1, params[i]);
            }
            rs = st.executeQuery();
            return rsh.handle(rs);

        } finally {
            release(conn, st, rs);
        }
    }

    public static DataSource getDataSource(){
        return new DataSource() {


            @Override
            public Connection getConnection(String username, String password) throws SQLException {

                return null;
            }

            @Override
            public Connection getConnection() throws SQLException {

                return JdbcUtils.getConnection();
            }

            @Override
            public PrintWriter getLogWriter() throws SQLException {

                return null;
            }

            @Override
            public int getLoginTimeout() throws SQLException {

                return 0;
            }

            @Override
            public Logger getParentLogger() throws SQLFeatureNotSupportedException {

                return null;
            }

            @Override
            public void setLogWriter(PrintWriter out) throws SQLException {


            }

            @Override
            public void setLoginTimeout(int seconds) throws SQLException {


            }

            @Override
            public boolean isWrapperFor(Class<?> iface) throws SQLException {

                return false;
            }

            @Override
            public <T> T unwrap(Class<T> iface) throws SQLException {

                return null;
            }
        };
    }
}
