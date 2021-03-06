package editor.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class LoadText implements ActionListener {
    private static final Logger log = Logger.getLogger(LoadText.class.getName());

    private final Supplier<Path> file;
    private final Consumer<String> textArea;

    public LoadText(Supplier<Path> file, Consumer<String> textArea) {
        this.file = file;
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        try {
            textArea.accept(Files.readString(file.get()));
        } catch (IOException e) {
            log.warning(e::getMessage);
        }
    }
}
