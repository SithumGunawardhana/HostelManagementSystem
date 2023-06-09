package lk.ijse.hostelManagementSystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.view.dtm.RoomDTM;

public interface RoomBO extends SuperBO {

    void saveRoom(RoomDTO dto);

    void updateRoom(RoomDTO dto);

    RoomDTO searcRoom(String id);

    void deleteRoom(String id);

    ObservableList<RoomDTM> getRooms();
}
