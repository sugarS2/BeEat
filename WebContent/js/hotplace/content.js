var mapContainer = document.getElementById('daumMap'), // 지도를 표시할 div 
    mapOption = {
        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new daum.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new daum.maps.services.Geocoder();

var x,y;

// 주소로 좌표를 검색합니다
geocoder.addressSearch($('.totalAddr').html(), function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === daum.maps.services.Status.OK) {

        var coords = new daum.maps.LatLng(result[0].y, result[0].x);
        y = result[0].y;
        x = result[0].x;
        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new daum.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new daum.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+$('.h_name').html()+'</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    

$('#daumMap').click(function(){
	window.open('http://map.daum.net/link/to/'+$('.totalAddr').html()+','+x+','+y);
})


/******** updateReply ********/
var hr_idx;
var h_code = $('.hotplace-reply-input .h_code').val();
function updateReply(hr_idx, hr_content){
	this.hr_idx = hr_idx;
	$('.hotplace-reply-input .hr_content').val(hr_content);
	$('.hotplace-reply-input .replyBtn').val('수 정');
	$('.hotplace-reply-input .resetBtn').attr("type", "button");
}



/******** checkReplyBtn('댓글달기'버튼인지 '댓글수정'버튼인지) ********/
function checkReplyBtn(){
	var replyBtn = $('.hotplace-reply-input .replyBtn').val();
	var hr_content = $('.hotplace-reply-input .hr_content').val();
	var email = $('.hotplace-reply-input .email').val();
	if(replyBtn=='댓 글 달 기'){
		$.ajax({
			url:"h_reply.do?method=insert",
			type:"POST",
			data:{"h_code":h_code, "email":email, "hr_content":hr_content},
		}).done(function(){
			location.href="hotplace.do?method=content&h_code="+h_code;
		});
	}else if(replyBtn=='수 정'){
		$.ajax({
			url:"h_reply.do?method=update",
			type:"POST",
			data:{"hr_idx":hr_idx, "hr_content":hr_content},
		}).done(function(){
			location.href="hotplace.do?method=content&h_code="+h_code;
		});
	}
}

/******** 취소 버튼 눌렀을 때 ********/
function changeReplyBtn(){
	$('.hotplace-reply-input .resetBtn').attr("type", "hidden");
	$('.hotplace-reply-input .hr_content').val("");
	$('.hotplace-reply-input .replyBtn').val('댓 글 달 기');
}


/******** 삭제 버튼 눌렀을 때 ********/
function deleteReply(hr_idx){
	$.ajax({
		url:"h_reply.do?method=delete",
		type:"POST",
		data:{"hr_idx":hr_idx},
	}).done(function(){
		location.href="hotplace.do?method=content&h_code="+h_code;
	});
}