package ccw.study;

import ccw.study.Contactor;
import ccw.study.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ContactorDao {
    private  QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
    public void insert(Contactor c,String userid)throws SQLException {
        String sql = "insert into contact(name,tel,address,self) values(?,?,?,?)";
        qr.update(sql, c.getName(),c.getTel(),c.getAddress(),userid);
    }

    public void delete(int id) throws SQLException{
        String sql = "delete from contact where id=?";
        qr.update(sql, id);
    }

    public void update(Contactor c,String userId) throws SQLException{
        String sql = "update contact set name=?,tel=?,address=?,self=? where id=?";
        qr.update(sql, c.getName(),c.getTel(),c.getAddress(),userId,c.getId());
    }

    public List<Contactor> findAll(String userId) throws SQLException{
        String sql = "select * from contact where self = ?";
        List<Contactor> list = qr.query(sql, new BeanListHandler<Contactor>(Contactor.class),userId);
        return list;
    }

    public Contactor findByCid(int id) throws SQLException{
        String sql = "select * from contact where id=?";
        Contactor c = qr.query(sql, new BeanHandler<Contactor>(Contactor.class), id);
        return c;
    }
}
