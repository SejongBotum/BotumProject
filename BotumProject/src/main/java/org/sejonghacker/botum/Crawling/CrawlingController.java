package org.sejonghacker.botum.Crawling;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CrawlingController {
	
	@RequestMapping(value = "crawl.do")
	public String showScripts(Model model, HttpServletRequest req) throws IOException {

		// 페이지 접속
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
		
		// 페이지에서 얻은 쿠키
		Map<String, String> loginTryCookie = loginPageResponse.cookies();
		
		// 페이지에서 로그인에 함께 전송하는 토큰 얻어내기
		Document loginPageDocument = loginPageResponse.parse();

		String action = loginPageDocument.select("input.action").val();
		String newLoc = loginPageDocument.select("input.new_loc").val();
		
		System.out.println("토큰 확인 : " + action + " " + newLoc);
		
		// Window, Chrome의 User Agent.
		String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36";

		// 전송할 폼 데이터
		Map<String, String> data = new HashMap<>();
		data.put("user_id", "13011050");
		data.put("password", "rla1593");
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
		} else {
			System.out.println("로그인 실패?");
		}
		
		
		
//		
//		// 로그인 후 페이지(홈)
//		Document homePageDocument = Jsoup.connect("https://blackboard.sejong.ac.kr/")
//		                            .userAgent(userAgent)
//		                            .header("Referer", "https://blackboard.sejong.ac.kr/")
//                                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
//                                    .header("Content-Type", "application/x-www-form-urlencoded")
//                                    .header("Accept-Encoding", "gzip, deflate, br")
//                                    .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
//		                            .cookies(loginCookie) // 위에서 얻은 '로그인 된' 쿠키
//		                            .get();
//		
//		System.out.println(homePageDocument.html());
//		// 나의 코스에 있는 강의 목록
//		Elements lecList = homePageDocument.select("div"); //.select("li").select("a")
//		System.out.println(lecList.size());
//		
//		// 강의 이름 가져오기
//		for(Element lec : lecList) {
//		  String lecName = lec.text();
//		  
//		  System.out.println(lecName);
//		}
//		
		return "crawl";
	}
}
