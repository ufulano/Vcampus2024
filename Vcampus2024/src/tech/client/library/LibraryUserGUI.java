package tech.client.library;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import tech.client.main.MainStudent;
import tech.client.main.MainTeacher;
import tech.client.main.UserSession;
import tech.client.studentManage.SMStudentPersonal;
import Entity.BookEntity;
import Entity.UserEntity;

/**
 * 图书馆界面GUI，学生端和老师端
 */
public class LibraryUserGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel mainContentPane;
    private JButton backButton;
    private JScrollPane hotBookScrollPane;
    private JPanel HotList; // 定义 HotList 面板

    public LibraryUserGUI() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Vcampus·图书馆");
        setIconImage(Toolkit.getDefaultToolkit().getImage(LibraryUserGUI.class.getResource("/resources/icon/icon2/library.png")));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        mainContentPane = new JPanel();
        mainContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(mainContentPane);
        mainContentPane.setLayout(null);

        initHeader();
        initNavigationButtons();
        initHotBookList();
        initBackground();

        setVisible(true);
    }

    private void initHeader() {
        JLabel lblVcampus = new JLabel("图书馆", SwingConstants.CENTER);
        lblVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        lblVcampus.setBounds(21, 10, 117, 43);
        mainContentPane.add(lblVcampus);

        backButton = new JButton("返回");
        backButton.setBounds(784, 10, 99, 46);
        backButton.addActionListener(this::backButtonActionPerformed);
        backButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        backButton.setContentAreaFilled(false);
        mainContentPane.add(backButton);
    }

    private void initNavigationButtons() {
        JButton myBorrowingsButton = new JButton("我的借阅");
        myBorrowingsButton.setBounds(0, 77, 172, 84);
        myBorrowingsButton.setContentAreaFilled(false);
        myBorrowingsButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        myBorrowingsButton.addActionListener(this::myBorrowingsButtonActionPerformed);
        mainContentPane.add(myBorrowingsButton);

        JButton returnBooksButton = new JButton("还书");
        returnBooksButton.setBounds(0, 171, 172, 84);
        returnBooksButton.setContentAreaFilled(false);
        returnBooksButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        returnBooksButton.addActionListener(this::returnBooksButtonActionPerformed);
        mainContentPane.add(returnBooksButton);

        JButton borrowBooksButton = new JButton("借阅与检索");
        borrowBooksButton.setBounds(0, 265, 172, 84);
        borrowBooksButton.setContentAreaFilled(false);
        borrowBooksButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        borrowBooksButton.addActionListener(this::borrowBooksButtonActionPerformed);
        mainContentPane.add(borrowBooksButton);
    }

    private void initHotBookList() {
        HotList = new JPanel();
        HotList.setOpaque(false);
        HotList.setLayout(new GridLayout(0, 2, 10, 10)); // 设置布局为两列，间距为 10
        hotBookScrollPane = new JScrollPane(HotList);
        hotBookScrollPane.setBounds(182, 77, 693, 476);
        mainContentPane.add(hotBookScrollPane);
        hotBookScrollPane.setViewportView(HotList);
        HotList.setPreferredSize(new Dimension(hotBookScrollPane.getWidth() - 50, 300 * 5));

        // 获取图书列表
        List<BookEntity> bookList = getBookList();

        // 为方便调试使用缺省的 HotBook
        int count = 0;
        for (BookEntity book : bookList) {
            HotBook bookBlock = new HotBook(
                    book.getbImg_url(),
                    book.getbBookName(),
                    book.getbAuthor(),
                    book.getbPublisher()
            );
            bookBlock.setName(book.getbBookName());
            HotList.add(bookBlock);
            count++;
        }

        // 如果图书数量不足10个，添加空白的 HotBook 填充
        while (count < 10) {
            HotBook emptyBlock = new HotBook(); // 缺省构造，用于空白块
            HotList.add(emptyBlock);
            count++;
        }
        
        // 设置滚动条位置到最顶部
        SwingUtilities.invokeLater(() -> {
            hotBookScrollPane.getViewport().setViewPosition(new Point(0, 0));
        });
    }

    private void initBackground() {
        JLabel backgroundLabel = new JLabel(new ImageIcon(LibraryUserGUI.class.getResource("/resources/picture/老师课表背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        mainContentPane.add(backgroundLabel);
    }

    private List<BookEntity> getBookList() {
        // 创建图书列表
        List<BookEntity> bookList = new ArrayList<>();
        
        // 添加图书数据到列表
        bookList.add(new BookEntity(1, "The Great Gatsby", "F. Scott Fitzgerald", "Scribner", "9780743273565", 100, 50, "images/gatsby.jpg"));
        bookList.add(new BookEntity(2, "1984", "George Orwell", "Secker and Warburg", "9780451524935", 150, 75, "images/1984.jpg"));
        bookList.add(new BookEntity(3, "To Kill a Mockingbird", "Harper Lee", "J. B. Lippincott & Co.", "9780446310789", 200, 120, "images/mockingbird.jpg"));
        

        return bookList;
    }

    private void backButtonActionPerformed(ActionEvent e) {
    	UserEntity user = UserSession.getInstance().getUser();
    	System.out.println("session"+user);
        System.out.println("返回按钮被点击");

        if("学生".equals(user.getuRole())) {
			System.out.println("返回学生主界面");
			boolean windowOpen = false;
			Window[] windows = JFrame.getWindows();//获取所有打开窗口
			for (Window window : JFrame.getWindows()) {
				if (window instanceof MainStudent&&window.isVisible()) {
					windowOpen = true;
					dispose();
					window.toFront(); // 将窗口带到最前面
					break;
				}
			}
        
			if (!windowOpen) {
				MainStudent window = new MainStudent();
				dispose();
				window.setVisible(true);
			} else {
				System.out.println("Student main window is already open.");
			}
		}else if("教师".equals(user.getuRole())) {
			System.out.println("返回教师主界面");
			boolean windowOpen = false;
			Window[] windows = JFrame.getWindows();//获取所有打开窗口
			for (Window window : JFrame.getWindows()) {
				if (window instanceof MainTeacher&&window.isVisible()) {
					windowOpen = true;
					dispose();
					window.toFront(); // 将窗口带到最前面
					break;
				}
			}
        
			if (!windowOpen) {
				MainTeacher window = new MainTeacher();
				dispose();
				window.setVisible(true);
			} else {
				System.out.println("Teacher main window is already open.");
			}
		}

    }

    private void myBorrowingsButtonActionPerformed(ActionEvent e) {
        System.out.println("我的借阅");
        System.out.println("Student was clicked!");
        boolean windowOpen = false;
        Window[] windows = JFrame.getWindows(); // 获取所有打开窗口
        for (Window window : windows) {
            if (window instanceof MyBookGUI && window.isVisible()) {
                windowOpen = true;
                window.toFront(); // 将窗口带到最前面
                break;
            }
        }

        if (!windowOpen) {
            MyBookGUI studentWindow = new MyBookGUI();
            studentWindow.setVisible(true);
        } else {
            System.out.println("Student window is already open.");
        }
    }

    private void returnBooksButtonActionPerformed(ActionEvent e) {
        System.out.println("还书");
    }

    private void borrowBooksButtonActionPerformed(ActionEvent e) {
        System.out.println("借阅");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LibraryUserGUI frame = new LibraryUserGUI();
            frame.setVisible(true);
        });
    }
}