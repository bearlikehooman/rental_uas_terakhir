package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class DaftarCD extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private static Connection conn;
	private String[] tablecolumns={"ID","CD's Name", "Quantity", "Price", "Status"};
	private DefaultTableModel identitas;
	private CDSearch cdSearch;
	private JTextField idtext;
	private JTextField nametext;
	private JTextField qtytext;
	private JTextField pricetext;
	private JTextField statustext;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DaftarCD frame = new DaftarCD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public DaftarCD() {
		setTitle("Daftar CD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 775, 36);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Nama CD:");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(10, 11, 104, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(70, 8, 202, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		
		try {
			cdSearch = new CDSearch();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cdTitle = textField.getText();

					List<CD> cds = null;

					if (cdTitle != null && cdTitle.trim().length() > 0) {
						cds = cdSearch.searchCDs(cdTitle);
					} else {
						cds = cdSearch.getAllCDs();
					}
					
					CDTableModel model= new CDTableModel(cds);
					table.setModel(model);
			}catch (Exception exc) {
				JOptionPane.showMessageDialog(DaftarCD.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
			}
		} 
	});
		btnNewButton.setBounds(282, 7, 89, 23);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 466, 320);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				idtext.setText(model.getValueAt(i,0).toString());
				nametext.setText(model.getValueAt(i,1).toString());
				qtytext.setText(model.getValueAt(i,2).toString());
				pricetext.setText(model.getValueAt(i,3).toString());
				statustext.setText(model.getValueAt(i,4).toString());
			}
		});
	
		identitas = new DefaultTableModel(new Object[][] {},tablecolumns);
		table.setModel(identitas);
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("create new");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					koneksi();
					String newquery = "insert into cd(idCD, title, qty, price, status) values(?,?,?,?,?)";
					PreparedStatement getstatement = conn.prepareStatement(newquery);
					getstatement.setString(1, idtext.getText());
					getstatement.setString(2, nametext.getText());
					getstatement.setString(3, qtytext.getText());
					getstatement.setString(4, pricetext.getText());
					getstatement.setString(5, statustext.getText());
					
		            getstatement.executeUpdate();
		            DefaultTableModel model = (DefaultTableModel)table.getModel();
		            model.setRowCount(0);
		            show_cd();
		            JOptionPane.showMessageDialog(null, "Inserted Sucessfully!");
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(32, 368, 103, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					koneksi();
					int row = table.getSelectedRow();
					String value = (table.getModel().getValueAt(row, 0).toString());
					String updatequery = "UPDATE cd SET idCD=?, title=?, qty=?, price=?, status=? where idCD="+value;
					PreparedStatement updatestatement = conn.prepareStatement(updatequery);
					updatestatement.setString(1, idtext.getText());
					updatestatement.setString(2, nametext.getText());
					updatestatement.setString(3, qtytext.getText());
					updatestatement.setString(4, pricetext.getText());
		            updatestatement.setString(5, statustext.getText());
		            updatestatement.executeUpdate();
		            DefaultTableModel model = (DefaultTableModel)table.getModel();
		            model.setRowCount(0);
		            show_cd();
		            JOptionPane.showMessageDialog(null, "Updated Sucessfully!");
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(156, 368, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					koneksi();
					int row = table.getSelectedRow();
					String value = (table.getModel().getValueAt(row, 0).toString());;
					String deletequery ="DELETE FROM cd where idCD="+value;
					PreparedStatement deletestatement = conn.prepareStatement(deletequery);
					deletestatement.executeUpdate();
					DefaultTableModel model = (DefaultTableModel)table.getModel();
		            model.setRowCount(0);
		            show_cd();
		            JOptionPane.showMessageDialog(null, "Deleted Sucessfully!");
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(274, 368, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("rent");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String[] simpan = {idtext.getText(), nametext.getText(), qtytext.getText(), pricetext.getText(), statustext.getText()};
					Check ch= new Check();
					ch.judul.setText(nametext.getText());
					ch.total.setText(pricetext.getText());
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(387, 368, 89, 23);
		contentPane.add(btnNewButton_4);
		
		
		JLabel id = new JLabel("ID");
		id.setVerticalAlignment(SwingConstants.TOP);
		id.setHorizontalAlignment(SwingConstants.LEFT);
		id.setFont(new Font("Tahoma", Font.PLAIN, 12));
		id.setBounds(486, 49, 18, 15);
		contentPane.add(id);
		
		idtext = new JTextField();
		idtext.setHorizontalAlignment(SwingConstants.LEFT);
		idtext.setColumns(40);
		idtext.setBounds(559, 47, 206, 20);
		contentPane.add(idtext);
		
		JLabel lblCdsName = new JLabel("CD's Name");
		lblCdsName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCdsName.setBounds(486, 83, 63, 15);
		contentPane.add(lblCdsName);
		
		nametext = new JTextField();
		nametext.setColumns(40);
		nametext.setBounds(559, 78, 205, 43);
		contentPane.add(nametext);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantity.setBounds(486, 134, 56, 15);
		contentPane.add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrice.setBounds(486, 160, 50, 15);
		contentPane.add(lblPrice);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStatus.setBounds(486, 191, 50, 15);
		contentPane.add(lblStatus);
		
		qtytext = new JTextField();
		qtytext.setColumns(40);
		qtytext.setBounds(559, 132, 206, 20);
		contentPane.add(qtytext);
		
		pricetext = new JTextField();
		pricetext.setColumns(40);
		pricetext.setBounds(559, 158, 206, 20);
		contentPane.add(pricetext);
		
		statustext = new JTextField();
		statustext.setColumns(40);
		statustext.setBounds(559, 189, 206, 20);
		contentPane.add(statustext);
		show_cd();
	}
	
	private static void koneksi() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uas_database", "root", "");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public ArrayList<CD> cdList(){
		ArrayList<CD> cdsList = new ArrayList<>();
		try {
			koneksi();
			Statement statement = conn.createStatement();
			String displayquery="SELECT * FROM cd";
			ResultSet rs = statement.executeQuery(displayquery);
			CD cd;
			while(rs.next()){
				cd= new CD(rs.getInt("idCD"), rs.getString("title"), rs.getString("qty"), rs.getString("price"), rs.getString("status"));
				cdsList.add(cd);
			}
		}catch(Exception e){
			e.printStackTrace();
        }
		return cdsList;
	}
	
	public void show_cd() {
		ArrayList<CD> list = cdList();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		Object[] row = new Object[5];
		for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getid();
            row[1]=list.get(i).getname();
            row[2]=list.get(i).getqty();
            row[3]=list.get(i).getprice();
            row[4]=list.get(i).getstatus();
            model.addRow(row);
        }
	}
}
