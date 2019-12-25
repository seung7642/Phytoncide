<%@ page language="java" contentType="text/html; charset=utf-8"%>

<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="index3.html" class="brand-link"> <img
		src="${path }/dist/img/AdminLTELogo.png" alt="AdminLTE Logo"
		class="brand-image img-circle elevation-3" style="opacity: .8">
		<span class="brand-text font-weight-light">Phytoncide</span>
	</a>

	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel (optional) -->
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<c:if test="${empty login}">
				<div class="image">
					<img src="${path }/resources/upload/user/default-user.png"
						class="img-circle elevation-2" alt="User Image">
				</div>
				<div class="info">
					<a href="#" class="d-block"> OFFLINE</a>
				</div>
			</c:if>
			<c:if test="${! empty login}">
				<div class="image">
					<img src="/${login.userImg}" class="img-circle elevation-2"
						alt="User Image">
				</div>
				<div class="pull-left info">
					<a href="#" class="d-block"> ONLINE</a>
				</div>
			</c:if>
		</div>

		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column" data-widget="tree"
				role="menu" data-accordion="false">
				<!-- Add icons to the links using the .nav-icon class
                     with font-awesome or any other icon font library -->
				<li class="nav-item has-treeview menu-open"><a href="#"
					class="nav-link active"> <i
						class="nav-icon fas fa-tachometer-alt"></i>
						<p>
							가게 자원 관리 <i class="right fas fa-angle-left"></i>
						</p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item"><a href="sales/" class="nav-link active"> <i
								class="far fa-circle nav-icon"></i>
								<p>매출 관리</p>
						</a></li>
						<li class="nav-item"><a href="employee/" class="nav-link">
								<i class="far fa-circle nav-icon"></i>
								<p>직원 관리</p>
						</a></li>
						<li class="nav-item"><a href="asset/" class="nav-link"> <i
								class="far fa-circle nav-icon"></i>
								<p>자산 관리</p>
						</a></li>
					</ul></li>
				<li class="nav-item"><a href="article/list/" class="nav-link"> <i
						class="nav-icon fas fa-th"></i>
						<p>
							기록 페이지 <span class="right badge badge-danger">New</span>
						</p>
				</a></li>
			</ul>
		</nav>
		<!-- /.sidebar-menu -->
	</section>
	<!-- /.sidebar -->
</aside>