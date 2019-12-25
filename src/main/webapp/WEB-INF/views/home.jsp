<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>

<%@ include file="include/head.jsp"%>

<body class="hold-transition sidebar-mini skin-blue">
	<div class="wrapper">
		<!-- Main Header -->
		<%@ include file="include/main_header.jsp"%>

		<!-- Left side column. contains the logo and sidebar -->
		<%@ include file="include/left_side.jsp"%>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0 text-dark">관리 페이지</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="javascript:void(0)">Home</a></li>
								<li class="breadcrumb-item active">Admin Page</li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-6">
							<div class="card">
								<div class="card-header border-0">
									<div class="d-flex justify-content-between">
										<h3 class="card-title">온라인 스토어 방문객</h3>
										<a href="javascript:void(0);">View Report</a>
									</div>
								</div>
								<div class="card-body">
									<div class="d-flex">
										<p class="d-flex flex-column">
											<span class="text-bold text-lg">820명</span> <span>Visitors
												Over Time</span>
										</p>
										<p class="ml-auto d-flex flex-column text-right">
											<span class="text-success"> <i class="fas fa-arrow-up"></i>
												12.5%
											</span> <span class="text-muted">Since last week</span>
										</p>
									</div>
									<!-- /.d-flex -->

									<div class="position-relative mb-4">
										<canvas id="visitors-chart" height="200"></canvas>
									</div>

									<div class="d-flex flex-row justify-content-end">
										<span class="mr-2"> <i
											class="fas fa-square text-primary"></i> 올해
										</span> <span> <i class="fas fa-square text-gray"></i> 작년
										</span>
									</div>
								</div>
							</div>
							<!-- /.card -->
						</div>
						<!-- /.col-md-6 -->


						<div class="col-lg-6">
							<div class="card">
								<div class="card-header border-0">
									<div class="d-flex justify-content-between">
										<h3 class="card-title">가게 매출 관리</h3>
										<a href="javascript:void(0);">View Report</a>
									</div>
								</div>
								<div class="card-body">
									<div class="d-flex">
										<p class="d-flex flex-column">
											<span class="text-bold text-lg">18,230원</span> <span>Sales
												Over Time</span>
										</p>
										<p class="ml-auto d-flex flex-column text-right">
											<span class="text-success"> <i class="fas fa-arrow-up"></i>
												33.1%
											</span> <span class="text-muted">Since last month</span>
										</p>
									</div>
									<!-- /.d-flex -->

									<div class="position-relative mb-4">
										<canvas id="sales-chart" height="200"></canvas>
									</div>

									<div class="d-flex flex-row justify-content-end">
										<span class="mr-2"> <i
											class="fas fa-square text-primary"></i> 올해
										</span> <span> <i class="fas fa-square text-gray"></i> 작년
										</span>
									</div>
								</div>
							</div>
							<!-- /.card -->
						</div>
						<!-- /.col-lg-6 -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content -->
		</div>
		<!-- ./content-wrapper -->

		<!-- Main Footer -->
		<%@ include file="include/main_footer.jsp"%>

	</div>
	<!-- ./wrapper -->

	<%@ include file="include/plugin_js.jsp"%>
	<script src="${path }/resources/myDist/dataset_sales.js"></script>
	<script src="${path }/resources/myDist/dataset_visitors.js"></script>
</body>
</html>