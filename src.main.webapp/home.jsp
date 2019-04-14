<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>使用ajax请求数据</title>
<%
 pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript" src="${APP_PATH }/static/js/jquery-3.3.1.min.js" ></script>
<!-- 引入bootstrap -->
<link rel="stylesheet" href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script type="text/javascript" src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" ></script>

</head>
<body>
	<!--标题：SSM—CRUD -->
	<div class="row">
	  <div class="col-md-12"><h1>SSM—CRUD</h1></div>
	</div>
	<!-- 新增删除按钮 -->
	<div class="row">
	  <div class="col-md-2 col-md-offset-10">
	  	<button id="emp_add_but_Modal" class="btn btn-primary">新增</button>
	  	<button id="emp_delete_but" class="btn btn-danger">删除</button>
	  </div>
	</div>
	<!-- 员工列表 -->
	<div class="row">
		<div class="col-md-12">
			<table class="table table-hover" id="tableid">
				<thead>
					<tr style="text-align:center">
						<!-- style="text-align:center"内容居中 -->
						<th><input type="checkbox" id="checkboxall"><th>
						<th>lastname</th>
						<th>email</th> 
						<th>gender</th>
						<th>depName</th>
						<th>operation</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		</div>
	</div>
	<!-- 分页 -->
	<div class="row">
		<!--分页信息  -->
		<div class="col-md-9 col-md-offset-3"  id="111">
			
		</div>
		<!-- 分页条 -->
		<div class="col-md-3 col-md-offset-9" id="222">
			
		</div>
	</div>
	<!-- 新增模态窗 -->
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">新增员工</h4>
	      </div>
	      <div class="modal-body">
	        	<!--新增员工的form表单  -->
	        	<form class="form-horizontal">
				  <div class="form-group">
				    <label for="name" class="col-sm-2 control-label">姓名</label>
				    <div class="col-sm-10">
				      <input type="text"  class="form-control" id="name_input" name="empLastname" placeholder="请输入姓名">
				      <span id="span_name_ck" class="help-block"></span>
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="col-sm-2 control-label">性别</label>
				    <div class="col-sm-10">
				      <label class="radio-inline">
						  <input type="radio" name="gender" id="gender" value="1" checked="1"> 男
						</label>
						<label class="radio-inline">
						  <input type="radio" name="gender" id="gender" value="0"> 女
					  </label>
				    </div>
				  </div>
				  <!-- 邮箱文本框 -->
				 <div class="form-group">
				    <label for="email" class="col-sm-2 control-label">邮箱</label>
				    <div class="col-sm-10">
				      <input type="text"  class="form-control" id="email_input" name="email" placeholder="请输填写邮箱">
				      <span id="span_email_ck" class="help-block"></span>
				    </div>
				  </div>
				  <!-- 选择部门 -->
				  <div class="form-group">
				    <label  class="col-sm-2 control-label">部门</label>
				    <div class="col-sm-6">
				     	<select class="form-control" name="depid" id="alldepinfo">
							
						</select>
				    </div>
				  </div>
				</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="saveemp_btn" >保存</button>
	      </div>
	    </div>
	  </div>
	</div>

	
	
	<!-- 修改模态窗 -->
	<!-- Modal -->
	<div class="modal fade" id="my_Update_Modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">员工修改</h4>
	      </div>
	      <div class="modal-body">
	        	<!--修改员工的form表单  -->
	        	<form class="form-horizontal">
				  <div class="form-group">
				    <label for="name" class="col-sm-2 control-label">姓名</label>
				    <div class="col-sm-10">
				       <p class="form-control-static" id="name_idet_input"></p>
				      <span id="span_name_ck" class="help-block"></span>
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="col-sm-2 control-label">性别</label>
				    <div class="col-sm-10">
				      <label class="radio-inline">
						  <input type="radio" name="gender" id="gender" value="1" checked="1"> 男
						</label>
						<label class="radio-inline">
						  <input type="radio" name="gender" id="gender" value="0"> 女
					  </label>
				    </div>
				  </div>
				  <!-- 邮箱文本框 -->
				 <div class="form-group">
				    <label for="email" class="col-sm-2 control-label">邮箱</label>
				    <div class="col-sm-10">
				      <input type="text"  class="form-control" id="email_edit_input" name="email" placeholder="请输填写邮箱">
				      <span id="span_email_ck" class="help-block"></span>
				    </div>
				  </div>
				  <!-- 选择部门 -->
				  <div class="form-group">
				    <label  class="col-sm-2 control-label">部门</label>
				    <div class="col-sm-6">
				     	<select class="form-control" name="depid" id="alldepinfo">
							
						</select>
				    </div>
				  </div>
				</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="idet_emp_btn" >确认修改</button>
	      </div>
	    </div>
	  </div>
	</div>
