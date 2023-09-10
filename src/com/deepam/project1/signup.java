package com.deepam.project1;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class signup extends JFrame implements ActionListener {

    JButton create, back;
    Choice accountType;
    JTextField meter , user , nameField , passWord;

    signup(){

        setBounds(450 , 250 , 940 , 540);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(23 , 20 , 880, 460);
        panel.setBorder(new TitledBorder(new LineBorder(Color.blue , 2) , "Create Account" , TitledBorder.LEADING, TitledBorder.TOP,  null, Color.blue ));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(25, 26, 25));
        add(panel);

        JLabel heading = new JLabel("Select Account Type");
        heading.setBounds(100 , 50, 140, 20);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(heading);

        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260, 50, 150 , 20);
        panel.add(accountType);

        JLabel meterNo = new JLabel("Meter No.");
        meterNo.setBounds(100 , 95, 140, 20);
        meterNo.setForeground(Color.BLACK);
        meterNo.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(meterNo);

        meter = new JTextField();
        meter.setBounds(260, 95, 150, 20);
        meter.setVisible(false);
        panel.add(meter);


        JLabel createUsername = new JLabel("Username");
        createUsername.setBounds(100 , 140, 140, 20);
        createUsername.setForeground(Color.BLACK);
        createUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(createUsername);

        user = new JTextField();
        user.setBounds(260, 140, 150, 20);
        panel.add(user);

        JLabel name = new JLabel("Name");
        name.setBounds(100 , 185, 140, 20);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(name);

        nameField = new JTextField();
        nameField.setBounds(260, 185, 150, 20);
        panel.add(nameField);

        meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {}

            @Override
            public void focusLost(FocusEvent fe) {
                try {
                    connectDatabase c  = new connectDatabase();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+meter.getText()+"'");
                    while(rs.next()) {
                        nameField.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JLabel password = new JLabel("Password");
        password.setBounds(100 , 230, 140, 20);
        password.setForeground(Color.BLACK);
        password.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(password);

        passWord = new JTextField();
        passWord.setBounds(260, 230, 150, 20);
        panel.add(passWord);

        accountType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                String user = accountType.getSelectedItem();
                if (user.equals("Customer")) {
                    meter.setVisible(true);
                    meter.setVisible(true);
                    nameField.setEditable(false);
                } else {
                    meter.setVisible(false);
                    meter.setVisible(false);
                    nameField.setEditable(true);
                }
            }
        });

        create = new JButton("Create Account");
        create.setBounds(110, 290, 130, 30 );
        create.addActionListener(this);
        panel.add(create);

        back = new JButton("Back to Login");
        back.setBounds(280, 290, 130, 30 );
        back.addActionListener(this);
        panel.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(200 , 120 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 30 , 450 , 350);
        panel.add(image);

        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == create) {
            String atype = accountType.getSelectedItem();
            String susername = user.getText();
            String sname = nameField.getText();
            String spassword = passWord.getText();
            String smeter = meter.getText();

            try {
                connectDatabase c = new connectDatabase();

                String query = null;
                if (atype.equals("Admin")) {
                    query = "insert into login values('"+smeter+"', '"+susername+"', '"+sname+"', '"+spassword+"', '"+atype+"')";
                }
                else {
                    query = "update login set username = '"+susername+"', password = '"+spassword+"', user = '"+atype+"' where meter_no = '"+smeter+"'";
                }
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfully");

                setVisible(false);
                new login();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == back) {
            setVisible(false);

            new login();
        }

    }

    public static void main(String[] args) {
        new signup();
    }
}
