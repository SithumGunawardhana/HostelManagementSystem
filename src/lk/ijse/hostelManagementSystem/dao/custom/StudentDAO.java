package lk.ijse.hostelManagementSystem.dao.custom;

import lk.ijse.hostelManagementSystem.Entity.Student;
import lk.ijse.hostelManagementSystem.dao.CrudDAO;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student , String> {

     List<Student> getAll();
}
