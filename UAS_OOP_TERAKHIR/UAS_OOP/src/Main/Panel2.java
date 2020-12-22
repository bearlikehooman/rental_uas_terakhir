package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel2 frame = new Panel2();
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
	public Panel2() {
		setTitle("Welcome !");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Halo, apa yang ingin anda lakukan ?");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(29, 11, 395, 78);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Daftar CD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DaftarCD cd= new DaftarCD();
				cd.setVisible(true);
			}
		});
		JButton btnNewButton1 = new JButton("Customer");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Daftar();
			}
		});
		btnNewButton1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton1.setBounds(243, 118, 135, 30);
		contentPane.add(btnNewButton1);
		
		JButton btnDaftarCustomer = new JButton("Daftar CD");
		btnDaftarCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DaftarCD cd= new DaftarCD();
				cd.setVisible(true);
			}
		});
		btnDaftarCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnDaftarCustomer.setBounds(29, 118, 162, 30);
		contentPane.add(btnDaftarCustomer);
		
		JButton btnCreatevNewAdmin = new JButton("Create New Admin");
		btnCreatevNewAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrasi regist = new Registrasi();
				regist.setVisible(true);
			}
		});
		btnCreatevNewAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCreatevNewAdmin.setBounds(29, 181, 162, 30);
		contentPane.add(btnCreatevNewAdmin);
	}

}
