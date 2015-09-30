package com.concat.dao;

import java.util.List;

import com.concat.model.Summary;

public interface SummaryDAO {

	public void addSummary(Summary p);
	public void updateSummary(Summary p);
	public List<Summary> listSummaries();
	public Summary getSummaryById(int id);
	public void removeSummary(int id);
	public int getNextSequence(String collectionName);
}
