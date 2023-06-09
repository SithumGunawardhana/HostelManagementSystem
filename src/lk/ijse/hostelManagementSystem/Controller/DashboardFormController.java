package lk.ijse.hostelManagementSystem.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.ijse.hostelManagementSystem.util.Navigation;
import lk.ijse.hostelManagementSystem.util.Routes;

import java.io.IOException;

public class DashboardFormController {



    public JFXButton btnLogout;
    public JFXButton btnDashBoard;
    public JFXButton btnManageStudent;
    public JFXButton btnManageRoom;
    public JFXButton btnReserveRoom;
    public Pane contex;
    public AnchorPane pane;

    public void btnDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBORD,pane);
    }

    public void btnManageStudentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/StudentForm");

    }

    public void btnManageRoomsOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/RoomForm");
    }

    public void btnReserveRoomOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/ReservetionForm");
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }


    public void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        contex.getChildren().clear();
        contex.getChildren().add(node);
    }
}
