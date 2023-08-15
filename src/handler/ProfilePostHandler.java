package handler;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import DTO.Member;
import dao.DAO;

public class ProfilePostHandler implements CommonHandler {

	DAO dao;
	
	public ProfilePostHandler setDAO(DAO dao) {
		this.dao = dao;
		return this;
	}
	
	
	@Override
	public String execute(HashMap<String, Object> map) {
		
		HttpSession session = (HttpSession)map.get("SESSION");
		
		int id = (Integer)map.get("ID");
		Member member = dao.getMemberByID(id);
		
		// 비공개멤버이므로 접근 차단
		if(member.getOpen() != 1) {
			
		}
		
		
		HashMap<String, Object> profile = dao.getProfile(member);
		session.setAttribute("PROFILE", profile);
		
		session.setAttribute("PNO", (Integer)map.get("PNO"));
		
		return "/code/02_prfl_post.jsp";
	}

}
