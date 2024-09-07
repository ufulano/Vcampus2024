package tech.client.studentManage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import Entity.BookEntity;
import tech.client.main.MainStudent;

import Entity.*;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;
import javax.swing.JOptionPane;
/**
 * 管理员查看单个学生的学籍信息，根据功能不同有不同的初始化方式
 */
public class StudentDetails extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldName;
    private JTextField textFieldGender;
    private JTextField textFieldBirthday;
    private JTextField textFieldGrade;
    private JTextField textFieldBirthplace;
    private JTextField textFieldID;
    private JTextField textFieldMajor;
    private JTextField textField;
    private JSpinner birthdaySpinner;
    
    private String status; // 用于记录操作状态

    public StudentDetails(UserEntity user) {
        setTitle("Vcampus·学生信息");
        setResizable(false);
        
        status = "新窗口";
        
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


        JButton button = new JButton("确认");
        button.setBounds(613, 474, 132, 48);
        button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button.setBackground(Color.white);
        contentPane.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            		status = "确认";
            		System.out.println("确认学生");
            		dispose(); // 关闭当前窗口
            }
        });

        initializeLabelsAndTextFields(panel,user);
        
        initializeBackground();
        setSize(900,600);
    }

    private void initializeLabelsAndTextFields(JPanel panel,UserEntity user) {
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

        textFieldGender = new JTextField();
        textFieldGender.setEnabled(false);
        textFieldGender.setEditable(false);
        textFieldGender.setColumns(10);
        textFieldGender.setBounds(209, 168, 189, 37);
        panel.add(textFieldGender);


        textFieldGrade = new JTextField();
        textFieldGrade.setEnabled(false);
        textFieldGrade.setEditable(false);
        textFieldGrade.setColumns(10);
        textFieldGrade.setBounds(209, 212, 189, 37);
        panel.add(textFieldGrade);

        textFieldBirthplace = new JTextField();
        textFieldBirthplace.setEnabled(false);
        textFieldBirthplace.setEditable(false);
        textFieldBirthplace.setColumns(10);
        textFieldBirthplace.setBounds(209, 296, 189, 37);
        panel.add(textFieldBirthplace);

        // 日期
        textFieldBirthday = new JTextField();
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
        
        textFieldName.setText(user.getuName());
        textFieldGender.setText(user.getuGender());
        textFieldGrade.setText(Integer.toString(user.getuGrade()));
        textFieldBirthplace.setText(user.getuBirthplace());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        textFieldBirthday.setText(dateFormat.format(user.getuBirthday()));
        textFieldID.setText(user.getuID());
        textFieldMajor.setText(Integer.toString(user.getuMajor()));
        
    }

    private void initializeBackground() {
        JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/左喷泉背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        contentPane.add(backgroundLabel);
        backgroundLabel.setLayout(null);
    }
    

    
    public String getStatus() {
        return status; // 返回用户操作状态
    }

    // 设置状态的假设方法
    public void setStatus(String status) {
        this.status = status;
    }
}
