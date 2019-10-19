<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生教务系统</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/newwindow/css/x-admin.css"
	media="all">
<jsp:include page="/cite_css_js.jsp" />
</head>

<body>
	<div class="ydc-content-slide ydc-body" style="margin-top: 20px;">
		<div class="ydc-flex">

			<!-- right begin -->
			<div class="ydc-column">
				<div class="ydc-release-content">
					<div class="ydc-tabPanel ydc-tabPanel-release">
						<!-- the title  -->
						<div class="ydc-release-tab-head">
							<ul>
								<li class="hit">录入成绩</li>
							</ul>
						</div>
						<div class="x-body" style="margin-left: 100px">
						
							<form class="layui-form" name="form" method="post">
								<div class="layui-form-item">
									<label for="L_email" class="layui-form-label"> 学号 </label>
									<div class="layui-input-inline">
										<input type="text" class="layui-input" name="studentNo"
											readonly="readonly" value="${choose.student_no }">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">姓名 </label>
									<div class="layui-input-inline">
										<input type="text" id="L_pass" readonly="readonly"
											class="layui-input" value="${choose.student_name }">
									</div>
								</div>
								<div class="layui-form-item">
									<label for="L_repass" class="layui-form-label">班级 </label>
									<div class="layui-input-inline">
										<input type="text" id="L_repass" readonly="readonly"
											class="layui-input" value="${choose.class_name}">
									</div>
								</div>
								<div class="layui-form-item">
									<label for="L_repass" class="layui-form-label">课程 </label>
									<div class="layui-input-inline">
										<input type="text" id="L_repass" readonly="readonly"
											name="courseName" class="layui-input"
											value="${choose.course_name}">
									</div>
								</div>
								<div class="layui-form-item">
									<label for="L_repass" class="layui-form-label">成绩 </label>
									<div class="layui-input-inline">
										<input type="text" id="L_repass" name="studentScore"
											class="layui-input" placeholder="请录入成绩">
											<div style="color:red;">${message }</div>
									</div>
								</div>
								<div class="layui-form-item">
									<label for="L_repass" class="layui-form-label"> </label>
									<button class="layui-btn" style="background-color: #ff5454;"
										onclick="update()">保存</button>
									<button class="layui-btn" style="background-color: #ff5454;"
										onclick="cancel()">取消</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		function update() {//提交
			document.form.action = "addStudentScoreServlet";
			document.form.submit();
		}
		function cancel() {//取消
			document.form.action = "teacher/teacher_student.jsp";
			document.form.submit();
		}
	</script>


</body>
</html>