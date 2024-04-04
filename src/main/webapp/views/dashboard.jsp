<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>

<html class="loading" lang="en" data-textdirection="ltr">
  <!-- BEGIN: Head-->
  
<!-- Mirrored from pixinvent.com/demo/vuexy-html-bootstrap-admin-template/html/ltr/horizontal-menu-template/dashboard-ecommerce.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 07 Aug 2022 05:36:10 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0,minimal-ui">
    <meta name="description" content="Vuexy admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, Vuexy admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Dashboard analytics - weibridgedata</title>
    <link rel="apple-touch-icon" href="/weibridgedata/resources/images/ico/apple-icon-120.html">
   <link rel="icon" type="image/png" sizes="96x96" href="/weibridgedata/resources/images/protect-favicon.png" >

    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,300;0,400;0,500;0,600;1,400;1,500;1,600" rel="stylesheet">
	    <meta name="google-signin-client_id" content="46521935412-0pl18k3a2mq7fs8nrl1853qcie9h5fjb.apps.googleusercontent.com">
<script src="/weibridgedata/resources/js/jQuery-v.3.5.min.js"></script>
    <!-- BEGIN: Vendor CSS-->
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/vendors/css/extensions/sweetalert2.min.css"/>
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/css/plugins/extensions/ext-component-sweet-alerts.min.css"/>
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/vendors/css/vendors.min.css">
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/vendors/css/tables/datatable/dataTables.bootstrap5.min.css">
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/vendors/css/tables/datatable/responsive.bootstrap5.min.css">
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/vendors/css/tables/datatable/buttons.bootstrap5.min.css">
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/vendors/css/tables/datatable/rowGroup.bootstrap5.min.css">
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/vendors/css/pickers/pickadate/pickadate.css">
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/vendors/css/pickers/flatpickr/flatpickr.min.css">
        <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/vendors/css/extensions/toastr.min.css">
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/css/plugins/extensions/ext-component-toastr.min.css">
    <!-- END: Vendor CSS-->
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
	  <link rel="stylesheet" href="/weibridgedata/resources/css/font-awesome-v.4.7.css" />
    <!-- BEGIN: Theme CSS-->
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/css/colors.min.css">
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/css/components.min.css">
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/css/themes/dark-layout.min.css">
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/css/themes/bordered-layout.min.css">
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/css/themes/semi-dark-layout.min.css">
   <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/vendors/css/forms/select/select2.min.css">
    <!-- BEGIN: Page CSS-->
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/css/core/menu/menu-types/horizontal-menu.min.css">
        <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/css/plugins/forms/pickers/form-flat-pickr.min.css">
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/css/plugins/forms/pickers/form-pickadate.min.css">

    <!-- BEGIN: Custom CSS-->
    <link rel="stylesheet" type="text/css" href="/weibridgedata/resources/css/style.css">
    <!-- END: Custom CSS-->
<style>
@media (min-width: 1200px){
	.modal-xl {
	    margin-left: 10%!important;;
	    margin-right: 3%!important;;
	     max-width: 80%!important;;
	}
}
.modal {
    width: 100% !important;
}
</style>
  </head>
  <!-- END: Head-->

  <!-- BEGIN: Body-->
  <body class="horizontal-layout horizontal-menu  navbar-floating footer-static  " data-open="hover" data-menu="horizontal-menu" data-col="">
 	<!-- BEGIN: Header-->
	<jsp:include page="../views/layout/header.jsp"></jsp:include>
    <!-- END: Header-->

 <jsp:include page="../views/layout/userActivityCheck.jsp"></jsp:include>
    <!-- BEGIN: Main Menu-->
    <div class="horizontal-menu-wrapper">
    <%--   <div class="header-navbar navbar-expand-sm navbar navbar-horizontal floating-nav navbar-light navbar-shadow menu-border container-xxl" role="navigation" data-menu="menu-wrapper" data-menu-type="floating-nav">
        <div class="navbar-header">
          <ul class="nav navbar-nav flex-row">
            <li class="nav-item me-auto"><a class="navbar-brand" href="#"><span class="brand-logo">
                  <svg viewbox="0 0 139 95" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" height="24">
                    <defs>
                      <lineargradient id="linearGradient-1" x1="100%" y1="10.5120544%" x2="50%" y2="89.4879456%">
                        <stop stop-color="#000000" offset="0%"></stop>
                        <stop stop-color="#FFFFFF" offset="100%"></stop>
                      </lineargradient>
                      <lineargradient id="linearGradient-2" x1="64.0437835%" y1="46.3276743%" x2="37.373316%" y2="100%">
                        <stop stop-color="#EEEEEE" stop-opacity="0" offset="0%"></stop>
                        <stop stop-color="#FFFFFF" offset="100%"></stop>
                      </lineargradient>
                    </defs>
                    <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                      <g id="Artboard" transform="translate(-400.000000, -178.000000)">
                                             			         <img src="<%=request.getContextPath() %>/resources/images/logo/protect-main.jpeg" width="50" height="40" class="card-img">

                      </g>
                    </g>
                  </svg></span>
                <h2 class="brand-text mb-0"></h2></a></li>
            <li class="nav-item nav-toggle"><a class="nav-link modern-nav-toggle pe-0" data-bs-toggle="collapse"><i class="d-block d-xl-none text-primary toggle-icon font-medium-4" data-feather="x"></i></a></li>
          </ul>
        </div>
        <div class="shadow-bottom"></div>
        <!-- Horizontal menu content-->
 			<jsp:include page="../views/layout/menu.jsp"></jsp:include> 
  
     </div> --%>
    </div>    <!-- END: Main Menu-->

    <!-- BEGIN: Content-->
