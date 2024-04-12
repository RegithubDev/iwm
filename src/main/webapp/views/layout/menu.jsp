<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menu</title>
<style>


div.main-menu-content {
  position: -webkit-sticky;
  position: sticky;
 
}
.horizontal-menu .header-navbar.navbar-horizontal ul#main-menu-navigation>li.active>a {
    background: #da0d14!important;
    box-shadow: 0 0 6px 1px rgb(240 103 103 / 60%)
    color: #FFF;
    border-radius: 4px;
}
</style>
</head>
<body>
    <div class="main-menu menu-fixed menu-accordion menu-shadow menu-light" data-scroll-to-active="true" style="touch-action: none; user-select: none; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
      <div class="navbar-header expanded">
        <ul class="nav navbar-nav flex-row">
          <li class="nav-item me-auto"><a class=" nav-item" href="<%=request.getContextPath() %>/home"><span class="">
              		<img src="/iwm/resources/images/logo/logo.svg" class="logo" style="
    width: 10rem;"></span>
              </a></li>
          <li class="nav-item nav-toggle"><a class="nav-link modern-nav-toggle pe-0" data-bs-toggle="collapse">
          <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-x d-block d-xl-none text-primary toggle-icon font-medium-4"><line x1="18" y1="6" x2="6" y2="18"></line><line x1="6" y1="6" x2="18" y2="18"></line></svg>
          <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-disc d-none d-xl-block collapse-toggle-icon primary font-medium-4"><circle cx="12" cy="12" r="10"></circle><circle cx="12" cy="12" r="3"></circle></svg></a></li>
        </ul>
      </div>
      <div class="shadow-bottom" style="display: none;"></div>
      <div class="main-menu-content ps" style="height: 291.625px;margin-top: 4rem;">
        <ul class="navigation navigation-main" id="main-menu-navigation" data-menu="menu-navigation">

				<li class=" nav-item bghover active" id="home"><a class="d-flex align-items-center"
					href="<%=request.getContextPath() %>/home"><svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="HomeOutlinedIcon"><path d="m12 5.69 5 4.5V18h-2v-6H9v6H7v-7.81l5-4.5M12 3 2 12h3v8h6v-6h2v6h6v-8h3L12 3z"></path></svg><span
				     		class="menu-title text-truncate" data-i18n="Email">Home</span></a></li>
				
				 <c:if test="${sessionScope.BASE_ROLE eq 'Admin'}">
					<li class=" nav-item bghover" id="settings"><a class="d-flex align-items-center"
						href="<%=request.getContextPath() %>/iwm-User"><i data-feather='settings'></i><span
						class="menu-title text-truncate " data-i18n="Calendar">User</span></a>
					</li>
				</c:if>
				
				
				
			</ul>
      <div class="ps__rail-x" style="left: 0px; bottom: 0px;"><div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div></div><div class="ps__rail-y" style="top: 0px; height: 292px; right: 0px;"><div class="ps__thumb-y" tabindex="0" style="top: 0px; height: 0px;"></div></div></div>
    </div>
        <script>
        var option = window.localStorage.getItem("selectedOption");
        $( document ).ready(function() {
       		var url = $(location).attr('href');
       		if(option != 'undefined' && option != null){
           		$('li.active').removeClass('active');
           		if(url.indexOf('user') != -1){
          			 $('#settings').addClass('active');
	           		}else if(url.indexOf('iwm-User') != -1 || url.indexOf('/update-irm-form') != -1){
	           			$('#settings').addClass('active');
	           		}else if(url.indexOf('data') != -1){
	           			$('#datamanagement').addClass('active');
	           		}else if(url.indexOf('product') != -1){
	           			$('#settings').addClass('active');
	           		}else if(url.indexOf('settings') != -1){
	           			$('#settings').addClass('active');
	           		}else if(url.indexOf('sbu') != -1){
	           			$('#settings').addClass('active');
	           		}else if(url.indexOf('category') != -1){
	           			$('#settings').addClass('active');
	           		}else if(url.indexOf('city') != -1){
	           			$('#settings').addClass('active');
	           		}else if(url.indexOf('state') != -1){
	           			$('#settings').addClass('active');
	           		}else if(url.indexOf('role') != -1){
	           			$('#settings').addClass('active');
	           		}else if(url.indexOf('management') != -1){
	           			$('#managementdasboard').addClass('active');
	           		}else if(url.indexOf('/helpdesk') != -1){
	           			$('#helpdesk').addClass('active');
	           		}else if(url.indexOf('/remainder') != -1){
	           			$('#remainder').addClass('active');
	           		}else{
	           			$('#home').addClass('active');
	           		}
           	}
        });
        </script>
</body>
</html>