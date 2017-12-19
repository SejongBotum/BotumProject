package org.sejonghacker.botum.fileSystem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam("dir") String dir,
			HttpSession session) {
		uploadPath = session.getServletContext().getRealPath("/scripts/");
		
		System.out.println(dir + uploadPath + " " + file.getOriginalFilename());
		return "redirect:home.do";
	}


	public void setMethodNameResolver(Object arg0) {
		
	}
}
