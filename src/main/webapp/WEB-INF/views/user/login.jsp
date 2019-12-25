<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>

<%@ include file="../include/head.jsp" %>

<body class="hold-transition sidebar-mini skin-blue">

    <div class="wrapper">
        <!-- Main Header -->
        <%@ include file="../include/main_header.jsp" %>
        
        <!-- Left side column. contains the logo and sidebar -->
        <%@ include file="../include/left_side.jsp"%>
        
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page Header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0 text-dark">로그인 페이지</h1>
                        </div>
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="${path }">Home</a></li>
                                <li class="breadcrumb-item active">Login Page</li>
                            </ol>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
            </div>
            <!-- /.content-header -->
            
            <!-- Main Content -->
            <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-6">
                            <div class="card card-info">
                                <div class="card-header">
                                    <h3 class="card-title">Login Form</h3>
                                </div>
                                <!-- /.card-header -->
                                <form class="form-horizontal">
                                    <div class="card-body">
                                        <div class="form-group row">
                                            <label for="userEmail" class="col-sm-2 col-form-label">Email</label>
                                            <div class="col-sm-10">
                                                <input type="email" class="form-control" id="userEmail" placeholder="Email">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="userPassword" class="col-sm-2 col-form-label">Password</label>
                                            <div class="col-sm-10">
                                                <input type="password" class="form-control" id="userPassword" placeholder="Password">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="offset-sm-2 col-sm-10">
                                                <div class="form-check">
                                                    <input type="checkbox" class="form-check-input" id="exampleCheck2">
                                                    <label class="form-check-label" for="exampleCheck2">Remember me</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.card-body -->
                                    <div class="card-footer">
                                        <button type="submit" class="btn btn-info" formaction="${path }/user/register">Sign up</button>
                                        <button type="submit" class="btn btn-default float-right" formaction="${path }/user/login">Sign in</button>
                                    </div>
                                    <!-- /.card-footer -->
                                </form>
                                <!-- /.form-horizontal -->
                            </div>
                            <!-- /.card -->
                        </div>
                        <!-- /.col -->
                        <div class="col-md-3"></div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->
        
        <!-- Main Footer -->
        <%@ include file="../include/main_footer.jsp" %>
        
    </div>
    <!-- /.wrapper -->
    
    <!-- Plugin Javascript -->
    <%@ include file="../include/plugin_js.jsp" %>
    
</body>
</html>