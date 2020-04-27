package shoaeb.bank71;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JEditorPane;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Send extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField name;
	JEditorPane text;
	String key=null;
	int v=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Send dialog = new Send();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			///e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Send() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Send Messege");
		setResizable(false);
		setBounds(510, 210, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 11, 235, 216);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				////
				getvalue();
			}
		});
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setViewportView(table);
		
		name = new JTextField();
		name.setBackground(new Color(255, 255, 255));
		name.setEditable(false);
		name.setFont(new Font("Tahoma", Font.BOLD, 16));
		name.setBounds(26, 11, 137, 34);
		contentPanel.add(name);
		name.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 64, 138, 100);
		contentPanel.add(scrollPane_1);
		
		text = new JEditorPane();
		scrollPane_1.setViewportView(text);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText().length()>=1)
				update();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(47, 188, 89, 39);
		contentPanel.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(0, 128, 0));
				okButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Refresh");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadtable();
					}
				});
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(0, 128, 0));
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadtable();
		
		try {
			Thread x=new Thread(new Runnable(){
				int d1=startT();
				//int v2=startT();

				public void run(){
				while(true){
					try {
						Thread.sleep(300);
						 //Toolkit.getDefaultToolkit().beep();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e);
					}
					int v2=startT();
					if(d1<v2) {
					loadtable();
				    d1=v2;
					}
					//v=v2;
				}
					
				}
			});
			x.start();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
		
		}
	}
	public  void loadtable(){
		Connection conn=DataBaseConnection.dbConnector();
		try{
			String query="select Ac,Name,Messege from Inbox";
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
	
	void getvalue(){
		Connection conn=DataBaseConnection.dbConnector();
		
		
		try{
			int row=table.getSelectedRow();
			key=(table.getModel().getValueAt(row, 0)).toString();
			String query="select * from Inbox where Ac='"+key+"' ";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
		
			while(rs.next()){
				
				name.setText("To: "+rs.getString("Name"));
				
			}
			
			pst.close();
			rs.close();
			
		}
		catch(Exception e){
			//JOptionPane.showMessageDialog(null,"Erorr.."+e);
		}
		
	}
	void update(){
		 
		 
			Connection conn=DataBaseConnection.dbConnector();
			try {
				String sql="Update User set Messege='"+text.getText()+"' where Ac='"+key+"' ";
				
				PreparedStatement pst;
				pst = conn.prepareStatement(sql);
				
				pst.execute();
				pst.close();
				//Mail();
				JOptionPane.showMessageDialog(null, "Successfully sent");
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e);
			}
			}
		 
			
	int  startT(){
		Connection conn=DataBaseConnection.dbConnector();
		int x=0;
		
		try{
			//int row=table.getSelectedRow();
			//key=(table.getModel().getValueAt(row, 0)).toString();
			String query="select * from Inbox";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
		
			while(rs.next()){
				x++;
				
				
			}
			
			pst.close();
			rs.close();
			return x;
		}
		catch(Exception e){
			//JOptionPane.showMessageDialog(null,"Erorr.."+e);
			return x;
		}
		
	}
}
