package tech.client.schedule;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import tech.client.main.UserSession;
import tech.client.studentManage.StudentDetails;
import tech.client.studentManage.manageOpreation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Entity.*;

public class SelectedCoursesGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel mainContentPane;
    private JTable coursesTable;
    private List<CourseEntity> selectedCourses; // 已选课程列表

    public SelectedCoursesGUI() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Vcampus·已选课程");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        mainContentPane = new JPanel();
        mainContentPane.setBackground(new Color(205, 230, 233));
        setContentPane(mainContentPane);
     		
     		JButton btnRemove = new JButton("退选");
     		btnRemove.setBackground(Color.WHITE);
     		btnRemove.setFont(new Font("微软雅黑", Font.PLAIN, 20));
     		btnRemove.setContentAreaFilled(false);
     		btnRemove.setBounds(775, 486, 99, 46);
     		mainContentPane.add(btnRemove);
        
     // Head
     		JLabel lblVcampus = new JLabel("已选课程");
     		lblVcampus.setBounds(21, 10, 133, 43);
     		lblVcampus.setHorizontalAlignment(SwingConstants.CENTER);
     		lblVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 30));
     		mainContentPane.add(lblVcampus);
     		
     		JButton btnBack = new JButton("返回");
     		btnBack.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				dispose();
     			}
     		});
     		btnBack.setBounds(775, 12, 99, 46);
     		btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 20));
     		btnBack.setContentAreaFilled(false);
     		mainContentPane.add(btnBack);

        // 获得已选课程
        selectedCourses = getSelectedCourses();

        // 创建表格模型
        String[] columnNames = {"课程ID", "课程名称", "学分", "容量", "上课时间", "上课地点"};
        Object[][] data = new Object[selectedCourses.size()][columnNames.length];
        for (int i = 0; i < selectedCourses.size(); i++) {
            CourseEntity course = selectedCourses.get(i);
            ScheduleEntity schedule=courseOperation.getSchedule(course);
            if(course!=null&&schedule!=null) {
            // ScheduleEntity schedule = selectedCourses.get(i);
            data[i] = new Object[]{
                course.getcCourseID(),
                course.getcCourseName(),
                course.getcCredits(),
                course.getcCapacity(),
                schedule.getsDayofWeek(),
                schedule.getsTimePeriod(),
                schedule.getsClassroom(),
                " ",
                " ",
                ""
            };
            }
            else {
            	JOptionPane.showMessageDialog(null, "信息拉取失败", "错误", JOptionPane.ERROR_MESSAGE);
            	return;
            }
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 8; // 只有操作列可编辑
            }
        };
        mainContentPane.setLayout(null);

        coursesTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(coursesTable);
        scrollPane.setBounds(10, 61, 864, 397);
        mainContentPane.add(scrollPane);
        

        JLabel lblNewLabel = new JLabel("选中课程点击下方“退选”即可退选课程！");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        lblNewLabel.setBounds(164, 32, 228, 15);
        mainContentPane.add(lblNewLabel);

        //退选操作
        btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if("成功".equals(courseOperation.backcourse(getCourse()))){
				 JOptionPane.showMessageDialog(null, 
                         "退选成功", 
                         "提示", 
                         JOptionPane.INFORMATION_MESSAGE);
			}
				else {
					JOptionPane.showMessageDialog(null, "退选失败", "错误", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

    }

     //获取表格选中栏
    public CourseEntity getCourse() {
    	CourseEntity course=new CourseEntity();
    	//获取选中的行索引
    	int selectedRow = coursesTable.getSelectedRow();
    	if (selectedRow >= 0) {
    		course.setcCourseID(coursesTable.getValueAt(selectedRow, 0).toString());
    		course.setcCourseName(coursesTable.getValueAt(selectedRow, 1).toString());
    		course.setcCredits(Integer.parseInt(coursesTable.getValueAt(selectedRow, 2).toString()));
    		course.setcCapacity(Integer.parseInt(coursesTable.getValueAt(selectedRow, 3).toString()));
    	    System.out.println(course);
    	} 
    	else {
    		JOptionPane.showMessageDialog(null, "未选中行", "错误", JOptionPane.ERROR_MESSAGE);
    	    return null;
    	}
    	return course;
    }
    
    
    //获取当前学生的选课列表
    private List<CourseEntity> getSelectedCourses() {
    	UserEntity stu = UserSession.getInstance().getUser();
        List<CourseEntity> courses = courseOperation.checkselectedcourse(stu);
        courses.add(new CourseEntity("1", 2024, "高等数学", 4, 1, 1, 60, 50, true, "张三", "1001"));
        courses.add(new CourseEntity("2", 2024, "线性代数", 3, 2, 1, 50, 40, false, "李四", "1002"));
        
        return courses;
    }



    private class JButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;

        public JButtonEditor(ActionListener actionPerformedListener) {
            super(new JCheckBox());
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(actionPerformedListener);
            label = "退选";
            isPushed = false;
            updateButton();
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                    boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            updateButton();
            return button;
        }

        private void updateButton() {
            button.setText(label);
            //  button.setIcon(...);
            //  button.setPressed(isPushed);
        }

        public Object getCellEditorValue() {
            return new String(label);
        }

        public boolean stopCellEditing() {
            isPushed = !isPushed;
            updateButton();
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SelectedCoursesGUI frame = new SelectedCoursesGUI();
            frame.setVisible(true);
        });
    }
}