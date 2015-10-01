package com.concat.api.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.concat.model.Summary;
import com.concat.service.SummaryService;
import com.concat.util.SummaryUtil;

@Controller
public class SummaryAPIController {

	private SummaryService summaryService;
	private Summary summary;
	
	@Autowired(required=true)
	@Qualifier(value="summaryService")
	public void setSummaryService(SummaryService ps){
		this.summaryService = ps;
	}
	
	@RequestMapping(value = "/concat/text/summary", method = RequestMethod.POST)
	public @ResponseBody String summarizeText(@RequestParam("userIdentity") String userIdentity,@RequestParam("originalText") String originalText) {
		
		SummaryUtil s = new SummaryUtil();
		
		String summaryText = s.summarize(originalText);
				
		logService(originalText, summaryText, userIdentity);
		
		return summaryText;
	}
	
	@RequestMapping(value = "/concat/file/summary", method = RequestMethod.POST)
	public @ResponseBody String summarizeFile(@PathVariable("userIdentity") String userIdentity,@PathVariable("originalText") File originalFile) {
	
		SummaryUtil s = new SummaryUtil();
		
		String summaryText = s.summarize(originalFile);
				
		logService(originalFile.toString(), summaryText, userIdentity);
		
		return summaryText;
	}
	
	public void logService(String originalText,String summaryText, String userIdentity){

		try{
		summary = new Summary();
		
		summary.setOriginalText(originalText);
		summary.setSummary(summaryText);
		summary.setUserIdentity(userIdentity);
		
		summaryService.addSummary(summary);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
