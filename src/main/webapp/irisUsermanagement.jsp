
<!DOCTYPE html>
<!--
Template Name: Vuexy - Vuejs, HTML & Laravel Admin Dashboard Template
Author: PixInvent
Website: http://www.pixinvent.com/
Contact: hello@pixinvent.com
Follow: www.twitter.com/pixinvents
Like: www.facebook.com/pixinvents
Purchase: https://1.envato.market/vuexy_admin
Renew Support: https://1.envato.market/vuexy_admin
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.

-->
<html class="loading" lang="en" data-textdirection="ltr">
  <!-- BEGIN: Head-->
  
<!-- Mirrored from pixinvent.com/demo/vuexy-html-bootstrap-admin-template/html/ltr/horizontal-menu-template/app-email.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 07 Aug 2022 05:35:38 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0,minimal-ui">
    <meta name="description" content="Vuexy admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, Vuexy admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Home</title>
    <link rel="apple-touch-icon" href="/iris/resources//images/ico/apple-icon-120.html">
    <link rel="shortcut icon" type="image/x-icon" href="https://pixinvent.com/demo/vuexy-html-bootstrap-admin-template/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,300;0,400;0,500;0,600;1,400;1,500;1,600" rel="stylesheet">

    <!-- BEGIN: Vendor CSS-->
    <link rel="stylesheet" type="text/css" href="/iris/resources//vendors/css/vendors.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources//vendors/css/editors/quill/katex.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources//vendors/css/editors/quill/monokai-sublime.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources//vendors/css/editors/quill/quill.snow.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources//vendors/css/extensions/toastr.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources//vendors/css/forms/select/select2.min.css">
    <link rel="preconnect" href="https://fonts.gstatic.com/">
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css2?family=Inconsolata&amp;family=Roboto+Slab&amp;family=Slabo+27px&amp;family=Sofia&amp;family=Ubuntu+Mono&amp;display=swap">
    <!-- END: Vendor CSS-->

    <!-- BEGIN: Theme CSS-->
    <link rel="stylesheet" type="text/css" href="/iris/resources//css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources//css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources//css/colors.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources//css/components.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources//css/themes/dark-layout.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources//css/themes/bordered-layout.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources//css/themes/semi-dark-layout.min.css">

    <!-- BEGIN: Page CSS-->
    <link rel="stylesheet" type="text/css" href="/iris/resources//css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources//css/plugins/forms/form-quill-editor.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources//css/plugins/extensions/ext-component-toastr.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources//css/pages/app-email.min.css">
    <!-- END: Page CSS-->

    <!-- BEGIN: Custom CSS-->
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/style.css">
    <!-- END: Custom CSS-->
<style>
.badge i, .badge svg {
    height: 28px!important;
    width: 28px;
    font-size: 12px;
    stroke-width: 3;
    vertical-align: top;
    color: black;
}
.list-group-item {
    position: relative;
    display: block;
    padding: 0.75rem 1.25rem;
    color: #000000;
    background-color: #FFF;
    border: 1px solid rgba(34,41,47,.125);
}

.menu-hide{
	display:none;
}
.show-icon{
	display:block;
}
.horizontal-layout.navbar-floating:not(.blank-page) .app-content {
      padding: calc(0rem + 1.57rem* 2 + 1.3rem) 0rem 0;
}
</style>
  </head>
  <!-- END: Head-->

  <!-- BEGIN: Body-->
  <body class="horizontal-layout horizontal-menu content-left-sidebar navbar-floating footer-static  " data-open="hover" data-menu="horizontal-menu" data-col="content-left-sidebar">

    <!-- BEGIN: Header-->
    <jsp:include page="../views/layout/header.jsp"></jsp:include>
    <!-- END: Header-->


    <!-- BEGIN: Main Menu-->
    <div class="horizontal-menu-wrapper">
    </div>
    <!-- END: Main Menu-->

    <!-- BEGIN: Content-->
    <div class="app-content content email-application">
      <div class="content-overlay"></div>
     <!--  <div class="header-navbar-shadow"></div> -->
      <div class="content-area-wrapper container-xxl p-0" style="
    height: 100%;
