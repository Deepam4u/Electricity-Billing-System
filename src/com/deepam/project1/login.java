package com.deepam.project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {

    JButton loginButton, cancelButton, signUp;
    JTextField userName, passwordArea;
    Choice loggingIn;

    login(){



        super("Login Page");
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);

        JLabel username = new JLabel("Username");
        username.setBounds(300 , 30 , 100, 20);
        add(username);

        userName = new JTextField();
        userName.setBounds(400, 30, 150, 20);
        add(userName);

        JLabel password = new JLabel("Password");
        password.setBounds(300 , 70 , 100, 20);
        add(password);

        passwordArea = new JTextField();
        passwordArea.setBounds(400, 70, 150, 20);
        add(passwordArea);

        JLabel loginInAs = new JLabel("Login As");
        loginInAs.setBounds(300 , 110 , 100, 20);
        add(loginInAs);

        loggingIn = new Choice();
        loggingIn.add("----");
        loggingIn.add("Admin");
        loggingIn.add("Customer");
        loggingIn.setBounds(400 , 110 , 150 , 20);
        add(loggingIn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        loginButton = new JButton("Login As" , new ImageIcon(i2));
        loginButton.setBounds(310 , 170 , 100, 20);
        loginButton.addActionListener(this);
        add(loginButton);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4 = i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        cancelButton = new JButton("Cancel" , new ImageIcon(i4));
        cancelButton.setBounds(450 , 170 , 100, 20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i6 = i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        signUp = new JButton("Sign Up" , new ImageIcon(i6));
        signUp.setBounds(380 , 200 , 100, 20);
        signUp.addActionListener(this);
        add(signUp);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(0 , 0, 260, 260);
        add(image);


        setSize(640, 300);
        setLocation(600 , 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == loginButton) {
            String susername = userName.getText();
            String spassword = passwordArea.getText();
            String user = loggingIn.getSelectedItem();

            try {
                connectDatabase c = new connectDatabase();
                String query = "select * from login where username = '"+susername+"' and password = '"+spassword+"' and user = '"+user+"'";

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    userName.setText("");
                    passwordArea.setText("");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == cancelButton) {
            setVisible(false);
        }
        else if (ae.getSource() == signUp) {
            setVisible(false);

            new signup();
        }

    }


    public static void main(String[] args) {
        new login();
    }
}
