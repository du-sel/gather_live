package handler;

import java.sql.Timestamp;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.Member;
import dao.DAO;


public class AccountHandler implements CommonHandler {

	
	
	DAO dao;
	
	public AccountHandler setDAO(DAO dao) {
		this.dao = dao;
		return this;
	}


	
	
	
	@Override
	public String execute(HashMap<String, Object> map) {
		
		Member member = (Member)map.get("MEMBER");
		
		// 폼을 아직 거치지 않았음! 뷰로 연결
		if(member == null) {
			return "/code/05_join_2.jsp";
		}
		
		// 이미 폼을 거쳐서 들어왔음. Account 처리 필요 
		else {
			HttpSession session = (HttpSession)map.get("SESSION");
			session.setAttribute("MEMBER", member);
			return "redirect:../join/insert.do";
		}
		
	}
	

	
	
	
	
	
	
	
	

}
