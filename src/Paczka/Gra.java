package Paczka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Gra extends JPanel implements KeyListener, ActionListener{

    private int x = 300;
    private int speed = 20;
    private Timer time;
    private int ex = 10;
    private int ey = 10;
    private Random liczba = new Random();
    private Random ilosc = new Random();
    private int wrogX1 = liczba.nextInt(6) *100;
    private int wrogX2 = liczba.nextInt(6) *100;
    private int wrogX3 = liczba.nextInt(6) *100;
    private int wrogX4 = liczba.nextInt(6) *100;
    private int wrogX5 = liczba.nextInt(6) *100;
    private int wrogX6 = liczba.nextInt(6) *100;

    private int punkty = 0;

    public Gra(){

        time = new Timer(10,this);
        time.start();


        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(this);



    }

    public void paint(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(0,0,900,800);

        /***************************************************************
                                        Gracz
        **************************************************************** */

        g.setColor(Color.blue);
        g.fillRect(x,685,45,45);

        /***************************************************************
                                    Wrog
         **************************************************************** */
        g.setColor(Color.red);
        g.fillRect(wrogX1,ey,50,50);
        g.fillRect(wrogX2,ey,50,50);
        g.fillRect(wrogX3,ey,50,50);
        g.fillRect(wrogX4,ey,50,50);
        g.fillRect(wrogX5,ey,50,50);


        /***************************************************************
                                    Punkty
         **************************************************************** */

        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,20));
        g.drawString("Punkty: " + punkty,750,40);



    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        ey+=2;

        if(ey == 750){
            punkty++;
            ey = 10;
            wrogX1 = liczba.nextInt(6)*100;
            wrogX2 = liczba.nextInt(6)*100;
            wrogX3 = liczba.nextInt(6)*100;
            wrogX4 = liczba.nextInt(6)*100;
            wrogX5 = liczba.nextInt(6)*100;


        }

        Rectangle gracz = new Rectangle(x,685,75,75);
        Rectangle wrog1 = new Rectangle(wrogX1,ey,50,50);
        Rectangle wrog2 = new Rectangle(wrogX2,ey,50,50);
        Rectangle wrog3 = new Rectangle(wrogX3,ey,50,50);
        Rectangle wrog4 = new Rectangle(wrogX4,ey,50,50);
        Rectangle wrog5 = new Rectangle(wrogX5,ey,50,50);

        if(gracz.intersects(wrog1) || gracz.intersects(wrog2)|| gracz.intersects(wrog3)|| gracz.intersects(wrog4)|| gracz.intersects(wrog5)){
            time.stop();
            nextgame();
            punkty= 0;



        }

    }



    private void nextgame() {

        JOptionPane.showMessageDialog(null,"\tGame over" + "\n Zdobyłeś: "+ punkty + " punkty" + "\n wciśnij enter, aby rozpoczać od nowa");

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_A){
            if( x == 0){
                x = 0;
            }else {
                x -= speed;

                }



        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            if(x == 840){
               x = 840;
            } else {
                x += speed;

            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            reset();

        }
    }

    private void reset() {
        ey = 10;
        wrogX1 = liczba.nextInt(6)*100;
        wrogX2 = liczba.nextInt(6)*100;
        wrogX3 = liczba.nextInt(6)*100;
        wrogX4 = liczba.nextInt(6)*100;
        wrogX5 = liczba.nextInt(6)*100;

        x = 300;
        time.start();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
