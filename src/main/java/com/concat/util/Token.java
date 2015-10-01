package com.concat.util;
import java.util.ArrayList;

/**
 * 
 * @author thisara
 *
 */
public class Token {

	private String word;
	private double count;
	private double scnt;
	private double wght;

	private ArrayList<String> sentensePosList;
	private ArrayList<String> wordPosList;

	public Token(String token) {
		word = new String(token);
		sentensePosList = new ArrayList<String>();
		wordPosList = new ArrayList<String>();
		count = 0;
		scnt = 0;
	}

	public void incrementCount(int sentensePos, int wordPos) {
		count++;
		addToSentensePosList(sentensePos);
		addToWordPosList(wordPos);
	}

	public double getCount() {
		return count;
	}

	public String getWord() {
		return word;
	}

	public void addToSentensePosList(int sentensePos) {
		if (!sentensePosList.contains(sentensePos + ""))
			scnt++;
			sentensePosList.add(sentensePos + "");
	}

	public void addToWordPosList(int wordPos) {
		wordPosList.add(wordPos + "");
	}

	public ArrayList<String> getWordPosList() {
		return wordPosList;
	}

	public ArrayList<String> getSentensePos() {
		return sentensePosList;
	}

	public void weight(double wg) {
		wght = wg;
	}

	public double weight() {
		return wght;
	}

	public double sentenseCount() {
		return scnt;
	}

}