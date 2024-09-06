package tech.client.schedule;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import Entity.CourseEntity;
import Entity.ScheduleEntity;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
     		btnBack.setBounds(751, 12, 99, 46);
     		btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 20));
     		btnBack.setContentAreaFilled(false);
     		mainContentPane.add(btnBack);

        // 初始化已选课程数据
        selectedCourses = getSelectedCourses();

        // 创建表格模型
        String[] columnNames = {"课程ID", "课程名称", "学分", "容量", "上课时间", "上课地点"};
        Object[][] data = new Object[selectedCourses.size()][columnNames.length];
        for (int i = 0; i < selectedCourses.size(); i++) {
            CourseEntity course = selectedCourses.get(i);
            // ScheduleEntity schedule = selectedCourses.get(i);
            data[i] = new Object[]{
                course.getcCourseID(),
                course.getcCourseName(),
                course.getcCredits(),
                course.getcCapacity(),
                //schedule.getsDayofWeek(),
                //schedule.getsTimePeriod(),
                //schedule.getsClassroom(),
                " ",
                " ",
                ""
            };
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
    }

       

    private List<CourseEntity> getSelectedCourses() {
        // 这里应该是调用后端接口获取已选课程列表的逻辑
        // 暂时使用一个示例列表来代替
        List<CourseEntity> courses = new ArrayList<>();
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