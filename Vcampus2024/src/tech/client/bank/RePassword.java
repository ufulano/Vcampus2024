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
import java.awt.Toolkit;

public class RePassword extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(RePassword.class.getResource("/resources/icon/icon2/密码.png")));
		setTitle("VCampus·银行·修改密码");
		setBounds(100, 100, 450, 341);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("确认修改");
			okButton.setBackground(Color.WHITE);
			okButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			okButton.setBounds(150, 236, 137, 41);
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
		
		JLabel lblPassword = new JLabel("请输入支付密码：");
		lblPassword.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblPassword.setBounds(52, 86, 137, 15);
		contentPanel.add(lblPassword);
		
		JLabel lblNewLabel_1 = new JLabel("请输入新密码：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(52, 137, 137, 15);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("确认新密码：");
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(52, 188, 137, 15);
		contentPanel.add(lblNewLabel_1_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(179, 177, 205, 41);
		contentPanel.add(passwordField_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(215, 238, 249));
		panel.setBounds(27, 60, 379, 166);
		contentPanel.add(panel);
	}
}
