package Controller.item;

import DBConnection.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class itemController implements ItemService {

    @Override
    public boolean addItem() {
        return false;
    }

    @Override
    public boolean updateItem() {
        return false;
    }

    @Override
    public boolean deleteItem() {
        return false;
    }

    @Override
    public item searchcode(String Code) {
        String  SQL="SELECT * FROM item WHERE code ='"+Code+"'";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
             resultSet.next();
             return new item(
                     resultSet.getString(1),
                     resultSet.getString(2),
                     resultSet.getDouble(3),
                     resultSet.getInt(4)
             );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<item> getAll() {
        ArrayList<item> itemsList = new ArrayList<>();
        try {
            String SQL ="Select * from item";
            System.out.println(SQL);
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                itemsList.add( new item(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4)
                    )
                );
            }
              return itemsList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public ObservableList<String>getItemcode(){
        ObservableList<String> ItemList = FXCollections.observableArrayList();
        List<item> all = getAll();
        all.forEach(item -> {
            ItemList.add((item.getCode()));
        });
            return ItemList;
    }
}
