package org.example.controller;
import org.example.controller.action.ActionDraw;
import org.example.controller.action.ActionInterface;
import org.example.model.Model;
import org.example.model.MyShape;
import org.example.view.*;


import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import java.awt.geom.RectangularShape;
import java.util.Collection;

public class Controller {
    Model model;
    MyPanel panel;
    MyFrame frame;
    ActionInterface actionInterface;

    public Controller() {
        model = new Model();
        model.setCurrentShape(new MyShape());
        panel = new MyPanel(this);
        frame = new MyFrame(panel);
        actionInterface = new ActionDraw(model);
        frame.setController(this);
    }

    public void setActionInterface(ActionInterface actionInterface) {
        this.actionInterface = actionInterface;
        actionInterface.setModel(model);
    }

    public void mousePressed(Point point) {
        actionInterface.mousePressed(point);
    }

    public void mouseDragged(Point point) {
        actionInterface.mouseDragged(point);
    }

    public Collection<MyShape> translate() {
        return model.getList();
    }



}
