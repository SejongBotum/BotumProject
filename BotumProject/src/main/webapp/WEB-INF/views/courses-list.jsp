<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>BOTUM</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />

        <!-- App favicon -->
        <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/frontAssets/images/favicon.ico">

        <!-- Sweet Alert css -->
        <link href="${pageContext.servletContext.contextPath}/frontAssets/plugins/sweet-alert/sweetalert2.min.css" rel="stylesheet" type="text/css" />

        <!-- App css -->
        <link href="${pageContext.servletContext.contextPath}/frontAssets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.servletContext.contextPath}/frontAssets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.servletContext.contextPath}/frontAssets/css/metismenu.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.servletContext.contextPath}/frontAssets/css/style.css" rel="stylesheet" type="text/css" />

        <script src="${pageContext.servletContext.contextPath}/frontAssets/js/modernizr.min.js"></script>

    </head>


    <body>
		<jsp:include page="layout/session-check.jsp"></jsp:include>
        <!-- Begin page -->
        <div id="wrapper">

            <!-- Top Bar Start -->
            <jsp:include page="layout/topbar.jsp"></jsp:include>
            <!-- Top Bar End -->


            <!-- ========== Left Sidebar Start ========== -->
            <jsp:include page="layout/leftside.jsp"></jsp:include>            
            <!-- Left Sidebar End -->



            <!-- ============================================================== -->
            <!-- Start right Content here -->
            <!-- ============================================================== -->
            <div class="content-page">
                <!-- Start content -->
                <div class="content">
                    <div class="container-fluid">

                        <div class="row">
                            <div class="col-12">
                                <div class="page-title-box">
                                    <h3 class="page-title float-left">강의 목록</h3>

                                    <ol class="breadcrumb float-right">
                                        <li class="breadcrumb-item"><a href="#">강의 목록</a></li>
                                    </ol>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->


                        <div class="row">
                            <div class="col-lg-12">
                                <div class="card-box">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th style="min-width:50%;">목록</th>
                                            <th>정보</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${list}" var="lect" varStatus="stat">
                                        <tr>
                                            <td>${lect.name}</td>
                                            <td>
                                            	<a href ="${pageContext.servletContext.contextPath}/showScripts.do?fileName=${lect.name}&dir=${lect.number}">열람</a>
                                                <!-- <button type="button" class="btn btn-light waves-effect waves-light btn-sm" id="sa-basic">열람</button> -->
                                            </td>
                                        </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                </div> <!-- end card-box -->
                            </div>
                            <!-- end col -->

                        </div>
                        <!-- end row -->


                    </div> <!-- container -->

                </div> <!-- content -->

                <footer class="footer text-right">
                    2017 Botum - Sejong Hackerthon
                </footer>

            </div>


            <!-- ============================================================== -->
            <!-- End Right content here -->
            <!-- ============================================================== -->


        </div>
        <!-- END wrapper -->



		<jsp:include page="layout/footer.jsp"></jsp:include>

        <!-- Sweet Alert Js  -->
        <script src="${pageContext.servletContext.contextPath}/frontAssets/plugins/sweet-alert/sweetalert2.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/frontAssets/pages/jquery.sweet-alert.init.js"></script>

    </body>
</html>