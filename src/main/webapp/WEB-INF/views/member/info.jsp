<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/layout/headCSS.jsp"></c:import>

</head>
<!-- Page Wrapper -->
<body id="page-top">

	<div id="wrapper">
		<!-- Sidebar -->	
		<c:import url="/WEB-INF/views/layout/sidebar.jsp"></c:import>
		
		 <div id="content-wrapper" class="d-flex flex-column">
			 <div id="content">
				<c:import url="/WEB-INF/views/layout/topbar.jsp"></c:import>
			<div class="container-fluid">
				<!-- page실제내용 -->
				<h1><sec:authentication property="name"></sec:authentication></h1>
				<h1><sec:authentication property="email"></sec:authentication></h1>
				<h1><sec:authentication property="birth"></sec:authentication></h1>
				<h1><sec:authentication property="joinDate"></sec:authentication></h1>
				<h1><sec:authentication property="username"></sec:authentication></h1>
			</div>
			</div>
			<c:import url="/WEB-INF/views/layout/footer.jsp"></c:import>
			</div>
	
	</div>
	
	
	
	
	
	<c:import url="/WEB-INF/views/layout/footjs.jsp"></c:import>
</body>
</html>