">
        <div class="sidebar-left">
          <div class="sidebar">
          <div class="sidebar-content email-app-sidebar" id="menuDiv">
  <div class="email-app-menu shadow-right">
  <div class="pricing-badge text-end p-2">
                <a
        type="button"
        class=" badge rounded-pill badge-light-primary"
        data-bs-backdrop="false"
        data-bs-toggle="modal"
        data-bs-target="#compose-mail" onclick="strinkMenu();"
      >
        <i data-feather='chevrons-left' class="menuList"></i>
        <i data-feather='align-justify' class="menu-hide showIcon"></i>
        
      </a>
              </div>
   <!--  <div class="form-group-compose text-center compose-btn">
      <a
        type="button"
        class="compose-email   w-20"
        data-bs-backdrop="false"
        data-bs-toggle="modal"
        data-bs-target="#compose-mail" onclick="strinkMenu();"
      >
        <i data-feather='x' class="menuList"></i>
        <i data-feather='align-justify' class="menu-hide showIcon"></i>
        
      </a>
    </div> -->
    <div class="sidebar-menu-list">
      <div class="list-group list-group-messages ">
        <a href="<%=request.getContextPath() %>/home" class="list-group-item list-group-item-action active bghover p-1  ">
        <svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium svglogo  css-vubbuv" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="HomeOutlinedIcon"><path d="m12 5.69 5 4.5V18h-2v-6H9v6H7v-7.81l5-4.5M12 3 2 12h3v8h6v-6h2v6h6v-8h3L12 3z"></path></svg>
          <span class="align-middle menuList ">Home</span>
        </a>
         <a href="<%=request.getContextPath() %>/home" class="list-group-item list-group-item-action  bghover p-1  ">
        <svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium svglogo  css-vubbuv" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="LocationOnOutlinedIcon"><path d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zM7 9c0-2.76 2.24-5 5-5s5 2.24 5 5c0 2.88-2.88 7.19-5 9.88C9.92 16.21 7 11.85 7 9z"></path><circle cx="12" cy="9" r="2.5"></circle></svg>
          <span class="align-middle menuList ">Site Management</span>
        </a>
         <a href="<%=request.getContextPath() %>/home" class="list-group-item list-group-item-action  bghover p-1  ">
       <svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium svglogo css-vubbuv" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="SupervisorAccountOutlinedIcon"><path d="M9 12c1.93 0 3.5-1.57 3.5-3.5S10.93 5 9 5 5.5 6.57 5.5 8.5 7.07 12 9 12zm0-5c.83 0 1.5.67 1.5 1.5S9.83 10 9 10s-1.5-.67-1.5-1.5S8.17 7 9 7zm.05 10H4.77c.99-.5 2.7-1 4.23-1 .11 0 .23.01.34.01.34-.73.93-1.33 1.64-1.81-.73-.13-1.42-.2-1.98-.2-2.34 0-7 1.17-7 3.5V19h7v-1.5c0-.17.02-.34.05-.5zm7.45-2.5c-1.84 0-5.5 1.01-5.5 3V19h11v-1.5c0-1.99-3.66-3-5.5-3zm1.21-1.82c.76-.43 1.29-1.24 1.29-2.18C19 9.12 17.88 8 16.5 8S14 9.12 14 10.5c0 .94.53 1.75 1.29 2.18.36.2.77.32 1.21.32s.85-.12 1.21-.32z"></path></svg>
          <span class="align-middle menuList ">User Management</span>
        </a>
         <a href="<%=request.getContextPath() %>/home" class="list-group-item list-group-item-action  bghover p-1  ">
     <svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium svglogo css-vubbuv" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="InsertChartOutlinedOutlinedIcon"><path d="M9 17H7v-7h2v7zm4 0h-2V7h2v10zm4 0h-2v-4h2v4zm2 2H5V5h14v14zm0-16H5c-1.1 0-2 .9-2 2v14c0 1.1.9 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2z"></path></svg>
          <span class="align-middle menuList ">Data Management</span>
        </a>
         <a href="<%=request.getContextPath() %>/home" class="list-group-item list-group-item-action  bghover p-1  ">
         <svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium svglogo css-vubbuv" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="VisibilityOutlinedIcon"><path d="M12 6c3.79 0 7.17 2.13 8.82 5.5C19.17 14.87 15.79 17 12 17s-7.17-2.13-8.82-5.5C4.83 8.13 8.21 6 12 6m0-2C7 4 2.73 7.11 1 11.5 2.73 15.89 7 19 12 19s9.27-3.11 11-7.5C21.27 7.11 17 4 12 4zm0 5c1.38 0 2.5 1.12 2.5 2.5S13.38 14 12 14s-2.5-1.12-2.5-2.5S10.62 9 12 9m0-2c-2.48 0-4.5 2.02-4.5 4.5S9.52 16 12 16s4.5-2.02 4.5-4.5S14.48 7 12 7z"></path></svg>
          <span class="align-middle menuList ">Product Catalogue</span>
        </a>
         <a href="<%=request.getContextPath() %>/home" class="list-group-item list-group-item-action  bghover p-1  ">
        <svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium svglogo css-vubbuv" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="DesignServicesOutlinedIcon"><path d="M20.97 7.27c.39-.39.39-1.02 0-1.41l-2.83-2.83a.9959.9959 0 0 0-1.41 0l-4.49 4.49-3.89-3.89c-.78-.78-2.05-.78-2.83 0l-1.9 1.9c-.78.78-.78 2.05 0 2.83l3.89 3.89L3 16.76V21h4.24l4.52-4.52 3.89 3.89c.95.95 2.23.6 2.83 0l1.9-1.9c.78-.78.78-2.05 0-2.83l-3.89-3.89 4.48-4.48zM5.04 6.94l1.89-1.9L8.2 6.31 7.02 7.5l1.41 1.41 1.19-1.19 1.2 1.2-1.9 1.9-3.88-3.88zm11.23 7.44-1.19 1.19 1.41 1.41 1.19-1.19 1.27 1.27-1.9 1.9-3.89-3.89 1.9-1.9 1.21 1.21zM6.41 19H5v-1.41l9.61-9.61 1.3 1.3.11.11L6.41 19zm9.61-12.44 1.41-1.41 1.41 1.41-1.41 1.41-1.41-1.41z"></path></svg>
          <span class="align-middle menuList ">Management Dashboard</span>
        </a>
      
         <a href="<%=request.getContextPath() %>/home" class="list-group-item list-group-item-action bghover p-1 ">
        <svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium svglogo css-vubbuv" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="HelpOutlineOutlinedIcon"><path d="M11 18h2v-2h-2v2zm1-16C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 18c-4.41 0-8-3.59-8-8s3.59-8 8-8 8 3.59 8 8-3.59 8-8 8zm0-14c-2.21 0-4 1.79-4 4h2c0-1.1.9-2 2-2s2 .9 2 2c0 2-3 1.75-3 5h2c0-2.25 3-2.5 3-5 0-2.21-1.79-4-4-4z"></path></svg>
          <span class="align-middle menuList ">Help Center</span>
        </a>
         <a href="<%=request.getContextPath() %>/home" class="list-group-item list-group-item-action  bghover p-1  ">
         <svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium svglogo css-vubbuv" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="NotificationsNoneOutlinedIcon"><path d="M12 22c1.1 0 2-.9 2-2h-4c0 1.1.9 2 2 2zm6-6v-5c0-3.07-1.63-5.64-4.5-6.32V4c0-.83-.67-1.5-1.5-1.5s-1.5.67-1.5 1.5v.68C7.64 5.36 6 7.92 6 11v5l-2 2v1h16v-1l-2-2zm-2 1H8v-6c0-2.48 1.51-4.5 4-4.5s4 2.02 4 4.5v6z"></path></svg>
          <span class="align-middle menuList ">Reminder</span>
        </a>
        
      </div>
      <!-- <hr /> -->
    </div>
  </div>
