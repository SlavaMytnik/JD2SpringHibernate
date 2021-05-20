package org.example.jd2p2v2.config;

public final class ConfigAttr {
    public static final String SERVLET_MAPPING = "/";

    public static final String PROPERTY_SOURCE =
            "classpath:database/database.properties";
    public static final String COMPONENT_SCAN = "org.example.jd2p2v2";

    public static final String DB_DRIVER = "db.driver";
    public static final String DB_URL = "db.url";
    public static final String DB_USERNANE = "db.username";
    public static final String DB_PASSWORD = "db.password";

    public static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    public static final String HIBERNATE_DLL_AUTO = "hibernate.hbm2ddl.auto";

    public static final String RESOLVER_PREFIX = "/WEB-INF/jsp/";
    public static final String RESOLVER_SUFFIX = ".jsp";
    public static final String MESSAGE_BASENAME = "localization/localization";
    public static final String MESSAGE_ENCODING = "UTF-8";
    public static final String INTERCEPTOR_NAME = "local";

    private ConfigAttr() {}
}
