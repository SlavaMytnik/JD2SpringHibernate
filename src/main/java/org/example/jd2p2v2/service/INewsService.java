package org.example.jd2p2v2.service;

import java.util.List;

import org.example.jd2p2v2.entity.News;

public interface INewsService {
	List<News> getAll();
	News getById(int id);
	void editById(int id, String title, String brief, String content);
	void deleteById(int id);
}
