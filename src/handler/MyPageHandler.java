package handler;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import DTO.Member;
import dao.DAO;

public class MyPageHandler implements CommonHandler {
	
	
	DAO dao;
	
	public MyPageHandler setDAO(DAO dao) {
		this.dao = dao;
		return this;
	}
	
	
	

	@Override
	public String execute(HashMap<String, Object> map) {
		
		HttpSession session = (HttpSession)map.get("SESSION");
		
		Member account = (Member)session.getAttribute("ACCOUNT");
		
		// 로그인 되어있지 않다면 돌려보내기 
		if(account == null) {
			
			return "referer:?error=needLogin";
			
		} else {
		
			
			// 악기, 지역 정보 추가로 저장
			session.setAttribute("MYINST", dao.getMyInst(account));
			session.setAttribute("MYLOCA", dao.getMyLoca(account));
			
			// 나이 저장
			session.setAttribute("MYAGE", dao.getMemberAge(account));
			
			
			// 프로필 한꺼번에 저장
			session.setAttribute("MYPROFILE", dao.getProfile(account));
			
			return "/code/03_my_main.jsp";
			
		}
		
		
	}

}
