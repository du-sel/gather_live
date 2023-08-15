package handler;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import DTO.Member;
import dao.DAO;

public class MyProfileHandler implements CommonHandler {
	
	DAO dao;
	
	public MyProfileHandler setDAO(DAO dao) {
		this.dao = dao;
		return this;
	}
	
	

	@Override
	public String execute(HashMap<String, Object> map) {
		
		HttpSession session = (HttpSession)map.get("SESSION");
		Member account = (Member)session.getAttribute("ACCOUNT");
		
		session.setAttribute("MYPROFILE", dao.getProfile(account));
		
		
		return "/code/03_my_prfl.jsp";
	}

}
