<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


</head>
<body id="my_rcrt" class="my">




	<section id="main">
		
		<div class="inner">

			
			<div id="header">
				<h1 class="h1"><a href="../my/main.do">마이 페이지</a></h1>
				<h3>내가 쓴 글 관리</h3>
			</div>


			<div class="flex_c">

				<jsp:include page="../0_my_lnav.jsp"></jsp:include>
	

					<section id="list_c">
					
						<h2>내가 쓴 모집글</h2>
			
						<ul class="list">
							<li class="post"><a href="01_rcrt_post.jsp">MY POST</a></li>
							<li class="post"><a href="01_rcrt_post.jsp">MY POST</a></li>
							<li class="post"><a href="01_rcrt_post.jsp">MY POST</a></li>
						</ul>
						
						<ol id="paging">
							<a>《</a>
							<a>〈</a>
							<li><a>1</a></li>
							<li><a>2</a></li>
							<li><a>3</a></li>
							<li><a>4</a></li>
							<a>〉</a>
							<a>》</a>
						</ol>
		
					</section>
		

				
			</div>








		</div>



		<a id="talk">
			<img src="/gatherlive/resources/img/img_ico_talk.png">
		</a>

		<a id="btn_toTop" href="#">
			<img src="/gatherlive/resources/img/ico_btn_toTop.svg">
		</a>

	</section>









	<script src="/gatherlive/resources/js/gnav.js"></script>
	
	<script>
	
		$(()=> {
			
			// gnav current 클래스 지정
			$('#gnav .nav_mypage').addClass('current');
			
			// lnav current 클래스 지정
			$('#lnav .my_rcrt').addClass('current');
		
	
		});

	
	</script>
	
	

</body>
</html>