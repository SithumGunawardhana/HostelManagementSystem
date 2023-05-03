package lk.ijse.hostelManagementSystem.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.RoomBO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.util.Navigation;
import lk.ijse.hostelManagementSystem.util.Routes;
import lk.ijse.hostelManagementSystem.view.dtm.RoomDTM;

public class RoomFormController {

    public JFXTextField txtRoomTypeID;
    public JFXTextField txtKeyMoney;
    public JFXComboBox cmbRoomType;
    public JFXTextField txtQtq;
    public JFXButton btnSaveRoom;
    public TableColumn colRoomTypeId;
    public TableColumn cloRoomType;
    public TableColumn colKeyMoney;
    public TableColumn colQty;
    public JFXButton btnSerchRoom;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public TableView tblRoom;

    RoomBO roomBO = (RoomBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ROOM);


    public void btnSaveRoomOnAction(ActionEvent actionEvent) {
        try {
            roomBO.saveRoom(new RoomDTO(txtRoomTypeID.getText(), (String) cmbRoomType.getValue(), Integer.parseInt(txtQtq.getText()), txtKeyMoney.getText()));
            cleanText();
            new Alert(Alert.AlertType.CONFIRMATION,"Saved!").show();
           // Navigation.navigate(Routes.ROOM);
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"not save!").show();
        }
    }

    public void btnSearchRoomOnAction(ActionEvent actionEvent) {

        try {

        RoomDTO room =roomBO.searcRoom(txtRoomTypeID.getText());

        txtRoomTypeID.setText(room.getRoomTpeId());
        cmbRoomType.setValue(room.getType());
        txtQtq.setText(String.valueOf(room.getQyt()));
        txtKeyMoney.setText(room.getKeyMoney());

    }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"not have this search id ").show();
        }
    }

    public void btnUpdateRoomOnAction(ActionEvent actionEvent) {
        try {
            roomBO.updateRoom(new RoomDTO(txtRoomTypeID.getText(), (String) cmbRoomType.getValue(), Integer.parseInt(txtQtq.getText()), txtKeyMoney.getText()));
            new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "not update!").show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            roomBO.deleteRoom(txtRoomTypeID.getText());
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted!").show();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"not Delete!").show();
        }
    }

    public void cmbRoomTypeOnAction() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Non-AC ","Non-AC / Food","AC ","AC / Food");
        cmbRoomType.setItems(list);

    }



    public void initialize() {
        cmbRoomTypeOnAction();
        selectAllRooms();
        colRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("roomTpeId"));
        cloRoomType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qyt"));

    }



    private void selectAllRooms(){
        ObservableList<RoomDTM> rooms = roomBO.getRooms();
        tblRoom.setItems(rooms);
    }

    public void validateFieldsOnKeyRelease(KeyEvent keyEvent) {
    }

    public void cleanText(){
        txtRoomTypeID.setText("");
        cmbRoomType.setValue("");
        txtQtq.setText("");
        txtKeyMoney.setText("");
    }


    public void txtRoomIdOnAction(ActionEvent actionEvent) {
        try {


            RoomDTO room = roomBO.searcRoom(txtRoomTypeID.getText());

            txtRoomTypeID.setText(room.getRoomTpeId());
            cmbRoomType.setValue(room.getType());
            txtQtq.setText(String.valueOf(room.getQyt()));
            txtKeyMoney.setText(room.getKeyMoney());
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"not have this search id ").show();
        }
    }
}
