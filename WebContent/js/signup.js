/* Validate */

$(function(){
	$(document).ready(function(){
		$('#validate_form').validate({
			rules:{
				email : {
					required:true, 
					email:true, 
					remote:{
						url:"../validate.do",
						type:"post"
					}
				},
				name : {required:true},
				pwd : {required:true},
				pwd_repeat : {equalTo:"#pwd"},
			},
			messages:{
				email : {
					required:"이메일을 입력하세요.", 
					email:"올바른 이메일 주소를 입력하세요.", 
					remote: $.validator.format("입력하신 {0}는 이미 존재하는 이메일입니다.")},
				name : {required:"이름(닉네임)을 입력하세요."},
				pwd : {required:"비밀번호를 입력하세요."},
				pwd_repeat : {equalTo:"비밀번호를 다시 확인하세요."},
			},
			submitHandler: function(form){
				alert("회원가입 성공!!");
				//window.location.href="../main.do";
				form.submit();
			},
		    success: function(e){
            }
		});
		
		
		function submitSignUp(){
			var request = $.ajax({
				url:"../member.do?method=signup", 
				method:"POST", 
				dataType:"json",
				data:{"email":$('#email').val(), "name":$('#name').val(), "pwd":$('#pwd').val()}
			});
			
			request.done(function(data){
				alert("회원가입 성공!");
				window.location.href="main.do";
			});
		}
		
	});
});