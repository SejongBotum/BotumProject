<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="topbar">

    <!-- LOGO -->
    <div class="topbar-left">
        <a href="${pageContext.request.contextPath}/home.do" class="logo">
                            <span>
                                <img src="${pageContext.servletContext.contextPath}/frontAssets/images/logo.png" alt="" height="16">
                            </span>
            <i>
                <img src="${pageContext.servletContext.contextPath}/frontAssets/images/logo_sm.png" alt="" height="28">
            </i>
        </a>
    </div>

    <nav class="navbar-custom">

        <ul class="list-unstyled topbar-right-menu float-right mb-0">
        
            <li class="dropdown notification-list">
                <a class="nav-link dropdown-toggle arrow-none waves-light waves-effect" data-toggle="dropdown" href="#" role="button"
                   aria-haspopup="false" aria-expanded="false">
<!--                     <i class="fi-bell noti-icon"></i>
                    <span class="badge badge-danger badge-pill noti-icon-badge">4</span> -->
                </a>
                <div class="dropdown-menu dropdown-menu-right dropdown-lg">

                    <!-- item-->
                    <div class="dropdown-item noti-title">
                        <h6 class="m-0"><span class="float-right"><a href="" class="text-dark"><small>Clear All</small></a> </span>Notification</h6>
                    </div>

                    <div class="slimscroll" style="max-height: 190px;">
                    </div>

                    <!-- All-->
                    <a href="javascript:void(0);" class="dropdown-item text-center text-primary notify-item notify-all">
                        View all <i class="fi-arrow-right"></i>
                    </a>
                </div>
            </li>

            <li class="dropdown notification-list">
                <a class="nav-link dropdown-toggle arrow-none waves-light waves-effect" data-toggle="dropdown" href="#" role="button"
                   aria-haspopup="false" aria-expanded="false">
<!--                     <i class="fi-speech-bubble noti-icon"></i>
                    <span class="badge badge-light badge-pill noti-icon-badge">6</span> -->
                </a>
                <div class="dropdown-menu dropdown-menu-right dropdown-lg">

                    <!-- item-->
                    <div class="dropdown-item noti-title">
                        <h6 class="m-0"><span class="float-right"><a href="" class="text-dark"><small>Clear All</small></a> </span>Chat</h6>
                    </div>
					
                    <div class="slimscroll" style="max-height: 190px;">
                    </div>

                    <!-- All-->
                    <a href="javascript:void(0);" class="dropdown-item text-center text-primary notify-item notify-all">
                        View all <i class="fi-arrow-right"></i>
                    </a>

                </div>
            </li>

            <li class="dropdown notification-list">
                <a class="nav-link dropdown-toggle waves-effect waves-light nav-user" data-toggle="dropdown" href="#" role="button"
                   aria-haspopup="false" aria-expanded="false">
                    <img src="${pageContext.servletContext.contextPath}/frontAssets/images/users/avatar-1.jpg" alt="user" class="rounded-circle"> <span class="ml-1">${sessionScope.mvo.id}<i class="mdi mdi-chevron-down"></i> </span>
                </a>
                <div class="dropdown-menu dropdown-menu-right profile-dropdown ">
                    <!-- item-->
                    <div class="dropdown-item noti-title">
                        <h6 class="text-overflow m-0">Welcome !</h6>
                    </div>
                    
                    <!-- item-->
                    <a href="" class="dropdown-item notify-item" data-toggle="modal" data-target=".bs-example-modal-lg">
                        <i class="fi-paper"></i> <span>material upload</span>
                    </a>
                    <!-- item-->
                    <a href="${pageContext.servletContext.contextPath}/logout.do" class="dropdown-item notify-item">
                        <i class="fi-power"></i> <span>Logout</span>
                    </a>

                </div>
            </li>

        </ul>

        <ul class="list-inline menu-left mb-0">
            <li class="float-left">
                <button class="button-menu-mobile open-left waves-light waves-effect">
                    <i class="dripicons-menu"></i>
                </button>
            </li>
        </ul>

    </nav>

</div>
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" style="display: none;">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h5 class="modal-title" id="myLargeModalLabel">업로드 할 과목과 파일을 선택하세요.</h5>
			</div>
			<div class="modal-body" align="center">
				<form enctype="multipart/form-data" method="post"
					action="${pageContext.request.contextPath }/uploadFile.do" class="form-horizontal ">
					<select class="form-control select2" name="dir">
						<option>Select</option>
							<c:forEach items="${list}" var="lect" varStatus="stat">
							<option value="${lect.number}">${lect.name}</option>
							</c:forEach>	
					</select>
					<br>
					<input type="file" name= "file" class="btn-secondary">
					<input type="submit" class="btn btn-gradient btn-file" value="업로드">
				</form>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->



