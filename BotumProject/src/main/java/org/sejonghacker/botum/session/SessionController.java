package org.sejonghacker.botum.session;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SessionController {
	
	@Resource
	private SessionService sessionService;
	
	@RequestMapping(value="login.do", method = RequestMethod.POST)
	public String login(String id, String password, HttpSession session) throws IOException {
		// 블랙보드 페이지 접속
		Connection.Response loginPageResponse = Jsoup.connect("https://blackboard.sejong.ac.kr/")
													 .timeout(3000)
													 .header("Origin", "https://blackboard.sejong.ac.kr")
		                                             .header("Referer", "https://blackboard.sejong.ac.kr/")
		                                             .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
		                                             .header("Content-Type", "application/x-www-form-urlencoded")
		                                             .header("Accept-Encoding", "gzip, deflate, br")
		                                             .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
		                                             .method(Connection.Method.GET)
		                                             .execute();
		                                             
		System.out.println("페이지접속");
		
		// 블랙보드 페이지에서 얻은 쿠키
		Map<String, String> loginTryCookie = loginPageResponse.cookies();
		
		// 페이지에서 로그인에 함께 전송하는 토큰 얻어내기
		Document loginPageDocument = loginPageResponse.parse();

		String action = loginPageDocument.select("input.action").val();
		String newLoc = loginPageDocument.select("input.new_loc").val();
		
		// Window, Chrome의 User Agent.
		String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36";

		// 전송할 폼 데이터
		Map<String, String> data = new HashMap<>();
		data.put("user_id", id);
		data.put("password", password);
		data.put("redirectUrl", "https://blackboard.sejong.ac.kr/");
		// 페이지에서 얻은 토큰들
		data.put("action", action);
		data.put("new_loc", newLoc);

		// 로그인(POST)
		Connection.Response response = Jsoup.connect("https://blackboard.sejong.ac.kr/")
		                                    .userAgent(userAgent)
		                                    .timeout(3000)
		                                    .header("Origin", "https://blackboard.sejong.ac.kr")
                                            .header("Referer", "https://blackboard.sejong.ac.kr/")
                                            .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                                            .header("Content-Type", "application/x-www-form-urlencoded")
                                            .header("Accept-Encoding", "gzip, deflate, br")
                                            .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
		                                    .cookies(loginTryCookie)
		                                    .data(data)
		                                    .method(Connection.Method.POST)
		                                    .execute();

		System.out.println("로그인");
		
		// 로그인 성공 후 얻은 쿠키
		Map<String, String> loginCookie = response.cookies();
		
		System.out.println(loginCookie.size());
		
		if(loginCookie.size() > 0) {
			System.out.println("로그인 성공");
			
			MemberVO mvo = new MemberVO();
			mvo.setId(id);
			mvo.setPw(password);
			
			session.setAttribute("mvo", mvo);
		} else {
			System.out.println("로그인 실패?");
		}
		
//		session.setAttribute("mvo", mvo);
		return "redirect:home.do";
	}
	
	@RequestMapping(value="register.do", method = RequestMethod.POST)
	public String register(MemberVO mvo) {
		return (sessionService.register(mvo))? "index" : "index";
	}
}
