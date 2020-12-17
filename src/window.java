import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class window extends JFrame {
    public window() {
        super("Bibliothèque");
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        GridBagLayout myLayout = new GridBagLayout();
        panel.setLayout(myLayout);


        // Menu et sous- menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fichier = new JMenu();
        fichier.setText("Files");
        menuBar.add(fichier);

        JMenuItem ouvrir = new JMenuItem("Ouvrir");
        fichier.add(ouvrir);
        ouvrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers texte", ".txt");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " +
                            chooser.getSelectedFile().getName());
                }

            }
        });

        JMenuItem fermer = new JMenuItem("Fermer");
        fichier.add(fermer);

        JMenu edit = new JMenu();
        edit.setText("Edit");
        menuBar.add(edit);

        JMenu about = new JMenu();
        about.setText("About");
        menuBar.add(about);






        // JButton
        JButton valide = new JButton("Valider");


        //JLabel
        JLabel titra = new JLabel("Titre : ");
        JLabel auteura = new JLabel("Auteur : ");
        JLabel parutiona = new JLabel("Parution : ");
        JLabel colonna = new JLabel("Colonne : ");
        JLabel rangea = new JLabel("Rangée : ");
        JLabel resumea = new JLabel("Résumé : ");


        //JTextField
        JTextField titre = new JTextField();
        titre.setPreferredSize(new Dimension(150, 30));

        JTextField auteur = new JTextField();
        auteur.setPreferredSize(new Dimension(150, 30));

        JTextField parution = new JTextField();
        parution.setPreferredSize(new Dimension(150, 30));

        JTextField colonne = new JTextField();
        colonne.setPreferredSize(new Dimension(150, 30));

        JTextField rangee = new JTextField();
        rangee.setPreferredSize(new Dimension(150, 30));

        JTextField resume = new JTextField();
        resume.setPreferredSize(new Dimension(150, 150));




        //GridBagLayout
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);



        GridBagConstraints gbc = new GridBagConstraints();

        // constraints JTextField
        gbc.gridx = 9;
        gbc.gridy = 0;
        panel.add(titre, gbc);
        gbc.gridy = 1;
        panel.add(auteur, gbc);
        gbc.gridy = 2;
        panel.add(parution, gbc);
        gbc.gridy = 3;
        panel.add(colonne, gbc);
        gbc.gridy = 4;
        panel.add(rangee, gbc);
        gbc.gridy = 5;
        panel.add(resume, gbc);


        //constraints JLabel
        gbc.gridx = 8;
        gbc.gridy = 0;
        panel.add(titra, gbc);
        gbc.gridy = 1;
        panel.add(auteura, gbc);
        gbc.gridy = 2;
        panel.add(parutiona, gbc);
        gbc.gridy = 3;
        panel.add(colonna, gbc);
        gbc.gridy = 4;
        panel.add(rangea, gbc);
        gbc.gridy = 5;
        panel.add(resumea, gbc);

        //constraints JButton
        gbc.gridx = 9;
        gbc.gridy = 6;
        panel.add(valide, gbc);


        String[][] d = {
                { "Harry Potter", "J.K Rowling" ,"", "5" ,"",""},
                { "Eragon", "C.Paolini", "Un monde de dragon", "2" ,"",""},
        };
        String [] col={"Nom", "Auteur", "Résumé", "Colonne","Rangée","Parution"};

        JTable table=new JTable(d, col);
        gbc.gridwidth = 6;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(table.getTableHeader(), gbc);
        gbc.gridwidth = 6;
        gbc.gridy = 1;
        panel.add(table, gbc);

        //test button

        JButton ajouter = new JButton("Ajouter");
        gbc.gridy=2;
        panel.add(ajouter,gbc);
        JButton supprimer = new JButton("Supprimer");
        gbc.gridx = 5;
        gbc.gridy=2;
        panel.add(supprimer,gbc);


        setContentPane(panel);
        }
    }


