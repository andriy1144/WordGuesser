package org.project.GameWindows.Panels;

import javax.swing.*;
import java.awt.*;

public class MainGamePanel extends JPanel {
    private final Font textFont = new Font(Font.MONOSPACED, Font.BOLD, 65);
    private JLabel word;

    public MainGamePanel(){
        setPreferredSize(new Dimension(800,400));
        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);

        createUIPanel();
    }

    private void createUIPanel(){
        word = new JLabel("");
        word.setFont(textFont);
        word.setForeground(Color.WHITE);

        add(word);
    }
    
    public void setWord(String word) {
    	this.word.setText(word);
    }
}
