<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/login/css/style.css"
	rel='stylesheet' type='text/css' />
<title>学生教务系统</title>
<!-- 登录失效，跳出frame框架 -->
<script type="text/javascript">
	if (window != top)
		top.location.href = location.href;
</script>

</head>
<body>
	<div class="main">
		<div class="login-form">
			<h1>学生教务系统</h1>
			<div class="head">
				<img src="<%=request.getContextPath()%>/login/img/user.png" />
			</div>
			<form action="loginServlet" method="post">
				<input type="text" name="account" placeholder="学号/工号" /> <input
					type="password" name="password" placeholder="密码" />
				<div class="radio">
					<input id="1" type="radio" checked name="role" value="1"> <label
						for="1"></label> <span>学生</span> <input id="2" type="radio"
						name="role" value="2" /> <label for="2"></label> <span>教师</span>
					<input id="3" type="radio" name="role" value="3" /> <label for="3"></label>
					<span>管理员</span>
				</div>
				<div class="submit">
					<input type="submit" value="登录">
				</div>

			</form>
			<div
				style="margin-bottom: 10px; color: red; font-size: 14px; text-align: center; margin-top: -20px;">${message}
			</div>
		</div>
	</div>

</body>
</html>