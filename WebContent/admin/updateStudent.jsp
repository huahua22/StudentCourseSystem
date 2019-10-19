<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>updateStudent</title>
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
								<li class="hit">修改学生信息</li>
							</ul>
						</div>
						<div class="x-body" style="margin-left: 100px">
							<form class="layui-form" name="form" method="post">
								<div class="layui-form-item">
									<label for="L_email" class="layui-form-label"> <span
										class="x-red">*</span>学号
									</label>
									<div class="layui-input-inline">
										<input type="text" name="studentNo" class="layui-input"
											readonly="readonly" value="${student.student_no }">
									</div>
									<div class="layui-form-mid layui-word-aux"><span
										class="x-red">*</span>不可修改</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label"> <span class="x-red">*</span>姓名
									</label>
									<div class="layui-input-inline">
										<input type="text" id="L_pass" name="studentName"
											class="layui-input" value="${student.student_name }">
									</div>
								</div>
								<div class="layui-form-item">
									<label for="L_repass" class="layui-form-label"> <span
										class="x-red">*</span>手机号
									</label>
									<div class="layui-input-inline">
										<input type="text" id="L_repass" name="studentContact"
											class="layui-input" value="${student.student_contact}">
									</div>
								</div>
								<div class="layui-form-item">
									<label for="L_username" class="layui-form-label"> <span
										class="x-red">*</span>系属
									</label>
									<div class="layui-input-inline">
										<input type="text" id="username" name="depart_name"
											class="layui-input" value="${student.classes.depart_name }">
									</div>
								</div>
								<div class="layui-form-item">
									<label for="L_username" class="layui-form-label"> <span
										class="x-red">*</span>班级
									</label>
									<div class="layui-input-inline">
										<input type="text" id="L_username" name="className"
											class="layui-input" value="${student.classes.class_name }">
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
		function update() {//提交修改
			document.form.action = "updateStudentServlet";
			document.form.submit();
		}
		function cancel() {//取消修改
			document.form.action = "studentListServlet";
			document.form.submit();
		}
	</script>


</body>
</html>