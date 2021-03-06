package editor.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;
import java.util.logging.Logger;

import static java.nio.file.StandardOpenOption.*;

public class SaveText implements ActionListener {
    private static final Logger log = Logger.getLogger(SaveText.class.getName());

    private final Supplier<Path> file;
    private final Supplier<String> textArea;

    public SaveText(Supplier<Path> file, Supplier<String> textArea) {
        this.file = file;
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        try {
            Files.writeString(file.get(), textArea.get(), CREATE, WRITE, TRUNCATE_EXISTING);
        } catch (IOException e) {
            log.warning(e::getMessage);
        }
    }
}
