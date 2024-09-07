package tech.client.schedule;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import Entity.UserEntity;
import Entity.CourseEntity;
import tech.client.library.LibraryManagerGUI;
import tech.client.library.LibraryUserGUI;
import tech.client.main.MainManager;
import tech.client.main.MainStudent;
import tech.client.studentManage.manageOpreation;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;

import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableColumn;

/**
 * 管理员的课程管理主页
 */
public class scheduleManagerSide extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					scheduleManagerSide frame = new scheduleManagerSide();
					frame.setVisible(true);
					frame.setSize(900,600);
					frame.setTitle("Vcampus·选课系统");
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
	public scheduleManagerSide() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainStudent.class.getResource("/resources/icon/icon2/课表.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(597, 103, 155, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// Head
		JLabel lblVcampus = new JLabel("课程管理");
		lblVcampus.setBounds(21, 10, 133, 43);
		lblVcampus.setHorizontalAlignment(SwingConstants.CENTER);
		lblVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		contentPane.add(lblVcampus);
		
		JButton btnBack = new JButton("返回");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.out.println("返回管理员主界面");
					boolean windowOpen = false;
	                Window[] windows = JFrame.getWindows();//获取所有打开窗口
	                for (Window window : JFrame.getWindows()) {
	                    if (window instanceof MainManager&&window.isVisible()) {
	                        windowOpen = true;
	                        dispose();
	                        window.toFront(); // 将窗口带到最前面
	                        break;
	                    }
	                }
	                
	                if (!windowOpen) {
	                	MainManager window = new MainManager();
	                	dispose();
	                    window.setVisible(true);
	                } else {
	                    System.out.println("Manager main window is already open.");
	                }
			}
		});
		btnBack.setBounds(784, 10, 99, 46);
		btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnBack.setContentAreaFilled(false);
		contentPane.add(btnBack);
		
		 // 创建课程列表（默认）
        MTablePanel table = new MTablePanel();
        table.setBorder(null);
        table.setBounds(190, 80, 645, 450);
        contentPane.add(table);

		// 左侧按钮
		JButton btnManage = new JButton("课程总览");  // 选中查看所有课程，点击查看课程详情，【增加】【删改】跳转至课程详情页面
		btnManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//设置为课程列表
			    table.courseList();
			}
		});
		btnManage.setBounds(1, 77, 171, 84);
		btnManage.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		contentPane.add(btnManage);
		
		JButton btnStudentList = new JButton("学生列表"); //选中课程的同时点击，查看当前科目的学生信息，【增加】【删改】弹窗提示
		btnStudentList.setBounds(0, 171, 172, 84);
		btnStudentList.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		contentPane.add(btnStudentList);
		btnStudentList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//设置为课程列表
			    table.stuList();
			}
		});
        
		// 中央工作区
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(762, 99, 97, 33);
		contentPane.add(btnNewButton);
        
    
        
		JButton btnRe = new JButton("删改");
		btnRe.setBackground(Color.WHITE);
		btnRe.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnRe.setBounds(759, 539, 97, 25);
		contentPane.add(btnRe);
		
		JButton btnNew = new JButton("增加");
		btnNew.setBackground(Color.WHITE);
		btnNew.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNew.setBounds(652, 539, 97, 25);
		contentPane.add(btnNew);
                        
        // 背景                
        JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/老师课表背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        backgroundLabel.setOpaque(true); 
        contentPane.add(backgroundLabel);
                        
	}
}
class MTablePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTable infoTable;
    private DefaultTableModel model;
    private TableRowSorter<DefaultTableModel> rowSorter; // 确保声明了 rowSorter

    @SuppressWarnings("serial")
    public MTablePanel() {
        setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        setLayout(null); 
        setSize(900,600);

        // 定义列名
        String[] columnNames = {"课程编号", "学年", "课程名称", "学分","年级", "专业", "最大容量", "剩余名额","授课教师","工号"};

        // 初始化表格模型
        model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        infoTable = new JTable(model);
        rowSorter = new TableRowSorter<>(model);
        infoTable.setRowSorter(rowSorter);
   

        JScrollPane jsp = new JScrollPane(infoTable);
        jsp.setBounds(42, 100, 619, 464);
   

        // 添加组件到面板
        add(jsp);

        // 设置面板大小
        this.setOpaque(false);
        this.validate();
    }
    
    //替换为学生列表
    public void stuList() {
    	//清空当前列表
    	model.setRowCount(0);
    	//更换列名
    	String[] columnNames = {"一卡通号", "姓名", "性别", "学号","年级", "专业", "出生日期", "出生地","密码"};
    	model.setColumnIdentifiers(columnNames);
    	 TableColumnModel columnModel = infoTable.getColumnModel();
         TableColumn passwordColumn = columnModel.getColumn(8); // “密码”列的索引是8
         passwordColumn.setMinWidth(0);
         passwordColumn.setMaxWidth(0);
         passwordColumn.setWidth(0);
    }
    //替换为课程列表
    public void courseList() {
    	//清空当前列表
    	model.setRowCount(0);
    	//更换列名
    	String[] columnNames = {"课程编号", "学年", "课程名称", "学分","年级", "专业", "最大容量", "剩余名额","是否结束","授课教师","工号"};
    	model.setColumnIdentifiers(columnNames);
    }
    
    //向表格中添加课程
    public void addCourse(CourseEntity course) {
    	model.addRow(new Object[]{course.getcCourseID(), course.getcYear(), course.getcCourseName(),course.getcCredits()
                , course.getcGrade(), course.getcMajor(), course.getcCapacity(), course.getcAvailable(),course.getcEnd()
                ,course.getuName(),course.getuNumber()});
    }
    public void addCourselist(List<CourseEntity> list) {
    	for (CourseEntity course : list) {
            model.addRow(new Object[]{course.getcCourseID(), course.getcYear(), course.getcCourseName(),course.getcCredits()
                    , course.getcGrade(), course.getcMajor(), course.getcCapacity(), course.getcAvailable(),course.getcEnd()
                    ,course.getuName(),course.getuNumber()});
    	}
    }
    //向表格中添加学生
    public void addStu(UserEntity user) {
    	model.addRow(new Object[]{user.getuID(), user.getuName(), user.getuGender(),user.getuNumber()
                , user.getuGrade(), user.getuMajor(), user.getuBirthday(), user.getuBirthplace(),user.getuPwd()});
    }
    public void addStulist(List<UserEntity> list) {
    	for (UserEntity user : list) {
            model.addRow(new Object[]{user.getuID(), user.getuName(), user.getuGender(),user.getuNumber()
            , user.getuGrade(), user.getuMajor(), user.getuBirthday(), user.getuBirthplace(),user.getuPwd()});
    	}
    }

    //删除学生
    public void deleteStu() {
    	//获取选中的行索引
    	int selectedRow = infoTable.getSelectedRow();
    	if (selectedRow >= 0) {
    	    model.removeRow(selectedRow);
    	} 
    	else {
    	    JOptionPane.showMessageDialog(null, "请先选择要删除的行", "错误", JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    //获取选中的学生
    //"学号", "姓名", "性别", "学号","年级", "专业", "出生日期", "出生地"
    public UserEntity getStu() {
    	UserEntity user=new UserEntity();
    	int selectedRow = infoTable.getSelectedRow();
    	if (selectedRow >= 0) {
    		user.setuID(model.getValueAt(selectedRow, 0).toString());
    		user.setuName(model.getValueAt(selectedRow, 1).toString());
    	    user.setuGender(model.getValueAt(selectedRow, 2).toString());
    	    user.setuNumber(model.getValueAt(selectedRow, 3).toString());
    	    user.setuGrade(Integer.parseInt(model.getValueAt(selectedRow, 4).toString()));
    	    user.setuMajor(Integer.parseInt(model.getValueAt(selectedRow, 5).toString()));
    	    user.setuBirthplace(model.getValueAt(selectedRow, 7).toString());
    	    user.setuPwd(model.getValueAt(selectedRow, 8).toString());
    	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//指定日期格式
    	        try {
    	        java.util.Date utilDate = dateFormat.parse(model.getValueAt(selectedRow, 6).toString());
    	        user.setuBirthday(new Date(utilDate.getTime()));
    	        } catch (ParseException e) {
    	            e.printStackTrace();
    	        }
    	        System.out.println(user);
    	} 
    	else {
    		JOptionPane.showMessageDialog(null, "未选中行", "错误", JOptionPane.ERROR_MESSAGE);
    	    return null;
    	}
    	return user;
    }
}
