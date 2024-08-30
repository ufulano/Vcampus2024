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
import javax.swing.border.EmptyBorder;

import tech.client.main.MainStudent;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

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
		
		JLabel lblNewLabel = new JLabel("课程信息");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 30));
		lblNewLabel.setBounds(27, 10, 140, 46);
		contentPane.add(lblNewLabel);
		
		
		
		JButton btnStudentList = new JButton("学生列表");
		btnStudentList.setBounds(10, 142, 140, 42);
		btnStudentList.setContentAreaFilled(false);
		btnStudentList.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		contentPane.add(btnStudentList);
		
		JButton btnBack = new JButton("返回");
		btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnBack.setBounds(757, 10, 99, 46);
		btnBack.setContentAreaFilled(false);
		contentPane.add(btnBack);
                
                JButton btnSchedule = new JButton("排课信息");
                btnSchedule.setContentAreaFilled(false);
                btnSchedule.setFont(new Font("微软雅黑", Font.PLAIN, 20));
                btnSchedule.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	}
                });
                btnSchedule.setBounds(10, 86, 140, 46);
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
