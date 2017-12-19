package org.sejonghacker.botum.fileSystem;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oreilly.servlet.MultipartRequest;


@Controller
public class FileUploadController {
	
	@RequestMapping(value = "uploadForm.do")
	public String uploadPage(HttpServletRequest req, String imgStr) {
		return "form-uploads";
	}
	
	@RequestMapping(value = "uploadFile.do", method = RequestMethod.GET)
	public String uploadFile(HttpServletRequest req) {
		String contextPath = req.getSession().getServletContext().getRealPath("/scripts/");
//		MultipartRequest m = new 
/*		try {
			MultipartRequest m = new MultipartRequest(req, contextPath, 1024*1024*5, "UTF-8");
			System.out.println(m.getOriginalFileName("file"));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return "courses-list";
	}
}
