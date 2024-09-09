package tech.client.schedule;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseSelectionBlock extends JPanel {
    private static final long serialVersionUID = 1L;
    private String courseID;
    private String courseName;
    private int credits;
    private int capacity;
    private int available;
    private String dayOfWeek; // 星期几
    private String timePeriod; // 节数
    private String instructor; // 任课老师
    private JButton btnSelectCourse;
    private boolean isSelected; // 是否已选
    
 // 缺省构造函数
    public CourseSelectionBlock() {
        setVisible(false); // 设置整个JPanel不可见
    }

    public CourseSelectionBlock(String courseID, String courseName, int credits, int capacity, int available, 
                                String dayOfWeek, String timePeriod, String instructor, boolean isSelected) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
        this.capacity = capacity;
        this.available = available;
        this.dayOfWeek = dayOfWeek;
        this.timePeriod = timePeriod;
        this.instructor = instructor;
        this.isSelected = isSelected;
        initialize();
    }

    private void initialize() {
        setBorder(new LineBorder(new Color(205, 226, 235), 3, true));
        setBackground(Color.WHITE);
        setLayout(null);

        Font yaheiFont = new Font("微软雅黑", Font.PLAIN, 16);

        JLabel lblCourseName = new JLabel(courseName);
        lblCourseName.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblCourseName.setBounds(55, 22, 200, 25);
        add(lblCourseName);

        JLabel lblCredits = new JLabel("学分: " + credits);
        lblCredits.setFont(yaheiFont);
        lblCredits.setBounds(55, 52, 200, 25);
        add(lblCredits);

        JLabel lblCapacity = new JLabel("容量: " + capacity);
        lblCapacity.setFont(yaheiFont);
        lblCapacity.setBounds(55, 82, 200, 25);
        add(lblCapacity);

        JLabel lblAvailable = new JLabel("剩余: " + available);
        lblAvailable.setFont(yaheiFont);
        lblAvailable.setBounds(55, 112, 200, 25);
        add(lblAvailable);

        JLabel lblSchedule = new JLabel("时间: " + dayOfWeek + " " + timePeriod);
        lblSchedule.setVerticalAlignment(SwingConstants.TOP);
        lblSchedule.setFont(yaheiFont);
        lblSchedule.setBounds(55, 182, 222, 44);
        add(lblSchedule);

        JLabel lblInstructor = new JLabel("老师: " + instructor);
        lblInstructor.setFont(yaheiFont);
        lblInstructor.setBounds(55, 147, 200, 25);
        add(lblInstructor);

        btnSelectCourse = new JButton(isSelected ? "已选" : "选择课程");
        btnSelectCourse.setBackground(new Color(205, 230, 233));
        btnSelectCourse.setFont(yaheiFont);
        btnSelectCourse.setBounds(55, 225, 222, 44);
        btnSelectCourse.setOpaque(false);
        if (isSelected) {
            btnSelectCourse.setEnabled(false);
        } else {
            btnSelectCourse.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectCourse();
                }
            });
        }
        add(btnSelectCourse);
    }

    //选择当前课程
    private void selectCourse() {
        System.out.println("Selected course: " + courseName);
        
    }

    @Override
    public String toString() {
        return "CourseSelectionBlock{" +
                "courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", capacity=" + capacity +
                ", available=" + available +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", timePeriod='" + timePeriod + '\'' +
                ", instructor='" + instructor + '\'' +
                ", isSelected=" + isSelected +
                '}';
    }
}