<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	<form action="${pageContext.request.contextPath}/upload/goUpload.do" method="post" 
		enctype="multipart/form-data">
		<input type="file" id="file" name="file">
		<br><input type="submit" value="上传">
	</form>
</body>
</html>