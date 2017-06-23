<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name='viewport' content='width=deive-width, user-scalable=no'>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/board-pc.css" media='screen and (min-width:900px)'/>
<link rel="stylesheet" type="text/css" href="./css/board-mobile.css" media='screen and (max-width:900px)'/>
<%
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");
%>

<script src="js/board.js"></script>

</head>
<body>
<%
String inc = "./board/list.jsp";
if(request.getParameter("inc") != null) {
   inc = request.getParameter("inc");
}
%>  

   <div id='main'>
      <div id='top'>
         <%@include file="top.jsp"%>
      </div>
      
      <div id='center'>
         <jsp:include page="<%=inc %>"/>
      </div>
      
      <div id='bottom'>
         <%@include file="bottom.jsp"%>
      </div>


   </div>
   <script>init();</script>
</body>
</html>