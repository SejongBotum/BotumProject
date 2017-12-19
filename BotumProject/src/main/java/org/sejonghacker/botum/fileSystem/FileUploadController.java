package org.sejonghacker.botum.fileSystem;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FileUploadController {
	
	@RequestMapping(value = "uploadForm.do")
	public String uploadPage(HttpServletRequest req, String imgStr) {
		String contextPath = req.getSession().getServletContext().getRealPath("/scripts/");
		return "form-uploads";
	}
}
