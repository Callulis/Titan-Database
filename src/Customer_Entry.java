import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Owner on 11/26/2017.
 */
public class Customer_Entry {
    private JTextField First_Name;
    private JTextField Last_Name;
    private JTextField DOB;
    private JTextField Country;
    private JTextField City;
    private JTextField Zip_Code;
    private JTextField Street;
    private JTextField Apartment;
    private JTextField Gender;
    private JButton enterCustomerButton;
     JPanel panelCustomer;
    private JButton homeButton;
    private JTextField State;

    static final String userName="root";//put your MySQL user name
    static final String password="Chri$!!1";//put your MySQL password
    private static Connection connection=null;

    static JFrame my_frame = new JFrame("Customer Entry");


    public Customer_Entry(){
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    my_frame.dispose();
                    my_frame.setResizable(false);
                    my_frame.setVisible(false);
                    my_frame.setContentPane(new Home_Screen().panelHome);
                    my_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
        enterCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object newInstance;
                String customer_id = String.valueOf((int)(Math.random() * 100000));
                try {
                    newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3360/titangames?autoReconnect=true&useSSL=false", userName, password);// Please use your database name here
                    PreparedStatement updateStaff;
                    Statement queryStatement = connection.createStatement();
                    String query = "INSERT INTO customer (Customer_ID, Last_Name, First_Name, DOB, Country, State, City, Zip_Code, Street, Apartment, Gender) " +
                            " VALUES (" + customer_id + "," + Last_Name.getText() + "," + First_Name.getText() + "," + DOB.getText() + "," + Country.getText() + "," +
                            State.getText() + "," + City.getText() + "," + Zip_Code.getText() + "," + Street.getText() + "," + Apartment.getText() + "," + Gender.getText() + ";";
                    PreparedStatement preparedStmt = connection.prepareStatement(query);
                    preparedStmt.executeUpdate();

                } catch (InstantiationException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1){
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {


        my_frame.setResizable(false);
        my_frame.setContentPane(new Customer_Entry().panelCustomer);
        my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        my_frame.pack();
        my_frame.setVisible(true);
    }
}
