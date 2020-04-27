package Shoaeb.user;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Window.Type;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;
//import shoaeb.bank71.DataBaseConnection;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Forget extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField eml;
    int x=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Forget dialog = new Forget();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Forget() {
		setTitle("Forget Password");
		setType(Type.UTILITY);
		setBounds(450, 250, 451, 201);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(105, 105, 105));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		eml = new JTextField();
		eml.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(x==0){
					eml.setText(null);
				}
				x++;
			}
		});
		eml.setHorizontalAlignment(SwingConstants.CENTER);
		eml.setFont(new Font("Tahoma", Font.BOLD, 15));
		eml.setText("Enter Your Email Address");
		eml.setBounds(44, 34, 344, 33);
		contentPanel.add(eml);
		eml.setColumns(10);
		
		JButton btnNewButton = new JButton("Get Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mail();
			}
		});
		Image img=new ImageIcon(this.getClass().getResource("/privacy.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(124, 81, 184, 48);
		contentPanel.add(btnNewButton);
	}
	void Mail(){
		Connection conn = DataBaseConnection.dbConnector();
		try{
			String query="select Ac,Name,Password from User where Email='"+eml.getText()+"' ";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){

				String from ="email@gmail.com";
		        String pass = "pass";
		        String[] to ={ eml.getText() }; // list of recipient email addresses
		        String subject = "Bank71";
		        String Name=rs.getString("Name");
		        String body="Hi "+Name+  "\nAccount no: "+ rs.getString("Ac")+ "\n Your Password is"+ rs.getString("Password")+ "\nThank you";
		        Email.send1(from, pass, to, subject, body);
		        JOptionPane.showMessageDialog(null, "Hi "+Name+" Your password was send to Your email address");
		        dispose();
		        
		        
			}
			else
				JOptionPane.showMessageDialog(null,"Invalid email address");
			pst.close();
			rs.close();
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Erorr.. sending mail"+e);
		}
		
	}
}
