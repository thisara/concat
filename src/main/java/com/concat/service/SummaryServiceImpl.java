package com.concat.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concat.dao.SummaryDAO;
import com.concat.model.Summary;

@Service
public class SummaryServiceImpl implements SummaryService {
	
	private SummaryDAO summaryDAO;

	public void setSummaryDAO(SummaryDAO summaryDAO) {
		this.summaryDAO = summaryDAO;
	}

	@Override
	public void addSummary(Summary p) {
		this.summaryDAO.addSummary(p);
	}

	@Override
	public void updateSummary(Summary p) {
		this.summaryDAO.updateSummary(p);
	}

	@Override
	public List<Summary> listSummaries() {
		return this.summaryDAO.listSummaries();
	}

	@Override
	public Summary getSummaryById(int id) {
		return this.summaryDAO.getSummaryById(id);
	}

	@Override
	public void removeSummary(int id) {
		this.summaryDAO.removeSummary(id);
	}

}
