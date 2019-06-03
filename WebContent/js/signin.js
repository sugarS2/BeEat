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
		    success: function(){}
		});
		
	});
});

function check_user(){
	var email =$('#email').val();
	var pwd =$('#pwd').val();
	jQuery.ajax({
		url:"../member.do?method=signin",
		type:"post",
		data: {"email":email, "pwd":pwd},
		success : function(response){
			if (response=="true") {
				alert('로그인 성공!');   
				window.location="../main.do";
            } else {
            	$('.error_msg').html('로그인 정보가 일치하지 않습니다.');
            }
		}
	});
}
