package org.example.jd2p2v2.controller;

public final class ControllerRedirect {
    public static final String REDIRECT = "redirect:";

    public static final String SHOW_ERROR_PAGE = REDIRECT
            + ControllerMapping.BASE + ControllerMapping.SHOW_ERROR_PAGE;
    public static final String SHOW_REDIRECT_REGISTRATION_PAGE = REDIRECT
            + ControllerMapping.BASE
            + ControllerMapping.SHOW_REDIRECT_REGISTRATION_PAGE;
    public static final String SHOW_REDIRECT_LOGINATION_PAGE = REDIRECT
            + ControllerMapping.BASE
            + ControllerMapping.SHOW_REDIRECT_LOGINATION_PAGE;
    public static final String SHOW_MAIN_PAGE = REDIRECT
            + ControllerMapping.BASE + ControllerMapping.SHOW_MAIN_PAGE;
    public static final String SHOW_INDEX_PAGE = REDIRECT
            + ControllerMapping.BASE + ControllerMapping.SHOW_INDEX_PAGE;
    public static final String SHOW_EDIT_PAGE = REDIRECT
            + ControllerMapping.BASE + ControllerMapping.SHOW_EDIT_PAGE;
    public static final String SHOW_NEWS_PAGE = REDIRECT
            + ControllerMapping.BASE + ControllerMapping.SHOW_NEWS_PAGE;

    private ControllerRedirect() {}
}
