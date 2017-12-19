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
                                        <tr>
                                            <td>디지털신호처리시스템</td><td>이영렬 교수님</td>
                                            <td>
                                            	<a href ="${pageContext.servletContext.contextPath}/showScripts.do?name=001&number=1">열람</a>
                                                <!-- <button type="button" class="btn btn-light waves-effect waves-light btn-sm" id="sa-basic">열람</button> -->
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>선형대수</td><td>이영렬 교수님</td>
                                            <td>
                                            	<a href ="${pageContext.servletContext.contextPath}/showScripts.do?name=001&number=2">열람</a>
                                                <!-- <button type="button" class="btn btn-light waves-effect waves-light btn-sm" id="sa-basic">열람</button> -->
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>고전독서</td><td>이태하 교수님</td>
                                            <td>
                                            	<a href ="${pageContext.servletContext.contextPath}/showScripts.do?name=이태하&number=고전독서">열람</a>
                                                <!-- <button type="button" class="btn btn-light waves-effect waves-light btn-sm" id="sa-basic">열람</button> -->
                                            </td>
                                        </tr>
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
                    2017 - 2018 © Abstack. - Coderthemes.com
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