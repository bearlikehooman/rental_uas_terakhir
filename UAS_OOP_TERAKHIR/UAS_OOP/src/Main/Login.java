package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("LOGIN ADMIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Admin");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 414, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(23, 94, 89, 27);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(134, 95, 276, 29);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(23, 143, 89, 27);
		contentPane.add(lblNewLabel_1_1);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(134, 144, 276, 29);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uas_Database", "root", "");
					Statement stmt =conn.createStatement();
					String sql="select * from admin where email='"+username.getText()+"' and password ='" +pass.getText()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						Panel2 panel2 = new Panel2();
						panel2.setVisible(true);
					}
					else 
						JOptionPane.showMessageDialog(null, "Incorrect ussername and password...");	
					conn.close();
					
				} catch(Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton.setBounds(131, 216, 89, 30);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("EXIT");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want Exit", "EXIT", 
				JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnExit.setBounds(263, 216, 89, 30);
		contentPane.add(btnExit);
		setVisible(true);
	}

}
