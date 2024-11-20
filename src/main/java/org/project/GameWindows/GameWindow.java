package org.project.GameWindows;

import org.project.GameWindows.Panels.HeaderPanel;
import org.project.GameWindows.Panels.InputPanel;
import org.project.GameWindows.Panels.MainGamePanel;
import org.project.Utilz.WindowsManager;

import java.awt.*;
import org.project.GameController;

public class GameWindow extends MainJFrame {
	private GameController gameController;
	
	private HeaderPanel headerPanel;
	private MainGamePanel mainGamePanel;
	private InputPanel inputPanel;
	
    public GameWindow(){
    	WindowsManager.addWindow(this);
    	createUIFrame(800,700);
    	
    	headerPanel = new HeaderPanel();
    	mainGamePanel = new MainGamePanel();
    	
    	gameController = new GameController(this);
    	    	
    	inputPanel = new InputPanel(gameController);
    	
        getContentPane().add(headerPanel, BorderLayout.NORTH);
        getContentPane().add(mainGamePanel, BorderLayout.CENTER);
        getContentPane().add(inputPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public HeaderPanel getHeaderPanel() {
    	return this.headerPanel;
    }
    public MainGamePanel getGamePanel() {
    	return this.mainGamePanel;
    }
    public InputPanel getInputPanel() {
    	return this.inputPanel;
    }
}