
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
  
<!-- Mirrored from pixinvent.com/demo/vuexy-html-bootstrap-admin-template/html/ltr/horizontal-menu-template/dashboard-ecommerce.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 07 Aug 2022 05:36:10 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0,minimal-ui">
    <meta name="description" content="Vuexy admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, Vuexy admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Dashboard analytics - iris</title>
    <link rel="apple-touch-icon" href="/iris/resources/images/ico/apple-icon-120.html">
   <link rel="icon" type="image/png" sizes="96x96" href="/iris/resources/images/protect-favicon.png" >

    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,300;0,400;0,500;0,600;1,400;1,500;1,600" rel="stylesheet">
	    <meta name="google-signin-client_id" content="46521935412-0pl18k3a2mq7fs8nrl1853qcie9h5fjb.apps.googleusercontent.com">

    <!-- BEGIN: Vendor CSS-->
    <link rel="stylesheet" type="text/css" href="/iris/resources/vendors/css/vendors.min.css"> 
    <link rel="stylesheet" type="text/css" href="/iris/resources/vendors/css/charts/apexcharts.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/vendors/css/extensions/toastr.min.css">
    <!-- END: Vendor CSS-->

    <!-- BEGIN: Theme CSS-->
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/colors.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/components.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/themes/dark-layout.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/themes/bordered-layout.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/themes/semi-dark-layout.min.css">
	<script src="/iris/resources/js/jQuery-v.3.5.min.js"></script>
    <!-- BEGIN: Page CSS-->
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/pages/dashboard-ecommerce.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/plugins/charts/chart-apex.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/plugins/extensions/ext-component-toastr.min.css">
    <!-- END: Page CSS-->
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
    <!-- BEGIN: Custom CSS-->
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/style.css">
    <!-- END: Custom CSS-->

  </head>
  <!-- END: Head-->

  <!-- BEGIN: Body-->
  <body class="horizontal-layout horizontal-menu  navbar-floating footer-static  " data-open="hover" data-menu="horizontal-menu" data-col="">
 	<!-- BEGIN: Header-->
	<jsp:include page="../views/layout/header.jsp"></jsp:include>
    <!-- END: Header-->


    <!-- BEGIN: Main Menu-->
    <div class="horizontal-menu-wrapper">
      <div class="header-navbar navbar-expand-sm navbar navbar-horizontal floating-nav navbar-light navbar-shadow menu-border container-xxl" role="navigation" data-menu="menu-wrapper" data-menu-type="floating-nav">
        <div class="navbar-header">
          <ul class="nav navbar-nav flex-row">
            <li class="nav-item me-auto"><a class="navbar-brand" href="index-2.html"><span class="brand-logo">
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
                                             			         <img src="<%=request.getContextPath() %>/resources/images/Aayush-Safety.png" width="50" height="40" class="card-img">

                      </g>
                    </g>
                  </svg></span>
                <h2 class="brand-text mb-0">Safety</h2></a></li>
            <li class="nav-item nav-toggle"><a class="nav-link modern-nav-toggle pe-0" data-bs-toggle="collapse"><i class="d-block d-xl-none text-primary toggle-icon font-medium-4" data-feather="x"></i></a></li>
          </ul>
        </div>
        <div class="shadow-bottom"></div>
        <!-- Horizontal menu content-->
 			<jsp:include page="../views/layout/menu.jsp"></jsp:include> 
      </div>
    </div>    <!-- END: Main Menu-->

    <!-- BEGIN: Content-->
    <div class="app-content content ">
      <div class="content-overlay"></div>
      <div class="header-navbar-shadow"></div>
      <div class="content-wrapper container-xxl p-0">
        <div class="content-header row">
        </div>
        <div class="content-body"><!-- Dashboard Ecommerce Starts -->
<section id="dashboard-ecommerce">

