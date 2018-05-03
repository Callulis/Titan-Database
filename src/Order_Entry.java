import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Owner on 11/26/2017.
 */
public class Order_Entry {
    JPanel panelOrder;
    private JTextField Quantity;
    private JTextField State;
    private JTextField Zip;
    private JTextField Country;
    private JTextField ProductID;
    private JTextField EmployeeID;
    private JTextField OrderID;
    private JTextField Vendor_Name;
    private JTextField Vendor_Contact;
    private JTextField Email;
    private JTextField Street;
    private JButton enterOrderButton;
    private JButton homeButton;
    private JComboBox comboBox1;
    private JTextField City;
    private JTextField Phone;
    static JFrame  my_frame = new JFrame("Order Entry Form");

    static final String userName="root";//put your MySQL user name
    static final String password="Chri$!!1";//put your MySQL password
    private static Connection connection=null;

    public Order_Entry() {
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
        enterOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object newInstance;
                try {
                    newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3360/titangames?autoReconnect=true&useSSL=false", userName, password);// Please use your database name here
                    PreparedStatement updateStaff;
                    Statement queryStatement = connection.createStatement();
                    String query = "update users set num_points = ? where first_name = ?";
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
                /*
                statement.executeUpdate("INSERT INTO ITEM_ORDER (Order_ID, Order_Employee_ID, Order_DateTime, Order_Product_ID, Order_Vendor_ID, Vendor_Order_Quantity, Customer_Sale_Quantity) +" +
                        " VALUES (" + OrderID.getText() + "," + EmployeeID.getText() + "," + null + "," + ProductID.getText() + "," + null + "," + Quantity.getText() + "," + null + ")");
                        */
            }
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {


        my_frame.setResizable(false);
        my_frame.setContentPane(new Order_Entry().panelOrder);
        my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        my_frame.pack();
        my_frame.setVisible(true);
    }
}
