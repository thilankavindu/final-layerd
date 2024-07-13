package lk.ijse.finalProject.bo.custom;

import lk.ijse.finalProject.bo.SuperBO;
import lk.ijse.finalProject.dto.UserDTO;

import java.sql.SQLException;

public interface UserBO extends SuperBO {
    boolean checkCredential(String userId, String password) throws SQLException, ClassNotFoundException;

    boolean saveUser(UserDTO userDTO) throws SQLException, ClassNotFoundException;
}
