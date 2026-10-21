package org.example.controller;
import org.example.view.MyFrame;
import org.example.view.MyPanel;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import java.awt.geom.RectangularShape;

public class Controller {
    Point2D []points;
    MyPanel myPanel;
    MyFrame myFrame;
    RectangularShape currentShape;
    Rectangle2D rectangle2D;
    Ellipse2D ellipse2D;


    public Controller(){
        rectangle2D = new Rectangle2D.Double();
        ellipse2D = new Ellipse2D.Double();
        points=new Point2D[2];

        myPanel=new MyPanel(this);
        myFrame=new MyFrame(myPanel);
        currentShape=rectangle2D;
    }

    public void mousePressed(Point point) {
        points[0]=point;
    }
    public void mouseDragged(Point point){
        points[1] = point;
    }
    public void draw(Graphics2D g2){
        if(points[0]!=null)
        {
            currentShape.setFrameFromDiagonal(points[0],points[1]);
            g2.draw(currentShape);
        }

    }


    public void setEllipse() {
        currentShape = ellipse2D;
    }

    public void setRect() {
        currentShape = rectangle2D;
    }
}
