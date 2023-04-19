package lk.ijse.hostelManagementSystem.dao.custom;
import lk.ijse.hostelManagementSystem.dao.SuperDAO;

import java.util.List;

public interface QueryDAO extends SuperDAO {

    List<Object[]> getPaymentStutas();

}
