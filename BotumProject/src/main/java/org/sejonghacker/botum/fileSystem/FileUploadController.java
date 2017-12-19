package org.sejonghacker.botum.fileSystem;

import java.io.File;
import java.io.IOException;

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
		String regfix = "\\";
//		String regfix = "/";
		uploadPath = session.getServletContext().getRealPath("/scripts/");
		File f = new File(uploadPath + regfix + dir);
		if(!f.exists()) f.mkdirs();
		f = new File(uploadPath + regfix + dir + regfix + "material.pdf");
		System.out.println(file.getOriginalFilename());
		try {
			file.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:home.do";
	}
}
