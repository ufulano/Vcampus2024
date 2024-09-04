package tech.client.schedule;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import tech.client.library.LibraryUserGUI;
import tech.client.main.MainStudent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.Color;

/**
 *  老师课表，可查看选课名单
 *  UI基本设计完成
 */
public class scheduleTeacherSide extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					scheduleTeacherSide frame = new scheduleTeacherSide();
					frame.setVisible(true);
					frame.setSize(900,600);
					frame.setTitle("Vcampus·课表");
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
	public scheduleTeacherSide() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainStudent.class.getResource("/resources/icon/icon2/课表.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Head
		JLabel lblVcampus = new JLabel("课程信息");
		lblVcampus.setBounds(21, 10, 133, 43);
		lblVcampus.setHorizontalAlignment(SwingConstants.CENTER);
		lblVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		contentPane.add(lblVcampus);
		
		JButton btnBack = new JButton("返回");
		btnBack.setBounds(784, 10, 99, 46);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnBack.setContentAreaFilled(false);
		contentPane.add(btnBack);
		
		// 左侧按钮
		JButton btnSchedule = new JButton("排课信息");// 显示课表
		btnSchedule.setBounds(0, 87, 172, 74);
		btnSchedule.setIcon(new ImageIcon(LibraryUserGUI.class.getResource("")));
		btnSchedule.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        btnSchedule.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        contentPane.add(btnSchedule);  
        
		JButton btnStudentList = new JButton("学生列表"); // 查看自己课程的选课名单，combox显示自己的
		btnStudentList.setBounds(0, 171, 172, 84);
		btnStudentList.setIcon(new ImageIcon(LibraryUserGUI.class.getResource("")));
		btnStudentList.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		contentPane.add(btnStudentList);
		

		// 中间部分
		// 用于显示信息
		table = new JTable();
		table.setBounds(214, 142, 645, 426);
        table.setBackground(UIManager.getColor("Button.light"));
        contentPane.add(table);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(762, 99, 97, 23);
		contentPane.add(btnNewButton);
		
		JComboBox comboBoxClass = new JComboBox();
		comboBoxClass.setBounds(627, 99, 125, 23);
		contentPane.add(comboBoxClass);
		
		
        // 表格标题
		JLabel lblTitle = new JLabel("<dynamic>");
		lblTitle.setBounds(214, 87, 183, 38);
		lblTitle.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		contentPane.add(lblTitle);

		
        
        // 背景设置
        JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/老师课表背景.png")));
        backgroundLabel.setBounds(0,0, 900, 600);
        backgroundLabel.setOpaque(true); 
        contentPane.add(backgroundLabel);
                            
	}
}
