package com.codebind;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Fenetre extends JFrame{

    // création du menu
    JMenuBar barMenu;
    JMenuItem itemImage;
    JMenuItem itemDiagramme;
    JMenuItem itemTableau;
    JMenu droits;
    JMenu insert;
    JMenu partage;
    JMenu save;
    JMenu connexion;
    JMenu inscription;

    // création des boutons sur la page
    JButton butTab1;
    JButton butTab2;
    JButton butTab3;
    JButton btClear;
    JButton crayon;
    JButton gomme;

    //Création des controles
    public ControlTableau controlTab;
    public ControlMenu controlMenu;
    public ControleClear clear;

    //création d'un tableau
    //WhiteBoard whiteBoard;
    WhiteBoard tableau1;
    WhiteBoard tableau2;
    WhiteBoard tableau3;
    WhiteBoard tableauCourant;
    JPanel ptab1;
    JPanel ptab2;
    JPanel ptab3;
    JPanel ptableau;



    public Fenetre()
    {
        initAtribut();
        creerInterface();
        creerMenu();
        pack();
        setSize(650,650);                   // Fixe la taille par défaut
        setVisible(true);                                // Affiche la fenetre
        setLocationRelativeTo(null);
        setTitle("Tableau Blanc Interractif");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Gestion de la fermeture
    }

    public void initAtribut()
    {
        // initiation menu
        barMenu = new JMenuBar();
        itemDiagramme = new JMenuItem("Diagramme");
        itemImage = new JMenuItem("Image");
        itemTableau = new JMenuItem("Tableau");
        droits = new JMenu("Droits");
        insert = new JMenu("Insertion");
        partage = new JMenu("Partager");
        save = new JMenu("Enregistre");
        connexion = new JMenu("Connexion");
        inscription = new JMenu("Inscription");


        //initiation des boutons sur la page principale
        butTab1 = new JButton("Tableau 1");
        butTab2 = new JButton("Tableau 2");
        butTab3 = new JButton("Tableau 3");
        btClear = new JButton("Clear");
        crayon = new JButton("Crayon");
        gomme = new JButton("gomme");


        //initiation des contrôles pour les action du Menu et des tableaux
        controlTab = new ControlTableau(this);
        controlMenu = new ControlMenu(this);
        clear = new ControleClear(this);


        // création des tableaux
        tableau1 = new WhiteBoard(1, Color.red);
        tableau2 = new WhiteBoard(2,Color.blue);
        tableau3 = new WhiteBoard(3, Color.magenta);
        tableauCourant =tableau1;

        ptab1 = new JPanel();
        ptab2 = new JPanel();
        ptab3 = new JPanel();
        ptableau = new JPanel();



    }

    public void creerMenu() {
        //gestion des actions si on clic sur un des menu
        itemDiagramme.addActionListener(controlMenu);
        itemImage.addActionListener(controlMenu);
        itemTableau.addActionListener(controlMenu);


        // ajout des éléments dans le JMenu insert
        insert.add(itemDiagramme);
        insert.add(itemImage);
        insert.add(itemTableau);


        // ajout des éléments à la barre de Menu
        barMenu.add(droits);
        barMenu.add(insert);
        barMenu.add(partage);
        barMenu.add(save);
        barMenu.add(connexion);
        barMenu.add(inscription);
        setJMenuBar(barMenu);


        //ajout des tableaux
        getContentPane().add(tableau1, BorderLayout.CENTER);
        getContentPane().add(tableau2, BorderLayout.CENTER);
        getContentPane().add(tableau3, BorderLayout.CENTER);


        tableau2.setVisible(false);
        tableau3.setVisible(false);

    }

    public void creerInterface()
    {
        /**pour superposer setLayout = null*/
        //création du panel général avec alignement verticale des éléments
        JPanel pano = new JPanel();
        pano.setLayout(new BoxLayout(pano, BoxLayout.Y_AXIS));

        //création du panel pour les boutons avec alignement horizontal des éléments
        JPanel panButTab = new JPanel();
        panButTab.setLayout(new BoxLayout(panButTab, BoxLayout.X_AXIS));

        // Insertion ajout des boutons dans le panel
        panButTab.add(butTab1);
        panButTab.add(butTab2);
        panButTab.add(butTab3);
        panButTab.add(btClear);
        panButTab.add(gomme);
        panButTab.add(crayon);

        // ajout du panel avec les boutons dans le panel
        pano.add(panButTab);

        ptableau.add(tableau1);
        ptableau.add(tableau2);
        ptableau.add(tableau3);
        ptableau.setLayout(null);

        setContentPane(ptableau);

        //ajout des actions sur les boutons
        butTab1.addActionListener(controlTab);
        butTab2.addActionListener(controlTab);
        butTab3.addActionListener(controlTab);
        btClear.addActionListener(clear);

        //permet l'affichag du panel général
        setContentPane(pano);

    }

}