<div class="app-content content " style="
    top: -4rem;
">      <div class="content-overlay"></div>
      <div class="header-navbar-shadow"></div>
      <div class="content-wrapper container-xxl p-0">
      <!--   <div class="content-header row">
        <div class="content-header-left col-md-9 col-12 mb-2">
            <div class="row breadcrumbs-top">
              <div class="col-12">
                <h2 class="content-header-title float-start mb-0">Dashboard </h2>
                <div class="breadcrumb-wrapper">
                </div>
              </div>
            </div>
          </div>
        </div> -->
        
        
        <div class="content-header row">
          <div class="content-header-left col-md-9 col-12 mb-2">
            <div class="row breadcrumbs-top">
              <div class="col-12">
                <h2 class="content-header-title float-start mb-0">IWM</h2>
                <div class="breadcrumb-wrapper">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index-2.html">IWM</a>
                    </li>
                   
                  </ol>
                </div>
              </div>
            </div>
          </div>
          <div class="content-header-right text-md-end col-md-3 col-12 d-md-block d-none">
            <div class="mb-1 breadcrumb-right">
              <div class="dropdown">
<button
												class="dt-button buttons-collection btn btn-outline-secondary dropdown-toggle me-2"
												tabindex="0" aria-controls="DataTables_Table_0"
												type="button" aria-haspopup="true">
												<span><svg xmlns="http://www.w3.org/2000/svg"
														width="24" height="24" viewBox="0 0 24 24" fill="none"
														stroke="currentColor" stroke-width="2"
														stroke-linecap="round" stroke-linejoin="round"
														class="feather feather-share font-small-4 me-50">
														<path d="M4 12v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-8"></path>
														<polyline points="16 6 12 2 8 6"></polyline>
														<line x1="12" y1="2" x2="12" y2="15"></line></svg>Export</span>
											</button>                <div class="dropdown-menu dropdown-menu-end"><a class="dropdown-item" href="app-todo.html"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-check-square me-1"><polyline points="9 11 12 14 22 4"></polyline><path d="M21 12v7a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h11"></path></svg><span class="align-middle">Todo</span></a><a class="dropdown-item" href="app-chat.html"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-message-square me-1"><path d="M21 15a2 2 0 0 1-2 2H7l-4 4V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2z"></path></svg><span class="align-middle">Chat</span></a><a class="dropdown-item" href="app-email.html"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-mail me-1"><path d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z"></path><polyline points="22,6 12,13 2,6"></polyline></svg><span class="align-middle">Email</span></a><a class="dropdown-item" href="app-calendar.html"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-calendar me-1"><rect x="3" y="4" width="18" height="18" rx="2" ry="2"></rect><line x1="16" y1="2" x2="16" y2="6"></line><line x1="8" y1="2" x2="8" y2="6"></line><line x1="3" y1="10" x2="21" y2="10"></line></svg><span class="align-middle">Calendar</span></a></div>
              </div>
            </div>
          </div>
        </div>
        
       <section id="basic-datatable">
  <div class="row">
    <div class="col-12">
      <div class="card">
        <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper dt-bootstrap5 no-footer">
								<div class="col-md-12">
      <div class="card">
        
        <div class="card-body">
          <div class="row">
            <div class="col-xl-2 col-md-6 col-8">
              <div class="mb-1">
                <label class="form-label" for="basicInput">Customer</label>
														<div class="position-relative" >
															<select
																class="select2-size-lg form-select select2-hidden-accessible"
																id="customer" >
																<option value="text">Select Customer</option>

															</select>
														</div>
													</div>
            </div>
           
            
            <!--   <div class="col-xl-2 col-md-6 col-8">
              <div class="mb-1">
                <label class="form-label" for="basicInput">IWMA NO</label>
														<div class="position-relative" >
															<select
																class="select2-size-lg form-select select2-hidden-accessible"
																id="iwma_no" >
																<option value="text">Select IWMA NO.</option>

															</select>
														</div>
													</div>
            </div> -->
              <div class="col-xl-2 col-md-6 col-8">
              <div class="mb-1">
                <label class="form-label" for="basicInput">FROM And TO</label>
														<div class="position-relative" >
															<input type="text" name="daterange" value="01/01/2018 - 01/15/2018" style="
    width: 30rem;
