package tech.client.studentManage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entity.UserEntity;
import tech.client.library.LibraryStudentGUI;
import tech.client.library.MyBookGUI;
import tech.client.main.MainStudent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class SMManagerSide extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SMManagerSide frame = new SMManagerSide();
                frame.setVisible(true);
                frame.setTitle("Vcampus·学籍信息");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SMManagerSide() {
        // 设置窗口图标
        ImageIcon icon = new ImageIcon(SMStudentPersonal.class.getResource("/resources/icon/icon1/ic_student.png"));
        this.setIconImage(icon.getImage());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        contentPane = new JPanel();
        contentPane.setBackground(new Color(135, 206, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        // 创建 StudentTablePanel 
        StudentTablePanel studentPanel = new StudentTablePanel();
        studentPanel.setBorder(null);
        studentPanel.setBounds(180, 70, 720, 493);
        contentPane.add(studentPanel);
        
		JLabel lblNewLabel = new JLabel("学生管理");
		lblNewLabel.setBounds(21, 10, 133, 43);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);
        
        JButton btnReMajor = new JButton("转专业");
        btnReMajor.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        btnReMajor.setBounds(0, 356, 170, 80);
        btnReMajor.setBackground(Color.white);
        contentPane.add(btnReMajor);
        
        JButton btnRePassword = new JButton("修改密码");
        btnRePassword.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        btnRePassword.setBounds(0, 266, 170, 80);
        btnRePassword.setBackground(Color.white);
        contentPane.add(btnRePassword);

        
		JButton btnAdd = new JButton("办理入学");
		btnAdd.setBounds(0, 86, 170, 80);
		btnAdd.setIcon(new ImageIcon(MyBookGUI.class.getResource("")));
		btnAdd.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnAdd.setBackground(Color.white);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 这里要添加错误提示

			}
		});
		contentPane.add(btnAdd);

		JButton btnDelete = new JButton("办理退学");
		btnDelete.setBounds(0, 176, 170, 80);
		btnDelete.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnDelete.setIcon(new ImageIcon(MyBookGUI.class.getResource("")));
		btnDelete.setBackground(Color.white);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		contentPane.add(btnDelete);
		
        JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/老师课表背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        backgroundLabel.setOpaque(false); 
        contentPane.add(backgroundLabel);
        
        setSize(900,600);
    }
    
}


class StudentTablePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTable infoTable;
    private JTextField textGrade;
    private DefaultTableModel model;

    @SuppressWarnings("serial")
	public StudentTablePanel() {
        setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        setLayout(null); 
        setSize(900,600);
        // 初始化表格模型
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int a, int b) {
                return false;
            }
        };

        infoTable = new JTable(model);
        JScrollPane jsp = new JScrollPane(infoTable);
        jsp.setBounds(42, 100, 619, 464);

        // 初始化文本框和下拉框
        textGrade = new JTextField();
        textGrade.setBounds(287, 50, 113, 30);
        textGrade.setColumns(10);

        JComboBox<String> comboMajor = new JComboBox<>(new String[] {"计算机科学", "电子工程", "机械工程"});
        comboMajor.setBounds(89, 49, 151, 30);

        // 初始化标签
        JLabel lblMajor = new JLabel("专业");
        lblMajor.setBounds(50, 55, 100, 20);

        JLabel lblGrade = new JLabel("年级");
        lblGrade.setBounds(250, 55, 100, 20);

        // 初始化查询按钮
        JButton btnSearch = new JButton("查询");
        btnSearch.setBounds(428, 49, 80, 30);
        btnSearch.setBackground(Color.white);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 查询逻辑
            }
        });

        // 添加组件到面板
        add(jsp);
        add(textGrade);
        add(comboMajor);
        add(lblMajor);
        add(lblGrade);
        add(btnSearch);

        // 设置面板大小
        this.setSize(900, 600);
        this.setOpaque(false);

        // 由于使用绝对布局，需要调用 validate() 来应用布局
        this.validate();
    }
}