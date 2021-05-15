package editor.component;

import editor.events.Command;
import editor.events.CommandEvent;
import editor.events.CommandListener;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AppMenu extends JMenuBar {

    private final CommandListener commandListener;

    public AppMenu(final CommandListener listener) {

        this.commandListener = listener;
        final var menuFile = new JMenu("File");
        menuFile.setName("MenuFile");
        menuFile.setMnemonic(KeyEvent.VK_F);
        add(menuFile);

        final var menuItemOpen = new JMenuItem("Open", KeyEvent.VK_O);
        menuItemOpen.setName("MenuOpen");
        menuItemOpen.addActionListener(getListener(Command.OPEN));

        final var menuItemSave = new JMenuItem("Save", KeyEvent.VK_S);
        menuItemSave.setName("MenuSave");
        menuItemSave.addActionListener(getListener(Command.SAVE));

        final var menuItemExit = new JMenuItem("Exit", KeyEvent.VK_X);
        menuItemExit.setName("MenuExit");
        menuItemExit.addActionListener(getListener(Command.EXIT));

        menuFile.add(menuItemOpen);
        menuFile.add(menuItemSave);
        menuFile.addSeparator();
        menuFile.add(menuItemExit);

        final var menuSearch = new JMenu("Search");
        menuSearch.setName("MenuSearch");
        menuSearch.setMnemonic(KeyEvent.VK_S);
        add(menuSearch);

        final var menuItemStart = new JMenuItem("Start search", KeyEvent.VK_S);
        menuItemStart.setName("MenuStartSearch");
        menuItemStart.addActionListener(getListener(Command.START_SEARCH));
        menuSearch.add(menuItemStart);

        final var menuItemPrev = new JMenuItem("Previous match", KeyEvent.VK_P);
        menuItemPrev.setName("MenuPreviousMatch");
        menuItemPrev.addActionListener(getListener(Command.PREVIOUS));
        menuSearch.add(menuItemPrev);

        final var menuItemNext = new JMenuItem("Next match", KeyEvent.VK_N);
        menuItemNext.setName("MenuNextMatch");
        menuItemNext.addActionListener(getListener(Command.NEXT));
        menuSearch.add(menuItemNext);

        final var menuItemRegex = new JMenuItem("Use regular expressions", KeyEvent.VK_R);
        menuItemRegex.setName("MenuUseRegExp");
        menuItemRegex.addActionListener(getListener(Command.USE_REGEX));
        menuSearch.add(menuItemRegex);

    }

    private ActionListener getListener(final Command command) {
        return a -> commandListener.commandEventOccurred(new CommandEvent(this, command));
    }
}
