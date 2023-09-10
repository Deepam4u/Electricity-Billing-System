package com.deepam.project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class calcBIll extends JFrame implements ActionListener {

    JTextField tfunits;
    JButton next, cancel;
    JLabel name, address;
    Choice meternumber, cmonth;

    calcBIll() {

        setSize(700, 500);
        setLocation(570, 250);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(204, 248, 236));
        add(panel);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(140, 18, 400, 25);
        heading.setFont(new Font("Helvetica", Font.PLAIN, 24));
        panel.add(heading);

        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(100, 80, 100, 20);
        panel.add(meterNo);

        meternumber = new Choice();

        try {
            connectDatabase c  = new connectDatabase();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()) {
                meternumber.add(rs.getString("meter_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        meternumber.setBounds(240, 80, 200, 20);
        panel.add(meternumber);

        JLabel userName = new JLabel("Name");
        userName.setBounds(100, 120, 100, 20);
        panel.add(userName);

        name = new JLabel("");
        name.setBounds(240, 120, 100, 20);
        panel.add(name);

        JLabel userAddress = new JLabel("Address");
        userAddress.setBounds(100, 160, 100, 20);
        panel.add(userAddress);

        address = new JLabel();
        address.setBounds(240, 160, 200, 20);
        panel.add(address);

        try {
            connectDatabase c = new connectDatabase();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meternumber.getSelectedItem()+"'");
            while(rs.next()) {
                name.setText(rs.getString("name"));
                address.setText(rs.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        meternumber.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    connectDatabase c = new connectDatabase();
                    ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meternumber.getSelectedItem()+"'");
                    while(rs.next()) {
                        name.setText(rs.getString("name"));
                        address.setText(rs.getString("address"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JLabel city = new JLabel("Units Consumed");
        city.setBounds(100, 200, 100, 20);
        panel.add(city);

        tfunits = new JTextField();
        tfunits.setBounds(240, 200, 200, 20);
        panel.add(tfunits);

        JLabel state = new JLabel("Month");
        state.setBounds(100, 240, 100, 20);
        panel.add(state);

        cmonth = new Choice();
        cmonth.setBounds(240, 240, 200, 20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        panel.add(cmonth);

        next = new JButton("Submit");
        next.setBounds(120, 350, 100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        panel.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 350, 100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());

        add(panel, "Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String meter = meternumber.getSelectedItem();
            String units = tfunits.getText();
            String month = cmonth.getSelectedItem();

            int totalBill = 0;
            int unit_consumed = Integer.parseInt(units);

            String query = "select * from tax";

            try {
                connectDatabase c = new connectDatabase();
                ResultSet rs = c.s.executeQuery(query);

                while(rs.next()) {
                    totalBill += unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                    totalBill += Integer.parseInt(rs.getString("meter_rent"));
                    totalBill += Integer.parseInt(rs.getString("service_tax"));
                    totalBill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
                    totalBill += Integer.parseInt(rs.getString("fixed_tax"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String query2 = "insert into bill values('"+meter+"', '"+month+"', '"+units+"', '"+totalBill+"', 'Not Paid')";

            try {
                connectDatabase c  =  new connectDatabase();
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new calcBIll();
    }
}
