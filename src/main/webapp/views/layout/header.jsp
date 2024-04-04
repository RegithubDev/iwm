<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
<meta charset="UTF-8">
<!-- <meta name="google-signin-client_id" content="180023549420-4araucipo8cil4matp902f64cte57md9.apps.googleusercontent.com">
 --> <script src="https://accounts.google.com/gsi/client" onload="initClient()" async defer></script>
<title>Header</title>
<script src="/iris/resources/js/jQuery-v.3.5.min.js"  ></script>
<style type="text/css">
.horizontal-menu .header-navbar.navbar-brand-center .navbar-header {
    left: calc(3% - 56px) !important;
    }
    .card-img {
 max-width: 20% !important;
    margin-left: 0%;
    margin-top: 0.5% !important;
}
.navbar-brand {
    margin-right: 0rem !important;
    white-space: nowrap;
}
/* .horizontal-menu .header-navbar {
    background: #FFF !important;
    z-index: 999!important;
    line-height: 1;
    min-height: auto;
} */
@media (max-width: 767px) {
 	
	 .hides{
	 	display:none;
	 }
 
 }
</style>
</head>
<body>

    <nav class="header-navbar navbar navbar-expand-lg align-items-center navbar-shadow fixed-top navbar-light">
      <div class="navbar-container d-flex content">
      <div class="bookmark-wrapper d-flex align-items-center">
          <ul class="nav navbar-nav d-xl-none">
            <li class="nav-item"><a class="nav-link menu-toggle" href="#"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-menu ficon"><line x1="3" y1="12" x2="21" y2="12"></line><line x1="3" y1="6" x2="21" y2="6"></line><line x1="3" y1="18" x2="21" y2="18"></line></svg></a></li>
          </ul>
          <ul class="nav navbar-nav bookmark-icons">
          <%-- <li class="badge bg-dark">${sessionScope.BASE_SBU }</li> --%>
           </ul>
          <ul class="nav navbar-nav">
            
          </ul>
        </div>
        <ul class="nav navbar-nav align-items-center ms-auto">
          
          <li class="nav-item d-none d-lg-block"><a class="nav-link nav-link-style"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-moon ficon"><path d="M21 12.79A9 9 0 1 1 11.21 3 7 7 0 0 0 21 12.79z"></path></svg></a></li>
          
          
          
          <li class="nav-item dropdown dropdown-user"><a class="nav-link dropdown-toggle dropdown-user-link" id="dropdown-user" href="#" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <div class="user-nav d-sm-flex d-none"><span class="user-name fw-bolder">${sessionScope.USER_NAME } </span><span class="fw-bolder user-status"></span></div><span class="avatar"><img class="round" src="../../../app-assets/images/portrait/small/avatar-s-11.jpg" alt="avatar" height="40" width="40"><span class="avatar-status-online"></span></span></a>
            <div class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdown-user"><a class="dropdown-item"  href="<%=request.getContextPath() %>/iris-accountinfo"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-user me-50"><path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path><circle cx="12" cy="7" r="4"></circle></svg> Profile</a>
              <div class="dropdown-divider"></div>  <a class="dropdown-item g_id_signout" href="#"  id="signout_button" ><i class="me-50" data-feather="power"></i> Logout</a>
            </div>
          </li>
        </ul>
      </div>
    </nav>
	    
     <form action="<%=request.getContextPath() %>/logout" name="logoutForm" id="logoutForm" method="post">
		<input type="hidden" name="email" id="email"/>
	</form>
    <script>
    $(window).on("load",(function(){
    	//$('.btn-page-block-custom').hide();
        if (feather) {
          feather.replace({ width: 14, height: 14 });
        }
        if('${welcome}' != ''){
        	jQuery('#clickModal').click();
        	  "use strict";var e,o,t,r,a,s="#ebf0f7",i="#5e5873",n="#ebe9f1",d=document.querySelector("#gained-chart"),l=document.querySelector("#order-chart"),h=document.querySelector("#avg-sessions-chart"),p=document.querySelector("#support-trackers-chart"),c=document.querySelector("#sales-visit-chart"),w="rtl"===$("html").attr("data-textdirection");setTimeout(
          			  (function(){toastr.success("You have successfully logged in. Now you can start to explore!","👋 Welcome ${sessionScope.USER_NAME}",{closeButton:!0,tapToDismiss:!1,rtl:w})}),2e3),e={chart:{height:100,type:"area",toolbar:{show:!1},sparkline:{enabled:!0},grid:{show:!1,padding:{left:0,right:0}}},colors:[window.colors.solid.primary],dataLabels:{enabled:!1},stroke:{curve:"smooth",width:2.5},fill:{type:"gradient",gradient:{shadeIntensity:.9,opacityFrom:.7,opacityTo:.5,stops:[0,80,100]}},series:[{name:"Subscribers",data:[28,40,36,52,38,60,55]}],xaxis:{labels:{show:!1},axisBorder:{show:!1}},yaxis:[{y:0,offsetX:0,offsetY:0,padding:{left:0,right:0}}],tooltip:{x:{show:!1}}},new ApexCharts(d,e).render(),o={chart:{height:100,type:"area",toolbar:{show:!1},sparkline:{enabled:!0},grid:{show:!1,padding:{left:0,right:0}}},colors:[window.colors.solid.warning],dataLabels:{enabled:!1},stroke:{curve:"smooth",width:2.5},fill:{type:"gradient",gradient:{shadeIntensity:.9,opacityFrom:.7,opacityTo:.5,stops:[0,80,100]}},series:[{name:"Orders",data:[10,15,8,15,7,12,8]}],xaxis:{labels:{show:!1},axisBorder:{show:!1}},yaxis:[{y:0,offsetX:0,offsetY:0,padding:{left:0,right:0}}],tooltip:{x:{show:!1}}},new ApexCharts(l,o).render(),t={chart:{type:"bar",height:200,sparkline:{enabled:!0},toolbar:{show:!1}},states:{hover:{filter:"none"}},colors:[s,s,window.colors.solid.primary,s,s,s],series:[{name:"Sessions",data:[75,125,225,175,125,75,25]}],grid:{show:!1,padding:{left:0,right:0}},plotOptions:{bar:{columnWidth:"75%",distributed:!0,endingShape:"rounded"}},tooltip:{x:{show:!1}},xaxis:{type:"numeric"}},new ApexCharts(h,t).render(),r={chart:{height:270,type:"radialBar"},plotOptions:{radialBar:{size:150,offsetY:20,startAngle:-150,endAngle:150,hollow:{size:"65%"},track:{background:"#fff",strokeWidth:"100%"},dataLabels:{name:{offsetY:-5,color:i,fontSize:"1rem"},value:{offsetY:15,color:i,fontSize:"1.714rem"}}}},colors:[window.colors.solid.danger],fill:{type:"gradient",gradient:{shade:"dark",type:"horizontal",shadeIntensity:.5,gradientToColors:[window.colors.solid.primary],inverseColors:!0,opacityFrom:1,opacityTo:1,stops:[0,100]}},stroke:{dashArray:8},series:[83],labels:["Completed Tickets"]},new ApexCharts(p,r).render(),a={chart:{height:300,type:"radar",dropShadow:{enabled:!0,blur:8,left:1,top:1,opacity:.2},toolbar:{show:!1},offsetY:5},series:[{name:"Sales",data:[90,50,86,40,100,20]},{name:"Visit",data:[70,75,70,76,20,85]}],stroke:{width:0},colors:[window.colors.solid.primary,window.colors.solid.info],plotOptions:{radar:{polygons:{strokeColors:[n,"transparent","transparent","transparent","transparent","transparent"],connectorColors:"transparent"}}},fill:{type:"gradient",gradient:{shade:"dark",gradientToColors:[window.colors.solid.primary,window.colors.solid.info],shadeIntensity:1,type:"horizontal",opacityFrom:1,opacityTo:1,stops:[0,100,100,100]}},markers:{size:0},legend:{show:!1},labels:["Jan","Feb","Mar","Apr","May","Jun"],dataLabels:{background:{foreColor:[n,n,n,n,n,n]}},yaxis:{show:!1},grid:{show:!1,padding:{bottom:-27}}},new ApexCharts(c,a).render()
        }
        if('${NewUser}' != ''){
      	  "use strict";var e,o,t,r,a,s="#ebf0f7",i="#5e5873",n="#ebe9f1",d=document.querySelector("#gained-chart"),l=document.querySelector("#order-chart"),h=document.querySelector("#avg-sessions-chart"),p=document.querySelector("#support-trackers-chart"),c=document.querySelector("#sales-visit-chart"),w="rtl"===$("html").attr("data-textdirection");setTimeout(
        			  (function(){toastr.success("You have been <b>Rewarded with 100 points</b> By Registering into <b>Safety Portal</b>"," Congratulations ${sessionScope.USER_NAME}! ",{closeButton:!0,tapToDismiss:!1,rtl:w})}),2e3),e={chart:{height:100,type:"area",toolbar:{show:!1},sparkline:{enabled:!0},grid:{show:!1,padding:{left:0,right:0}}},colors:[window.colors.solid.primary],dataLabels:{enabled:!1},stroke:{curve:"smooth",width:2.5},fill:{type:"gradient",gradient:{shadeIntensity:.9,opacityFrom:.7,opacityTo:.5,stops:[0,80,100]}},series:[{name:"Subscribers",data:[28,40,36,52,38,60,55]}],xaxis:{labels:{show:!1},axisBorder:{show:!1}},yaxis:[{y:0,offsetX:0,offsetY:0,padding:{left:0,right:0}}],tooltip:{x:{show:!1}}},new ApexCharts(d,e).render(),o={chart:{height:100,type:"area",toolbar:{show:!1},sparkline:{enabled:!0},grid:{show:!1,padding:{left:0,right:0}}},colors:[window.colors.solid.warning],dataLabels:{enabled:!1},stroke:{curve:"smooth",width:2.5},fill:{type:"gradient",gradient:{shadeIntensity:.9,opacityFrom:.7,opacityTo:.5,stops:[0,80,100]}},series:[{name:"Orders",data:[10,15,8,15,7,12,8]}],xaxis:{labels:{show:!1},axisBorder:{show:!1}},yaxis:[{y:0,offsetX:0,offsetY:0,padding:{left:0,right:0}}],tooltip:{x:{show:!1}}},new ApexCharts(l,o).render(),t={chart:{type:"bar",height:200,sparkline:{enabled:!0},toolbar:{show:!1}},states:{hover:{filter:"none"}},colors:[s,s,window.colors.solid.primary,s,s,s],series:[{name:"Sessions",data:[75,125,225,175,125,75,25]}],grid:{show:!1,padding:{left:0,right:0}},plotOptions:{bar:{columnWidth:"75%",distributed:!0,endingShape:"rounded"}},tooltip:{x:{show:!1}},xaxis:{type:"numeric"}},new ApexCharts(h,t).render(),r={chart:{height:270,type:"radialBar"},plotOptions:{radialBar:{size:150,offsetY:20,startAngle:-150,endAngle:150,hollow:{size:"65%"},track:{background:"#fff",strokeWidth:"100%"},dataLabels:{name:{offsetY:-5,color:i,fontSize:"1rem"},value:{offsetY:15,color:i,fontSize:"1.714rem"}}}},colors:[window.colors.solid.danger],fill:{type:"gradient",gradient:{shade:"dark",type:"horizontal",shadeIntensity:.5,gradientToColors:[window.colors.solid.primary],inverseColors:!0,opacityFrom:1,opacityTo:1,stops:[0,100]}},stroke:{dashArray:8},series:[83],labels:["Completed Tickets"]},new ApexCharts(p,r).render(),a={chart:{height:300,type:"radar",dropShadow:{enabled:!0,blur:8,left:1,top:1,opacity:.2},toolbar:{show:!1},offsetY:5},series:[{name:"Sales",data:[90,50,86,40,100,20]},{name:"Visit",data:[70,75,70,76,20,85]}],stroke:{width:0},colors:[window.colors.solid.primary,window.colors.solid.info],plotOptions:{radar:{polygons:{strokeColors:[n,"transparent","transparent","transparent","transparent","transparent"],connectorColors:"transparent"}}},fill:{type:"gradient",gradient:{shade:"dark",gradientToColors:[window.colors.solid.primary,window.colors.solid.info],shadeIntensity:1,type:"horizontal",opacityFrom:1,opacityTo:1,stops:[0,100,100,100]}},markers:{size:0},legend:{show:!1},labels:["Jan","Feb","Mar","Apr","May","Jun"],dataLabels:{background:{foreColor:[n,n,n,n,n,n]}},yaxis:{show:!1},grid:{show:!1,padding:{bottom:-27}}},new ApexCharts(c,a).render()
      }
        if('${success}' != ''){
        	 "use strict";var e,o,t,r,a,s="#ebf0f7",i="#5e5873",n="#ebe9f1",d=document.querySelector("#gained-chart"),l=document.querySelector("#order-chart"),h=document.querySelector("#avg-sessions-chart"),p=document.querySelector("#support-trackers-chart"),c=document.querySelector("#sales-visit-chart"),w="rtl"===$("html").attr("data-textdirection");setTimeout(
         			  (function(){toastr.success("${success}",{closeButton:!0,tapToDismiss:!1,rtl:w})}),2e3),e={chart:{height:100,type:"area",toolbar:{show:!1},sparkline:{enabled:!0},grid:{show:!1,padding:{left:0,right:0}}},colors:[window.colors.solid.primary],dataLabels:{enabled:!1},stroke:{curve:"smooth",width:2.5},fill:{type:"gradient",gradient:{shadeIntensity:.9,opacityFrom:.7,opacityTo:.5,stops:[0,80,100]}},series:[{name:"Subscribers",data:[28,40,36,52,38,60,55]}],xaxis:{labels:{show:!1},axisBorder:{show:!1}},yaxis:[{y:0,offsetX:0,offsetY:0,padding:{left:0,right:0}}],tooltip:{x:{show:!1}}},new ApexCharts(d,e).render(),o={chart:{height:100,type:"area",toolbar:{show:!1},sparkline:{enabled:!0},grid:{show:!1,padding:{left:0,right:0}}},colors:[window.colors.solid.warning],dataLabels:{enabled:!1},stroke:{curve:"smooth",width:2.5},fill:{type:"gradient",gradient:{shadeIntensity:.9,opacityFrom:.7,opacityTo:.5,stops:[0,80,100]}},series:[{name:"Orders",data:[10,15,8,15,7,12,8]}],xaxis:{labels:{show:!1},axisBorder:{show:!1}},yaxis:[{y:0,offsetX:0,offsetY:0,padding:{left:0,right:0}}],tooltip:{x:{show:!1}}},new ApexCharts(l,o).render(),t={chart:{type:"bar",height:200,sparkline:{enabled:!0},toolbar:{show:!1}},states:{hover:{filter:"none"}},colors:[s,s,window.colors.solid.primary,s,s,s],series:[{name:"Sessions",data:[75,125,225,175,125,75,25]}],grid:{show:!1,padding:{left:0,right:0}},plotOptions:{bar:{columnWidth:"75%",distributed:!0,endingShape:"rounded"}},tooltip:{x:{show:!1}},xaxis:{type:"numeric"}},new ApexCharts(h,t).render(),r={chart:{height:270,type:"radialBar"},plotOptions:{radialBar:{size:150,offsetY:20,startAngle:-150,endAngle:150,hollow:{size:"65%"},track:{background:"#fff",strokeWidth:"100%"},dataLabels:{name:{offsetY:-5,color:i,fontSize:"1rem"},value:{offsetY:15,color:i,fontSize:"1.714rem"}}}},colors:[window.colors.solid.danger],fill:{type:"gradient",gradient:{shade:"dark",type:"horizontal",shadeIntensity:.5,gradientToColors:[window.colors.solid.primary],inverseColors:!0,opacityFrom:1,opacityTo:1,stops:[0,100]}},stroke:{dashArray:8},series:[83],labels:["Completed Tickets"]},new ApexCharts(p,r).render(),a={chart:{height:300,type:"radar",dropShadow:{enabled:!0,blur:8,left:1,top:1,opacity:.2},toolbar:{show:!1},offsetY:5},series:[{name:"Sales",data:[90,50,86,40,100,20]},{name:"Visit",data:[70,75,70,76,20,85]}],stroke:{width:0},colors:[window.colors.solid.primary,window.colors.solid.info],plotOptions:{radar:{polygons:{strokeColors:[n,"transparent","transparent","transparent","transparent","transparent"],connectorColors:"transparent"}}},fill:{type:"gradient",gradient:{shade:"dark",gradientToColors:[window.colors.solid.primary,window.colors.solid.info],shadeIntensity:1,type:"horizontal",opacityFrom:1,opacityTo:1,stops:[0,100,100,100]}},markers:{size:0},legend:{show:!1},labels:["Jan","Feb","Mar","Apr","May","Jun"],dataLabels:{background:{foreColor:[n,n,n,n,n,n]}},yaxis:{show:!1},grid:{show:!1,padding:{bottom:-27}}},new ApexCharts(c,a).render()
        }
        if('${error}' != ''){
       	 "use strict";var e,o,t,r,a,s="#ebf0f7",i="#5e5873",n="#ebe9f1",d=document.querySelector("#gained-chart"),l=document.querySelector("#order-chart"),h=document.querySelector("#avg-sessions-chart"),p=document.querySelector("#support-trackers-chart"),c=document.querySelector("#sales-visit-chart"),w="rtl"===$("html").attr("data-textdirection");setTimeout(
        			  (function(){toastr.error("${error}",{closeButton:!0,tapToDismiss:!1,rtl:w})}),2e3),e={chart:{height:100,type:"area",toolbar:{show:!1},sparkline:{enabled:!0},grid:{show:!1,padding:{left:0,right:0}}},colors:[window.colors.solid.primary],dataLabels:{enabled:!1},stroke:{curve:"smooth",width:2.5},fill:{type:"gradient",gradient:{shadeIntensity:.9,opacityFrom:.7,opacityTo:.5,stops:[0,80,100]}},series:[{name:"Subscribers",data:[28,40,36,52,38,60,55]}],xaxis:{labels:{show:!1},axisBorder:{show:!1}},yaxis:[{y:0,offsetX:0,offsetY:0,padding:{left:0,right:0}}],tooltip:{x:{show:!1}}},new ApexCharts(d,e).render(),o={chart:{height:100,type:"area",toolbar:{show:!1},sparkline:{enabled:!0},grid:{show:!1,padding:{left:0,right:0}}},colors:[window.colors.solid.warning],dataLabels:{enabled:!1},stroke:{curve:"smooth",width:2.5},fill:{type:"gradient",gradient:{shadeIntensity:.9,opacityFrom:.7,opacityTo:.5,stops:[0,80,100]}},series:[{name:"Orders",data:[10,15,8,15,7,12,8]}],xaxis:{labels:{show:!1},axisBorder:{show:!1}},yaxis:[{y:0,offsetX:0,offsetY:0,padding:{left:0,right:0}}],tooltip:{x:{show:!1}}},new ApexCharts(l,o).render(),t={chart:{type:"bar",height:200,sparkline:{enabled:!0},toolbar:{show:!1}},states:{hover:{filter:"none"}},colors:[s,s,window.colors.solid.primary,s,s,s],series:[{name:"Sessions",data:[75,125,225,175,125,75,25]}],grid:{show:!1,padding:{left:0,right:0}},plotOptions:{bar:{columnWidth:"75%",distributed:!0,endingShape:"rounded"}},tooltip:{x:{show:!1}},xaxis:{type:"numeric"}},new ApexCharts(h,t).render(),r={chart:{height:270,type:"radialBar"},plotOptions:{radialBar:{size:150,offsetY:20,startAngle:-150,endAngle:150,hollow:{size:"65%"},track:{background:"#fff",strokeWidth:"100%"},dataLabels:{name:{offsetY:-5,color:i,fontSize:"1rem"},value:{offsetY:15,color:i,fontSize:"1.714rem"}}}},colors:[window.colors.solid.danger],fill:{type:"gradient",gradient:{shade:"dark",type:"horizontal",shadeIntensity:.5,gradientToColors:[window.colors.solid.primary],inverseColors:!0,opacityFrom:1,opacityTo:1,stops:[0,100]}},stroke:{dashArray:8},series:[83],labels:["Completed Tickets"]},new ApexCharts(p,r).render(),a={chart:{height:300,type:"radar",dropShadow:{enabled:!0,blur:8,left:1,top:1,opacity:.2},toolbar:{show:!1},offsetY:5},series:[{name:"Sales",data:[90,50,86,40,100,20]},{name:"Visit",data:[70,75,70,76,20,85]}],stroke:{width:0},colors:[window.colors.solid.primary,window.colors.solid.info],plotOptions:{radar:{polygons:{strokeColors:[n,"transparent","transparent","transparent","transparent","transparent"],connectorColors:"transparent"}}},fill:{type:"gradient",gradient:{shade:"dark",gradientToColors:[window.colors.solid.primary,window.colors.solid.info],shadeIntensity:1,type:"horizontal",opacityFrom:1,opacityTo:1,stops:[0,100,100,100]}},markers:{size:0},legend:{show:!1},labels:["Jan","Feb","Mar","Apr","May","Jun"],dataLabels:{background:{foreColor:[n,n,n,n,n,n]}},yaxis:{show:!1},grid:{show:!1,padding:{bottom:-27}}},new ApexCharts(c,a).render()
       }
        $.blockUI({
            message:
              '<div class="d-flex justify-content-center align-items-center"><p class="me-50 mb-0">Please wait Fetching data...</p> <div class="spinner-border text-danger text-white" role="status"></div> </div>',
            timeout: 1000,
            css: {
              backgroundColor: 'transparent',
              color: '#fff',
              border: '0'
            },
            overlayCSS: {
              opacity: 0.8
            }
          });
  	 }));
    
    const button = document.getElementById("signout_button");
    button.onclick = () => {
      google.accounts.id.disableAutoSelect();
      console.log('User signed out.');
      $("#email").val('');
		$("#logoutForm").submit();
    }
	  
    </script>
</body>
</html>