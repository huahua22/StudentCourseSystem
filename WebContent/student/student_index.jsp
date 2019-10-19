<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>学生教务系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name='TTUNION_verify' content='b846c3c2b85efabc496d2a2b8399cd62'>
<meta name="sogou_site_verification" content="gI1bINaJcL" />
<meta name="360-site-verification"
	content="37ae9186443cc6e270d8a52943cd3c5a" />
<meta name="baidu_union_verify"
	content="99203948fbfbb64534dbe0f030cbe817">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="X-UA-Compatible"
	content="IE=9; IE=8; IE=7; IE=EDGE;chrome=1">
<meta name="format-detection" content="telephone=no" />
<meta name="baidu-site-verification" content="ZVPGgtpUfW" />
</head>

<frameset frameborder="0" rows="80,*">
	<frame src="<%=request.getContextPath()%>/student/header.jsp" noresize="noresize" scrolling="no" />
	<frameset frameborder="0" cols="20%,80%">
		<frame src="<%=request.getContextPath()%>/student/student_left.jsp" noresize="noresize" scrolling="no" />
		<frame scrolling="yes" name="main" />
	</frameset>
</frameset>
</html>