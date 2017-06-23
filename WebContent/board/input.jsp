<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Q&A 작성하기</h2>
<form name='frm_board' method='post' enctype="multipart/form-data">
	<label>작성자</label>
	<input type='text' name='worker'/><br/>
	<label>제목</label>
	<input type='text' name='subject'>
	<p/>
	<input type='button' id='btninputR' value='저장하기'>
	<input type='button' id='btnlist' value='목록으로'>
</form>


</body>
</html>