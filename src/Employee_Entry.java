import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Owner on 11/26/2017.
 */
public class Employee_Entry {
     JPanel panelEmployee;
    private JTextField First_Name;
    private JTextField Last_Name;
    private JTextField DOB;
    private JTextField SSN;
    private JTextField City;
    private JTextField Zip_Code;
    private JTextField Street;
    private JTextField Apartment;
    private JTextField Country;
    private JButton enterEmployeeButton;
    private JTextField Email;
    private JTextField Phone_Number;
    private JButton homeButton;
    private JComboBox Supervisor;
    private JTextField Employee_ID;
    private JTextField State;

    static final String userName="root";//put your MySQL user name
    static final String password="Chri$!!1";//put your MySQL password
    private static Connection connection=null;
    static JFrame my_frame = new JFrame("Employee Entry");

    public Employee_Entry(){
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    my_frame.dispose();
                    my_frame.setResizable(false);
                    my_frame.setContentPane(new Home_Screen().panelHome);
                    my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    my_frame.pack();
                    my_frame.setVisible(true);
                }
                catch(SQLException x)
                {
                    x.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                } catch (InstantiationException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        enterEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object newInstance;
                try {
                    newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
                } catch (InstantiationException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3360/titangames?autoReconnect=true&useSSL=false", userName, password);// Please use your database name here
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                PreparedStatement updateStaff;
                try {
                    Statement queryStatement = connection.createStatement();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                String querys;

                String query = "INSERT INTO EMPLOYEE (Employee_ID, Supervisor, Last_Name, First_Name, DOB, Phone_Number, Email, SSN, Country, State, City, Zip_Code, Street, Apartment) +" +
                        " VALUES (" + Employee_ID.getText() + "," + Supervisor.getSelectedItem() + "," + Last_Name.getText() + "," + First_Name.getText() + "," + DOB.getText() + "," +
                        Phone_Number.getText() + "," + Email.getText() + "," + SSN.getText() + "," + Country.getText() + "," + State.getText() + "," + City.getText() + "," + Zip_Code.getText() + "," + Street.getText() + "," +
                        Apartment.getText() + ")";

                try {
                    PreparedStatement preparedStmt = connection.prepareStatement(query);
                    //preparedStmt.setInt   (1, 6000);
                    //preparedStmt.setString(2, "Fred");
                    preparedStmt.executeUpdate();
                    preparedStmt.executeUpdate(query);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }






            }
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {


        my_frame.setResizable(false);
        my_frame.setContentPane(new Employee_Entry().panelEmployee);
        my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        my_frame.pack();
        my_frame.setVisible(true);

    }


}
