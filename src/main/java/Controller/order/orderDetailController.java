package Controller.order;

import DBConnection.DBConnection;
import Model.orderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class orderDetailController {
    public boolean addOrderDetail(List<orderDetail> orderDetails){
        for (orderDetail orderDetail:orderDetails){
            boolean isAddorderDetail =  addOrderDetails(orderDetail);
            if (isAddorderDetail){
                return false;
            }
        }
        return true;
    }
    public boolean addOrderDetails(orderDetail orderDetails){
          String SQL ="INSERT INTO orderdetail Values(?,?,?,?)";
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,orderDetails.getOderID());
            preparedStatement.setObject(2,orderDetails.getItemCode());
            preparedStatement.setObject(3,orderDetails.getQty());
            preparedStatement.setObject(4,orderDetails.getUnitePrce());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
