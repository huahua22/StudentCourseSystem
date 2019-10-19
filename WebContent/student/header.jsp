<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/cite_css_js.jsp" />
</head>
<body>
	<header class="ydc-header">
	<div class="ydc-entered">
		<div class="ydc-header-content ydc-flex">
			<h1>学生教务系统</h1>
			<div class="ydc-column">
				<div class="ydc-column-user">
					<div class="ydc-user-photo">
						<p>欢迎你，${student.student_name}</p>
					</div>
					<div class="ydc-user-info">
						<div class="ydc-user-info-func ydc-flex">
							<span class="ydc-mal"><i class="ydc-icon ydc-icon-mail fl i1"></i></span>
							<a href="<%=request.getContextPath()%>/login.jsp" target="parent">退出</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</header>
</body>
</html>
