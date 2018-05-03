import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

public class my_gui {

    static final String userName="root";//put your MySQL user name
    static final String password="Chri$!!1";//put your MySQL password
    private static Connection connection=null;



    JPanel panelMain;
    private JButton Button_5;
    private JTextArea textArea1;
    private JButton Button_1;
    private JButton Button_2;
    private JButton Button_3;
    private JButton Button_6;
    private JButton Button_7;
    private JButton Button_4;
    private JButton backButton;
    static JFrame  my_frame = new JFrame("Sale Entry Form");


    public void make_sql_query(int x) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3360/titangames?autoReconnect=true&useSSL=false", userName, password);// Please use your database name here
        PreparedStatement updateStaff;
        Statement queryStatement = connection.createStatement();
        String querys;


        //Choose correct sql query based on number given
        switch (x) {
            case 1:
                querys = "Select Product_Name,SUM(Stock_Number) " +
                        "From PRODUCT " +
                        "Group by Product_ID;";
                break;
            case 2:
                querys = "Select SUM(Quantity) " +
                        "From CUSTOMER_RESALE;";
                break;
            case 3:
                querys = "Select Count(Status) " +
                        "From PRODUCT " +
                        "Where Status='new';";
                break;
            case 4:
                querys = "Select SUM(Store_Credit) " +
                        "From CUSTOMER_RESALE";
                break;
            case 5:
                querys = "Select Last_Name, First_Name " +
                        "From EMPLOYEE";
                break;
            case 6:
                querys = "Select (SUM(Customer_Sale_Quantity*Sale_Price)-SUM(Product_Price*Vendor_Order_Quantity)) " +
                        "From ITEM_ORDER, PRODUCT " +
                        "Where Product_ID=Order_Product_ID;";
                break;
            case 7:
                querys = "SELECT Gender, COUNT(Gender) " +
                        "FROM CUSTOMER " +
                        "Group by Gender;";
                break;
            default:
                querys = "ERROR";
        }


        ResultSet results = queryStatement.executeQuery(querys);

        StringBuilder builder = new StringBuilder();
        int columnCount = results.getMetaData().getColumnCount();
        while (results.next()) {
            for (int i = 0; i < columnCount;) {
                builder.append(results.getString(i + 1));
                if (++i < columnCount) builder.append(",");
            }
            builder.append("\r\n");
        }
        String resultSetAsString = builder.toString();
        //updateStaff = connection.prepareStatement(querys);
        //updateStaff.executeUpdate();
        textArea1.setText(resultSetAsString);


    }

    public my_gui() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{

        Button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    make_sql_query(1);
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

        Button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    make_sql_query(2);
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
        Button_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    make_sql_query(3);
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
        Button_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    make_sql_query(4);
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
        Button_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    make_sql_query(5);
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
        Button_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    make_sql_query(6);
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
        Button_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    make_sql_query(7);
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

        backButton.addActionListener(new ActionListener() {
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
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        my_frame = new JFrame("Titan Games And Hobbies");
        my_frame.setContentPane(new my_gui().panelMain);
        my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        my_frame.pack();
        my_frame.setVisible(true);
    }
}