<div class="content-area-wrapper container-xxl p-0">
        <div class="sidebar-left">
          <div class="sidebar"><div class="sidebar-content email-app-sidebar">
  <div class="email-app-menu">
    <div class="form-group-compose text-center compose-btn">
      
    </div>
    <div class="sidebar-menu-list ps ps--active-y">
      <div class="list-group list-group-messages">
        <a href="#" class="list-group-item list-group-item-action active">
          <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-mail font-medium-3 me-50"><path d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z"></path><polyline points="22,6 12,13 2,6"></polyline></svg>
          <span class="align-middle">Inbox</span>
          <span class="badge badge-light-primary rounded-pill float-end">3</span>
        </a>
        <a href="#" class="list-group-item list-group-item-action">
          <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-send font-medium-3 me-50"><line x1="22" y1="2" x2="11" y2="13"></line><polygon points="22 2 15 22 11 13 2 9 22 2"></polygon></svg>
          <span class="align-middle">Sent</span>
        </a>
        <a href="#" class="list-group-item list-group-item-action">
          <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-edit-2 font-medium-3 me-50"><path d="M17 3a2.828 2.828 0 1 1 4 4L7.5 20.5 2 22l1.5-5.5L17 3z"></path></svg>
          <span class="align-middle">Draft</span>
          <span class="badge badge-light-warning rounded-pill float-end">2</span>
        </a>
        <a href="#" class="list-group-item list-group-item-action">
          <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-star font-medium-3 me-50"><polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2"></polygon></svg>
          <span class="align-middle">Starred</span>
        </a>
        <a href="#" class="list-group-item list-group-item-action">
          <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-info font-medium-3 me-50"><circle cx="12" cy="12" r="10"></circle><line x1="12" y1="16" x2="12" y2="12"></line><line x1="12" y1="8" x2="12.01" y2="8"></line></svg>
          <span class="align-middle">Spam</span>
          <span class="badge badge-light-danger rounded-pill float-end">5</span>
        </a>
        <a href="#" class="list-group-item list-group-item-action">
          <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash font-medium-3 me-50"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path></svg>
          <span class="align-middle">Trash</span>
        </a>
      </div>
      <!-- <hr /> -->
      <h6 class="section-label mt-3 mb-1 px-2">Labels</h6>
      <div class="list-group list-group-labels">
        <a href="#" class="list-group-item list-group-item-action"><span class="bullet bullet-sm bullet-success me-1"></span>Personal</a>
        <a href="#" class="list-group-item list-group-item-action"><span class="bullet bullet-sm bullet-primary me-1"></span>Company</a>
        <a href="#" class="list-group-item list-group-item-action"><span class="bullet bullet-sm bullet-warning me-1"></span>Important</a>
        <a href="#" class="list-group-item list-group-item-action"><span class="bullet bullet-sm bullet-danger me-1"></span>Private</a>
      </div>
    <div class="ps__rail-x" style="left: 0px; bottom: 0px;"><div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div></div><div class="ps__rail-y" style="top: 0px; height: 88px; right: 0px;"><div class="ps__thumb-y" tabindex="0" style="top: 0px; height: 17px;"></div></div></div>
  </div>
</div>

          </div>
        </div>
        <div class="content-right">
          <div class="content-wrapper container-xxl p-0">
            <div class="content-header row">
            </div>
            <div class="content-body"><div class="body-content-overlay"></div>
