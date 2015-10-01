package com.concat.util;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Enumeration;
import java.util.Set;

/**
 * 
 * @author thisara
 *
 */
public class SummaryUtil {
	
	Set<String> summaryPoints;
	StringBuffer summary;
	ArrayList<Sentense> sentenseList;
	Hashtable<String,Token> tokenMap;
	double scnt;

	public SummaryUtil() {
		sentenseList = new ArrayList<Sentense>();
		summaryPoints = new TreeSet<String>();
		tokenMap = new Hashtable<String,Token>();
		summary = new StringBuffer();		
	}

	public void removeStopWords() {

		StopWord stopWord = new StopWord();
		SpecialCharacter specialCharacter = new SpecialCharacter();
		for (int i = 0; i < sentenseList.size(); i++) {
			Sentense sentense = sentenseList.get(i);
			sentense.setsrSentence(specialCharacter.remove(sentense.getRawSentense()));
			sentense.setsrSentence(stopWord.remove(sentense.getsrSentence()));
		}
		summary.append("NO OF SENTENSE :"+sentenseList.size() +"\n\n");
		for (int i = 0; i < sentenseList.size(); i++) {
			Sentense sl = sentenseList.get(i);
			summary.append("\n" + (i+1) +":  "+ sl.getsrSentence());
			summaryPoints.add(sl.getsrSentence());
		}

	}

	public void separateSentense(String originalText) {
		SentenseUtil sentense = new SentenseUtil(originalText);
		sentense.separateSentense(sentenseList);	
		summary.append("NO OF SENTENSE :"+sentenseList.size() +"\n\n");
		scnt = sentenseList.size();
		for (int i = 0; i < sentenseList.size(); i++) {
			Sentense sl = sentenseList.get(i);
			summary.append("\n " + (i+1) +":  " + sl.getRawSentense());
			summaryPoints.add(sl.getsrSentence());
		}
	}
	
	public void separateSentense(File fp) {	
		SentenseUtil sentense=new SentenseUtil(fp);
		sentense.separateSentense(sentenseList);	
		summary.append("NO OF SENTENSE :"+sentenseList.size() +"\n\n");		
		scnt=sentenseList.size();
		for(int i=0;i<sentenseList.size();i++)
		 {	  
			Sentense sl= sentenseList.get(i);  	 
			summary.append("\n " + (i+1) +":  " + sl.getRawSentense());
			summaryPoints.add(sl.getsrSentence());
		 }		
	 }

