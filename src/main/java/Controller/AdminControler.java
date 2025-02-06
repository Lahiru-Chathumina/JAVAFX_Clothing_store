package Controller;

import DBConnection.DBConnection;
import Reqister.admin;
import Reqister.usear;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminControler {

    @FXML
    private TextField textEmail;
    @FXML
    private PasswordField textPassword;
    @FXML
    void BtnLoging(ActionEvent event) throws SQLException, IOException {
        String SQL ="Select * from admin where username='" +textEmail.getText()+"'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL);
        if(resultSet.next()){
            admin admin = new admin(
                    resultSet.getString(2),
                    resultSet.getString(3)
            );
            System.out.println(admin);

            if (admin.getPassword().equals(textPassword.getText())){
                 Stage stage = new Stage();
                 stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Reqister.fxml"))));
                 stage.show();
             } else {
                 System.out.println("admin Password envalid");
                new Alert(Alert.AlertType.ERROR,"Enter Your Admin Password");

            }

        }else {
            System.out.println(textEmail.getText());
            new Alert(Alert.AlertType.ERROR,"Enter Your Admin Email");
        }
    }

    @FXML
    void BtndLoging(MouseEvent event) {

    }

    @FXML
    void hypFrogetPassword(ActionEvent event) {

    }

}
