package shoaeb.bank71;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Log extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Log dialog = new Log();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Log() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Log");
		setType(Type.UTILITY);
		setBounds(500, 100, 477, 363);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 343, 275);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(374, 123, 75, 37);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblClearLog = new JLabel(" Clear Log");
		lblClearLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				del();
			}
		});
		lblClearLog.setBounds(0, 0, 75, 37);
		panel_1.add(lblClearLog);
		lblClearLog.setForeground(Color.WHITE);
		lblClearLog.setFont(new Font("Tahoma", Font.BOLD, 14));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JPanel panel = new JPanel();
				panel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				panel.setForeground(Color.WHITE);
				panel.setBackground(Color.BLACK);
				buttonPane.add(panel);
				{
					JLabel lblOk = new JLabel("      Ok        ");
					lblOk.setForeground(Color.WHITE);
					panel.add(lblOk);
					lblOk.setFont(new Font("Tahoma", Font.BOLD, 14));
				}
			}
		}
		loadtable();
	}
	public  void loadtable(){
		Connection conn = DataBaseConnection.dbConnector();
		try{
			String query="select * from Log";
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
	public  void del(){
		Connection conn = DataBaseConnection.dbConnector();
		try{
			String query="DELETE FROM 'main'.'Log'";
			PreparedStatement pst=conn.prepareStatement(query);
			//ResultSet rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.execute();
			pst.close();
			//rs.close();
			loadtable();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Erorr.."+e);
		}
		
	}
}
