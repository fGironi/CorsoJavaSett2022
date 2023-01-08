$(document).ready(function(){
	
	$("#formAggiuntaAuto").validate({
		rules: {
			"automobile.targa" : {
				required: true,
				minlength: 6,
				maxlength: 10
			},
			"automobile.costoBase": {
				required: true,
				number: true,
				min: 1000
			},
			"automobile.costruttore":{
				required: true
			},
			"automobile.alimentazione":{
				required: true
			},
			"automobile.annoCostruzione":{
				required: true
			},
			"automobile.colore":{
				required: true
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