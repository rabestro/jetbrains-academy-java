package editor.events;

import java.util.EventListener;

public interface CommandListener extends EventListener {
    void commandEventOccurred(CommandEvent commandEvent);
}
