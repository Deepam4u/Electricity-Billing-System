package com.deepam.project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class meterInfo extends JFrame implements ActionListener {

    JButton next;
    Choice meterlocation, metertype, phasecode, billtype;
    String meterNumber;
    meterInfo(String meterNumber) {

        this.meterNumber = meterNumber;

        setSize(700, 500);
        setLocation(600, 300);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(193, 224, 234));
        add(panel);

        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(200, 18, 200, 25);
        heading.setFont(new Font("Helvetica", Font.PLAIN, 24));
        panel.add(heading);

        JLabel meterNo = new JLabel("Meter No.");
        meterNo.setBounds(100, 80, 100, 20);
        panel.add(meterNo);

        JLabel meterNumberField = new JLabel(meterNumber);
        meterNumberField.setBounds(240, 80, 100, 20);
        panel.add(meterNumberField);

        JLabel meterNum = new JLabel("Meter Location");
        meterNum.setBounds(100, 120, 100, 20);
        panel.add(meterNum);

        meterlocation = new Choice();
        meterlocation.add("Outside");
        meterlocation.add("Inside");
        meterlocation.setBounds(240, 120, 200, 20);
        panel.add(meterlocation);

        JLabel meterType = new JLabel("Meter Type");
        meterType.setBounds(100, 160, 100, 20);
        panel.add(meterType);

        metertype = new Choice();
        metertype.add("Electric Meter");
        metertype.add("Solar Meter");
        metertype.add("Smart Meter");
        metertype.setBounds(240, 160, 200, 20);
        panel.add(metertype);

        JLabel phaseCode = new JLabel("Phase Code");
        phaseCode.setBounds(100, 200, 100, 20);
        panel.add(phaseCode);

        phasecode = new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        phasecode.setBounds(240, 200, 200, 20);
        panel.add(phasecode);

        JLabel billType = new JLabel("Bill Type");
        billType.setBounds(100, 240, 100, 20);
        panel.add(billType);

        billtype = new Choice();
        billtype.add("Normal");
        billtype.add("Industial");
        billtype.setBounds(240, 240, 200, 20);
        panel.add(billtype);

        JLabel days = new JLabel("Days");
        days.setBounds(100, 280, 100, 20);
        panel.add(days);

        JLabel billDays = new JLabel("30 Days");
        billDays.setBounds(240, 280, 100, 20);
        panel.add(billDays);

        JLabel notes = new JLabel("Note");
        notes.setBounds(100, 320, 100, 20);
        panel.add(notes);

        JLabel billNote = new JLabel("By Default Bill is calculated for 30 days only");
        billNote.setBounds(240, 320, 500, 20);
        panel.add(billNote);

        next = new JButton("Submit");
        next.setBounds(220, 390, 100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        panel.add(next);

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
            String meter = meterNumber;
            String location = meterlocation.getSelectedItem();
            String type = metertype.getSelectedItem();
            String code = phasecode.getSelectedItem();
            String typebill = billtype.getSelectedItem();
            String days = "30";

            String query = "insert into meter_info values('"+meter+"', '"+location+"', '"+type+"', '"+code+"', '"+typebill+"', '"+days+"')";

            try {
                connectDatabase c = new connectDatabase();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Meter Information Added Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new meterInfo("");
    }

}
