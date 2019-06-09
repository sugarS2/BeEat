/* Validate */

$.validator.addMethod("extension", function (value, element, param) {
    param = typeof param === "string" ? param.replace(/,/g, '|') : "png|jpe?g";
    return this.optional(element) || value.match(new RegExp(".(" + param + ")$", "i"));
});

$(function(){
	$(document).ready(function(){
		
		$('#insert-form').validate({
			rules : {
				b_title : {required:true},
				b_content : {
					required:true,
					minlength : 10
				}, 
				b_img1 : {
					required:true, 
					extension:"jpg|png"
				},
				b_img2 : {extension:"jpg|png"},
				b_img3 : {extension:"jpg|png"}
			},
			messages : {
				b_title : {required:"제목을 입력해주세요."},
				b_content : {
					required:"본문 내용을 입력해주세요.",
					minlength : "본문 내용은 10자 이상 입력주세요."
				},		
				b_img1 : {
					required:"대표 이미지 1개는 필수로 올리셔야 합니다.",
					extension:"이미지 확장자는 .jpg 또는 .png만 가능합니다."
				},
				b_img2 : {extension:"이미지 확장자는 .jpg 또는 .png만 가능합니다."},
				b_img3 : {extension:"이미지 확장자는 .jpg 또는 .png만 가능합니다."}
			},
			submitHandler: function(form){
				form.submit();
			},
			success : function(){}
		});
		
		
	});
});