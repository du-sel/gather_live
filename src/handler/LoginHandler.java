package handler;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import DTO.Member;
import dao.DAO;

public class LoginHandler implements CommonHandler {

	DAO dao;
	
	public LoginHandler setDAO(DAO dao) {
		this.dao = dao;
		return this;
	}
	
	
	
	@Override
	public String execute(HashMap<String, Object> map) {
		
		HttpSession session = (HttpSession)map.get("SESSION");
		
		if(map.get("EMAIL") == null) {
			return "/code/04_login.jsp";
		}
		else {
		
			String email = (String)map.get("EMAIL");
			String pw = (String)map.get("PW");
			
			Member found = dao.getMemberByMail(email);
			
			
			// 해당 메일주소로 가입된 회원이 없을 때 
			if(found.getUser_name() == null) {
				return "referer:?error=noSuchMember";
			} else {
				
				// 회원은 있으나 비밀번호가 일치하지 않을 때 
				if(!found.getPassword().equals(pw)) {
					System.out.println("비밀번호가 일치하지 않음");
					return "referer:?error=wrongPassword";
				} else {
					
					// 로그인 성공 
					System.out.println("로그인 성공");
					session.setAttribute("ACCOUNT", found);
					return "redirect:../";
				
				}
			}
		}
	}

}
