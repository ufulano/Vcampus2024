package tech.client.studentManage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    private JTextField textFieldAge;
    private JTextField textFieldBirthplace;
    private JTextField textFieldBirthday;
    private JTextField textFieldID;
    private JTextField textFieldMajor;
    private JTextField textField;
    
    private String status; // 用于记录操作状态

    public StudentDetails(String s) {
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
            	//先检查是否有字段为空
            	boolean anyFieldEmpty = checkFieldsEmpty(textFieldName, textFieldGender, textFieldAge, 
                        textFieldBirthplace, textFieldBirthday, 
                        textFieldID, textFieldMajor);
            	if(anyFieldEmpty) {
            		 JOptionPane.showMessageDialog(null, "有字段为空！", 
                             "Warning", JOptionPane.WARNING_MESSAGE);
            		 return;
            	}
            	else {
            		status = "确认";
            		System.out.println("确认学生");
            		dispose(); // 关闭当前窗口
            	}
            }
        });

        initializeLabelsAndTextFields(panel,s);
        
        JLabel lblPassword = new JLabel("密码：");
        lblPassword.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblPassword.setBounds(115, 419, 208, 45);
        panel.add(lblPassword);
        
        textField = new JTextField();
        //textField.setEnabled(false);
        //textField.setEditable(false);
        textField.setColumns(10);
        textField.setBounds(208, 427, 189, 37);
        panel.add(textField);
        initializeBackground();
        setSize(900,600);
    }

    private void initializeLabelsAndTextFields(JPanel panel,String s) {
        // 初始化标签和文本字段

        JLabel lblNewLabel = new JLabel(s);
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

        textFieldName = new JTextField();
        //textFieldName.setEnabled(false);
        //textFieldName.setEditable(false);
        textFieldName.setBounds(209, 125, 189, 37);
        panel.add(textFieldName);
        textFieldName.setColumns(10);

        textFieldGender = new JTextField();
        //textFieldGender.setEnabled(false);
        //textFieldGender.setEditable(false);
        textFieldGender.setColumns(10);
        textFieldGender.setBounds(209, 168, 189, 37);
        panel.add(textFieldGender);

        textFieldAge = new JTextField();
        //textFieldAge.setEnabled(false);
        //textFieldAge.setEditable(false);
        textFieldAge.setColumns(10);
        textFieldAge.setBounds(209, 212, 189, 37);
        panel.add(textFieldAge);

        textFieldBirthplace = new JTextField();
        //textFieldBirthplace.setEnabled(false);
        //textFieldBirthplace.setEditable(false);
        textFieldBirthplace.setColumns(10);
        textFieldBirthplace.setBounds(209, 296, 189, 37);
        panel.add(textFieldBirthplace);

        textFieldBirthday = new JTextField();
        //textFieldBirthday.setEnabled(false);
        //textFieldBirthday.setEditable(false);
        textFieldBirthday.setColumns(10);
        textFieldBirthday.setBounds(209, 254, 189, 37);
        panel.add(textFieldBirthday);

        textFieldID = new JTextField();
        //textFieldID.setEnabled(false);
        //textFieldID.setEditable(false);
        textFieldID.setColumns(10);
        textFieldID.setBounds(209, 343, 189, 37);
        panel.add(textFieldID);

        textFieldMajor = new JTextField();
        //textFieldMajor.setEnabled(false);
        //textFieldMajor.setEditable(false);
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
    
    //点击确认时调用获取用户并传递
    public UserEntity getUser() {
        UserEntity user=new UserEntity();
        user.setuName(textFieldName.getText());
        user.setuGender(textFieldGender.getText());
        user.setuAge(Integer.parseInt(textFieldAge.getText()));
        user.setuBirthplace(textFieldBirthplace.getText());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//指定日期格式
        try {
        java.util.Date utilDate = dateFormat.parse(textFieldBirthday.getText());
        user.setuBirthday(new Date(utilDate.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setuID(textFieldID.getText());
        user.setuMajor(Integer.parseInt(textFieldMajor.getText()));
        user.setuPwd(textField.getText());
        System.out.println(user);
    	return user;
    }
    
    private static boolean checkFieldsEmpty(JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                return true; // 找到空字段
            }
        }
        return false; // 所有字段都有内容
    }
    
    public String getStatus() {
        return status; // 返回用户操作状态
    }

    // 设置状态的假设方法
    public void setStatus(String status) {
        this.status = status;
    }
}
