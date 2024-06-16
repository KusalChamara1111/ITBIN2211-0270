package Controller;

import Model.DBConnection;
import View.Home;
import View.Login;
import static com.sun.glass.ui.Cursor.setVisible;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginController {

    public static void login(String username, String password) {
        // Check if the username and password fields are empty
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill out both username and password fields");
        } else {
            // Perform authentication check
            if (authenticate(username, password)) {
                JOptionPane.showMessageDialog(null, "Login Successful");
                // Hide the login view
                 // Create an instance of the Home class and make it visible
                 
                  
        Home home = new Home();
        home.setVisible(true);
        
        // Hide the login page
        setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
     

    private static boolean authenticate(String username, String password) {
        // Perform authentication against the database
        // For demonstration purposes, let's assume a hard-coded admin username and password
        return username.equals("Admin") && password.equals("747719");
    }
}
