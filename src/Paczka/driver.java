package Paczka;

import javax.swing.*;

public class driver {


    public static void main (String[] args){

        Gra gra = new Gra();
        JFrame jf = new JFrame("Runerscaper");
        jf.setBounds(300,300,900,800);
        jf.setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setLocation(0,0);
        jf.add(gra);
    }

}
