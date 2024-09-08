package tech.client.schedule;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import Entity.CourseEntity;
import tech.client.main.MainStudent;

/**
 * 选课界面GUI，学生端
 * 注意 
 */
public class CourseSelectionGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel mainContentPane;
    private JButton backButton;
    private JScrollPane courseScrollPane;
    private JPanel CourseList; // 定义 CourseList 面板
    private JTextField textField;
    private JButton btnNewButton;

    public CourseSelectionGUI() {
        initializeUI();
    }

    private void initializeUI() {
    	
        setTitle("Vcampus·选课系统");
        setIconImage(Toolkit.getDefaultToolkit().getImage(CourseSelectionGUI.class.getResource("")));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        mainContentPane = new JPanel();
        mainContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(mainContentPane);
        mainContentPane.setLayout(null);

        initHeader();
        initNavigationButtons();
        initCourseList();
        initBackground();

        setResizable(false) ;
    	setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initHeader() {
        
    	JComboBox<String> comboBox = new JComboBox<>();
    	comboBox.setBounds(182, 80, 100, 34);
    	// 添加选项
    	comboBox.addItem("全部课程");
    	comboBox.addItem("已选");
    	comboBox.addItem("未选");
    	
    	comboBox.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        String selectedOption = (String) comboBox.getSelectedItem();
    	        if ("已选".equals(selectedOption)) {
    	            // 显示已选课程
    	            showSelectedCourses();
    	        } else if ("未选".equals(selectedOption)) {
    	            // 显示未选课程
    	            showUnselectedCourses();
    	        } else if ("全部课程".equals(selectedOption)) {
    	            // 显示全部课程
    	            showAllCourses();
    	        }
    	    }
    	});
    	mainContentPane.add(comboBox);
    	
        
        btnNewButton = new JButton("搜索");
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        btnNewButton.setBounds(460, 80, 93, 34);
        mainContentPane.add(btnNewButton);
        
        textField = new JTextField();
        textField.setText("请输入课程名称");
        textField.setBounds(292, 82, 158, 34);
        mainContentPane.add(textField);
        textField.setColumns(10);
        JLabel lblVcampus = new JLabel("选课系统", SwingConstants.CENTER);
        lblVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        lblVcampus.setBounds(21, 10, 138, 43);
        mainContentPane.add(lblVcampus);

        backButton = new JButton("返回");
        backButton.setBounds(784, 10, 99, 46);
        backButton.addActionListener(this::backButtonActionPerformed);
        backButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        backButton.setContentAreaFilled(false);
        mainContentPane.add(backButton);
    }

    private void initNavigationButtons() {
        // 左侧按钮
        JButton btnManageCourses = new JButton("已选课程"); 
        btnManageCourses.setBackground(Color.WHITE);
        btnManageCourses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 添加管理课程的逻辑
                manageCourses();
            }
        });
        btnManageCourses.setBounds(1, 77, 171, 84);
        btnManageCourses.setOpaque(false); // 设置按钮透明
        btnManageCourses.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        mainContentPane.add(btnManageCourses);

        JButton btnMySchedule = new JButton("我的课表"); // 直接跳转到我的课表
        btnMySchedule.setBackground(Color.WHITE);
        btnMySchedule.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 添加查看我的课表的逻辑
                showMySchedule();
            }
        });
        btnMySchedule.setBounds(0, 171, 172, 84);
        btnMySchedule.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        btnMySchedule.setOpaque(false); // 设置按钮透明
        mainContentPane.add(btnMySchedule);
    }



    private void initCourseList() {
        CourseList = new JPanel();
        CourseList.setOpaque(false);
        CourseList.setLayout(new GridLayout(0, 2, 10, 10)); // 设置布局为两列，间距为 10
        courseScrollPane = new JScrollPane(CourseList);
        courseScrollPane.setBounds(183, 126, 693, 427);
        mainContentPane.add(courseScrollPane);
        courseScrollPane.setViewportView(CourseList);
        CourseList.setPreferredSize(new Dimension(courseScrollPane.getWidth() - 50, 300 * 5));

        // 获取课程列表
        List<CourseSelection> courseList = getCourseList();

        // 为方便调试使用缺省的 CourseSelectionBlock
        int count = 0;
        for (CourseSelection courseselection : courseList) {
            CourseSelectionBlock courseBlock = new CourseSelectionBlock(
            		courseselection.course.getcCourseID(),
            		courseselection.course.getcCourseName(),
            		courseselection.course.getcCredits(),
            		courseselection.course.getcCapacity(),
            		courseselection.course.getcAvailable(),
                    "星期一", // 假设的星期几
                    "1-2节", // 假设的节数
                    "张三" ,// 假设的任课老师  
                    courseselection.getisSelected()
            );
            CourseList.add(courseBlock);
            count++;
        }

        // 如果课程数量不足10个，添加空白的 CourseSelectionBlock 填充
        while (count < 10) {
            CourseSelectionBlock emptyBlock = new CourseSelectionBlock();
            CourseList.add(emptyBlock);
            count++;
        }
    }

    private void initBackground() {
        JLabel backgroundLabel = new JLabel(new ImageIcon(CourseSelectionGUI.class.getResource("/resources/picture/老师课表背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 573);
        mainContentPane.add(backgroundLabel);
    }
    
    private void showSelectedCourses() {
        // 实现显示已选课程的逻辑
        System.out.println("Displaying selected courses...");
    }

    private void showUnselectedCourses() {
        // 实现显示未选课程的逻辑
        System.out.println("Displaying unselected courses...");
    }

    private void showAllCourses() {
        // 实现显示全部课程的逻辑
        System.out.println("Displaying all courses...");
    }

    private List<CourseSelection> getCourseList() {
        // 创建课程列表
        List<CourseSelection> courseList = new ArrayList<>();
        CourseEntity C1 = new CourseEntity("1", 2024, "高等数学", 4, 1, 1, 60, 50, true, "张三", "1001");
        CourseEntity C2 = new CourseEntity("2", 2024, "线性代数", 3, 2, 1, 50, 40, false, "李四", "1002");
        // 添加课程数据到列表
        courseList.add( new CourseSelection(C1,true));
        courseList.add( new CourseSelection(C2,false));
        // 更多课程数据...

        return courseList;
    }

    private void backButtonActionPerformed(ActionEvent e) {
        System.out.println("返回按钮被点击");
		boolean windowOpen = false;
        Window[] windows = JFrame.getWindows();//获取所有打开窗口
        for (Window window : JFrame.getWindows()) {
            if (window instanceof CourseSelectionGUI&&window.isVisible()) {
                windowOpen = true;
                dispose();
                window.toFront(); // 将窗口带到最前面
                break;
            }
        }
        
        if (!windowOpen) {
        	CourseSelectionGUI window = new CourseSelectionGUI();
        	dispose();
        	System.out.println("回到选课界面.");
            window.setVisible(true);
        } else {
            System.out.println("Course main window is already open.");
        }
    }
    private void manageCourses() {
        // 实现管理课程的功能
        System.out.println("Managing courses...");
        boolean windowOpen = false;
        Window[] windows = JFrame.getWindows();//获取所有打开窗口
        for (Window window : JFrame.getWindows()) {
            if (window instanceof SelectedCoursesGUI &&window.isVisible()) {
                windowOpen = true;
                window.toFront(); // 将窗口带到最前面
                break;
            }
        }
        
        if (!windowOpen) {
        	SelectedCoursesGUI studentWindow = new SelectedCoursesGUI();
            studentWindow.setVisible(true);
        } else {
            System.out.println("Student window is already open.");
        }
    }

    private void showMySchedule() {
        // 实现显示我的课表的功能
        System.out.println("My schedule...");
        boolean windowOpen = false;
        Window[] windows = JFrame.getWindows();//获取所有打开窗口
        for (Window window : JFrame.getWindows()) {
            if (window instanceof scheduleStudentSide &&window.isVisible()) {
                windowOpen = true;
                window.toFront(); // 将窗口带到最前面
                break;
            }
        }
        
        if (!windowOpen) {
        	scheduleStudentSide studentWindow = new scheduleStudentSide();
            studentWindow.setVisible(true);
        } else {
            System.out.println("Student window is already open.");
        }
    }
    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CourseSelectionGUI frame = new CourseSelectionGUI();
            frame.setVisible(true);
        });
    }
    
    public class CourseSelection {
        private CourseEntity course;
        private boolean isSelected;

        public CourseSelection(CourseEntity course, boolean isSelected) {
            this.course = course;
            this.isSelected = isSelected;
        }
        public CourseEntity getCourse() {
            return course;
        }

        public void setCourse(CourseEntity course) {
            this.course = course;
        }
        public boolean getisSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        @Override
        public String toString() {
            return "CourseSelection{" +
                    "course=" + course +
                    ", isSelected=" + isSelected +
                    '}';
        }
    }
}