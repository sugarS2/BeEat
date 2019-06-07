$(function() {
	$(document).ready(function() {
		$('.hotplace-category li').hover(
			function() {
				$(this).addClass('hovered');
			}, function() {
				$(this).removeClass('hovered');
		});
		
		$('.orderList').change(function(){
			var order = $('.orderList option:selected').attr('value');
			var c_code = $('.clicked a').attr('id');
			$.ajax({
				url:"hotplace.do?method=findByOptions",
				type:"POST",
				data:{"order":order, "c_code":c_code}
			});
			alert(c_code+', ' + order);
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