$(document).ready(function(){
	
	$("#formCercaAuto").validate({
		rules: {
			
			costoBaseMin: {
				number: true
			},
			costoBaseMax: {
				number: true
			},
			costoMin: {
				number: true
			},
			costoMax: {
				number: true
			}
						
		}
	});
	
	$("#addSubmit").validate({ 
 onsubmit: false,
 submitHandler: function(form) {  
   if ($(form).valid())
   {
       form.submit(); 
   }
   return false; // prevent normal form posting
 }
});
})