">
														
														</div>
													</div>
            </div>
            
          </div>
        </div>
      </div>
    </div>
								<div
									class="d-flex justify-content-between align-items-center mx-0 row">
									<div class="col-sm-12 col-md-6">
										<div class="dataTables_length" id="DataTables_Table_0_length">
											<label>Show <select name="DataTables_Table_0_length"
												aria-controls="DataTables_Table_0" class="form-select"><option
														value="7">7</option>
													<option value="10">10</option>
													<option value="25">25</option>
													<option value="50">50</option>
													<option value="75">75</option>
													<option value="100">100</option></select> entries
											</label>
										</div>
									</div>
									<div class="col-sm-12 col-md-6">
										<div id="DataTables_Table_0_filter" class="dataTables_filter">
											<label>Search:<input type="search"
												class="form-control" placeholder=""
												aria-controls="DataTables_Table_0"></label>
										</div>
									</div>
								</div>
								<table
									class="datatables-basic table dataTable no-footer dtr-column"
									id="DataTables_Table_0" role="grid"
									aria-describedby="DataTables_Table_0_info"
									style="width: 1298px;">
									<thead>
										<tr role="row">
											<th class="control sorting_disabled" rowspan="1" colspan="1"
												style="width: 41px; display: none;" aria-label=""></th>
											<th
												class="sorting_disabled dt-checkboxes-cell dt-checkboxes-select-all"
												rowspan="1" colspan="1" style="width: 41px;" data-col="1"
												aria-label=""></th>
											<th class="sorting" tabindex="0"
												aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
												style="width: 128px;"
												aria-label="Name: activate to sort column ascending">IWMA
												NO.</th>
											<th class="sorting" tabindex="0"
												aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
												style="width: 132px;"
												aria-label="Email: activate to sort column ascending">CUSTOMER</th>
											<th class="sorting" tabindex="0"
												aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
												style="width: 119px;"
												aria-label="Date: activate to sort column ascending">Date</th>
											<th class="sorting" tabindex="0"
												aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
												style="width: 152px;"
												aria-label="Salary: activate to sort column ascending">WASTE
												CATEGORY</th>
											<th class="sorting" tabindex="0"
												aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
												style="width: 147px;"
												aria-label="Status: activate to sort column ascending">WASTE
												NAME</th>
											<th class="sorting_disabled" rowspan="1" colspan="1"
												style="width: 157px;" aria-label="Actions">QTY IN MT</th>
											<th class="sorting_disabled" rowspan="1" colspan="1"
												style="width: 157px;" aria-label="Actions">DISPOSAL
												METHODS</th>
										</tr>
									</thead>
									<tbody>
										<tr class="odd">
											<td valign="top" colspan="7" class="dataTables_empty">Loading...</td>
										</tr>
									</tbody>
								</table>
				<div class="d-flex justify-content-between mx-0 row">
				<div class="col-sm-12 col-md-6">
				<div class="dataTables_info" id="DataTables_Table_0_info" role="status" aria-live="polite">Showing 0 to 0 of 0 entries</div>
				</div>
				<div class="col-sm-12 col-md-6">
				<div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate">
				<ul class="pagination"><li class="paginate_button page-item previous disabled" id="DataTables_Table_0_previous">
				<a href="#" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0" class="page-link">&nbsp;</a></li><li class="paginate_button page-item next disabled" id="DataTables_Table_0_next"><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="1" tabindex="0" class="page-link">&nbsp;</a></li></ul></div></div></div></div>
      </div>
    </div>
  </div>
  <!-- Modal to add new record -->
  <div class="modal modal-slide-in fade" id="modals-slide-in">
    <div class="modal-dialog sidebar-sm">
      <form class="add-new-record modal-content pt-0">
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">×</button>
        <div class="modal-header mb-1">
          <h5 class="modal-title" id="exampleModalLabel">New Record</h5>
        </div>
        <div class="modal-body flex-grow-1">
          <div class="mb-1">
            <label class="form-label" for="basic-icon-default-fullname">Full Name</label>
            <input type="text" class="form-control dt-full-name" id="basic-icon-default-fullname" placeholder="John Doe" aria-label="John Doe">
          </div>
          <div class="mb-1">
            <label class="form-label" for="basic-icon-default-post">Post</label>
            <input type="text" id="basic-icon-default-post" class="form-control dt-post" placeholder="Web Developer" aria-label="Web Developer">
          </div>
          <div class="mb-1">
            <label class="form-label" for="basic-icon-default-email">Email</label>
            <input type="text" id="basic-icon-default-email" class="form-control dt-email" placeholder="john.doe@example.com" aria-label="john.doe@example.com">
            <small class="form-text"> You can use letters, numbers &amp; periods </small>
          </div>
          <div class="mb-1">
            <label class="form-label" for="basic-icon-default-date">Joining Date</label>
            <input type="text" class="form-control dt-date flatpickr-input" id="basic-icon-default-date" placeholder="MM/DD/YYYY" aria-label="MM/DD/YYYY" readonly="readonly">
          </div>
          <div class="mb-4">
            <label class="form-label" for="basic-icon-default-salary">Salary</label>
            <input type="text" id="basic-icon-default-salary" class="form-control dt-salary" placeholder="$12000" aria-label="$12000">
          </div>
          <button type="button" class="btn btn-primary data-submit me-1 waves-effect waves-float waves-light">Submit</button>
          <button type="reset" class="btn btn-outline-secondary waves-effect" data-bs-dismiss="modal">Cancel</button>
        </div>
      </form>
    </div>
  </div>