<!-- Email list Area -->
<div class="email-app-list">
  <!-- Email search starts -->
  <div class="app-fixed-search d-flex align-items-center">
    <div class="sidebar-toggle d-block d-lg-none ms-1">
      <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-menu font-medium-5"><line x1="3" y1="12" x2="21" y2="12"></line><line x1="3" y1="6" x2="21" y2="6"></line><line x1="3" y1="18" x2="21" y2="18"></line></svg>
    </div>
    <div class="d-flex align-content-center justify-content-between w-100">
      <div class="input-group input-group-merge">
        <span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-search text-muted"><circle cx="11" cy="11" r="8"></circle><line x1="21" y1="21" x2="16.65" y2="16.65"></line></svg></span>
        <input type="text" class="form-control" id="email-search" placeholder="Search email" aria-label="Search..." aria-describedby="email-search">
      </div>
    </div>
  </div>
  <!-- Email search ends -->

  <!-- Email actions starts -->
  <div class="app-action">
    <div class="action-left">
      <div class="form-check selectAll">
        <input type="checkbox" class="form-check-input" id="selectAllCheck">
        <label class="form-check-label fw-bolder ps-25" for="selectAllCheck">Select All</label>
      </div>
    </div>
    <div class="action-right">
      <ul class="list-inline m-0">
        <li class="list-inline-item">
          <div class="dropdown">
            <a href="#" class="dropdown-toggle" id="folder" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-folder font-medium-2"><path d="M22 19a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h5l2 3h9a2 2 0 0 1 2 2z"></path></svg>
            </a>
            <div class="dropdown-menu dropdown-menu-end" aria-labelledby="folder" style="">
              <a class="dropdown-item d-flex align-items-center" href="#">
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-edit-2 font-small-4 me-50"><path d="M17 3a2.828 2.828 0 1 1 4 4L7.5 20.5 2 22l1.5-5.5L17 3z"></path></svg>
                <span>Draft</span>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-info font-small-4 me-50"><circle cx="12" cy="12" r="10"></circle><line x1="12" y1="16" x2="12" y2="12"></line><line x1="12" y1="8" x2="12.01" y2="8"></line></svg>
                <span>Spam</span>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash font-small-4 me-50"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path></svg>
                <span>Trash</span>
              </a>
            </div>
          </div>
        </li>
        <li class="list-inline-item">
          <div class="dropdown">
            <a href="#" class="dropdown-toggle" id="tag" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-tag font-medium-2"><path d="M20.59 13.41l-7.17 7.17a2 2 0 0 1-2.83 0L2 12V2h10l8.59 8.59a2 2 0 0 1 0 2.82z"></path><line x1="7" y1="7" x2="7.01" y2="7"></line></svg>
            </a>
            <div class="dropdown-menu dropdown-menu-end" aria-labelledby="tag" style="">
              <a href="#" class="dropdown-item"><span class="me-50 bullet bullet-success bullet-sm"></span>Personal</a>
              <a href="#" class="dropdown-item"><span class="me-50 bullet bullet-primary bullet-sm"></span>Company</a>
              <a href="#" class="dropdown-item"><span class="me-50 bullet bullet-warning bullet-sm"></span>Important</a>
              <a href="#" class="dropdown-item"><span class="me-50 bullet bullet-danger bullet-sm"></span>Private</a>
            </div>
          </div>
        </li>
        <li class="list-inline-item mail-unread">
          <span class="action-icon"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-mail font-medium-2"><path d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z"></path><polyline points="22,6 12,13 2,6"></polyline></svg></span>
        </li>
        <li class="list-inline-item mail-delete">
          <span class="action-icon"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash-2 font-medium-2"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path><line x1="10" y1="11" x2="10" y2="17"></line><line x1="14" y1="11" x2="14" y2="17"></line></svg></span>
        </li>
      </ul>
    </div>
  </div>
  <!-- Email actions ends -->

  <!-- Email list starts -->
  <div class="email-user-list ps">
    <ul class="email-media-list">
      <li class="d-flex user-mail mail-read">
        <div class="mail-left pe-50">
          <div class="avatar">
            <img src="/iris/resources//images/portrait/small/avatar-s-20.jpg" alt="avatar img holder">
          </div>
          <div class="user-action">
            <div class="form-check">
              <input type="checkbox" class="form-check-input" id="customCheck1">
              <label class="form-check-label" for="customCheck1"></label>
            </div>
            <span class="email-favorite"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-star"><polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2"></polygon></svg></span>
          </div>
        </div>
        <div class="mail-body">
          <div class="mail-details">
            <div class="mail-items">
              <h5 class="mb-25">Tonny Deep</h5>
              <span class="text-truncate">🎯 Focused impactful open system </span>
            </div>
            <div class="mail-meta-item">
              <span class="me-50 bullet bullet-success bullet-sm"></span>
              <span class="mail-date">4:14 AM</span>
            </div>
          </div>
          <div class="mail-message">
            <p class="text-truncate mb-0">
              Hey John, bah kivu decrete epanorthotic unnotched Argyroneta nonius veratrine preimaginary saunders
              demidolmen Chaldaic allusiveness lorriker unworshipping ribaldish tableman hendiadys outwrest unendeavored
              fulfillment scientifical Pianokoto CheloniaFreudian sperate unchary hyperneurotic phlogiston duodecahedron
              unflown Paguridea catena disrelishable Stygian paleopsychology cantoris phosphoritic disconcord fruited
              inblow somewhatly ilioperoneal forrard palfrey Satyrinae outfreeman melebiose
            </p>
          </div>
        </div>
      </li>
      
      
      
      
      
      
      
      
      
      
      
    </ul>
    <div class="no-results">
      <h5>No Items Found</h5>
    </div>
  <div class="ps__rail-x" style="left: 0px; bottom: 0px;"><div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div></div><div class="ps__rail-y" style="top: 0px; height: 326px; right: 0px;"><div class="ps__thumb-y" tabindex="0" style="top: 0px; height: 0px;"></div></div></div>
  <!-- Email list ends -->
