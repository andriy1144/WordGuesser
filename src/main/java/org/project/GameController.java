package org.project;

import java.util.Random;

import org.project.GameWindows.GameWindow;

public class GameController {
	private char[] wordArray;
	private char[] wordAnswer;
	
	private int attempts;
	
	private GameWindow gameWindow;
	
	public GameController(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
		attempts = 0;
		
		int chosenWordIndex = generateIndex();
		String chosenWord = Words.words[chosenWordIndex];

		//System.out.println(chosenWord);
		setWord(chosenWord);
	}

	private int generateIndex() {
		Random rand = new Random();
		return rand.nextInt(Words.getLength());
	}
	
	public void setWord(String word) {
		this.wordAnswer = word.toCharArray();
		hideWord(wordAnswer.length);
	}

	private void hideWord(int length) {
		wordArray = new char[length*2 - 1];
		for(int i = 0; i < length*2-1; i++) {
			wordArray[i] = i % 2 == 0 ? '_' : ' ';
		}
		updateGamePanel();
	}
	
	public boolean guessWord(String guess) {
		if(guess.length() != wordAnswer.length) {
			//Will show message in the future;
			return false;
		}
		
		char[] guessArray = guess.toCharArray();
		checkWord(guessArray);
		
		updateGamePanel();
		attempts++;

		return checkWin();
	}
	
	private void updateGamePanel() {
		gameWindow.getGamePanel().setWord(String.valueOf(wordArray));
	}
	
	private void checkWord(char[] guessArray) {
		int wordArrayInd = 0;
		for(int i = 0; i < guessArray.length; i++) {
			if(wordAnswer[i] == guessArray[i]) {
				wordArray[wordArrayInd] = wordAnswer[i];
			}
			wordArrayInd+=2;
		}
	}
	
	private boolean checkWin() {
		for(int i = 0; i < wordArray.length; i+=2) {
			if(wordArray[i] == '_') return false;
		}
		return true;
	}
	
	public int getWordLen() {
		return wordAnswer.length;
	}

	public String getWord() {
		return String.valueOf(wordAnswer);
	}

	public int getAttempts() {
		return this.attempts;
	}
}
