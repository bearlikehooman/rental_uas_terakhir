package Main;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Check extends JFrame {
    JLabel Dtanggal,tanggal,Dhari,DJudul,Dnama, Dharga, judul,title,total,duedate,Dtanggal2,alarm;
    JTextField hari,nama;

    Date now = new Date();
    SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
    JButton previous,save,result;
	public String sql;


    public Check () {
        setTitle("Rent");
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        previous = new JButton("Previous");
        save = new JButton("Save");
        result = new JButton("Total");

        alarm=new JLabel();
        alarm.setForeground(Color.red);
        tanggal=new JLabel();
        nama=new JTextField();
        judul=new JLabel();
        title=new JLabel();
        total=new JLabel();
        hari=new JTextField();
        hari.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c= e.getKeyChar();
                if (!(Character.isDigit(c)|| c== KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE) ){
                    getToolkit().beep();
                    e.consume();
                    alarm.setText("Input number only!");
                } else {
                    alarm.setText("");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {


            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        duedate=new JLabel();
        add(alarm);
        alarm.setBounds(180,125,180,20);
        tanggal.setText(sf.format(now));
        Dtanggal2 = new JLabel("Due date");
        Dnama = new JLabel("Customer name                   ");
        Dharga = new JLabel("Total price                 ");
        DJudul = new JLabel("Title                 ");
        Dhari=new JLabel("Hari                     ");
        Dtanggal = new JLabel("Rent date        ");

        add(Dnama);
        Dnama.setBounds(30,20,180,40);
        add(DJudul);
        DJudul.setBounds(30,60,180,40);
        add(Dhari);
        Dhari.setBounds(30,100,180,40);
        add(Dharga);
        Dharga.setBounds(30,140,180,40);
        add(Dtanggal);
        Dtanggal.setBounds(30,180,180,40);
        add(Dtanggal2);
        Dtanggal2.setBounds(30,220,180,40);

        add(nama);
        nama.setBounds(180,30,180,20);
        add(judul);
        judul.setBounds(180,60,180,40);
        add(hari);
        hari.setBounds(180,110,180,20);
        add(total);
        total.setBounds(180,140,180,40);
        add(tanggal);
        tanggal.setBounds(180,180,180,40);
        add(duedate);
        duedate.setBounds(180,220,180,40);


        add(previous);
        previous.setBounds(30,270,90,30);
        add(save);
        save.setBounds(140,270,90,30);
        save.addActionListener(new savedata());
        add(result);
        result.setBounds(250,270,90,30);
        result.addActionListener(new resultset());
    }

    class resultset implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar cal = new GregorianCalendar();
            int day = cal.get(Calendar.DAY_OF_MONTH) + Integer.parseInt(hari.getText());
            int month = cal.get(Calendar.MONTH) + 1;
            int year = cal.get(Calendar.YEAR);

            if (day >374){
                day = day-376;
                year = year+1;
            }
            if (month == 1 && day > 31) {
                int newmon = 2;
                int newday = day - 31;
                duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
            }
            if (month == 2 && day > 28) {
                int newmon = 3;
                int newday = day - 28;
                duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
            }
            if (month == 3 && day > 31) {
                int newmon = 4;
                int newday = day - 31;
                duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
            }
            if (month == 4 && day > 30) {
                int newmon = 5;
                int newday = day - 30;
                duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
            }
            if (month == 5 && day > 31) {
                int newmon = 6;
                int newday = day - 31;
                duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
            }
            if (month == 6 && day > 30) {
                int newmon = 7;
                int newday = day - 30;
                duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
            }
            if (month == 7 && day > 31) {
                int newmon = 8;
                int newday = day - 31;
                duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
            }
            if (month == 8 && day > 31) {
                int newmon = 9;
                int newday = day - 31;
                duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
            }
            if (month == 9 && day > 30) {
                int newmon = 10;
                int newday = day - 30;
                duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
            }
            if (month == 10 && day > 31) {
                int newmon = 11;
                int newday = day - 31;
                duedate.setText(newday + "-" + newmon + "-" + year);
            }
            if (month == 11 && day > 30) {
                int newmon = 12;
                int newday = day - 30;
                duedate.setText(newday + "-" + newmon + "-" + year);
            }
            if (month == 12 && day > 31) {
                int newmon = 1;
                int newday = day - 31;
                if (newmon == 1 && newday > 31) {
                    newmon = 2;
                    newday = newday - 31;
                    duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
                }
                if (newmon == 2 && newday > 28) {
                    newmon = 3;
                    newday = newday - 28;
                    duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
                }
                if (newmon == 3 && newday > 31) {
                    newmon = 4;
                    newday = newday - 31;
                    duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
                }
                if (newmon == 4 && newday > 30) {
                    newmon = 5;
                    newday = newday - 30;
                    duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
                }
                if (newmon == 5 && newday > 31) {
                    newmon = 6;
                    newday = newday - 31;
                    duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
                }
                if (newmon == 6 && newday > 30) {
                    newmon = 7;
                    newday = newday - 30;
                    duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
                }
                if (newmon == 7 && newday > 31) {
                    newmon = 8;
                    newday = newday - 31;
                    duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
                }
                if (newmon == 8 && newday > 31) {
                    newmon = 9;
                    newday = newday - 31;
                    duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
                }
                if (newmon == 9 && newday > 30) {
                    newmon = 10;
                    newday = newday - 30;
                    duedate.setText(newday + "-" + newmon + "-" + cal.get(Calendar.YEAR));
                }
                if (newmon == 10 && newday > 31) {
                    newmon = 11;
                    newday = newday - 31;
                    duedate.setText(newday + "-" + newmon + "-" + year);
                }
                if (newmon == 11 && newday > 30) {
                    newmon = 12;
                    newday = newday - 30;
                    duedate.setText(newday + "-" + newmon + "-" + year);
                }else {

                    duedate.setText(newday + "-" + newmon + "-" + (cal.get(Calendar.YEAR) + 1));
                }
            } else {
                duedate.setText(day + "-" + month + "-" + year);


            }
        }

    }

    class savedata implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
            	java.sql.Connection conn = (Connection)Konfig.configDB();
				PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                String sql = "INSERT INTO customer (penyewa,titlecd,totalprice,rentdate,duedate) VALUES (?,?,?,?,?)";
                ps.setString(1,nama.getText());
                ps.setString(2,judul.getText());
                ps.setString(3,total.getText());
                ps.setString(4,tanggal.getText());
                ps.setString(5,duedate.getText());
                ps.execute();
                int opt =JOptionPane.showConfirmDialog(null, "DATA DITAMBAHKAN! TAMBAH LAGI?", "R",JOptionPane.YES_NO_OPTION );
                if (opt==0){
                    new DaftarCD();
                    close();
                } else {
                    new Panel2();
                    close();
                }

            } catch (HeadlessException | SQLException a) {
                JOptionPane.showMessageDialog(null, a.getMessage());
            }
        }
    }

    public void close (){
        WindowEvent winClose = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClose);
    }
}

