package Model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class Home {

    @FXML
    private AnchorPane ancerpan;

    @FXML
    void BtnHome(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/Home.fxml");
        assert resource !=null;
        Parent load = FXMLLoader.load(resource);
        ancerpan.getChildren().clear();
    }

    @FXML
    void BtnLog(ActionEvent event)throws IOException {
        URL resource = this.getClass().getResource("/View/log.fxml");
        assert resource !=null;
        Parent load = FXMLLoader.load(resource);
        ancerpan.getChildren().clear();
        ancerpan.getChildren().add(load);
    }

    @FXML
    void BtnReqister(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/View/Reqister.fxml");
        assert resource !=null;
        Parent load = FXMLLoader.load(resource);
        ancerpan.getChildren().clear();
        ancerpan.getChildren().add(load);

    }

    public void BtnAdmin(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/View/admin.fxml");
        assert resource !=null;
        Parent load = FXMLLoader.load(resource);
        ancerpan.getChildren().clear();
        ancerpan.getChildren().add(load);
    }
}
