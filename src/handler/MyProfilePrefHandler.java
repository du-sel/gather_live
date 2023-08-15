package handler;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import DTO.Member;
import dao.DAO;

public class MyProfilePrefHandler implements CommonHandler {
	
	DAO dao;
	
	public MyProfilePrefHandler setDAO(DAO dao) {
		this.dao = dao;
		return this;
	}

	
	
	@Override
	public String execute(HashMap<String, Object> map) {
		
		HttpSession session = (HttpSession)map.get("SESSION");
		Member member = (Member)map.get("MEMBER");
		
		dao.updateMember(member);
		
		session.setAttribute("ACCOUNT", member);
		
		
		return "redirect:../prfl.do?msg=ok";
	}

}
