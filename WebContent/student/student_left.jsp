<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/cite_css_js.jsp" />
</head>
<body>
<section>
	<div class="ydc-content-slide ydc-body" style="margin-top: 30px;">
		<div class="ydc-flex">
			<div class="ydc-column">
				<div class="ydc-menu">
					<ul>
						<li class="ydc-menu-item"><a href="http://localhost:8080/StudentCourseSystem/showStudentDetailServlet" class="active"
							 target="main"><i
								class="ydc-icon ydc-icon-home fl"></i>个人主页</a></li>

						<li class="ydc-menu-item"><span class="ydc-menu-sub-title">
								<i class="ydc-icon ydc-icon-file fl"></i>学籍信息
						</span>
							<ul>
							<li><a
									href="student_course.jsp"
									target="main" >我的课程</a></li>
								<li><a
									href="student_score.jsp"
									target="main" >查看成绩</a></li>
								<li><a href="<%=request.getContextPath() %>/student/student_choose.jsp" target="main">选课中心</a></li>
							
							<li><a href="<%=request.getContextPath() %>/studentInforServlet" target="main">我的班级</a></li>
							
							</ul>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</section>

	<script type="text/javascript">
		var slideIndex = 0;
		showSlides();

		function showSlides() {
			var i;
			var slides = document.getElementsByClassName("mySlides");
			for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";
			}
			slideIndex++;
			if (slideIndex > slides.length) {
				slideIndex = 1
			}
			slides[slideIndex - 1].style.display = "block";
			setTimeout(showSlides, 3000); // 滚动时间
		}
	</script>

	<script type="text/javascript">
		$(function() {
			$('.ydc-tabPanel ul li').click(
					function() {
						$(this).addClass('hit').siblings().removeClass('hit');
						$('.ydc-panes>div:eq(' + $(this).index() + ')').show()
								.siblings().hide();
					})
		})
	</script>
	<script type="text/javascript">
		$('a').click(function() {
			$('.active').removeClass();
			$(this).addClass("active");
		})
	</script>
</body>
</html>