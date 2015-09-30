package com.concat.service;

import java.util.List;

import com.concat.model.Summary;

public interface SummaryService {

	public void addSummary(Summary p);
	public void updateSummary(Summary p);
	public List<Summary> listSummaries();
	public Summary getSummaryById(int id);
	public void removeSummary(int id);
	
}
