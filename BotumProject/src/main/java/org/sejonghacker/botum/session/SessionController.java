package org.sejonghacker.botum.session;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SessionController {
	
	@Resource
	private SessionService sessionService;
	
	@RequestMapping(value="login.do", method = RequestMethod.POST)
	public String login(String id, String pw, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO mvo = sessionService.login(id, pw);
		session.setAttribute("mvo", mvo);
		return "index";
	}
	
	@RequestMapping(value="register.do", method = RequestMethod.POST)
	public String register(MemberVO mvo) {
		return (sessionService.register(mvo))? "index" : "index";
	}
}
