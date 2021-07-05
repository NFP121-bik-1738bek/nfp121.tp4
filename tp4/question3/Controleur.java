package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Décrivez votre classe Controleur ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(null);
        
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        
        boutons.add(push);  push.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actEvt) {
                try {
                    pile.empiler(operande());
                    actualiserInterface();
                } catch (Exception exep) { }
            }
        });
        
        boutons.add(add);   add.addActionListener(new Operateur());
        boutons.add(sub);   sub.addActionListener(new Operateur());
        boutons.add(mul);   mul.addActionListener(new Operateur());
        boutons.add(div);   div.addActionListener(new Operateur());
    
        boutons.add(clear); clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action){
                try {
                    while(!pile.estVide()){
                        pile.depiler();
                    }
                    actualiserInterface();
                    } catch(Exception ex){
                }
            }
        });
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
        donnee.setText("");
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

    private class Operateur implements ActionListener {
        public void actionPerformed(ActionEvent ae){
            String operateur = ((JButton) ae.getSource()).getActionCommand();
            
            if (pile.taille() <= 1) {
                return;
            }
            
            try {
                int n1 = pile.depiler();
                int n2 = pile.depiler();
            
                switch(operateur) {
                    case "+" : pile.empiler(n1 + n2); break;
                    case "-" : pile.empiler(n2 - n1); break;
                    case "*" : pile.empiler(n1 * n2); break;
                    case "/" : if (n1 != 0) { pile.empiler(n2 / n1); } break;
                } 
                
                actualiserInterface();
            } catch (Exception ex1) {}
        }
    } 
}
