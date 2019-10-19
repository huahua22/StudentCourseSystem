<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/cite_css_js.jsp" />
<title>showStudentDetail</title>
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
								<li class="hit">个人信息</li>
								<li>修改密码</li>
							</ul>
						</div>
						<!-- the begin tab  -->
						<div class="ydc-panes">
							<!-- person infor  -->
							<div class="ydc-pane ydc-pane-clear" style="display: block;">
								<div class="ydc-reg-form-group clearfix">
									<label>学号</label>
									<div class="ydc-reg-form-input">
										<label>${student.student_no }</label>
									</div>
								</div>
								<div class="ydc-reg-form-group clearfix">
									<label>姓名</label>
									<div class="ydc-reg-form-input">
										<label>${student.student_name }</label>
									</div>
								</div>
								<div class="ydc-reg-form-group clearfix">
									<label>联系方式</label>
									<div class="ydc-reg-form-input">
										<label>${student.student_contact }</label>
									</div>
								</div>
								<div class="ydc-reg-form-group clearfix">
									<label>班级</label>
									<div class="ydc-reg-form-input">
										<label>${student.classes.class_name }</label>
									</div>
								</div>
								<div class="ydc-reg-form-group clearfix">
									<label>院系</label>
									<div class="ydc-reg-form-input">
										<label>${student.classes.depart_name }</label>
									</div>
								</div>
								<!-- 上传头像 -->
								<div class="ydc-reg-form-group clearfix">
									<div class="aui-card-form-item preview  aui-news"
										style="margin-top: 20px;">
										<label class="aui-card-form-label">头像:</label>
										<div class="aui-file-up-img" id="preview_0">
											<img class="" id="imghead_0" border="0"
												src="admin/images/icon/noimg.gif">
										</div>

										<div class="aui-file-up-btn clearfix ">
											<div class="idPicFile aui-btn aui-file-new">
												<input type="file" name="file" id="1"
													class="file_photo aui-file-new-up" style="margin: 0;">
												<a>上传头像</a>
											</div>
											<div class="aui-remarks">
												<p>图片尺寸建议：800*400 图片大小不超过1MB</p>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- update password -->
							<div class="ydc-pane">
								<div class="container information-content">
									<div class="content">
										<form
											action="<%=request.getContextPath()%>/updateStudentPasswordServlet"
											method="post">
											<div class="revise-content clearfix ">
												<div class="list fr">
													<label>原密码</label> : <input type="password" value=""
														name="oldpassword" />
												</div>
												<div class="list fr">
													<label>新密码</label> : <input type="password" value=""
														name="newpassword" />
												</div>
												<div class="list fr ">
													<label>确认密码</label> : <input type="password" value=""
														name="newpassword2" />
												</div>
											</div>
											<div class="list1">
												<input type="submit" value="提交">
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		jQuery(function() {
			upload_start();
		});
		//tab切换
		$(function() {
			$('.aui-ad-tab-title ul li').click(
					function() {
						$(this).addClass('aui-current').siblings().removeClass(
								'aui-current');
						$('.aui-ad-tab-body>div:eq(' + $(this).index() + ')')
								.show().siblings().hide();
					})
		});
	</script>
	<script type="text/javascript">
		$(function() {
			$('.ydc-tabPanel ul li').click(
					function() {
						$(this).addClass('hit').siblings().removeClass('hit');
						$('.ydc-panes>div:eq(' + $(this).index() + ')').show()
								.siblings().hide();
					})
		}) //tab
	</script>
</body>
</html>