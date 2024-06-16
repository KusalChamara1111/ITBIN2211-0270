/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import javax.swing.JOptionPane;

/**
 *
 * @author Kusal
 */
public class TeacherController {
    public static void Form(String TeachertName, String NICNo, String Gender, String DateOfBirth,String Subject,String Phone,String Address) {
new Model.Addtearecord().Form(TeachertName,  NICNo,  Gender,  DateOfBirth, Subject,Phone,Address);
JOptionPane.showMessageDialog(null, "New Record has been inserted", "Successfull", JOptionPane.INFORMATION_MESSAGE);
}
    
}
