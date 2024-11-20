package org.project.GameWindows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import org.project.Utilz.*;

public class GameOverWindow extends MainJFrame{

	public GameOverWindow(String word, int attempts) {
		WindowsManager.addWindow(this);
		createUIFrame(400,400);
		
		getContentPane().add(new HeaderPanel(), BorderLayout.NORTH);
		getContentPane().add(new StatusPanel(word,attempts), BorderLayout.CENTER);
		getContentPane().add(new ButtonPanel(this), BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	
	/* HEADER PANEL */
	private class HeaderPanel extends JPanel{
	    private final Font titleFont = new Font(Font.MONOSPACED,Font.BOLD,60);
		private JLabel title;
		
		HeaderPanel() {
			setLayout(new GridBagLayout());
			setPreferredSize(new Dimension(400,100));
			setBackground(Color.BLACK);
			
			createUIPanel();
		}
		
		private void createUIPanel(){
			title = new JLabel("You won!");
			title.setForeground(Color.WHITE);
			title.setFont(titleFont);
			
			add(title);
		}
	}
	
	/* BUTTON PANEL */
	private class ButtonPanel extends JPanel implements ActionListener{
	    private final Font btnFont = new Font(Font.MONOSPACED,Font.BOLD,30);
		private JButton playAgainBtn, menuBtn;
		private GameOverWindow rootFrame;
		
		ButtonPanel(GameOverWindow rootFrame){
			this.rootFrame = rootFrame;
			
			setLayout(new FlowLayout(FlowLayout.CENTER));
			setPreferredSize(new Dimension(400,100));
			setBackground(Color.BLACK);
			
			createUIPanel();
		}
		
		private void createUIPanel(){
			playAgainBtn = new RoundedButton("Play again");
			playAgainBtn.setFont(btnFont);
			playAgainBtn.addActionListener(this);
			add(playAgainBtn);
			
			menuBtn = new RoundedButton("Menu");
			menuBtn.setFont(btnFont);
			menuBtn.addActionListener(this);
			add(menuBtn);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			
			WindowsManager.closeAllWindows();
			if(source.getText().equals("Play again")) {
				new GameWindow();
			}else {
				new MenuWindow();
			}
		}
	}
	
	/* STATISTIC PANEL */
	private class StatusPanel extends JPanel{
	    private final Font textFont = new Font(Font.MONOSPACED,Font.BOLD,35);
		private JLabel word, attempts;
		private String wordString;
		private int attemptsInt; 
		
		StatusPanel(String wordString, int attempts){
			this.wordString = wordString;
			this.attemptsInt = attempts;
			
			setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			setPreferredSize(new Dimension(400,200));
			setBackground(Color.BLACK);
			
			createUIPanel();
		}
		
		private void createUIPanel(){			
			word = new JLabel("Word: " + wordString);
			word.setAlignmentX(CENTER_ALIGNMENT);
			word.setFont(textFont);
			add(word);
			
			
			attempts = new JLabel("Attempts: " + attemptsInt);
			attempts.setAlignmentX(CENTER_ALIGNMENT);
			attempts.setFont(textFont);
			add(attempts);
		}
	}
	
}
