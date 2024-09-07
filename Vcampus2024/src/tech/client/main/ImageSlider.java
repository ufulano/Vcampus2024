package tech.client.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ImageSlider extends JPanel {
    private static final long serialVersionUID = 1L;
    private final List<JEditorPane> imagePanes;
    private final Timer timer;
    private int currentImageIndex;
    private final int fadeDuration = 300; // 300毫秒完成淡入淡出
    private final int showDuration = 15000; // 显示图片15000毫秒（15秒）
    private boolean fadeIn = false; // 开始时不进行淡入
    private int alpha = 255; // 初始设置为不透明

    public ImageSlider() {
        imagePanes = new ArrayList<>();
        setPreferredSize(new Dimension(600, 333));
        setLayout(new CardLayout());

        // 创建 Timer 用于定时切换图片
        timer = new Timer(50, new ActionListener() { // 50毫秒更新一次透明度
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fadeIn) {
                    // 淡入
                    alpha += 10; // 每次增加10，加快淡入速度
                    if (alpha > 255) alpha = 255;
                    updateImageTransparency(alpha);
                    if (alpha == 255) {
                        showImageInfo(); // 显示系统提示
                        fadeIn = false; // 切换到淡出模式
                        timer.setDelay(showDuration); // 设置显示持续时间
                    }
                } else {
                    // 淡出
                    alpha -= 10; // 每次减少10，加快淡出速度
                    if (alpha < 0) alpha = 0;
                    updateImageTransparency(alpha);
                    if (alpha == 0) {
                        showImageInfo(); // 显示系统提示
                        currentImageIndex = (currentImageIndex + 1) % imagePanes.size();
                        fadeIn = true; // 切换到淡入模式
                        updateImageTransparency(0); // 重置透明度
                        timer.setDelay(fadeDuration); // 恢复淡入速度
                    }
                }
            }
        });
    }

    private void showImageInfo() {
        // 打印图片编号和地址
        System.out.println("Image " + (currentImageIndex + 1) + ": " + imagePanes.get(currentImageIndex).getPage());
    }

    public void setImageUrls(String[] imageUrls) {
        // 清除之前的组件
        this.removeAll();
        imagePanes.clear();
        for (int i = 0; i < imageUrls.length; i++) {
            JEditorPane editorPane = createEditorPane(imageUrls[i]);
            add(editorPane, "image" + i);
            imagePanes.add(editorPane);
        }
        // 显示第一张图片并设置为不透明
        ((CardLayout) getLayout()).first(this);
        updateImageTransparency(255); // 设置初始透明度为完全不透明
        currentImageIndex = 0; // 重置当前图片索引
        timer.start(); // 启动定时器
    }

    private void updateImageTransparency(int alpha) {
        if (imagePanes.size() > 0) {
            JEditorPane currentPane = imagePanes.get(currentImageIndex);
            currentPane.setOpaque(true); // 始终设置为不透明
            currentPane.setBackground(new Color(255, 255, 255, alpha));
            currentPane.repaint();
        }
    }

    private JEditorPane createEditorPane(String imageUrl) {
        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        String htmlText = "<html><body><center><img src='" + imageUrl + "' alt='Image' style='max-width: 100%; height: auto;'/></center></body></html>";
        editorPane.setText(htmlText);
        return editorPane;
    }
}