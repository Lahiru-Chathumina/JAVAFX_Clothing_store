package Controller.item;

import javafx.application.Application;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class item extends Application {
    private String code;
    private String Decription;
    private Double unitPrice;
    private int stock;

    @Override
    public void start(Stage stage) throws Exception {

    }
}
