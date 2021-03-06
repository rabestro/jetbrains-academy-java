package editor;

import static javax.swing.SwingUtilities.invokeLater;

public class ApplicationRunner {
    public static void main(String[] args) {
        invokeLater(TextEditor::new);
    }
}
