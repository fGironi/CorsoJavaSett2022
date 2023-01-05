$(document).ready(function(){
	
	$("#formAggiuntaAuto").validate({
		rules: {
			"automobile.targa" : {
				required: true,
				minlength: 7,
				maxlength: 7
			},
			"automobile.costoBase": {
				required: true,
				number: true,
				min: 1000
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