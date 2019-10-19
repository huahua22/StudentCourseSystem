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
</head>
<body>
	<div class="ydc-content-slide ydc-body" style="margin-top: 20px;">
		<div class="ydc-flex">
			<div class="ydc-column ">
				<div class="ydc-release-content">
					<div class="ydc-tabPanel ydc-tabPanel-release">
						<div class="ydc-release-tab-head">
							<ul>
								<li class="hit">班级管理</li>
							</ul>
						</div>
						<div class="ydc-panes">
							<div class="ydc-panes-account">
								<table class="mytablelist" id="table">
									<thead>
										<tr>
											<th width="30%">id</th>
											<th width="30%">班级名</th>
											<th width="40%">系属</th>
					
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
		var url = 'http://localhost:8080/StudentCourseSystem/classListServlet';
		$.ajax({
			type : "POST", //请求方式  
			url : url, //servlet请求路径  
			cache : false,
			data : "",
			dataType : 'json', //返回值类型  
			success : function(data) {
				var str = "";
				$.each(data, function(i, obj) {
					str += "<tr>" + "<td width='25%'>" + obj.class_no + "</td>" + "<td width='25%'>"
							+ obj.class_name + "</td>" + "<td width='25%'>"
							+ obj.depart_name + "</td>" + "</tr>";
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