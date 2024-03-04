/**
 * 
 */
function bbs_check(){
	var title=document.getElementById('title');
	var writer=document.getElementById('writer');
	var content=document.getElementById('content');//document.querySelector('#content')
	if(!title.value){
		alert('글제목을 입력하세요');
		title.focus();
		return false;
	}
	
	if(!writer.value){
		alert('작성자를 입력하세요');
		writer.focus();
		return false;
	}
	
	if(!content.value){
		alert('글내용을 입력하세요');
		content.focus();
		return false;
	}
	return true;
}//------------------------------------------
 
 