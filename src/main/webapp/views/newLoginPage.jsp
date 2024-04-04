<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0,minimal-ui">
    <meta name="description" content="Vuexy admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, Vuexy admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Login Page - IRIS </title>
    <link rel="apple-touch-icon" href="/iris/resources/images/logo/logo.png">
    <link rel="shortcut icon" type="image/x-icon" href="/iris/resources/images/logo/logo.png">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,300;0,400;0,500;0,600;1,400;1,500;1,600" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/iris/resources/vendors/css/vendors.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/colors.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/components.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/themes/dark-layout.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/themes/bordered-layout.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/themes/semi-dark-layout.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/core/menu/menu-types/horizontal-menu.min.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/plugins/forms/form-validation.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources/css/pages/authentication.css">
    <link rel="stylesheet" type="text/css" href="/iris/resources//css/style.css">
     <script src="https://accounts.google.com/gsi/client" async defer></script>
       <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,300;0,400;0,500;0,600;1,400;1,500;1,600" rel="stylesheet">
      <link rel="preconnect" href="https://fonts.googleapis.com/" />
    <link rel="preconnect" href="https://fonts.gstatic.com/" crossorigin />
      <link
      href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&amp;family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&amp;display=swap"
      rel="stylesheet"
    />
<style>

@media screen and (max-width: 601px)  {
    .logo {
       width: 19rem!important;
       margin-left: 4rem!important;
    }

}
@media screen and (min-width: 601px) and (max-width: 1024px) {
    .logo {
       width: 8rem!important;
    }

}
input:-webkit-autofill, input:-webkit-autofill:hover, input:-webkit-autofill:focus, input:-webkit-autofill:active {
    animation: input_background_autofill 0s forwards;
    -webkit-text-fill-color: black !important;
}

.img-fluid-1{
	max-width: 56%;
    height: auto;
}
</style>
  </head>
  <!-- END: Head-->

  <!-- BEGIN: Body-->
  <body class="horizontal-layout horizontal-menu blank-page navbar-floating footer-static  " data-open="hover" data-menu="horizontal-menu" data-col="blank-page">
    <!-- BEGIN: Content-->
    <div class="app-content content ">
      <div class="content-overlay"></div>
      <div class="header-navbar-shadow"></div>
      <div class="content-wrapper">
        <div class="content-header row">
        </div>
        <div class="content-body">
          <div class="auth-wrapper auth-cover">
            <div class="auth-inner row m-0">
              <!-- Brand logo--><a class="brand-logo " href="#">
         			<img src="/iris/resources/images/logo/logo.png" class="logo" style="
    width: 8rem;
">
                </a>
              <!-- /Brand logo-->
              <!-- Left Text-->
              <div class="d-none d-lg-flex col-lg-7 align-items-center p-5" style="
    background-color: white;
