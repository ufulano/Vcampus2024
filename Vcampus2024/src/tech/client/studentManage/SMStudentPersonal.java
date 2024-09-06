package tech.client.studentManage;

import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Entity.UserEntity;

import tech.client.main.MainStudent;
import tech.client.main.UserSession;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;


import java.text.SimpleDateFormat;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import Entity.BookEntity;
import tech.client.main.MainStudent;

/**
 * 学生自己查看自己的学籍信息
 */
public class SMStudentPersonal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldName;
    private JTextField textFieldGender;
    private JTextField textFieldAge;
    private JTextField textFieldBirthplace;
    private JTextField textFieldBirthday;
    private JTextField textFieldID;
    private JTextField textFieldMajor;

    public SMStudentPersonal() {
        setTitle("Vcampus·学生信息");
        setResizable(false);
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 882, 689);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(348, 0, 404, 464);
        panel.setBackground(new Color(255, 255, 255));
        contentPane.add(panel);
        panel.setOpaque(false);
        panel.setLayout(null);



		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(383, 42, 404, 431);
		contentPane.add(panel);
		panel.setOpaque(false); // 设置面板不透明，允许背景显示
		panel.setLayout(null);*/

		
		JLabel lblID = new JLabel("一卡通号：");
		lblID.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblID.setBounds(116, 343, 208, 37);
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
		lblMajor.setBounds(116, 378, 208, 45);
		panel.add(lblMajor);
		
		JLabel lblBirthday = new JLabel("出生日期：");
		lblBirthday.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblBirthday.setBounds(116, 246, 208, 45);
		panel.add(lblBirthday);
		
		JLabel lblBirthplace = new JLabel("出生地：");
		lblBirthplace.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblBirthplace.setBounds(116, 296, 208, 37);
		panel.add(lblBirthplace);
		
		UserEntity user = UserSession.getInstance().getUser();
		//判断是否是学生
		if(user.getuRole()!="1"){
			return;
		}
		
		textFieldName = new JTextField();
		textFieldName.setText(user.getuName());
		textFieldName.setEnabled(false);
		textFieldName.setEditable(false);
		textFieldName.setBounds(209, 125, 189, 37);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldGender = new JTextField();
		textFieldGender.setText(user.getuGender());
		textFieldGender.setEnabled(false);
		textFieldGender.setEditable(false);
		textFieldGender.setColumns(10);
		textFieldGender.setBounds(209, 168, 189, 37);
		panel.add(textFieldGender);
		
		textFieldAge = new JTextField();
		textFieldAge.setText(Integer.toString(user.getuAge()));
		textFieldAge.setEnabled(false);
		textFieldAge.setEditable(false);
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(209, 212, 189, 37);
		panel.add(textFieldAge);
		
		textFieldBirthplace = new JTextField();
		textFieldBirthplace.setText(user.getuBirthplace());
		textFieldBirthplace.setEnabled(false);
		textFieldBirthplace.setEditable(false);
		textFieldBirthplace.setColumns(10);
		textFieldBirthplace.setBounds(209, 296, 189, 37);
		panel.add(textFieldBirthplace);
		
		textFieldBirthday = new JTextField();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  // 选择你需要的日期格式
		textFieldBirthday.setText(formatter.format(user.getuBirthday()));  // 格式化 Date 为 String
		textFieldBirthday.setEnabled(false);
		textFieldBirthday.setEditable(false);
		textFieldBirthday.setColumns(10);
		textFieldBirthday.setBounds(209, 254, 189, 37);
		panel.add(textFieldBirthday);
		
		textFieldID = new JTextField();
		textFieldID.setText(user.getuID());
		textFieldID.setEnabled(false);
		textFieldID.setEditable(false);
		textFieldID.setColumns(10);
		textFieldID.setBounds(209, 343, 189, 37);
		panel.add(textFieldID);
		
		textFieldMajor = new JTextField();
		textFieldMajor.setText(Integer.toString(user.getuMajor()));
		textFieldMajor.setEnabled(false);
		textFieldMajor.setEditable(false);
		textFieldMajor.setColumns(10);
		textFieldMajor.setBounds(209, 386, 189, 37);
		panel.add(textFieldMajor);
		
		JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/左喷泉背景.png")));
		backgroundLabel.setBounds(0, 0, 900, 600);
		contentPane.add(backgroundLabel);
		
		/*JButton button = new JButton("New button");
		button.setBounds(768, 549, 97, 23);
		contentPane.add(button);*/
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(790, 549, 97, 23);
		contentPane.add(button_1);
        JButton button = new JButton("确认");
        button.setBounds(613, 474, 132, 48);

        button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button.setBackground(Color.white);
        contentPane.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 关闭当前窗口
            }
        });

        initializeLabelsAndTextFields(panel);
        initializeBackground();
        setSize(900,600);
    }

    private void initializeLabelsAndTextFields(JPanel panel) {
        // 初始化标签和文本字段

        JLabel lblNewLabel = new JLabel("学生信息");
        lblNewLabel.setBounds(115, 64, 283, 43);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
    	
        JLabel lblID = new JLabel("一卡通号：");
        lblID.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblID.setBounds(116, 343, 208, 37);
        panel.add(lblID);

        JLabel lblName = new JLabel("姓名：");
        lblName.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblName.setBounds(116, 117, 208, 45);
        panel.add(lblName);

        JLabel lblGender = new JLabel("性别：");
        lblGender.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblGender.setBounds(116, 160, 208, 45);
        panel.add(lblGender);

        JLabel lblGrade = new JLabel("年级：");
        lblGrade.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblGrade.setBounds(116, 204, 208, 45);
        panel.add(lblGrade);

        JLabel lblMajor = new JLabel("专业：");
        lblMajor.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblMajor.setBounds(116, 378, 208, 45);
        panel.add(lblMajor);

        JLabel lblBirthday = new JLabel("出生日期：");
        lblBirthday.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblBirthday.setBounds(116, 246, 208, 45);
        panel.add(lblBirthday);

        JLabel lblBirthplace = new JLabel("出生地：");
        lblBirthplace.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblBirthplace.setBounds(116, 296, 208, 37);
        panel.add(lblBirthplace);

        textFieldName = new JTextField();
        textFieldName.setEnabled(false);
        textFieldName.setEditable(false);
        textFieldName.setBounds(209, 125, 189, 37);
        panel.add(textFieldName);
        textFieldName.setColumns(10);

        JComboBox<String> comboBoxGender = new JComboBox<String>();
        comboBoxGender.setEnabled(false);
        comboBoxGender.setBounds(323, 168, 75, 37);
        comboBoxGender.addItem("男");
        comboBoxGender.addItem("女");
        panel.add(comboBoxGender);

        textFieldAge = new JTextField();
        textFieldAge.setEnabled(false);
        textFieldAge.setEditable(false);
        textFieldAge.setColumns(10);
        textFieldAge.setBounds(209, 212, 189, 37);
        panel.add(textFieldAge);

        textFieldBirthplace = new JTextField();
        textFieldBirthplace.setEnabled(false);
        textFieldBirthplace.setEditable(false);
        textFieldBirthplace.setColumns(10);
        textFieldBirthplace.setBounds(209, 296, 189, 37);
        panel.add(textFieldBirthplace);

        textFieldBirthday = new JTextField();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  // 选择你需要的日期格式
		textFieldBirthday.setText("");  // 格式化 Date 为 String
		textFieldBirthday.setEnabled(false);
		textFieldBirthday.setEditable(false);
		textFieldBirthday.setColumns(10);
		textFieldBirthday.setBounds(209, 254, 189, 37);
		panel.add(textFieldBirthday);


        textFieldID = new JTextField();
        textFieldID.setEnabled(false);
        textFieldID.setEditable(false);
        textFieldID.setColumns(10);
        textFieldID.setBounds(209, 343, 189, 37);
        panel.add(textFieldID);

        textFieldMajor = new JTextField();
        textFieldMajor.setEnabled(false);
        textFieldMajor.setEditable(false);
        textFieldMajor.setColumns(10);
        textFieldMajor.setBounds(209, 386, 189, 37);
        panel.add(textFieldMajor);
        
    }
    private void initializeBackground() {
        JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/左喷泉背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        contentPane.add(backgroundLabel);
        backgroundLabel.setLayout(null);
    }
}

