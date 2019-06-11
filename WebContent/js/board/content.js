function reReply(br_idx){
	this.br_idx = br_idx;
	$('.name').attr("type", "text");
	$('.br_content').attr("type", "text");
	$('.insertReRe').attr('type', 'button');
}


$('.inputReBtn').click(function(){
	var rowItem = "<tr class='reply-input-content'>"
		rowItem += "<td> <input type='text' name='br_content' class='br_content'> </td>"	
		rowItem += "<td> <button type='button' name='insertReRe' class='ReReBtn'>작성</button> </td>"
		rowItem += "</tr>"

	$(this).after(rowItem);
	$(this).attr('type', 'hidden');
});
$(document).on("click","button[name=insertReRe]",function(){
    var trHtml = $(this).parent().parent();
    var rowItem = "<tr>"
		rowItem += "<td><input type='button' value='[답글]' class='inputReBtn' /></td>"
		rowItem += "</tr>"
	var email = $('.board-reply-list .m_name').val();
    var br_content = $('.reply-input-content .br_content').val();
    var br_refer = $('.board-reply-list .br_refer').val();
    var br_lev = $('.board-reply-list .br_lev').val();
    var br_order = $('.board-reply-list .br_order').val();
    var b_code = $('.board-reply-list .b_code').val();
    $.ajax({
    	url:"board.do?method=insertReRe",
    	type:"POST",
    	data:{"email":email, "br_content":br_content, "br_refer":br_refer, "br_lev":br_lev, "br_order":br_order, "b_code":b_code},
    }).done(function(){
    	location.href="board.do?method=content&b_code="+b_code;
    });
	trHtml.after(rowItem);		
    trHtml.remove();
     
});

$('.insertReRe').click(function() {
	alert("띵똥");
    //$(this).closest("tr").remove()
    
});