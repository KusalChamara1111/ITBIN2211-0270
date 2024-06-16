package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSearch {
    private Statement stmt;
    private ResultSet rs;

    public DBSearch() {
        // Constructor implementation
    }

    public ResultSet searchLogin(String usName) {
        try {
            stmt = (Statement) DBConnection.getConnection();
            String name = usName;
            // Execute the Query
            rs = stmt.executeQuery("SELECT * FROM users where username='" + name + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
