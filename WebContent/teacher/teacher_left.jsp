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
						<li class="ydc-menu-item"><a href="person_center.jsp" class="active"
							 target="main"><i
								class="ydc-icon ydc-icon-home fl"></i>个人主页</a></li>

						<li class="ydc-menu-item"><span class="ydc-menu-sub-title">
								<i class="ydc-icon ydc-icon-file fl"></i>我的管理
						</span>
							<ul>
								<li><a
									href="teacher_course.jsp"
									target="main" >课程安排</a></li>
								<li><a href="student_infor.jsp" target="main">班级信息</a></li>
								<li><a href="teacher_student_score.jsp" target="main">学生成绩</a></li>
								<li><a href="teacher_student.jsp" target="main">录入成绩</a></li>
							</ul>
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
	</script>
	<script type="text/javascript">
		$('a').click(function() {
			$('.active').removeClass();
			$(this).addClass("active");
		})
	</script>
</body>
</html>