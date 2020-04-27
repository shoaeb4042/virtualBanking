package Shoaeb.user;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;



//import shoaeb.bank71.DataBaseConnection;
import net.proteanit.sql.DbUtils;
//import shoaeb.bank71.DataBaseConnection;




import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField ac;
	private JPasswordField ps;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblPassword;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPanel panel_2;
	JCheckBox cb;
	int x;
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
	Connection conn=null;
	private JLabel lblNewLabel_5;
	
	public Login() {
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		URL iconURL = getClass().getResource("/logo.png");
		// iconURL is null when not found
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
		setTitle("User Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 366, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ac = new JTextField();
		ac.setFont(new Font("Tahoma", Font.BOLD, 13));
		ac.setBounds(118, 107, 152, 29);
		contentPane.add(ac);
		ac.setColumns(10);
		
		ps = new JPasswordField();
		ps.setFont(new Font("Tahoma", Font.ITALIC, 13));
		ps.setBounds(118, 164, 152, 29);
		contentPane.add(ps);
		
		cb = new JCheckBox("Remember Me");
		cb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(cb.isSelected()){
			x=JOptionPane.showConfirmDialog(null, "Dow You want to save Your password?");
			
			if(x==0)
				cbox(ac.getText(),ps.getText());
			else
				cb.setSelected(false);
				}
			}
		});
		cb.setForeground(new Color(255, 255, 255));
		cb.setBackground(new Color(0, 128, 0));
		cb.setFont(new Font("Tahoma", Font.BOLD, 11));
		cb.setBounds(118, 207, 120, 23);
		contentPane.add(cb);
		
		panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(118, 241, 120, 23);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Forgot Password");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Forget().setVisible(true);
				
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 113, 23);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 0));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(160, 294, 92, 36);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(cb.isSelected()==false)
				cbox("","");
				login();
			}
		});
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(0, 0, 92, 36);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		
		lblNewLabel_2 = new JLabel("Account No.");
		lblNewLabel_2.setForeground(new Color(0, 0, 51));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(16, 105, 92, 36);
		contentPane.add(lblNewLabel_2);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 0, 51));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(16, 162, 80, 36);
		contentPane.add(lblPassword);
		
		panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBackground(new Color(0, 204, 0));
		panel_2.setBounds(50, 31, 267, 46);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_3 = new JLabel(" Please Login To Access Your Account");
		lblNewLabel_3.setBounds(0, 0, 260, 46);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setForeground(new Color(128, 0, 128));
		Image img=new ImageIcon(this.getClass().getResource("/bg.jpg")).getImage();
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Signup().setVisible(true);
				dispose();
			}
		});
		Image sign=new ImageIcon(this.getClass().getResource("/signup.png")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(sign));
		lblNewLabel_5.setBounds(258, 204, 102, 60);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_4.setIcon(new ImageIcon(img));
		lblNewLabel_4.setBounds(0, 0, 360, 423);
		contentPane.add(lblNewLabel_4);
		cbox1();
	}
	public  void login(){
		conn=DataBaseConnection.dbConnector();
		try{
			String query="select * from User where Ac='"+ac.getText()+"' and Password='"+ps.getText()+"' ";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				pst.close();
				rs.close();
				cokies(ac.getText());
				
				new Menu().setVisible(true);
				dispose();
			}
			else
				JOptionPane.showMessageDialog(null,"Wrong password");
			pst.close();
			rs.close();
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Erorr.."+e);
		}
		
	}
	
	 void cbox(String a,String b) {
		 
		 
			conn=DataBaseConnection.dbConnector();
			try {
				String sql="Update remember set Ac='"+a+"',Password='"+b+"' where key='1' ";
				
				PreparedStatement pst;
				pst = conn.prepareStatement(sql);
				
				pst.execute();
				pst.close();
				
				//JOptionPane.showMessageDialog(null, "Successfully Updated");
				//return 0;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e);
				//return 0;
			}
			
			
		}
	 public  void cbox1(){
			conn=DataBaseConnection.dbConnector();
			try{
				String query="select * from remember";
				PreparedStatement pst=conn.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				while(rs.next()){
					ac.setText(rs.getString("Ac"));
					ps.setText(rs.getString("Password"));
				}
				pst.close();
				rs.close();
				
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,"Erorr.."+e);
			}
			
		}
	 
	 void cokies(String a) {
		 
		 
			conn=DataBaseConnection.dbConnector();
			try {
				String sql="Update Cokies set Ac='"+a+"'";
				
				PreparedStatement pst;
				pst = conn.prepareStatement(sql);
				
				pst.execute();
				pst.close();
				
				//JOptionPane.showMessageDialog(null, "Successfully Updated"+a);
				//return 0;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "here "+e);
				//return 0;
			}
			
			
		}
}
