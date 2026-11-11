package org.example.view;
import org.example.controller.Controller;
import org.example.controller.action.ActionDraw;
import org.example.controller.action.ActionMove;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    MyPanel myPanel;
    Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public MyFrame(MyPanel myPanel) throws HeadlessException {
        /////////////////////////////// menu /////////////////////
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu action = new JMenu("Action");
        JMenuItem draw = new JMenuItem("Draw");
        JMenuItem move = new JMenuItem("Move");
        action.add(draw);
        action.add(move);
        menuBar.add(action);
        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setActionInterface(new ActionDraw());
            }
        });
        move.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setActionInterface(new ActionMove());
            }
        });
        /////////////////////////////// panel/////////////////////
        this.myPanel = myPanel;
        add(myPanel);
        super.setSize(500,500);
        setVisible(true);
    }
}
