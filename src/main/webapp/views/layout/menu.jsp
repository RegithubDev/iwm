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
              		<img src="/iris/resources/images/logo/logo.png" class="logo" style="
    width: 10rem;
"></span>
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
				<%-- <li class=" nav-item bghover" id="sitemanagement"> <a class="d-flex align-items-center"
					href="<%=request.getContextPath() %>/sitemanagement"><svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="LocationOnOutlinedIcon"><path d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zM7 9c0-2.76 2.24-5 5-5s5 2.24 5 5c0 2.88-2.88 7.19-5 9.88C9.92 16.21 7 11.85 7 9z"></path><circle cx="12" cy="9" r="2.5"></circle></svg><span
						class="menu-title text-truncate" data-i18n="Chat">Site Management</span></a></li>
				<li class=" nav-item bghover" id="usermanagement"><a class="d-flex align-items-center"
					href="<%=request.getContextPath() %>/usermanagement"><svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="SupervisorAccountOutlinedIcon"><path d="M9 12c1.93 0 3.5-1.57 3.5-3.5S10.93 5 9 5 5.5 6.57 5.5 8.5 7.07 12 9 12zm0-5c.83 0 1.5.67 1.5 1.5S9.83 10 9 10s-1.5-.67-1.5-1.5S8.17 7 9 7zm.05 10H4.77c.99-.5 2.7-1 4.23-1 .11 0 .23.01.34.01.34-.73.93-1.33 1.64-1.81-.73-.13-1.42-.2-1.98-.2-2.34 0-7 1.17-7 3.5V19h7v-1.5c0-.17.02-.34.05-.5zm7.45-2.5c-1.84 0-5.5 1.01-5.5 3V19h11v-1.5c0-1.99-3.66-3-5.5-3zm1.21-1.82c.76-.43 1.29-1.24 1.29-2.18C19 9.12 17.88 8 16.5 8S14 9.12 14 10.5c0 .94.53 1.75 1.29 2.18.36.2.77.32 1.21.32s.85-.12 1.21-.32z"></path></svg><span
						class="menu-title text-truncate" data-i18n="Todo">User Management</span></a></li> --%>
				<li class=" nav-item bghover" id="datamanagement"><a class="d-flex align-items-center"
					href="<%=request.getContextPath() %>/iris-datamanagement"><svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="InsertChartOutlinedOutlinedIcon"><path d="M9 17H7v-7h2v7zm4 0h-2V7h2v10zm4 0h-2v-4h2v4zm2 2H5V5h14v14zm0-16H5c-1.1 0-2 .9-2 2v14c0 1.1.9 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2z"></path></svg><span
						class="menu-title text-truncate" data-i18n="Calendar">Data Management</span></a>
				</li>
				<li class=" nav-item bghover" id="settings"><a class="d-flex align-items-center"
					href="<%=request.getContextPath() %>/iris-settings"><i data-feather='settings'></i><span
						class="menu-title text-truncate " data-i18n="Calendar">Configuration</span></a>
				</li>
				<%-- <li class=" nav-item bghover" id="productcatalogue"><a class="d-flex align-items-center"
					href="<%=request.getContextPath() %>/productcatalogue"><svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="VisibilityOutlinedIcon"><path d="M12 6c3.79 0 7.17 2.13 8.82 5.5C19.17 14.87 15.79 17 12 17s-7.17-2.13-8.82-5.5C4.83 8.13 8.21 6 12 6m0-2C7 4 2.73 7.11 1 11.5 2.73 15.89 7 19 12 19s9.27-3.11 11-7.5C21.27 7.11 17 4 12 4zm0 5c1.38 0 2.5 1.12 2.5 2.5S13.38 14 12 14s-2.5-1.12-2.5-2.5S10.62 9 12 9m0-2c-2.48 0-4.5 2.02-4.5 4.5S9.52 16 12 16s4.5-2.02 4.5-4.5S14.48 7 12 7z"></path></svg><span
						class="menu-title text-truncate" data-i18n="Kanban">Product Catalogue</span></a>
				</li>
					<li class=" nav-item bghover" id="managementdasboard"><a class="d-flex align-items-center"
					href="<%=request.getContextPath() %>/managementdasboard"><svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="DesignServicesOutlinedIcon"><path d="M20.97 7.27c.39-.39.39-1.02 0-1.41l-2.83-2.83a.9959.9959 0 0 0-1.41 0l-4.49 4.49-3.89-3.89c-.78-.78-2.05-.78-2.83 0l-1.9 1.9c-.78.78-.78 2.05 0 2.83l3.89 3.89L3 16.76V21h4.24l4.52-4.52 3.89 3.89c.95.95 2.23.6 2.83 0l1.9-1.9c.78-.78.78-2.05 0-2.83l-3.89-3.89 4.48-4.48zM5.04 6.94l1.89-1.9L8.2 6.31 7.02 7.5l1.41 1.41 1.19-1.19 1.2 1.2-1.9 1.9-3.88-3.88zm11.23 7.44-1.19 1.19 1.41 1.41 1.19-1.19 1.27 1.27-1.9 1.9-3.89-3.89 1.9-1.9 1.21 1.21zM6.41 19H5v-1.41l9.61-9.61 1.3 1.3.11.11L6.41 19zm9.61-12.44 1.41-1.41 1.41 1.41-1.41 1.41-1.41-1.41z"></path></svg><span
						class="menu-title text-truncate" data-i18n="Kanban">Management Dasboard</span></a>
				</li>
					<li class=" nav-item bghover" id="helpdesk"><a class="d-flex align-items-center"
					href="<%=request.getContextPath() %>/helpdesk"><svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="HelpOutlineOutlinedIcon"><path d="M11 18h2v-2h-2v2zm1-16C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 18c-4.41 0-8-3.59-8-8s3.59-8 8-8 8 3.59 8 8-3.59 8-8 8zm0-14c-2.21 0-4 1.79-4 4h2c0-1.1.9-2 2-2s2 .9 2 2c0 2-3 1.75-3 5h2c0-2.25 3-2.5 3-5 0-2.21-1.79-4-4-4z"></path></svg><span
						class="menu-title text-truncate" data-i18n="Kanban">Help Desk</span></a>
				</li>
				<li class=" nav-item bghover" id="remainder"><a class="d-flex align-items-center"
					href="<%=request.getContextPath() %>/remainder"><svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="NotificationsNoneOutlinedIcon"><path d="M12 22c1.1 0 2-.9 2-2h-4c0 1.1.9 2 2 2zm6-6v-5c0-3.07-1.63-5.64-4.5-6.32V4c0-.83-.67-1.5-1.5-1.5s-1.5.67-1.5 1.5v.68C7.64 5.36 6 7.92 6 11v5l-2 2v1h16v-1l-2-2zm-2 1H8v-6c0-2.48 1.51-4.5 4-4.5s4 2.02 4 4.5v6z"></path></svg><span
						class="menu-title text-truncate" data-i18n="Kanban">Remainder</span></a>
				</li> --%>
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
	           		}else if(url.indexOf('site') != -1 || url.indexOf('/update-irm-form') != -1){
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