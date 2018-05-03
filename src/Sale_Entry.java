import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Owner on 11/26/2017.
 */
public class Sale_Entry {
    private JTextField Card_Type;
    private JTextField Card_Number;
    private JTextField Name_On_Card;
    private JTextField Payment_Type;
    private JTextField First_Name;
    private JTextField Last_Name;
    private JTextField DOB;
    private JTextField Emp_First_Name;
    private JTextField Emp_Last_Name;
    private JTextField Product_Name;
    private JTextField Product_Type;
    private JTextField Product_Edition;
    private JTextField Price;
    private JTextField Quantity;
    private JButton enterSaleButton;
    JPanel panelSale;
    private JButton homeButton;
    static JFrame  my_frame = new JFrame("Sale Entry Form");

    static final String userName="root";//put your MySQL user name
    static final String password="Chri$!!1";//put your MySQL password
    private static Connection connection=null;

    public Sale_Entry() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
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
        enterSaleButton.addActionListener(new ActionListener() {
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
                statement.executeUpdate("INSERT INTO EMPLOYEE (Employee_ID, Supervisor, Last_Name, First_Name, DOB, Phone_Number, Email, SSN, Country, State, City, Zip_Code, Street, Apartment) +" +
                        " VALUES (" + Employee_ID.getText() + "," + Supervisor.getSelectedItem() + "," + Last_Name.getText() + "," + First_Name.getText() + "," + DOB.getText() + "," +
                        Phone_Number.getText() + "," + Email.getText() + "," + SSN.getText() + "," + Country.getText() + "," + State.getText() + "," + City.getText() + "," + Zip_Code.getText() + "," + Street.getText() + "," +
                        Apartment.getText() + ")");
                */
            }
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        my_frame.setResizable(false);
        my_frame.setContentPane(new Sale_Entry().panelSale);
        my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        my_frame.pack();
        my_frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
