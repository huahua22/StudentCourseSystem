<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生教务系统</title>
<jsp:include page="/cite_css_js.jsp" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/admin/js/jquery.min.js"></script>
</head>
<body>
	<div class="ydc-content-slide ydc-body" style="margin-top: 20px;">
		<div class="ydc-flex">
			<div class="ydc-column">
				<div class="ydc-release-content">
					<div class="ydc-tabPanel ydc-tabPanel-release">
						<div class="ydc-release-tab-head">
							<ul>
								<li class="hit">开设课程</li>
							</ul>
						</div>
						<div class="ydc-panes" style="margin-top: 40px;">
							<div
								style="color: red; font-size: 14px; text-align: center; margin-bottom: 20px;">${message}</div>

							<form name="form" method="post">
								<div class="ydc-reg-form-group clearfix">
									<label><span style="color: red;">*</span>课程名:</label>
									<div class="ydc-reg-form-input">
										<input type="text" name="courseName" class="ydc-form-control">
									</div>
								</div>
								<div class="ydc-reg-form-group clearfix">
									<label><span style="color: red;">*</span>人数上限:</label>
									<div class="ydc-reg-form-input">
										<input type="text" name="upLimit" class="ydc-form-control">
									</div>
								</div>
								<div class="ydc-reg-form-group clearfix">
									<label><span style="color: red;">*</span>状态:</label>
									<div class="ydc-reg-form-input">
										<select  name="courseStatus"
											style="width: 320px; height: 38px;">
											<option>已审核</option>
											<option>未审核</option>
										</select>
									</div>
								</div>
								<div class="ydc-reg-form-group clearfix">
									<label><span style="color: red;">*</span>教师姓名:</label>
									<div class="ydc-reg-form-input">
										<select id="teacherInfo" name="teacherNo"
											style="width: 320px; height: 38px;">
										</select>
									</div>
								</div>
								<div class="ydc-reg-form-group" style="margin-top: 40px;">
									<div class="ydc-reg-form-button" style="margin-left: 255px;">
										<div class="ydc-reg-yzm">
											<button onclick="add()">添加</button>
											<button onclick="cancel()" style="margin-left: 20px;">取消</button>
										</div>
									</div>
								</div>
							</form>

						</div>


					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 动态生成下拉框 -->
	<script type="text/javascript">
		var url = "http://localhost:8080/StudentCourseSystem/teacherJsonServlet";
		$.ajax({
			type : "POST", //请求方式  
			url : url, //servlet请求路径  
			cache : false,
			data : "",
			dataType : 'json', //返回值类型  
			success : function(data) {
				var str = "";

				$.each(data, function(i, obj) {
					str += "<option value="+obj.teacher_no+">" + obj.teacher_name
							+ "</option>";
				});

				$("#teacherInfo").append(str);
			},
			error : function() {
				alert('请求失败');
			},
		});
	</script>
	<script type="text/javascript">
		function add() {//提交
			document.form.action = "<%=request.getContextPath()%>/addCourseServlet";
			document.form.submit();
		}
		function cancel() {//取消
			document.form.action = "<%=request.getContextPath()%>/admin/course_manager.jsp";
			document.form.submit();
		}
	</script>

</body>
</html>