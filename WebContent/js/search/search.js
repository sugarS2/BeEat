$(function(){
	$('#searchText').autocomplete({

		source:function(request, response){
			$.ajax({
				type:"post",
				dataType:"json",
				url:"search.do?method=find",
				data:{"searchText" : $("#searchText").val()},
				success : function(data){
					console.log(data);
					response($.map(data,function(item){	
						return{
							label: "[" +item.c_name+"] " + item.h_name + " (" + item.loc_addr1 + " " + item.loc_addr2 + ") ", //label :화면에 보여지는 텍스트
							value:item.h_name,  //value : 실제 text태그에 들어갈 값
						}
					}));
				},
				error : function(data){
					alert("error 발생" + data);
				}
			});
		},
		minLength:1,
		select : function(event, ui){
			console.log(ui.item.value);
			location.href='search.do?method=search&searchText=' + ui.item.value;
		}
	});
});


function search(searchText){
	var regex = /\s/;
		if(keyword == null || keyword == "" || keyword == " "){
			alert('검색어를 입력해 주세요!');
			return;
		}else{
			location.href='search.do?method=search&searchText=' + searchText;
	  	}
}