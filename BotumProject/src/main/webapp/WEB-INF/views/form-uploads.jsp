<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*,com.oreilly.servlet.*,com.oreilly.servlet.multipart.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Abstack - Responsive Web App Kit</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />

        <jsp:include page="layout/css.jsp"></jsp:include>
        <!-- Bootstrap fileupload css -->
        <link href="${pageContext.servletContext.contextPath}/frontAssets/plugins/bootstrap-fileupload/bootstrap-fileupload.css" rel="stylesheet" />



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
                                    <h4 class="page-title float-left">파일 업로드</h4>

                                    <ol class="breadcrumb float-right">
                                        <li class="breadcrumb-item"><a href="#">업로드</a></li>
                                    </ol>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->

                        <div class="row">
                            <div class="col-12">
                                <div class="card-box">
                                    <h4 class="header-title m-t-0">File Upload</h4>
									
                                    <form action="#" class="form-horizontal ">
                                        <div class="form-group row">
                                            <label class="col-3 col-form-label">파일을 선택하세요.</label>
                                            <div class="controls col-9">
                                                <div class="fileupload fileupload-new" data-provides="fileupload">
                                                    <button type="button" class="btn btn-gradient btn-file">
                                                        <span class="fileupload-new"><i class="fa fa-paper-clip"></i> Select file</span>
                                                        <span class="fileupload-exists"><i class="fa fa-undo"></i> Change</span>
                                                        <input type="file" class="btn-secondary" />
                                                    </button>
                                                    <span class="fileupload-preview" style="margin-left:5px;"></span>
                                                    <a href="#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none; margin-left:5px;"></a>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!--  end row -->

                    </div> <!-- container -->

                </div> <!-- content -->

            </div>


            <!-- ============================================================== -->
            <!-- End Right content here -->
            <!-- ============================================================== -->


        </div>
        <!-- END wrapper -->
		<jsp:include page="layout/footer.jsp"></jsp:include>
		
        <!-- Bootstrap fileupload js -->
        <script src="${pageContext.servletContext.contextPath}/frontAssets/plugins/bootstrap-fileupload/bootstrap-fileupload.js"></script>

    </body>
</html>