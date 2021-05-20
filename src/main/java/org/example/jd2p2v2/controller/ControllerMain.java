package org.example.jd2p2v2.controller;

import org.example.jd2p2v2.bean.LoginationInfo;
import org.example.jd2p2v2.bean.RegistrationInfo;
import org.example.jd2p2v2.entity.User;
import org.example.jd2p2v2.service.INewsService;
import org.example.jd2p2v2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Controller
@Validated
@RequestMapping(ControllerMapping.BASE)
public class ControllerMain {
    private final LoginationInfo loginationInfo;

    private final RegistrationInfo registrationInfo;

    private final INewsService newsService;

	private final IUserService userService;

	@Autowired
	public ControllerMain(LoginationInfo loginationInfo,
						  RegistrationInfo registrationInfo,
						  INewsService newsService,
						  IUserService userService) {
		this.loginationInfo = loginationInfo;
		this.registrationInfo = registrationInfo;
		this.newsService = newsService;
		this.userService = userService;
	}

	@RequestMapping(ControllerMapping.SHOW_INDEX_PAGE)
	public String showIndexPage(Model model) {
		model.addAttribute(ControllerAttr.LOGINATION_INFO, loginationInfo);
		model.addAttribute(ControllerAttr.NEWS, newsService.getAll());

		return ControllerPage.PAGE_INDEX;
	}

    @RequestMapping(ControllerMapping.SHOW_REGISTRATION_PAGE)
    public String showRegistrationPage(@NotNull HttpSession session, Model model) {
		model.addAttribute(ControllerAttr.REGISTRATION_INFO, registrationInfo);

		return ControllerPage.PAGE_REGISTRATION;
    }

	@RequestMapping(ControllerMapping.LOGINATION)
	public String logination(
			@NotNull HttpSession session,
			@Valid @ModelAttribute(ControllerAttr.LOGINATION_INFO) LoginationInfo loginationInfo,
			BindingResult bindingResult) {
		User user = userService.logination(loginationInfo);

		if (user == null) {
			return ControllerRedirect.SHOW_REDIRECT_LOGINATION_PAGE;
		}

		session.setAttribute(ControllerAttr.AUTH, true);
		session.setAttribute(ControllerAttr.USERNAME, user.getLogin());
		session.setAttribute(ControllerAttr.ROLE, user.getRole());

		return ControllerRedirect.SHOW_MAIN_PAGE;
	}

    @RequestMapping(ControllerMapping.REGISTRATION)
    public String registration(
            @NotNull HttpSession session,
			@Valid @ModelAttribute(ControllerAttr.REGISTRATION_INFO) RegistrationInfo registrationInfo,
            BindingResult bindingResult) {
		registrationInfo.setRole(ControllerAttr.ROLE_USER);
		registrationInfo.setStatus(ControllerAttr.STATUS_ACTIVE);

		User user = userService.registration(registrationInfo);

		if (user == null) {
			return ControllerRedirect.SHOW_REDIRECT_REGISTRATION_PAGE;
		}

		session.setAttribute(ControllerAttr.AUTH, true);
		session.setAttribute(ControllerAttr.USERNAME, user.getLogin());
		session.setAttribute(ControllerAttr.ROLE, user.getRole());

		return ControllerRedirect.SHOW_MAIN_PAGE;
	}

	@RequestMapping(ControllerMapping.LOGOUT)
	public String logout(@NotNull HttpSession session) {

		session.removeAttribute(ControllerAttr.AUTH);
		session.removeAttribute(ControllerAttr.USERNAME);
		session.removeAttribute(ControllerAttr.ROLE);

		return ControllerRedirect.SHOW_INDEX_PAGE;
	}

	@RequestMapping(ControllerMapping.SHOW_MAIN_PAGE)
	public String showMainPage(@NotNull HttpSession session,
							   @NotNull @AssertTrue @SessionAttribute(ControllerAttr.AUTH) boolean auth,
							   @NotNull @SessionAttribute(ControllerAttr.USERNAME) String username,
							   @NotNull @SessionAttribute(ControllerAttr.ROLE) String role,
							   Model model) {
		model.addAttribute(ControllerAttr.USERNAME, session.getAttribute(ControllerAttr.USERNAME));
		model.addAttribute(ControllerAttr.ROLE, session.getAttribute(ControllerAttr.ROLE));
		model.addAttribute(ControllerAttr.NEWS, newsService.getAll());

		return ControllerPage.PAGE_MAIN;
	}

