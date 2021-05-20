package org.example.jd2p2v2.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
@RequestMapping(ControllerMapping.ADVICE_BASE)
public class ControllerException {

    @RequestMapping(ControllerMapping.ADVICE_ERROR)
    public ModelAndView noHandlerMappingFound() {
        return new ModelAndView(ControllerPage.PAGE_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException() {
        return new ModelAndView(ControllerPage.PAGE_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ModelAndView handleConstraintViolationException(Exception e) {
        String message = e.getMessage();

        if (message.contains(ControllerAttr.LOGINATION_INFO_ERROR)) {
            return new ModelAndView(
                    ControllerRedirect.SHOW_REDIRECT_LOGINATION_PAGE);
        } else if (message.contains(ControllerAttr.REGISTRATION_INFO_ERROR)) {
            return new ModelAndView(
                    ControllerRedirect.SHOW_REDIRECT_REGISTRATION_PAGE);
        } else {
            return new ModelAndView(ControllerRedirect.SHOW_ERROR_PAGE);
        }
    }
}
