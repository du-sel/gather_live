package handler;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import DTO.Member;
import dao.DAO;

public class ChangePWHandler implements CommonHandler {
	
	
	DAO dao;
	
	public ChangePWHandler setDAO(DAO dao) {
		this.dao = dao;
		return this;
	}
	
	

	@Override
	public String execute(HashMap<String, Object> map) {
		
		
		String pw = (String)map.get("PW");
		String pw_new = (String)map.get("PW_NEW");
		
		if(pw == null) {
			return "/code/03_my_chgPw.jsp";
		} else {
			
			HttpSession session = (HttpSession)map.get("SESSION");
			Member account = (Member)session.getAttribute("ACCOUNT");
			
			// 폼으로 들어왔는데 기존 비밀번호가 틀렸을 경우
			if(!pw.equals(account.getPassword())) {
				
				return "referer:?error=wrongPW";
				
			}
			
			
			// 정상 변경
			
			account.setPassword(pw_new);
			dao.updatePW(account);
			
			return "redirect:../my/changePW.do?msg=ok";
			
		}
		
		
		
		
	}

}
