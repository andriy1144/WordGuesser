package org.project.GameWindows;

import javax.swing.*;
import java.awt.*;

public class MainJFrame extends JFrame {
    protected void createUIFrame(int width, int height){
        setSize(new Dimension(width,height)); // Default: 800x700
        setLocationRelativeTo(null);
        setTitle("Word Guesser");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
