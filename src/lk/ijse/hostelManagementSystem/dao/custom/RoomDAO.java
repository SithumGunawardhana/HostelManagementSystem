package lk.ijse.hostelManagementSystem.dao.custom;

import lk.ijse.hostelManagementSystem.Entity.Room;
import lk.ijse.hostelManagementSystem.dao.CrudDAO;

import java.util.List;

public interface RoomDAO extends CrudDAO<Room , String> {

     List<Room> getAll();
}
