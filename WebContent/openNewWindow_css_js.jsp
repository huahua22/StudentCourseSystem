<%@ page pageEncoding="UTF-8"%>
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/newwindow/css/x-admin.css">
<script src="<%=request.getContextPath()%>/newwindow/lib/layui/layui.js" charset="utf-8"></script> 
<script src="<%=request.getContextPath()%>/newwindow/js/x-layui.js" charset="utf-8"></script> 
<script src="<%=request.getContextPath()%>/newwindow/js/jquery2.js" charset="utf-8"></script> 
<script src="<%=request.getContextPath()%>/newwindow/js/js.js" charset="utf-8"></script> 
<script>
            layui.use(['laydate','element','laypage','layer'], function(){
                $ = layui.jquery;//jquery
              laydate = layui.laydate;//日期插件
              lement = layui.element();//面包导航
              laypage = layui.laypage;//分页
              layer = layui.layer;//弹出层
            });

             /*添加*/
            function student_management_add(title,url,w,h){
                x_admin_show(title,url,w,h);
            }
            </script>