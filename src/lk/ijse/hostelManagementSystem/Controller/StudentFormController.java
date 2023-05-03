package lk.ijse.hostelManagementSystem.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.StudentBO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;
import lk.ijse.hostelManagementSystem.util.Navigation;
import lk.ijse.hostelManagementSystem.util.Routes;
import lk.ijse.hostelManagementSystem.view.dtm.StudentDTM;


public class StudentFormController {

    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtStudentNo;
    public JFXDatePicker cmbBirthDay;
    public JFXComboBox cmbGender;
    public JFXButton btnAddStudent;
    public JFXButton btnUpdateStudent;
    public JFXButton btnSerchStudent;
    public JFXButton btnDeleteStudent;
    public TableColumn colStuduentId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDOB;
    public TableColumn colGender;
    public TableView tblStudent;
    public AnchorPane pane;

    StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENT);

     public  void btnAddStudentNoOnAction(ActionEvent actionEvent) {
         try {


             studentBO.saveStudent(new StudentDTO(txtStudentId.getText(), txtStudentName.getText(), txtStudentAddress.getText(), txtStudentNo.getText(), cmbBirthDay.getValue(), (String) cmbGender.getValue()));
             new Alert(Alert.AlertType.CONFIRMATION,"saved").show();
             clearText();
             Navigation.navigate(Routes.STUDENT,pane);
         }catch (Exception e){
             new Alert(Alert.AlertType.ERROR,"not save").show();
         }

    }

    public void btnUpdateStudentOnAction(ActionEvent actionEvent) {
         try{
         studentBO.updateStudent(new StudentDTO(txtStudentId.getText(), txtStudentName.getText(), txtStudentAddress.getText(), txtStudentNo.getText(), cmbBirthDay.getValue(), (String) cmbGender.getValue()));
         clearText();
         new Alert(Alert.AlertType.CONFIRMATION,"Updated!").show();
         Navigation.navigate(Routes.STUDENT,pane);
    }catch (Exception e) {
             new Alert(Alert.AlertType.ERROR,"not Update!").show();
         }
         }

    public void btnSearchStudentOnAction(ActionEvent actionEvent) {
         try {


             StudentDTO student = studentBO.searcStudent(txtStudentId.getText());

             txtStudentId.setText(student.getStudentId());
             txtStudentName.setText(student.getName());
             txtStudentAddress.setText(student.getAddress());
             txtStudentNo.setText(student.getContactNo());
             cmbBirthDay.setValue(student.getDob());
             cmbGender.setValue(student.getGender());
         }catch (Exception e){
             new Alert(Alert.AlertType.ERROR,"not have this search id").show();
         }
    }

    public void btnDeleteStudentOnAction(ActionEvent actionEvent) {
         try {
             studentBO.deleteStudent(txtStudentId.getText());
             clearText();
             new Alert(Alert.AlertType.CONFIRMATION,"Deleted!").show();
             Navigation.navigate(Routes.STUDENT,pane);
         }catch (Exception e) {
             new Alert(Alert.AlertType.ERROR,"Not delete!").show();


         }
    }

    public void cmbGenderOnAction() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Mail" , "Femail","other");
        cmbGender.setItems(list);
    }



    public void initialize() {
        cmbGenderOnAction();
        selectAllStudents();
        colStuduentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

    }

    private void selectAllStudents(){
        ObservableList<StudentDTM> students = studentBO.getStudents();
        tblStudent.setItems(students);
    }


    public void validateFieldsOnKeyRelease(KeyEvent keyEvent) {
    }

    public void clearText(){
        txtStudentId.setText("");
        txtStudentName.setText("");
        txtStudentAddress.setText("");
        txtStudentNo.setText("");
    }

    public void txtStudentIDOnAction(ActionEvent actionEvent) {
        try {
            StudentDTO student = studentBO.searcStudent(txtStudentId.getText());

            txtStudentId.setText(student.getStudentId());
            txtStudentName.setText(student.getName());
            txtStudentAddress.setText(student.getAddress());
            txtStudentNo.setText(student.getContactNo());
            cmbBirthDay.setValue(student.getDob());
            cmbGender.setValue(student.getGender());

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Not have this enter id").show();
        }
    }
}