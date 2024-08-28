package tech.client.studentManage;
/**
 * 学籍管理系统，学生端
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tech.client.main.MainStudent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class SMStudentSide extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldGender;
	private JTextField textFieldAge;
	private JTextField textFieldBirthplace;
	private JTextField textFieldBirthday;
	private JTextField textFieldID;
	private JTextField textFieldMajor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SMStudentSide frame = new SMStudentSide();
					frame.setVisible(true);
					frame.setSize(1200,800);
					frame.setTitle("Vcampus·学籍信息");
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
	public SMStudentSide() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SMStudentSide.class.getResource("/resources/icon/icon1/ic_student.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1194, 868);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(164, 91, 851, 648);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblID = new JLabel("一卡通号：");
		lblID.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblID.setBounds(445, 117, 208, 45);
		panel.add(lblID);
		
		JLabel lblName = new JLabel("姓名：");
		lblName.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblName.setBounds(116, 117, 208, 45);
		panel.add(lblName);
		
		JLabel lblGender = new JLabel("性别：");
		lblGender.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblGender.setBounds(116, 160, 208, 45);
		panel.add(lblGender);
		
		JLabel lblAge = new JLabel("年龄：");
		lblAge.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblAge.setBounds(116, 204, 208, 45);
		panel.add(lblAge);
		
		JLabel lblMajor = new JLabel("专业：");
		lblMajor.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblMajor.setBounds(445, 160, 208, 45);
		panel.add(lblMajor);
		
		JLabel lblBirthday = new JLabel("出生日期：");
		lblBirthday.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblBirthday.setBounds(116, 246, 208, 45);
		panel.add(lblBirthday);
		
		JLabel lblBirthplace = new JLabel("出生地：");
		lblBirthplace.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblBirthplace.setBounds(116, 288, 208, 45);
		panel.add(lblBirthplace);
		
		textFieldName = new JTextField();
		textFieldName.setEditable(false);
		textFieldName.setBounds(209, 125, 189, 37);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldGender = new JTextField();
		textFieldGender.setEditable(false);
		textFieldGender.setColumns(10);
		textFieldGender.setBounds(209, 168, 189, 37);
		panel.add(textFieldGender);
		
		textFieldAge = new JTextField();
		textFieldAge.setEditable(false);
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(209, 212, 189, 37);
		panel.add(textFieldAge);
		
		textFieldBirthplace = new JTextField();
		textFieldBirthplace.setEditable(false);
		textFieldBirthplace.setColumns(10);
		textFieldBirthplace.setBounds(209, 296, 189, 37);
		panel.add(textFieldBirthplace);
		
		textFieldBirthday = new JTextField();
		textFieldBirthday.setEditable(false);
		textFieldBirthday.setColumns(10);
		textFieldBirthday.setBounds(209, 254, 189, 37);
		panel.add(textFieldBirthday);
		
		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setColumns(10);
		textFieldID.setBounds(549, 125, 189, 37);
		panel.add(textFieldID);
		
		textFieldMajor = new JTextField();
		textFieldMajor.setEditable(false);
		textFieldMajor.setColumns(10);
		textFieldMajor.setBounds(549, 168, 189, 37);
		panel.add(textFieldMajor);
	}
}
