package com.deepam.project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class project extends JFrame implements ActionListener {

    String atype, meter;

    project() {

        this.atype = atype;
        this.meter = meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2 = background.getImage().getScaledInstance(1920, 1080 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Account");
        menuBar.add(menu);

        JMenuItem menuItem = new JMenuItem("New Customer");
        menuItem.setFont(new Font("monospaced" , Font.PLAIN, 12));
        menuItem.setBackground(Color.WHITE);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20 , 20 , Image.SCALE_DEFAULT);
        menuItem.setIcon(new ImageIcon(image1));
        menuItem.setIcon(new ImageIcon(image1));
        menuItem.setMnemonic('N');
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menu.add(menuItem);


        JMenuItem customerDetails = new JMenuItem("Customer Details");
        customerDetails.setFont(new Font("monospaced" , Font.PLAIN, 12));
        customerDetails.setBackground(Color.WHITE);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20 , 20 , Image.SCALE_DEFAULT);
        customerDetails.setIcon(new ImageIcon(image2));
        customerDetails.setIcon(new ImageIcon(image2));
        customerDetails.setMnemonic('D');
        customerDetails.addActionListener(this);
        customerDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        menu.add(customerDetails);


        JMenuItem depositDetails = new JMenuItem("Deposit Details");
        depositDetails.setFont(new Font("monospaced" , Font.PLAIN, 12));
        depositDetails.setBackground(Color.WHITE);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20 , 20 , Image.SCALE_DEFAULT);
        depositDetails.setIcon(new ImageIcon(image3));
        depositDetails.setIcon(new ImageIcon(image3));
        depositDetails.setMnemonic('M');
        depositDetails.addActionListener(this);
       depositDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        menu.add(depositDetails);


        JMenuItem calcBill = new JMenuItem("Calculate Bill");
        calcBill.setFont(new Font("monospaced", Font.PLAIN, 12));
        calcBill.setBackground(Color.WHITE);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calcBill.setIcon(new ImageIcon(image4));
        calcBill.setMnemonic('B');
        calcBill.addActionListener(this);
        calcBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        menu.add(calcBill);


        JMenu info = new JMenu("Information");
        info.setForeground(Color.RED);
        menuBar.add(info);

        JMenuItem updateinfo = new JMenuItem("Update Information");
        updateinfo.setFont(new Font("monospaced", Font.PLAIN, 12));
        updateinfo.setBackground(Color.WHITE);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateinfo.setIcon(new ImageIcon(image5));
        updateinfo.setMnemonic('P');
        updateinfo.addActionListener(this);
        updateinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        info.add(updateinfo);

        JMenuItem viewinfo = new JMenuItem("View Information");
        viewinfo.setFont(new Font("monospaced", Font.PLAIN, 12));
        viewinfo.setBackground(Color.WHITE);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(image6));
        viewinfo.setMnemonic('L');
        viewinfo.addActionListener(this);
        viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        info.add(viewinfo);


        JMenu user = new JMenu("User");
        user.setForeground(Color.BLUE);
        menuBar.add(user);



        JMenuItem payBill = new JMenuItem("Pay Bill");
        payBill.setFont(new Font("monospaced", Font.PLAIN, 12));
        payBill.setBackground(Color.WHITE);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        payBill.setIcon(new ImageIcon(image7));
        payBill.setMnemonic('R');
        payBill.addActionListener(this);
        payBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        user.add(payBill);

        JMenuItem billDetails = new JMenuItem("Bill Details");
        billDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        billDetails.setBackground(Color.WHITE);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billDetails.setIcon(new ImageIcon(image8));
        billDetails.setMnemonic('B');
        billDetails.addActionListener(this);
        billDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        user.add(billDetails);

        JMenu report = new JMenu("Report");
        report.setForeground(Color.RED);
        menuBar.add(report);



        JMenuItem generateBill = new JMenuItem("Generate Bill");
        generateBill.setFont(new Font("monospaced", Font.PLAIN, 12));
        generateBill.setBackground(Color.WHITE);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generateBill.setIcon(new ImageIcon(image9));
        generateBill.setMnemonic('G');
        generateBill.addActionListener(this);
        generateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        report.add(generateBill);

        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        menuBar.add(utility);



        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced", Font.PLAIN, 12));
        notepad.setBackground(Color.WHITE);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image10));
        notepad.setMnemonic('K');
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
        utility.add(notepad);


        JMenuItem calc = new JMenuItem("Calculator");
        calc.setFont(new Font("monospaced", Font.PLAIN, 12));
        calc.setBackground(Color.WHITE);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calc.setIcon(new ImageIcon(image10));
        calc.setMnemonic('C');
        calc.addActionListener(this);
        calc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        utility.add(calc);

        JMenu menuExit = new JMenu("Exit");
        menuExit.setForeground(Color.RED);
        menuBar.add(menuExit);



        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("monospaced", Font.PLAIN, 12));
        exit.setBackground(Color.WHITE);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image12));
        exit.setMnemonic('W');
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        menuExit.add(exit);


        setLayout(new FlowLayout());

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("New Customer")) {
            new newCustomer();
        } else if (msg.equals("Customer Details")) {
//            new CustomerDetails();
        } else if (msg.equals("Deposit Details")) {
//            new DepositDetails();
        } else if (msg.equals("Calculate Bill")) {
            new calcBIll();
        } else if (msg.equals("View Information")) {
            new meterInfo(meter);
        } else if (msg.equals("Update Information")) {
//            new UpdateInformation(meter);
        } else if (msg.equals("Bill Details")) {
//            new BillDetails(meter);
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Exit")) {
            setVisible(false);
//            new Login();
        } else if (msg.equals("Pay Bill")) {
//            new PayBill(meter);
        } else if (msg.equals("Generate Bill")) {
//            new GenerateBill(meter);
        }
    }


    public static void main(String[] args) {

        new project();
    }
}
