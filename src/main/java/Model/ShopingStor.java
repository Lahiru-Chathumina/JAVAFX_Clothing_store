package Model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShopingStor implements Initializable {

    @FXML
    private AnchorPane AnchorPane;


    @FXML
    void BtnOder(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/View/oder_from.fxml");
        assert resource !=null;
         Parent load = FXMLLoader.load(resource);
         AnchorPane.getChildren().clear();
         AnchorPane.getChildren().add(load);
    }

    @FXML
    void Btnkids(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/View/Kids.fxml");
        assert resource !=null;
       Parent  load = FXMLLoader.load(resource);
       AnchorPane.getChildren().clear();
       AnchorPane.getChildren().add(load);
    }

    @FXML
    void Btnwomen(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/View/women.fxml");
        assert resource !=null;
        Parent load = FXMLLoader.load(resource);
        AnchorPane.getChildren().clear();
        AnchorPane.getChildren().add(load);

    }
//     Home loard ///
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadHome();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void Btnmen(ActionEvent actionEvent) throws IOException {
      loadHome();
    }
    public void loadHome() throws IOException {
        URL resource = this.getClass().getResource("/View/Men.fxml");
        assert resource !=null;
        Parent load = FXMLLoader.load(resource);
        AnchorPane.getChildren().clear();
        AnchorPane.getChildren().add(load);
    }

}
