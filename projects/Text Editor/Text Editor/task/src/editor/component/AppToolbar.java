package editor.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.logging.Logger;

public class AppToolbar extends JPanel {
    private static final Logger log = Logger.getLogger(AppToolbar.class.getName());
    private static final Dimension ICON_SIZE = new Dimension(20, 20);

    private final JTextField fileName = new JTextField(15);
    private final JButton openButton = new JButton(new ImageIcon("open.png"));
    private final JButton saveButton = new JButton("Save");

    {
        fileName.setName("FilenameField");
        openButton.setName("LoadButton");
        openButton.setPreferredSize(ICON_SIZE);
        saveButton.setName("SaveButton");
        saveButton.setPreferredSize(ICON_SIZE);

        final var icon = new ImageIcon("open.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(fileName);
        add(openButton);
        add(saveButton);
    }

    private JButton createButton(final String name, final String description) {
        final var icon = new ImageIcon(name + ".png", description);
        final var image = icon.getImage()
                .getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        icon.setImage(image);
        final var button = new JButton(icon);
        button.setName(name);
        return button;
    }

    public AppToolbar(final ActionListener loadText, final ActionListener saveText) {
        openButton.addActionListener(loadText);
        saveButton.addActionListener(saveText);
    }

    public Path getFile() {
        return Path.of(fileName.getText());
    }


}
