package com.concat.api.controller;

import java.io.File;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.concat.model.Summary;
import com.concat.service.SummaryService;
import com.concat.util.SummaryUtil;

/**
 * 
 * @author thisara
 *
 */
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
	public @ResponseBody Set<String> summarizeText(@RequestParam("userIdentity") String userIdentity,@RequestParam("originalText") String originalText) {
		
		SummaryUtil s = new SummaryUtil();
		
		Set<String> summaryText = s.summarize(originalText);
				
		logService(originalText, summaryText.toString(), userIdentity);
		
		return summaryText;
	}
	
	@RequestMapping(value = "/concat/file/summary", method = RequestMethod.POST)
	public @ResponseBody Set<String> summarizeFile(@PathVariable("userIdentity") String userIdentity,@PathVariable("originalText") File originalFile) {
	
		SummaryUtil s = new SummaryUtil();
		
		Set<String> summaryText = s.summarize(originalFile);
				
		logService(originalFile.toString(), summaryText.toString(), userIdentity);
		
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

    @RequestMapping(value = "/concat/text/summary/api", method = RequestMethod.POST)
    public @ResponseBody Set<String> summarizeTextSecond(@RequestBody String originalText) {

        System.out.println("originalText" + originalText);
        SummaryUtil s = new SummaryUtil();

        Set<String> summarize = s.summarize(originalText);

        logService(originalText, summarize.toString(), "2");
        return summarize;
    }


}
