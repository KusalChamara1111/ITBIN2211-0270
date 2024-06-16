

package Controller;
import javax.swing.JOptionPane;

/**
 *
 * @author Kusal
 */
public class StudentController {
    public static void Form(String StudentName, String DateOfBirth, String gender, String Phone,String Address) {
new Model.Addsturecord().Form(StudentName,DateOfBirth,gender,Phone,Address);
JOptionPane.showMessageDialog(null, "New Record has been inserted", "Successfull", JOptionPane.INFORMATION_MESSAGE);


}
}
    

