$(function() {
	$(document).ready(function() {
		$('.hotplace-category li').hover(
			function() {
				$(this).addClass('hovered');
			}, function() {
				$(this).removeClass('hovered');
		});
	});
});


/*function category(c_code){
	var request = $.ajax({
		url:"hotplace.do?method=findByCategory",
		type:"POST",
		data:{"c_code":c_code}
	});
	
	request.done(function(data){
		location.href="hotplace.do?method=list";
	});
}*/