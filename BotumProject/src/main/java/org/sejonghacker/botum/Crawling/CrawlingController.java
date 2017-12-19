package org.sejonghacker.botum.Crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.sejonghacker.botum.session.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CrawlingController {
	
	@Resource
	private LectureDAO lectureDAO;  
	
	@RequestMapping(value = "courses-list.do")
	public String showScripts(Model model, HttpSession session) throws IOException {
		List<Map<String, String>> list = new ArrayList<>();
		MemberVO mvo = null;
		mvo = (MemberVO)session.getAttribute("mvo");
		if(mvo != null && mvo.getMember_id().charAt(0) == 'p') {
			ArrayList<Lecture> lectList = lectureDAO.getAllList(mvo.getMember_id());
			for (Lecture lecture : lectList) {
				HashMap<String, String> pMap = new HashMap<>();
				pMap.put("number", lecture.getDir_name()); 
				pMap.put("name", lecture.getLect_name());
				list.add(pMap);
			}
			
			model.addAttribute("list", list);
			return "courses-list";
		}
		
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
		mvo = (MemberVO) session.getAttribute("mvo");
		if(mvo == null) {
			System.out.println("세션에 로그인 정보 없음");
			return "courses-list";
		}
		String id = mvo.getMember_id();
		String password = mvo.getMember_pwd();
		
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
		
		// 로그인 후 홈 페이지 파싱
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
		
		Elements divs = homePageDocument.select("div.edit_controls");
		Element div = divs.get(0);
		Element a = div.getElementsByTag("a").get(0);
		String lectListPath = a.attr("href");
		
		// 강의목록 페이지로 이동 후 페이지 파싱
		Document listPageDoc = Jsoup.connect(bbPath + "/" + lectListPath)
									.userAgent(userAgent)
					                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
					                .header("Content-Type", "application/x-www-form-urlencoded")
					                .header("Accept-Encoding", "gzip, deflate, br")
					                .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
					                .cookies(loginCookie)
					                .get();
		
		
		Elements lects = listPageDoc.select("strong");
		
		// 학생 전체 수강 목록 데이터 전송

		for (Element element : lects) {
			String[] lectVal = (element.text()).split(":");
			String lectNum = lectVal[0].trim();
			String lectName = lectVal[1].trim().replaceAll(" ", "");
			
			Map<String, String> jMap = new HashMap<String, String>();
			jMap.put("number", lectNum);
			jMap.put("name", lectName);
			list.add(jMap);
		}
		model.addAttribute("list", list);
		
		return "courses-list";
	}
}
