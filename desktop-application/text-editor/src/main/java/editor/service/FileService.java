package editor.service;

import editor.component.TextPane;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.System.Logger.Level.TRACE;
import static java.lang.System.Logger.Level.WARNING;
import static java.nio.file.StandardOpenOption.*;

public class FileService extends JFileChooser {
    private static final System.Logger LOGGER = System.getLogger("");

    private final TextPane textPane;

    public FileService(final TextPane textPane) {
        super(FileSystemView.getFileSystemView().getHomeDirectory());
        this.textPane = textPane;
        setName("FileChooser");
        setMultiSelectionEnabled(false);
        setFileSelectionMode(JFileChooser.FILES_ONLY);
    }

    public void open() {
        LOGGER.log(TRACE, getName(), "open", "Open a document");
        if (showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            openDocument();
        }
    }

    public void save() {
        LOGGER.log(TRACE, getName(), "save", "Save a document");
        if (showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            saveDocument();
        }
    }

    private void openDocument() {
        LOGGER.log(TRACE, getName(), "openDocument", getSelectedFile().getAbsolutePath());
        final var filePath = Path.of(getSelectedFile().toURI());
        try {
            textPane.setText(Files.readString(filePath));
        } catch (IOException e) {
            textPane.setText("");
            LOGGER.log(WARNING, e::getMessage);
        }
    }

    private void saveDocument() {
        LOGGER.log(TRACE, getName(), "saveDocument", getSelectedFile().getAbsolutePath());
        final var filePath = Path.of(getSelectedFile().toURI());
        try {
            Files.writeString(filePath, textPane.getText(), CREATE, WRITE, TRUNCATE_EXISTING);
        } catch (IOException e) {
            LOGGER.log(WARNING, e::getMessage);
        }
    }
}
