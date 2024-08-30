package tech.client.schedule;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import tech.client.main.MainStudent;
import javax.swing.JMenuBar;
import javax.swing.UIManager;

public class scheduleManagerSide extends JFrame {

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
		
		JButton btnManage = new JButton("选课管理");
		btnManage.setBounds(23, 194, 140, 42);
		btnManage.setContentAreaFilled(false);
		btnManage.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		contentPane.add(btnManage);
		
		JButton btnStudentList = new JButton("学生列表");
		btnStudentList.setBounds(23, 142, 140, 42);
		btnStudentList.setContentAreaFilled(false);
		btnStudentList.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		contentPane.add(btnStudentList);
		
		JButton btnBack = new JButton("返回");
		btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnBack.setBounds(784, 10, 99, 46);
		btnBack.setContentAreaFilled(false);
		contentPane.add(btnBack);
                
                JButton btnSchedule = new JButton("排课信息");
                btnSchedule.setContentAreaFilled(false);
                btnSchedule.setFont(new Font("微软雅黑", Font.PLAIN, 20));
                btnSchedule.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	}
                });
                btnSchedule.setBounds(23, 84, 140, 46);
                contentPane.add(btnSchedule);
                        
                        table = new JTable();
                        table.setBackground(UIManager.getColor("Button.light"));
                        table.setBounds(211, 102, 645, 460);
                        contentPane.add(table);
                        
                                JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/老师课表背景.png")));
                                backgroundLabel.setBounds(0, 0, 900, 600);
                                backgroundLabel.setOpaque(true); 
                                contentPane.add(backgroundLabel);
        
	}

}
