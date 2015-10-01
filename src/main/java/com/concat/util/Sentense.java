package com.concat.util;

/**
 * 
 * @author thisara
 *
 */
public class Sentense {

	String rawSentense = "", srSentense = "";
	private double wght;

	public Sentense(String sen) {
		rawSentense = new String(sen);
		wght = 0.0;
	}

	public void setRawSentense(String sentense) {
		rawSentense = new String(sentense);
	}

	public void setsrSentence(String rsen) {
		srSentense = new String(rsen);
	}

	public String getRawSentense() {
		return rawSentense;
	}

	public String getsrSentence() {
		return srSentense;
	}

	public void weight(double wg) {
		wght = wght + wg;
	}

	public double weight() {
		return wght;
	}

}