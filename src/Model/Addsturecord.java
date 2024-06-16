/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Statement;


/**
 *
 * @author Kusal
 */
public class Addsturecord {
    Statement stmt;
    
    public void Form(String StudentName, String DateOfBirth, String Gender, String Phone,String Address) {
try {
stmt = (Statement) DBConnection.getConnection();
stmt.executeUpdate
("INSERT INTO students (StudentName,DateOfBirth,Gender,Phone,Address) VALUES('" + StudentName + "','" + DateOfBirth + "','" + Gender + "','" + Phone + "','" + Address + "')");

} catch (Exception e) {
e.printStackTrace();
}
}
}    

