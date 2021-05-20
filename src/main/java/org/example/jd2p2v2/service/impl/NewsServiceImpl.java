package org.example.jd2p2v2.service.impl;

import java.util.List;

import org.example.jd2p2v2.dao.INewsDAO;
import org.example.jd2p2v2.entity.News;
import org.example.jd2p2v2.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Service
@Validated
public class NewsServiceImpl implements INewsService {
	private final INewsDAO newsDAO;

	@Autowired
	public NewsServiceImpl(INewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}

	@Transactional
	@NotNull
	public List<News> getAll() {
		return newsDAO.getAll();
	}

	@Transactional
	@NotNull
	public News getById(int id) {
		return newsDAO.getById(id);
	}

	@Transactional
	public void editById(int id, String title, String brief, String content) {
		newsDAO.editById(id, title, brief, content);
	}

	@Transactional
	public void deleteById(int id) {
		newsDAO.deleteById(id);
	}
}