<script type="text/javascript">

	//保存总页数数
	var pages;
	//保存当前页；
	var pageNum;
	$(function(){
		To_Page(1);
	});
	//点击分页按钮跳转到对应的页面
	function To_Page(pn){
		$.ajax({
			url:"${APP_PATH}/employeejson",
			data:"pn="+pn,
			type:"GET",
			success:function(result){
				//解析并并显示员工数据(1)
				build_emps_table(result);
				build_page_nav(result);
				//解析并显示分页条信息
				build_article_page(result);
			}
		});
	}
	//解析并并显示员工数据(1)
	function build_emps_table(result){
		$("#tableid tbody").empty();
		//var emps=result.extend.pageinfo.list;
		 $.each(result.extend.pageinfo.list,function(index,item){
			 	var checkbox =$("<td><input type='checkbox' id='check_box_items'><td>");
				var empId =$("<td></td>").append(item.empId);
				var empLastname=$("<td></td>").append(item.empLastname);
				var gender=$("<td></td>").append(item.gender=="1"?"男":"女");
				var email=$("<td></td>").append(item.email);
				var depName=$("<td></td>").append(item.department.depName);
				/*<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 编辑**/
				var idet_btn=$("<button></button>").addClass("btn btn-info btn-sm edit_btn").append($("<span></span>").addClass("glyphicon glyphicon-pencil ").append("编辑"));
				//给编辑按钮自定义id
				idet_btn.attr("emp-btn-id",item.empId);
				var del_btn=$("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append($("<span></span>").addClass("glyphicon glyphicon-trash").append("删除"));
				del_btn.attr("del-btn-id",item.empId);
				var ide_del_btn=$("<td></td>").append(idet_btn).append(del_btn);
				$("<tr></tr>").append(checkbox)
							 .append(empId)
							 .append(empLastname)
							 .append(gender)
							 .append(email)
							 .append(depName)
							 .append(ide_del_btn)
							 .appendTo("#tableid tbody");
			}); 
	}
	
	//解析并显示分页信息
	function build_page_nav(result){
		$("#111").empty();
		var total=result.extend.pageinfo.total;
		if(total==0){
			$("<span></span>").append("暂无记录").appendTo("#111");
		}else{
			pageNum=result.extend.pageinfo.pageNum;
			pages=result.extend.pageinfo.pages;
			var total=result.extend.pageinfo.total;
			$("<span></span>").append(pageNum).append("页")
						.append("  ").append("共").append(pages).append("页")
						.append("  ").append("共").append(total).append("条记录").appendTo("#111");
		}
	}
	//解析并显示分页条信息
	function build_article_page(result){
		$("#222").empty();
		var pageinfos=result.extend.pageinfo.navigatepageNums;
		//总页数
		var pages=result.extend.pageinfo.pages;
		//构建分页条
		//首页按钮
		var firstpage_btn=$("<li></li>").append($("<a></a>").attr("href","#").append("首页"));
		firstpage_btn.click(function(){
			To_Page(1);
		})
		//尾页按钮
		var endspage_btn=$("<li></li>").append($("<a></a>").attr("href","#").append("尾页"));
		endspage_btn.click(function(){
			To_Page(result.extend.pageinfo.pages);
		})
		//上一页
		var previous_page=$("<li></li>").append($("<a></a>").attr("href","#").append("&laquo;"));
		if(result.extend.pageinfo.hasPreviousPage==false){
			previous_page.addClass("disabled");
		}else{
			previous_page.click(function(){
				To_Page(result.extend.pageinfo.pageNum-1);
			});
		}
		//下一页
		var next_page=$("<li></li>").append($("<a></a>").attr("href","#").append("&raquo;"));
		if(result.extend.pageinfo.hasNextPage==false){
			next_page.addClass("disabled");
		}else{
			next_page.click(function(){
				To_Page(result.extend.pageinfo.pageNum+1);
			});
		}
		var ul=$("<ul></ul>").addClass("pagination").append(firstpage_btn).append(previous_page);
		$.each(pageinfos,function(index,item){
			var navigatepageNums=$("<li></li>").append($("<a></a>").attr("href","#").append(item));
			if(result.extend.pageinfo.pageNum==item){
				navigatepageNums.addClass("active");
			}
			navigatepageNums.click(function(){
				To_Page(item);
			})
			ul.append(navigatepageNums);
		});
		ul.append(next_page).append(endspage_btn);
		var navs= $("<nav></nav>").append(ul);
		navs.appendTo("#222")
	}
	
	//打开模态窗体
	$("#emp_add_but_Modal").click(function(){
		//清空表单数据
		$("#myModal form")[0].reset();
		//打开模态窗体前吧所有的部门加入到模态窗体的下拉框中;
		//获取所有的部门方法
		getDepAll("#alldepinfo");
		$('#myModal').modal({
			backdrop:"static"
		});
	});
	//获取所有的部门
	function getDepAll(element){
		$.ajax({
			url:"${APP_PATH}/getAllDeptInfo",
			type:"GET",
			success:function(result){
				//获取到的全部部门信息添加到下拉框中
				//<option value="3">军事</option>
				$.each(result.extend.deplist,function(){
					var depId =result.extend.deplist.depId;
					var depName=result.extend.deplist.depName
					$("<option></option>").attr("value",this.depId).append(this.depName).appendTo(element);
				});
			}
		})
	}
	
	//点击保存按钮
	$("#saveemp_btn").click(function(){
		if(!TextboxCheck()){
			return false;
		}
		$.ajax({
			url:"${APP_PATH}/addEmployee",
			type:"POST",
			data:$("#myModal form").serialize(),
			success:function(result){
				//成功后关闭模态窗
				$("#myModal").modal('hide');
				//去最后一页
				To_Page(pages);
			}
		});
	});
	
	//给文本框做校验方法
	function TextboxCheck(){
		//校验用户名name_input
		var name_input_val =$("#name_input").val();
		//使用jquery正则表达式
		var name_input_zhengzhe=(/^[a-zA-Z0-9_-]{6,16}$/);
		if(!name_input_zhengzhe.test(name_input_val)){
			//$("#name_input").parent().addClass("has-error");
			//$("#name_input").next("span").text("请输入6-16为的字母或数字的用户名"); 
			show_Check_info("#name_input","error","请输入6-16为的字母或数字的用户名")
			return false;
		}else{
			show_Check_info("#name_input","success","")
			//$("#name_input").parent().addClass("has-success");
			//$("#name_input").next("span").text("");
		} 
		
		//邮箱格式校验email_input
		//得到email_input的值
		var email_input_val=$("#email_input").val();
		var email_input_zhengzhe=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		if(!email_input_zhengzhe.test(email_input_val)){
			//给父元素添加has-error
			// $("#email_input").parent().addClass("has-error");
			//$("#email_input").next("span").text("请输入正确的邮箱格式");
			show_Check_info("#email_input","error","请输入正确的邮箱格式");
			return false;
		}else{
			show_Check_info("#email_input","success","");
			//$("#email_input").parent().addClass("has-success");
			//$("#email_input").next("span").text("");
		}
		return true;
	}
	//校验用户名是否重复,
	$("#name_input").change(function(){
		$.ajax({
			url:"${APP_PATH}/userNameCheck",
			data:"empname="+$("#name_input").val(),
			type:"GET",
			success:function(result){
				var	empnamenum=result.extend.empnamenum;
				if(empnamenum > 0){
					show_Check_info("#name_input","error","用户名已经存在,请从新输入");
				}else{
					show_Check_info("#name_input","success","用户名可用");
				}
			}
		});
	});
	//因为校验的信息内容都差不多，为了减少代码的重复性写一个方法保存校验的信息
	function show_Check_info(element,status,textval){
		//清除当前元素的
		$(element).parent().removeClass("has-success has-error");
		$(element).next("span").text("");
		if("success"==status){
			$(element).parent().addClass("has-success");
			$(element).next("span").text(textval);
		}else if("error"==status){
			$(element).parent().addClass("has-error");
			$(element).next("span").text(textval);
		}
	}
	
	//给模态窗添加点击事件
	//我们是按钮创建之前就绑定了click,说以绑定不上
	$(document).on("click",".edit_btn",function(){
		//清空表单数据
		$("#my_Update_Modal form")[0].reset();
		//打开模态窗体
		getDepAll("#my_Update_Modal select");
		
		//根据员工的id查找用户的信息
		getempInfoById($(this).attr("emp-btn-id"));
		
		//吧id传递给修改按钮
		$("#idet_emp_btn").attr("idet_id",$(this).attr("emp-btn-id"));
		
		$('#my_Update_Modal').modal({
			backdrop:'static'
		})
	})
	
	function getempInfoById(empid){
		$.ajax({
			url:"${APP_PATH}/getEmpInfoById/"+empid,
			type:"GET",
			success:function(result){
				var emp=result.extend.empinfo;
				$("#name_idet_input").text(emp.empLastname);
				$("#my_Update_Modal input[type=radio]").val([emp.gender]);
				$("#email_edit_input").val(emp.email);
				$("#my_Update_Modal select").val([emp.depid]);
				
			}
		});
	}
	//给确认修改按钮添加点击事件
	$("#idet_emp_btn").click(function(){
		//校验修改文本框的邮箱
		if(!check_edit_email()){
			return false;
		}
		//提交修改信息
		$.ajax({
			url:"${APP_PATH}/updateEmpById/"+$(this).attr("idet_id"),
			data:$("#my_Update_Modal form").serialize(),
			type:"PUT",
			success:function(result){
				//关闭模态窗；
				$('#my_Update_Modal').modal('hide');
				//跳转到本页面：
				To_Page(pageNum);
			}
		})
	});
	function check_edit_email(){
		$("#email_edit_input").parent().removeClass("has-success has-error");
		$("#email_edit_input").next("span").text("");
		var emailedit=$("#email_edit_input").val();
		var ereg=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		if(!ereg.test(emailedit)){
			$("#email_edit_input").parent().addClass("has-error");
			$("#email_edit_input").next().text("请输入正确的邮箱格式");
			return false;
		}
		return true;
	}
	
	//给删除按钮添加点击事件
	$(document).on("click",".delete_btn",function(){
		//弹出确认框：确认要删除XXX吗
		var empname=$(this).parents("tr").find("td:eq(1)").text();
		if(confirm("你确认要删除"+empname+"这条信息吗")){
			//调用删除方法
			deleteEmpByID($(this).attr("del-btn-id"));
		}
	});
	//根据员工的id删除员工
	function deleteEmpByID(empid){
		$.ajax({
			url:"${APP_PATH}/deleteEmpById/"+empid,
			type:"DELETE",
			success:function(result){
				//回到本也
				To_Page(pageNum);
			}
		})
	}
	</script>
</body>

</html>