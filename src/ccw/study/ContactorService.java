package ccw.study;

import ccw.study.*;

import java.sql.SQLException;
import java.util.List;

public class ContactorService {
    ContactorDao dao = new ContactorDao();

    public void add(Contactor c,String userId){
        try {
            dao.insert(c,userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id){
        try {
            dao.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Contactor> load(String userId){
        try {
            return dao.findAll(userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Contactor loadById(int id){
        try {
            return dao.findByCid(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void edit(Contactor c,String userId){
        try {
            dao.update(c,userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
