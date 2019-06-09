function reReply(br_idx){
	this.br_idx = br_idx;
	$('.name').attr("type", "text");
	$('.br_content').attr("type", "text");
	$('.insertReRe').attr('type', 'button');
}


$('.inputReBtn').click(function(){
	var replyInput = $(this).closest('div').addClass('aa');
	
	//replyInput.$('.trHidden .name').attr("type", "text");
});