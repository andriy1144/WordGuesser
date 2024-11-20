package org.project.GameWindows.Panels;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {
    private final Font titleFont = new Font(Font.MONOSPACED, Font.BOLD, 45);

    private JLabel label;

    public HeaderPanel(){
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(800,100));
        setBorder(BorderFactory.createMatteBorder(0,0,5,0,Color.WHITE));
        setBackground(Color.BLACK);

        createUIPanel();
    }

    private void createUIPanel(){
        label = new JLabel("Word Guesser");
        label.setFont(titleFont);
        label.setForeground(Color.WHITE);

        add(label);
    }
}
