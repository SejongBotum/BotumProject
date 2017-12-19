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
        <jsp:include page="layout/css.jsp"></jsp:include>
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
                                    <h4 class="page-title float-left">Scripts</h4>

                                    <ol class="breadcrumb float-right">
                                        <li class="breadcrumb-item"><a href="#">${param.name} 교수님</a></li>
                                        <li class="breadcrumb-item"><a href="#">${param.number} </a></li>
                                        <li class="breadcrumb-item active">분반번호 1</li>
                                    </ol>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->
                        <div class="form-group row">
                        </div>
 						<div class="row">
                            <div class="col-md-12">
                                <div class="card-box">
                                    <div class="row">
		                                <!-- Simple card -->
			                            <div class="col-md-6 col-lg-6">
			                                <div class="card m-b-30">
			                                <iframe style = "size: witdth:100%;height:500px;" src = "${pageContext.servletContext.contextPath}/scripts/${param.number}/material.pdf"></iframe>
			                                </div>
			                            </div>
		                            	<!-- card -->
                                        <div class="col-6">
                                            <h3 class="m-t-0 header-title">본문</h3>
											<p class="card-text" id="script"></p>
										</div>
                                            <div class="clearfix"></div>
                                        </div>

                                    </div>
                                    <!-- end row -->
                                </div>
                            </div>

                        </div>
                        <!-- end row -->
                    </div> <!-- container -->
                </div> <!-- content -->

                <footer class="footer text-right">
                </footer>

            </div>


            <!-- ============================================================== -->
            <!-- End Right content here -->
            <!-- ============================================================== -->
        </div>
        
        <!-- END wrapper -->
		<jsp:include page="layout/footer.jsp"></jsp:include>
		
		<!-- Ajax -->
		
		<script type="text/javascript">
			$(document).ready(function(){
				getContent();
			});
			function getContent(){
				$.getJSON("getScripts.do?name=${number}&number=${name}", function(data){
					$("#script").html(data.content);
				});
				setTimeout("getContent()", 2000);
			}
		</script>
    </body>
</html>