/* Validate */
$(function(){
	$(document).ready(function(){
		$('#validate_form').validate({
			rules:{
				email : {
					required:true, 
					email:true, 
				},
				pwd : {required:true}
			},
			messages:{
				email : {
					required:"이메일을 입력하세요.", 
					email:"올바른 이메일 주소를 입력하세요."
				},
				pwd : {required:"비밀번호를 입력하세요."}
			},
			submitHandler: function(form) {
		        form.submit(); // 유효성 검사 통과시 전송
		    },
		    success: function(e){
                //
            }
		});
		
	});
});