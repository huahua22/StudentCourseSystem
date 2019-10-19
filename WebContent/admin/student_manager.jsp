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
<jsp:include page="/openNewWindow_css_js.jsp" />
</head>
<body>
	<div class="ydc-content-slide ydc-body" style="margin-top: 20px;">
		<div class="ydc-flex">
			<div class="ydc-column">
				<div class="ydc-release-content">
					<div class="ydc-tabPanel ydc-tabPanel-release">
						<div class="ydc-release-tab-head">
							<ul>
								<li class="hit">学生管理</li>
							</ul>
						</div>
						<div class="ydc-panes" style="margin-top: 15px;margin-bottom: 20px;">
							<div class="ydc-pane" style="display: block;">

								<!-- 搜索栏 -->
								<div class="clearfix">
									<div class="fl ydc-group-sel">
										<select>
											<option>按学号查找</option>
											<option>按班级查找</option>
											<option>按系部查找</option>
										</select>
									</div>
									<div class="fl ydc-group-input">
										<input type="text" placeholder="请输入学号/系属/班级">
										<button class="ydc-group-button">搜索</button>
									</div>
								</div>
								<!--添加学生  -->
								<button class="myaddbutton" onclick="window.location.href='<%=request.getContextPath()%>/admin/add_student.jsp'">添加学生</button>
								<!-- 学生信息表格 -->
								<div class="ydc-panes">
									<div class="ydc-panes-account">
										<table class="mytablelist">
											<thead>
												<tr>
													<th width="20%">学号</th>
													<th width="20%">姓名</th>
													<th width="20%">联系方式</th>
													<th width="20%">报到时间</th>
													<th width="20%">操作</th>
												</tr>
											</thead>
											<c:forEach items="${studentList}" var="stu">
												<tr>
													<td width="20%">${stu.student_no }</td>
													<td width="20%">${stu.student_name }</td>
													<td width="20%">${stu.student_contact }</td>
													<td width="20%"><fmt:formatDate
															pattern="yyyy-MM-dd hh:mm:ss" value="${stu.add_time }" /></td>
													<td width="20%"><a
														href="deleteStudentServlet?student_no=${stu.student_no }">删除</a>
														<a
														href="selectStudentServlet?student_no=${stu.student_no }">修改</a></td>
												</tr>
											</c:forEach>
											<!-- 分页 -->
											<tr>
												<td colspan="5" align="center">
													<div class="foot">
														<a
															href="studentListServlet?changePageNow=${pageNow-pageSize }">上一页</a>
														<c:forEach begin="1" end="${pageCount}" varStatus="status">

															<c:if test="${status.index ==pageNow/pageSize+1}">
																<a style="color: red"
																	href="studentListServlet?changePageNow=${(status.index-1)*pageSize}">${status.index}</a>
															</c:if>
															<c:if test="${status.index !=pageNow/pageSize+1}">
																<a
																	href="studentListServlet?changePageNow=${(status.index-1)*pageSize}">${status.index}</a>
															</c:if>
														</c:forEach>
														<a
															href="studentListServlet?changePageNow=${pageNow+pageSize}">下一页</a>
													</div>
												</td>
											</tr>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>