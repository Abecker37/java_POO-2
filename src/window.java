import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

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
                    File fText = chooser.getSelectedFile();
                    System.out.println(fText = fText.getAbsoluteFile());
                }

            }
        });

        JMenuItem fermer = new JMenuItem("Fermer");
            fermer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                    }
            });
        fichier.add(fermer);

        JMenu edit = new JMenu();
        edit.setText("Edit");
        menuBar.add(edit);

        JMenu about = new JMenu();
        about.setText("About");
        menuBar.add(about);

        JMenuItem aboutUsButton = new JMenuItem("About us");
        aboutUsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Version 1.00 \n Amaury - Brendan - Antoine - Lucas");            }
        });
        about.add(aboutUsButton);




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
        panel.add(resume, gbc);
        gbc.gridy = 3;
        panel.add(colonne, gbc);
        gbc.gridy = 4;
        panel.add(rangee, gbc);
        gbc.gridy = 5;
        panel.add(parution, gbc);


        //constraints JLabel
        gbc.gridx = 8;
        gbc.gridy = 0;
        panel.add(titra, gbc);
        gbc.gridy = 1;
        panel.add(auteura, gbc);
        gbc.gridy = 2;
        panel.add(resumea, gbc);
        gbc.gridy = 3;
        panel.add(colonna, gbc);
        gbc.gridy = 4;
        panel.add(rangea, gbc);
        gbc.gridy = 5;
        panel.add(parutiona, gbc);


        String[][] d = {
                { "Harry Potter", "J.K Rowling" ,"", "5" ,"",""},
                { "Eragon", "C.Paolini", "Un monde de dragon", "2" ,"",""},
        };
        String [] col={"Nom", "Auteur", "Résumé", "Colonne", "Rangée", "Parution"};
        DefaultTableModel tablemodel=new DefaultTableModel(d,col);
        JTable table = new JTable(tablemodel) {
        public Component prepareRenderer (TableCellRenderer renderer, int row, int column)
        {
            Component c = super.prepareRenderer(renderer, row, column);
            Color color1 = new Color(220, 220, 220);
            Color color2 = Color.WHITE;
            if (!c.getBackground().equals(getSelectionBackground())) {
                Color coleur = (row % 2 == 0 ? color1 : color2);
                c.setBackground(coleur);
                coleur = null;
            }
            return c;
        }
    };

        // JButton
        JButton valide = new JButton("Valider");

        valide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablemodel.setValueAt(titre.getText(), table.getSelectedRow(), 0);
                d[table.getSelectedRow()][0] = titre.getText();
                tablemodel.fireTableCellUpdated(table.getSelectedRow(), 0);

                tablemodel.setValueAt(auteur.getText(), table.getSelectedRow(), 1);
                d[table.getSelectedRow()][1] = auteur.getText();
                tablemodel.fireTableCellUpdated(table.getSelectedRow(), 1);

                tablemodel.setValueAt(resume.getText(), table.getSelectedRow(), 2);
                d[table.getSelectedRow()][2] = resume.getText();
                tablemodel.fireTableCellUpdated(table.getSelectedRow(), 2);

                tablemodel.setValueAt(colonne.getText(), table.getSelectedRow(), 3);
                d[table.getSelectedRow()][3] = colonne.getText();
                tablemodel.fireTableCellUpdated(table.getSelectedRow(), 3);

                tablemodel.setValueAt(rangee.getText(), table.getSelectedRow(), 4);
                d[table.getSelectedRow()][4] = rangee.getText();
                tablemodel.fireTableCellUpdated(table.getSelectedRow(), 4);

                tablemodel.setValueAt(parution.getText(), table.getSelectedRow(), 5);
                d[table.getSelectedRow()][5] = parution.getText();
                tablemodel.fireTableCellUpdated(table.getSelectedRow(), 5);


                titre.setText("");
                auteur.setText("");
                resume.setText("");
                colonne.setText("");
                rangee.setText("");
                parution.setText("");

            }
        });

        //constraints JButton
        gbc.gridx = 9;
        gbc.gridy = 6;
        panel.add(valide, gbc);


        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                titre.setText(d[table.getSelectedRow()][0]);
                auteur.setText(d[table.getSelectedRow()][1]);
                resume.setText(d[table.getSelectedRow()][2]);
                colonne.setText(d[table.getSelectedRow()][3]);
                rangee.setText(d[table.getSelectedRow()][4]);
                parution.setText(d[table.getSelectedRow()][5]);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        gbc.gridwidth = 6;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(table.getTableHeader(), gbc);
        gbc.gridwidth = 6;
        gbc.gridy = 1;
        panel.add(table, gbc);


        //test button

        JButton supprimer = new JButton("Supprimer");

        supprimer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                // vérifier d'abord la ligne sélectionnée
                if(table.getSelectedRow() != -1)
                {
                    // supprimer la ligne sélectionnée du modèle de table
                    tablemodel.removeRow(table.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Deleted successfully");
                }
                else{
                    JOptionPane.showMessageDialog(null, "aucun element a selectionner");
                }
            }
        });
        gbc.gridx = 5;
        gbc.gridy=2;
        panel.add(supprimer,gbc);


        JButton ajoutBouton = new JButton("Ajouter");
        gbc.gridy=2;


                // vérifier d'abord la ligne sélectionnée
                /*if(table.getSelectedRow() != -1)
                {*/
        ajoutBouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Integer.parseInt(colonne.getText()) < 6 && Integer.parseInt(colonne.getText())>0){
                        if (Integer.parseInt(rangee.getText()) < 8 && Integer.parseInt(rangee.getText())>0){
                            if (Integer.parseInt(parution.getText())<2021){

                                tablemodel.addRow(
                                        new Object[]{
                                                titre.getText(),
                                                auteur.getText(),
                                                resume.getText(),
                                                colonne.getText(),
                                                rangee.getText(),
                                                parution.getText(),

                                        }
                                );

                                titre.setText("");
                                auteur.setText("");
                                resume.setText("");
                                colonne.setText("");
                                rangee.setText("");
                                parution.setText("");

                            }else{
                                JOptionPane.showMessageDialog(null, "Date non correcte");
                            }

                        }else{
                            JOptionPane.showMessageDialog(null, "Rangée pas bonne");

                        }

                    }else{
                        JOptionPane.showMessageDialog(null, "colonne pas bonne");

                    }

                }
                catch (NumberFormatException numberFormatException){
                    JOptionPane.showMessageDialog(null, "Valeur incorrecte concernant la date, la rangée, ou la colonne");

                }

                //Ajouter les données du formulaire

                    }
                });
        gbc.gridx = 2;
        gbc.gridy=2;
        panel.add(ajoutBouton,gbc);







        setContentPane(panel);
        }
    }


