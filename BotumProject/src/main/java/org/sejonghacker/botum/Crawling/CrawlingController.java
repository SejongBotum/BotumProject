package org.sejonghacker.botum.Crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.sejonghacker.botum.session.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import netscape.javascript.JSObject;

@Controller
public class CrawlingController {
	
	@RequestMapping(value = "courses-list.do")
	public String showScripts(Model model, HttpSession session) throws IOException {
		String bbPath = "https://blackboard.sejong.ac.kr/";
		
		// 블랙보드 페이지 접속
		Connection.Response loginPageResponse = Jsoup.connect(bbPath)
													 .timeout(3000)
													 .header("Origin", "https://blackboard.sejong.ac.kr")
		                                             .header("Referer", "https://blackboard.sejong.ac.kr/")
		                                             .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
		                                             .header("Content-Type", "application/x-www-form-urlencoded")
		                                             .header("Accept-Encoding", "gzip, deflate, br")
		                                             .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
		                                             .method(Connection.Method.GET)
		                                             .execute();
		
		// 블랙보드 페이지에서 얻은 쿠키
		Map<String, String> loginTryCookie = loginPageResponse.cookies();
		
		// 페이지에서 로그인에 함께 전송하는 토큰 얻어내기
		Document loginPageDocument = loginPageResponse.parse();

		String action = loginPageDocument.select("input.action").val();
		String newLoc = loginPageDocument.select("input.new_loc").val();
		
		// Window, Chrome의 User Agent.
		String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36";

		// 세션에 유지되고 있는 정보(다시 로그인 하기 위함)
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		if(mvo == null) {
			System.out.println("세션에 로그인 정보 없음");
		}
		String id = mvo.getId();
		String password = mvo.getPw();
		
		// 전송할 폼 데이터
		Map<String, String> data = new HashMap<>();
		data.put("user_id", id);
		data.put("password", password);
		data.put("redirectUrl", "https://blackboard.sejong.ac.kr/");
		// 페이지에서 얻은 토큰들
		data.put("action", action);
		data.put("new_loc", newLoc);

		// 로그인(POST)
		Connection.Response response = Jsoup.connect(bbPath)
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
		
		Map<String, String> loginCookie = response.cookies();
		
		// 페이지 파싱
		Document homePageDocument = Jsoup.connect(bbPath)
										 .userAgent(userAgent)
						                 .header("Origin", "https://blackboard.sejong.ac.kr")
						                 .header("Referer", "https://blackboard.sejong.ac.kr/")
						                 .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
						                 .header("Content-Type", "application/x-www-form-urlencoded")
						                 .header("Accept-Encoding", "gzip, deflate, br")
						                 .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
						                 .cookies(loginCookie)
						                 .get();
		
//		System.out.println(homePageDocument);
		
		Elements divs = homePageDocument.select("div.edit_controls");
		System.out.println(divs.size());
		Element div = divs.get(0);
//		System.out.println(div);
		Element a = div.getElementsByTag("a").get(0);
//		System.out.println(a);
		String lectListPath = a.attr("href");
//		System.out.println(lectListPath);
		
		Document listPageDoc = Jsoup.connect(bbPath + "/" + lectListPath)
									.userAgent(userAgent)
					                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
					                .header("Content-Type", "application/x-www-form-urlencoded")
					                .header("Accept-Encoding", "gzip, deflate, br")
					                .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
					                .cookies(loginCookie)
					                .get();
		
//		System.out.println(listPageDoc);
		
		Elements lects = listPageDoc.select("strong");
		
		List<Map<String, String>> list = new ArrayList<>();
		
		for (Element element : lects) {
			String[] lectVal = (element.text()).split(":");
			String lectNum = lectVal[0].trim();
			String lectName = lectVal[1].trim().replaceAll(" ", "");
			System.out.println(lectNum + " " + lectName);
			
			Map<String, String> jMap = new HashMap<String, String>();
			jMap.put("number", lectNum);
			jMap.put("name", lectName);
			list.add(jMap);
		}

		model.addAttribute("list", list);
		
		return "courses-list";
	}
}
