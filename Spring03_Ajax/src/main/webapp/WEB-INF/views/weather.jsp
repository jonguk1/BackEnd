<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>weather</title>
   <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    
    <script>
    	$(function(){
    		$('#btn').click(function(){
    			$.ajax({
        			url:'https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=c0da6e3347e9e94c10a95f8ad4e13f00',
        			dataType: 'json'
    			})
	    			.done(function(data){
	    				alert('success');
	    			})
	    			.fail(function(err){
	    				alert('err: '+err.status);
	    			})
    			
    			
    		})
    		
    		
    		
    	})
    
    </script>
    
    
    
</head>
<body>
	<button id="btn">날씨 알아오기</button>
	<div id="result">
	</div>
</body>
</html>