	public double difPos(String str1, String str2) {
		int s1 = str1.length();
		int s2 = str2.length();
		int sz = (s1 > s2) ? s1 : s2;
		int mz = (s1 < s2) ? s1 : s2;
		double dp = mz, sm = 0;
		for (int i = 0; i < mz; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				dp = i + 1;
				break;
			} else
				sm++;
		}
		return (sm * (dp / sz));
	}

	private void addWord(String tok, int sp, int wp) {
		Token wl = new Token(tok);
		wl.incrementCount(sp + 1, wp);
		tokenMap.put(tok, wl);
	}

	private void upword(String tok, int sp, int wp) {
		Token wl = tokenMap.remove(tok);
		wl.incrementCount(sp + 1, wp);
		tokenMap.put(tok, wl);
	}

	private void delword(Object tok) {
		Token wl = tokenMap.remove(tok);
		if (wl.getCount() > 3)
			tokenMap.put((String)tok, wl);
	}

	private void setwight(Object tok) {
		double wg = 0.0;
		Token wl =  tokenMap.get(tok);
		double tf = wl.getCount();
		double df = wl.sentenseCount();
		wg = tf * Math.log10(scnt / df);
		wl.weight(wg);
	}

	public void uniqueWords() {
		for (int i = 0; i < sentenseList.size(); i++) {
			Sentense sentense = sentenseList.get(i);
			String srSentense = sentense.getsrSentence();
			int wc = 0;
			StringTokenizer stk = new StringTokenizer(srSentense, " ");
			while (stk.hasMoreElements()) {
				String tok = (String) stk.nextElement();
				tok = tok.trim();
				wc++;
				if (!tokenMap.containsKey(tok) && tok.length() >= 3)
					addWord(tok, i, wc);
				else if (tokenMap.containsKey(tok))
					upword(tok, i, wc);
			}
		}

		summary.append("No of unique words:" +tokenMap.size() + "\n");
		Enumeration<String> key = tokenMap.keys();
		while (key.hasMoreElements()) {
			Token wl =  tokenMap.get(key.nextElement());
			
			summary.append("\n" +wl.getWord() + ":  " + wl.getCount() );		    
		}
	}

	public void stemword(String w1, String w2) {

		if (!tokenMap.containsKey(w2) || !tokenMap.containsKey(w1)) {
			//System.out.print("return:");
			return;
		}
		Token wl1 =  tokenMap.remove(w1);
		Token wl2 =  tokenMap.remove(w2);

		ArrayList<String> wp = wl2.getWordPosList();
		ArrayList<String> sp = wl2.getSentensePos();

		for (int i = 0; i < wp.size(); i++) {
			String wp2 = wp.get(i);
			String sp2 = sp.get(i);
			wl1.incrementCount(Integer.parseInt(wp2), Integer.parseInt(sp2));
		}

		tokenMap.put(w1, wl1);

	}

	public void stemming() {

		int sz = tokenMap.size();
		double wdis[][] = new double[sz][sz];
		Set<String> s1 = tokenMap.keySet();
		Object obj[] = s1.toArray();

		for (int i = 0; i < sz; i++) {
			String str1 = (String) obj[i];
			for (int j = 0; j < sz; j++) {
				String str2 = (String) obj[j];
				if (i != j)
					wdis[i][j] = difPos(str1, str2);
			}
		}

		for (int i = 0; i < sz; i++) {
			String str1 = (String) obj[i];
			for (int j = 0; j < sz; j++) {
				String str2 = (String) obj[j];
				if (i != j && wdis[i][j] >= 3.0) {
					stemword(str1, str2);
				}
			}
		}

		summary.append("No of unique words:" +tokenMap.size() + "\n");
		Enumeration<String> key = tokenMap.keys();
		while (key.hasMoreElements()) {
			Token wl =  tokenMap.get(key.nextElement());
			summary.append("\n" +wl.getWord() + ":  " + wl.getCount());	
		}
	}

	public void significant() {

		Enumeration<String> key = tokenMap.keys();
		while (key.hasMoreElements())
			delword(key.nextElement());

		summary.append("No of Significant words:" +tokenMap.size() + "\n");
		key = tokenMap.keys();
		while (key.hasMoreElements()) {
			Token wl =  tokenMap.get(key.nextElement());
			summary.append("\n" +wl.getWord() + ":  " + wl.getCount() + ":"+wl.sentenseCount() );	
		}
	}

	public void weight() {
		Enumeration<String> key = tokenMap.keys();
		while (key.hasMoreElements())
			setwight(key.nextElement());

		summary.append("Weight of Significant words:" + "\n");
		key = tokenMap.keys();
		while (key.hasMoreElements()) {
			Token wl =  tokenMap.get(key.nextElement());
			summary.append("\n" +wl.getWord() + ":  " + wl.weight());		
		}
	}

	public String ranking() {
		Sentense sl = null;
		double max = 0.0;
		int mi = 0;

		for (int i = 0; i < sentenseList.size(); i++) {
			sl =  sentenseList.get(i);
			String sen = sl.getsrSentence();
			Enumeration<String> key = tokenMap.keys();
			while (key.hasMoreElements()) {
				String str = key.nextElement();
				if (sen.indexOf(str) != -1) {
					Token wl =  tokenMap.get(str);
					sl.weight(wl.weight());
				}
			}
		}

		for (int i = 0; i < sentenseList.size(); i++) {
			sl =  sentenseList.get(i);
			if (sl.weight() > max) {
				max = sl.weight();
				mi = i;
			}
		}

		summary.append("\t SUMMARY \n" ); 
		String str1 = sl.getRawSentense();
		sl =  sentenseList.get(mi);
		summary.append(sl.getRawSentense() +"\n" );
		  summary.append("\n Sentense  and Ranking "  +"\n");

		for (int i = 0; i < sentenseList.size(); i++) {
			sl =  sentenseList.get(i);
			summary.append("\n" + (i+1) +" : " + sl.getRawSentense() + " : " + sl.weight());     
		}

		return str1;
	}

	//Summarize text
	public Set<String> summarize(String s) {

		separateSentense(s);
		removeStopWords();
		uniqueWords();
		stemming();
		significant();
		weight();
		String str = ranking();
		System.out.println(str);
		
		summary.append("SUMMARY \n\n" ); 
		summary.append(str);
		
		return summaryPoints;
	}

	//Summarize text on a text file
	public Set<String> summarize(File file) {

		separateSentense(file);
		removeStopWords();
		uniqueWords();
		stemming();
		significant();
		weight();
		String str = ranking();
		System.out.println(str);
		
		summary.append("SUMMARY \n\n" ); 
		summary.append(str);
		
		return summaryPoints;
	}
	
	public static void main(String str[]) {
		
		SummaryUtil sm = new SummaryUtil();

		sm.summarize(
				"Apache Cassandra, a top level Apache project born at Facebook and built on Amazon’s Dynamo and Google’s BigTable, is a distributed database for managing large amounts of structured data across many commodity servers, while providing highly available service and no single point of failure.  Cassandra offers capabilities that relational databases and other NoSQL databases simply cannot match such as: continuous availability, linear scale performance, operational simplicity and easy data distribution across multiple data centers and cloud availability zones.");

	}

}