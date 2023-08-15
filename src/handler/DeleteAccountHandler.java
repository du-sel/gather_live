package handler;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import DTO.Member;
import dao.DAO;

public class DeleteAccountHandler implements CommonHandler {

	
	DAO dao;
	
	public DeleteAccountHandler setDAO(DAO dao) {
		this.dao = dao;
		return this;
	}
	
	
	
	
	@Override
	public String execute(HashMap<String, Object> map) {
		
		HttpSession session = (HttpSession)map.get("SESSION");
		
		Member account = (Member)session.getAttribute("ACCOUNT");
		
		
		int res = dao.deleteAccount(account);
		
		if(res > 0) {
			
			session.invalidate();
			
			return "redirect:../";
			
		}
		
		
		return null;
	}

}
