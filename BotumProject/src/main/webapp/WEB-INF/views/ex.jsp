<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*,com.oreilly.servlet.*,com.oreilly.servlet.multipart.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <% request.setCharacterEncoding("utf-8"); %>  --%>

<html>
<head><title>upload test</title></head>
<body>
<h3>파일 upload</h3>




<%-- 

<%  
        String dir=application.getRealPath("/scripts/");
        int max= 5*1024*1024;

        //최대크기 max바이트, dir 디렉토리에 파일을 업로드하는 MultipartRequest
        //객체를 생성한다.
        MultipartRequest m = new MultipartRequest(request,dir,max,"UTF-8",
                                               new  DefaultFileRenamePolicy());
%>

<c:set var="file1" value='<%= m.getFilesystemName("file1")%>' />   // 파일이름을 file1 이라는 파라메터로 넘겨받음
<c:set var="ofile1" value='<%= m.getOriginalFileName("file1") %>' />


<p>
<ul>
	<li>제목: ${subject}<br></li>
	<li>업로드파일1: <a href=/scripts/${file1}>${ofile1}</a><br></li>
</ul> --%>
</body>
</html>