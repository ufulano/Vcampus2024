package tech.client.schedule;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;

import tech.client.main.MainStudent;

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
        panel.setBounds(344, 107, 506, 455);
        contentPane.add(panel);

        lblNewLabel = new JLabel("课表查看");
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 30));
        lblNewLabel.setBounds(344, 26, 159, 44);
        contentPane.add(lblNewLabel);

        JButton btnBack = new JButton("返回");
        btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        btnBack.setBounds(681, 26, 187, 46);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        contentPane.add(btnBack);

        table = new ScheduleTable();
        panel.add(table);

        // 添加背景标签
        JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/课表背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        backgroundLabel.setOpaque(true); // 确保背景标签覆盖整个窗口
        contentPane.add(backgroundLabel);

        // 确保 contentPane 在添加组件后重新验证和重绘
        contentPane.revalidate();
        contentPane.repaint();

        setLocationRelativeTo(null); // 再次居中显示
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
        String[] columnNames = {"课程", "时间", "地点", "教师"};
        model = new DefaultTableModel(columnNames, 0); // 假设没有行数据
        infoTable = new JTable(model);

     // 创建滚动面板
        JScrollPane jsp = new JScrollPane(infoTable);

        // 添加滚动面板到面板
        add(jsp);

        // 设置滚动面板的 bounds，确保在添加到面板之后设置
        jsp.setBounds(0, 0, 504, 460); 

        // 由于使用绝对布局，需要调用 validate() 来应用布局
        this.validate();
    }
}

  