<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<h1>List Page</h1>
				
				<div class="card shadow mb-4">
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
								<thead>
									<tr>
										<th>NO</th>
										<th>Title</th>
										<th>Writer</th>
										<th>Date</th>
										<th>Hit</th>
									</tr>
								
								</thead>
								<tbody>
									<c:forEach items="${list}" var="vo">
											<tr>
												<td>${vo.boardNo}</td>
												<td><a href="./detail?boardNo=${vo.boardNo}">${vo.boardTitle}</a></td>
												<td>${vo.boardWriter}</td>
												<td>${vo.boardDate}</td>
												<td>${vo.boardHit}</td>
												<td><a href="./update" class="btn btn-primary btn-icon-split">
                                        <span class="icon text-white-50">
                                            
                                        </span>
                                        <span class="text">글수정</span>
                                    </a></td>
                                    <td><a href="/board/notice/delete?boardNo=${vo.boardNo}" class="btn btn-primary btn-icon-split">
                                        <span class="icon text-white-50">
                                            
                                        </span>
                                        <span class="text">글삭제</span>
                                    </a></td>
											</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
				<sec:authorize access="hasRole('ADMIN')">
				<a href="./add" class="btn btn-primary btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-flag"></i>
                                        </span>
                                        <span class="text">글작성</span>
                                    </a>
                                    </sec:authorize>
				        </div>
					                    </div>
					                <div class="col-sm-12 col-md-7">
					                    <div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
					                        <ul class="pagination">
					                            <li class="paginate_button page-item previous disabled" id="dataTable_previous">
					                                <a href="#" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
					                            </li>
					                            <li class="paginate_button page-item ">
					                            	<a href="#" aria-controls="dataTable" data-dt-idx="1" tabindex="0" class="page-link active">1</a>
					                            </li>
					                            <li class="paginate_button page-item ">
					                            	<a href="#" aria-controls="dataTable" data-dt-idx="2" tabindex="0" class="page-link active">2</a>
					                            </li>
					                            <li class="paginate_button page-item next" id="dataTable_next">
					                            	<a href="#" aria-controls="dataTable" data-dt-idx="7" tabindex="0" class="page-link">Next</a>
					                            </li>
					                            
					                        </ul>
					                    </div>
					                </div>
				
			</div>
			</div>
			<c:import url="/WEB-INF/views/layout/footer.jsp"></c:import>
			</div>
	
	</div>
	
	
	
	
	
	<c:import url="/WEB-INF/views/layout/footjs.jsp"></c:import>
</body>
</html>