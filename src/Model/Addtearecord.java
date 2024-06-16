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
public class Addtearecord {
    Statement stmt;
    
     public void Form(String TeacherName, String NICNo, String Gender,String DateOfBirth ,String Subject,String Phone,String Address) {
try {
stmt = (Statement) DBConnection.getConnection();
stmt.executeUpdate
("INSERT INTO teachers (TeacherName,NICNo,Gender,DateOfBirth,Subject,Phone,Address) VALUES('" + TeacherName + "','" + NICNo + "','"+Gender+"','" + DateOfBirth + "','" + Subject + "','" + Phone + "','" + Address + "')");

} catch (Exception e) {
e.printStackTrace();
}
}
}