	@RequestMapping(ControllerMapping.SHOW_ERROR_PAGE)
	public String showErrorPage() {
		return ControllerPage.PAGE_ERROR;
	}

    @RequestMapping(ControllerMapping.SHOW_REDIRECT_LOGINATION_PAGE)
    public String showRedirectLoginationPage() {
        return ControllerPage.PAGE_REDIRECT_LOGINATION;
    }

    @RequestMapping(ControllerMapping.SHOW_REDIRECT_REGISTRATION_PAGE)
    public String showRedirectRegistrationPage() {
        return ControllerPage.PAGE_REDIRECT_REGISTRATION;
    }

	@RequestMapping(ControllerMapping.SHOW_NEWS_PAGE)
	public String showNewsPage(@NotNull HttpSession session,
							   @NotNull @AssertTrue @SessionAttribute(ControllerAttr.AUTH) boolean auth,
							   @NotNull @SessionAttribute(ControllerAttr.USERNAME) String username,
							   @NotNull @SessionAttribute(ControllerAttr.ROLE) String role,
							   @NotNull @RequestParam(ControllerAttr.ID) int id,
							   @NotNull @RequestParam(ControllerAttr.EDITED) boolean edited,
							   Model model) {
		model.addAttribute(ControllerAttr.USERNAME, session.getAttribute(ControllerAttr.USERNAME));
		model.addAttribute(ControllerAttr.ROLE, session.getAttribute(ControllerAttr.ROLE));
		model.addAttribute(ControllerAttr.ID, id);
		model.addAttribute(ControllerAttr.EDITED, edited);
		model.addAttribute(ControllerAttr.NEWS, newsService.getById(id));

		return ControllerPage.PAGE_NEWS;
	}

	@RequestMapping(ControllerMapping.SHOW_EDIT_PAGE)
	public String showEditPage(@NotNull HttpSession session,
							   @NotNull @AssertTrue @SessionAttribute(ControllerAttr.AUTH) boolean auth,
							   @NotNull @SessionAttribute(ControllerAttr.USERNAME) String username,
							   @NotNull @Pattern(regexp = ControllerAttr.ROLE_ADMIN)
								   @SessionAttribute(ControllerAttr.ROLE) String role,
							   @NotNull @RequestParam(ControllerAttr.ID) int id,
							   Model model) {
		model.addAttribute(ControllerAttr.USERNAME, session.getAttribute(ControllerAttr.USERNAME));
		model.addAttribute(ControllerAttr.ROLE, session.getAttribute(ControllerAttr.ROLE));
		model.addAttribute(ControllerAttr.ID, id);
		model.addAttribute(ControllerAttr.NEWS, newsService.getById(id));

		return ControllerPage.PAGE_EDIT;
	}

	@RequestMapping(ControllerMapping.DELETE_NEWS)
	public String deleteNews(@NotNull HttpSession session,
							 @NotNull @AssertTrue @SessionAttribute(ControllerAttr.AUTH) boolean auth,
							 @NotNull @Pattern(regexp = ControllerAttr.ROLE_ADMIN)
								 @SessionAttribute(ControllerAttr.ROLE) String role,
							 @NotNull @RequestParam(ControllerAttr.ID) int id) {
		newsService.deleteById(id);

		return ControllerRedirect.SHOW_MAIN_PAGE;
	}

	@RequestMapping(ControllerMapping.EDIT_NEWS)
	public String editNews(@NotNull HttpSession session,
						   @NotNull @AssertTrue @SessionAttribute(ControllerAttr.AUTH) boolean auth,
						   @NotNull @Pattern(regexp = ControllerAttr.ROLE_ADMIN)
							   @SessionAttribute(ControllerAttr.ROLE) String role,
						   @NotNull @RequestParam(ControllerAttr.ID) int id,
						   @NotNull @RequestParam(ControllerAttr.TITLE) String title,
						   @NotNull @RequestParam(ControllerAttr.BRIEF) String brief,
						   @NotNull @RequestParam(ControllerAttr.CONTENT) String content,
						   RedirectAttributes redirectAttributes) {
		newsService.editById(id, title, brief, content);

		redirectAttributes.addAttribute(ControllerAttr.ID, id);
		redirectAttributes.addAttribute(ControllerAttr.EDITED, true);

		return ControllerRedirect.SHOW_NEWS_PAGE;
	}
}
