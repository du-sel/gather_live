package handler;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

public class LogoutHandler implements CommonHandler {

	@Override
	public String execute(HashMap<String, Object> map) {
		
		HttpSession session = (HttpSession)map.get("SESSION");		
		session.invalidate();
		
		return "redirect:../";
	}

}
