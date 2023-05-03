package lk.ijse.hostelManagementSystem.dao.custom.impl;

import com.sun.xml.bind.v2.model.core.ID;
import lk.ijse.hostelManagementSystem.Entity.Reservation;
import lk.ijse.hostelManagementSystem.Entity.Room;
import lk.ijse.hostelManagementSystem.dao.custom.ReservationDAO;
import lk.ijse.hostelManagementSystem.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public void save(Reservation entity) {

    }

    @Override
    public boolean update(Reservation entity) {

        return false;
    }

    @Override
    public Reservation serch(ID id) {
        return null;
    }

    @Override
    public void delete(ID id) {

    }

    @Override
    public void getStudentId(Reservation enty) {

    }

    @Override
    public void getRoomId(Reservation enty) {

    }

    @Override
    public String getResevetionId() {
        return null;
    }
    @Override
    public Reservation get(String id) {
        return null;

    }


}
