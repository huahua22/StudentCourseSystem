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
</head>
<body>
	<div class="ydc-content-slide ydc-body" style="margin-top: 20px;">
		<div class="ydc-flex">
			<div class="ydc-column ">
				<div class="ydc-release-content">
					<div class="ydc-tabPanel ydc-tabPanel-release">
						<div class="ydc-release-tab-head">
							<ul>
								<li class="hit">我的班级</li>
							</ul>
						</div>
						<div class="ydc-panes">
							<div class="ydc-panes-account">
								<table>
									<thead>
										<tr>
											<th width="20%">学号</th>
											<th width="20%">姓名</th>
											<th width="20%">联系方式</th>
											<th width="20%">班级</th>
											<th width="20%">报到时间</th>


										</tr>
									</thead>
									<c:forEach items="${studentList}" var="item">
										<tr>
											<td width="20%">${item.student_no }</td>
											<td width="20%">${item.student_name }</td>
											<td width="20%">${item.student_contact }</td>
											<td width="20%">${item.classes.class_name }</td>
											<td width="20%"><fmt:formatDate
													pattern="yyyy-MM-dd hh:mm:ss" value="${item.add_time }" />
											</td>
										</tr>
									</c:forEach>

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