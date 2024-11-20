package org.project.GameWindows.Panels;

import org.project.GameController;
import org.project.GameWindows.GameOverWindow;
import org.project.Utilz.RoundJTextField;
import org.project.Utilz.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputPanel extends JPanel {
    private final Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 35);
    private final Font textFieldFont = new Font(Font.MONOSPACED, Font.BOLD,25);

    private JTextField field;
    private JButton enterBtn;
    
    private GameController gameController;

    private int maxWordLen;
    
    public InputPanel(GameController gameController){
    	this.gameController = gameController;
    	maxWordLen = gameController.getWordLen();
    	
        setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        setPreferredSize(new Dimension(800,200));
        setBackground(Color.BLACK);

        createUIPanel();
    }

    private void createUIPanel(){
        field = new RoundJTextField(20);
        field.setPreferredSize(new Dimension(300, 60));
        field.setFont(textFieldFont);
        field.addActionListener(new EnterButtonListener());
        field.setToolTipText("Enter a word of " + maxWordLen + " chars length");
        field.setSelectionColor(Color.ORANGE);
        add(field);
        
        enterBtn = new RoundedButton("Enter");
        enterBtn.setPreferredSize(new Dimension(200,60));
        enterBtn.setFont(buttonFont);
        enterBtn.addActionListener(new EnterButtonListener());
        
        add(enterBtn);
    }
    
    private class EnterButtonListener implements ActionListener {    	
		@Override
		public void actionPerformed(ActionEvent e) {
			String text = field.getText();
			if(gameController.guessWord(text.toLowerCase())) {
				field.setEditable(false);
				new GameOverWindow(gameController.getWord(),gameController.getAttempts());
			}
			field.setText("");
		}
    }
}
