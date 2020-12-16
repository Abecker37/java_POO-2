import javax.swing.*;

public class window extends JFrame {
    public window() {
        super("Bibliothèque");
        setSize(250, 250);
        JPanel panel = new JPanel();
        setContentPane(panel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fichier = new JMenu();
        fichier.setText("Fichiers");
        menuBar.add(fichier);

        JMenuItem ouvrir = new JMenuItem("Ouvrir");
        fichier.add(ouvrir);
    }
}
