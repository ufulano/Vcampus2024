package tech.client.library;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import tech.client.main.MainStudent; // 确保这个导入是正确的

/**
 * 我的借阅页面
 */
public class QueryBook extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txtTitle;
    private JTextField txtAuthor;
    private JTable tblSearch;
    private DefaultTableModel model;
    private JTextField txtISBN;
    private JButton backButton;
    //private List<Book> list; // 假设这是从某处获取的书籍列表

    /**
     * Create the dialog.
     */
    public QueryBook() {
        setModal(true);
        setTitle("Vcampus·图书馆·借阅与检索");
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainStudent.class.getResource("/resources/icon/icon2/library.png")));
        setResizable(false);
        setSize(871, 723);
        getContentPane().setLayout(new BorderLayout());
        
        backButton = new JButton("返回");
        backButton.setBounds(784, 10, 99, 46);
        backButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        backButton.setContentAreaFilled(false);
        contentPanel.add(backButton);
        
        JButton myBorrowingsButton = new JButton("我的借阅");
        myBorrowingsButton.setBounds(0, 77, 172, 84);
        myBorrowingsButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        contentPanel.add(myBorrowingsButton);

        JButton returnBooksButton = new JButton("还书");
        returnBooksButton.setBounds(0, 171, 172, 84);
        returnBooksButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        contentPanel.add(returnBooksButton);

        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        JLabel backgroundLabel = new JLabel(new ImageIcon(LibraryManagerGUI.class.getResource("/resources/picture/老师课表背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        

        initializeComponents();
        contentPanel.add(backgroundLabel);
        setSize(900,600);
    }

    private void initializeComponents() {
        JLabel lblNewLabel = new JLabel("借阅与检索");
        lblNewLabel.setBounds(21, 10, 196, 43);
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        contentPanel.add(lblNewLabel);

        txtTitle = new JTextField();
        txtTitle.setBounds(254, 132, 157, 30);
        txtTitle.setColumns(10);
        contentPanel.add(txtTitle);

        txtAuthor = new JTextField();
        txtAuthor.setBounds(461, 132, 157, 30);
        txtAuthor.setText("");
        txtAuthor.setColumns(10);
        contentPanel.add(txtAuthor);

        JLabel lblTitle = new JLabel("书名");
        lblTitle.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        lblTitle.setBounds(214, 136, 30, 18);
        contentPanel.add(lblTitle);

        JLabel lblAuthor = new JLabel("作者");
        lblAuthor.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        lblAuthor.setBounds(421, 136, 30, 18);
        contentPanel.add(lblAuthor);

        String[] tableHeader = {"书目编号", "书名", "作者"};
        model = new DefaultTableModel(null, tableHeader);
        tblSearch = new JTable(model);
        tblSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

            }
        });
        JScrollPane jsp = new JScrollPane(tblSearch);
        jsp.setBounds(215, 172, 609, 266);
        contentPanel.add(jsp);

        JButton btnSearch = new JButton("检索");
        btnSearch.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        btnSearch.setBounds(640, 131, 79, 30);
        btnSearch.addActionListener(e -> searchBooks());
        contentPanel.add(btnSearch);

        JButton btnReset = new JButton("重置");
        btnReset.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        btnReset.setBounds(724, 131, 79, 30);
        btnReset.addActionListener(e -> resetFields());
        contentPanel.add(btnReset);

        txtISBN = new JTextField();
        txtISBN.setBounds(349, 448, 267, 30);
        contentPanel.add(txtISBN);
        txtISBN.setColumns(10);

        JLabel lblISBN = new JLabel("需要借阅的书目编号:");
        lblISBN.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        lblISBN.setBounds(225, 453, 120, 18);
        contentPanel.add(lblISBN);

        JButton btnComfirm = new JButton("确认");
        btnComfirm.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        btnComfirm.setIcon(new ImageIcon(QueryBook.class.getResource("/resources/assets/icon/tick.png")));
        btnComfirm.setBounds(728, 448, 96, 38);
        btnComfirm.addActionListener(e -> confirmBook());
        contentPanel.add(btnComfirm);
    }

    private void searchBooks() {
        // 实现搜索逻辑
    }

    private void resetFields() {
        txtTitle.setText("");
        txtAuthor.setText("");
        model.setRowCount(0);
    }

    private void confirmBook() {
        // 实现确认借书逻辑
    }
    
}