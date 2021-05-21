package viewer;

import viewer.component.DataBaseViewer;

import javax.swing.*;

import static java.lang.System.Logger.Level.INFO;

public class SQLiteViewer extends JFrame {
    private static final System.Logger LOGGER = System.getLogger("");

    {
        var dataBaseViewer = new DataBaseViewer();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("SQLite Viewer");
        setLayout(null);
        setContentPane(dataBaseViewer.getMainPanel());
        pack();
        setVisible(true);
    }

    public SQLiteViewer() {
        LOGGER.log(INFO, "SQLiteViewer started");
    }

}
