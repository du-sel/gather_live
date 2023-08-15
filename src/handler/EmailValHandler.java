package handler;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.Member;
import dao.DAO;

public class EmailValHandler implements CommonHandler {

	DAO dao;
	
	public EmailValHandler setDAO(DAO dao) {
		this.dao = dao;
		return this;
	}
	
	
	
	@Override
	public String execute(HashMap<String, Object> map) {
		
		String email = (String)map.get("EMAIL");
		
		if(email == null) {
			
			return "/code/05_join_1.jsp";
			
		} else {
			
			Member member = dao.getMemberByMail(email);
			
			if(member.getUser_name() == null) {	// 기존 이메일 중에 일치하는 게 없으면
				HttpSession session = (HttpSession)map.get("SESSION");
				session.setAttribute("EMAIL", email);
				return "redirect:../join/account.do";
			} else {	// 중복된 이메일이 있으면
				return "referer:?error=duplicate";
			}
		}
				
	}

	

}
