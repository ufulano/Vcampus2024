package tech.client.studentManage;

import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import tech.client.main.MainStudent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * 学生查看自己的学籍信息，不可更改
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

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SMStudentPersonal frame = new SMStudentPersonal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SMStudentPersonal() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(SMStudentPersonal.class.getResource("/resources/icon/icon1/ic_student.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Vcampus·学籍信息");
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(900, 600);
        getContentPane().setBackground(new Color(135, 206, 250));
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(345, 0, 404, 431);
        contentPane.add(panel);
        panel.setOpaque(false); // 设置为不透明，这样它会显示其父容器的背景
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("学籍信息");
        lblNewLabel.setBounds(115, 64, 133, 43);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));

        JButton button = new JButton("返回");
        button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button.setBounds(617, 441, 132, 48);
        button.setBackground(Color.white);
        contentPane.add(button);
        button.addActionListener(e -> this.dispose()); // 添加事件监听器

        initializeLabelsAndTextFields(panel);

        JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/左喷泉背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        contentPane.add(backgroundLabel);
    }

    private void initializeLabelsAndTextFields(JPanel panel) {
        // 初始化标签和文本字段
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
        textFieldName.setEnabled(false);
        textFieldName.setEditable(false);
        textFieldName.setBounds(209, 125, 189, 37);
        panel.add(textFieldName);
        textFieldName.setColumns(10);

        textFieldGender = new JTextField();
        textFieldGender.setEnabled(false);
        textFieldGender.setEditable(false);
        textFieldGender.setBounds(209, 168, 189, 37);
        panel.add(textFieldGender);
        textFieldGender.setColumns(10);

        textFieldAge = new JTextField();
        textFieldAge.setEnabled(false);
        textFieldAge.setEditable(false);
        textFieldAge.setBounds(209, 212, 189, 37);
        panel.add(textFieldAge);
        textFieldAge.setColumns(10);

        textFieldBirthplace = new JTextField();
        textFieldBirthplace.setEnabled(false);
        textFieldBirthplace.setEditable(false);
        textFieldBirthplace.setBounds(209, 296, 189, 37);
        panel.add(textFieldBirthplace);
        textFieldBirthplace.setColumns(10);

        textFieldBirthday = new JTextField();
        textFieldBirthday.setEnabled(false);
        textFieldBirthday.setEditable(false);
        textFieldBirthday.setBounds(209, 254, 189, 37);
        panel.add(textFieldBirthday);
        textFieldBirthday.setColumns(10);

        textFieldID = new JTextField();
        textFieldID.setEnabled(false);
        textFieldID.setEditable(false);
        textFieldID.setBounds(209, 343, 189, 37);
        panel.add(textFieldID);
        textFieldID.setColumns(10);

        textFieldMajor = new JTextField();
        textFieldMajor.setEnabled(false);
        textFieldMajor.setEditable(false);
        textFieldMajor.setBounds(209, 386, 189, 37);
        panel.add(textFieldMajor);
        textFieldMajor.setColumns(10);
    }
}