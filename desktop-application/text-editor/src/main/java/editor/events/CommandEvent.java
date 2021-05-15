package editor.events;

import java.util.EventObject;

public class CommandEvent extends EventObject {

    private Command command;

    public CommandEvent(Object source) {
        super(source);
    }

    public CommandEvent(Object source, Command command) {
        super(source);
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
