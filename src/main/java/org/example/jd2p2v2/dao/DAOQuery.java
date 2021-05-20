package org.example.jd2p2v2.dao;

public final class DAOQuery {
    public static final String GET_ALL_NEWS_QUERY = "from News where status=:status order by :date desc";

    private DAOQuery() {}
}
