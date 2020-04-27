package Shoaeb.user;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Dialog.ModalExclusionType;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;

import org.ibex.nestedvm.util.Seekable.File;






import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField name1;
	private JTextField txtLogout;
	private JTextField ad;
	private JTextField mob;
	private JTextField name;
	private JTextField eml;
	private JTextField ac;
	private JTextField bl;
	JEditorPane text,hover,text2;
	JLabel pix;
	private JTextField ps;
	//public JLabel pix;
    String filename=null;
    String ac3=null;
    int s=0;
   static byte[] person=null;
	/**
	 * Launch the application.
	 */
   Connection conn2 = DataBaseConnection.dbConnector();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setResizable(false);
		setTitle("User Menu");
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		URL iconURL = getClass().getResource("/logo.png");
		// iconURL is null when not found
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 393, 473);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		Image fimg= new ImageIcon(this.getClass().getResource("/tolls1.png")).getImage();
		mnNewMenu.setIcon(new ImageIcon(fimg));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Help");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try{
                     
                     String d ="http://facebook.com/salehin.shoaeb";
                    
                     java.awt.Desktop.getDesktop().browse(java.net.URI.create(d));
                     }catch(Exception e){
                    	 JOptionPane.showMessageDialog(null, "No connection");
                     }
			}
		});
		
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem.setForeground(Color.BLACK);
		Image help1= new ImageIcon(this.getClass().getResource("/help.png")).getImage();
		mntmNewMenuItem.setIcon(new ImageIcon(help1));
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		Image exit= new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Refresh");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getvalue();
			}
		});
		Image ref= new ImageIcon(this.getClass().getResource("/transfer.png")).getImage();
		mntmNewMenuItem_2.setIcon(new ImageIcon(ref));
		mntmNewMenuItem_2.setForeground(new Color(0, 0, 0));
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		mntmNewMenuItem_1.setIcon(new ImageIcon(exit));
		mnNewMenu.add(mntmNewMenuItem_1);
		Image img=new ImageIcon(this.getClass().getResource("/cash.png")).getImage();
		Image img1=new ImageIcon(this.getClass().getResource("/transfer.png")).getImage();
		Image img2=new ImageIcon(this.getClass().getResource("/profile.png")).getImage();
		JMenu mnNewMenu_1 = new JMenu("Cashin");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new Cash().setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.setForeground(Color.BLACK);
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.setIcon(new ImageIcon(img));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("CashOut");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Cash().setVisible(true);
				dispose();
			}
			
			
		});
		mnNewMenu_2.setForeground(Color.BLACK);
		Image imgs=new ImageIcon(this.getClass().getResource("/cashin.png")).getImage();
		mnNewMenu_2.setIcon(new ImageIcon(imgs));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Transfer");
		mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Cash().setVisible(true);
				dispose();
			}
		});
		mnNewMenu_3.setIcon(new ImageIcon(img1));
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_3.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Recharge");
		mnNewMenu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Send().setVisible(true);
				
			}
		});
		Image imgr=new ImageIcon(this.getClass().getResource("/rec.png")).getImage();
		mnNewMenu_4.setIcon(new ImageIcon(imgr));
		mnNewMenu_4.setForeground(Color.BLACK);
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_4);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 11, 131, 131);
		contentPane.add(desktopPane);
		
		JButton btnNewButton_1 = new JButton("Change");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				JFileChooser ch=new JFileChooser();
				ch.showOpenDialog(null);
				java.io.File f=ch.getSelectedFile();
				filename=f.getAbsolutePath();
				
				
					File image=new File(filename);
					
					FileInputStream fis=new FileInputStream(f);
					ByteArrayOutputStream bos=new ByteArrayOutputStream();
					byte[] buf=new byte[1024];
					for(int read;(read=fis.read(buf))!=-1;){
						bos.write(buf, 0,read);
						
					}
					person=bos.toByteArray();
					
					ImageIcon format = new ImageIcon(person);
					pix.setIcon(format);
					
						String sql1="Update User set image=? where Ac='"+ac3+"' ";
						
						PreparedStatement pst4;
						pst4 = conn2.prepareStatement(sql1);
						pst4.setBytes(1,person);
						pst4.execute();
						//JOptionPane.showMessageDialog(null, "Successfully Updated");
						

					
				}
				catch(Exception ec){
					
				}
			}
		});
		btnNewButton_1.setBackground(new Color(255, 250, 250));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(21, 97, 89, 23);
		desktopPane.add(btnNewButton_1);
		
		pix = new JLabel("");
		pix.setFont(new Font("Tahoma", Font.BOLD, 13));
		pix.setHorizontalAlignment(SwingConstants.CENTER);
		pix.setBounds(0, 0, 131, 131);
		desktopPane.add(pix);
		
		name1 = new JTextField();
		name1.setFont(new Font("Tahoma", Font.BOLD, 12));
		name1.setHorizontalAlignment(SwingConstants.CENTER);
		name1.setForeground(new Color(255, 255, 255));
		name1.setBackground(new Color(0, 0, 0));
		name1.setEditable(false);
		name1.setBounds(235, 323, 131, 26);
		contentPane.add(name1);
		name1.setColumns(10);
		
		txtLogout = new JTextField();
		txtLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Login().setVisible(true);
				dispose();
			}
		});
		txtLogout.setForeground(new Color(0, 0, 0));
		txtLogout.setBackground(new Color(255, 250, 250));
		txtLogout.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLogout.setText("Logout");
		txtLogout.setEditable(false);
		txtLogout.setBounds(266, 360, 74, 26);
		contentPane.add(txtLogout);
		txtLogout.setColumns(10);
		
		ad = new JTextField();
		ad.setHorizontalAlignment(SwingConstants.CENTER);
		ad.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				hover.setText("A\nd\nd\nr\ne\ns\ns\n");
			}
		});
		ad.setFont(new Font("Tahoma", Font.BOLD, 14));
		ad.setBounds(10, 278, 148, 26);
		contentPane.add(ad);
		ad.setColumns(10);
		
		mob = new JTextField();
		mob.setHorizontalAlignment(SwingConstants.CENTER);
		mob.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				hover.setText("\nM\no\nb\ni\nl\ne\n");
			}
		});
		mob.setFont(new Font("Tahoma", Font.BOLD, 14));
		mob.setBounds(10, 241, 148, 26);
		contentPane.add(mob);
		mob.setColumns(10);
		
		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Tahoma", Font.BOLD, 15));
		name.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				hover.setText("\n\nN\na\nm\ne\n");
			}
		});
		name.setForeground(new Color(255, 255, 255));
		name.setBackground(new Color(0, 0, 0));
		name.setEditable(false);
		name.setBounds(10, 164, 148, 32);
		contentPane.add(name);
		name.setColumns(10);
		
		eml = new JTextField();
		eml.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				hover.setText("\nE\nm\na\ni\nl\n");
			}
		});
		eml.setBounds(10, 204, 148, 26);
		contentPane.add(eml);
		eml.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn;
				conn=DataBaseConnection.dbConnector();
				try {
					String sql="Update User set Email='"+eml.getText()+"',Mobile='"+mob.getText()+"',Address='"+ad.getText()+"' Where Ac='"+ac3+"' ";
					
					PreparedStatement pst;
					pst = conn.prepareStatement(sql);
					JOptionPane.showMessageDialog(null, "Successfully Updated");
					pst.execute();
					pst.close();
				
					
					

				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		Image sign1=new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(sign1));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(27, 363, 118, 44);
		contentPane.add(btnNewButton);
		
		ac = new JTextField();
		ac.setHorizontalAlignment(SwingConstants.CENTER);
		ac.setForeground(new Color(255, 255, 255));
		ac.setFont(new Font("Tahoma", Font.BOLD, 14));
		ac.setBackground(new Color(0, 0, 0));
		ac.setEditable(false);
		ac.setBounds(251, 11, 126, 37);
		contentPane.add(ac);
		ac.setColumns(10);
		
		bl = new JTextField();
		bl.setForeground(new Color(255, 255, 255));
		bl.setFont(new Font("Tahoma", Font.BOLD, 15));
		bl.setBackground(new Color(0, 0, 0));
		bl.setEditable(false);
		bl.setBounds(251, 59, 126, 32);
		contentPane.add(bl);
		bl.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 134, 162, 44);
		contentPane.add(scrollPane);
		
		text = new JEditorPane();
		text.setEditable(false);
		text.setFont(new Font("Tahoma", Font.BOLD, 10));
		text.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(text);
		
		JLabel lblNewLabel = new JLabel("Give Us Feedback");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(215, 102, 162, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Send");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
				String query="insert into Inbox (Ac,Name,Messege) values (?, ?, ?)";
				Connection conn=DataBaseConnection.dbConnector();
				
				PreparedStatement pst=conn.prepareStatement(query);
				pst.setString(1,ac.getText());
				pst.setString(2,name.getText());
				pst.setString(3,text2.getText());
				pst.execute();
			
				JOptionPane.showMessageDialog(null,"Messege sent");
				pst.close();
				conn.close();
				}
				catch(Exception x){
					JOptionPane.showMessageDialog(null,"Messege"+x);
				}
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		Image sign=new ImageIcon(this.getClass().getResource("/mess.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(sign));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(251, 262, 100, 32);
		contentPane.add(btnNewButton_2);
		
		JLabel bg = new JLabel("New label");
		Image bga=new ImageIcon(this.getClass().getResource("/bg3.jpg")).getImage();
		
		ps = new JTextField();
		ps.setHorizontalAlignment(SwingConstants.CENTER);
		ps.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				hover.setText("P\na\ns\ns\nw\no\nr\nd\n");
			}
		});
		ps.setFont(new Font("Tahoma", Font.BOLD, 14));
		ps.setColumns(10);
		ps.setBounds(10, 315, 148, 26);
		contentPane.add(ps);
		
		hover = new JEditorPane();
		hover.setEditable(false);
		hover.setForeground(new Color(255, 255, 255));
		hover.setBackground(new Color(0, 0, 0));
		hover.setFont(new Font("Tahoma", Font.BOLD, 18));
		hover.setBounds(168, 162, 28, 179);
		contentPane.add(hover);
		
		JLabel lblAc = new JLabel("AC  :");
		lblAc.setHorizontalAlignment(SwingConstants.CENTER);
		lblAc.setForeground(Color.WHITE);
		lblAc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAc.setBounds(204, 9, 50, 39);
		contentPane.add(lblAc);
		
		JLabel lblBdt = new JLabel("BDT:");
		lblBdt.setHorizontalAlignment(SwingConstants.CENTER);
		lblBdt.setForeground(Color.WHITE);
		lblBdt.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBdt.setBounds(204, 54, 50, 39);
		contentPane.add(lblBdt);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(215, 189, 162, 56);
		contentPane.add(scrollPane_1);
		
		text2 = new JEditorPane();
		scrollPane_1.setViewportView(text2);
		bg.setIcon(new ImageIcon(bga));
		bg.setBounds(0, 0, 387, 418);
		contentPane.add(bg);
		getvalue();
		
		try {
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
					getvalue();
				}
					
				}
			});
			x.start();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
		
		}
		
	}
	void getvalue(){
		Connection conn = DataBaseConnection.dbConnector();
		String acn=null;
		try{
			String query="select * from Cokies where key='1' ";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				acn=rs.getString("Ac");
				ac3=rs.getString("Ac");
			}
			pst.close();
			rs.close();
			//conn.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Erorr.."+e);
		}
		
		try{
			String query="select * from User Where Ac='"+acn+"'";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				ac.setText(rs.getString("Ac"));
				bl.setText(rs.getString("Balance"));
				name.setText(rs.getString("Name"));
				eml.setText(rs.getString("Email"));
				mob.setText(rs.getString("Mobile"));
				ad.setText(rs.getString("Address"));
				text.setText("Admin: "+rs.getString("Messege")+"\n");
				ps.setText(rs.getString("Password"));
				name1.setText(rs.getString("Name"));
				byte[] idata=rs.getBytes("image");
				ImageIcon format = new ImageIcon(idata);
				pix.setIcon(format);
			}
			pst.close();
			rs.close();
			conn.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Erorr.."+e);
		}
		
		
	}
}
