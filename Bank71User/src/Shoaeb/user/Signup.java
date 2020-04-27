package Shoaeb.user;




import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JDesktopPane;

import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JCheckBox;





import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Signup extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private JTextField ps;
	private JTextField eml;
	private JTextField mn;
	private JTextField ad;
	private JTextField path;
	private JTextField txtSignup;
	byte[] person=null;
    String filename=null;
    JCheckBox cb;
    private JTextField al;
    private JTextField txtCancel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Signup dialog = new Signup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Signup() {
		setType(Type.NORMAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Signup");
		setResizable(false);
		setBounds(500, 100, 382, 457);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		name = new JTextField();
		name.setBounds(114, 37, 164, 31);
		contentPanel.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(26, 37, 77, 31);
		contentPanel.add(lblNewLabel);
		
		ps = new JTextField();
		ps.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(ps.getText().length()==3){
					 al.setForeground(Color.MAGENTA);
						al.setText("Poor");
						
					}
					else if(ps.getText().length()>3 && ps.getText().length()<5){
						al.setForeground(Color.BLUE);
						al.setText("Midium");
						
					}
					else if(ps.getText().length()>=5){
						al.setForeground(Color.green);
						al.setText("Strong");
						
					}
					else{
						al.setForeground(Color.RED);
						al.setText("Wrong");
					}
			}
		});
		ps.setColumns(10);
		ps.setBounds(114, 93, 164, 31);
		contentPanel.add(ps);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(26, 93, 77, 31);
		contentPanel.add(lblPassword);
		
		eml = new JTextField();
		eml.setColumns(10);
		eml.setBounds(114, 145, 164, 31);
		contentPanel.add(eml);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(26, 145, 77, 31);
		contentPanel.add(lblEmail);
		
		mn = new JTextField();
		mn.setColumns(10);
		mn.setBounds(114, 199, 164, 31);
		contentPanel.add(mn);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMobile.setBounds(26, 199, 77, 31);
		contentPanel.add(lblMobile);
		
		ad = new JTextField();
		ad.setColumns(10);
		ad.setBounds(114, 252, 164, 31);
		contentPanel.add(ad);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(26, 252, 77, 31);
		contentPanel.add(lblAddress);
		
		JLabel lblPhoto = new JLabel("Photograph");
		lblPhoto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhoto.setBounds(26, 304, 86, 31);
		contentPanel.add(lblPhoto);
		
		JButton btnNewButton = new JButton("Browse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				JFileChooser ch=new JFileChooser();
				ch.showOpenDialog(null);
				java.io.File f=ch.getSelectedFile();
				filename=f.getAbsolutePath();
				path.setText(filename);
				
					
					
					FileInputStream fis=new FileInputStream(f);
					ByteArrayOutputStream bos=new ByteArrayOutputStream();
					byte[] buf=new byte[1024];
					for(int read;(read=fis.read(buf))!=-1;){
						bos.write(buf, 0,read);
						
					}
					person=bos.toByteArray();
				}
				catch(Exception ec){
					//JOptionPane.showMessageDialog(null,"Failed To load Try Again "+ec);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(123, 304, 89, 31);
		contentPanel.add(btnNewButton);
		
		path = new JTextField();
		path.setForeground(new Color(255, 255, 255));
		path.setBackground(new Color(0, 128, 0));
		path.setFont(new Font("Tahoma", Font.BOLD, 12));
		path.setEditable(false);
		path.setText("Path..");
		path.setBounds(217, 304, 102, 31);
		contentPanel.add(path);
		path.setColumns(10);
		
		txtSignup = new JTextField();
		txtSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Boolean a,b,c;
				a=mobile();
				b=email();
				c=data();
				if(a==true && b==true && c==true){
				
				String from ="avirtualbank@gmail.com";
		        String pass = "admin.bank";
		        String[] to ={ eml.getText() }; // list of recipient email addresses
		        String subject = "Bank71";
		        String name1 =name.getText();
		        String code=Code.getcode();
		        String body="Hi "+name1+"\nYour Code is "+ code;
		        Email.send1(from, pass, to, subject, body);
		        String ver=JOptionPane.showInputDialog("A verification code was sent to "+eml.getText()+"\nEnter the code to Complete Sign up..");
		        if(ver.equals(code)){
		        	JOptionPane.showMessageDialog(null,"Code is correct ,Please wait for Conformation messege, Press ok");
		        	insert();
		        }
		        else{
		        	JOptionPane.showMessageDialog(null, "Wrong code please try again");
		        }
		        
				}
				else
					JOptionPane.showMessageDialog(null, "please fillup the from carefully");
			}
		});
		txtSignup.setBackground(new Color(0, 128, 0));
		txtSignup.setForeground(new Color(255, 255, 255));
		txtSignup.setHorizontalAlignment(SwingConstants.CENTER);
		txtSignup.setText("Signup");
		txtSignup.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtSignup.setEditable(false);
		txtSignup.setBounds(114, 376, 103, 41);
		contentPanel.add(txtSignup);
		txtSignup.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(78, 376, 30, 41);
		contentPanel.add(lblNewLabel_1);
	    cb = new JCheckBox("I accept the terms & Conditions");
		cb.setBackground(new Color(0, 128, 0));
		cb.setFont(new Font("Tahoma", Font.BOLD, 11));
		cb.setForeground(Color.WHITE);
		cb.setBounds(114, 342, 205, 27);
		contentPanel.add(cb);
		
		al = new JTextField();
		al.setFont(new Font("Tahoma", Font.BOLD, 12));
		al.setBackground(new Color(224, 255, 255));
		al.setEditable(false);
		al.setBounds(288, 98, 78, 20);
		contentPanel.add(al);
		al.setColumns(10);
		
		txtCancel = new JTextField();
		txtCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		txtCancel.setText("Cancel");
		txtCancel.setHorizontalAlignment(SwingConstants.CENTER);
		txtCancel.setForeground(Color.WHITE);
		txtCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtCancel.setEditable(false);
		txtCancel.setColumns(10);
		txtCancel.setBackground(new Color(0, 128, 0));
		txtCancel.setBounds(227, 376, 92, 41);
		contentPanel.add(txtCancel);
	}
	boolean mobile(){
		try{
		@SuppressWarnings("unused")
		int mob=Integer.parseInt(mn.getText());
		}
		catch(Exception x){
			JOptionPane.showMessageDialog(null,"invalid number" );
		}
		try {
			if(mn.getText().length()==11 && (mn.getText().startsWith("017") ||
					mn.getText().startsWith("016") || mn.getText().startsWith("018") || 
					mn.getText().startsWith("015") || mn.getText().startsWith("011") || 
					mn.getText().startsWith("019")))
			return true;
			
			else
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
			
	}
	boolean email(){
		try{
		if(eml.getText().endsWith("@gmail.com") || eml.getText().endsWith("@ymail.com") || 
				eml.getText().endsWith("@yahoo.com") || eml.getText().endsWith("@hotmail.com") || eml.getText().endsWith("@live.com") 
				|| eml.getText().endsWith("@email.com") || eml.getText().endsWith("@diu.edu.bd")){
		return true;}
		else
			return false;
		}
		catch(Exception e){
			return false;
		}
	}
	boolean data(){
		try {
			if((filename.endsWith(".jpg") ||filename.endsWith(".gif")
					||filename.endsWith(".png") ) && cb.isSelected()==true &&
					filename!=null && name.getText().length()>1
					&& ad.getText().length()>2 && ps.getText().length()>2 )
				
			 return true;
			
			else
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	void insert(){
		try{
			String from ="avirtualbank@gmail.com";
	        String pass = "admin.bank";
	        String[] to ={ eml.getText() }; // list of recipient email addresses
	        String subject = "Bank71";
	        String name1 =name.getText();
	        String code=Code.getac();
	        String body="Hi "+name1+"\nYour Account number is "+ code;
	        Email.send1(from, pass, to, subject, body);
			String query="insert into User (Ac,Name,Password,Mobile,Address,Email,Balance,Image,Messege) values (?, ?, ?, ?, ?, ?, ?, ?,?)";
			Connection conn=DataBaseConnection.dbConnector();
			
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1,code);
			pst.setString(2,name.getText());
			pst.setString(3,ps.getText());
			pst.setString(4,mn.getText());
			pst.setString(5,ad.getText());
			pst.setString(6,eml.getText());
			pst.setString(7,"00");
			pst.setBytes(8,person);
			pst.setString(9,"Welcome to bank71");
			pst.execute();
		
			JOptionPane.showMessageDialog(null,"SignUp Successfull , Pleasecheck your mail to Get Your Account number");
			pst.close();
			conn.close();
			
			new Login().setVisible(true);
			dispose();
			
		}
		catch(Exception ei){
			JOptionPane.showMessageDialog(null,"Failed To signup Try Again "+ei);
		}
	      
	}
}