</div>
<!--/ Email list Area -->
<!-- Detailed Email View -->
<div class="email-app-details">
  <!-- Detailed Email Header starts -->
  <div class="email-detail-header">
    <div class="email-header-left d-flex align-items-center">
      <span class="go-back me-1"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-chevron-left font-medium-4"><polyline points="15 18 9 12 15 6"></polyline></svg></span>
      <h4 class="email-subject mb-0">Focused open system 😃</h4>
    </div>
    <div class="email-header-right ms-2 ps-1">
      <ul class="list-inline m-0">
        <li class="list-inline-item">
          <span class="action-icon favorite"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-star font-medium-2"><polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2"></polygon></svg></span>
        </li>
        <li class="list-inline-item">
          <div class="dropdown no-arrow">
            <a href="#" class="dropdown-toggle" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-folder font-medium-2"><path d="M22 19a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h5l2 3h9a2 2 0 0 1 2 2z"></path></svg>
            </a>
            <div class="dropdown-menu" aria-labelledby="folder">
              <a class="dropdown-item d-flex align-items-center" href="#">
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-edit-2 font-medium-3 me-50"><path d="M17 3a2.828 2.828 0 1 1 4 4L7.5 20.5 2 22l1.5-5.5L17 3z"></path></svg>
                <span>Draft</span>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-info font-medium-3 me-50"><circle cx="12" cy="12" r="10"></circle><line x1="12" y1="16" x2="12" y2="12"></line><line x1="12" y1="8" x2="12.01" y2="8"></line></svg>
                <span>Spam</span>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash font-medium-3 me-50"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path></svg>
                <span>Trash</span>
              </a>
            </div>
          </div>
        </li>
        <li class="list-inline-item">
          <div class="dropdown no-arrow">
            <a href="#" class="dropdown-toggle" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-tag font-medium-2"><path d="M20.59 13.41l-7.17 7.17a2 2 0 0 1-2.83 0L2 12V2h10l8.59 8.59a2 2 0 0 1 0 2.82z"></path><line x1="7" y1="7" x2="7.01" y2="7"></line></svg>
            </a>
            <div class="dropdown-menu" aria-labelledby="tag">
              <a href="#" class="dropdown-item"><span class="me-50 bullet bullet-success bullet-sm"></span>Personal</a>
              <a href="#" class="dropdown-item"><span class="me-50 bullet bullet-primary bullet-sm"></span>Company</a>
              <a href="#" class="dropdown-item"><span class="me-50 bullet bullet-warning bullet-sm"></span>Important</a>
              <a href="#" class="dropdown-item"><span class="me-50 bullet bullet-danger bullet-sm"></span>Private</a>
            </div>
          </div>
        </li>
        <li class="list-inline-item">
          <span class="action-icon"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-mail font-medium-2"><path d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z"></path><polyline points="22,6 12,13 2,6"></polyline></svg></span>
        </li>
        <li class="list-inline-item">
          <span class="action-icon"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash font-medium-2"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path></svg></span>
        </li>
        <li class="list-inline-item email-prev">
          <span class="action-icon"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-chevron-left font-medium-2"><polyline points="15 18 9 12 15 6"></polyline></svg></span>
        </li>
        <li class="list-inline-item email-next">
          <span class="action-icon"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-chevron-right font-medium-2"><polyline points="9 18 15 12 9 6"></polyline></svg></span>
        </li>
      </ul>
    </div>
  </div>
  <!-- Detailed Email Header ends -->

  <!-- Detailed Email Content starts -->
  <div class="email-scroll-area ps ps--active-y">
    <div class="row">
      <div class="col-12">
        <div class="email-label">
          <span class="mail-label badge rounded-pill badge-light-primary">Company</span>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-header email-detail-head">
            <div class="user-details d-flex justify-content-between align-items-center flex-wrap">
              <div class="avatar me-75">
                <img src="/iris/resources//images/portrait/small/avatar-s-9.jpg" alt="avatar img holder" width="48" height="48">
              </div>
              <div class="mail-items">
                <h5 class="mb-0">Carlos Williamson</h5>
                <div class="email-info-dropup dropdown">
                  <span role="button" class="dropdown-toggle font-small-3 text-muted" id="card_top01" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    carlos@gmail.com
                  </span>
                  <div class="dropdown-menu" aria-labelledby="card_top01">
                    <table class="table table-sm table-borderless">
                      <tbody>
                        <tr>
                          <td class="text-end">From:</td>
                          <td>carlos@gmail.com</td>
                        </tr>
                        <tr>
                          <td class="text-end">To:</td>
                          <td>johndoe@ow.ly</td>
                        </tr>
                        <tr>
                          <td class="text-end">Date:</td>
                          <td>14:58, 29 Aug 2020</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
            <div class="mail-meta-item d-flex align-items-center">
              <small class="mail-date-time text-muted">29 Aug, 2020, 14:58</small>
              <div class="dropdown ms-50">
                <div role="button" class="dropdown-toggle hide-arrow" id="email_more" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical font-medium-2"><circle cx="12" cy="12" r="1"></circle><circle cx="12" cy="5" r="1"></circle><circle cx="12" cy="19" r="1"></circle></svg>
                </div>
                <div class="dropdown-menu dropdown-menu-end" aria-labelledby="email_more">
                  <div class="dropdown-item"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-corner-up-left me-50"><polyline points="9 14 4 9 9 4"></polyline><path d="M20 20v-7a4 4 0 0 0-4-4H4"></path></svg>Reply</div>
                  <div class="dropdown-item"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-corner-up-right me-50"><polyline points="15 14 20 9 15 4"></polyline><path d="M4 20v-7a4 4 0 0 1 4-4h12"></path></svg>Forward</div>
                  <div class="dropdown-item"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash-2 me-50"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path><line x1="10" y1="11" x2="10" y2="17"></line><line x1="14" y1="11" x2="14" y2="17"></line></svg>Delete</div>
                </div>
              </div>
            </div>
          </div>
          <div class="card-body mail-message-wrapper pt-2">
            <div class="mail-message">
              <p class="card-text">Hey John,</p>
              <p class="card-text">
                bah kivu decrete epanorthotic unnotched Argyroneta nonius veratrine preimaginary saunders demidolmen
                Chaldaic allusiveness lorriker unworshipping ribaldish tableman hendiadys outwrest unendeavored
                fulfillment scientifical Pianokoto Chelonia
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-header email-detail-head">
            <div class="user-details d-flex justify-content-between align-items-center flex-wrap">
              <div class="avatar me-75">
                <img src="/iris/resources//images/portrait/small/avatar-s-18.jpg" alt="avatar img holder" width="48" height="48">
              </div>
              <div class="mail-items">
                <h5 class="mb-0">Ardis Balderson</h5>
                <div class="email-info-dropup dropdown">
                  <span role="button" class="dropdown-toggle font-small-3 text-muted" id="dropdownMenuButton200" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    abaldersong@utexas.edu
                  </span>
                  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton200">
                    <table class="table table-sm table-borderless">
                      <tbody>
                        <tr>
                          <td class="text-end">From:</td>
                          <td>abaldersong@utexas.edu</td>
                        </tr>
                        <tr>
                          <td class="text-end">To:</td>
                          <td>johndoe@ow.ly</td>
                        </tr>
                        <tr>
                          <td class="text-end">Date:</td>
                          <td>4:25 AM 13 Jan 2018</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
            <div class="mail-meta-item d-flex align-items-center">
              <small class="mail-date-time text-muted">17 May, 2020, 4:14</small>
              <div class="dropdown ms-50">
                <div role="button" class="dropdown-toggle hide-arrow" id="email_more_2" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical font-medium-2"><circle cx="12" cy="12" r="1"></circle><circle cx="12" cy="5" r="1"></circle><circle cx="12" cy="19" r="1"></circle></svg>
                </div>
                <div class="dropdown-menu dropdown-menu-end" aria-labelledby="email_more_2">
                  <div class="dropdown-item"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-corner-up-left me-50"><polyline points="9 14 4 9 9 4"></polyline><path d="M20 20v-7a4 4 0 0 0-4-4H4"></path></svg>Reply</div>
                  <div class="dropdown-item"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-corner-up-right me-50"><polyline points="15 14 20 9 15 4"></polyline><path d="M4 20v-7a4 4 0 0 1 4-4h12"></path></svg>Forward</div>
                  <div class="dropdown-item"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash-2 me-50"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path><line x1="10" y1="11" x2="10" y2="17"></line><line x1="14" y1="11" x2="14" y2="17"></line></svg>Delete</div>
                </div>
              </div>
            </div>
          </div>
          <div class="card-body mail-message-wrapper pt-2">
            <div class="mail-message">
              <p class="card-text">Hey John,</p>
              <p class="card-text">
                bah kivu decrete epanorthotic unnotched Argyroneta nonius veratrine preimaginary saunders demidolmen
                Chaldaic allusiveness lorriker unworshipping ribaldish tableman hendiadys outwrest unendeavored
                fulfillment scientifical Pianokoto Chelonia
              </p>
              <p class="card-text">
                Freudian sperate unchary hyperneurotic phlogiston duodecahedron unflown Paguridea catena disrelishable
                Stygian paleopsychology cantoris phosphoritic disconcord fruited inblow somewhatly ilioperoneal forrard
                palfrey Satyrinae outfreeman melebiose
              </p>
            </div>
          </div>
          <div class="card-footer">
            <div class="mail-attachments">
              <div class="d-flex align-items-center mb-1">
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-paperclip font-medium-1 me-50"><path d="M21.44 11.05l-9.19 9.19a6 6 0 0 1-8.49-8.49l9.19-9.19a4 4 0 0 1 5.66 5.66l-9.2 9.19a2 2 0 0 1-2.83-2.83l8.49-8.48"></path></svg>
                <h5 class="fw-bolder text-body mb-0">2 Attachments</h5>
              </div>
              <div class="d-flex flex-column">
                <a href="#" class="mb-50">
                  <img src="/iris/resources//images/icons/doc.png" class="me-25" alt="png" height="18">
                  <small class="text-muted fw-bolder">interdum.docx</small>
                </a>
                <a href="#">
                  <img src="/iris/resources//images/icons/jpg.png" class="me-25" alt="png" height="18">
                  <small class="text-muted fw-bolder">image.png</small>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-body">
            <div class="d-flex justify-content-between">
              <h5 class="mb-0">
                Click here to
                <a href="#">Reply</a>
                or
                <a href="#">Forward</a>
              </h5>
            </div>
          </div>
        </div>
      </div>
    </div>
  <div class="ps__rail-x" style="left: 0px; bottom: 0px;"><div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div></div><div class="ps__rail-y" style="top: 0px; height: 352px; right: 0px;"><div class="ps__thumb-y" tabindex="0" style="top: 0px; height: 147px;"></div></div></div>
  <!-- Detailed Email Content ends -->
