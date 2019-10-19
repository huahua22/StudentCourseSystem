<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>studentManager</title>
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
								<li class="hit">教师管理</li>
							</ul>
						</div>
						<div class="ydc-panes">
						<button class="myaddbutton" onclick="window.location.href='<%=request.getContextPath()%>/admin/add_teacher.jsp'">录入教师</button>
							${message }
							<div class="ydc-panes-account">
								<table  class="mytablelist" style="margin-bottom:20px;">
									<thead>
										<tr>
											<th width="20%">教师编号</th>
											<th width="20%">姓名</th>
											<th width="20%">联系方式</th>
											<th width="20%">入职时间</th>
											<th width="20%">操作</th>
										</tr>
									</thead>
									<c:forEach items="${teacherList}" var="item">
										<tr>
											<td width="20%">${item.teacher_no }</td>
											<td width="20%">${item.teacher_name }</td>
											<td width="20%">${item.teacher_contact }</td>
											<td width="20%"><fmt:formatDate
													pattern="yyyy-MM-dd hh:mm:ss" value="${item.add_time }" /></td>
										    <td width="20%"><a
														href="deleteTeacherServlet?teacher_no=${item.teacher_no }">删除</a>
														<a
														href="selectTeacherServlet?teacher_no=${item.teacher_no }">修改</a></td>
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