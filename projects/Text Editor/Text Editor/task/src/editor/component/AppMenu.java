package editor.component;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AppMenu extends JMenuBar {


    public AppMenu(final ActionListener loadText, final ActionListener saveText) {
        final var menuFile = new JMenu("File");
        menuFile.setName("MenuFile");
        menuFile.setMnemonic(KeyEvent.VK_F);
        add(menuFile);

        final var menuItemLoad = new JMenuItem("Open", KeyEvent.VK_L);
        menuItemLoad.setName("MenuLoad");
        menuItemLoad.addActionListener(loadText);

        final var menuItemSave = new JMenuItem("Save", KeyEvent.VK_S);
        menuItemSave.setName("MenuSave");
        menuItemSave.addActionListener(saveText);

        final var menuItemExit = new JMenuItem("Exit", KeyEvent.VK_X);
        menuItemExit.setName("MenuExit");
        menuItemExit.addActionListener(actionEvent -> System.exit(0));

        menuFile.add(menuItemLoad);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemExit);

    }
}