">
                <div class="w-100 d-lg-flex align-items-center justify-content-center px-5"><img class="img-fluid-1" src="/iris/resources/images/banner/newbanner.png" alt="Login V2"/></div>
              </div>
              <!-- /Left Text-->
              <!-- Login-->
              <div class="d-flex col-lg-5 align-items-center auth-bg px-2 p-lg-8" >
                <div class=" card p-4 col-12 col-sm-8 col-md-6 col-lg-8 px-xl-2 mx-auto">
                  <h1 class="bold re-text fw-bolder">Sign In</h1>
                  <p class="card-text mb-2">Please sign-in to your account and start the adventure</p>
                
                   <div id="g_id_onload" 
					     data-client_id="180023549420-57imk7usicj28m4489imvf0spmk3v7l7.apps.googleusercontent.com"
					     data-context="use"
					     data-ux_mode="popup"
					     data-callback="handleCredentialResponse"
					     data-nonce=""
					     data-itp_support="true">
					</div>
					<div class="g_id_signin justify-content-center mt-1"
					     data-type="standard"  
					     data-shape="rectangular"
					     data-theme="filled_blue"
					     data-text="signin_with"
					     data-size="large"
					     data-logo_alignment="left">
					</div>
                	<!-- 			 <div id="g_id_onload"
									 180023549420-57imk7usicj28m4489imvf0spmk3v7l7.apps.googleusercontent.com
				     data-client_id="180023549420-4araucipo8cil4matp902f64cte57md9.apps.googleusercontent.com"
				     data-context="signin"
				     data-ux_mode="popup"
				     data-callback="handleCredentialResponse"
				     data-nonce=""
				     data-auto_select="true"
				     data-itp_support="true">
				</div>
				
				<div class="g_id_signin justify-content-center mt-1"
				     data-type="standard"
				     data-shape="rectangular"
				     data-theme="outline"
				     data-text="signin_with"
				     data-size="large"
				     data-logo_alignment="left">
				</div> -->
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- END: Content-->


    <!-- BEGIN: Vendor JS-->
    <script src="/iris/resources/vendors/js/vendors.min.js"></script>
    <!-- BEGIN Vendor JS-->

    <!-- BEGIN: Page Vendor JS-->
    <script src="/iris/resources/vendors/js/ui/jquery.sticky.js"></script>
    <script src="/iris/resources/vendors/js/forms/validation/jquery.validate.min.js"></script>
    <!-- END: Page Vendor JS-->

    <!-- BEGIN: Theme JS-->
    <script src="/iris/resources/js/core/app-menu.min.js"></script>
    <script src="/iris/resources/js/core/app.min.js"></script>
    <!-- END: Theme JS-->

    <!-- BEGIN: Page JS-->
    <script src="/iris/resources/js/scripts/pages/auth-login.js"></script>
    <!-- END: Page JS-->
  <form action="<%=request.getContextPath() %>/login" name="loginForm" id="loginForm" method="post">
		<input type="hidden" name="email_id" id="email_id"/>
		<input type="hidden" name="user_name" id="user_name"/>
		<input id="profileImg" name="profileImg" type="hidden" />
		<input id="gToken" name="user_session_id" type="hidden" />
		<input id="device_type" name="device_type" type="hidden" />
	</form>
    <script>
      $(window).on('load',  function(){
        if (feather) {
          feather.replace({ width: 14, height: 14 });
        }
      })
      
      function login(){
		  var emp_name = $('#emp_name').val();
		  var password = $('#password').val();
		  if(emp_name != '' && password != ''){
			  $('#loginForm').submit();
		  }
      }
      var client;
      var access_token;

      function initClient() { 
    	  
        client = google.accounts.oauth2.initTokenClient({
          client_id: '180023549420-4araucipo8cil4matp902f64cte57md9.apps.googleusercontent.com',
          scope: 'https://www.googleapis.com/auth/calendar.readonly \
                  https://www.googleapis.com/auth/contacts.readonly',
          callback: (tokenResponse) => {
            access_token = tokenResponse.access_token;
          },
        });
      }
    	function decodeJwtResponse(token) {
            let base64Url = token.split('.')[1]
            let base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
            let jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
                return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
            }).join(''));
            return JSON.parse(jsonPayload)
        }

        let responsePayload;
        
    	window.handleCredentialResponse = (response) => {
    		  // decodeJwtResponse() is a custom function defined by you
    		  // to decode the credential response.
    		  responsePayload = decodeJwtResponse(response.credential);

    		  console.log("ID: " + responsePayload.sub);
    		  console.log('Full Name: ' + responsePayload.name);
    		  console.log('Given Name: ' + responsePayload.given_name);
    		  console.log('Family Name: ' + responsePayload.family_name);
    		  console.log("Image URL: " + responsePayload.picture);
    		  console.log("Email: " + responsePayload.email);
    		  if('${success}' == null || '${success}' == ''){
	    		  if('${invalidEmail}' == null || '${invalidEmail}' == ''){
	    			  $("#email_id").val(responsePayload.email);
	    			  $("#user_name").val(responsePayload.name);
	    			  $("#profileImg").val(responsePayload.picture);
	    			  $("#gToken").val(responsePayload.sub);
		    		  $("#loginForm").submit();
	    		  }else{
	    			 alert(profile.getEmail()+" do not have access to login. Please try with registered mail account (or) contact to admin.");
	    			 signOut();
			      }
		      }else if('${success}' == 'Successfully logged out'){
		    	  if('${invalidEmail}' == null || '${invalidEmail}' == ''){
		    		  $("#email_id").val(responsePayload.email);
	    			  $("#user_name").val(responsePayload.name);
	    			  $("#profileImg").val(responsePayload.picture);
	    			  $("#gToken").val(responsePayload.sub);
		    		  $("#loginForm").submit();
	    		  }
		      }else{
			      signOut();
		      }
    		}
    </script>
  </body>
  <!-- END: Body-->

<!-- Mirrored from pixinvent.com/demo/vuexy-html-bootstrap-admin-template/html/ltr/horizontal-menu-template/auth-login-cover.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 07 Aug 2022 05:36:01 GMT -->
</html>