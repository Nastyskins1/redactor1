package org.example.view;


import controller.Controller;
import model.SpeakBehavior;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;

public class MyPanel extends JPanel {
    JTextField t1;
    JButton b3;
    JButton b4;
    Controller controller;


    public MyPanel(Controller controller){
        this. controller=  controller;
        t1=new JTextField("                             ");
        b3=new JButton("Ellipse");
        b4=new JButton("Rect");


        add(t1);
        add(b3);
        add(b4);


        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                controller.setEllipse();;
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                controller.setRect();;
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                controller.mousePressed(e.getPoint());
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                controller.mouseDragged(e.getPoint());
                repaint();
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 =(Graphics2D) g;
        controller.draw(g2);
    }

}



