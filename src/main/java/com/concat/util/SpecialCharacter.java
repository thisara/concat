package com.concat.util;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 
 * @author thisara
 *
 */
public class SpecialCharacter {

	char specialCharacterArray[];

	public SpecialCharacter() {
		int cnt = 0, sz = 0;
		char bt[] = null;
		try {
			File fp = new File("/home/sudeep/Desktop/hack/concat/src/main/java/com/concat/util/specials.txt");
			FileReader fis = new FileReader(fp);
			sz = (int) fp.length();
			bt = new char[sz];
			fis.read(bt);
			fis.close();
		} catch (IOException ex) {
		}
		specialCharacterArray = getTokens(new String(bt));
	}

	public char[] getTokens(String sen) {
		int sz = 0, cnt = 0;
		char words[] = null;
		StringTokenizer stk = new StringTokenizer(sen);
		sz = stk.countTokens();
		words = new char[sz];
		while (stk.hasMoreTokens()) {
			words[cnt] = new String(stk.nextToken()).charAt(0);
			cnt++;
		}
		return words;
	}

	public String remove(String sen) {
		String dsen = new String(sen);

		for (int j = 0; j < specialCharacterArray.length; j++) {

			char csh[] = dsen.toCharArray();
			dsen = "";
			for (int i = 0; i < csh.length; i++)
				if (csh[i] != specialCharacterArray[j])
					dsen = dsen + csh[i];

		}

		return dsen;
	}

}