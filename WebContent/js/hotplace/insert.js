/* Validate */

$.validator.addMethod("extension", function (value, element, param) {
    param = typeof param === "string" ? param.replace(/,/g, '|') : "png|jpe?g";
    return this.optional(element) || value.match(new RegExp(".(" + param + ")$", "i"));
});

$(function(){
	$(document).ready(function(){
		
		$('#insert-form').validate({
			rules : {
				h_name : {required:true},
				h_address : {required:true},
				h_info : {required:true},
				//h_tel : {required:true},
				//h_time : {required:true},
				h_menu : {required:true}, 
				h_img1 : {
					required:true, 
					extension:"jpg|png|gif"
				},
				h_img2 : {extension:"jpg|png|gif"},
				h_img3 : {extension:"jpg|png|gif"}
			},
			messages : {
				h_name : {required:"매장이름을 입력해주세요."},
				h_address : {required:"상세주소를 입력해주세요."},
				h_info : {required:"매장 정보 및 소개를 입력해주세요."},
				//h_tel : {required:"매장 전화번호를 입력해주세요."},
				//h_time : {required:"매장 운영시간을 입력해주세요."},
				h_menu : {required:"매장의 대표메뉴를 입력해주세요."}, 
				h_img1 : {
					required:"대표 이미지 1개는 필수로 올리셔야 합니다.",
					extension:"이미지 확장자는 .jpg 또는 .png , .gif 만 가능합니다."
				},
				h_img2 : {extension:"이미지 확장자는 .jpg 또는 .png , .gif 만 가능합니다."},
				h_img3 : {extension:"이미지 확장자는 .jpg 또는 .png , .gif 만 가능합니다."}
			},
			submitHandler: function(form){
				form.submit();
			},
			success : function(){}
		});
		
		
	});
});