package com.concat.util;
import java.io.*;
import java.util.StringTokenizer;

/**
 * 
 * @author thisara
 *
 */
public class StopWord {

	String stopWordArray[];

	public StopWord() {
		int cnt = 0, sz = 0;
		char bt[] = null;
		try {
			File fp = new File("F:/TPI-UserStories/Q3/L2_ToolProfileAutomation/EclipseWorkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp4/wtpwebapps/ConCat/WEB-INF/classes/com/concat/util/stopwords.txt");
			FileReader fis = new FileReader(fp);
			sz = (int) fp.length();
			bt = new char[sz];
			fis.read(bt);
			fis.close();
		} catch (IOException ex) {
		}
		stopWordArray = getTokens(new String(bt));
	}

	public boolean isStopword(String word) {
		boolean flag = false;
		for (int i = 0; i < stopWordArray.length; i++) {
			if (stopWordArray[i].equalsIgnoreCase(word)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public String[] getTokens(String sen) {
		int sz = 0, cnt = 0;
		String words[] = null;
		StringTokenizer stk = new StringTokenizer(sen);
		sz = stk.countTokens();
		words = new String[sz];
		while (stk.hasMoreTokens()) {
			words[cnt] = new String(stk.nextToken());
			cnt++;
		}
		return words;
	}

	public String remove(String sen) {
		String dsen = "";
		String words[] = getTokens(sen);
		for (int j = 0; j < words.length; j++) {
			if (!isStopword(words[j]))
				dsen = dsen + words[j] + " ";
		}
		return dsen;
	}

}