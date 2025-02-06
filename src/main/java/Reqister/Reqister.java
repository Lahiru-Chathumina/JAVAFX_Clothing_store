package Reqister;

import DBConnection.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.*;

public class Reqister {

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textName;

    @FXML
    private TextField textPassword;

    @FXML
    private TextField textPassword02;

    @FXML
    private TextField txetAddress;

    @FXML
    void BtnReqistoer(ActionEvent event) {
        String SQL="Insert into users(username,email,password)values(?,?,?)";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            if (textPassword.getText().equals(textPassword02.getText())){
                ResultSet resultSet = statement.executeQuery("Select * from users where email='"+textEmail.getText()+"'");
                if (!resultSet.next()){
                              usear usear = new usear(
                                      textName.getText(),
                                      textEmail.getText(),
                                      txetAddress.getText(),
                                      textPassword.getText()
                              );
                              PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                              preparedStatement.setString(1,usear.getName());
                              preparedStatement.setString(2, usear.getEmail());
                              preparedStatement.setString(3,usear.getPassword());
                              preparedStatement.executeUpdate();
                          } else {
                              new Alert(Alert.AlertType.ERROR,"Email Alrady Have Place Select your Loging").show();
                          }
            }else {
                new Alert(Alert.AlertType.ERROR,"Enter Same Password").show();
                System.out.println("notpass");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void Btnclear(ActionEvent event) {
        txetAddress.clear();
        textEmail.clear();
        textName.clear();
        textPassword.clear();
        textPassword02.clear();
    }

}
