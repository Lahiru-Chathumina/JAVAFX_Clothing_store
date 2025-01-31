package Controller.order;

import Controller.customer.Customer;
import Controller.customer.CustomerController;
import Controller.item.item;
import Controller.item.itemController;
import Model.CardTabaleMod;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderFromController implements Initializable {

    @FXML
    private ComboBox COMCustomerID;

    @FXML
    private TableColumn ColQTY;

    @FXML
    private TableColumn ColTotel;

    @FXML
    private TableColumn ColUnitPrice;

    @FXML
    private ComboBox ComItemCode;

    @FXML
    private TableView Teable;

    @FXML
    private TableColumn colDescription;

    @FXML
    private TableColumn colitemCode;

    @FXML
    private TextField textCustomerAddress;

    @FXML
    private TextField textCustomerName;

    @FXML
    private TextField textDescription;

    @FXML
    private TextField textQTY;

    @FXML
    private TextField textStock;

    @FXML
    private TextField textUnitPrice;

    @FXML
    void btnAddCard(ActionEvent event) {
        ObservableList<CardTabaleMod> CartList = FXCollections.observableArrayList();
        String Code = COMCustomerID.getValue().toString();
        String Description = textDescription.getText();
        int QTYONHand = Integer.parseInt(textQTY.getText());
        double UnitePrice = Double.parseDouble(textUnitPrice.getText());
        double Total = QTYONHand*UnitePrice;

        CartList.add(new CardTabaleMod(Code,Description,QTYONHand,UnitePrice,Total));
        Teable.setItems(CartList);
    }

    @FXML
    void btnplaceOrder(ActionEvent event) {

    }
///////////////////////////////////////////////////// loardTabale();  loardItemCode();//////////////////////////////////////////////////////////
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colitemCode.setCellValueFactory(new PropertyValueFactory<>("itemcode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        ColQTY.setCellValueFactory(new PropertyValueFactory<>("QTYonHand"));
        ColUnitPrice.setCellValueFactory(new PropertyValueFactory<>("UnitePrice"));
        ColTotel.setCellValueFactory(new PropertyValueFactory<>("Total"));


        loardTabale();
        loardItemCode();

        ComItemCode.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
            if (o!= null) {
                          searchItemdate(t1.toString());
            }
        } );

        COMCustomerID.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue ) ->{

                 if(newValue!=null){
                     searchCustomerData(newValue.toString());
                 }
             });
    }
    /// //////////////////////////////////////////////  searchCustomerData //////////////////////////////////////////////////////////////////
    private Customer searchCustomerData(String customerId) {
        Customer customer = new CustomerController().searchCustomer(customerId);
        if (customer!=null){
            System.out.println(customer.getName());
            System.out.println(customer.getAddress());
            textCustomerName.setText(customer.getName());
            textCustomerAddress.setText(customer.getAddress());
        }else {
            System.out.println("No customer found with ID: " + customerId);

        }
        return customer;
    }
    private void loardTabale(){
        COMCustomerID.setItems( new CustomerController().getCustoremerids());
        }
/// //////////////////////  Item //////////////////////////////////////////////////////////////////////////////////////
    private void loardItemCode() {
        ComItemCode.setItems(new itemController().getItemcode());
    }
    private void searchItemdate(String t1){
        item searchcode = new itemController().searchcode(t1);
        textDescription.setText(searchcode.getDecription());
        textStock.setText(String.valueOf(searchcode.getStock()));
        textUnitPrice.setText(searchcode.getUnitPrice().toString());
    }
}
