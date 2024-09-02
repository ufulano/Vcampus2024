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

public class LibraryStudentGUI extends JFrame {

	/**
	 * 图书馆界面GUI
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Boolean click = true;

	int nowPos = 0;

	/**
	 * Create the frame.
	 */
	public LibraryStudentGUI() {
		setTitle("Vcampus·图书馆");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(LibraryStudentGUI.class.getResource("/resources/icon/icon2/library.png")));
		setResizable(false);
		setSize(900,600);
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		JButton btnBorrow = new JButton("借书");
		btnBorrow.setBounds(0, 171, 172, 84);
		btnBorrow.setIcon(new ImageIcon(LibraryStudentGUI.class.getResource("")));
		btnBorrow.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		btnBorrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnBorrow);

		JButton btnReturn = new JButton("还书");
		btnReturn.setBounds(0, 265, 172, 84);
		btnReturn.setIcon(new ImageIcon(LibraryStudentGUI.class.getResource("")));
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

		JButton btnRenew = new JButton("我的借阅");
		btnRenew.setBounds(1, 77, 171, 84);
		btnRenew.setIcon(new ImageIcon(LibraryStudentGUI.class.getResource("")));
		btnRenew.setFont(new Font("微软雅黑", Font.PLAIN, 17));
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

		JPanel HotList = new JPanel();

		JScrollPane scrollPane = new JScrollPane(HotList);
		scrollPane.setBounds(273, 152, 544, 403);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(HotList);
		HotList.setPreferredSize(new Dimension(scrollPane.getWidth() - 50, 300 * 5));
		HotList.setLayout(null);

		JLabel lblLibraryIcon = new JLabel("");
		lblLibraryIcon.setBounds(21, 10, 64, 64);
		lblLibraryIcon.setIcon(new ImageIcon(LibraryStudentGUI.class.getResource("/resources/assets/icon/library.png")));
		contentPane.add(lblLibraryIcon);

		JLabel lblVcampus = new JLabel("图书馆");
		lblVcampus.setBounds(21, 10, 133, 43);
		lblVcampus.setHorizontalAlignment(SwingConstants.CENTER);
		lblVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		contentPane.add(lblVcampus);

		JLabel lblHotBookIcon = new JLabel("热门书籍");
		lblHotBookIcon.setBounds(213, 94, 148, 48);
		lblHotBookIcon.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblHotBookIcon.setIcon(new ImageIcon(LibraryStudentGUI.class.getResource("")));
		contentPane.add(lblHotBookIcon);

		
		//热门图书列表
		//List<Book> list = null;
		
		
		
		
		JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/老师课表背景.png")));
		backgroundLabel.setBounds(0, 0, 900, 600);
		contentPane.add(backgroundLabel);


		LibraryStudentGUI that = this;
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

		//这里是参考的多线程
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
