package tech.client.schedule;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Entity.CourseEntity;
import Entity.ScheduleEntity;
import Entity.UserEntity;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;

import tech.client.main.MainManager;
import tech.client.main.MainStudent;
import tech.client.main.UserSession;
import tech.client.studentManage.SMManagerSide;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;

/**
 * 学生课表
 * 只显示排课信息
 * UI设计基本完成
 * 
 */
public class scheduleStudentSide extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private ScheduleTable table;
    private JLabel lblNewLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    scheduleStudentSide frame = new scheduleStudentSide();
                    frame.setVisible(true);
                    frame.setSize(900, 600);
                    frame.setTitle("Vcampus·我的课表");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Create the frame.
     */
    public scheduleStudentSide() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainStudent.class.getResource("/resources/icon/icon2/课表.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 907, 631);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(102, 107, 719, 455);
        contentPane.add(panel);

        lblNewLabel = new JLabel("课表查看");
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 30));
        lblNewLabel.setBounds(36, 21, 159, 44);
        contentPane.add(lblNewLabel);

        JButton btnBack = new JButton("返回");
        btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        btnBack.setBounds(681, 26, 187, 46);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        contentPane.add(btnBack);

        btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        panel.setLayout(null);
        
        
        table = new ScheduleTable();
        panel.add(table);
        table.setBounds(0, 0, 719, 455);
        /*List<CourseEntity> list=table.getCourseList();
        table.addCourse(list);
        */
        table.addCourse();
    	System.out.print("time");

        // 添加背景标签
        JLabel backgroundLabel = new JLabel(new ImageIcon(scheduleStudentSide.class.getResource("/resources/picture/商店背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        backgroundLabel.setOpaque(true); 
        contentPane.add(backgroundLabel);

        contentPane.revalidate();
        contentPane.repaint();

        setLocationRelativeTo(null); // 居中显示
    }
}

class ScheduleTable extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTable infoTable;
    private DefaultTableModel model;

    public ScheduleTable() {
        setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        setLayout(null); 
        // 初始化表格模型
        String[] columnNames = {"", "周一", "周二", "周三", "周四", "周五", "周六", "周日"};
        String[][] data = {
                {"1-2节", "", "", "", "", "", "", ""},
                {"3-4节", "", "", "", "", "", "", ""},
                {"5-6节", "", "", "", "", "", "", ""},
                {"7-8节", "", "", "", "", "", "", ""}
        };

        model = new DefaultTableModel(data, columnNames);

        infoTable = new JTable(model) {
            // 覆盖getToolTipText方法以实现自动换行
            @Override
            public String getToolTipText(MouseEvent event) {
                int row = rowAtPoint(event.getPoint());
                int col = columnAtPoint(event.getPoint());
                String tip = (String) getModel().getValueAt(row, col);
                return tip != null ? tip.replace("\n", "<br>") : null;
            }
        };

        infoTable.setRowSelectionAllowed(true);
        infoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        infoTable.setRowHeight(infoTable.getRowHeight() * 8);
        infoTable.setDefaultRenderer(Object.class, new TableRenderer());
        // 调整行高
        adjustRowHeights();
        // 创建滚动面板
        JScrollPane jsp = new JScrollPane(infoTable);

        // 添加滚动面板到面板
        add(jsp);

        // 设置滚动面板的 bounds，确保在添加到面板之后设置
        jsp.setBounds(0, 0, 700, 460); // 调整宽度以填满容器

        // 由于使用绝对布局，需要调用 validate() 来应用布局
        this.validate();
    }

private void adjustRowHeights() {
    for (int row = 0; row < infoTable.getRowCount(); row++) {
        int rowHeight = infoTable.getRowHeight();
        for (int col = 0; col < infoTable.getColumnCount(); col++) {
            Component comp = infoTable.prepareRenderer(infoTable.getCellRenderer(row, col), row, col);
            int cHeight = comp.getPreferredSize().height;
            if (cHeight > rowHeight) {
                rowHeight = cHeight;
            }
        }
        infoTable.setRowHeight(row, rowHeight);
    }
}

    class TableRenderer extends JTextArea implements TableCellRenderer {
        private static final long serialVersionUID = 1L;

        public TableRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
            setOpaque(true);
            
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(table.getBackground());
            }
            setFont(table.getFont()); // 使用表格的字体
            if (value != null) {
                setText(value.toString());
            } else {
                setText("");
            }
            return this;
        }

        @Override
        public void setSize(Dimension d) {
            super.setSize(d);
            // 重新计算文本区域的大小以适应内容
            revalidate();
        }
    }

    //测试用
    public void addCourse() {
        CourseEntity course = new CourseEntity(
                "CS101",    // cCourseID: 课程编号
                2024,       // cYear: 年份
                "Computer Science", // cCourseName: 课程名称
                4,          // cCredits: 学分
                1,          // cMajor: 专业编号
                2,          // cGrade: 年级
                30,         // cCapacity: 容量
                25,         // cAvailable: 可用名额
                false,      // cEnd: 课程是否结束
                "Dr. Smith",// uName: 教师姓名
                "123456789" // uNumber: 教师编号
        );
        // 获取每一个课程的排课时间
        List<ScheduleEntity> schedulelist = new ArrayList<>();
        // 添加一些示例数据
        schedulelist.add(new ScheduleEntity(1, "CS101", 0, 1, "A101")); // Monday, Period 1-2, Classroom A101
        schedulelist.add(new ScheduleEntity(2, "MA201", 2, 3, "B202")); // Wednesday, Period 5-6, Classroom B202
        schedulelist.add(new ScheduleEntity(3, "PH303", 3, 0, "C303")); 
        for (ScheduleEntity schedule : schedulelist) {
            // 访问 ScheduleEntity 对象的属性或调用方法
            //获取星期和节次
            int week = schedule.getsDayofWeek();
            int time = schedule.getsTimePeriod();
            System.out.print("week" + week);
            System.out.print("time" + time);
            int columnIndex = week + 1; // "+1" 因为第一个列是空的
            int rowIndex = time;

            model.setValueAt(course.getcCourseName() + "\n" + schedule.getsClassroom(), rowIndex, columnIndex);
        }
        System.out.print("测试");
    }
}


  