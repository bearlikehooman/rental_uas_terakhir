package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Registrasi extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Email;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrasi frame = new Registrasi();
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
	public Registrasi() {
		setTitle("Registrasi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblName.setBounds(10, 64, 108, 41);
		contentPane.add(lblName);
		
		Name = new JTextField();
		Name.setBounds(128, 73, 285, 26);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEmail.setBounds(10, 107, 108, 41);
		contentPane.add(lblEmail);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(128, 116, 285, 26);
		contentPane.add(Email);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPassword.setBounds(10, 145, 108, 41);
		contentPane.add(lblPassword);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(128, 154, 285, 26);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uas_Database", "root", "");
					PreparedStatement ps = (PreparedStatement) conn.prepareStatement("insert into admin( name, email, password) values(?,?,?);");
					ps.setString(1, Name.getText());
					ps.setString(2, Email.getText());
					ps.setString(3, pass.getText());
					int x = ps.executeUpdate();
					if (x>0) {
						JOptionPane.showMessageDialog(null, "Registration done sucessfully");
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "Registration Failed");
					}
					conn.close();
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(128, 213, 103, 30);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Cancel");
				if(JOptionPane.showConfirmDialog(frame, "Are You Sure to Cancel ? ", "Cancel", 
				JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCancel.setBounds(265, 213, 103, 30);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("Registrasi Admin");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1.setBounds(10, 22, 403, 31);
		contentPane.add(lblNewLabel_1);
	}
}
