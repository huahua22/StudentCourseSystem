<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--拼装当前网页的相对路径  -->
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生教务系统</title>
<jsp:include page="/cite_css_js.jsp" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/admin/js/jquery.min.js"></script>

<!-- 下拉框选中表单改变 -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#classInfo").change(

		function() {
			var parent = $("#classInfo");
			getStudent(parent.val(), parent.find("option:selected").text());
		});

		getStudent(0, '');
	});

	function getStudent(classId, className) {
		var url = "http://localhost:8080/StudentCourseSystem/getStudentByClassNameServlet";
		$.ajax({
			type : "POST", //请求方式  
			url : url, //servlet请求路径  
			cache : false,
			data : {//传参  
				"classId" : classId,
				"className" : className
			},
			dataType : 'json', //返回值类型  
			success : function(data) {
				var str = "";
				$.each(data, function(i, obj) {
					str += "<tr>" + "<td width='20%'>" + obj.student_no
							+ "</td>" + "<td width='20%'>" + obj.student_name
							+ "</td>" + "<td width='20%'>"
							+ obj.student_contact + "</td>"
							+ "<td width='20%'>" + obj.className + "</td>"
							+ "<td width='20%'>" + obj.depart_name + "</td>"
							+ "</tr>";
				});
				$("#table tr").remove();//清空之前的数据
				$("#table").append(str);

			},
			error : function() {
				alert('请求失败');
			},
		});
	}
</script>
</head>
<body>
	<div class="ydc-content-slide ydc-body" style="margin-top: 20px;">
		<div class="ydc-flex">
			<div class="ydc-column">
				<div class="ydc-release-content">
					<div class="ydc-tabPanel ydc-tabPanel-release">
						<div class="ydc-release-tab-head">
							<ul>
								<li class="hit">班级信息</li>
							</ul>
						</div>
						<div class="ydc-panes" style="margin-top: 15px;">
							<div class="ydc-pane" style="display: block;">

								<!-- 搜索栏 -->
								<div class="clearfix">

									<div class="fl ydc-group-input ydc-group-sel">
										<select id="classInfo">

										</select>
									</div>
								</div>
							</div>


							<div class="ydc-panes-account">
								<table class="mytablelist">
									<thead>
										<tr>
											<th width="20%">学号</th>
											<th width="20%">姓名</th>
											<th width="20%">联系方式</th>
											<th width="20%">班级</th>
											<th width="20%">院系</th>
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
	</div>
	<!-- 动态生成下拉框 -->
	<script type="text/javascript">
		var url = "http://localhost:8080/StudentCourseSystem/classListServlet";
		$.ajax({
			type : "POST", //请求方式  
			url : url, //servlet请求路径  
			cache : false,
			data : "",
			dataType : 'json', //返回值类型  
			success : function(data) {
				var str = "<option value='0'>请选择班级</option>";

				$.each(data, function(i, obj) {
					str += "<option value="+obj.class_no+">" + obj.class_name
							+ "</option>";
				});

				$("#classInfo").append(str);
				$("#classInfo").find("option").first().attr("selected", true);

			},
			error : function() {
				alert('请求失败');
			},
		});
	</script>

</body>
</html>