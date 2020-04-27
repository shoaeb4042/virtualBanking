package Shoaeb.user;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Send extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTextField mn;
	public static JTextField am;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Send dialog = new Send();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Send() {
		setTitle("Recharge");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(490, 200, 411, 228);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNumber.setBounds(10, 10, 108, 38);
		contentPanel.add(lblNumber);
		
		mn = new JTextField();
		mn.setFont(new Font("Tahoma", Font.BOLD, 18));
		mn.setBounds(133, 10, 198, 38);
		contentPanel.add(mn);
		mn.setColumns(10);
		
		JLabel lblAmmount = new JLabel("Ammount");
		lblAmmount.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAmmount.setBounds(10, 72, 108, 38);
		contentPanel.add(lblAmmount);
		
		am = new JTextField();
		am.setHorizontalAlignment(SwingConstants.CENTER);
		am.setFont(new Font("Tahoma", Font.BOLD, 18));
		am.setColumns(10);
		am.setBounds(133, 72, 198, 38);
		contentPanel.add(am);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean b=mobile();
				if(b)
				new SmsSender();
				else
				JOptionPane.showMessageDialog(null, "Invalid ammount Or Number");
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(133, 121, 108, 34);
		contentPanel.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				okButton.setForeground(Color.WHITE);
				okButton.setBackground(Color.BLACK);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setBackground(Color.BLACK);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	boolean mobile(){
		int n=20;
		try{
		@SuppressWarnings("unused")
		int mob=Integer.parseInt(mn.getText());
		n=Integer.parseInt(am.getText());
		}
		catch(Exception x){
			JOptionPane.showMessageDialog(null,"invalid number" );
		}
		try {
			if(n>=20&&n<=200&&mn.getText().length()==11 && (mn.getText().startsWith("017") ||
					mn.getText().startsWith("016") || mn.getText().startsWith("018") || 
					mn.getText().startsWith("015") || mn.getText().startsWith("011") || 
					mn.getText().startsWith("019")))
			return true;
			
			else
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}}
}
