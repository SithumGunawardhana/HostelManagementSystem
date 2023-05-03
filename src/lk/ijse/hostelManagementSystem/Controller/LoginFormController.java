package lk.ijse.hostelManagementSystem.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelManagementSystem.util.Navigation;
import lk.ijse.hostelManagementSystem.util.Routes;
import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;
    public JFXButton btnSignIn;

    public AnchorPane pane;


    public void btnSignOnAction(ActionEvent actionEvent) throws IOException {

try {

    if (txtEmail.getText().equals("Sithum") && txtPassword.getText().equals("Sithum1234")) {

        Navigation.navigate(Routes.DASHBORD, pane);
    }else {

        new Alert(Alert.AlertType.ERROR,"your name or password incorrect").show();
        Navigation.navigate(Routes.LOGIN,pane);
    }
}catch (Exception e){
          new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }


}
