<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

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
	  	<button id="emp_add_but" class="btn btn-primary">新增</button>
	  	<button id="emp_delete_but" class="btn btn-danger">删除</button>
	  </div>
	</div>
	<!-- 员工列表 -->
	<div class="row">
		<div class="col-md-12">
			<table class="table table-hover">
				<tr style="text-align:center">
					<th style="text-align:center">lastname</th>
					<th style="text-align:center">email</th> 
					<th style="text-align:center">gender</th>
					<th style="text-align:center">depName</th>
					<th style="text-align:center">operation</th>
				</tr>
				<c:forEach items="${emplist.list }" var="emplist">
					<tr>
						<td style="text-align:center">${emplist.empLastname }</td>
						<td style="text-align:center">${emplist.email}</td>
						<td style="text-align:center">${emplist.gender=="0"?"男":"女"}</td>
						<td style="text-align:center">${emplist.department.depName }</td>
						<td style="text-align:center">
							<button type="button" class="btn btn-info btn-sm">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 编辑
							</button>
							<button type="button" class="btn btn-danger btn-sm">
								<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除
							</button>
						</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</div>
	<!-- 分页 -->
	<div class="row">
		<!--分页信息  -->
		<div class="col-md-9">
			当前页${emplist.pageNum } 共有${emplist.pages}页, 总计 ${emplist.total } 条记录
		</div>
		<!-- 分页条 -->
		<div class="col-md-3">
			<nav aria-label="Page navigation">
			  <ul class="pagination">
			 
			   <li><a href="${APP_PATH }/employeeall?pn=1">首页</a></li>
			   
			   <!-- 如果是第一人上一页无法点击 -->
			 	<c:if test="${emplist.pageNum==1 }">
			 		<li class=disabled>
				      <a href="#" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				 	</li>
			 	</c:if>
			    <c:if test="${emplist.pageNum!=1 }">
			 		<li>
				      <a href="${APP_PATH }/employeeall?pn=${emplist.pageNum-1}" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				 	</li>
			 	</c:if>
				 
				 <c:forEach items="${emplist.navigatepageNums}" var="Navigat">
				 	<!-- 如果是当前页 着重显示 -->
				 	<c:if test="${Navigat==emplist.pageNum  }">
				 			<li class="active"><a href="${APP_PATH }/employeeall?pn=${Navigat}">${Navigat}</a></li>
				 	</c:if>
				 	<c:if test="${Navigat!=emplist.pageNum  }">
				 		<li><a href="${APP_PATH }/employeeall?pn=${Navigat}">${Navigat}</a></li>
				 	</c:if>
				 </c:forEach>
				 
					<!-- 如果当前页等于总页数，说明是最后一页，最后也有的时候下一页禁止使用 -->
			    	<c:if test="${emplist.pageNum == emplist.pages}">
			    		  <li class="disabled">
					    	 <a href="" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						  </li>
			    	</c:if>
			    	 
			    	<c:if test="${emplist.pageNum !=emplist.pages}">
			    		  <li>
					    	 <a href="${APP_PATH }/employeeall?pn=${emplist.pageNum+1}" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						  </li>
			    	</c:if>
			     <li><a href="${APP_PATH }/employeeall?pn=${emplist.pages}">末页</a></li>
			  </ul>
			</nav>
		</div>
	</div>
</body>
</html>