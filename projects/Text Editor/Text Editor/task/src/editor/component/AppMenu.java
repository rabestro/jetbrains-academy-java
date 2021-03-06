package editor.component;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AppMenu extends JMenuBar {

    private final JMenu menu = new JMenu("File");

    public AppMenu(final ActionListener loadText, final ActionListener saveText) {
        menu.setName("MenuFile");
        menu.setMnemonic(KeyEvent.VK_F);
        add(menu);

        final var menuItemLoad = new JMenuItem("Load", KeyEvent.VK_L);
        menuItemLoad.setName("MenuLoad");
        menuItemLoad.addActionListener(loadText);

        final var menuItemSave = new JMenuItem("Save", KeyEvent.VK_S);
        menuItemSave.setName("MenuSave");
        menuItemSave.addActionListener(saveText);

        final var menuItemExit = new JMenuItem("Exit", KeyEvent.VK_X);
        menuItemExit.setName("MenuExit");
        menuItemExit.addActionListener(actionEvent -> System.exit(0));

        menu.add(menuItemLoad);
        menu.add(menuItemSave);
        menu.add(menuItemExit);

    }
}
