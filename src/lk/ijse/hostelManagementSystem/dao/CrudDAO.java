package lk.ijse.hostelManagementSystem.dao;
public interface CrudDAO <T ,ID> extends SuperDAO {

    void  save(T entity);

    boolean update(T entity);

    T serch(ID id);

    void delete(ID id);

}
