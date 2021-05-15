package editor.component;

import editor.events.Command;
import editor.events.CommandEvent;
import editor.events.CommandListener;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Toolbar extends JPanel {
    private static final Logger log = Logger.getLogger(Toolbar.class.getName());

    private final CommandListener listener;
    private final JTextField textPattern = new JTextField(15);
    private final JCheckBox useRegex = new JCheckBox("Use regex");
    private final int iconSize = 16;

    public Toolbar(final CommandListener listener) {
        this.listener = listener;
        textPattern.setName("SearchField");
        useRegex.setName("UseRegExCheckbox");

        setLayout(new FlowLayout(FlowLayout.LEFT));
        addButton("OpenButton", Command.OPEN);
        addButton("SaveButton", Command.SAVE);
        add(textPattern);
        addButton("StartSearchButton", Command.START_SEARCH);
        addButton("PreviousMatchButton", Command.PREVIOUS);
        addButton("NextMatchButton", Command.NEXT);
        add(useRegex);
    }

    private void addButton(final String name, final Command command) {
        Objects.requireNonNull(name);
        // The working directory should be set properly to load icons...
        final var url = "src/images/" + name + ".png";
        final var button = new JButton();
        button.setName(name);
        button.setMargin(new Insets(0, 0, 0, 0));
        final var originalIcon = new ImageIcon(url, name);
        final var icon = new ImageIcon(originalIcon.getImage()
                .getScaledInstance(iconSize, iconSize, java.awt.Image.SCALE_SMOOTH));
        button.setIcon(icon);
        button.addActionListener(event ->
                listener.commandEventOccurred(new CommandEvent(this, command)));
        add(button);
    }

    public Pattern getPattern() {
        return Pattern.compile(textPattern.getText(), useRegex.isSelected() ? 0 : Pattern.LITERAL);
    }

    public void useRegex() {
        log.info("Use regular expressions");
        useRegex.setSelected(!useRegex.isSelected());
    }
}
