package com.concat.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.AbstractList;

/**
 * 
 * @author thisara
 *
 */
public class SentenseUtil {

	String doc = "";

	public SentenseUtil(String content) {
		doc = new String(content);
		doc = doc.replaceAll("\r\n", " ");
	}

	public SentenseUtil(File fp) {     
	    int sz; byte bt[];  
	    try { 			            
	    FileInputStream fis=new FileInputStream(fp);
	    sz=(int)fp.length();	
	    bt=new byte[sz];
	    fis.read(bt);            
	    this.doc=new String(bt);    	
	    } 
	   catch(IOException ex){   System.out.println(ex);}
	 }
	
	public AbstractList<Sentense> separateSentense(AbstractList<Sentense> sentenseList) {
		int fs1 = 0, fs2 = 0;
		int nx = 0;

		while (nx < (doc.length() - 1)) {
			nx = doc.indexOf(".", fs2);
			if (nx == -1)
				break;
			else if (nx == doc.lastIndexOf(".")) {
				String str = (doc.substring(fs1, nx + 1)).toLowerCase();
				sentenseList.add(new Sentense(str));
				fs2 = nx + 1;
				fs1 = fs2;
				break;
			} else if (doc.charAt(nx + 1) == ' ' || doc.charAt(nx + 1) == '\r' || doc.charAt(nx + 1) == '\n') {
				String str = (doc.substring(fs1, nx + 1).toLowerCase()).trim();
				sentenseList.add(new Sentense(str));
				fs2 = nx + 1;
				fs1 = fs2;
			} else
				fs2 = nx + 1;
		}

		return sentenseList;
	}

}