package tech.client.library;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.net.URL;

public class HotBook extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextArea txtBookName;
    private JTextArea txtAuthor;
    private JTextArea txtPublisher;
    private JEditorPane edpPicture;


    public HotBook() {
        initialize("default_image.png", "Unknown Book", "Unknown Author", "Unknown Publisher");
        setVisible(false); // Optionally set the panel to not visible initially
    }


    public HotBook(String img_url, String bookName, String author, String publisher) {
        initialize(img_url, bookName, author, publisher);
    }

    private void initialize(String picture, String bookName, String author, String publisher) {
        setBackground(new Color(240, 240, 240));
        setOpaque(false);
        setBorder(new LineBorder(new Color(205, 226, 235), 3, true));
        setSize(349, 315);
        setLayout(null); // 使用绝对布局

        // 创建和配置图片显示区域
        edpPicture = createEditorPane(picture, 14, 10, 236, 261);
        add(edpPicture);

        // 创建和配置书名显示文本区域
        txtBookName = createNameField(bookName, 213, 10, 120, 59);
        add(txtBookName);

        // 创建和配置作者显示文本区域
        txtAuthor = createTextArea(author, 213, 79, 120, 59);
        add(txtAuthor);

        // 创建和配置出版社显示文本区域
        txtPublisher = createTextArea("", 213, 189, 120, 59);
        add(txtPublisher);

        // 出版社文本
        {
            JTextArea textArea = new JTextArea();
            textArea.setText(publisher);
            textArea.setOpaque(false);
            textArea.setLineWrap(true);
            textArea.setFont(new Font("微软雅黑", Font.PLAIN, 12));
            textArea.setEditable(false);
            textArea.setBounds(189, 157, 124, 44);
            add(textArea);
        }

        // 立即借阅按钮
        {
            JButton btnNewButton = new JButton("立即借阅");
            btnNewButton.setBackground(new Color(205, 230, 233));
            btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
            btnNewButton.setBounds(186, 232, 131, 45);
            add(btnNewButton);
        }
    }

    private JEditorPane createEditorPane(String imageUrl, int x, int y, int width, int height) {
        JEditorPane editorPane = new JEditorPane();
        editorPane.setBounds(10, 24, 169, 253);
        editorPane.setEditable(false);
        editorPane.setContentType("text/html"); // 设置内容类型为 HTML

        // 构建 HTML 字符串，将图片嵌入其中
        String htmlText = "<html><body><center><img src='" + imageUrl + "' alt='Book Image' style='max-width: 100%; height: auto;'/></center></body></html>";

        // 设置 HTML 内容
        editorPane.setText(htmlText);

        add(editorPane); // 将 editorPane 添加到 JPanel 中
        return editorPane;
    }

    private JTextArea createNameField(String text, int x, int y, int width, int height) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(189, 22, 124, 85);
        textArea.setBackground(new Color(255, 255, 255));
        textArea.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textArea.setEditable(false);
        textArea.setText(text);
        textArea.setOpaque(false);
        textArea.setLineWrap(true);
        add(textArea);
        return textArea;
    }

    private JTextArea createTextArea(String text, int x, int y, int width, int height) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(189, 111, 128, 36);
        textArea.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        textArea.setEditable(false);
        textArea.setText(text);
        textArea.setOpaque(false);
        textArea.setLineWrap(true);
        add(textArea);
        return textArea;
    }
}