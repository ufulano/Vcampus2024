package tech.client.library;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import Entity.BookEntity;
import tech.client.main.MainStudent;
/**
 * 图书馆界面GUI，学生端和老师端
 */
public class LibraryUserGUI extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Boolean click = true;

	int nowPos = 0;

	/**
	 * Create the frame.
	 */
	public LibraryUserGUI() {
		setTitle("Vcampus·图书馆");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(LibraryUserGUI.class.getResource("/resources/icon/icon2/library.png")));
		setResizable(false);
		setSize(900,600);
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		// head
		JLabel lblVcampus = new JLabel("图书馆");
		lblVcampus.setBounds(21, 10, 133, 43);
		lblVcampus.setHorizontalAlignment(SwingConstants.CENTER);
		lblVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		contentPane.add(lblVcampus);
		
		JButton btnBack = new JButton("返回");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(784, 10, 99, 46);
		btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnBack.setContentAreaFilled(false);
		contentPane.add(btnBack);

		// 左侧按钮
		JButton btnRenew = new JButton("我的借阅");
		btnRenew.setBounds(1, 77, 171, 84);
		btnRenew.setIcon(new ImageIcon(LibraryUserGUI.class.getResource("")));
		btnRenew.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		btnRenew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		contentPane.add(btnRenew);
		

		JButton btnReturn = new JButton("还书");
		btnReturn.setBounds(0, 265, 172, 84);
		btnReturn.setIcon(new ImageIcon(LibraryUserGUI.class.getResource("")));
		btnReturn.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		btnReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	               System.out.println("Return book was clicked!");
	                boolean windowOpen = false;
	                Window[] windows = JFrame.getWindows();//获取所有打开窗口
	                for (Window window : JFrame.getWindows()) {
	                    if (window instanceof ReurnBook) {
	                        windowOpen = true;
	                        window.toFront(); // 将窗口带到最前面
	                        break;
	                    }
	                }
	                
	                if (!windowOpen) {
	                	ReurnBook window = new ReurnBook();
	                    window.setVisible(true);
	                } else {
	                    System.out.println("Return book is already open.");
	                }
	            }
		});
		contentPane.add(btnReturn);

		JButton btnBorrow = new JButton("借书");
		btnBorrow.setBounds(0, 171, 172, 84);
		btnBorrow.setIcon(new ImageIcon(LibraryUserGUI.class.getResource("")));
		btnBorrow.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		btnRenew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 System.out.println("Borrow book was clicked!");
	                boolean windowOpen = false;
	                Window[] windows = JFrame.getWindows();//获取所有打开窗口
	                for (Window window : JFrame.getWindows()) {
	                    if (window instanceof MyBookGUI) {
	                        windowOpen = true;
	                        window.toFront(); // 将窗口带到最前面
	                        break;
	                    }
	                }
	                
	                if (!windowOpen) {
	                	MyBookGUI window = new MyBookGUI();
	                    window.setVisible(true);
	                } else {
	                    System.out.println("Borrowing is already open.");
	                }
			}
		});
		contentPane.add(btnRenew);

		//热门书籍板块
		JPanel HotList = new JPanel();

		JScrollPane scrollPane = new JScrollPane(HotList);
		scrollPane.setBounds(273, 152, 544, 403);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(HotList);
		HotList.setPreferredSize(new Dimension(scrollPane.getWidth() - 50, 300 * 5));
		HotList.setLayout(null);

		JLabel lblLibraryIcon = new JLabel("");
		lblLibraryIcon.setBounds(21, 10, 64, 64);
		lblLibraryIcon.setIcon(new ImageIcon(LibraryUserGUI.class.getResource("/resources/assets/icon/library.png")));
		contentPane.add(lblLibraryIcon);


		JLabel lblHotBookIcon = new JLabel("热门书籍");
		lblHotBookIcon.setBounds(213, 94, 148, 48);
		lblHotBookIcon.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblHotBookIcon.setIcon(new ImageIcon(LibraryUserGUI.class.getResource("")));
		contentPane.add(lblHotBookIcon);
	
		// 背景
		JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/老师课表背景.png")));
		backgroundLabel.setBounds(0, 0, 900, 600);
		contentPane.add(backgroundLabel);


		//运行 线程
		LibraryUserGUI that = this;
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				scrollPane.getVerticalScrollBar().setValue(0);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				that.setVisible(true);
			}
		});
		
		Thread thread = null;
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
				while (true) {
					scrollPane.getVerticalScrollBar().setValue(nowPos++);
					if (nowPos >= 1100 /* 容错 */) {
						nowPos = 0;
						scrollPane.getVerticalScrollBar().setValue(nowPos++);
					}
					try {
						thread.sleep(90);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();

	}
}
