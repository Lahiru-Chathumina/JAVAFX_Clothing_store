package Log;

import DBConnection.DBConnection;
import Reqister.usear;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Log {

    @FXML
    private PasswordField textpassword;

    @FXML
    private TextField txtusearname;

    @FXML
    void BTNLoging(ActionEvent event) throws SQLException, IOException {
        String SQL ="Select * from users where email='" +txtusearname.getText()+"'";
        Connection connection = DBConnection.getInstance().getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery(SQL);
        if (resultSet.next()) {
            usear usear = new usear(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );
            System.out.println(usear);
            if (usear.getPassword().equals(textpassword.getText())) {
                Stage stage = new Stage();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/ShopingStor.fxml"))));
                stage.show();
            } else {
                System.out.println("password issue");
            }


        }else {
            new Alert(Alert.AlertType.ERROR, "Place valid email").show();
        }
    }
    @FXML
    void BtnfrogetPassword(ActionEvent event) {

    }

}
