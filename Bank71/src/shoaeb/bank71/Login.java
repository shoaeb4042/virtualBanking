package shoaeb.bank71;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SplashScreen;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Font;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

@SuppressWarnings({ "unused", "serial" })
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField Time;
	private JPasswordField pss;
	JLabel num,load;
	private JLabel lblQuit;
	private JLabel lblEnterPassword;
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
		URL iconURL = getClass().getResource("/logo.png");
		// iconURL is null when not found
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
		setTitle("Admin Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 643, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel back = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/bg.jpg")).getImage();
		
		Time = new JTextField();
		Time.setForeground(new Color(255, 255, 255));
		Time.setFont(new Font("Tahoma", Font.BOLD, 18));
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
		Date date = new Date();
		Time.setText("  "+dateFormat.format(date));
		//System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
		Time.setBackground(new Color(124, 252, 0));
		Time.setEditable(false);
		Time.setBounds(405, 0, 170, 45);
		contentPane.add(Time);
		Time.setColumns(10);
		
		pss = new JPasswordField();
		pss.setFont(new Font("Tahoma", Font.BOLD, 14));
		pss.setBounds(189, 160, 195, 34);
		contentPane.add(pss);
		
		JLabel login = new JLabel("Login");
		login.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(pss.getText().equals("bank71")){
				new Home().setVisible(true);
				dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Wrong password");
			}
		});
		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("Tahoma", Font.BOLD, 16));
		Image img1= new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		login.setIcon(new ImageIcon(img1));
		login.setBounds(408, 148, 97, 59);
		contentPane.add(login);
		
		 load = new JLabel("");
		load.setForeground(Color.WHITE);
		load.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		load.setBounds(200, 234, 97, 45);
		contentPane.add(load);
		
		 num = new JLabel("");
		num.setForeground(Color.WHITE);
		num.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		num.setBounds(317, 239, 76, 34);
		contentPane.add(num);
		
		lblQuit = new JLabel("Quit");
		lblQuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		Image img3= new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		lblQuit.setIcon(new ImageIcon(img3));
		lblQuit.setForeground(Color.WHITE);
		lblQuit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuit.setBounds(529, 375, 83, 40);
		contentPane.add(lblQuit);
		
		lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterPassword.setForeground(new Color(255, 255, 255));
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterPassword.setBounds(184, 98, 200, 50);
		contentPane.add(lblEnterPassword);
		back.setIcon(new ImageIcon(img));
		back.setBounds(0, 0, 637, 426);
		contentPane.add(back);
	}
}
