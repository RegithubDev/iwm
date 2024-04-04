
    $("#VisibilityIcon").click(function(){
        var fieldType = $("#passwordField").attr('type');
        if(fieldType === 'password'){
			
            $("#passwordField").attr('type', 'text');
            $("#VisibilityIcon").removeClass('fa-eye').addClass('fa-eye-slash');
        } else {
            $("#passwordField").attr('type', 'password');
            $("#VisibilityIcon").removeClass('fa-eye-slash').addClass('fa-eye');
        }
    });
