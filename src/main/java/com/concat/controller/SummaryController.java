package com.concat.controller;

import java.io.File;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.concat.model.Summary;
import com.concat.service.SummaryService;
import com.concat.util.SummaryUtil;

@Controller
public class SummaryController {
	
	private SummaryService summaryService;
	private Summary summary;
	private StringBuffer finalSummary;
	
	@Autowired(required=true)
	@Qualifier(value="summaryService")
	public void setSummaryService(SummaryService ps){
		this.summaryService = ps;
	}
	
	@RequestMapping(value = "/summarize", method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public @ResponseBody Set<String> summarize(@RequestBody String originalText) {
  
        SummaryUtil s = new SummaryUtil();
		
		Set<String> summaryText = s.summarize(originalText);

        logService(originalText, summaryText.toString(), "TODO");
        
        return summaryText;//"summary "+userIdentity+" - "+originalText;
	}
	
	@RequestMapping(value = "/summarizeFile", method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public @ResponseBody Set<String> summarizeFile(@RequestBody File file) {

		SummaryUtil s = new SummaryUtil();
		
		Set<String> summaryText = s.summarize(file);

        logService(file.toString(), summaryText.toString(), "TODO");
        
        return summaryText;//"summary "+userIdentity+" - "+originalText;
	}
	
	@RequestMapping(value = "/summaries", method = RequestMethod.GET)
	public String listSummarys(Model model) {
		model.addAttribute("summary", new Summary());
		model.addAttribute("listSummaries", this.summaryService.listSummaries());
		return "summary";
	}
	
	//For add and update summary both
	@RequestMapping(value= "/summary/add", method = RequestMethod.POST)
	public String addSummary(@ModelAttribute("summary") Summary s){
		if(s.getId() == 0){
			//new summary, add it
			this.summaryService.addSummary(s);
		}else{
			//existing summary, call update
			this.summaryService.updateSummary(s);
		}
		
		return "redirect:/summaries";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeSummary(@PathVariable("id") int id){		
        this.summaryService.removeSummary(id);
        return "redirect:/summaries";
    }
 
    @RequestMapping("/edit/{id}")
    public String editSummary(@PathVariable("id") int id, Model model){
        model.addAttribute("summary", this.summaryService.getSummaryById(id));
        model.addAttribute("listSummaries", this.summaryService.listSummaries());
        return "summary";
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
