package lk.ijse.hostelManagementSystem.view.dtm;

import lk.ijse.hostelManagementSystem.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReseveationDTM {

    private String resId;
    private LocalDate date;
    private Student student;
    public String status;
}
