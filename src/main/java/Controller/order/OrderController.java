package Controller.order;

import DBConnection.DBConnection;
import Model.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderController {
    public boolean placeOder(order order){
        String SQL="INSERT INTO order VALUES(?,?,?)";
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,order.getId());
            preparedStatement.setObject(2,order.getDate());
            preparedStatement.setObject(3,order.getCustomerID());
            Boolean isorderAdd = preparedStatement.executeUpdate() > 0;
            if(isorderAdd){
                boolean b = new orderDetailController().addOrderDetail(order.getOrderDiteil());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
