package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

public class WhiteBoard extends JPanel implements MouseListener, MouseMotionListener, Cloneable {
    private Point curr = null;
    private Point prev = null;
    private Color couleurPinceau;
    private Color couleurFond;
    private Graphics2D graph;
    private int taille;
    
    //Permet d'identifier le tableau pour faciliter le traitement pour l'action du bouton clear
    public int id;


    /**
     * constructeur pour dÃ©finir un identifiant du tableau pour faciliter le traitement avec le bouton clear
     * @param id
     */
    public WhiteBoard(int id) {
        addMouseListener(this);
        addMouseMotionListener(this);
        setOpaque(false);
        this.id = id;
        this.couleurPinceau = Color.BLACK;
        this.couleurFond = Color.LIGHT_GRAY;
        this.graph = (Graphics2D) getGraphics();
        this.taille = 1;
    }
    
    public void setTaille(int varTaille)
    {
    	this.taille = varTaille;
    }

    public void clear() {
        getGraphics().clearRect(0, 0, getWidth(), getHeight());
    }

    public int getId(){
        return this.id;
    }

    /**
     * permet de tracer les traits
     * @param e
     */
    @Override
    public void mouseDragged(final MouseEvent e) {

        int taille = 25;
        prev=curr;
        curr=e.getPoint();
        
        System.out.println( this.graph );
        
        Graphics2D g2 = (Graphics2D) getGraphics();
                
        g2.setColor(couleurPinceau);
        g2.setStroke(new BasicStroke( this.taille ));
        g2.draw(new Line2D.Float(prev.x, prev.y, curr.x, curr.y));
        graph = g2;
        //      
//      g2 = (Graphics2D) graph.create(); 
      
//       this.graph.setColor(couleurPinceau);
//       this.graph.setStroke(new BasicStroke( taille ));
//       this.graph.draw(new Line2D.Float(prev.x, prev.y, curr.x, curr.y));
        
            
    }	

    public void setCouleurPinceau(Color couleurCourante)
    {
        this.couleurPinceau = couleurCourante;
    }

    public Color getCouleurFond(){
        return this.couleurFond;
    }

    @Override
    public void mouseMoved(final MouseEvent e) { }

    @Override
    public void mouseClicked(final MouseEvent e) { }

    @Override
    public void mouseEntered(final MouseEvent e) { }

    @Override
    public void mouseExited(final MouseEvent e) { }

    @Override
    public void mousePressed(final MouseEvent e) {
        curr = e.getPoint();
    }

    /**
     * Permet d'arreter le dessin quand on arrete de cliquer sur la souris
     * @param e
     */
    @Override
    public void mouseReleased(final MouseEvent e) {
        prev=curr=null;
    }
    
	public Object clone() {
		Object o = null;
		try {
			// On récupère l'instance à renvoyer par l'appel de la 
			// méthode super.clone()
			o = super.clone();
		} catch(CloneNotSupportedException cnse) {
			// Ne devrait jamais arriver car nous implémentons 
			// l'interface Cloneable
			cnse.printStackTrace(System.err);
		}
		// on renvoie le clone
		return o;
	}
}
