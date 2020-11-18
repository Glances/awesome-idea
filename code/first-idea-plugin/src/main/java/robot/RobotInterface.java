package robot;

import com.intellij.ui.components.JBScrollPane;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * @author shuang.kou
 * @createTime 2020年11月14日 09:12:00
 **/
public class RobotInterface {
    public static void initialize() {
        JFrame frame = new JFrame("美女聊天机器人");
        frame.setBounds(100, 100, 396, 258);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(JBUI.Borders.empty(5));
        contentPane.add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel question = new JLabel("问题");
        question.setBounds(10, 146, 92, 15);
        contentPanel.add(question);

        // 机器人回答
        JLabel answer = new JLabel("回答");
        answer.setBounds(10, 46, 92, 15);
        contentPanel.add(answer);

        // 机器人回答内容
        JBScrollPane scrollPane = new JBScrollPane();
        scrollPane.setBounds(136, 30, 198, 73);
        contentPanel.add(scrollPane);
        JTextArea answerContent = new JTextArea(3, 33);
        answerContent.setLineWrap(true);
        answerContent.setEnabled(false);
        scrollPane.setViewportView(answerContent);
        // 输入问题
        JTextArea enteredQuestion = new JTextArea();
        enteredQuestion.setBounds(136, 142, 198, 24);
        contentPanel.add(enteredQuestion);
        // 提交按钮
        JButton submit = new JButton("\u63D0\u4EA4\u95EE\u9898");
        submit.setBounds(115, 196, 93, 23);
        contentPanel.add(submit);


        //注册监听事件
        submit.addActionListener(e -> {
            String answer1 = "";
            // 获取输入的问题
            String q = enteredQuestion.getText();
            try {
                answer1 = Robot.getAnswer(q);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            answerContent.setText(answer1);
        });
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
