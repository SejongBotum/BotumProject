package org.sejonghacker.botum.fileSystem;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileUploadController {
	private String uploadPath;
	@RequestMapping(value = "uploadForm.do")
	public String uploadPage(HttpServletRequest req, String imgStr) {
		return "form-uploads";
	}
	
	@RequestMapping(value = "uploadFile.do", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public String uploadFle(@RequestParam("file") MultipartFile file) {
/*		uploadPath = request.getSession().getServletContext().getRealPath("/scripts/");
		String test = request.getParameter("test");
		MultipartFile file = request.getFile("file");*/
		System.out.println(file);
		return "redirect:home.do";
	}
/*
	@RequestMapping(value = "uploadFile.do", method = RequestMethod.GET)
	public String uploadFile(HttpServletRequest req) {
		uploadRepository = req.getSession().getServletContext().getRealPath("/scripts/");
//		MultipartRequest m = new 
		try {
			MultipartRequest m = new MultipartRequest(req, contextPath, 1024*1024*5, "UTF-8");
			System.out.println(m.getOriginalFileName("file"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "courses-list";
	}*/

	public void setMethodNameResolver(Object arg0) {
		
	}
}
