package org.sejonghacker.botum.voiceTracking;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VoiceController {

	@RequestMapping(value = "recode.do", method = RequestMethod.POST)
	public void recode(String msg, String fileName, String dir, Model m, HttpServletRequest req){
		String contextPath = req.getSession().getServletContext().getRealPath("/scripts/");
		Calendar calendear = Calendar.getInstance();
		Date date = calendear.getTime();
		if(msg.equals("/0")) {
			msg = "[system] 강의가 시작 되었습니다.<br>";
		}else if(msg.equals("/1")) {
			msg = "[system] 강의가 종료 되었습니다.<br>";
		}else {
			String today = (new SimpleDateFormat("HH:mm:ss").format(date));
			msg = "[" + today + "] " + msg;
			msg += "<br>";
		}
		VoiceFileRecoder vfr = new VoiceFileRecoder(contextPath, dir, fileName);
		vfr.recode(msg);
		
	}
	
	@RequestMapping(value ="showScripts.do")
	public String showScripts(String dir, String fileName, Model m, HttpServletRequest req){
		m.addAttribute("dir", dir);
		m.addAttribute("fileName", fileName);
		return "striptsUI";
	}
	
	@RequestMapping(value ="getScripts.do")
	@ResponseBody
	public JSONObject getScripts(String dir, String fileName, HttpServletRequest req) {
		String contextPath = req.getSession().getServletContext().getRealPath("/scripts/");
		String res = "";
		VoiceFileRecoder vfr = new VoiceFileRecoder(contextPath, fileName, dir);
		res = vfr.read(dir, fileName);
		Map<String, String> jMap = new HashMap<String, String>();
		jMap.put("content", res);
		JSONObject jsonObject = new JSONObject(jMap);
		return jsonObject;
	}
}
