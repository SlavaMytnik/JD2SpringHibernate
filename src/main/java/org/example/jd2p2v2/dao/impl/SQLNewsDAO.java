package org.example.jd2p2v2.dao.impl;

import java.util.List;

import org.example.jd2p2v2.dao.DAOAttr;
import org.example.jd2p2v2.dao.DAOQuery;
import org.example.jd2p2v2.dao.INewsDAO;
import org.example.jd2p2v2.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Repository
@Validated
public class SQLNewsDAO implements INewsDAO {
	private final SessionFactory sessionFactory;

	@Autowired
	public SQLNewsDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@NotNull
	public List<News> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<News> query =
				currentSession.createQuery(DAOQuery.GET_ALL_NEWS_QUERY,
						News.class);
		query.setParameter(DAOAttr.STATUS, DAOAttr.STATUS_ACTIVE);
		query.setParameter(DAOAttr.DATE, DAOAttr.DATE);

		return query.getResultList();
	}

	@Override
	@NotNull
	public News getById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		return currentSession.get(News.class, id);
	}

	@Override
	public void editById(int id, String title, String brief, String content) {
		Session currentSession = sessionFactory.getCurrentSession();

		News news = currentSession.get(News.class, id);
		news.setTitle(title);
		news.setBrief(brief);
		news.setContent(content);

		currentSession.update(news);
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		News news = currentSession.get(News.class, id);
		news.setStatus(DAOAttr.STATUS_DELETED);

		currentSession.update(news);
	}
}