</section>
      </div>
    </div>
    <!-- END: Content-->

    <div class="sidenav-overlay"></div>
    <div class="drag-target"></div>

    <!-- BEGIN: Footer-->
   <footer class="footer footer-static footer-light">
      <p class="clearfix mb-0"><span class="float-md-start d-block d-md-inline-block mt-25">COPYRIGHT  &copy;  <span id="currentYear"></span> | Powered by<a class="ms-25" href="https://resustainability.com/" target="_blank">Re Sustainability Limited</a><span class="d-none d-sm-inline-block"> . All Rights Reserved.</span></span></p>
    </footer>
    <button class="btn btn-primary btn-icon scroll-top" type="button"><i data-feather="arrow-up"></i></button>
    <!-- END: Footer-->

    <!-- BEGIN: Vendor JS-->
    <script src="/weibridgedata/resources/vendors/js/vendors.min.js"></script>
    <!-- BEGIN Vendor JS-->

    <!-- BEGIN: Page Vendor JS-->
    <script src="/weibridgedata/resources/vendors/js/ui/jquery.sticky.js"></script>
    <script src="/weibridgedata/resources/vendors/js/forms/select/select2.full.min.js"></script>
    <script src="/weibridgedata/resources/vendors/js/charts/apexcharts.min.js"></script>
    <script src="/weibridgedata/resources/vendors/js/extensions/toastr.min.js"></script>
    <script src="/weibridgedata/resources/vendors/js/extensions/moment.min.js"></script>
    <script src="/weibridgedata/resources/vendors/js/tables/datatable/jquery.dataTables.min.js"></script>
    <script src="/weibridgedata/resources/vendors/js/tables/datatable/datatables.buttons.min.js"></script>
    <script src="/weibridgedata/resources/vendors/js/tables/datatable/dataTables.bootstrap5.min.js"></script>
    <script src="/weibridgedata/resources/vendors/js/tables/datatable/dataTables.responsive.min.js"></script>
    <script src="/weibridgedata/resources/vendors/js/tables/datatable/responsive.bootstrap5.js"></script>
    <!-- END: Page Vendor JS-->  
    <script src="/weibridgedata/resources/js/materialize-v.1.0.min.js "  ></script>
    <script src="/weibridgedata/resources/js/jquery-validation-1.19.1.min.js"  ></script>
    <script src="/weibridgedata/resources/js/jquery.dataTables-v.1.10.min.js"  ></script>
     <script src="/weibridgedata/resources/js/datetime-moment-v1.10.12.js"  ></script>
         <script src="/weibridgedata/resources/js/dataTables.material.min.js"  ></script>
      <script src="/weibridgedata/resources/js/moment-v2.8.4.min.js"  ></script>
    <!-- BEGIN: Theme JS-->
    <script src="/weibridgedata/resources/js/core/app-menu.min.js"></script>
    <script src="/weibridgedata/resources/js/core/app.min.js"></script>
    <script src="/weibridgedata/resources/js/scripts/customizer.min.js"></script>
     <script src="/weibridgedata/resources/js/scripts/forms/form-select2.min.js"></script>
    <!-- END: Theme JS-->
   <script src="/weibridgedata/resources/js/scripts/pages/modal-add-new-cc.min.js"></script>
    <script src="/weibridgedata/resources/js/scripts/pages/page-pricing.min.js"></script>
    <script src="/weibridgedata/resources/js/scripts/pages/modal-add-new-address.min.js"></script>
    <script src="/weibridgedata/resources/js/scripts/pages/modal-create-app.min.js"></script>
    <script src="/weibridgedata/resources/js/scripts/pages/modal-two-factor-auth.min.js"></script>
    <script src="/weibridgedata/resources/js/scripts/pages/modal-edit-user.min.js"></script>
    <script src="/weibridgedata/resources/js/scripts/pages/modal-share-project.min.js"></script>
    <!-- BEGIN: Page JS-->
     <script src="/weibridgedata/resources/js/scripts/pages/dashboard-analytics.min.js"></script>
    <script src="/weibridgedata/resources/js/scripts/pages/app-invoice-list.min.js"></script>
    <script src="/weibridgedata/resources/vendors/js/pickers/pickadate/picker.js"></script>
    <script src="/weibridgedata/resources/vendors/js/pickers/pickadate/picker.date.js"></script>
    <script src="/weibridgedata/resources/vendors/js/pickers/pickadate/picker.time.js"></script>
    <script src="/weibridgedata/resources/vendors/js/pickers/pickadate/legacy.js"></script>
    <script src="/weibridgedata/resources/vendors/js/pickers/flatpickr/flatpickr.min.js"></script>
     <script src="/weibridgedata/resources/js/scripts/forms/pickers/form-pickers.min.js"></script>
     <script src="/weibridgedata/resources/js/scripts/extensions/ext-component-blockui.js"></script>
      <script src="/weibridgedata/resources/js/scripts/pages/dashboard-ecommerce.min.js"></script>
    <!-- END: Theme JS-->

    <!-- BEGIN: Page JS-->
    <script src="/weibridgedata/resources/js/scripts/pages/dashboard-ecommerce.min.js"></script>
    <!-- END: Page JS-->
        
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />

 <form action="<%=request.getContextPath() %>/logout" name="logoutForm" id="logoutForm" method="post">
		<input type="hidden" name="email" id="email"/>
	</form>
    <script>
      $(window).on('load',  function(){
    	
        if (feather) {
          feather.replace({ width: 14, height: 14 });
        }
      })
       document.getElementById("currentYear").innerHTML = new Date().getFullYear();

      function historyRE(document_code,approver_type,status,approver_code){
       	  $('#historyRE').modal('show');
      }
      
      
      $(function() {
    	  $('input[name="daterange"]').daterangepicker({
    	    opens: 'left'
    	  }, function(start, end, label) {
    	    console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
    	  });
    	});
      
      
      
      
      
      
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

<!-- Mirrored from pixinvent.com/demo/vuexy-html-bootstrap-admin-template/html/ltr/horizontal-menu-template/dashboard-ecommerce.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 07 Aug 2022 05:36:10 GMT -->
</html>