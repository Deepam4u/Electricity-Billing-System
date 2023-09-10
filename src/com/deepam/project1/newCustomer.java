package com.deepam.project1;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class newCustomer extends JFrame implements ActionListener {

    JTextField nameField , address, city , state , email , phone;
    JLabel meterField;
    JButton next, cancel;

    newCustomer() {

        setSize(700, 500);
        setLocation(600, 300);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(193, 224, 234));
        add(panel);

        JLabel heading = new JLabel("New Customer");
        heading.setBounds(200, 18, 200, 25);
        heading.setFont(new Font("Helvetica", Font.PLAIN, 24));
        panel.add(heading);

        JLabel userName = new JLabel("Customer Name");
        userName.setBounds(100, 80, 100, 20);
        panel.add(userName);

        nameField = new JTextField();
        nameField.setBounds(240, 80, 200, 20);
        panel.add(nameField);

        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(100, 120, 100, 20);
        panel.add(meterNo);

        meterField = new JLabel("");
        meterField.setBounds(240, 120, 100, 20);
        panel.add(meterField);

        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        meterField.setText("" + Math.abs(number));

        JLabel userAddress = new JLabel("Address");
        userAddress.setBounds(100, 160, 100, 20);
        panel.add(userAddress);

        address = new JTextField();
        address.setBounds(240, 160, 200, 20);
        panel.add(address);

        JLabel userCity = new JLabel("City");
        userCity.setBounds(100, 200, 100, 20);
        panel.add(userCity);

        city = new JTextField();
        city.setBounds(240, 200, 200, 20);
        panel.add(city);

        JLabel userState = new JLabel("State");
        userState.setBounds(100, 240, 100, 20);
        panel.add(userState);

        state = new JTextField();
        state.setBounds(240, 240, 200, 20);
        panel.add(state);

        JLabel luserEmail = new JLabel("Email");
        luserEmail.setBounds(100, 280, 100, 20);
        panel.add(luserEmail);

        email = new JTextField();
        email.setBounds(240, 280, 200, 20);
        panel.add(email);

        JLabel userPhone = new JLabel("Phone Number");
        userPhone.setBounds(100, 320, 100, 20);
        panel.add(userPhone);

        phone = new JTextField();
        phone.setBounds(240, 320, 200, 20);
        panel.add(phone);

        next = new JButton("Next");
        next.setBounds(120, 390, 100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        panel.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 390, 100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());

        add(panel, "Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == next) {
            String name = nameField.getText();
            String meter = meterField.getText();
            String saddress = address.getText();
            String scity = city.getText();
            String sstate = state.getText();
            String semail = email.getText();
            String sphone = phone.getText();

            String query1 = "insert into customer values('"+name+"', '"+meter+"', '"+saddress+"', '"+scity+"', '"+sstate+"', '"+semail+"', '"+sphone+"')";
            String query2 = "insert into login values('"+meter+"', '', '"+name+"', '', '')";

            try {
                connectDatabase c = new connectDatabase();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);

                // new frame
                new meterInfo(meter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }

    }




    public static void main(String[] args) {

        new newCustomer();

    }
}
