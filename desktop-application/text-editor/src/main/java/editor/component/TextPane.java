package editor.component;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TextPane extends JScrollPane {

    private final JTextArea textArea = new JTextArea();

    {
        textArea.setName("TextArea");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
    }

    public TextPane() {
        setName("ScrollPane");
        setViewportView(textArea);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        final var marginBorder = new EmptyBorder(new Insets(10, 10, 10, 10));
        setBorder(getBorder() == null ? marginBorder : new CompoundBorder(marginBorder, getBorder()));
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public void highlightMatch(final int start, final int end) {
        textArea.setCaretPosition(end);
        textArea.select(start, end);
        textArea.grabFocus();
    }
}