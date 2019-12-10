<%@ page language="java" contentType="text/html; charset=utf-8" %>
<html>

<%@ include file="include/head.jsp"%>

<body class="hold-transition skin-blue">

<div class="wrapper">

    <!-- Main Header -->
    <%@ include file="include/main_header.jsp"%>
    
    <!-- Left side column. contains the logo and sidebar -->
    <%@ include file="include/left_side.jsp"%>
    
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                            메인 페이지
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}/"><i class="fa fa-dashboard"></i> home</a></li>
            </ol>
        </section>
        
        <!-- Main content -->
        <section class="content container-fluid">
            <p>메인 페이지입니다.</p>
            컨텍스크 경로 : ${pageContext.request.contextPath}  ${path }
        </section>
    </div>
    <!-- ./content-wrapper -->
    
    <!-- Main Footer -->
    <%@ include file="include/main_footer.jsp"%>

</div>
<!-- ./wrapper -->

<%@ include file="include/plugin_js.jsp" %>

</body>
</html>