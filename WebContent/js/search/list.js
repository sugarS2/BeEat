/***** hotplace-list *****/

$(function(){
	$(document).ready(function(){
		
		var searchText = $('.searchText').text(); 
		var currentNum = $('.currentNum').text(); 
		var totalNum = $('.totalNum').text(); 
		
		if(Number(currentNum) == Number(totalNum)){
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
		
	});
});
