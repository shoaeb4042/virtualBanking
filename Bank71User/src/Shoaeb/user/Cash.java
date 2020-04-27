package Shoaeb.user;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cash extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField ac;
	private JTextField am;
	private JTextField rac;
	JCheckBox cashin,cashout,transfer;
	String pass;
	int a1=0;
	int a2=0;
	int a3=0;
	int z=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cash dialog = new Cash();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	Connection conn=null;
	public Cash() {
		setTitle("Control Center");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(500, 100, 440, 363);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		ac = new JTextField();
		ac.setBackground(new Color(255, 255, 255));
		ac.setEditable(false);
		ac.setForeground(new Color(0, 128, 0));
		ac.setFont(new Font("Tahoma", Font.BOLD, 25));
		ac.setBounds(185, 11, 172, 32);
		contentPanel.add(ac);
		ac.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Your AC");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(63, 9, 112, 32);
		contentPanel.add(lblNewLabel);
		
		JLabel lblAmmount = new JLabel("Ammount");
		lblAmmount.setForeground(SystemColor.desktop);
		lblAmmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAmmount.setBounds(63, 66, 112, 32);
		contentPanel.add(lblAmmount);
		
		am = new JTextField();
		am.setForeground(new Color(0, 0, 128));
		am.setFont(new Font("Tahoma", Font.BOLD, 25));
		am.setColumns(10);
		am.setBounds(185, 68, 172, 32);
		contentPanel.add(am);
		
		JLabel lblRecei = new JLabel("Recipent's AC");
		lblRecei.setForeground(SystemColor.desktop);
		lblRecei.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRecei.setBounds(63, 124, 112, 32);
		contentPanel.add(lblRecei);
		
		rac = new JTextField();
		rac.setBackground(new Color(255, 255, 255));
		rac.setEditable(false);
		rac.setForeground(new Color(255, 0, 0));
		rac.setFont(new Font("Tahoma", Font.BOLD, 25));
		rac.setColumns(10);
		rac.setBounds(185, 126, 172, 32);
		contentPanel.add(rac);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cashin.isSelected()==true)
					plus();
				else if(cashout.isSelected()==true)
					minus();
				else if(transfer.isSelected()==true)
					send();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(185, 221, 132, 43);
		contentPanel.add(btnNewButton);
		
		 cashin = new JCheckBox("Cashin");
		 cashin.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) {
		 		if(cashin.isSelected()){
		 			cashout.setSelected(false);
		 			transfer.setSelected(false);
		 		}
		 	}
		 });
		cashin.setForeground(new Color(255, 255, 255));
		cashin.setBackground(new Color(0, 128, 0));
		cashin.setFont(new Font("Tahoma", Font.BOLD, 11));
		cashin.setBounds(133, 179, 69, 23);
		contentPanel.add(cashin);
		
		 cashout = new JCheckBox("Cashout");
		 cashout.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) {
		 		if(cashout.isSelected()){
		 			cashin.setSelected(false);
		 			transfer.setSelected(false);
		 		}
		 	}
		 });
		cashout.setForeground(new Color(255, 255, 255));
		cashout.setBackground(new Color(0, 128, 0));
		cashout.setFont(new Font("Tahoma", Font.BOLD, 11));
		cashout.setBounds(210, 179, 80, 23);
		contentPanel.add(cashout);
		
		transfer = new JCheckBox("Transfer");
		transfer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(transfer.isSelected()){
		 			cashout.setSelected(false);
		 			cashin.setSelected(false);
		 			rac.setEditable(true);
		 		}
			}
		});
		transfer.setForeground(new Color(255, 255, 255));
		transfer.setBackground(new Color(0, 128, 0));
		transfer.setFont(new Font("Tahoma", Font.BOLD, 11));
		transfer.setBounds(300, 179, 80, 23);
		contentPanel.add(transfer);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(transfer.isSelected()==false){
		 			//cashout.setSelected(false);
		 			//cashin.setSelected(false);
					
		 			rac.setEditable(false);
		 		}
			}
		});
		lblNewLabel_1.setBounds(0, 0, 434, 301);
		contentPanel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(128, 128, 128));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setForeground(new Color(0, 0, 0));
				okButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				okButton.setBackground(new Color(255, 255, 255));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new Menu().setVisible(true);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(new Color(0, 0, 0));
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				cancelButton.setBackground(new Color(255, 255, 255));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						new Menu().setVisible(true);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		getvalue();
	}
	
	void getvalue(){
		Connection conn = DataBaseConnection.dbConnector();
		//String acn=null;
		try{
			String query="select * from Cokies where key='1' ";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				ac.setText(rs.getString("Ac"));
				
			}
			pst.close();
			rs.close();
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Erorr.."+e);
		}
	}
	
	double getcash(){
		try{
			Connection conn = DataBaseConnection.dbConnector();
			String a=null;
			String query="select Balance,Password from User where Ac='"+ac.getText()+"' ";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				a=rs.getString("Balance");
				pass=rs.getString("Password");
			}
			pst.close();
			rs.close();
			return Double.parseDouble(a);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Erorr.."+e);
			return 0;
		}
		
	}
	///2222222
	double getcash2(){
		try{
			Connection conn = DataBaseConnection.dbConnector();
			String a=null;
			String query="select Balance from User where Ac='"+rac.getText()+"' ";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				a=rs.getString("Balance");
				
			}
			pst.close();
			rs.close();
			return Double.parseDouble(a);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Erorr.."+e);
			return 0;
		}
		
	}
	
	////22222
	Boolean plus2(){
		try {
			double c=Double.parseDouble(am.getText());
			
			double c2=getcash2()+c;
			
			if(a3<=3&&c<=50000 && c2>=1000 ){
				try {
				String sql1="Update User set Balance=? where Ac='"+rac.getText()+"' ";
				Connection conn2 = DataBaseConnection.dbConnector();
				PreparedStatement pst4;
				pst4 = conn2.prepareStatement(sql1);
				
				pst4.setString(1,Double.toString(c2));
				pst4.execute();
				pst4.close();
				
			
				} 
				catch (Exception e) {
					
					return false;
				}
				
				return true;
			}
			else{
				//JOptionPane.showMessageDialog(null, "Invalid ammount Or password");
				return false;
			}
			
			
		} catch (Exception e) {
			
			return false;
		}
	}
	///33333
	
	void plus(){
		try {
			double c=Double.parseDouble(am.getText());
			
			double c2=getcash()+c;
			String p=JOptionPane.showInputDialog("Please Enter your Password");
			if(a1<=3&&c<=50000 && c2>=1000 && p.equals(pass)){
				try {
				String sql1="Update User set Balance=? where Ac='"+ac.getText()+"' ";
				Connection conn2 = DataBaseConnection.dbConnector();
				PreparedStatement pst4;
				pst4 = conn2.prepareStatement(sql1);
				
				pst4.setString(1,Double.toString(c2));
				pst4.execute();
				pst4.close();
				a1++;
				JOptionPane.showMessageDialog(null, "Cashin successfull.\n Your Current Balance BDT"+c2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
				
				
			}
			else
				JOptionPane.showMessageDialog(null, "Invalid ammount Or password");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid ammount");
			//return 0;
		}
	}
	///
	void minus2(){
		try {
			double c=Double.parseDouble(am.getText());
			double c1=getcash();
			double c2=getcash()-c;
			String p=JOptionPane.showInputDialog("Please Enter your Password");
			Boolean x=plus2();
			////
			//JOptionPane.showMessageDialog(null, "here ");
			//JOptionPane.showMessageDialog(null, x+p+pass);
			if(a3<=3&&c1>c&&c<=50000 && c>=1000 && p.equals(pass) && x==true){
				////
				//JOptionPane.showMessageDialog(null, "here2");
				try {
				String sql1="Update User set Balance=? where Ac='"+ac.getText()+"' ";
				Connection conn2 = DataBaseConnection.dbConnector();
				PreparedStatement pst4;
				pst4 = conn2.prepareStatement(sql1);
				///
				//JOptionPane.showMessageDialog(null, "here3");
				pst4.setString(1,Double.toString(c2));
				pst4.execute();
				pst4.close();
				a3++;
				JOptionPane.showMessageDialog(null, "Transfer successfull.\n Your Current Balance BDT"+c2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
				
				
			}
			else
				JOptionPane.showMessageDialog(null, "Invalid ammount Or password");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid ammount");
			//return 0;
		}
	}
	
	///
	void minus(){
		try {
			double c=Double.parseDouble(am.getText());
			double c1=getcash();
			double c2=getcash()-c;
			String p=JOptionPane.showInputDialog("Please Enter your Password");
			if(a2<=3&&c1>c&&c<=50000 && c>=1000 && p.equals(pass)){
				try {
				String sql1="Update User set Balance=? where Ac='"+ac.getText()+"' ";
				Connection conn2 = DataBaseConnection.dbConnector();
				PreparedStatement pst4;
				pst4 = conn2.prepareStatement(sql1);
				
				pst4.setString(1,Double.toString(c2));
				pst4.execute();
				pst4.close();
				a2++;
				JOptionPane.showMessageDialog(null, "Cashout successfull.\n Your Current Balance BDT"+c2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
				
				
			}
			else
				JOptionPane.showMessageDialog(null, "Invalid ammount Or password");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid ammount");
			//return 0;
		}
	}

	void send(){
		//plus2();
		minus2();
	}
}
