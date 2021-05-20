package org.example.jd2p2v2.controller;

public final class ControllerMapping {
    public static final String BASE = "/command";

    public static final String SHOW_INDEX_PAGE = "/showIndexPage";
    public static final String SHOW_MAIN_PAGE = "/showMainPage";
    public static final String SHOW_REGISTRATION_PAGE =
            "/showRegistrationPage";
    public static final String SHOW_ERROR_PAGE = "/showErrorPage";
    public static final String SHOW_NEWS_PAGE = "/showNewsPage";
    public static final String SHOW_EDIT_PAGE = "/showEditPage";
    public static final String SHOW_REDIRECT_REGISTRATION_PAGE =
            "/showRedirectRegistrationPage";
    public static final String SHOW_REDIRECT_LOGINATION_PAGE =
            "/showRedirectLoginationPage";

    public static final String REGISTRATION = "/registration";
    public static final String LOGINATION = "/logination";
    public static final String LOGOUT = "/logout";
    public static final String DELETE_NEWS = "/deleteNews";
    public static final String EDIT_NEWS = "/editNews";

    public static final String ADVICE_BASE = "/*";
    public static final String ADVICE_ERROR = "/**";

    private ControllerMapping() {}
}
