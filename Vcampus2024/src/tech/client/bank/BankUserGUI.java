package tech.client.bank;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import tech.client.login.LoginGUI;
import tech.client.main.ImageSlider;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//时间相关
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import tech.client.login.*;
import Entity.UserEntity;
import tech.client.studentManage.SMStudentPersonal;
import tech.client.library.*;
import java.awt.Window;
import tech.client.schedule.*;
/**
 * 用户主页，学生
 */


public class BankUserGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldWelcom;
	private ImageSlider imageSlider;
	private JTextField txtVcampus;

	public BankUserGUI() {				
		int width = 90; 
		int height = 90; //icon大小
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(BankUserGUI.class.getResource("/resources/icon/icon1/school.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 903, 606);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 887, 567);
		panel.setOpaque(false); // 设置面板不透明，允许背景显示
		contentPane.add(panel);
		panel.setLayout(null);

		// 
		JButton btnOrders = new JButton();
		btnOrders.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		    }
		});
		

		JLabel labelWelcome = new JLabel("余额显示");
		labelWelcome.setForeground(new Color(141, 102, 75));
		labelWelcome.setFont(new Font("幼圆", Font.BOLD, 16));
		labelWelcome.setBounds(332, 10, 460, 42);
		panel.add(labelWelcome);
		
		ImageIcon originalIcon = new ImageIcon(BankUserGUI.class.getResource("/resources/icon/icon2/学籍.png"));
		Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		btnOrders.setIcon(new ImageIcon(scaledImage));
		btnOrders.setContentAreaFilled(false);
		btnOrders.setBorderPainted(false);
		btnOrders.setBounds(92, 441, 141, 126);

		
		JButton btnRecharge = new JButton("");
		ImageIcon originalIcon1 = new ImageIcon(BankUserGUI.class.getResource("/resources/icon/icon2/选课.png"));
		Image scaledImage1 = originalIcon1.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		btnRecharge.setIcon(new ImageIcon(scaledImage1));
		btnRecharge.setContentAreaFilled(false);
		btnRecharge.setBorderPainted(false);
		btnRecharge.setBorder(null);
		btnRecharge.setBounds(371, 432,151, 154);

		ImageSlider imageSlider = new ImageSlider();
        // 测试图片地址
        String[] imageUrls = {
            "https://example.com/image1.jpg",
            "https://example.com/image2.jpg",
            "https://example.com/image3.jpg"
        };
        imageSlider.setImageUrls(imageUrls);
        imageSlider.setVisible(true);
        imageSlider.setBounds(163, 80, 590, 336);
        panel.add(imageSlider);
		
		// 创建银行按钮
		JButton btnPassword = new JButton();
		ImageIcon originalIcon5 = new ImageIcon(BankUserGUI.class.getResource("/resources/icon/icon2/银行.png")); 
		Image scaledImage5 = originalIcon5.getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH);
		btnPassword.setIcon(new ImageIcon(scaledImage5));
		btnPassword.setContentAreaFilled(false);
		btnPassword.setBorderPainted(false);
		btnPassword.setBorder(null);
		btnPassword.setBounds(663, 458, 127, 99); 
		panel.add(btnPassword);

		JLabel lbl2 = new JLabel("账户充值");
		lbl2.setForeground(new Color(102, 0, 0));
		lbl2.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lbl2.setBounds(416, 541, 68, 26);
		panel.add(lbl2);
		
		JLabel lbl1 = new JLabel("我的账单");
		lbl1.setForeground(new Color(102, 0, 0));
		lbl1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lbl1.setLabelFor(btnOrders);
		lbl1.setBounds(133, 541, 60, 26);
		panel.add(lbl1);

		panel.add(btnOrders);
		panel.add(btnRecharge);
		panel.add(btnPassword);

		panel.add(btnOrders);
		panel.add(btnRecharge);
		panel.add(btnPassword);
		
		JLabel backgroundLabel = new JLabel(new ImageIcon(BankUserGUI.class.getResource("/resources/picture/银行背景 .png")));
		backgroundLabel.setBounds(0, 0, 900, 581);
		contentPane.add(backgroundLabel);
		
		
		
		JButton btnOut = new JButton("");
		ImageIcon originalIcon6 = new ImageIcon(BankUserGUI.class.getResource("/resources/icon/icon2/退出.png")); // 假设银行图标的路径
		Image scaledImage6 = originalIcon6.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);
		btnOut.setIcon(new ImageIcon(scaledImage6));
		btnOut.setContentAreaFilled(false);
		btnOut.setBorderPainted(false);
		btnOut.setBorder(null);
		btnOut.setBounds(802, 10, 68, 50);
		panel.add(btnOut);
		btnOut.setFont(new Font("幼圆", Font.BOLD, 12));
		
		JLabel lblShop_1 = new JLabel("修改密码");
		lblShop_1.setForeground(new Color(102, 0, 0));
		lblShop_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblShop_1.setBounds(698, 541, 60, 26);
		panel.add(lblShop_1);
		
		txtVcampus = new JTextField();
		txtVcampus.setOpaque(false);
		txtVcampus.setFont(new Font("幼圆", Font.BOLD, 30));
		txtVcampus.setText("网上银行");
		txtVcampus.setBounds(55, 2, 199, 83);
		txtVcampus.setBorder(null);
		panel.add(txtVcampus);

	}
}
	
	