</div>

          </div>
        </div>
        <div class="content-right">
          <div class="content-wrapper container-xxl p-0">
            <div class="content-header row">
									            <div class="sidebar-toggle d-block d-lg-none ms-1">
											      <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-menu font-medium-5"><line x1="3" y1="12" x2="21" y2="12"></line><line x1="3" y1="6" x2="21" y2="6"></line><line x1="3" y1="18" x2="21" y2="18"></line></svg>
											    </div>
            </div>
            <div class="content-body"><div class="body-content-overlay"></div>
<div class="col-12 p-2" id="bigDiv">
      <div class="card">
        <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper dt-bootstrap5 no-footer"><div class="card-header border-bottom p-1"><div class="head-label"><h6 class="mb-0">DataTable with Buttons</h6></div><div class="dt-action-buttons text-end"><div class="dt-buttons d-inline-flex"> <button class="dt-button buttons-collection btn btn-outline-secondary dropdown-toggle me-2" tabindex="0" aria-controls="DataTables_Table_0" type="button" aria-haspopup="true"><span><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-share font-small-4 me-50"><path d="M4 12v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-8"></path><polyline points="16 6 12 2 8 6"></polyline><line x1="12" y1="2" x2="12" y2="15"></line></svg>Export</span></button> <button class="dt-button create-new btn btn-primary" tabindex="0" aria-controls="DataTables_Table_0" type="button" data-bs-toggle="modal" data-bs-target="#modals-slide-in"><span><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus me-50 font-small-4"><line x1="12" y1="5" x2="12" y2="19"></line><line x1="5" y1="12" x2="19" y2="12"></line></svg>Add New Record</span></button> </div></div></div><div class="d-flex justify-content-between align-items-center mx-0 row"><div class="col-sm-12 col-md-6"><div class="dataTables_length" id="DataTables_Table_0_length"><label>Show <select name="DataTables_Table_0_length" aria-controls="DataTables_Table_0" class="form-select"><option value="7">7</option><option value="10">10</option><option value="25">25</option><option value="50">50</option><option value="75">75</option><option value="100">100</option></select> entries</label></div></div><div class="col-sm-12 col-md-6"><div id="DataTables_Table_0_filter" class="dataTables_filter"><label>Search:<input type="search" class="form-control" placeholder="" aria-controls="DataTables_Table_0"></label></div></div></div><table class="datatables-basic table dataTable no-footer dtr-column" id="DataTables_Table_0" role="grid" aria-describedby="DataTables_Table_0_info" style="width: 1298px;">
          <thead>
            <tr role="row"><th class="control sorting_disabled" rowspan="1" colspan="1" style="width: 41px; display: none;" aria-label=""></th><th class="sorting_disabled dt-checkboxes-cell dt-checkboxes-select-all" rowspan="1" colspan="1" style="width: 41px;" data-col="1" aria-label=""><div class="form-check"> <input class="form-check-input" type="checkbox" value="" id="checkboxSelectAll"><label class="form-check-label" for="checkboxSelectAll"></label></div></th><th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 128px;" aria-label="Name: activate to sort column ascending">Name</th><th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 132px;" aria-label="Email: activate to sort column ascending">Email</th><th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 119px;" aria-label="Date: activate to sort column ascending">Date</th><th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 152px;" aria-label="Salary: activate to sort column ascending">Salary</th><th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 147px;" aria-label="Status: activate to sort column ascending">Status</th><th class="sorting_disabled" rowspan="1" colspan="1" style="width: 157px;" aria-label="Actions">Actions</th></tr>
          </thead>
        <tbody><tr class="odd"><td valign="top" colspan="7" class="dataTables_empty">Loading...</td></tr></tbody></table><div class="d-flex justify-content-between mx-0 row"><div class="col-sm-12 col-md-6"><div class="dataTables_info" id="DataTables_Table_0_info" role="status" aria-live="polite">Showing 0 to 0 of 0 entries</div></div><div class="col-sm-12 col-md-6"><div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate"><ul class="pagination"><li class="paginate_button page-item previous disabled" id="DataTables_Table_0_previous"><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0" class="page-link">&nbsp;</a></li><li class="paginate_button page-item next disabled" id="DataTables_Table_0_next"><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="1" tabindex="0" class="page-link">&nbsp;</a></li></ul></div></div></div></div>
      </div>
    </div>


            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- END: Content-->


    <!-- BEGIN: Customizer-->
    <!-- End: Customizer-->

    <!-- Buynow Button-->
    <div class="sidenav-overlay"></div>
    <div class="drag-target"></div>

    <!-- BEGIN: Footer-->
   <footer class="footer footer-static footer-light">
      <p class="clearfix mb-0"><span class="float-md-start d-block d-md-inline-block mt-25">COPYRIGHT  &copy;  <span id="currentYear"></span> ,| Powered by<a class="ms-25" href="https://ramkyenviroengineers.com/" target="_blank">Re Sustainability Limited</a><span class="d-none d-sm-inline-block"> . All Rights Reserved.</span></span></p>
    </footer>
    <button class="btn btn-primary btn-icon scroll-top" type="button"><i data-feather="arrow-up"></i></button>
    <!-- END: Footer-->


    <!-- BEGIN: Vendor JS-->
    <script src="/iris/resources//vendors/js/vendors.min.js"></script>
    <!-- BEGIN Vendor JS-->

    <!-- BEGIN: Page Vendor JS-->
    <script src="/iris/resources//vendors/js/ui/jquery.sticky.js"></script>
    <script src="/iris/resources//vendors/js/editors/quill/katex.min.js"></script>
    <script src="/iris/resources//vendors/js/editors/quill/highlight.min.js"></script>
    <script src="/iris/resources//vendors/js/editors/quill/quill.min.js"></script>
    <script src="/iris/resources//vendors/js/extensions/toastr.min.js"></script>
    <script src="/iris/resources//vendors/js/forms/select/select2.full.min.js"></script>
    <!-- END: Page Vendor JS-->

    <!-- BEGIN: Theme JS-->
    <script src="/iris/resources//js/core/app-menu.min.js"></script>
    <script src="/iris/resources//js/core/app.min.js"></script>
    <script src="/iris/resources//js/scripts/customizer.min.js"></script>
    <!-- END: Theme JS-->

    <!-- BEGIN: Page JS-->
    <script src="/iris/resources//js/scripts/pages/app-email.min.js"></script>
    <!-- END: Page JS-->

    <script>
	 $(window).on('load',  function(){
    	
        if (feather) {
          feather.replace({ width: 14, height: 14 });
        }
      })
       document.getElementById("currentYear").innerHTML = new Date().getFullYear();

	 function strinkMenu(){ 
		 var menuWidth = $("#menuDiv").width();
		 if(menuWidth == '260'){
			 $(".menuList").fadeIn("slow", function() {
		            $(this).addClass("menu-hide");
		        });
			 $(".showIcon").removeClass('menu-hide');
			 $('#menuDiv').animate({
			        width: "6rem" // New width you want to animate to
			    }, 200); 
			 $('#bigDiv').animate({
			        width: "90rem" // New width you want to animate to
			    }, 200); ''
			    
			 
		 }else{
			 $(".showIcon").addClass('menu-hide');
			 $(".menuList").removeClass('menu-hide');
			 $('#menuDiv').animate({
			        width: "260px" // New width you want to animate to
			    }, 200);
			 $('#bigDiv').animate({
			        width: "78rem" // New width you want to animate to
			    }, 200); ''
		 }
		 
		 
		

	}
		
    </script>
     <script async>
        var link = document.createElement( 'link' );
        link.href = 'https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/styles/atelier-cave-light.min.css';
        link.rel = 'stylesheet';document.getElementsByTagName( 'head' )[0].appendChild( link );
      </script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js"></script>
      <script async>hljs.initHighlightingOnLoad();</script>
   
  </body>
  <!-- END: Body-->

<!-- Mirrored from pixinvent.com/demo/vuexy-html-bootstrap-admin-template/html/ltr/horizontal-menu-template/app-email.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 07 Aug 2022 05:35:41 GMT -->
</html>