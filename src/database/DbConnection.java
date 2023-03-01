package database;
import java.sql.*;

public class DbConnection {
    public  Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:postgresql://localhost:5432/dvdrental","postgres","root");
            System.out.println("connect to database");
        } catch (Exception ex) {
            System.err.println("Cannot connect to database");
            System.exit(0);
        }
        return connection;
    }
}
