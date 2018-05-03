import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
/**
 * Created by Owner on 11/26/2017.
 */
public class Home_Screen {

    static JFrame  my_frame = new JFrame("Titan Games And Hobbies");
     JPanel panelHome;
    private JButton customerButton;
    private JButton employeeButton;
    private JButton saleButton;
    private JButton orderButton;
    private JButton reportsButton;

    public Home_Screen()  throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{

        reportsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    my_frame.dispose();
                    my_frame.setContentPane(new my_gui().panelMain);
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

        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    my_frame.dispose();
                    my_frame.setContentPane(new Customer_Entry().panelCustomer);
                    my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    my_frame.pack();
                    my_frame.setVisible(true);


            }
        });
        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                my_frame.dispose();
                my_frame.setContentPane(new Employee_Entry().panelEmployee);
                my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                my_frame.pack();
                my_frame.setVisible(true);
            }
        });
        saleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    my_frame.dispose();
                    my_frame.setContentPane(new Sale_Entry().panelSale);
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
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                my_frame.dispose();
                my_frame.setContentPane(new Order_Entry().panelOrder);
                my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                my_frame.pack();
                my_frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {


        my_frame.setResizable(false);
        my_frame.setContentPane(new Home_Screen().panelHome);
        my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        my_frame.pack();
        my_frame.setVisible(true);
    }


}
