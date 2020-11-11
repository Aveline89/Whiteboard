package com.codebind;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ControlTableau extends JFrame implements ActionListener {

    Fenetre fen;
    List<WhiteBoard> listeTableau;

    Color couleurCourante;

    /**
     * constructeur
     * @param fen
     */
    public ControlTableau(Fenetre fen){
        this.fen = fen;
        this.listeTableau = new ArrayList<WhiteBoard>(3);
        listeTableau.add(fen.tableau1);
        listeTableau.add(fen.tableau2);
        listeTableau.add(fen.tableau3);


    }

    /**
     * Permet pour le moment de définir le tableau courant pour le retenir
     * @param actionEvent
     */
    public void actionPerformed(ActionEvent actionEvent)
    {
        /**listeTableau.get(0).setVisible(false);
        listeTableau.get(1).setVisible(false);
        listeTableau.get(2).setVisible(false);*/

        //action du bouton butTab1
        if(actionEvent.getSource() == fen.butTab1)
        {
            //fen.ptab1.setVisible(false);
            /**listeTableau.get(0).setVisible(true);
            listeTableau.get(1).setVisible(false);
            listeTableau.get(2).setVisible(false);*/
            fen.tableauCourant = fen.tableau1;
            fen.tableau1.setVisible(true);
            fen.tableau2.setVisible(false);
            fen.tableau3.setVisible(false);
            //System.out.println(fen.tableauCourant.getId());
        }

        //action du bouton butTab2
        if(actionEvent.getSource() == fen.butTab2)
        {
            /**listeTableau.get(1).setVisible(true);
            listeTableau.get(0).setVisible(false);
            listeTableau.get(2).setVisible(false);*/
            fen.tableauCourant = fen.tableau2;
            fen.tableau2.setVisible(true);
            fen.tableau1.setVisible(false);
            fen.tableau3.setVisible(false);
            //System.out.println(fen.tableauCourant.getId());
        }

        //action du bouton butTab3
        if(actionEvent.getSource() == fen.butTab3)
        {
            /**listeTableau.get(2).setVisible(true);
            listeTableau.get(1).setVisible(false);
            listeTableau.get(0).setVisible(false);*/
            fen.tableauCourant = fen.tableau3;
            fen.tableau3.setVisible(true);
            fen.tableau1.setVisible(false);
            fen.tableau2.setVisible(false);
            //System.out.println(fen.tableauCourant.getId());
        }

        if(actionEvent.getSource() == fen.btnTextField)
        {
            JTextField textField = new JTextField();
            textField.setSize(50,50);
            fen.add(textField);
            fen.validate();
            fen.repaint();
        }

        if(actionEvent.getSource() == fen.btnColorBlue)
        {
            fen.tableauCourant.setCouleurPinceau(Color.BLUE);
            this.couleurCourante = Color.BLUE;
            System.out.println(fen.tableauCourant.getId());
            System.out.println(fen.tableauCourant.getId());
        }

        if(actionEvent.getSource() == fen.btnColorGreen)
        {
            fen.tableauCourant.setCouleurPinceau(Color.GREEN);
            this.couleurCourante = Color.GREEN;
            System.out.println(fen.tableauCourant.getId());
            System.out.println(fen.tableauCourant.getId());
        }

        if(actionEvent.getSource() == fen.btnColorRed)
        {
            fen.tableauCourant.setCouleurPinceau(Color.RED);
            this.couleurCourante = Color.RED;
            System.out.println(fen.tableauCourant.getId());
            System.out.println(fen.tableauCourant.getId());
        }

        if(actionEvent.getSource() == fen.btnColorBlack)
        {
            fen.tableauCourant.setCouleurPinceau(Color.BLACK);
            this.couleurCourante = Color.BLACK;
            System.out.println(fen.tableauCourant.getId());
            System.out.println(fen.tableauCourant.getId());
        }

        if(actionEvent.getSource() == fen.btnEraser)
        {
            fen.tableauCourant.setCouleurPinceau(fen.tableauCourant.getCouleurFond());
            System.out.println(fen.tableauCourant.getId());
            System.out.println(fen.tableauCourant.getId());
        }

        if(actionEvent.getSource() == fen.btnPen)
        {
            fen.tableauCourant.setCouleurPinceau(this.couleurCourante);
            System.out.println(fen.tableauCourant.getId());
            System.out.println(fen.tableauCourant.getId());
        }
    }

}
