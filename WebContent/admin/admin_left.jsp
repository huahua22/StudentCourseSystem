<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生教务系统</title>
<jsp:include page="/cite_css_js.jsp" />
</head>
<body>
<section>
	<div class="ydc-content-slide ydc-body" style="margin-top: 30px;">
		<div class="ydc-flex">
			<div class="ydc-column">
				<div class="ydc-menu">
					<ul>
						<li class="ydc-menu-item"><a href="person_center.jsp" class="active"
							 target="main"><i
								class="ydc-icon ydc-icon-home fl"></i>个人主页</a></li>

						<li class="ydc-menu-item"><span class="ydc-menu-sub-title">
								<i class="ydc-icon ydc-icon-file fl"></i>学生中心
						</span>
							<ul>
								<li><a
									href="<%=request.getContextPath()%>/studentListServlet"
									target="main" >学生管理</a></li>
								<li><a href="<%=request.getContextPath()%>/admin/class_manager.jsp" target="main">班级管理</a></li>
							</ul></li>
						<li class="ydc-menu-item"><span class="ydc-menu-sub-title">
								<i class="ydc-icon ydc-icon-record fl"></i>课程中心
						</span>
							<ul>
								<li><a href="<%=request.getContextPath()%>/admin/course_manager.jsp" target="main">课程管理</a></li>
								<li><a href="<%=request.getContextPath()%>/admin/choose_center.jsp" target="main">选课中心</a></li>
							</ul></li>
						<li class="ydc-menu-item"><span class="ydc-menu-sub-title">
								<i class="ydc-icon ydc-icon-set fl"></i>教师中心
						</span>
							<ul>
								<li><a href="<%=request.getContextPath()%>/teacherListServlet" target="main">教师管理</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</section>

	<script type="text/javascript">
		$(function() {
			$('.ydc-tabPanel ul li').click(
					function() {
						$(this).addClass('hit').siblings().removeClass('hit');
						$('.ydc-panes>div:eq(' + $(this).index() + ')').show()
								.siblings().hide();
					})
		})
	</script>s
	<script type="text/javascript">
		$('a').click(function() {
			$('.active').removeClass();
			$(this).addClass("active");
		})
	</script>
</body>
</html>