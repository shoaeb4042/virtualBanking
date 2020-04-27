package shoaeb.bank71;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.SystemColor;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Home extends JFrame {
	JLabel picture;
	private JPanel contentPane;
	private JTable table;
	private JTextField ac;
	private JTextField name;
	private JTextField mail;
	private JTextField mob;
	private JTextField Time;
	private JTextField address;
	//byte[] pix=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	private JTextField taka;
	private JTextField taka2;
	private JTextField txtCashin;
	private JTextField user1;
	public Home() {
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		URL iconURL = getClass().getResource("/logo.png");
		// iconURL is null when not found
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
		setTitle("Control center");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(380, 100, 746, 498);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("Tools");
		mnFile.setForeground(Color.BLACK);
		mnFile.setFont(new Font("Segoe UI", Font.BOLD, 12));
		Image fimg= new ImageIcon(this.getClass().getResource("/tolls1.png")).getImage();
		mnFile.setIcon(new ImageIcon(fimg));
		menuBar.add(mnFile);
		
		JMenu mnNewMenu = new JMenu("Refresh");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 try{
                    loadtable();
                    loaduser();
                    JOptionPane.showMessageDialog(null, "Done");
                     }catch(Exception e1){
                            
                     }
			}
		});
		mnNewMenu.setBackground(Color.WHITE);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		Image help11= new ImageIcon(this.getClass().getResource("/transfer.png")).getImage();
		Image help1= new ImageIcon(this.getClass().getResource("/help.png")).getImage();
		 mnNewMenu.setIcon(new ImageIcon(help11));
		mnFile.add(mnNewMenu);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenu mnNewMenu_1 = new JMenu("About");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 try{
                     String d = "https://www.facebook.com/salehin6";
                    
                    
                     java.awt.Desktop.getDesktop().browse(java.net.URI.create(d));
                     }catch(Exception e1){
                            
                     }
			}
		});
		mnNewMenu_1.setBackground(Color.WHITE);
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		Image help12= new ImageIcon(this.getClass().getResource("/about.png")).getImage();
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
                    String d = "https://www.facebook.com/salehin6";
                   
                   
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(d));
                    }catch(Exception e1){
                           
                    }
			}
		});
		mnHelp.setIcon(new ImageIcon(help1));
		mnHelp.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnHelp.setBackground(Color.WHITE);
		mnFile.add(mnHelp);
		
		JSeparator separator_2 = new JSeparator();
		mnFile.add(separator_2);
		mnNewMenu_1.setIcon(new ImageIcon(help12));
		mnFile.add(mnNewMenu_1);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenu mnNewMenu_2 = new JMenu("Exit");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		mnNewMenu_2.setBackground(Color.WHITE);
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		Image help1w= new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		 mnNewMenu_2.setIcon(new ImageIcon(help1w));
		mnFile.add(mnNewMenu_2);
		
		JMenu mnSearch = new JMenu("Log");
		mnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Log().setVisible(true);
			}
		});
		Image ref1= new ImageIcon(this.getClass().getResource("/log.png")).getImage();
		mnSearch.setIcon(new ImageIcon(ref1));
		mnSearch.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnSearch.setForeground(Color.BLACK);
		menuBar.add(mnSearch);
		
		JMenu mnNewMenu_3 = new JMenu("Send Messege");
		mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Send().setVisible(true);
			}
		});
		mnNewMenu_3.setBackground(Color.WHITE);
		Image mess= new ImageIcon(this.getClass().getResource("/mess.png")).getImage();
		 mnNewMenu_3.setIcon(new ImageIcon(mess));
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_3.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu_3);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy  hh:mm");
		Date date = new Date();
		
		lblNewLabel_1.setText("                                                                     Current Date: "+dateFormat.format(date));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		menuBar.add(lblNewLabel_1);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 39, 334, 370);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setSurrendersFocusOnKeystroke(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getvalue();
			}
		});
		scrollPane.setViewportView(table);
		
		ac = new JTextField();
		ac.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ac.setEditable(false);
		ac.setBounds(76, 167, 96, 20);
		contentPane.add(ac);
		ac.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(76, 198, 96, 20);
		contentPane.add(name);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(76, 229, 96, 20);
		contentPane.add(mail);
		
		mob = new JTextField();
		mob.setColumns(10);
		mob.setBounds(76, 260, 96, 20);
		contentPane.add(mob);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(23, 11, 127, 128);
		contentPane.add(desktopPane);
		
		 picture = new JLabel("New label");
		Image img= new ImageIcon(this.getClass().getResource("/no.png")).getImage();
		picture.setIcon(new ImageIcon(img));
		picture.setBounds(0, 0, 127, 128);
		desktopPane.add(picture);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 196, 49, 20);
		contentPane.add(lblName);
		
		JLabel lblAc = new JLabel("AC");
		lblAc.setForeground(new Color(255, 255, 255));
		lblAc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAc.setBounds(10, 167, 49, 20);
		contentPane.add(lblAc);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(10, 231, 49, 20);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Mobile");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(10, 262, 49, 20);
		contentPane.add(lblAddress);
		
		JLabel lblCurrentStatus = new JLabel("Current Status");
		lblCurrentStatus.setForeground(new Color(255, 255, 255));
		lblCurrentStatus.setBackground(new Color(255, 255, 255));
		lblCurrentStatus.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCurrentStatus.setBounds(293, 2, 156, 29);
		contentPane.add(lblCurrentStatus);
		
		
		JLabel logout = new JLabel(" LogOut");
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Login().setVisible(true);
				dispose();
			}
		});
		logout.setForeground(new Color(255, 255, 255));
		logout.setFont(new Font("Tahoma", Font.BOLD, 12));
		Image img1= new ImageIcon(this.getClass().getResource("/lout.png")).getImage();
		logout.setIcon(new ImageIcon(img1));
		logout.setBounds(631, 70, 83, 29);
		contentPane.add(logout);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Toolkit.getDefaultToolkit().beep();
			}
		});
		Image img1c= new ImageIcon(this.getClass().getResource("/ad.png")).getImage();
		lblAdmin.setIcon(new ImageIcon(img1c));
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAdmin.setBackground(Color.WHITE);
		lblAdmin.setBounds(621, 7, 109, 60);
		contentPane.add(lblAdmin);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(76, 291, 96, 20);
		contentPane.add(address);
		
		JLabel lblAdress = new JLabel("Address");
		lblAdress.setForeground(Color.WHITE);
		lblAdress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdress.setBounds(10, 291, 56, 20);
		contentPane.add(lblAdress);
		
		JLabel bgr = new JLabel("");
		
	
		Image img12= new ImageIcon(this.getClass().getResource("/bg3.jpg")).getImage();
		Image img121= new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 345, 83, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update");
		lblNewLabel.setBounds(0, 0, 74, 35);
		panel.add(lblNewLabel);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//new
				update();
				loadtable();
			}
		});
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setIcon(new ImageIcon(img121));
		Image img11= new ImageIcon(this.getClass().getResource("/del.png")).getImage();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(108, 345, 74, 35);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblBan = new JLabel("Delete");
		lblBan.setBounds(0, 0, 74, 35);
		panel_1.add(lblBan);
		lblBan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				delete();
				loadtable();
			}
		});
		lblBan.setIcon(new ImageIcon(img11));
		lblBan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBan.setForeground(Color.WHITE);
		
		taka = new JTextField();
		taka.setFont(new Font("Tahoma", Font.PLAIN, 20));
		taka.setForeground(Color.WHITE);
		taka.setBackground(Color.BLACK);
		taka.setEditable(false);
		taka.setBounds(580, 231, 150, 38);
		contentPane.add(taka);
		taka.setColumns(10);
		
		taka2 = new JTextField();
		taka2.setBounds(647, 300, 83, 29);
		contentPane.add(taka2);
		taka2.setColumns(10);
		
		JLabel lblTotalBalance = new JLabel("Current Balance BDT.");
		lblTotalBalance.setForeground(Color.WHITE);
		lblTotalBalance.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalBalance.setBounds(568, 189, 162, 35);
		contentPane.add(lblTotalBalance);
		
		JLabel lblCashin_1 = new JLabel("Ammount");
		Image img1d= new ImageIcon(this.getClass().getResource("/cashin.png")).getImage();
		lblCashin_1.setIcon(new ImageIcon(img1d));
		lblCashin_1.setForeground(Color.WHITE);
		lblCashin_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCashin_1.setBounds(554, 297, 90, 35);
		contentPane.add(lblCashin_1);
		
		txtCashin = new JTextField();
		txtCashin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
				double t=Double.parseDouble(taka.getText());
				double t2=Double.parseDouble(taka2.getText());
				if(taka2.getText().length()>=1 && t2>=1000 && t2<=50000){
				double t3=t+t2;
				String t4=Double.toString(t3);
				try {
					String sql="Update Balance set Cash2='"+t4+"' ";
					
					PreparedStatement pst;
					pst = conn.prepareStatement(sql);
					
					pst.execute();
					pst.close();
					loadcash();
					Log(dateFormat.format(date),"Admin","Cashin succesfull. Amount BDT "+t4);
					taka2.setText(null);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
				}
				else
					JOptionPane.showMessageDialog(null, "You Cant Cashin Less Than tk 1000");
				}
				catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, "Enter a valid ammount");
				}
				
			}
		});
		txtCashin.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtCashin.setForeground(Color.WHITE);
		txtCashin.setText("  CASHIN");
		txtCashin.setBackground(Color.BLACK);
		txtCashin.setEditable(false);
		txtCashin.setBounds(604, 363, 90, 35);
		contentPane.add(txtCashin);
		txtCashin.setColumns(10);
		
		user1 = new JTextField();
		user1.setFont(new Font("Tahoma", Font.BOLD, 16));
		user1.setText("Total User:");
		user1.setForeground(Color.WHITE);
		user1.setBackground(Color.BLACK);
		user1.setEditable(false);
		user1.setBounds(580, 132, 150, 46);
		contentPane.add(user1);
		user1.setColumns(10);
		bgr.setIcon(new ImageIcon(img12));
		bgr.setBounds(0, -1, 740, 449);
		contentPane.add(bgr);
		loadtable();
		loaduser();
		loadcash();
		Log(dateFormat.format(date),"Admin","Logged in");


		///thread
		
		/*try {
			Thread x=new Thread(new Runnable(){
				public void run(){
				while(true){
					try {
						Thread.sleep(300);
						 //Toolkit.getDefaultToolkit().beep();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e);
					}
					loadtable();
				}
					
				}
			});
			x.start();
			//x.join();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
		
		}*/
		
	}
	public  void loadtable(){
		conn=DataBaseConnection.dbConnector();
		try{
			String query="select Ac,Name,Email,Mobile from User";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Erorr.."+e);
		}
		
	}
	public  void loadcash(){
		conn=DataBaseConnection.dbConnector();
		try{
			String query="select Cash2 from Balance";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
				taka.setText(rs.getString("Cash2"));
			pst.close();
			rs.close();
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Erorr.."+e);
		}
		
	}
	
	void getvalue(){
		conn=DataBaseConnection.dbConnector();
		
		
		try{
			int row=table.getSelectedRow();
			String key=(table.getModel().getValueAt(row, 0)).toString();
			String query="select * from User where Ac='"+key+"' ";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			byte[] idata=rs.getBytes("Image");
			//String v=rs.getBytes("Image").toString();
			
			ImageIcon format = new ImageIcon(idata);
			//System.out.print("++ "+format+" ++");
			picture.setIcon(format);
			while(rs.next()){
				ac.setText(rs.getString("Ac"));
				name.setText(rs.getString("Name"));
				mail.setText(rs.getString("Email"));
				mob.setText(rs.getString("Mobile"));
				address.setText(rs.getString("Address"));
			}
			
			pst.close();
			rs.close();
			
		}
		catch(Exception e){
			//JOptionPane.showMessageDialog(null,"Erorr.."+e);
		}
		
	}
	
	void update(){
	 
	  if(ac.getText().length()>0){
		conn=DataBaseConnection.dbConnector();
		try {
			String sql="Update User set Name='"+name.getText()+"',Email='"+mail.getText()+"',Mobile='"+mob.getText()+"',Address='"+address.getText()+"' where Ac='"+ac.getText()+"' ";
			
			PreparedStatement pst;
			pst = conn.prepareStatement(sql);
			
			pst.execute();
			pst.close();
			//Mail();
			JOptionPane.showMessageDialog(null, "Successfully Updated");
			Mail();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e);
		}
		}
	  else
		  JOptionPane.showMessageDialog(null, "Nothing to Update");
		
	}
	void delete(){
		 
		  if(ac.getText().length()>0){
			conn=DataBaseConnection.dbConnector();
			try{
				String query="delete  from User where Ac='"+ac.getText()+"' ";
				PreparedStatement pst=conn.prepareStatement(query);
				
				pst.execute();
				
				JOptionPane.showMessageDialog(null, "Successfully Deleted");
				
				pst.close();
				name.setText(null);
				mail.setText(null);
				mob.setText(null);
				address.setText(null);
				ac.setText(null);
				
			}
			catch(Exception e1){
				JOptionPane.showMessageDialog(null,"Eror..");
				name.setText(null);
				mail.setText(null);
				mob.setText(null);
				address.setText(null);
				ac.setText(null);
			}
			}
		  else
			  JOptionPane.showMessageDialog(null, "Nothing to Update");
			
		}
	 void Mail(){
		String from ="avirtualbank@gmail.com";
        String pass = "admin.bank";
        String[] to ={ mail.getText() }; // list of recipient email addresses
        String subject = "Bank71";
        String Name=name.getText();
        String body="Hi "+Name+  "\nYour profile is recently changed by Admin \nThank you";
        Email.send1(from, pass, to, subject, body);
	}
	 void Log(String Date,String Ac,String Messege){
		 
		 conn=DataBaseConnection.dbConnector();
			try{
				String query="Insert into Log (Date) Values ('"+Date+" --> Name-->"+Ac+" Messege--> "+Messege+"')";
				PreparedStatement pst=conn.prepareStatement(query);
				
				pst.execute();
				pst.close();
				
				
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,"Erorr.."+e);
			}
	 }
	 
	 public  void loaduser(){
			conn=DataBaseConnection.dbConnector();
			try{
				int i=0;
				String query="select * from User";
				PreparedStatement pst=conn.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				while(rs.next()){
					i++;
				}
               user1.setText("Total User: "+i);
				
				pst.close();
				rs.close();
				
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,"Erorr.."+e);
			}
			
		}
}
