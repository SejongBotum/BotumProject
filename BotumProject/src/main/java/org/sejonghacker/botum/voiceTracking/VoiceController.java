package org.sejonghacker.botum.voiceTracking;

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
		//System.out.println("Source : " + msg + "name : " + fileName + "number : " + dir);
		if(msg.equals("/0") || msg.equals("/1")) return;
		msg += "<br>";
		System.out.println(contextPath + fileName + dir);
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
		System.out.println(dir + "  " + fileName);
		VoiceFileRecoder vfr = new VoiceFileRecoder(contextPath, fileName, dir);
		res = vfr.read(dir, fileName);
		System.out.println(res);
		Map<String, String> jMap = new HashMap<String, String>();
		jMap.put("content", res);
		JSONObject jsonObject = new JSONObject(jMap);
		System.out.println("obj : " + jsonObject.toString());
		return jsonObject;
	}
}
