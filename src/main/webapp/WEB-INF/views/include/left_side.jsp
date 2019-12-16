<%@ page language="java" contentType="text/html; charset=utf-8" %>

<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index3.html" class="brand-link">
      <img src="/${path }/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
           style="opacity: .8">
      <span class="brand-text font-weight-light">AdminLTE 3</span>
    </a>

	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <c:if test="${empty login}">
                <div class="image">
                    <img src="${path }/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    <p>Guest</p>
                    <a href="#" class="d-block"><i class="fa fa-circle text-danger"></i> OFFLINE</a>
                </div>
            </c:if>
            <c:if test="${! empty login}">
                <div class="image">
                    <img src="/${login.userImg}" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>${login.userName}</p>
                    <a href="#" class="d-block"><i class="fa fa-circle text-success"></i> ONLINE</a>
                </div>
            </c:if>
        </div>
        
        <!-- Sidebar Menu -->
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="tree" role="menu" data-accordion="false">
                <!-- Add icons to the links using the .nav-icon class
                     with font-awesome or any other icon font library -->
                <li class="nav-item has-treeview menu-open">
                    <a href="#" class="nav-link active">
                        <i class="nav-icon fas fa-tachometer-alt"></i>
                        <p>
                                                가게 자원 관리 
                        <i class="right fas fa-angle-left"></i>
                        </p>
		            </a>
		            <ul class="nav nav-treeview">
		                <li class="nav-item">
		                    <a href="#" class="nav-link active">
		                        <i class="far fa-circle nav-icon"></i>
		                        <p>Active Page</p>
		                    </a>
		                </li>
		                <li class="nav-item">
		                    <a href="#" class="nav-link">
		                        <i class="far fa-circle nav-icon"></i>
		                        <p>Inactive Page</p>
		                    </a>
		                </li>
		                <li class="nav-item">
                            <a href="sales/" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>매출 관리</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="employee/" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>직원 관리</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="asset/" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>자산 관리</p>
                            </a>
                        </li>
		            </ul>
		        </li>
	            <li class="header">Record</li>
	            <li class="treeview">
	                <a href="#"><i class="fa fa-edit"></i> <span>게시판</span>
	                    <span class="pull-right-container">
	                        <i class="fa fa-angle-left pull-right"></i>
	                    </span>
	                </a>
	                <ul class="treeview-menu">
	                    <li><a href="${path}/article/paging/search/list"><i class="fa fa-list"></i> 게시글 목록</a></li>
	                </ul>
	            </li>
	        </ul>
        </nav>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>