</div>
<!--/ Detailed Email View -->

<!-- compose email -->
<div class="modal modal-sticky" id="compose-mail" data-bs-keyboard="false">
  <div class="modal-dialog modal-lg modal-dialog-scrollable">
    <div class="modal-content p-0">
      <div class="modal-header">
        <h5 class="modal-title">Compose Mail</h5>
        <div class="modal-actions">
          <a href="#" class="text-body me-75"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-minus"><line x1="5" y1="12" x2="19" y2="12"></line></svg></a>
          <a href="#" class="text-body me-75 compose-maximize"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-maximize-2"><polyline points="15 3 21 3 21 9"></polyline><polyline points="9 21 3 21 3 15"></polyline><line x1="21" y1="3" x2="14" y2="10"></line><line x1="3" y1="21" x2="10" y2="14"></line></svg></a>
          <a class="text-body" href="#" data-bs-dismiss="modal" aria-label="Close"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-x"><line x1="18" y1="6" x2="6" y2="18"></line><line x1="6" y1="6" x2="18" y2="18"></line></svg></a>
        </div>
      </div>
      <div class="modal-body flex-grow-1 p-0">
        <form class="compose-form">
          <div class="compose-mail-form-field select2-primary">
            <label for="email-to" class="form-label">To: </label>
            <div class="flex-grow-1">
              <div class="position-relative"><select class="select2 form-select w-100 select2-hidden-accessible" id="email-to" multiple="" data-select2-id="email-to" tabindex="-1" aria-hidden="true">
                <option data-avatar="1-small.png" value="Jane Foster">Jane Foster</option>
                <option data-avatar="3-small.png" value="Donna Frank">Donna Frank</option>
                <option data-avatar="5-small.png" value="Gabrielle Robertson">Gabrielle Robertson</option>
                <option data-avatar="7-small.png" value="Lori Spears">Lori Spears</option>
              </select><span class="select2 select2-container select2-container--default" dir="ltr" data-select2-id="1" style="width: auto;"><span class="selection"><span class="select2-selection select2-selection--multiple" role="combobox" aria-haspopup="true" aria-expanded="false" tabindex="-1" aria-disabled="false"><ul class="select2-selection__rendered"><li class="select2-search select2-search--inline"><input class="select2-search__field" type="search" tabindex="0" autocomplete="off" autocorrect="off" autocapitalize="none" spellcheck="false" role="searchbox" aria-autocomplete="list" placeholder="" style="width: 0.75em;"></li></ul></span></span><span class="dropdown-wrapper" aria-hidden="true"></span></span></div>
            </div>
            <div>
              <a class="toggle-cc text-body me-1" href="#">Cc</a>
              <a class="toggle-bcc text-body" href="#">Bcc</a>
            </div>
          </div>
          <div class="compose-mail-form-field cc-wrapper" style="display: none;">
            <label for="emailCC" class="form-label">Cc: </label>
            <div class="flex-grow-1">
              <!-- <input type="text" id="emailCC" class="form-control" placeholder="CC"/> -->
              <div class="position-relative"><select class="select2 form-select w-100 select2-hidden-accessible" id="emailCC" multiple="" data-select2-id="emailCC" tabindex="-1" aria-hidden="true">
                <option data-avatar="1-small.png" value="Jane Foster">Jane Foster</option>
                <option data-avatar="3-small.png" value="Donna Frank">Donna Frank</option>
                <option data-avatar="5-small.png" value="Gabrielle Robertson">Gabrielle Robertson</option>
                <option data-avatar="7-small.png" value="Lori Spears">Lori Spears</option>
              </select><span class="select2 select2-container select2-container--default" dir="ltr" data-select2-id="2" style="width: auto;"><span class="selection"><span class="select2-selection select2-selection--multiple" role="combobox" aria-haspopup="true" aria-expanded="false" tabindex="-1" aria-disabled="false"><ul class="select2-selection__rendered"><li class="select2-search select2-search--inline"><input class="select2-search__field" type="search" tabindex="0" autocomplete="off" autocorrect="off" autocapitalize="none" spellcheck="false" role="searchbox" aria-autocomplete="list" placeholder="" style="width: 0.75em;"></li></ul></span></span><span class="dropdown-wrapper" aria-hidden="true"></span></span></div>
            </div>
            <a class="text-body toggle-cc" href="#"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-x"><line x1="18" y1="6" x2="6" y2="18"></line><line x1="6" y1="6" x2="18" y2="18"></line></svg></a>
          </div>
          <div class="compose-mail-form-field bcc-wrapper" style="display: none;">
            <label for="emailBCC" class="form-label">Bcc: </label>
            <div class="flex-grow-1">
              <!-- <input type="text" id="emailBCC" class="form-control" placeholder="BCC"/> -->
              <div class="position-relative"><select class="select2 form-select w-100 select2-hidden-accessible" id="emailBCC" multiple="" data-select2-id="emailBCC" tabindex="-1" aria-hidden="true">
                <option data-avatar="1-small.png" value="Jane Foster">Jane Foster</option>
                <option data-avatar="3-small.png" value="Donna Frank">Donna Frank</option>
                <option data-avatar="5-small.png" value="Gabrielle Robertson">Gabrielle Robertson</option>
                <option data-avatar="7-small.png" value="Lori Spears">Lori Spears</option>
              </select><span class="select2 select2-container select2-container--default" dir="ltr" data-select2-id="3" style="width: auto;"><span class="selection"><span class="select2-selection select2-selection--multiple" role="combobox" aria-haspopup="true" aria-expanded="false" tabindex="-1" aria-disabled="false"><ul class="select2-selection__rendered"><li class="select2-search select2-search--inline"><input class="select2-search__field" type="search" tabindex="0" autocomplete="off" autocorrect="off" autocapitalize="none" spellcheck="false" role="searchbox" aria-autocomplete="list" placeholder="" style="width: 0.75em;"></li></ul></span></span><span class="dropdown-wrapper" aria-hidden="true"></span></span></div>
            </div>
            <a class="text-body toggle-bcc" href="#"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-x"><line x1="18" y1="6" x2="6" y2="18"></line><line x1="6" y1="6" x2="18" y2="18"></line></svg></a>
          </div>
          <div class="compose-mail-form-field">
            <label for="emailSubject" class="form-label">Subject: </label>
            <input type="text" id="emailSubject" class="form-control" placeholder="Subject" name="emailSubject">
          </div>
          <div id="message-editor">
            <div class="editor ql-container ql-snow" data-placeholder="Type message..."><div class="ql-editor ql-blank" data-gramm="false" contenteditable="true" data-placeholder="Message"><p><br></p></div><div class="ql-clipboard" contenteditable="true" tabindex="-1"></div><div class="ql-tooltip ql-hidden"><a class="ql-preview" rel="noopener noreferrer" target="_blank" href="about:blank"></a><input type="text" data-formula="e=mc^2" data-link="https://quilljs.com" data-video="Embed URL"><a class="ql-action"></a><a class="ql-remove"></a></div></div>
            <div class="compose-editor-toolbar ql-toolbar ql-snow">
              <span class="ql-formats me-0">
                <span class="ql-font ql-picker"><span class="ql-picker-label" tabindex="0" role="button" aria-expanded="false" aria-controls="ql-picker-options-0" data-label="Sailec Light"><svg viewBox="0 0 18 18"> <polygon class="ql-stroke" points="7 11 9 13 11 11 7 11"></polygon> <polygon class="ql-stroke" points="7 7 9 5 11 7 7 7"></polygon> </svg></span><span class="ql-picker-options" aria-hidden="true" tabindex="-1" id="ql-picker-options-0"><span tabindex="0" role="button" class="ql-picker-item ql-selected" data-label="Sailec Light"></span><span tabindex="0" role="button" class="ql-picker-item" data-value="sofia" data-label="Sofia Pro"></span><span tabindex="0" role="button" class="ql-picker-item" data-value="slabo" data-label="Slabo 27px"></span><span tabindex="0" role="button" class="ql-picker-item" data-value="roboto" data-label="Roboto Slab"></span><span tabindex="0" role="button" class="ql-picker-item" data-value="inconsolata" data-label="Inconsolata"></span><span tabindex="0" role="button" class="ql-picker-item" data-value="ubuntu" data-label="Ubuntu Mono"></span></span></span><select class="ql-font" style="display: none;">
                  <option selected="">Sailec Light</option>
                  <option value="sofia">Sofia Pro</option>
                  <option value="slabo">Slabo 27px</option>
                  <option value="roboto">Roboto Slab</option>
                  <option value="inconsolata">Inconsolata</option>
                  <option value="ubuntu">Ubuntu Mono</option>
                </select>
              </span>
              <span class="ql-formats me-0">
                <button class="ql-bold" type="button"><svg viewBox="0 0 18 18"> <path class="ql-stroke" d="M5,4H9.5A2.5,2.5,0,0,1,12,6.5v0A2.5,2.5,0,0,1,9.5,9H5A0,0,0,0,1,5,9V4A0,0,0,0,1,5,4Z"></path> <path class="ql-stroke" d="M5,9h5.5A2.5,2.5,0,0,1,13,11.5v0A2.5,2.5,0,0,1,10.5,14H5a0,0,0,0,1,0,0V9A0,0,0,0,1,5,9Z"></path> </svg></button>
                <button class="ql-italic" type="button"><svg viewBox="0 0 18 18"> <line class="ql-stroke" x1="7" x2="13" y1="4" y2="4"></line> <line class="ql-stroke" x1="5" x2="11" y1="14" y2="14"></line> <line class="ql-stroke" x1="8" x2="10" y1="14" y2="4"></line> </svg></button>
                <button class="ql-underline" type="button"><svg viewBox="0 0 18 18"> <path class="ql-stroke" d="M5,3V9a4.012,4.012,0,0,0,4,4H9a4.012,4.012,0,0,0,4-4V3"></path> <rect class="ql-fill" height="1" rx="0.5" ry="0.5" width="12" x="3" y="15"></rect> </svg></button>
                <button class="ql-link" type="button"><svg viewBox="0 0 18 18"> <line class="ql-stroke" x1="7" x2="11" y1="7" y2="11"></line> <path class="ql-even ql-stroke" d="M8.9,4.577a3.476,3.476,0,0,1,.36,4.679A3.476,3.476,0,0,1,4.577,8.9C3.185,7.5,2.035,6.4,4.217,4.217S7.5,3.185,8.9,4.577Z"></path> <path class="ql-even ql-stroke" d="M13.423,9.1a3.476,3.476,0,0,0-4.679-.36,3.476,3.476,0,0,0,.36,4.679c1.392,1.392,2.5,2.542,4.679.36S14.815,10.5,13.423,9.1Z"></path> </svg></button>
              </span>
            </div>
          </div>
          <div class="compose-footer-wrapper">
            <div class="btn-wrapper d-flex align-items-center">
              <div class="btn-group dropup me-1">
                <button type="button" class="btn btn-primary waves-effect waves-float waves-light">Send</button>
                <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split waves-effect waves-float waves-light" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-reference="parent">
                  <span class="visually-hidden">Toggle Dropdown</span>
                </button>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="#"> Schedule Send</a>
                </div>
              </div>
              <!-- add attachment -->
              <div class="email-attachement">
                <label for="file-input" class="form-label">
                  <svg xmlns="http://www.w3.org/2000/svg" width="17" height="17" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-paperclip ms-50"><path d="M21.44 11.05l-9.19 9.19a6 6 0 0 1-8.49-8.49l9.19-9.19a4 4 0 0 1 5.66 5.66l-9.2 9.19a2 2 0 0 1-2.83-2.83l8.49-8.48"></path></svg>
                </label>

                <input id="file-input" type="file" class="d-none">
              </div>
            </div>
            <div class="footer-action d-flex align-items-center">
              <div class="dropup d-inline-block">
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical font-medium-2 cursor-pointer me-50" role="button" id="composeActions" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><circle cx="12" cy="12" r="1"></circle><circle cx="12" cy="5" r="1"></circle><circle cx="12" cy="19" r="1"></circle></svg>
                <div class="dropdown-menu dropdown-menu-end" aria-labelledby="composeActions">
                  <a class="dropdown-item" href="#">
                    <span class="align-middle">Add Label</span>
                  </a>
                  <a class="dropdown-item" href="#">
                    <span class="align-middle">Plain text mode</span>
                  </a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="#">
                    <span class="align-middle">Print</span>
                  </a>
                  <a class="dropdown-item" href="#">
                    <span class="align-middle">Check Spelling</span>
                  </a>
                </div>
              </div>
              <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash font-medium-2 cursor-pointer" data-bs-dismiss="modal"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path></svg>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<!--/ compose email -->

            </div>
          </div>
        </div>
      </div>
