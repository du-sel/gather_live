<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="img/ico_favi-32.png">
<title>게더라이브 - Gather Live</title>

<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square-round.css" rel="stylesheet">

<link rel="stylesheet" href="css/css_base2.css" media="all">
<link rel="stylesheet" href="css/css_layout3.css" media="all">

<script type="text/javascript" src="js/jquery-3.6.4.js"></script>

<script src="js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css">

<!-- <script src="../js/jquery.jscrollpane.min.js"></script>
<script src="../js/jquery.mousewheel.js"></script>
<link rel="stylesheet" href="../css/jquery.jscrollpane.css">
<link rel="stylesheet" href="../css/jquery.custom.jscrollpane.css">
<script src="../js/scroll.js"></script> -->

<script>

	$(()=> {

		function make2Rows(iWidth) { 
		let iHeight = parseFloat($('.flexslider .slides > li').height());
			$('.alliance-list .slides > li').css('width', iWidth+'px');
		}


		let itemCnt = 3;  
		let iWidth = parseFloat($('.flexslider').width() / itemCnt);
		$('.flexslider').flexslider({
				animation: "slide",
				slideshowSpeed: 1000,
				animationSpeed: 300,
				animationLoop: false,
				directionNav: true,
				controlNav: false, 
				slideshow: false,
				touch: true,
				move: 1, 
				itemWidth: iWidth,
				itemMargin: 20,
				minItems: 3,
				maxItems: 3,
				start: make2Rows(iWidth)
			});

		$(window).on('resize', function() {
			let windowWidth = $( window ).width();
			if(windowWidth >= 768) {
				itemCnt = 3;
			} else if(windowWidth < 768 && windowWidth >= 576) {
				itemCnt = 2;
			} else if(windowWidth < 576) {
				itemCnt = 1;
			}
			iWidth = parseFloat($('.flexslider').width() / itemCnt);

			$('.flexslider').flexslider({
				animation: "slide",
				slideshowSpeed: 1000,
				animationSpeed: 300,
				animationLoop: false,
				directionNav: true,
				controlNav: false, 
				slideshow: false,
				touch: true,
				move: 1, 
				itemWidth: iWidth,
				itemMargin: 20,
				minItems: 1,
				maxItems: 3,
				start: make2Rows(iWidth)
			});
		});
			
			
			
			
			
	});


</script>


