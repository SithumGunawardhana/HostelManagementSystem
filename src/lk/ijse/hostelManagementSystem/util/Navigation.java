package lk.ijse.hostelManagementSystem.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {

    public static AnchorPane pane;
    public static void navigate(Routes routes , AnchorPane pane) throws IOException {

        Navigation.pane=pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();


        switch (routes){
            case LOGIN:
                window.setTitle("Login Form");
                initUI("LoginForm.fxml");
                break;

            case DASHBORD:
                window.setTitle("Dashboard Form");
                initUI("DashboardForm.fxml");
                break;

            case STUDENT:
                window.setTitle("Student Form");
                initUI("StudentForm.fxml");
                break;
            case ROOM:
                window.setTitle("Room Form");
                initUI("RoomForm.fxml");
                break;


            default:
                new Alert(Alert.AlertType.ERROR,"error").show();
        }
    }

    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/hostelManagementSystem/view/"+location)));
    }

}
