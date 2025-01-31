package DBConnection;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static DBConnection Instance;
@Getter
private Connection connection;

    private DBConnection(){
        String url ="jdbc:mysql://localhost:3306/thogakade";
        String username= "root";
        String password ="1234";
        try {
             connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DBConnection getInstance(){
           return Instance == null?Instance=new DBConnection():Instance;
    }


}
