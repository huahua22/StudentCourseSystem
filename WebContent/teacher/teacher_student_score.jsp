<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>classManager</title>
<jsp:include page="/cite_css_js.jsp" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/admin/js/jquery.min.js"></script>
<!-- 动态生成下拉框 -->
<script type="text/javascript">
	var url = "http://localhost:8080/StudentCourseSystem/teacherCourseServlet";
	$.ajax({
		type : "POST", //请求方式  
		url : url, //servlet请求路径  
		cache : false,
		data : "",
		dataType : 'json', //返回值类型  
		success : function(data) {
			var str = "<option value='0'>请选择课程</option>";

			$.each(data, function(i, obj) {
				str += "<option value="+obj.course_no+">" + obj.course_name
						+ "</option>";
			});

			$("#courseInfo").append(str);

		},
		error : function() {
			alert('请求失败');
		},
	});
</script>



</head>
<body>
	<div class="ydc-content-slide ydc-body" style="margin-top: 20px;">
		<div class="ydc-flex">
			<div class="ydc-column ">
				<div class="ydc-release-content">
					<div class="ydc-tabPanel ydc-tabPanel-release">
						<div class="ydc-release-tab-head">
							<ul>
								<li class="hit">学生成绩</li>
							</ul>
						</div>
						<div class="ydc-panes" style="margin-top: 15px;">

							<!-- 搜索栏 -->
							<div class="clearfix">

								<div class="fl ydc-group-input ydc-group-sel">
									<select id="courseInfo">

									</select>
								</div>
							</div>
						</div>

						<div class="ydc-panes-account">
							<table class="mytablelist" >
								<thead>
									<tr>
										<th width="20%">学号</th>
										<th width="20%">姓名</th>
										<th width="15%">班级</th>
										<th width="15%">课程</th>
										<th width="15%">教师</th>
										<th width="15%">分数</th>
									</tr>
								</thead>
							</table>
							<table class="mytablelist" id="table">
				                 
								</table>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		var url = 'http://localhost:8080/StudentCourseSystem/teacherStudentScoreServlet';
		$(document).ready(
				function() {
					$("#courseInfo").change(
							function() {
								$.ajax({
									type : "POST", //请求方式  
									url : url, //请求路径  
									cache : false,
									data : {//传参  
										"chooseId" : $("#courseInfo").val(),
										"chooseName" : $("#courseInfo").find(
												"option:selected").text(),
									},
									dataType : 'json', //返回值类型  
									success : function(data) {
										var str = "";
										$.each(data, function(i, obj) {
											str += "<tr>" + "<td width='20%'>"
											+ obj.student_no
											+ "</td>"
											+ "<td width='20%'>"
											+ obj.student_name
											+ "</td>"
											+ "<td width='15%'>"
											+ obj.class_name
											+ "</td>"
											+ "<td width='15%'>"
											+ obj.course_name
											+ "</td>"
											+ "<td width='15%'>"
											+ obj.teacher_name
											+ "</td>"
											+ "<td width='15%'>"
											+ obj.score
											+ "</td>"
											+ "</tr>";
										});
										$("#table tr").remove();
										$("#table").append(str);
									},
									error : function() {
										$("#table tr").remove();
										alert("暂无数据");
									},
								});
							});
				});
	</script>
</body>
</html>