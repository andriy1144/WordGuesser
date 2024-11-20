package org.project.GameWindows;

import org.project.Utilz.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends MainJFrame {
    private final Font titleFont = new Font(Font.MONOSPACED,Font.BOLD,100);
    private final Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 45);

    public MenuWindow(){
        createUIFrame(800,700);

        getContentPane().add(new TitlePanel(), BorderLayout.NORTH);
        getContentPane().add(new ButtonPanel(this), BorderLayout.CENTER);

        setVisible(true);
    }

    /* TITLE PANEL */
    private class TitlePanel extends JPanel{
        private JLabel title;

        TitlePanel(){
            setLayout(new GridBagLayout());
            setPreferredSize(new Dimension(800,400));
            setBackground(Color.BLACK);

            createUIPanel();
        }

        private void createUIPanel(){
            title = new JLabel("Word Guesser");
            title.setFont(titleFont);
            title.setForeground(Color.WHITE);

            add(title);
        }
    }

    /* Button panel */
    private class ButtonPanel extends JPanel{
        private JButton btnPlay;
        private final JFrame rootFrame;

        ButtonPanel(JFrame rootFrame){
            setLayout(new GridBagLayout());
            setPreferredSize(new Dimension(800,300));
            setBackground(Color.BLACK);

            this.rootFrame = rootFrame;

            createUIPanel();
        }

        private void createUIPanel() {
            btnPlay = new RoundedButton("Play");
            btnPlay.setFont(buttonFont);
            btnPlay.setPreferredSize(new Dimension(400,100));

            btnPlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    rootFrame.dispose();
                    new GameWindow();
                }
            });
            add(btnPlay);
        }
    }
}
