package tech.client.studentManage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
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
import tech.client.library.LibraryUserGUI;
import tech.client.library.MyBookGUI;
import tech.client.login.LoginGUI;
import tech.client.main.MainStudent;
import tech.client.main.UserSession;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import Entity.UserEntity;

import tech.client.main.MainManager;
/**
 * 管理员的学籍管理主页
 */
public class SMManagerSide extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private UserEntity Stu=new UserEntity();
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
        
        // head
		JLabel lblNewLabel = new JLabel("学生管理");
		lblNewLabel.setBounds(21, 10, 133, 43);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("返回");
		btnBack.setBounds(784, 10, 99, 46);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("返回管理员主界面");
				boolean windowOpen = false;
                Window[] windows = JFrame.getWindows();//获取所有打开窗口
                for (Window window : JFrame.getWindows()) {
                    if (window instanceof MainManager&&window.isVisible()) {
                        windowOpen = true;
                        SMManagerSide.this.dispose();
                        window.toFront(); // 将窗口带到最前面
                        break;
                    }
                }
                
                if (!windowOpen) {
                	MainManager window = new MainManager();
                	SMManagerSide.this.dispose();
                    window.setVisible(true);
                } else {
                    System.out.println("Manager main window is already open.");
                }
			}
		});
		btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnBack.setContentAreaFilled(false);
		contentPane.add(btnBack);
        
        JButton btnRe = new JButton("修改信息");
        btnRe.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        btnRe.setBounds(0, 266, 170, 80);
        btnRe.setBackground(Color.white);
        contentPane.add(btnRe);

        
		JButton btnAdd = new JButton("办理入学");
		btnAdd.setBounds(0, 86, 170, 80);
		btnAdd.setIcon(new ImageIcon(MyBookGUI.class.getResource("")));
		btnAdd.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnAdd.setBackground(Color.white);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 这里要添加错误提示
				Stu=null;//初始化
				//跳转到学生细节页面
				System.out.println("打开学生细节...");
				 boolean windowOpen = false;
	                Window[] windows = JFrame.getWindows();//获取所有打开窗口
	                for (Window window : JFrame.getWindows()) {
	                    if (window instanceof StudentDetails&&window.isVisible()) {
	                        windowOpen = true;
	                        window.toFront(); // 将窗口带到最前面
	                        break;
	                    }
	                }
	                
	                if (!windowOpen) {
	                	StudentDetails window = new StudentDetails("办理入学");
	                    window.setVisible(true);
	                    
	                    window.addWindowListener(new java.awt.event.WindowAdapter() {
	                        @Override
	                        public void windowClosed(java.awt.event.WindowEvent e) {
	                            // 在窗口关闭时检测状态
	                            String status = window.getStatus();
	                            if ("确认".equals(status)) {
	                            	Stu=window.getUser();
	                            } else {
	                            	return;
	                            }
	                            
	                            if(Stu!=null) {
	                				//UserEntity user = UserSession.getInstance().getUser();
	                                	 System.out.println("创建");
	                                	 System.out.println(Stu);
	                                	 menageOpreation.refreshStu(Stu);
	                                }
	                        } 
	                    });
	                }
	                else {
	                    System.out.println("Manager window is already open.");
	                }
				//按ID查询学生是否存在
				/*List<UserEntity> userlist =menageOpreation.getStudentManage(newStu.getuID());
				//学生不存在
				if(userlist!=null) {
					
				}
				else {
					System.out.println("学生已存在！");
					return;
				}*/
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
				/*Stu=null;//初始化
				boolean windowOpen = false;
                Window[] windows = JFrame.getWindows();//获取所有打开窗口
                for (Window window : JFrame.getWindows()) {
                    if (window instanceof StudentDetails && window.isVisible()) {
                        windowOpen = true;
                        window.toFront(); // 将窗口带到最前面
                        break;
                    }
                }
                
                if (!windowOpen) {
                	StudentDetails window = new StudentDetails("办理退学");
                    window.setVisible(true);
                    window.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent e) {
                            // 在窗口关闭时检测状态
                        	System.out.println("学生细节关闭");
                            String status = window.getStatus();
                            System.out.println("status:"+status);
                            if ("确认".equals(status)) {
                            	Stu=window.getUser();
                            	System.out.println("STU:"+Stu);
                            } else {
                            	return;
                            }
                           
                            if(Stu!=null) {
            				//UserEntity user = UserSession.getInstance().getUser();
                            	 System.out.println("删除");
                            	 System.out.println(Stu);
                            	 menageOpreation.deleteStu(Stu);
                            }
                            else {
                            	System.out.println("学生为空");
                            	return;
                            }
                        } 
                    });
                } else {
                    System.out.println("Manager window is already open.");
                }*/
				menageOpreation.deleteStu(Stu);
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
            	// 查询后在表格展示
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
        this.setOpaque(false);
        this.validate();
    }
}