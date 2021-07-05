package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IHMQuestion2_2 extends JFrame {

    private JButton boutonA = new JButton("A");
    private JButton boutonB = new JButton("B");
    private JButton boutonC = new JButton("C");

    private TextArea contenu = new TextArea(30, 80);

 
    public IHMQuestion2_2() {
        super("IHM Question2_2");
        JPanel enHaut = new JPanel();
        enHaut.add(boutonA);
        enHaut.add(boutonB);
        enHaut.add(boutonC);
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu); // contenu sera transmis aux observateurs, voir
                                // la description des constructeurs
        setLocation(150,150);pack();show();
        enHaut.setBackground(Color.magenta);
        

        JButtonObserver jbo1 = new JButtonObserver("jbo1", contenu);
        JButtonObserver jbo2 = new JButtonObserver("jbo2", contenu);
        JButtonObserver jbo3 = new JButtonObserver("jbo3", contenu);
        
        // le bouton A a 3 observateurs jbo1, jbo2 et jbo3
        boutonA.addActionListener(jbo1);
        boutonA.addActionListener(jbo2);
        boutonA.addActionListener(jbo3);
        
        // le bouton B a 2 observateurs jbo1 et jbo2
        boutonB.addActionListener(jbo1);
        boutonB.addActionListener(jbo2);
        
        // le bouton C a 1 observateur jbo1
        boutonC.addActionListener(jbo1);
        
        
        JMouseObserver jmo1 = new JMouseObserver("jmo1", contenu);
        JMouseObserver jmo2 = new JMouseObserver("jmo2", contenu);
        JMouseObserver jmo3 = new JMouseObserver("jmo3", contenu);
        
        // le bouton A a 1 observateur jmo1
        boutonA.addMouseListener(jmo1);
        
        // le bouton B a 1 observateur jmo2
        boutonB.addMouseListener(jmo2);
        
        // le bouton C a 1 observateur jmo3
        boutonC.addMouseListener(jmo3);
    }
    
     public static void main(String[] args){
        new IHMQuestion2_1();
        new IHMQuestion2_2();
    }


}
