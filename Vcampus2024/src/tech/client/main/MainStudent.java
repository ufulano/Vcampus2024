package tech.client.main;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 用户主页，学生
 */


public class MainStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainStudent frame = new MainStudent();
					frame.setVisible(true);
					frame.setSize(1200,800);
					frame.setTitle("Vcampus·个人主页");
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
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
	public MainStudent() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainStudent.class.getResource("/resources/icon/icon1/school.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1198, 795);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(104, 91, 597, 545);
		contentPane.add(panel);
		panel.setLayout(null);
		

		
		JButton btnStudentStatus = new JButton("");
		btnStudentStatus.setIcon(new ImageIcon(MainStudent.class.getResource("/resources/icon/icon1/statussmall.png")));
		btnStudentStatus.setContentAreaFilled(false);
		btnStudentStatus.setBorderPainted(false);
		btnStudentStatus.setBorder(null);
		btnStudentStatus.setBounds(68, 100, 133, 159);

		
		JButton btnClass = new JButton("");
		btnClass.setIcon(new ImageIcon(MainStudent.class.getResource("/resources/icon/icon1/zizhuxuankesmall.png")));
		btnClass.setContentAreaFilled(false);
		btnClass.setBorderPainted(false);
		btnClass.setBorder(null);
		btnClass.setBounds(225, 90, 133, 159);

		
		JButton btnLibrary = new JButton("");
		btnLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLibrary.setIcon(new ImageIcon(MainStudent.class.getResource("/resources/icon/icon1/librarysmall.png")));
		btnLibrary.setContentAreaFilled(false);
		btnLibrary.setBorderPainted(false);
		btnLibrary.setBorder(null);
		btnLibrary.setBounds(391, 90, 113, 159);

		
		JButton btnShop = new JButton("");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShop.setIcon(new ImageIcon(MainStudent.class.getResource("/resources/icon/icon1/shoppingsmall.png")));
		btnShop.setContentAreaFilled(false);
		btnShop.setBorderPainted(false);
		btnShop.setBorder(null);
		btnShop.setBounds(68, 299, 133, 166);
		
		JLabel lblShop = new JLabel("网上商城");
		lblShop.setForeground(new Color(0, 0, 153));
		lblShop.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblShop.setBounds(105, 439, 64, 26);
		panel.add(lblShop);
		
		JLabel lblStudentStatus_1_1 = new JLabel("图书馆");
		lblStudentStatus_1_1.setForeground(new Color(0, 0, 153));
		lblStudentStatus_1_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblStudentStatus_1_1.setBounds(418, 223, 64, 26);
		panel.add(lblStudentStatus_1_1);

		
		JButton btnNewButton_1_4 = new JButton("New button");
		btnNewButton_1_4.setBounds(245, 320, 113, 130);
		panel.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_5 = new JButton("New button");
		btnNewButton_1_5.setBounds(391, 320, 113, 130);

		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(725, 91, 345, 545);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(103, 77, 152, 159);
		panel_1.add(lblNewLabel);
		
		JButton btnOut = new JButton("登出");
		btnOut.setFont(new Font("幼圆", Font.BOLD, 12));
		btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOut.setBounds(1049, 21, 111, 36);
		contentPane.add(btnOut);
		
		JLabel lblStudentStatus_1 = new JLabel("自主选课");
		lblStudentStatus_1.setForeground(new Color(0, 0, 153));
		lblStudentStatus_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblStudentStatus_1.setBounds(261, 223, 64, 26);
		panel.add(lblStudentStatus_1);
		
		JLabel lblStudentStatus = new JLabel("学籍信息");
		lblStudentStatus.setForeground(new Color(0, 0, 153));
		lblStudentStatus.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblStudentStatus.setLabelFor(btnStudentStatus);
		lblStudentStatus.setBounds(105, 223, 64, 26);
		panel.add(lblStudentStatus);
		
		
		
		
		panel.add(btnStudentStatus);
		panel.add(btnClass);
		panel.add(btnLibrary);
		panel.add(btnShop);
		panel.add(btnNewButton_1_5);
	}
}
