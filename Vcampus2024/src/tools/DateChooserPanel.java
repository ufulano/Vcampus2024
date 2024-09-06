package tools;
import javax.swing.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateChooserPanel extends JPanel {
    /**
	 * 日期选择组件
	 */
	private static final long serialVersionUID = 1L;
	private JSpinner spinner;
    private JFormattedTextField textField;

    public DateChooserPanel() {
        super();

        // 创建一个日期格式化器
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // 创建一个日历实例，设置为当前日期
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();

        // 创建一个 SpinnerDateModel，设置初始日期和日期格式
        SpinnerDateModel model = new SpinnerDateModel(today, null, null, Calendar.DAY_OF_MONTH);
        spinner = new JSpinner(model);

        // 创建一个格式化文本字段
        textField = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
        textField.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(dateFormat)));

        // 设置布局和添加组件
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new JLabel("Enter Date:"));
        this.add(spinner);
    }

    public Date getDate() {
        return (Date) spinner.getValue();
    }

    public void setDate(Date date) {
        spinner.setValue(date);
    }
}