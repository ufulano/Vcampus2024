package tech.client.schedule;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import tech.client.library.LibraryUserGUI;
import tech.client.main.MainStudent;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
/**
 * 管理员的课程管理主页
 */
public class scheduleManagerSide extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					scheduleManagerSide frame = new scheduleManagerSide();
					frame.setVisible(true);
					frame.setSize(900,600);
					frame.setTitle("Vcampus·选课系统");
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
	public scheduleManagerSide() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainStudent.class.getResource("/resources/icon/icon2/课表.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(597, 103, 155, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// Head
		JLabel lblVcampus = new JLabel("课程管理");
		lblVcampus.setBounds(21, 10, 133, 43);
		lblVcampus.setHorizontalAlignment(SwingConstants.CENTER);
		lblVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		contentPane.add(lblVcampus);
		
		JButton btnBack = new JButton("返回");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(784, 10, 99, 46);
		btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnBack.setContentAreaFilled(false);
		contentPane.add(btnBack);

		// 左侧按钮
		JButton btnManage = new JButton("课程总览");  // 选中查看所有课程，点击查看课程详情，【增加】【删改】跳转至课程详情页面
		btnManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManage.setBounds(1, 77, 171, 84);
		btnManage.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		contentPane.add(btnManage);
		
		JButton btnStudentList = new JButton("学生列表"); //选中课程的同时点击，查看当前科目的学生信息，【增加】【删改】弹窗提示
		btnStudentList.setBounds(0, 171, 172, 84);
		btnStudentList.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		contentPane.add(btnStudentList);
        
		// 中央工作区
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(762, 99, 97, 33);
		contentPane.add(btnNewButton);
		
		table = new JTable();
        table.setBounds(211, 148, 645, 365);
        table.setBackground(UIManager.getColor("Button.light"));
        contentPane.add(table);  
        
		JButton btnRe = new JButton("删改");
		btnRe.setBackground(Color.WHITE);
		btnRe.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnRe.setBounds(759, 539, 97, 25);
		contentPane.add(btnRe);
		
		JButton btnNew = new JButton("增加");
		btnNew.setBackground(Color.WHITE);
		btnNew.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNew.setBounds(652, 539, 97, 25);
		contentPane.add(btnNew);
                        
        // 背景                
        JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/老师课表背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        backgroundLabel.setOpaque(true); 
        contentPane.add(backgroundLabel);
                        
	}
}
