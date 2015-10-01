package com.concat.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.concat.service.SummaryService;
import com.concat.util.SummaryUtil;

@Controller
public class SummaryAPIController {

	private SummaryService summaryService;
	
	@Autowired(required=true)
	@Qualifier(value="summaryService")
	public void setSummaryService(SummaryService ps){
		this.summaryService = ps;
	}
	
	@RequestMapping(value = "/concat/text/summary", method = RequestMethod.POST)
	public @ResponseBody String summarizeText(@RequestParam("userIdentity") String userIdentity,@RequestParam("originalText") String originalText) {
		
		SummaryUtil s = new SummaryUtil();
		
		return s.summarize(originalText);//"summary "+userIdentity+" - "+originalText;
	}
	
	@RequestMapping(value = "/concat/file/summary", method = RequestMethod.POST)
	public @ResponseBody String summarizeFile(@PathVariable("userIdentity") String userIdentity,@PathVariable("originalText") String originalText) {
	
		return "summary "+userIdentity+" - "+originalText;
	}
	

}