</section>
<!-- Dashboard Ecommerce ends -->

        </div>
      </div>
    </div>
    <!-- END: Content-->


    <!-- BEGIN: Customizer-->

    <!-- End: Customizer-->

  
    <div class="sidenav-overlay"></div>
    <div class="drag-target"></div>

    <!-- BEGIN: Footer-->
   <footer class="footer footer-static footer-light">
      <p class="clearfix mb-0"><span class="float-md-start d-block d-md-inline-block mt-25">COPYRIGHT  &copy;  <span id="currentYear"></span> ,| Powered by<a class="ms-25" href="https://ramkyenviroengineers.com/" target="_blank">Re Sustainability Limited</a><span class="d-none d-sm-inline-block"> . All Rights Reserved.</span></span></p>
    </footer>
    <button class="btn btn-primary btn-icon scroll-top" type="button"><i data-feather="arrow-up"></i></button>
    <!-- END: Footer-->


    <!-- BEGIN: Vendor JS-->
    <script src="/iris/resources/vendors/js/vendors.min.js"></script>
    <!-- BEGIN Vendor JS-->

    <!-- BEGIN: Page Vendor JS-->
      <!-- BEGIN: Page Vendor JS-->
        <script src="/iris/resources//vendors/js/vendors.min.js"></script>

    <!-- BEGIN: Page Vendor JS-->
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
    <script src="/iris/resources/vendors/js/ui/jquery.sticky.js"></script>
    <script src="/iris/resources/vendors/js/charts/apexcharts.min.js"></script>
    <script src="/iris/resources/vendors/js/extensions/toastr.min.js"></script>
    <script src="/iris/resources/vendors/js/extensions/moment.min.js"></script>
    <script src="/iris/resources/vendors/js/tables/datatable/jquery.dataTables.min.js"></script>
    <script src="/iris/resources/vendors/js/tables/datatable/datatables.buttons.min.js"></script>
    <script src="/iris/resources/vendors/js/tables/datatable/dataTables.bootstrap5.min.js"></script>
    <script src="/iris/resources/vendors/js/tables/datatable/dataTables.responsive.min.js"></script>
    <script src="/iris/resources/vendors/js/tables/datatable/responsive.bootstrap5.js"></script>
    <!-- END: Page Vendor JS-->
    <!-- BEGIN: Theme JS-->
    <script src="/iris/resources/js/core/app-menu.min.js"></script>
    <script src="/iris/resources/js/core/app.min.js"></script>
    <script src="/iris/resources/js/scripts/customizer.min.js"></script>
    <!-- END: Theme JS-->

    <!-- BEGIN: Page JS-->
    <script src="/iris/resources/js/scripts/pages/dashboard-ecommerce.min.js"></script>
    <!-- END: Page JS-->
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

		
    </script>
     <script async>
        var link = document.createElement( 'link' );
        link.href = 'https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/styles/atelier-cave-light.min.css';
        link.rel = 'stylesheet';document.getElementsByTagName( 'head' )[0].appendChild( link );
      </script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js"></script>
      <script async>hljs.initHighlightingOnLoad();</script>
        <jsp:include page="../views/layout/userActivityCheck.jsp"></jsp:include>
  </body>
  <!-- END: Body-->

<!-- Mirrored from pixinvent.com/demo/vuexy-html-bootstrap-admin-template/html/ltr/horizontal-menu-template/dashboard-ecommerce.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 07 Aug 2022 05:36:10 GMT -->
</html>