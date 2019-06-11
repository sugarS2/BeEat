/***** hotplace-list *****/

$(function(){
	$(document).ready(function(){
		
		var searchText = $('.searchText').text(); 
		var currentNum = $('.currentNum').text(); 
		var totalNum = $('.totalNum').text(); 
		
		//alert(Number(currentNum) + ' , ' + Number(totalNum));
		if(Number(currentNum) >= Number(totalNum)){
			$('.hotplace-more-view').hide();
		}
		
		// 더보기 버튼 클릭시
		$('.hotplace-more-view').click(function(){
			//alert(currentNum + ", " + totalNum);
			if(Number(currentNum) < Number(totalNum)){
				currentNum++;
				$('.currentNum').html(currentNum);
				location.href="search.do?method=search&searchText="+searchText+"&num="+currentNum;
			}
		});
		
		// TOP버튼
		$(window).scroll(function() {
            if ($(this).scrollTop() > 1000) {
                $('#MOVE_TOP_BTN').fadeIn();
                $('#MOVE_TOP_BTN').css('bottom', '60px');
                if($(this).scrollTop() > 1500){
                	$('#MOVE_TOP_BTN').css('bottom', '135px');
                	console.log($(this).scrollTop());
                }
            } else {
                $('#MOVE_TOP_BTN').fadeOut();
            }
        });
        
        $("#MOVE_TOP_BTN").click(function() {
            $('html, body').animate({
                scrollTop : 0
            }, 400);
            return false;
        });

		
	});
});
