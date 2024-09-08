package tech.client.schedule;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import tech.client.library.LibraryUserGUI;
import tech.client.main.MainStudent;
import tech.client.studentManage.SMStudentPersonal;

/**
 * 单个课程详情界面
 */
public class DeleteCourse extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane = new JPanel();
	private JTextField textFieldCapacity;


	/**
	 * Create the dialog.
	 */
	
	public DeleteCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(317, 10, 404, 444);
		contentPane.add(panel);
		panel.setOpaque(false); 
		panel.setLayout(null);
		
		// head
		JLabel lblNewLabel = new JLabel("课程详情");
		lblNewLabel.setBounds(116, 64, 133, 43);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		
		JButton button = new JButton("确认");
		button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		button.setBounds(589, 464, 132, 48);
		button.setBackground(Color.white);
		contentPane.add(button);
		
		JLabel lblName = new JLabel("课程名称：");
		lblName.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblName.setBounds(116, 117, 208, 45);
		panel.add(lblName);
		
		JLabel lblGender = new JLabel("课程ID：");
		lblGender.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblGender.setBounds(116, 160, 208, 45);
		panel.add(lblGender);
		
		JLabel lblCredits = new JLabel("学分：");
		lblCredits.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblCredits.setBounds(116, 204, 208, 45);
		panel.add(lblCredits);
		
		JLabel lblAvailable = new JLabel("排课时间：");
		lblAvailable.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblAvailable.setBounds(116, 386, 208, 37);
		panel.add(lblAvailable);
		
		JLabel lblProfession = new JLabel("专业：");
		lblProfession.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblProfession.setBounds(116, 246, 208, 45);
		panel.add(lblProfession);
		
		JLabel lblGrade = new JLabel("年级：");
		lblGrade.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblGrade.setBounds(116, 296, 208, 37);
		panel.add(lblGrade);
		
		JTextField textFieldName = new JTextField();
		textFieldName.setEnabled(false);
		textFieldName.setEditable(false);
		textFieldName.setBounds(209, 125, 189, 37);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JTextField textFieldID = new JTextField();
		textFieldID.setEnabled(false);
		textFieldID.setEditable(false);
		textFieldID.setColumns(10);
		textFieldID.setBounds(209, 168, 189, 37);
		panel.add(textFieldID);
		
		JTextField textFieldAge = new JTextField();
		textFieldAge.setEnabled(false);
		textFieldAge.setEditable(false);
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(209, 212, 189, 37);
		panel.add(textFieldAge);
		
		JTextField textFieldBirthplace = new JTextField();
		textFieldBirthplace.setEnabled(false);
		textFieldBirthplace.setEditable(false);
		textFieldBirthplace.setColumns(10);
		textFieldBirthplace.setBounds(209, 296, 189, 37);
		panel.add(textFieldBirthplace);
		
		JTextField textFieldProfession = new JTextField();
		textFieldProfession.setEnabled(false);
		textFieldProfession.setEditable(false);
		textFieldProfession.setColumns(10);
		textFieldProfession.setBounds(209, 254, 189, 37);
		panel.add(textFieldProfession);
		
		JTextField textFieldAvailable = new JTextField();
		textFieldAvailable.setEnabled(false);
		textFieldAvailable.setEditable(false);
		textFieldAvailable.setColumns(10);
		textFieldAvailable.setBounds(209, 386, 189, 37);
		panel.add(textFieldAvailable);
		
		textFieldCapacity = new JTextField();
		textFieldCapacity.setEnabled(false);
		textFieldCapacity.setEditable(false);
		textFieldCapacity.setColumns(10);
		textFieldCapacity.setBounds(209, 339, 189, 37);
		panel.add(textFieldCapacity);
		
		JLabel lblCapacity = new JLabel("课容量：");
		lblCapacity.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblCapacity.setBounds(116, 339, 208, 37);
		panel.add(lblCapacity);
		
		//背景
		JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/左喷泉背景.png")));
		backgroundLabel.setBounds(0, 0, 900, 600);
		contentPane.add(backgroundLabel);

	}
}
