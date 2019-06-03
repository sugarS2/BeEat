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