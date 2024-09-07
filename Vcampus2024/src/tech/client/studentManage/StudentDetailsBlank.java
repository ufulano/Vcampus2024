package tech.client.studentManage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

import Entity.BookEntity;
import Entity.UserEntity;
import tech.client.main.MainStudent;
import tools.DateChooserPanel;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
/**
 * 入学界面
 */
public class StudentDetailsBlank extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldName;
    private JTextField textFieldGrade;
    private JTextField textFieldBirthplace;
    private JTextField textFieldID;
    private JTextField textFieldMajor;
    private JTextField textFieldPassWord;
    private JSpinner birthdaySpinner;
    JComboBox<String> comboBoxGender = new JComboBox<String>();
    
    private String status; // 用于记录操作状态

    public StudentDetailsBlank(UserEntity user) {
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


        JButton button = new JButton("确认");
        button.setBounds(613, 474, 132, 48);
        button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button.setBackground(Color.white);
        contentPane.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(checkFieldsEmpty(textFieldName, textFieldGrade, textFieldBirthplace, textFieldID, textFieldMajor, textFieldPassWord)){//有空字段
            		JOptionPane.showMessageDialog(null, "有空字段", "错误", JOptionPane.ERROR_MESSAGE);
            		return;
            	}
        		status = "确认";
        		System.out.println("确认学生");
        		dispose(); // 关闭当前窗口
            }
        });

        JLabel lblNewLabel = new JLabel("学生入学");
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

        JLabel lblPassword = new JLabel("密码：");
        lblPassword.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblPassword.setBounds(115, 419, 208, 45);
        panel.add(lblPassword);
        
        textFieldName = new JTextField();
        textFieldName.setBounds(209, 125, 189, 37);
        panel.add(textFieldName);
        textFieldName.setColumns(10);

        textFieldGrade = new JTextField();
        textFieldGrade.setColumns(10);
        textFieldGrade.setBounds(209, 212, 189, 37);
        panel.add(textFieldGrade);

        textFieldBirthplace = new JTextField();
        textFieldBirthplace.setColumns(10);
        textFieldBirthplace.setBounds(209, 296, 189, 37);
        panel.add(textFieldBirthplace);
        

        comboBoxGender.setBounds(323, 168, 75, 37);
        comboBoxGender.addItem("男");
        comboBoxGender.addItem("女");
        if (user.getuGender().equals("0")) {
            comboBoxGender.setSelectedItem("男");
        } else if (user.getuGender().equals("1")) {
            comboBoxGender.setSelectedItem("女");
        }
        panel.add(comboBoxGender);

        textFieldID = new JTextField();
        textFieldID.setColumns(10);
        textFieldID.setBounds(209, 343, 189, 37);
        panel.add(textFieldID);

        
        textFieldMajor = new JTextField();
        textFieldMajor.setColumns(10);
        textFieldMajor.setBounds(209, 386, 189, 37);
        panel.add(textFieldMajor);


        
        textFieldPassWord = new JTextField();
        textFieldPassWord.setColumns(10);
        textFieldPassWord.setBounds(208, 427, 189, 37);
        panel.add(textFieldPassWord);
        textFieldPassWord.setText(user.getuPwd());

     // 创建并设置日期选择器
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1); // 设置为2000年1月1日
        java.util.Date defaultDate = calendar.getTime();
        SpinnerDateModel model = new SpinnerDateModel(defaultDate, null, null, Calendar.DAY_OF_MONTH);
        birthdaySpinner = new JSpinner(model);
        birthdaySpinner.setEditor(new JSpinner.DateEditor(birthdaySpinner, "yyyy-MM-dd"));
        birthdaySpinner.setBounds(209, 254, 189, 37);
        panel.add(birthdaySpinner);
        
        textFieldName.setText(user.getuName());
        textFieldGrade.setText(Integer.toString(user.getuGrade()));
        textFieldBirthplace.setText(user.getuBirthplace());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        textFieldID.setText(user.getuID());
        textFieldMajor.setText(Integer.toString(user.getuMajor()));
        
 
        initializeBackground();
        setSize(900,600);
    }

    public StudentDetailsBlank() {
    	System.out.println("Blank");
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


        JButton button = new JButton("确认");
        button.setBounds(613, 474, 132, 48);
        button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button.setBackground(Color.white);
        contentPane.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(checkFieldsEmpty(textFieldName, textFieldGrade, textFieldBirthplace, textFieldID, textFieldMajor, textFieldPassWord)){//有空字段
            		JOptionPane.showMessageDialog(null, "有空字段", "错误", JOptionPane.ERROR_MESSAGE);
            		return;
            	}
        		status = "确认";
        		System.out.println("确认学生");
        		dispose(); // 关闭当前窗口
            }
        });

        JLabel lblNewLabel = new JLabel("学生入学");
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

        JLabel lblPassword = new JLabel("密码：");
        lblPassword.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblPassword.setBounds(115, 419, 208, 45);
        panel.add(lblPassword);
        
        textFieldName = new JTextField();
        textFieldName.setBounds(209, 125, 189, 37);
        panel.add(textFieldName);
        textFieldName.setColumns(10);

        textFieldGrade = new JTextField();
        textFieldGrade.setColumns(10);
        textFieldGrade.setBounds(209, 212, 189, 37);
        panel.add(textFieldGrade);

        textFieldBirthplace = new JTextField();
        textFieldBirthplace.setColumns(10);
        textFieldBirthplace.setBounds(209, 296, 189, 37);
        panel.add(textFieldBirthplace);
        

        comboBoxGender.setBounds(323, 168, 75, 37);
        comboBoxGender.addItem("男");
        comboBoxGender.addItem("女");
        panel.add(comboBoxGender);

        textFieldID = new JTextField();
        textFieldID.setColumns(10);
        textFieldID.setBounds(209, 343, 189, 37);
        panel.add(textFieldID);

        textFieldMajor = new JTextField();
        textFieldMajor.setColumns(10);
        textFieldMajor.setBounds(209, 386, 189, 37);
        panel.add(textFieldMajor);

        

        
        textFieldPassWord = new JTextField();
        textFieldPassWord.setColumns(10);
        textFieldPassWord.setBounds(208, 427, 189, 37);
        panel.add(textFieldPassWord);
        

     // 创建并设置日期选择器
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1); // 设置为2000年1月1日
        java.util.Date defaultDate = calendar.getTime();
        SpinnerDateModel model = new SpinnerDateModel(defaultDate, null, null, Calendar.DAY_OF_MONTH);
        birthdaySpinner = new JSpinner(model);
        birthdaySpinner.setEditor(new JSpinner.DateEditor(birthdaySpinner, "yyyy-MM-dd"));
        birthdaySpinner.setBounds(209, 254, 189, 37);
        panel.add(birthdaySpinner);
 
        initializeBackground();
        setSize(900,600);
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
        user.setuGender((String) comboBoxGender.getSelectedItem());
        user.setuGrade(Integer.parseInt(textFieldGrade.getText()));
        user.setuBirthplace(textFieldBirthplace.getText());
        user.setuPwd(textFieldPassWord.getText());
        java.util.Date selectedDate = (java.util.Date) birthdaySpinner.getValue();
        user.setuBirthday(new Date(selectedDate.getTime()));

        user.setuID(textFieldID.getText());
        user.setuMajor(Integer.parseInt(textFieldMajor.getText()));
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
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	StudentDetailsBlank frame = new StudentDetailsBlank();
            frame.setVisible(true);
        });
    }
}

