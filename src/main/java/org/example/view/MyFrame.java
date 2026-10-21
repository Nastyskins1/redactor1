package org.example.view;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyPanel myPanel;
    public MyFrame(MyPanel myPanel) throws HeadlessException {
        this.myPanel = myPanel;
        add(myPanel);
        super.setSize(500,500);
        setVisible(true);
    }
}
