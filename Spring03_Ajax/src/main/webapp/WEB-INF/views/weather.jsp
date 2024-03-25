<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>weather</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">

<!-- jQuery library -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<script>
    	$(function(){
    		$('#btn').click(function(){
    			$.ajax({
        			url:'http://api.openweathermap.org/data/2.5/weather?q=pohang&appid=c0da6e3347e9e94c10a95f8ad4e13f00',
        			dataType: 'json'
    			})
	    			.done(function(data){
	    				let name = data.name;
    					let temp =Math.round(data.main.temp-273.15);
    					let humidity = data.main.humidity;
    					let weather = data.weather[0].main;
    					let str=`
    					    <h3>\${name}</h3>
    						<h3>현재 온도:\${temp}°C</h3>
    						<h3>현재 습도:\${humidity}%</h3>
    						<h3>현재 날씨:\${weather}</h3>
    					`;
    					if(weather =='Rain'){
    						str+= `
        						<svg xmlns="http://www.w3.org/2000/svg" width="100" height="100" fill="currentColor" class="bi bi-cloud-rain-fill" viewBox="0 0 16 16">
  						 	    	<path d="M4.158 12.025a.5.5 0 0 1 .316.633l-.5 1.5a.5.5 0 1 1-.948-.316l.5-1.5a.5.5 0 0 1 .632-.317m3 0a.5.5 0 0 1 .316.633l-1 3a.5.5 0 1 1-.948-.316l1-3a.5.5 0 0 1 .632-.317m3 0a.5.5 0 0 1 .316.633l-.5 1.5a.5.5 0 1 1-.948-.316l.5-1.5a.5.5 0 0 1 .632-.317m3 0a.5.5 0 0 1 .316.633l-1 3a.5.5 0 1 1-.948-.316l1-3a.5.5 0 0 1 .632-.317m.247-6.998a5.001 5.001 0 0 0-9.499-1.004A3.5 3.5 0 1 0 3.5 11H13a3 3 0 0 0 .405-5.973"/>
  						        </svg>
    						`;	
    					}else if(weather =='Clouds'){
       						str+= `
       							<svg xmlns="http://www.w3.org/2000/svg" width="100" height="100" fill="currentColor" class="bi bi-cloud" viewBox="0 0 16 16">
       						  		<path d="M4.406 3.342A5.53 5.53 0 0 1 8 2c2.69 0 4.923 2 5.166 4.579C14.758 6.804 16 8.137 16 9.773 16 11.569 14.502 13 12.687 13H3.781C1.708 13 0 11.366 0 9.318c0-1.763 1.266-3.223 2.942-3.593.143-.863.698-1.723 1.464-2.383m.653.757c-.757.653-1.153 1.44-1.153 2.056v.448l-.445.049C2.064 6.805 1 7.952 1 9.318 1 10.785 2.23 12 3.781 12h8.906C13.98 12 15 10.988 15 9.773c0-1.216-1.02-2.228-2.313-2.228h-.5v-.5C12.188 4.825 10.328 3 8 3a4.53 4.53 0 0 0-2.941 1.1z"/>
       							</svg>
    						`;
    					}else{
       						str+= `
       							<svg xmlns="http://www.w3.org/2000/svg" width="100" height="100" fill="currentColor" class="bi bi-brightness-high-fill" viewBox="0 0 16 16">
       						  		<path d="M12 8a4 4 0 1 1-8 0 4 4 0 0 1 8 0M8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0m0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13m8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5M3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8m10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0m-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0m9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707M4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708"/>
       							</svg>
    						`;
    					}
    					if(data.main.temp>=300){
       						str+= `
       							<h3>오늘은 더운 날씨 입니다 
       								<img src="resources/image/더운 날씨.PNG" style= "width:100px;height:150px"/>
       							</h3>
    						`;
    					}else if(data.main.temp>=200 && data.main.temp<300){
       						str+= `
       							<h3>오늘은 보통 날씨 입니다
       								<img src="resources/image/보통 날씨.PNG" style= "width:100px;height:150px"/>
       							</h3>
    						`;
    					}else{
       						str+= `
       							<h3>오늘은 추운 날씨 입니다
       								<img src="resources/image/추운 날씨.PNG" style= "width:100px;height:150px"/>
       							</h3>
       							
    						`;
    					}
    					
    					
    					$('#result').html(str).addClass('alert alert-primary');
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
	<div id="result"></div>
</body>
</html>