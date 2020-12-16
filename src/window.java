import javax.swing.*;
import java.awt.*;

public class window extends JFrame {
    public window() {
        super("Bibliothèque");
        setSize(250, 250);
        JPanel panel = new JPanel();
        GridBagLayout myLayout = new GridBagLayout();
        panel.setLayout(myLayout);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fichier = new JMenu();
        fichier.setText("Fichiers");
        menuBar.add(fichier);

        JMenuItem ouvrir = new JMenuItem("Ouvrir");
        fichier.add(ouvrir);


        JButton bouton=new JButton("test");
        // Gridbaglayout

        GridBagConstraints gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;

        gbc.gridheight=1;
        gbc.gridwidth=1;
        panel.add(bouton,gbc);
        JLabel test = new JLabel("test");
        JLabel test2 = new JLabel("test2");
        gbc.gridx=9;
        gbc.gridy=9;
        gbc.gridheight=1;
        gbc.gridwidth=1;
        panel.add(test,gbc);
        gbc.gridx=10;
        gbc.gridy=10;
        gbc.gridheight=1;
        gbc.gridwidth=1;
        panel.add(test2,gbc);
        String[][] d = {
                { "Sam", "29" ," Twinkle House" },
                { "Anna Sam", " 27 ", "Happy Villa" },
                { "Iza Norah", " 4 ", "Happy house" },
        };
        String [] col={"nom","auteur","résumer","colonne","rangé","parution"};
        JTable table=new JTable( d, col);
        panel.add(table,gbc);

        setContentPane(panel);
    }

}
