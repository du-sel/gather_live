<%@page import="org.json.simple.JSONArray"%>
<%@page import="DTO.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<script>

/* 	let data = [
		
		{
			"g1" : "건반",
			"name" : ["피아노", "신디사이저"]
		},
		
		{
			"g1" : "기타/베이스",
			"name" : ["기타", "베이스"]
		}
	
	] */
	
	
	let data = <%=(JSONArray)application.getAttribute("JSONINST") %>



	const getSecond = function(g1) {
		
		console.log(data);
		
		let second = document.getElementById("second");
		
		second.options.length = 0;
		second.add(new Option("-- 소분류 --", ""));
		
		for(let i = 0; i<data.length; i++) {
			let g1InData = data[i].g1;
			let nameInData = data[i].name;
			
			if(g1 == g1InData) {
				for(let j = 0; j<nameInData.length; j++) {
					let name = nameInData[j];
					second.add(new Option(name, name));
				}
			}
		}
		
		
	}


</script>
</head>
<body>



	<select id="first" onchange="getSecond(this.options[selectedIndex].value)">
		<option>-- 대분류 --</option>
		<option value="건반">건반</option>
		<option value="기타/베이스">기타/베이스</option>
	</select>

	<select id="second" onchange="alert(this.options[selectedIndex].value)">
		<option>-- 소분류 --</option>
	</select>

</body>
</html>