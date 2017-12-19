package org.sejonghacker.botum;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sejonghacker.botum.session.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 2017.12.19. 세종대학교 해커톤 프로젝트
 * Team Botum
 *
 * @author siotMan
 */
@Controller
public class IndexController {
	@Resource
	private TestService testService;
	//private static final Logger logger = LoggerFactorynul.getLogger(IndexController.class);
	
	/**
	 * 
	 * @return 메인 인덱스 페이지
	 */
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home(Model m, HttpSession session) {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		
		//MemberVO mvo = new MemberVO("13011085", "1031", "김승신", 0);
		return (mvo == null)? "redirect:loginForm.do" : "redirect:courses-list.do";
	}
	
	@RequestMapping(value = "loginForm.do")
	public String loginForm() {
		return "login";
	}
	
}
