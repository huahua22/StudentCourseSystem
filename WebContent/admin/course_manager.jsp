<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生教务系统</title>
<jsp:include page="/cite_css_js.jsp" />
<jsp:include page="/openNewWindow_css_js.jsp" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/admin/js/jquery.min.js"></script>
	
</head>
<body>
	<div class="ydc-content-slide ydc-body" style="margin-top: 20px;">
		<div class="ydc-flex">
			<div class="ydc-column ">
				<div class="ydc-release-content">
					<div class="ydc-tabPanel ydc-tabPanel-release">
						<div class="ydc-release-tab-head">
							<ul>
								<li class="hit">课程管理</li>
							</ul>
						</div>
						<div class="ydc-panes">
						<button class="myaddbutton" onclick="window.location.href='<%=request.getContextPath()%>/admin/add_course.jsp'">开设课程</button>
							${message }
							<div class="ydc-panes-account">
								<table id="table">
									<thead>
										<tr>
											<th width="15%">id</th>
											<th width="20%">课程名</th>
											<th width="15%">人数上限</th>
											<th width="15%">状态</th>
											<th width="15%">教师编号</th>
											<th width="20%">授课教师</th>

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
	<!-- 获取数据 -->
	<script type="text/javascript">
		var url = "http://localhost:8080/StudentCourseSystem/courseJsonServlet";
		$.ajax({
			type : "POST", //请求方式  
			url : url, //servlet请求路径  
			cache : false,
			data : "",
			dataType : 'json', //返回值类型  
			success : function(data) {
				var str = "";
				$.each(data, function(i, obj) {
					str += "<tr>" + "<td width='15%'>" + obj.course_no
							+ "</td>" + "<td width='20%'>" + obj.course_name
							+ "</td>" + "<td width='15%'>" + obj.up_limit
							+ "</td>" + "<td width='15%'>" + obj.course_status
							+ "</td>" + "<td width='15%'>" + obj.teacher_no
							+ "</td>" + "<td width='20%'>" + obj.teacher_name
							+ "</td>" + "</tr>";
				});
				$("#table").append(str);

			},
			error : function() {
				alert('请求失败');
			},
		});
	</script>
</body>
</html>