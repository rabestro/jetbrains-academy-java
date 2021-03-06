package editor.component;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AppTextArea extends JScrollPane implements Supplier<String>, Consumer<String> {
    private final JTextArea textArea = new JTextArea();

    public AppTextArea() {
        textArea.setName("TextArea");
        textArea.setBounds(0, 0, 300, 300);
        textArea.setFont(new Font("Serif", Font.ITALIC, 24));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        setViewportView(textArea);
        setName("ScrollPane");
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        setPreferredSize(new Dimension(300, 300));
        add(textArea);
    }

    @Override
    public void accept(String s) {
        textArea.setText(s);
    }

    @Override
    public String get() {
        return textArea.getText();
    }
}
