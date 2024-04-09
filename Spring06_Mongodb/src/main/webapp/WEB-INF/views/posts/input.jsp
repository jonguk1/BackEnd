<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::POSTS::</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.min.js"></script>

<script>
	$(function(){
		//showPosts();//포스트 목록 가져오기
		$('#frm').submit(function(e){
			e.preventDefault();
			let str=$('#btn').text();
			if(str=='글쓰기'){
				addPosts();
			}else if(str=='글수정'){
				updatePosts();
			}
			
		})	
	})

	const addPosts=function(){
		//alert('a')
		//[1] 작성자,title값 얻어오기
		let author=$('#author').val();
		let title=$('#title').val();
		
		//[2] ==> json유형의 객체로 만들기
		let data={
				title:title,
				author:author
		}
		//ajax요청 보내기. url: posts, method:post
		$.ajax({
			type:'post',
			url:'posts',
			data:data,
			dataType:'json',
			cache:false,
			success:function(res){
				alert(JSON.stringify(res));
			},
			error:function(err){
				alert('err: '+ err.status);
			}
		})
		
		
		
	}
	
	const updatePosts=function(){
		
	}
	
</script>


</head>
<body>
<div id="wrap" class="container">
    <h1>Posts 글쓰기</h1>
    <form id="frm" name="frm">
        <input type="hidden" name="id" id="id">
        <ul>
            <li>Author: </li>
            <li>
                <input type="text" name="author" id="author" placeholder="Author" required>
            </li>
            <li>
                <textarea name="title" id="title" placeholder="Title" rows="5" cols="70"></textarea>
            </li>
            <li>
                <button id="btn">글쓰기</button>
            </li>
        </ul>
    </form>
    
    <div id="postList">
        여기에 포스트 목록 들어올 예정
    </div>
</div>
</body>
</html>