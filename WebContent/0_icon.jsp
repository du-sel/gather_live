<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	
	<script type="text/javascript" src="resources/js/jquery-3.6.4.js"></script>
	<script>
	

		
		$(()=> {
			
			$('#talk').click(function() {
				//$(this).toggle();
				$('#talk_frame').toggle("fast");
			});
		

		});

		$(()=> {
			
			$('#ico_close').click(function() {
				//$(this).toggle();
				alert("누름");
				$('#talk_frame').css("display","none");
			});
		

		});

			
			


	
	
	</script>


	<iFrame src="/gatherlive/talk/00_talk_main.jsp"
		  name="talk_frame"		
		  id="talk_frame"		
		  > iFrame 태그를 지원하지 않는 브라우저입니다. 
	</iFrame>
	
	<%-- <section id="talk_frame">
		<jsp:include page="talk/00_talk_main.jsp"/>
	</section> --%>
	
	
	<a id="talk">
		<img src="resources/img/ico_talk-test.svg">
	</a>

	<a id="btn_toTop" href="#">
		<img src="resources/img/ico_btn_toTop.svg">
	</a>




</html>