package Controller.customer;

import DBConnection.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerController implements CustomerService {
    @Override
    public boolean addCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean deletCustomer(String id) {
        return false;
    }

    @Override
    public Customer searchCustomer(String id) {
        try {
            String SQL = "SELECT * FROM customer WHERE id = '" + id + "'";
            System.out.println(SQL);

            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);

            if (resultSet.next()) {
                return new Customer(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4)
                );
            } else {
                System.out.println("               ");
                System.out.println("no Search data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to search customer", e);
        }
        System.out.println("               ");
        return null;
    }

    @Override
    public List<Customer> getAll() {
        ArrayList<Customer> Customerlist = new ArrayList<>();

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * From customer");


            while (resultSet.next()) {
              System.out.println(resultSet.getString(1));
                Customer customer = new Customer(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4)
                );
                Customerlist.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Customerlist;
    }
    /// /////////////////////////////////////////////////////////////////////////////////
    public ObservableList<String> getCustoremerids() {
        List<Customer> customerList = getAll();

        ObservableList<String> CustomerIDList = FXCollections.observableArrayList();

        customerList.forEach(customer -> {
            CustomerIDList.add(customer.getId());
        });
        return CustomerIDList;
    }
/// ////////////////////////////////////////////////////////////////////////

}