</head>
<body id="intro">





	<section id="main">
	
		<div class="inner">

			
			<section class="sec main">
	
				<div id="img_main_c"></div>
				
				
				<h2 id="catch" class="desc title">함께 연주할 사람들이 있는 곳</h2>
				<h1 id="title_main" class="desc">게더라이브</h1>
				
				<h4 class="desc">
					음악은 혼자 할 때보다 여럿이 함께 할 때 더욱 즐겁죠!<br>
					게더라이브에서 함께 연주할 사람들을 찾아보세요!
				</h4>
			
			</section>
			
			
			
			<section class="sec rcrt">

				<div class="gridbox">

					<div class="img_c"></div>
					
					<h3 class="desc title">모집글로 찾기</h3>
					<h4 class="desc">
						단 하나의 곡을 목표로 하는 단기 합주부터<br>
						꾸준히 함께 활동할 밴드 멤버 구인까지!<br><br>
						원하는 조건으로 모집글을 게시해보세요 <br>
						나에게 딱 맞는 연주자가 찾아올 거예요
					</h4>
				</div>
				

				<div class="list_c">

					<h4>최근 모집글</h4>
					
					<div class="flexslider">
						<ul class="slides list rcrt">
							<li class="post rcrt"><a href="/00_Gather_Live/code/01_rcrt_post.jsp">
								<div class="postTop"></div>
								<div class="postInner">
									모집글 목록1
								</div>
							</a></li>
							<li class="post rcrt"><a href="#">모집글 목록2</a></li>
							<li class="post rcrt"><a href="#">모집글 목록3</a></li>
							<li class="post rcrt"><a href="#">모집글 목록4</a></li>
							<li class="post rcrt"><a href="#">모집글 목록5</a></li>
							<li class="post rcrt"><a href="#">모집글 목록6</a></li>
							<li class="post rcrt"><a href="#">모집글 목록7</a></li>
							<li class="post rcrt"><a href="#">모집글 목록8</a></li>
						</ul>
					</div>
					
					<h4 class="btn_toList"><a href="/00_Gather_Live/code/01_rcrt_list.jsp">
						모집글 더 보러가기
						<img src="img/ico_arrowCircle.svg" style="width: 2.2rem">
					</a></h4>
				</div>

			</section>
			
			
			
			
			
			<section class="sec prfl">
				
				<div class="gridbox">

					<div class="img_c">
						<img id="img_prfl" alt="프로필 이미지">
					</div>
					
					<h3 class="desc title">프로필로 찾기</h3>
					<h4 class="desc">
						다른 연주자들의 프로필을 살펴보세요! <br>
						내가 찾던 바로 그 사람이 숨어있을지도 몰라요
					</h4>
				</div>
					

				<div class="list_c">

					<h4>지금 활동 중인 프로필</h4>
					
					<div class="flexslider">
					
						<ul class="slides list prfl">
							<li class="post prfl"><a href="#">프로필 목록1</a></li>
							<li class="post prfl"><a href="#">프로필 목록2</a></li>
							<li class="post prfl"><a href="#">프로필 목록3</a></li>
							<li class="post prfl"><a href="#">프로필 목록4</a></li>
							<li class="post prfl"><a href="#">프로필 목록5</a></li>
							<li class="post prfl"><a href="#">프로필 목록6</a></li>
							<li class="post prfl"><a href="#">프로필 목록7</a></li>
							<li class="post prfl"><a href="#">프로필 목록8</a></li>
						</ul>
					
					</div>
					
					<h4 class="btn_toList"><a href="/00_Gather_Live/code/02_prfl_list.jsp">
						프로필 더 보러가기
						<img src="img/ico_arrowCircle.svg" style="width: 2.2rem">
					</a></h4>
				</div>

			</section>
			
			
			
			
			<section class="sec talk">

				<div class="gridbox">

					<div id="img_talk_c"></div>
					
					<h3 class="desc title">게더톡</h3>
					<h4 class="desc">
						마음에 드는 모집글을 발견했거나<br>
						함께하고 싶은 연주자를 발견했을 때,<br>
						게더톡을 통해 쉽고 빠르게 연락할 수 있어요
					</h4>

				</div>

			</section>
			
			
			
			
			<section class="sec join">
				<h3>지금 게더라이브에서 당신의 음악이 시작됩니다!</h3>
				<h3 id="btn_join"><a href="/00_Gather_Live/code/05_join_1.jsp">회원 가입 하러가기</a></h3>
			</section>
			
		</div>
			
		
		
		<div id="frame_c">
			<iFrame src="/00_Gather_Live/talk/00_talk_main.jsp"
					name="talk_frame"		
					id="talk_frame"		
					> iFrame 태그를 지원하지 않는 브라우저입니다. 
			</iFrame>
		</div>
		
		
		<a id="talk">
			<img src="img/ico_talk-test.svg">
		</a>
	
		<a id="btn_toTop" href="#">
			<img src="img/ico_btn_toTop.svg">
		</a>


	</section>











	<!-- <script src="/00_Gather_Live/js/gnav.js"></script> -->

	<script>
	
		$(()=> {
			
			/* $('#talk').click(function() {
				//$(this).toggle();
				document.talk_frame.src = "/00_Gather_Live/talk/00_talk_main.jsp";
				$('#frame_c').toggle("fast");
			});
		
	
			$('#talk_frame').contents().find('#ico_close').click(function() {
				//$(this).toggle();
				alert("누름");
				$('#frame_c').hide("fast");
			}); */
			
			
			$('#talk_frame').load(function() {
				$(this).contents().find('#ico_close').click(function() {
					alert("누름");
					$('#frame_c').hide("fast");
				});
			});


		});
		
	
			




		//메인 이미지
		let img_main_c = document.getElementById('img_main_c');
		let img_main = new Image();
		img_main.src = "img/img_main_test.svg";
		img_main.alt = "메인 이미지";
		img_main.style.width = "100%";

		img_main_c.appendChild(img_main);



		//모집글 이미지
		let img_rcrt_c = document.querySelector('.sec.rcrt .img_c');
		let img_rcrt = new Image();
		img_rcrt.src = "img/img_main_rcrt.svg";
		img_rcrt.alt = "모집글 이미지";
		img_rcrt.style.width = "100%";

		img_rcrt_c.appendChild(img_rcrt);



		//프로필 이미지
		let img_prfl_c = document.querySelector('.sec.prfl .img_c');
		let img_prfl = new Image();
		img_prfl.src = "img/img_main_prfl-test.svg";
		img_prfl.alt = "프로필 이미지";
		img_prfl.style.width = "100%";

		img_prfl_c.appendChild(img_prfl);



		//게더톡 이미지
		let img_talk_c = document.querySelector('.sec.talk #img_talk_c');
		let img_talk = new Image();
		img_talk.src = "img/img_talk.svg";
		img_talk.alt = "게더톡 이미지";
		img_talk.style.width = "100%";

		img_talk_c.appendChild(img_talk);




		
		



	</script>


</body>
</html>