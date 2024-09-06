package tech.client.library;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class HotBook extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextArea txtBookName;
    private JTextArea txtAuthor;
    private JTextArea txtPublisher;
    private  JEditorPane edpPicture;

    /**
     * Create the panel with default values.
     */
    public HotBook() {
        initialize("default_image.png", "Unknown Book", "Unknown Author","Unknown Pubilsher");
        setVisible(false); // Optionally set the panel to not visible initially
    }

    /**
     * Create the panel with specific values.
     */
    public HotBook(String img_url, String bookName, String author,String pubilsher) {
        initialize(img_url, bookName, author,pubilsher);
    }

    private void initialize(String picture, String bookName, String author,String pubilsher) {
        setBackground(new Color(240, 240, 240));
        setBorder(new LineBorder(new Color(205, 226, 235), 3, true));
        setSize(349, 315);

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
        {
        	JTextArea textArea = new JTextArea();
        	textArea.setText(pubilsher);
        	textArea.setOpaque(false);
        	textArea.setLineWrap(true);
        	textArea.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        	textArea.setEditable(false);
        	textArea.setBounds(181, 159, 158, 44);
        	add(textArea);
        }
        {
        	JButton btnNewButton = new JButton("立即借阅");
        	btnNewButton.setBackground(new Color(205, 230, 233));
        	btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        	btnNewButton.setBounds(181, 213, 147, 45);
        	add(btnNewButton);
        }
    }

    
    private JEditorPane createEditorPane(String html, int x, int y, int width, int height) {
        setLayout(null);
        JEditorPane editorPane = new JEditorPane();
        editorPane.setBounds(14, 30, 157, 233);
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        editorPane.setText("<html><body>" + html + "</body></html>");
        add(editorPane);
        return editorPane;
    }

    private JTextArea createNameField(String text, int x, int y, int width, int height) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(181, 30, 147, 86);
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
        textArea.setBounds(181, 105, 147, 44);
        textArea.setFont(new Font("微软雅黑", Font.PLAIN, 12)); 
        textArea.setEditable(false);
        textArea.setText(text);
        textArea.setOpaque(false);
        textArea.setLineWrap(true);
        add(textArea);
        return textArea;
    }
}