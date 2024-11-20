package org.project.Utilz;

import java.util.*;

import javax.swing.JFrame;

public class WindowsManager {
	private static final List<JFrame> wins = new ArrayList<>();
	
	private WindowsManager() {}
	
	public static void addWindow(JFrame window) {
		if(window != null) {
			wins.add(window);
		}
	}
	
	public static void closeAllWindows() {
		for(JFrame win : wins) {
			win.dispose();
		}
	}
}
