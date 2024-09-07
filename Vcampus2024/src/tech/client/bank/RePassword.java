package tech.client.bank;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class RePassword extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RePassword dialog = new RePassword();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public RePassword() {
		setTitle("Vcampus·银行·修改密码");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("确认修改");
			okButton.setBackground(Color.WHITE);
			okButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			okButton.setBounds(149, 189, 137, 41);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		passwordField = new JPasswordField();
		passwordField.setBounds(179, 75, 205, 41);
		contentPanel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(179, 126, 205, 41);
		contentPanel.add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("请输入支付密码：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel.setBounds(52, 86, 137, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("请输入新密码：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(52, 137, 137, 15);
		contentPanel.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 238, 248));
		panel.setBounds(30, 45, 378, 136);
		contentPanel.add(panel);
	}
}
