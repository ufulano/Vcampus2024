package tech.client.library;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ReurnBook extends JDialog {

	/**
	 * 归还图书，仅弹窗信息
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public ReurnBook() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReurnBook.class.getResource("/resources/icon/icon2/library.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblIsbn = new JLabel("请输入书籍编号：");
		lblIsbn.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblIsbn.setBounds(31, 87, 135, 40);
		getContentPane().add(lblIsbn);
		
		textField = new JTextField();
		textField.setBounds(176, 94, 175, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("还书");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(252, 155, 99, 40);
		getContentPane().add(btnNewButton);
		setBounds(100, 100, 450, 300);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Vcampus·图书馆·还书");

		
		setSize(400,300);
		
		
		
		
	}
}
