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

<script type="text/javascript">
	$(document).ready(function() {
		$("#courseInfor").change(

		function() {
			var parent = $("#courseInfor");
			getChoose(parent.val(), parent.find("option:selected").text());
		});

		getChoose(0, '');
	});

	function getChoose(courseId, courseName) {
		var url = "http://localhost:8080/StudentCourseSystem/getCourseScoreServlet";
		$.ajax({
			type : "POST", //请求方式  
			url : url, //servlet请求路径  
			cache : false,
			data : {//传参  
				"courseId" : courseId,
				"courseName" : courseName
			},
			dataType : 'json', //返回值类型  
			success : function(data) {
				var str = "";
				$.each(data, function(i, obj) {
					str += "<tr>" + "<td width='25%'>" + obj.course_no
							+ "</td>" + "<td width='25%'>" + obj.course_name
							+ "</td>" + "<td width='25%'>" + obj.teacher_no
							+ "</td>" + "<td width='25%'>" + obj.teacher_name
							+ "</td>" + "</tr>";
				});
			
				$("#table").append(str);

			},
			error : function() {
				alert('暂无数据');
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
								<li class="hit">我的课程</li>
							</ul>
						</div>
						<div class="ydc-panes" style="margin-top: 15px;">

							<!-- 动态数据表 -->
							<div class="ydc-panes-account">
								<table class="mytablelist" id="table">
									<thead>
										<tr>
											<th width="25%">课程Id</th>
											<th width="25%">课程名</th>
											<th width="25%">教师编号</th>
											<th width="25%">教师姓名</th>
											
										</tr>
									</thead>
								</table>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>