package Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class Daftar extends JFrame {
    private JTable table;
    private String[] tablecolumns={"ID","CD's Name", "Quantity", "Price", "Status"};
    private DefaultTableModel identitas;
    JScrollPane SP;
    JButton back;
    JPanel panel;


    public Daftar() {
        setTitle("Daftar Customer");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(600, 500);

        table = new JTable(){
            @Override
            public boolean isCellEditable(int data, int column) {
                return false;
            }
        };
        panel = new JPanel();
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        identitas = new DefaultTableModel(new Object[][] {},tablecolumns);
        table.setModel(identitas);
        SP = new JScrollPane(table);
        add(SP);
        SP.setBounds(10,10,450,100);
        back = new JButton("Back");
        back.addActionListener(new bacbtn());
        back.setBounds(10,10,100,40);
        showlist();
        add(panel);
        panel.setLayout(null);
        panel.setBounds(10,300,650,200);
        panel.add(back);

    }
    class bacbtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Panel2();
            close();
        }
    }

    private void showlist (){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Penyewa");
        model.addColumn("Judul CD");
        model.addColumn("Harga");
        model.addColumn("Rent Date");
        model.addColumn("Due Date");

        try {
            String sql = "SELECT * FROM customer";
            java.sql.Connection conn =(Connection)Konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()){

                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
            }
            table.setModel(model);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void close (){
        WindowEvent winClose = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClose);
    }


}

